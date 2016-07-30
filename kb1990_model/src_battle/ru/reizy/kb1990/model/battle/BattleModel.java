package ru.reizy.kb1990.model.battle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.BattleModelI;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.base.AtackInfo;
import ru.reizy.kb1990.model.battle.base.FieldType;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.MagicMark;
import ru.reizy.kb1990.model.battle.base.unit.ShooterUnit;
import ru.reizy.kb1990.model.battle.base.unit.ShootingMark;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.FlyingUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;
import ru.reizy.kb1990.model.battle.magic.abstraction.MagicBattleSpell;
import ru.reizy.kb1990.model.battle.magic.spells.events.SpellActivatedEvent;
import ru.reizy.kb1990.model.events.BattleBetrayalEvent;
import ru.reizy.kb1990.model.events.BattleFinishListener;
import ru.reizy.kb1990.model.events.BattleInfoEvent;
import ru.reizy.kb1990.model.events.BattleNewTurnEvent;
import ru.reizy.kb1990.model.events.BattleNextUnitEvent;
import ru.reizy.kb1990.model.events.BattleStartEvent;
import ru.reizy.kb1990.model.events.BattleUnitAtackEvent;
import ru.reizy.kb1990.model.events.BattleUnitMoveEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;

public class BattleModel implements BattleModelI {

	private static final Logger log = LoggerFactory.getLogger(BattleModel.class);

	private static final String NOT_ENOUGH_MP = "слишком далеко";
	private static final String CELL_WITH_FRIEND = "Поле уже занято дружественными войсками";

	public static final int FIELD_WIDTH = 6;
	public static final int FIELD_HEIGHT = 5;
	public static final int FIELD_SIZE = FIELD_WIDTH * FIELD_HEIGHT;
	/* увеличить чтобы было меньше препятствий на поле */
	private static final int VOID_KOEF = 20;
	private final KBModelBattleI model;
	private final Cell[][] field = new Cell[FIELD_WIDTH][FIELD_HEIGHT];
	private final FieldType[][] bgField = new FieldType[FIELD_WIDTH][FIELD_HEIGHT];
	private UnitInModel activeUnit;
	private List<UnitInModel> activeArmy;
	private LinkedList<UnitInModel> activeQueue = new LinkedList<UnitInModel>();
	private BattlePlayer playerHero;
	private BattleHero enemyHero;
	private PathField pathField = new PathField(this);

	public BattleModel(KBModelBattleI model) {
		this.model = model;
	}

	public BattlePlayer getPlayer() {
		return playerHero;
	}

	/*-
	 * (non-Javadoc) 
	 * 1) Создаются боевые проекции героев. 
	 * 2) Генерируется поле случайного заполнения либо создается поле-замок. 
	 * 3) Расставляются армии. 
	 * 4) Устанавливается активный юнит и армия. 
	 * 5) Инициируется представление.
	 * 
	 */
	public void startBattle(boolean castle, BattleFinishListener enemy) {
		log.info("Battle starts");
		playerHero = new BattlePlayer(model.getGlobalPlayer(), this);
		this.enemyHero = new BattleHero(enemy, this);

		List<Cell> c1 = new ArrayList<Cell>(5);
		List<Cell> c2 = new ArrayList<Cell>(5);

		if (castle) {
			getCastleField();
			c1.add(getCell(2, FIELD_HEIGHT - 1));
			c1.add(getCell(3, FIELD_HEIGHT - 1));
			c1.add(getCell(2, FIELD_HEIGHT - 2));
			c1.add(getCell(3, FIELD_HEIGHT - 2));
			c1.add(getCell(4, FIELD_HEIGHT - 2));
			c2.add(getCell(1, 0));
			c2.add(getCell(2, 0));
			c2.add(getCell(3, 0));
			c2.add(getCell(4, 0));
			c2.add(getCell(2, 1));
		} else {
			generateField();
			for (int i = 0; i < 5; i++) {
				c1.add(getCell(0, i));
				c2.add(getCell(FIELD_WIDTH - 1, i));
			}
		}

		int i;
		i = 0;
		for (UnitInModel unit : playerHero.getArmy()) {
			unit.setLocation(c1.get(i++));
		}
		i = 0;
		for (UnitInModel unit : enemyHero.getArmy()) {
			unit.setLocation(c2.get(i++));
		}

		activeUnit = getPlayerArmy().get(0);
		activeQueue.clear();
		activeArmy = null;
		onEvent(new BattleStartEvent());
		log.info("Field, heroes & armies generated");
		nextUnit();
	}

	/*
	 * Создание поля-замка
	 */
	private void getCastleField() {
		log.info("Field generate: castle");
		for (int i = 0; i < FIELD_WIDTH; i++) {
			for (int j = 0; j < FIELD_HEIGHT; j++) {
				field[i][j] = new Cell(i, j);
				bgField[i][j] = FieldType.GRASS;
			}
		}

		for (int j = 0; j < FIELD_HEIGHT; j++) {
			bgField[0][j] = FieldType.WALL;
			bgField[FIELD_WIDTH - 1][j] = FieldType.WALL;
		}

		bgField[1][FIELD_HEIGHT - 1] = FieldType.WALL;
		bgField[FIELD_WIDTH - 2][FIELD_HEIGHT - 1] = FieldType.WALL;
	}

	/*
	 * создание поля со случайным заполнением
	 */
	private void generateField() {
		log.info("Field generate: castom");
		for (int j = 0; j < FIELD_HEIGHT; j++) {
			for (int i = 0; i < FIELD_WIDTH; i++) {
				field[i][j] = new Cell(i, j);
			}
		}

		Random r = new Random();
		// army lines
		for (int j = 0; j < FIELD_HEIGHT; j++) {
			bgField[0][j] = FieldType.GRASS;
			bgField[FIELD_WIDTH - 1][j] = FieldType.GRASS;
		}
		// middle field
		int k1 = 0;
		int k2;
		for (int i = 1; i < (FIELD_WIDTH - 1); i++) {
			k2 = k1; // кол-во препятствий в пред. столбце
			k1 = 0; // кол-во препятствий в этом. столбце
			for (int j = 0; j < FIELD_HEIGHT; j++) {
				bgField[i][j] = FieldType.GRASS;
				// to serve path
				if (((FIELD_HEIGHT - (k1 + k2)) > 0) // останется хотя бы один
														// диагональный проход
						&& ((FIELD_HEIGHT - k1) > 1)) { //
					// предполагается прогрессивный рандом
					// вероятность первого препятствия больше
					// верроятности второго препятсвия вдвое
					final int bound = VOID_KOEF * (1 + 2 * k1 + k2);
					final int rand = bound - r.nextInt(bound);
					switch (rand) {
					case 1:
						bgField[i][j] = FieldType.BUSH;
						k1++;
						break;
					case 2:
						bgField[i][j] = FieldType.POOL;
						k1++;
						break;
					case 3:
						bgField[i][j] = FieldType.HILL;
						k1++;
						break;
					}
				}
			}
		}
	}

	/**
	 * Получить тип поля по координатам
	 * 
	 * @param i коордиата по горизонтали
	 * @param j координата по вертикали
	 * @return тип поля
	 */
	public FieldType getFieldType(int i, int j) {
		FieldType ft = bgField[i][j];
		if (ft == null) {
			ft = FieldType.GRASS;
		}
		return ft;
	}

	/**
	 * Получить списком армию игрока
	 * 
	 * @return список - армия игрока
	 */
	public List<UnitInModel> getPlayerArmy() {
		return (playerHero != null) ? playerHero.getArmy() : null;
	}

	/**
	 * Получить списком армию НПС
	 * 
	 * @return список - армия НПС
	 */
	public List<UnitInModel> getEnemyArmy() {
		if (enemyHero == null) {
			return null;
		}
		return enemyHero.getArmy();
	}

	/**
	 * получить текущего активного юнита
	 * 
	 * @return текущий активный юнит
	 */
	public UnitInModel getActiveUnit() {
		return activeUnit;
	}

	/**
	 * Получить объект на поле по координатам
	 * 
	 * @param i коордиата по горизонтали
	 * @param j координата по вертикали
	 * @return тип поля
	 */
	public Cell getCell(int x, int y) {
		if ((x >= 0) && (x < FIELD_WIDTH) && (y >= 0) && (y < FIELD_HEIGHT)) {
			return field[x][y];
		} else {
			return null;
		}
	}

	/**
	 * Рассчитать путь от клетки до клетки
	 * 
	 * @param cellFrom начало пути
	 * @param cellTo цель пути
	 * @return список клеток, по которым нужно пройти
	 */
	public List<Cell> getPath(Cell cellFrom, Cell cellTo) {
		log.info("Calculating path");

		List<Cell> list = new LinkedList<Cell>();
		int[][] mask = pathField.getMask();
		Cell cell = cellTo;
		do {
			list.add(0, cell);
			int k = mask[cell.getX()][cell.getY()];
			// if aim is enemy
			if (k < 100) {
				k = 100 - k;
			}
			int x = cell.getX();
			int y = cell.getY();
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (((cell.getX() + i) >= 0) && ((cell.getX() + i) < FIELD_WIDTH) && ((cell.getY() + j) >= 0) && ((cell.getY() + j) < FIELD_HEIGHT)) {
						int n = mask[cell.getX() + i][cell.getY() + j];
						if ((n >= 0) && (n < k)) {
							x = cell.getX() + i;
							y = cell.getY() + j;
							k = n;
						}
					}

				}
			}
			cell = getCell(x, y);
		} while (cell != list.get(0));
		return list;
	}

	/**
	 * сгенерировать маску возможных ходов
	 * 
	 * @return матрица-маска возможных ходов
	 */
	public int[][] getMPMask() {
		log.info("Calculating path map");

		if (activeUnit != null) {
			if (activeUnit.getType() instanceof FlyingUnit) {
				pathField.findFlyingPath(activeUnit.getLocation().getX(), activeUnit.getLocation().getY());
			} else if (activeUnit instanceof ShootingMark) {
				pathField.findSootingPath();
			} else if (activeUnit instanceof MagicMark) {
				pathField.findMagicPath((MagicMark) activeUnit);
			} else {
				pathField.findPath(activeUnit.getLocation().getX(), activeUnit.getLocation().getY());
			}
		}
		return pathField.getMask();

	}

	public void giveUp() {
		playerHero.getArmy().clear();
		tryFinish();
	}

	/*
	 * сделать активным следующего юнита
	 */
	private void nextUnit() {
		log.info("Go to next unit");
		UnitInModel prev = activeUnit;
		boolean isAlive;
		boolean canMove;
		boolean noUnits;

		log.info("Check on betrayal or finish");

		tryBetrayal();
		tryFinish();
		log.info("Try to find unit");

		do {
			noUnits = activeQueue.isEmpty();
			if (noUnits) {
				nextArmy();
			}
			activeUnit = activeQueue.poll();
			if (activeUnit != null) {
				isAlive = activeUnit.getCount() > 0;
				canMove = activeUnit.getMP() > 0;
			} else {
				isAlive = true;
				canMove = true;
			}

		} while (!(isAlive && canMove));

		if (activeUnit != null) {
			log.info("Unit found: " + activeUnit.getType().getClass().getSimpleName());
			KBEvent event = new BattleNextUnitEvent(prev, activeUnit);
			onEvent(event);
			// AI step
			if (enemyHero.getArmy().contains(activeUnit)) {
				log.info("Enemy unit action: " + activeUnit.getType().getClass().getSimpleName());
				new EnemyAI(this).move();
			} else if (activeUnit.isOutOfControl()) {
				log.info("Out of control unit action: " + activeUnit.getType().getClass().getSimpleName());
				new EnemyAI(this).move();
			}
		} else {
			log.info("Unit is not found. ");
		}
	}

	private void tryFinish() {
		log.info("Check on battle finish");
		List<UnitInModel> playerArmy = playerHero.getArmy();
		List<UnitInModel> enemyArmy = enemyHero.getArmy();
		if ((enemyArmy.isEmpty()) || (playerArmy.isEmpty())) {
			activeQueue.clear();
			activeUnit = null;
			playerHero.updateHero();
			enemyHero.updateHero();
			BattleHero winner;
			BattleHero looser;
			if (enemyArmy.isEmpty()) {
				log.info("Enemy army is void.");
				winner = playerHero;
				looser = enemyHero;
			} else {
				log.info("Player army is void.");
				winner = enemyHero;
				looser = playerHero;
			}
			looser.getBattleListener().onBattleFail(winner.getHero());
			winner.getBattleListener().onBattleWin(looser.getHero());
		} else {
			log.info("There is no void armies");
		}
	}

	private void tryBetrayal() {
		log.info("Check if enemy defeted & some our units out of control");

		List<UnitInModel> playerArmy = playerHero.getArmy();
		List<UnitInModel> enemyArmy = enemyHero.getArmy();
		if (enemyArmy.isEmpty()) {// enemy fail?
			log.info("Еnemy defeted: yes");
			// betrayal
			for (Iterator<UnitInModel> iterator = playerArmy.iterator(); iterator.hasNext();) {
				UnitInModel u = (UnitInModel) iterator.next();
				if (u.isOutOfControl()) {
					enemyArmy.add(u);
					u.setHero(enemyHero);
					iterator.remove();
				}
			}

			if (!enemyArmy.isEmpty()) {
				log.info("We have intruders: yes");
				onEvent(new BattleBetrayalEvent(enemyArmy));
			} else {
				log.info("We have intruders: no");
			}
		} else {
			log.info("Еnemy defeted: no");
		}
	}

	private void nextArmy() {
		log.info("Go to next army");
		if (activeArmy == getPlayerArmy()) {
			activeArmy = getEnemyArmy();
		} else {
			activeArmy = getPlayerArmy();
			playerHero.getMagicBook().refreshMagic();
			onEvent(new BattleNewTurnEvent());
		}
		for (UnitInModel unit : activeArmy) {
			unit.resetMP();
		}
		activeQueue.addAll(activeArmy);
		activeQueue.addAll(activeArmy);
	}

	public boolean isEnemy(UnitInModel unit) {
		UnitInModel thisUnit = activeUnit;
		if (activeUnit instanceof ShootingMark) {
			thisUnit = ((ShootingMark) activeUnit).getMaster();
		}
		boolean b = false;
		if (getPlayerArmy().contains(thisUnit)) {
			b = b || (unit.isOutOfControl());
			b = b || (thisUnit.isOutOfControl());
			b = b || (getEnemyArmy().contains(unit));
			return b;
		} else {
			return getPlayerArmy().contains(unit);
		}
	}

	public void goActiveTo(int x, int y) {
		log.info("Execute move command: [" + x + "; " + y + "]");
		if (((x >= FIELD_WIDTH) || (y >= FIELD_HEIGHT) || (x < 0) || (y < 0))) {
			return;
		}
		if ((activeUnit == null) || (activeUnit.getType() == null)) {
			nextUnit();
		} else
			try {
				int[][] mask = getMPMask();
				int way = mask[x][y];
				if (way > 0) {
					log.info("Target cell is void.");
					// fling moving with no reducing move points
					if (activeUnit.getType() instanceof FlyingUnit) {
						log.info("It's flying unit. Try to change location.");
						Cell from = activeUnit.getLocation();
						activeUnit.setLocation(getCell(x, y));
						onEvent(new BattleUnitMoveEvent(from, activeUnit));
					}
					// simple moving with reducing move points
					else if (way <= activeUnit.getMP()) {
						log.info("It's melee unit. Try to change location.");
						boolean reduceMP = activeUnit.reduceMP(way);
						Cell from = activeUnit.getLocation();
						activeUnit.setLocation(getCell(x, y));
						onEvent(new BattleUnitMoveEvent(from, activeUnit));
						if (reduceMP) {
							nextUnit();
						}
					} else {
						log.info("It's melee unit. Not enough movement points.");
						onEvent(new BattleInfoEvent(NOT_ENOUGH_MP));
					}
					// melee or magic attack
				} else if (way == -101) {
					log.info("Target cell with enemy unit.");
					// magic attack
					if (activeUnit instanceof MagicMark) {
						log.info("Spell is active.");
						MagicMark mark = (MagicMark) activeUnit;
						if (mark.getSpell().use(mark, getCell(x, y))) {
							log.info("Spell '" + mark.getSpell().getType() + "' was activated.");
							nextUnit();
						} else {
							log.info("Spell '" + mark.getSpell().getType() + "' was not activated.");
							KBEvent event = new BattleNextUnitEvent(activeUnit, activeUnit);
							onEvent(event);
						}
					}
					// melee attack
					else {
						log.info("Try move & melee atack.");
						UnitInModel aim = getCell(x, y).getContent();
						if (isEnemy(aim)) {
							atacking(aim);
							activeUnit.reduceMP(activeUnit.getMP());
							nextUnit();
						} else {
							log.info("Target cell with no enemy unit.");
						}
					}
					// shooting attack
				} else if ((way < -101) && (ShooterUnit.canShoot(activeUnit, mask))) {
					log.info("Try shooter atack.");
					activateShooting();
					UnitInModel aim = getCell(x, y).getContent();
					if (isEnemy(aim)) {
						atacking(aim);
						activeUnit.reduceMP(activeUnit.getMP());
						nextUnit();
					} else {
						log.info("Target cell with no enemy unit.");
					}
				}
			} catch (IllegalStateException e) {
				onEvent(new BattleInfoEvent(CELL_WITH_FRIEND));
			}
	}

	private void atacking(UnitInModel aim) {
		int c2 = aim.getCount();
		AtackInfo a1 = activeUnit.atack(aim);
		KBEvent event = new BattleUnitAtackEvent(a1);
		onEvent(event);
		log.info("Atack:   " + a1);
		if (aim.tryRevenge(activeUnit)) {
			AtackInfo a2 = aim.atack(c2, activeUnit);
			KBEvent event2 = new BattleUnitAtackEvent(a2);
			onEvent(event2);
			log.info("Revenge: " + a2);
		} else {
			log.info("Revenge: no");
		}
	}

	public Player getPlayerHero() {
		return playerHero.getHero();
	}

	public void activateShooting() {
		log.info("Try to activate shooting.");
		if (activeUnit instanceof ShooterUnit) {
			ShooterUnit shooterUnit = (ShooterUnit) activeUnit;
			if (shooterUnit.getShootCount() > 0) {
				activeUnit = (shooterUnit).getShootingMark();
				log.info("Shooting activated.");
			}
		}
	}

	public void onEvent(KBEvent event) {
		model.onEvent(event);
	}

	private void activateMagic(MagicBattleSpell spell) {
		log.info("Try to activate magic.");
		if (activeUnit != null) {
			UnitInModel prev = activeUnit;
			if (!(prev instanceof MagicMark)) {
				activeQueue.addFirst(activeUnit);
			}
			spell.prepair();
			activeUnit = new MagicMark(spell);
			onEvent(new SpellActivatedEvent(spell, prev.getLocation()));
			log.info("Magic activated: " + spell.getClass().getSimpleName());
		}
	}

	public void activatePlayerMagic(BattleSpells spellType) {
		if (playerHero.getMagicBook().isActive()) {
			MagicBattleSpell spell = playerHero.getMagicBook().get(spellType);
			activateMagic(spell);
		}
	}

	public void missPlayerUnit() {
		if (activeUnit != null) {
			final UnitType unitType = activeUnit.getType();
			log.info("Miss action: {}", unitType.getClass().getSimpleName());
		}
		if (isUserControled()) {
			activeQueue.remove(activeUnit);
			nextUnit();
		}
	}

	public void waitPlayerUnit() {
		if (activeUnit != null) {
			log.info("Wait action: {}", activeUnit.getType().getClass().getSimpleName());
		}
		if (isUserControled()) {
			nextUnit();
		}
	}

	public boolean isUserControled() {
		return (activeUnit != null) && (activeUnit.getBattleHero() == playerHero) && (!activeUnit.isOutOfControl());
	}

	void waitAIUnit() {
		nextUnit();
	}

	public void addView(KBViewInterface view) {
		model.addView(view);
	}

}
