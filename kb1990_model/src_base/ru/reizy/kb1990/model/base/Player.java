package ru.reizy.kb1990.model.base;

import static ru.reizy.kb1990.model.base.PasleElement.PASLE_H;
import static ru.reizy.kb1990.model.base.PasleElement.PASLE_W;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.base.artifact.Artifact;
import ru.reizy.kb1990.model.base.magic.MagicSpells;
import ru.reizy.kb1990.model.base.magic.battle.BattleMagicBook;
import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelMagicBook;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.Difficulty;
import ru.reizy.kb1990.model.globalmap.PlayerType;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.villains.Villain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Игрок - это герой, который может: - имеет имя - имеет эффекты заклинаний
 * глобальной карты - имеет магию - получает доход, арендует корабль - имеет
 * класс и ранг
 * 
 * 
 */
public class Player extends Hero {

	private static final int MAX_TEMP_MOVE_POINTS = 999;

	private static final Logger log = LoggerFactory.getLogger(Player.class);

	// имеет имя
	private final String name;
	// иметь эффекты заклинаний глобальной карты
	private int tempLeadership;
	private int tempMovePoints;
	// имеет магию
	private boolean magic;
	private int spellPower;
	private int spellCapacity;
	private TravelMagicBook travelMagicBook;
	private BattleMagicBook battleMagicBook;
	// получает доход, арендует корабль
	private int commission;
	private int boatRent = 500;
	// имеет класс и ранг
	private final PlayerType type;
	// имеет квест - пазл
	private final Set<Artifact> artifacts = new HashSet<Artifact>();
	private final Set<Villain> killedVillains = new HashSet<Villain>();

	@JsonIgnore
	private final List<Villain> aliveVillains = new ArrayList<Villain>();
	private final Set<PasleElement> pasleElements = new HashSet<PasleElement>();
	private final Set<Castle> castles = new HashSet<Castle>();
	private Villain contract;

	private int unitsKilledCount;
	private Difficulty difficulty;

	@JsonCreator
	public Player(@JsonProperty("army") UnitType[] army, @JsonProperty("armyCount") Integer[] armyCount,

	@JsonProperty("leadership") int leadership, @JsonProperty("attack") float attack, @JsonProperty("defence") float defence,
			@JsonProperty("attackSkill") float attackSkill, @JsonProperty("money") int money, @JsonProperty("rank") int rank,
			@JsonProperty("name") String name,

			@JsonProperty("tempLeadership") int tempLeadership, @JsonProperty("tempMovePoints") int tempMovePoints, @JsonProperty("spellPower") int spellPower,
			@JsonProperty("spellCapacity") int spellCapacity,

			@JsonProperty("travelMagicBook") TravelMagicBook travelMagicBook, @JsonProperty("battleMagicBook") BattleMagicBook battleMagicBook,

			@JsonProperty("commission") int commission, @JsonProperty("boatRent") int boatRent, @JsonProperty("type") PlayerType type,

			@JsonProperty("artifacts") Artifact[] artifacts,// -
			@JsonProperty("killedVillains") Villain[] killedVillains,// -

			@JsonProperty("contractCell") Cell contractCell, //
			@JsonProperty("magicActive") Boolean magicActive, //
			@JsonProperty("difficulty") Difficulty difficulty) {
		super();
		setArmy(army, armyCount);

		setLeadership(leadership);
		this.setAttack(attack);
		this.setDefence(defence);
		this.setAttackSkill(attackSkill);
		setRank(rank);
		addMoney(money - getMoney());
		this.name = name;

		this.tempLeadership = tempLeadership;
		this.tempMovePoints = tempMovePoints;
		this.spellPower = spellPower;
		this.spellCapacity = spellCapacity;

		this.travelMagicBook = travelMagicBook;
		this.battleMagicBook = battleMagicBook;

		this.commission = commission;
		this.boatRent = boatRent;
		this.type = type;

		for (int i = 0; i < killedVillains.length; i++) {
			addPasleElement(killedVillains[i]);
		}
		for (int i = 0; i < artifacts.length; i++) {
			addPasleElement(artifacts[i]);
		}
		// if (contractCell != null) {
		// this.contract = (Villain) ((Castle) (contractCell.getContent()))
		// .getHero();
		// }
		this.magic = magicActive;
		this.difficulty = difficulty;
		log.info("Player loaded!");
	}

	public Player(String name, PlayerType type, int money, Difficulty difficulty) {
		super(0, type.getLeadership()[0]);
		log.info("Player created!");
		travelMagicBook = new TravelMagicBook();
		battleMagicBook = new BattleMagicBook();
		this.name = name;
		this.type = type;
		this.spellCapacity = type.getSpellCapasity()[0];
		this.spellPower = type.getSpellPower()[0];
		this.commission = type.getCommission()[0];
		this.magic = type.isMagican();
		this.difficulty = difficulty;
		addMoney(money);
		addToArmy(UnitTypes.PEASANTS, 10);
	}

	public String getName() {
		return name;
	}

	public int getSpellPower() {
		return spellPower;
	}

	public int getSpellCapacity() {
		return spellCapacity;
	}

	public int getCommission() {
		return commission + castles.size() * 250;
	}

	public int getTempMovePoints() {
		return tempMovePoints;
	}

	public void setTempMovePoints(int tempMovePoints) {
		if (tempMovePoints > MAX_TEMP_MOVE_POINTS) {
			tempMovePoints = MAX_TEMP_MOVE_POINTS;
		}
		this.tempMovePoints = tempMovePoints;
	}

	public void setSpellCapacity(int spellCapacity) {
		this.spellCapacity = spellCapacity;
	}

	public void setSpellPower(int spellPower) {
		this.spellPower = spellPower;
	}

	public TravelMagicBook getTravelMagicBook() {
		return travelMagicBook;
	}

	public BattleMagicBook getBattleMagicBook() {
		return battleMagicBook;
	}

	public void setTempLeadership(int leadership) {
		tempLeadership = leadership;
	}

	@Override
	public int getLeadership() {
		int l = super.getLeadership();
		l += tempLeadership;
		if (l > MAX_LEADERSHIP) {
			l = MAX_LEADERSHIP;
		}
		return l;
	}

	public void setBoatRent(int boatRent) {
		this.boatRent = boatRent;
	}

	public int getBoatRent() {
		return boatRent;
	}

	public int getTempLeadership() {
		return tempLeadership;
	}

	public PlayerType getType() {
		return type;
	}

	@JsonIgnore
	public boolean isArmyFull() {
		return getArmy().size() >= ARMY_MAX_SIZE;
	}

	@JsonIgnore
	public int getArmyFreeCount() {
		return ARMY_MAX_SIZE - getArmy().size();
	}

	public void addToArmy(UnitTypes type) {
		addToArmy(type, getLeadership() / type.getUnitType().getMaxHitPoints());
	}

	public boolean isOutOfControl(int i) {
		UnitType type = getArmy().get(i);
		int max = getLeadership() / type.getMaxHitPoints();
		return getArmyCount().get(i) > max;
	}

	public void addSpell(MagicSpells spell) {
		if (spell instanceof TravelSpells) {
			travelMagicBook.addSpell((TravelSpells) spell);
		} else if (spell instanceof BattleSpells) {
			battleMagicBook.addSpell((BattleSpells) spell);
		} else {
			throw new IllegalArgumentException("Заклинание неизвестного типа");
		}
	}

	public void useMagic(MagicSpells spell) {
		if (spell instanceof TravelSpells) {
			travelMagicBook.reduse((TravelSpells) spell);
		} else if (spell instanceof BattleSpells) {
			battleMagicBook.reduse((BattleSpells) spell);
		} else {
			throw new IllegalArgumentException("Заклинание неизвестного типа");
		}
	}

	public void setMagicActive(boolean active) {
		magic = active;
	}

	public boolean isMagicActive() {
		return magic;
	}

	@JsonIgnore
	public boolean[][] getPasleMask() {
		boolean[][] b = new boolean[PASLE_W][PASLE_H];
		for (PasleElement pasleElement : pasleElements) {
			int x = pasleElement.getPasleX();
			int y = pasleElement.getPasleY();
			b[x][y] = true;
		}
		// for (int i = 0; i < PASLE_W * PASLE_H; i++)
		// b[i % PASLE_W][i / PASLE_W] = true;

		return b;
	}

	public void addPasleElement(PasleElement pasleElement) {
		if (pasleElement != null) {
			pasleElements.add(pasleElement);
			if (pasleElement instanceof Artifact) {
				addArtifact((Artifact) pasleElement);
			}
			if (pasleElement instanceof Villain) {
				killVillian((Villain) pasleElement);
			}
			log.info("Добавлен пазл {}", pasleElement);
		}
	}

	@JsonIgnore
	public Villain getContract() {
		final Villain c;
		if (killedVillains.contains(contract)) {
			c = null;
		} else {
			c = contract;
		}
		return c;
	}

	@JsonProperty("contractCell")
	private Cell getContractCell() {
		Cell cell = null;
		if (contract != null) {
			final Castle castle = contract.getCastle();
			if (castle != null) {
				cell = castle.getCell();
			}
		}
		return cell;
	}

	private void addArtifact(Artifact artifact) {
		if (artifact != null) {
			artifacts.add(artifact);
		}
	}

	private void killVillian(Villain villain) {
		if (villain != null) {
			villain.clear();
			killedVillains.add(villain);
			aliveVillains.remove(villain);
		}
	}

	public Set<Artifact> getArtifacts() {
		return Collections.unmodifiableSet(artifacts);
	}

	public Set<Villain> getKilledVillains() {
		return Collections.unmodifiableSet(killedVillains);
	}

	@JsonIgnore
	public List<Villain> getAliveVillains() {
		return Collections.unmodifiableList(aliveVillains);
	}



	public void setContract(Villain contract) {
		this.contract = contract;
	}

	public void setAliveVillains(List<Villain> init) {
		this.aliveVillains.clear();
		this.aliveVillains.addAll(init);
	}

	public boolean canLevelUp() {
		boolean up = false;
		int r = getRank() + 1;
		if ((r) < (type.getXp().length)) {
			int xp = type.getXp()[r];
			if (xp <= getKilledVillains().size()) {
				up = true;
			}
		}
		return up;
	}

	public boolean levelUp() {
		final boolean up = canLevelUp();
		if (up) {
			int r = getRank() + 1;
			setRank(r);
			spellCapacity += type.getSpellCapasity()[r];
			spellPower += type.getSpellPower()[r];
			addCommission(type.getCommission()[r]);
			addLeadership(type.getLeadership()[r]);
		}
		return up;
	}

	public void addLeadership(int i) {
		setLeadership(getLeadership() + i);

	}

	public void addCommission(int i) {
		commission += i;
	}

	public void addAliveVillain(Villain villain) {
		aliveVillains.add(villain);
		Collections.sort(aliveVillains);
	}

	@JsonIgnore
	public int getSpellsCount() {
		return travelMagicBook.getSpellsCount() + battleMagicBook.getSpellsCount();
	}

	public void switchInArmy(int id1, int id2) {
		UnitType unit1 = getArmy(id1);
		UnitType unit2 = getArmy(id2);
		if ((unit1 != null) && (unit2 != null)) {
			int count1 = getArmyCount(id1);
			int count2 = getArmyCount(id2);
			getArmy().set(id1, unit2);
			getArmyCount().set(id1, count2);
			getArmy().set(id2, unit1);
			getArmyCount().set(id2, count1);
		}
	}

	public void addCastle(Castle castle) {
		castles.add(castle);
	}

	public void removeCastle(Castle castle) {
		castles.remove(castle);
	}

	public Set<Castle> getCastles() {
		return castles;
	}

	public int getUnitsKilledCount() {
		return unitsKilledCount;
	}

	public void addUnitsKilledCount(int k) {
		unitsKilledCount += k;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	@JsonIgnore
	public int getScore() {
		float k = 0;
		k += 250 * artifacts.size();
		k += 500 * killedVillains.size();
		k += 100 * castles.size();
		k -= unitsKilledCount;
		k *= difficulty.getScoreMultiplier();
		return (int) k;
	}

}
