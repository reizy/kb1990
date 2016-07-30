package ru.reizy.kb1990.model.battle.base.unit;

import ru.reizy.kb1990.model.battle.BattleHero;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;

public class ShooterUnit extends Unit {

	private int shootCount;

	public ShooterUnit(BattleHero hero, Cell location, int count,
			ShooterUnitType type) {
		super(hero, location, count, type);
		shootCount = type.maxShootCount;
	}

	public ShootingMark getShootingMark() {
		return new ShootingMark(this);
	}

	public int getShootCount() {
		return shootCount;
	}

	public void reduseShootCount() {
		shootCount--;
	}

	public static boolean canShoot(UnitInModel unit, int[][] mask) {
		boolean b = (unit instanceof ShooterUnit);
		if (b) {
			ShooterUnit sUnit = (ShooterUnit) unit;
			b = (sUnit.shootCount > 0);
			if (b) {
				b = !canAtackNear(sUnit.getLocation(), mask);
			}
		}
		return b;
	}

	private static boolean canAtackNear(Cell location, int[][] mask) {
		boolean b = false;
		int x = location.getX();
		int y = location.getY();
		b = b || canAtack(x + 1, y, mask);
		b = b || canAtack(x - 1, y, mask);
		b = b || canAtack(x, y + 1, mask);
		b = b || canAtack(x, y - 1, mask);
		b = b || canAtack(x + 1, y + 1, mask);
		b = b || canAtack(x + 1, y - 1, mask);
		b = b || canAtack(x - 1, y + 1, mask);
		b = b || canAtack(x - 1, y - 1, mask);
		return b;
	}

	private static boolean canAtack(int x, int y, int[][] mask) {
		boolean b = ((x >= 0) && (x < mask.length) && (y >= 0) && (y < mask[0].length));
		if (b) {
			b = (mask[x][y] == -101);
		}
		return b;
	}
}
