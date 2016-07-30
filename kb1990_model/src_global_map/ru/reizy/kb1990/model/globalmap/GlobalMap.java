package ru.reizy.kb1990.model.globalmap;

import static ru.reizy.kb1990.model.globalmap.GlobalPlayer.VIEW_HEIGHT;
import static ru.reizy.kb1990.model.globalmap.GlobalPlayer.VIEW_WIDTH;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.BattleModelI;
import ru.reizy.kb1990.GlobalMapI;
import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.events.BrigeBuiltEvent;
import ru.reizy.kb1990.model.globalmap.events.BuyMagicEvent;
import ru.reizy.kb1990.model.globalmap.events.GlobalPlayerMoveEvent;
import ru.reizy.kb1990.model.globalmap.events.TravelSpellActivatinoEvent;
import ru.reizy.kb1990.model.globalmap.magic.Bridge;
import ru.reizy.kb1990.model.globalmap.magic.TravelMagicBook;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.residence.KingCastle;
import ru.reizy.kb1990.model.globalmap.residence.Residence;
import ru.reizy.kb1990.model.globalmap.residence.SignPost;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence;
import ru.reizy.kb1990.model.globalmap.residence.Town;
import ru.reizy.kb1990.model.globalmap.treasure.ArtifactTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.FullMapTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.GoldTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.NextMapTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.RandomSpellTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.RandomUnitTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.RichMineralDepositsTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.SpellCapacityIncreasesTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.SpellPowerIncreasesTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.Treasure;

public class GlobalMap implements GlobalMapI {
	private static final UnitTypes DEFAULT_UNIT = UnitTypes.PEASANTS;
	private static final int REMEMBERED_UNITS_COUNT = 3;
	private static final Logger log = LoggerFactory.getLogger(GlobalMap.class);
	public static final int SIMPLE_ENEMY_ARMY_SIZE = 3;
	public static final int CASTLE_ENEMY_ARMY_SIZE = 5;
	private static final int UNIT_SPREADING = 2;
	private static final double BONUS_PROBABILITY_TREASURE = 0.65;
	private final static int FIELD_WIDTH = 64;
	private final static int FIELD_HEIGHT = FIELD_WIDTH;
	private final int power;
	private int id;
	private final KBModelGlobalI model;

	private int fieldHeight = FIELD_HEIGHT;
	private int fieldWidth = FIELD_WIDTH;
	private FieldType[][] bgField;
	private Cell[][] map;
	private Cell inputCell;
	private GlobalMap nextMap;

	private final Set<Cell> towns = new TreeSet<Cell>();
	private final Set<Cell> castles = new TreeSet<Cell>();
	public Cell nextMapTreasureCell;

	public GlobalMap(KBModelGlobalI model, int power, GlobalPlayer player) {
		super();
		this.model = model;
		this.id = power;
		this.power = power;
	}

	public int getFieldHeight() {
		return fieldHeight;
	}

	public int getFieldWidth() {
		return fieldWidth;
	}

	public Cell firstLoad(InputStream name) {
		Cell startCell = firstLoad(new InputStreamReader(name));
		return startCell;
	}

	public Cell firstLoad(String name) {
		Cell startCell = null;
		final File f = new File(name);
		if (f.exists()) {
			try {
				startCell = firstLoad(new FileReader(f));
			} catch (FileNotFoundException e) {
				log.error("Map file not found!");
				e.printStackTrace();
			}
		}
		return startCell;
	}

	public Cell firstLoad(Reader in) {
		Cell startCell = null;
		final Map<Cell, String> townsNames = new HashMap<Cell, String>();
		final Map<Cell, Cell> townsCastles = new HashMap<Cell, Cell>();
		final Map<Cell, String> signPostsTexts = new HashMap<Cell, String>();
		final Map<Cell, String> castlesNames = new HashMap<Cell, String>();
		final Set<Cell> enemies = new TreeSet<Cell>();
		final Set<Cell> treashures = new TreeSet<Cell>();
		final Set<Cell> residences = new TreeSet<Cell>();
		final Set<Cell> signPosts = new TreeSet<Cell>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(in);
			int x = Integer.parseInt(reader.readLine());
			int y = Integer.parseInt(reader.readLine());
			init(x, y);
			for (int i = 0; i < fieldHeight; i++) {
				for (int j = 0; j < fieldWidth; j++) {
					int id = reader.read();
					if (id < 0) {
						id = 1;
					}
					FieldType tmp = FieldType.values()[id];
					if (FieldType.ACTIVE.contains(tmp)) {
						switch (tmp) {
						case ENEMY:
							enemies.add(map[i][j]);
							tmp = FieldType.GRASS;
							break;
						case BONUS:
							if (Math.random() < BONUS_PROBABILITY_TREASURE) {
								treashures.add(map[i][j]);
							} else {
								residences.add(map[i][j]);
							}
							tmp = FieldType.GRASS;
							break;
						case TOWN:
							towns.add(map[i][j]);
							break;
						case CASTLE_B:
							castles.add(map[i][j]);
							break;
						case SIGNPOST:
							signPosts.add(map[i][j]);
							break;
						case SHIP:
							inputCell = map[i][j];
							tmp = FieldType.POOL_O;
							break;
						case PLAYER:
							startCell = map[i][j];
							tmp = FieldType.GRASS;
							break;
						default:
							break;
						}
					}
					bgField[i][j] = tmp;
				}
			}

			if (treashures.size() < 4)// если получилось мало сундуков
			{
				final ArrayList<Cell> r = new ArrayList<Cell>(residences);
				Collections.shuffle(r);
				for (int i = 0; i < 4 - treashures.size(); i++) {
					Cell c = r.get(i);
					residences.remove(c);
					treashures.add(c);
					bgField[c.getX()][c.getY()] = FieldType.GRASS;
				}
			}

			loadCastles(reader, castlesNames);
			loadTowns(reader, townsNames, townsCastles);
			loadSignPosts(reader, signPostsTexts);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// castlesNames.put(map[11][07], "King Maximus");//

		generateEnemies(enemies);
		generateTreasures(treashures);
		generateResidences(residences);
		createCastles(castles, castlesNames);
		createTowns(towns, townsNames, townsCastles);
		createSignPosts(signPosts, signPostsTexts);

		return startCell;
	}

	private void loadCastles(BufferedReader br, Map<Cell, String> castlesNames) throws IOException {
		final String line = br.readLine() + br.readLine();
		if (line != null) {
			int size = Integer.parseInt(line);
			for (int i = 0; i < size; i++) {
				int x = Integer.parseInt(br.readLine());
				int y = Integer.parseInt(br.readLine());
				String name = br.readLine();
				castlesNames.put(map[x][y], name);
			}
		}
	}

	private void loadSignPosts(BufferedReader br, Map<Cell, String> signPostsTexts) throws IOException {
		final String line = br.readLine() + br.readLine();
		if (line != null) {
			int size = Integer.parseInt(line);
			for (int i = 0; i < size; i++) {
				int x = Integer.parseInt(br.readLine());
				int y = Integer.parseInt(br.readLine());
				String text = br.readLine();
				signPostsTexts.put(map[x][y], text);
			}
		}
	}

	void loadTowns(BufferedReader br, Map<Cell, String> townsNames, Map<Cell, Cell> townsCastles) throws IOException {
		br.readLine();
		final String line = br.readLine();
		if (line != null) {
			int size = Integer.parseInt(line);
			for (int i = 0; i < size; i++) {
				int x = Integer.parseInt(br.readLine());
				int y = Integer.parseInt(br.readLine());
				String name = br.readLine();
				int cx = Integer.parseInt(br.readLine());
				int cy = Integer.parseInt(br.readLine());
				townsNames.put(map[x][y], name);
				townsCastles.put(map[x][y], map[cx][cy]);
			}
		}
	}

	private void init(int x, int y) {
		fieldHeight = y;
		fieldWidth = x;
		map = new Cell[fieldWidth][fieldHeight];
		bgField = new FieldType[fieldWidth][fieldHeight];
		for (int i = 0; i < fieldWidth; i++) {
			for (int j = 0; j < fieldHeight; j++) {
				bgField[i][j] = FieldType.POOL_O;
				map[i][j] = new Cell(i, j, this);
			}
		}
	}

	private void createCastles(Set<Cell> castles, Map<Cell, String> castleNames) {

		for (Cell e : castles) {
			Residence r = null;
			if (e == map[11][7]) {
				r = new KingCastle(e, castleNames.get(e));
			} else {
				final Castle castle = new Castle(e, castleNames.get(e));
				castle.setHero(generateEnemy(CASTLE_ENEMY_ARMY_SIZE));
				r = castle;
			}
			r.setOutCell(getCell(e.getX(), e.getY() - 1));
		}
		castles.remove(map[11][7]);
	}

	private void createTowns(Set<Cell> towns, Map<Cell, String> townNames, Map<Cell, Cell> townsCastles) {
		for (Cell e : towns) {
			Cell castleCell = townsCastles.get(e);
			Castle castle = null;
			if (castleCell != null) {
				castle = (Castle) castleCell.getContent();
			}
			new Town(e, townNames.get(e), castle);
		}
	}

	private void createSignPosts(Set<Cell> signPosts, Map<Cell, String> signPostsTexts) {
		for (Cell e : signPosts) {
			new SignPost(e, signPostsTexts.get(e));
		}
	}

	private void generateTreasures(Set<Cell> treashures) {
		// generate positions of special items
		ArrayList<Integer> p = new ArrayList<Integer>();
		for (int i = 0; i < treashures.size(); i++) {
			p.add(i);
		}
		Collections.shuffle(p);

		int fmt = p.get(0);
		int nmt = p.get(1);
		int art1 = p.get(2);
		int art2 = p.get(3);

		int y = 0;
		for (Cell e : treashures) {
			Treasure x = null;
			// обязательные бонусы
			if (y == fmt) {
				x = new FullMapTreasure(e);
			} else if (y == nmt) {
				x = new NextMapTreasure(e);
				nextMapTreasureCell = e;
			} else if (y == art1) {
				x = new ArtifactTreasure(e, power * 2);
			} else if (y == art2) {
				x = new ArtifactTreasure(e, power * 2 + 1);
			} else {
				// случайные бонусы
				int i = (int) (Math.random() * 8);
				// i = 4;
				switch (i) {
				case 2:
					x = new RandomSpellTreasure(power, e);
					break;
				case 3:
					x = new RichMineralDepositsTreasure(power, e);
					break;
				case 4:
					x = new SpellCapacityIncreasesTreasure(power, e);
					break;
				case 5:
					x = new SpellPowerIncreasesTreasure(power, e);
					break;
				case 6:
					Set<UnitTypes> set = new HashSet<UnitTypes>(UnitCounts.A[power].keySet());
					UnitTypes u = generateUnit(set, UNIT_SPREADING, null);
					x = new RandomUnitTreasure(power, e, u);
					break;
				default:
					x = new GoldTreasure(power, e);
					break;
				}
			}
			y++;
			log.info("Generated treasure on " + e + ": " + x.getClass().getSimpleName());
		}
	}

	private void generateResidences(Set<Cell> residences) {
		UnitTypes[] set = UnitCounts.R.keySet().toArray(new UnitTypes[0]);
		List<UnitTypes> prev = new LinkedList<UnitTypes>();
		for (Cell e : residences) {
			UnitTypes t = generateUnit(set, 3, prev);
			log.debug("generateResidences: " + e + " - " + t + " " + prev);
			prev.add(t);
			if (prev.size() > REMEMBERED_UNITS_COUNT) {
				prev.remove(0);
			}
			new SimpleUnitResidence(t, e);
		}
	}

	private UnitTypes generateUnit(Set<UnitTypes> set, int spreading, List<UnitTypes> exclude) {
		return generateUnit(set.toArray(new UnitTypes[0]), spreading, exclude);
	}

	// чем больше spreading, тем меньше разброс
	private UnitTypes generateUnit(UnitTypes[] set, int spreading, List<UnitTypes> exclude) {
		final int maxSkill = 6;
		UnitTypes u = null;
		for (int i = 1; i <= maxSkill * spreading; i++) {
			final int id = (int) (Math.random() * set.length);
			u = set[id];
			int baseSkill = 2 + ((power == 3) ? 4 : power);
			final int pwd = Math.abs(baseSkill - u.getUnitType().getSkill());
			final boolean ex = (exclude != null) && (exclude.contains(u));
			if (!ex && (pwd * spreading < i)) {
				break;
			}

		}
		return u;
	}

	private void generateEnemies(Set<Cell> enemies) {
		for (Cell e : enemies) {
			GlobalHero h = new GlobalHero(generateEnemy(SIMPLE_ENEMY_ARMY_SIZE));
			h.goTo(e);
		}
	}

	protected int generateEnemyRank1() {
		int rank = this.power + 1;
		return rank;
	}

	protected int generateEnemyRank2() {
		int rank = this.power + 1;
		double i = Math.random();
		if (i > 0.97) { // 3%
			rank += 2;
		} else if (i > 0.90) {// 7%
			rank += 1;
		} else if (i > 0.87) {// 3%
			rank -= 2;
		} else if (i > 0.80) { // 7%
			rank -= 1;
		} else if (i > 0.50) { // 30%
			rank = 0;
		}
		rank = rank < 0 ? 0 : rank > 4 ? 4 : rank; // normalize
		return rank;
	}

	public Hero generateEnemy(int armySize) {
		int rank = generateEnemyRank1();
		Hero h = new Hero(rank, Hero.MAX_LEADERSHIP);
		Set<UnitTypes> set = new HashSet<UnitTypes>(UnitCounts.A[power].keySet());
		for (int k = 0; k < armySize; k++) {
			UnitTypes u = generateUnit(set, UNIT_SPREADING, null);
			int count = UnitCounts.A[power].get(u);
			if (count == 0) { // не должно произойти, но на всякий случай
				u = DEFAULT_UNIT;
				count = UnitCounts.A[power].get(u);
			}
			h.addToArmy(u, count);
			h.addMoney(u.getUnitType().getCost() * count / 2);
			set.remove(u);
		}
		return h;
	}

	public FieldType getFieldType(Cell cell) {
		FieldType f = null;
		if (cell != null) {
			f = getFieldType(cell.getX(), cell.getY());
		}
		return f;
	}

	public FieldType getFieldType(int x, int y) {
		if ((x < 0) || (y < 0) || (x >= fieldWidth) || (y >= fieldHeight)) {
			return null;
		} else {
			if (map[x][y].getContent() instanceof GlobalPlayer) {
				return bgField[x][y];
			}
			if (map[x][y].getContent() instanceof GlobalHero) {
				return FieldType.ENEMY;
			}
			if (map[x][y].getContent() instanceof Treasure) {
				return FieldType.BONUS;
			}
			if (map[x][y].getContent() instanceof SimpleUnitResidence) {
				return FieldType.BONUS;
			}
			if ((bgField[x][y] == FieldType.MAGE) && (getPlayer().getHero().isMagicActive())) {
				return FieldType.GRASS;
			}
			return bgField[x][y];
		}
	}

	public void clearFieldType(Cell cell) {
		if (cell != null) {
			int x = cell.getX();
			int y = cell.getY();
			bgField[x][y] = FieldType.GRASS;
		}
	}

	private GlobalPlayer getPlayer() {
		return model.getGlobalPlayer();
	}

	public void goTo(int x, int y) {
		Cell cell = getCell(x, y);
		goTo(cell);
	}

	public void goTo(Cell cell) {
		// если режим постройки мостов
		if (getPlayer().getBrigeMaker() > 0) {
			if (cell != null) {
				int dx = cell.getX() - getPlayer().getCell().getX();
				int dy = cell.getY() - getPlayer().getCell().getY();
				if ((dx == 0) || (dy == 0)) {
					boolean vertical = (dx == 0);
					for (int i = 0; i < getPlayer().getBrigeMaker(); i++) {
						if ((cell != null) && (FieldType.POOLS.contains(cell.getFieldType()))) {
							Bridge brige = new Bridge(cell, vertical);
							cell.setContent(brige);
							// следующая плита
							cell = getCell(cell.getX() + dx, cell.getY() + dy);
						} else {
							break;
						}
					}
					getPlayer().setBrigeMaker(0);
					KBEvent event = new BrigeBuiltEvent();
					onEvent(event);
				}
			}
		} else {
			// движение врага
			// враг не двигается если мы его атакуем
			if ((cell != null) && !(cell.getContent() instanceof GlobalHero)) {
				moveEnemy();
			}
			// если игрок не в полете, остался на месте и на его место наступил
			// враг
			if ((!getPlayer().isFlying()) && (cell == getPlayer().getCell())//
					&& (cell.getContent() instanceof GlobalHero) //
					&& (cell.getContent() != this)) {
				cell.getContent().onActivate(getPlayer());
			}

			if (getPlayer().isFlying()) {
				goFlyTo(cell);
				cell = null;
			} else {
				if (!goLandTo(cell)) {
					if (getPlayer().getCell().getContent() instanceof GlobalHero)
						((GlobalHero) (getPlayer().getCell().getContent())).attackEnemy(getPlayer());
				}
			}
		}
	}

	void moveEnemy() {
		final Cell cell = getPlayer().getCell();
		if (cell != null) {
			int xx = cell.getX();
			int yy = cell.getY();
			for (int i = 0; i < VIEW_WIDTH; i++) {
				for (int j = 0; j < VIEW_HEIGHT; j++) {
					int x = xx - VIEW_WIDTH / 2 + i;
					int y = yy - VIEW_HEIGHT / 2 + j;
					if ((x >= 0) && (y >= 0) && (x < getFieldWidth()) && (y < getFieldHeight())) {
						Content c = getCell(x, y).getContent();
						if ((c instanceof GlobalHero) && (c != getPlayer())) {
							GlobalHero enemy = (GlobalHero) c;
							int xk = (xx > x) ? x + 1 : (xx < x) ? x - 1 : x;
							int yk = (yy > y) ? y + 1 : (yy < y) ? y - 1 : y;
							if (moveEnemyAvaibleCell(xk, yk)) {
								enemy.goTo(getCell(xk, yk));
								return;
							} else if (moveEnemyAvaibleCell(x, yk)) {
								enemy.goTo(getCell(x, yk));
								return;
							} else if (moveEnemyAvaibleCell(xk, y)) {
								enemy.goTo(getCell(xk, y));
								return;
							}
						}
					}
				}
			}
		}
	}

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean moveEnemyAvaibleCell(int x, int y) {
		boolean b = getFieldType(x, y) == FieldType.GRASS;
		// safe zone near king castle
		b = b && !((id == 0) && (x < 18) && (y < 8));
		// log.warn(x + ";" + y + ":" + b);
		return b;
	}

	private void goFlyTo(Cell cell) {
		if (cell != null) {
			FieldType f = getFieldType(cell);
			log.info("Fly to {}", f);
			if ((f == FieldType.GRASS) //
					|| (f == FieldType.CASTLE_S) //
					|| (FieldType.SANDS.contains(f))//
					|| (FieldType.POOLS.contains(f))//
					|| (FieldType.HILLS.contains(f))//
					|| (FieldType.BUSHES.contains(f))//
					|| (FieldType.CASTLES.contains(f))//
					|| (f == FieldType.MAGE)//
					|| (f == FieldType.TOWN) //
					|| (f == FieldType.BONUS)//
					|| (f == FieldType.ENEMY) //
					|| (f == FieldType.SIGNPOST)) {
				getPlayer().goTo(cell, f);
			}
			KBEvent event = new GlobalPlayerMoveEvent();
			onEvent(event);
		}
	}

	private boolean goLandTo(Cell cell) {
		boolean canGo = false;
		if (cell != null) {
			FieldType f = getFieldType(cell);
			Content content = cell.getContent();
			log.info("Go to " + f);
			// если просто проходимые места
			if ((f == FieldType.GRASS) //
					|| (f == FieldType.CASTLE_S) //
					|| (FieldType.SANDS.contains(f))) {
				getPlayer().goTo(cell, f);
				// вода - проходима на корабле или по мосту
			} else if (FieldType.POOLS.contains(f)) {
				if (getPlayer().inShip()) { // уже плывем
					getPlayer().getShip().setCell(cell);
					getPlayer().goTo(cell, f);
				} else if (getPlayer().getShip().getCell() == cell) { // тут
																		// корабль
					getPlayer().goTo(cell, f);
				} else if (cell.getContent() instanceof Bridge) {
					getPlayer().goTo(cell, f);
				}
				// дом мага - покупка магии
			} else if (f == FieldType.MAGE) {
				KBEvent event = new BuyMagicEvent(getPlayer(), cell);
				onEvent(event);

				// активируемые элекенты
			} else if ((f == FieldType.TOWN) //
					|| (f == FieldType.BONUS)//
					|| (f == FieldType.ENEMY) //
					|| (f == FieldType.CASTLE_B) //
					|| (f == FieldType.SIGNPOST) //
			) {
				if (content != null) {
					log.info("Activate " + content.getClass().getSimpleName());
					canGo = content.onActivate(getPlayer());
				}
			}
			if (canGo) {
				getPlayer().goTo(cell, f);
			}
			KBEvent event = new GlobalPlayerMoveEvent();
			onEvent(event);

		}
		return canGo;
	}

	public Cell getCell(int i, int j) {
		if ((i < 0) || (j < 0) || (i >= fieldWidth) || (j >= fieldHeight)) {
			return null;
		} else {
			return map[i][j];
		}
	}

	public int getId() {
		return id;
	}

	public void activateMagic(TravelSpells spell) {
		TravelMagicBook book = getPlayer().getBook();

		book.get(spell).use();

		KBEvent event = new TravelSpellActivatinoEvent();
		onEvent(event);
	}

	public boolean hasFullMap() {
		return getPlayer().hasFullMap(this);
	}

	public BattleModelI getBattleModel() {
		return model.getBattleModel();
	}

	public void onEvent(KBEvent event) {
		getPlayer().onEvent(event);
	}

	public Set<Castle> getCastles() {
		Set<Castle> castles = new HashSet<Castle>();
		for (Cell c : this.castles) {
			castles.add((Castle) c.getContent());
		}
		return castles;
	}

	public Set<Town> getTowns() {
		Set<Town> towns = new HashSet<Town>();
		for (Cell c : this.towns) {
			towns.add((Town) c.getContent());
		}
		return towns;
	}

	public Cell getStartCell() {
		return inputCell;
	}

	public void setNextMap(GlobalMap map) {
		this.nextMap = map;
	}

	public GlobalMap getNextMap() {
		return nextMap;
	}

	Collection<Cell> getCellsByFieldType(FieldType ft) {
		List<Cell> c = new LinkedList<Cell>();
		for (int i = 0; i < fieldWidth; i++) {
			for (int j = 0; j < fieldHeight; j++) {
				if (bgField[i][j] == ft) {
					c.add(map[i][j]);
				}
			}
		}
		return c;
	}

	public Cell getInputCell() {
		return inputCell;
	}

	public Map<Cell, Treasure> getTreasures() {
		Map<Cell, Treasure> b = new HashMap<Cell, Treasure>();
		for (int i = 0; i < fieldWidth; i++) {
			for (int j = 0; j < fieldHeight; j++) {
				Cell cell = map[i][j];
				Content content = cell.getContent();
				if (content instanceof Treasure) {
					b.put(cell, (Treasure) content);
				}
			}
		}
		return b;
	}

	public Map<Cell, Residence> getResidences() {
		Map<Cell, Residence> b = new HashMap<Cell, Residence>();
		for (int i = 0; i < fieldWidth; i++) {
			for (int j = 0; j < fieldHeight; j++) {
				Cell cell = map[i][j];
				Content content = cell.getContent();
				if (content instanceof SimpleUnitResidence) {
					b.put(cell, (Residence) content);
				}
			}
		}
		return b;
	}

	public Map<Cell, Bridge> getBridges() {
		Map<Cell, Bridge> b = new HashMap<Cell, Bridge>();
		for (int i = 0; i < fieldWidth; i++) {
			for (int j = 0; j < fieldHeight; j++) {
				Cell cell = map[i][j];
				Content content = cell.getContent();
				if (content instanceof Bridge) {
					b.put(cell, (Bridge) content);
				}
			}
		}
		return b;
	}

	public Map<Cell, GlobalHero> getHeroes() {
		Map<Cell, GlobalHero> b = new HashMap<Cell, GlobalHero>();
		for (int i = 0; i < fieldWidth; i++) {
			for (int j = 0; j < fieldHeight; j++) {
				Cell cell = map[i][j];
				Content content = cell.getContent();
				if (content instanceof GlobalHero) {
					b.put(cell, (GlobalHero) content);
				}
			}
		}
		return b;
	}

	/**
	 * Delete heroes, treasures, simple unit residences
	 */
	public void clear() {
		for (int i = 0; i < fieldWidth; i++) {
			for (int j = 0; j < fieldHeight; j++) {
				Cell cell = map[i][j];
				Content content = cell.getContent();
				if (content instanceof Bridge) {
					cell.setContent(null);
				}
				if ((content instanceof GlobalHero) || (content instanceof Treasure) || (content instanceof SimpleUnitResidence)) {
					cell.setContent(null);
					bgField[i][j] = FieldType.GRASS;
				}
				if ((content instanceof Castle)) {
					Castle c = (Castle) cell.getContent();
					c.setHero(null);
				}
			}
		}
	}

	public void setLastMap() {
		new GoldTreasure(power, nextMapTreasureCell);
	}

}
