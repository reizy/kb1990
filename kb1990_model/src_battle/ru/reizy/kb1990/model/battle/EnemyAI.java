package ru.reizy.kb1990.model.battle;

import static ru.reizy.kb1990.model.battle.BattleModel.FIELD_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.ShooterUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.FlyingUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;
import ru.reizy.kb1990.model.events.FreezedUnitEvent;

public class EnemyAI {
	private BattleModel model;

	EnemyAI(BattleModel model) {
		this.model = model;
	}

	public void move() {
		// find enemy shooter
		List<UnitInModel> army = model.getPlayerArmy();
		if (army.size() > 0) {
			// если ход игрока - сменить атакуемую армию
			if (army.contains(model.getActiveUnit())) {
				army = model.getEnemyArmy();
			}
			// выбрать цель - юнита
			UnitInModel aim = null;
			for (UnitInModel aUnit : army) {
				if (aUnit instanceof ShooterUnit) {
					aim = aUnit;
					break;
				}
			}
			// if no shooters
			if (aim == null) {
				aim = army.get(0);
			}

			// try to movie
			int[][] mask = model.getMPMask();
			UnitInModel unit = model.getActiveUnit();
			if (ShooterUnit.canShoot(unit, mask)) {
				shooterMove(unit, aim, mask);
			} else if (unit.getType() instanceof FlyingUnit) {
				flyingMove(unit, aim, mask, army);
			} else {
				meleeMove(unit, aim, mask);
			}
		}
	}

	private void flyingMove(UnitInModel unit, UnitInModel aim, int[][] mask, List<UnitInModel> army) {
		// if near enemy - atack
		List<Cell> path = getNearCells(unit.getLocation());
		Cell cell = canAtack(path, mask);
		if (cell != null) {
			model.goActiveTo(cell.getX(), cell.getY());
		} else {
			// if can fly to the aim - fly and atack
			if (!tryFlyAndAtack(aim, mask)) {
				for (UnitInModel u : army) {
					if (tryFlyAndAtack(u, mask)) {
						break;
					}
				}
			}
		}
	}

	private boolean tryFlyAndAtack(UnitInModel aim, int[][] mask) {
		List<Cell> path = getNearCells(aim.getLocation());
		Cell cell = null;
		for (Cell c : path) {
			if (c != null) {
				if (mask[c.getX()][c.getY()] > 0) {
					cell = c;
				}
			}
		}
		if (cell != null) {
			model.goActiveTo(cell.getX(), cell.getY());
			model.goActiveTo(aim.getLocation().getX(), aim.getLocation().getY());
		}
		return (cell != null);
	}

	private void shooterMove(UnitInModel unit, UnitInModel aim, int[][] mask) {
		// try to movie
		List<Cell> path = getNearCells(unit.getLocation());
		Cell c = canAtack(path, mask);
		if (c == null) {
			c = aim.getLocation();
		}
		model.goActiveTo(c.getX(), c.getY());

	}

	private void meleeMove(UnitInModel unit, UnitInModel aim, int[][] mask) {
		// try to movie
		boolean canMove = true;
		while ((unit == model.getActiveUnit()) && (unit.getMP() > 0) && (canMove)) {
			List<Cell> path = getNearCells(unit.getLocation());
			Cell c = canAtack(path, mask);
			if (c != null) {
				model.goActiveTo(c.getX(), c.getY());
			} else if (unit.isFreesed()) {
				canMove = false;
				model.onEvent(new FreezedUnitEvent(unit));
			} else {
				canMove = oneStep(path, mask, aim.getLocation());
			}
			mask = model.getMPMask();
		}
		// no MP or no Way
		if (!canMove) {
			model.waitAIUnit();
		}
	}

	private static Cell canAtack(List<Cell> path, int[][] mask) {
		List<Cell> near = new ArrayList<Cell>();
		for (Cell c : path) {
			if (c != null) {
				if (mask[c.getX()][c.getY()] == -101) {
					near.add(c);
				}
			}
		}
		if (near.size() > 0) {
			Collections.sort(near, new Comparator<Cell>() {
				public int compare(Cell arg0, Cell arg1) {
					int a = arg0.getContent().getType().getId();
					int b = arg1.getContent().getType().getId();
					return a - b;
				}
			});
			return near.get(0);
		} else
			return null;
	}

	/**
	 * move on one step
	 * 
	 * @param path
	 * @param mask
	 * @param aLoc
	 * @return
	 */
	private boolean oneStep(List<Cell> path, int[][] mask, final Cell aLoc) {
		Collections.sort(path, new Comparator<Cell>() {
			// nearest way
			public int compare(Cell o1, Cell o2) {
				if (o1 == null)
					return 1;
				if (o2 == null)
					return -1;
				int a = Math.abs(o1.getX() - aLoc.getX());
				int a2 = a + Math.abs(o1.getY() - aLoc.getY());
				a = Math.max(a, Math.abs(o1.getY() - aLoc.getY()));
				int b = Math.abs(o2.getX() - aLoc.getX());
				int b2 = b + Math.abs(o2.getY() - aLoc.getY());
				b = Math.max(b, Math.abs(o2.getY() - aLoc.getY()));
				return (a - b) * FIELD_SIZE + (a2 - b2);
			}
		});

		boolean canMove = false;
		for (int i = 0; i < 5; i++) {
			Cell c = path.get(i);
			if (c != null) {
				if (mask[c.getX()][c.getY()] > 0) {
					model.goActiveTo(c.getX(), c.getY());
					canMove = true;
					break;
				}
			}
		}
		return canMove;
	}

	private List<Cell> getNearCells(Cell location) {
		List<Cell> path = new ArrayList<Cell>(9);
		int x = location.getX();
		int y = location.getY();
		path.add(model.getCell(x + 1, y));
		path.add(model.getCell(x - 1, y));
		path.add(model.getCell(x, y + 1));
		path.add(model.getCell(x, y - 1));
		path.add(model.getCell(x + 1, y + 1));
		path.add(model.getCell(x + 1, y - 1));
		path.add(model.getCell(x - 1, y + 1));
		path.add(model.getCell(x - 1, y - 1));
		return path;
	}

}
