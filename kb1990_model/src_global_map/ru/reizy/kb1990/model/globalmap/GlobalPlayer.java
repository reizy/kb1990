package ru.reizy.kb1990.model.globalmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.GlobalPlayerI;
import ru.reizy.kb1990.KBModelI;
import ru.reizy.kb1990.model.base.ArmyHolder;
import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.base.magic.MagicSpells;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.FlyingUnit;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.events.BattleFailEvent;
import ru.reizy.kb1990.model.globalmap.events.BattleWinEvent;
import ru.reizy.kb1990.model.globalmap.events.BuyMagicEvent;
import ru.reizy.kb1990.model.globalmap.events.BuyUnitEvent;
import ru.reizy.kb1990.model.globalmap.events.CastleActionEvent;
import ru.reizy.kb1990.model.globalmap.events.GameOverEvent;
import ru.reizy.kb1990.model.globalmap.events.GlobalPlayerMoveEvent;
import ru.reizy.kb1990.model.globalmap.events.RemoveUnitEvent;
import ru.reizy.kb1990.model.globalmap.events.ResidenceOutEvent;
import ru.reizy.kb1990.model.globalmap.events.ShowContractEvent;
import ru.reizy.kb1990.model.globalmap.events.TownActionEvent;
import ru.reizy.kb1990.model.globalmap.events.WeekEndEvent;
import ru.reizy.kb1990.model.globalmap.magic.TravelMagicBook;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.residence.KingCastle;
import ru.reizy.kb1990.model.globalmap.residence.Residence;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence.BuyStatus;
import ru.reizy.kb1990.model.globalmap.residence.Town;
import ru.reizy.kb1990.model.globalmap.villains.Villain;

public class GlobalPlayer extends GlobalHero implements GlobalPlayerI {
	private static final Logger log = LoggerFactory.getLogger(GlobalPlayer.class);

	private static final int MAX_AVAIBLE_CONTRACTS = 5;
	static final int VIEW_WIDTH = 5;
	static final int VIEW_HEIGHT = 5;

	public static final int PRICE_SIEGE = 3000;
	public static final int PRICE_MAGIC = 5000;
	private static final int TURNS_IN_DAY = 40;
	private static final int DAYS_IN_WEEK = 5;

	private final KBModelI model;

	private Player player;
	private final Ship ship;
	private final TravelMagicBook book;
	private final List<GlobalMap> maps = new ArrayList<GlobalMap>();
	private final Map<Integer, GlobalMap> openedMaps = new HashMap<Integer, GlobalMap>();
	private final Map<Integer, GlobalMap> fullMaps = new HashMap<Integer, GlobalMap>();
	private final Map<Integer, boolean[][]> unhidden = new HashMap<Integer, boolean[][]>();

	private final Set<Town> avaibleTowns = new HashSet<Town>();
	private final Set<Castle> avaibleCastles = new HashSet<Castle>();
	private Cell activeContentCell;
	private Cell pasleAimCell;
	private int time;
	private int contractIndex = 0;
	private boolean siegeWeapon;
	private int maxWeek;

	private final Map<Villain, Integer> villainsCastlesCheck = new HashMap<Villain, Integer>();

	private boolean fly;

	private int brigeMaker;

	public GlobalPlayer(KBModelI model, Player player) {
		super(player);
		this.player = player;
		this.model = model;
		this.ship = new Ship(null);
		this.book = new TravelMagicBook(this);
		this.time = player.getDifficulty().getDays() * TURNS_IN_DAY;
		this.maxWeek = getWeek();
	}

	public void onEvent(KBEvent event) {
		model.onEvent(event);
	}

	public Player getHero() {
		return player;
	}

	public Ship getShip() {
		return ship;
	}

	public void placeShip(Cell shipCell) {
		this.ship.setCell(shipCell);
	}

	public boolean inShip() {
		boolean b = (getCell() == ship.getCell()) && (!isFlying());
		return b;
	}

	public TravelMagicBook getBook() {
		return book;
	}

	public int getDays() {
		return 1 + ((time - 1) / TURNS_IN_DAY);
	}

	public int getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public void goTo(Cell cell, FieldType f) {
		goTo(cell);
		int w = getWeek();
		if ((!isFlying()) && (FieldType.SANDS.contains(f))) {
			player.setTempMovePoints(0);
			time -= TURNS_IN_DAY;
		} else {
			int tmp = player.getTempMovePoints();
			if (tmp > 0) {
				player.setTempMovePoints(tmp - 1);
			} else {
				time--;
			}
		}
		if (w > getWeek()) {
			onFinishWeek();
		}
	}

	@Override
	public void goTo(Cell cell) {
		this.setCell(cell);
		if (cell != null) {
			setActiveContentCell(cell);
		}
		unhideMap();
	}

	private int getWeek() {
		return (time - 1) / (TURNS_IN_DAY * DAYS_IN_WEEK);

	}

	public void finishWeek() {
		player.setTempMovePoints(0);
		player.setTempLeadership(0);
		time--;
		time -= time % (TURNS_IN_DAY * DAYS_IN_WEEK);
		onFinishWeek();
	}

	private void onFinishWeek() {
		if (time > 0) {
			// выбираем символ недели и заселяем резиденции
			UnitTypes unit = UnitTypes.getRandom();

			for (GlobalMap map : getMaps()) {
				for (Residence r : map.getResidences().values()) {
					SimpleUnitResidence sur = (SimpleUnitResidence) r;
					if (sur.getUnit() == unit) {
						sur.refresh();
					}
				}
				Integer count = UnitCounts.A[0].get(unit);
				count = (count == null) ? 1 : count;
				for (Castle holder : map.getCastles()) {
					if (holder != null) {
						incArmyOnWeekend(holder.getArmyHolder(), unit, count);
					}
				}
				for (GlobalHero holder : map.getHeroes().values()) {
					if (holder != null) {
						incArmyOnWeekend(holder.getHero(), unit, count);
					}
				}
			}

			// считаем бюджет
			int weekNum = maxWeek - getWeek();
			int commision = player.getCommission();
			int moneyBefore = player.getMoney();
			int boatRent = (getShip().getCell() == null) ? 0 : getHero().getBoatRent();
			List<Integer> unitsCost = new ArrayList<Integer>();
			List<UnitTypes> units = new ArrayList<UnitTypes>();
			int armyCost = 0;
			for (int i = 0; i < getHero().getArmy().size(); i++) {
				int wc = getHero().getArmyCount(i) * getHero().getArmy(i).getWeekCost();

				int x = moneyBefore + commision - boatRent - armyCost;
				units.add(UnitTypes.get(getHero().getArmy(i)));
				if (x < wc) {
					wc = 0;
					getHero().removeFromArmy(i);
					i--;
				}
				armyCost += wc;
				unitsCost.add(wc);

			}

			player.addMoney(commision);
			player.addMoney(-armyCost);
			player.addMoney(-boatRent);
			int moneyAfter = player.getMoney();
			// заселяем пустые замки и добавляем юниты в текущие гарнизоны
			Set<Castle> emptyCastles=new HashSet<Castle>();
			for (Castle castle : getHero().getCastles()) {
				if (castle.getArmy().isEmpty()) {
					emptyCastles.add(castle);
				}
			}
			for (Castle castle : emptyCastles) {				
					getHero().removeCastle(castle);
					castle.setHero(castle.getCell().getMap().generateEnemy(GlobalMap.CASTLE_ENEMY_ARMY_SIZE));				
			}
			// обновляем представление
			KBEvent event = new WeekEndEvent(unit, moneyBefore, commision, boatRent, armyCost, moneyAfter, weekNum, units, unitsCost);
			onEvent(event);
			log.warn("Week ends.");
		} else {
			// игра закончена
			KBEvent event = new GameOverEvent();
			onEvent(event);
		}
	}

	private void incArmyOnWeekend(ArmyHolder holder, UnitTypes unit, int count) {
		if (holder != null) {
			for (int i = 0; i < holder.getArmy().size(); i++) {
				UnitType unitTypes = holder.getArmy().get(i);
				if (UnitTypes.get(unitTypes) == unit) {
					holder.addToArmy(unit, count);
				}
			}
		}
	}

	public void openMap(GlobalMap map) {
		openedMaps.put(map.getId(), map);
	}

	public Map<Integer, GlobalMap> getOpenedMaps() {
		return openedMaps;
	}

	public GlobalMap getActiveMap() {
		GlobalMap map = null;
		if (getCell() != null) {
			map = getCell().getMap();
		}
		return map;
	}

	public void buyUnit(int count) {
		Cell activeContentCell = getActiveContent().getCell();
		if (activeContentCell != null) {
			if (activeContentCell.getContent() instanceof KingCastle) {
				final KingCastle ur = (KingCastle) activeContentCell.getContent();
				final Player p = getHero();
				onEvent(new BuyUnitEvent(ur, count, ur.buy(p, count)));
			} else if (activeContentCell.getContent() instanceof SimpleUnitResidence) {
				final SimpleUnitResidence ur = (SimpleUnitResidence) activeContentCell.getContent();
				final Player p = getHero();
				BuyStatus buyStatus = ur.buy(p, count);
				BuyUnitEvent event = new BuyUnitEvent(ur, count, buyStatus);
				onEvent(event);
			} else {
				log.error("Вы не в поселении воинов");
			}
		} else {
			log.error("Вы не в поселении");
		}

	}

	public boolean buySpell() {
		boolean b = false;
		if (getActiveTown() != null) {
			MagicSpells spell = getActiveTown().getSpell();
			if (getHero().getMoney() >= spell.getCost()) {
				if (getHero().getSpellCapacity() >= getHero().getSpellsCount()) {
					getHero().addMoney(-spell.getCost());
					getHero().addSpell(spell);
					b = true;
				}
			}
			KBEvent event = new TownActionEvent(getActiveTown());
			onEvent(event);

		}
		return b;
	}

	public GlobalHero getActiveEnemy() {
		if (getActiveContent() instanceof GlobalHero) {
			return (GlobalHero) getActiveContent();
		} else {
			return null;
		}
	}

	public SimpleUnitResidence getActiveResidence() {
		if (getActiveContent() instanceof SimpleUnitResidence) {
			return (SimpleUnitResidence) getActiveContent();
		} else {
			return null;
		}
	}

	public Town getActiveTown() {
		if (getActiveContent() instanceof Town) {
			return (Town) getActiveContent();
		} else {
			return null;
		}
	}

	public Castle getActiveCastle() {
		if (getActiveContent() instanceof Castle) {
			return (Castle) getActiveContent();
		} else {
			return null;
		}
	}

	public KingCastle getActiveKingCastle() {
		if (getActiveContent() instanceof KingCastle) {
			return (KingCastle) getActiveContent();
		} else {
			return null;
		}
	}

	private Content getActiveContent() {
		Content content = null;
		if (activeContentCell != null) {
			content = activeContentCell.getContent();
		}
		return content;
	}

	@Override
	public void onBattleFail(Hero enemy) {
		getHero().addToArmy(UnitTypes.PEASANTS, 10);
		maps.get(0).goTo(11, 5);
		getActiveMap().onEvent(new BattleFailEvent(enemy));
	}

	@Override
	public void onBattleWin(Hero enemy) {
		// получаем золото за победу
		getHero().addMoney(enemy.getMoney());
		Cell cell = activeContentCell;
		getActiveMap().goTo(cell.getX(), cell.getY());
		getActiveMap().onEvent(new BattleWinEvent(enemy));
	}

	public void buyShip() {
		log.info("Buy ship action");
		if (getShip().getCell() == null) {
			if (getHero().getMoney() >= getHero().getBoatRent()) {
				getHero().addMoney(-getHero().getBoatRent());
				Cell shipCell = getActiveTown().getShipCell();
				log.info("Summon ship at " + getActiveTown().getName() + " on " + shipCell);
				getShip().setCell(shipCell);
			}
		} else {
			getShip().setCell(null);
		}
		KBEvent event = new TownActionEvent(getActiveTown());
		onEvent(event);
	}

	public Villain getContract() {
		return player.getContract();
	}

	public boolean hasSeigeWeapon() {
		return siegeWeapon;
	}

	public boolean buySiegeWeapon() {
		boolean b = false;
		if (!hasSeigeWeapon()) {
			if (getHero().getMoney() >= PRICE_SIEGE) {
				getHero().addMoney(-PRICE_SIEGE);
				siegeWeapon = true;
				b = true;
			}
		}
		KBEvent event = new TownActionEvent(getActiveTown());
		onEvent(event);

		return b;
	}

	public boolean buyMagic() {
		boolean b = false;
		if (getHero().getMoney() >= PRICE_MAGIC) {
			getHero().addMoney(-PRICE_MAGIC);
			getHero().setMagicActive(true);
			b = true;
		}
		KBEvent event = new BuyMagicEvent(this, null);
		onEvent(event);
		return b;
	}

	public void nextContract() {
		final List<Villain> aliveVillains = player.getAliveVillains();
		if (aliveVillains.size() == 0) {
			contractIndex = 0;
			player.setContract(null);
		} else if (contractIndex >= aliveVillains.size()) {
			contractIndex = 0;
			player.setContract(aliveVillains.get(contractIndex));
		} else {
			if (aliveVillains.get(contractIndex) == getContract()) {
				contractIndex = ++contractIndex < MAX_AVAIBLE_CONTRACTS //
				? contractIndex < aliveVillains.size() ? contractIndex : 0
						: 0;
			}
			player.setContract(aliveVillains.get(contractIndex));
			if (getContract() == null) {
				contractIndex = 0;
				player.setContract(aliveVillains.get(contractIndex));
			}
		}
		KBEvent event = new ShowContractEvent();
		onEvent(event);
	}

	public boolean hasFullMap(GlobalMap map) {
		return (fullMaps.get(map.getId()) != null);
	}

	public void addFullMap(GlobalMap map) {
		fullMaps.put(map.getId(), map);
	}

	public void garnisonUnit(int id, boolean fromHeroToGarnison) {
		final Castle castle = getActiveCastle();
		if (castle != null) {
			final ArmyHolder to;
			final ArmyHolder from;

			if (fromHeroToGarnison) {
				from = getHero();
				to = castle.getArmyHolder();
			} else {
				to = getHero();
				from = castle.getArmyHolder();
			}

			// если принимающая армия имеет свободные слоты
			if (to.getArmy().size() < ArmyHolder.ARMY_MAX_SIZE) {
				// если индекс не ошибочный
				if (from.getArmy(id) != null) {
					boolean b = true;
					// вычесть деньги у героя на содержание ганризона
					if (fromHeroToGarnison) {
						int cost = from.getArmy(id).getWeekCost() * from.getArmyCount(id);
						b = (player.getMoney() >= cost);
						if (b) {
							player.addMoney(-cost);
						}
					}
					// собственно передача отряда
					if (b) {
						to.addToArmy(from.getArmy(id), from.getArmyCount(id));
						from.removeFromArmy(id);
					}
				}
			}
			KBEvent event = new CastleActionEvent(castle);
			onEvent(event);
		} else {
			log.error("вы не в замке");
		}
	}

	public ArmyHolder createGarnison() {
		return new ArmyHolder();
	}

	public Cell getPasleAimCell() {
		return pasleAimCell;
	}

	public void init(GlobalMap... map) {

		this.maps.addAll(Arrays.asList(map));
		this.openMap(map[0]);

		this.player.setAliveVillains(Villain.init(map));
		for (int i = 0; i < map.length; i++) {
			int fieldWidth = map[i].getFieldWidth();
			int fieldHeight = map[i].getFieldHeight();
			boolean[][] m = new boolean[fieldWidth][fieldHeight];
			unhidden.put(map[i].getId(), m);
		}
		// генерация победной точки
		List<Cell> grass = new LinkedList<Cell>();
		for (int i = 0; i < map.length; i++) {
			grass.addAll(map[i].getCellsByFieldType(FieldType.GRASS));
		}

		Collections.shuffle(grass);
		pasleAimCell = grass.get(0);
	}

	public Castle getContractersCastle() {
		final Villain villain = player.getContract();
		Castle castle = null;
		Integer r = villainsCastlesCheck.get(villain);
		r = (r == null) ? 0 : r;
		if (r >= villain.getRelocations()) {
			castle = villain.getCastle();
		}
		log.info("check r={} vr={}", r, villain.getRelocations());
		return castle;
	}

	public void checkCastle(Castle castle) {
		checkCastleInfo(castle);
		avaibleCastles.add(castle);
	}

	public void checkCastleInfo(Castle castle) {
		Hero hero = castle.getHero();
		if ((hero != null) && (hero instanceof Villain)) {

			Villain villain = (Villain) hero;
			villainsCastlesCheck.put(villain, villain.getRelocations());
			log.warn("put vr={}", villain.getRelocations());

		}
	}

	public void checkTown(Town town) {
		avaibleTowns.add(town);
	}

	public Set<Town> getAvaibleTowns() {
		return Collections.unmodifiableSet(avaibleTowns);
	}

	public Set<Castle> getAvaibleCastles() {
		return Collections.unmodifiableSet(avaibleCastles);
	}

	public boolean isFlying() {
		return fly;
	}

	public void tryFly() {
		fly = canFly();
		KBEvent event = new GlobalPlayerMoveEvent();
		onEvent(event);
	}

	public void tryLand() {
		if (canLand()) {
			fly = false;
			KBEvent event = new GlobalPlayerMoveEvent();
			onEvent(event);
		}
	}

	public List<GlobalMap> getMaps() {
		return maps;
	}

	public boolean canFly() {
		boolean b = true;
		for (UnitType unit : getHero().getArmy()) {
			b = b && (unit instanceof FlyingUnit) && (unit.getSkill() > 1);
		}
		return b;
	}

	public boolean canLand() {
		final FieldType f = getCell().getFieldType();
		return (f == FieldType.GRASS);
	}

	public Map<Integer, GlobalMap> getFullMaps() {
		return fullMaps;
	}

	public void goOut() {
		Object activeContent = getActiveContent();
		if (activeContent != null) {
			Residence residence = (Residence) activeContent;
			getActiveMap().goTo(residence.getOutCell());
			KBEvent event = new ResidenceOutEvent(residence);
			setActiveContentCell(null);
			onEvent(event);
		} else {
			log.error("Вы не в поселении");
		}
	}

	public void setActiveContentCell(Cell cell) {
		activeContentCell = cell;
	}

	public void setSiegeWeapon(boolean siegeWeapon) {
		this.siegeWeapon = siegeWeapon;

	}

	public void clear() {
		goTo(null);
		avaibleCastles.clear();
		avaibleTowns.clear();
		openedMaps.clear();
		fullMaps.clear();
		setActiveContentCell(null);
	}

	public void load(Cell cell, Cell shipCell, Cell pasleAimCell, int time, int maxWeek, boolean fly, boolean siegeWeapon, Cell[] avaibleCastlesCells,
			Cell[] avaibleTownsCells, int[] openedMaps, int[] fullMaps, Map<Integer, boolean[][]> unhidden2) {
		setCell(cell);
		this.ship.setCell(shipCell);
		this.pasleAimCell = pasleAimCell;
		this.time = time;
		this.maxWeek = maxWeek;
		this.fly = fly;
		this.siegeWeapon = siegeWeapon;

		for (int i = 0; i < avaibleCastlesCells.length; i++) {
			Castle castle = (Castle) avaibleCastlesCells[i].getContent();
			checkCastle(castle);
		}
		for (int i = 0; i < avaibleTownsCells.length; i++) {
			Town town = (Town) avaibleTownsCells[i].getContent();
			checkTown(town);
		}
		for (int i = 0; i < fullMaps.length; i++) {
			addFullMap(maps.get(fullMaps[i]));
		}
		for (int i = 0; i < openedMaps.length; i++) {
			this.openMap(maps.get(openedMaps[i]));
		}
		for (Entry<Integer, boolean[][]> entry : unhidden2.entrySet()) {
			final Integer key = entry.getKey();
			final boolean[][] value = entry.getValue();
			unhidden.put(key, value);
		}
	}

	public int getMaxWeek() {
		return maxWeek;
	}

	public void setPlayer(Player p) {
		player = p;
	}

	public boolean[][] getUnhidden() {
		return unhidden.get(getActiveMap().getId());
	}

	public Map<Integer, boolean[][]> getUnhiddens() {
		return unhidden;
	}

	private void unhideMap() {
		final Cell cell = getCell();
		if (cell != null) {
			int xx = cell.getX();
			int yy = cell.getY();
			GlobalMap map = getActiveMap();
			for (int i = 0; i < VIEW_WIDTH; i++) {
				for (int j = 0; j < VIEW_HEIGHT; j++) {
					int x = xx - VIEW_WIDTH / 2 + i;
					int y = yy - VIEW_HEIGHT / 2 + j;
					if ((x >= 0) && (y >= 0) && (x < map.getFieldWidth()) && (y < map.getFieldHeight())) {
						getUnhidden()[x][y] = true;
					}
				}
			}
		}
	}

	public void removeFromArmy(int id) {
		if (player.getArmy().size() > 1) {
			UnitType unit = player.getArmy(id);
			int count = player.getArmyCount(id);
			player.removeFromArmy(id);
			KBEvent event = new RemoveUnitEvent(unit, count);
			onEvent(event);
		}
	}

	/**
	 * @return the brigeMakerActive
	 */
	public int getBrigeMaker() {
		return brigeMaker;
	}

	public void setBrigeMaker(int i) {
		brigeMaker = i;
	}

}
