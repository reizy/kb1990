package ru.reizy.kb1990.model.battle.base;

import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;

public class AtackInfo {
	private int atack;
	private int dead;
	private int count;
	private int aimCount;
	private UnitInModel unit;
	private UnitInModel aim;
	private Cell unitCell;
	private Cell aimCell;
	private boolean revenge;
	private boolean shooting;
	private boolean special;

	public AtackInfo(UnitInModel unit, UnitInModel aim, Cell unitCell,
			Cell aimCell, int atack, int count, int aimCount, int dead,
			boolean revenge, boolean shooting, boolean special) {
		super();
		this.atack = atack;
		this.dead = dead;
		this.count = count;
		this.aimCount = aimCount;
		this.unit = unit;
		this.aim = aim;
		this.unitCell = unitCell;
		this.aimCell = aimCell;
		this.revenge = revenge;
		this.shooting = shooting;
		this.special = special;
	}

	public int getAtack() {
		return atack;
	}

	public int getDead() {
		return dead;
	}

	public int getCount() {
		return count;
	}

	public int getAimCount() {
		return aimCount;
	}

	public UnitInModel getUnit() {
		return unit;
	}

	public UnitInModel getAim() {
		return aim;
	}

	public boolean isRevenge() {
		return revenge;
	}

	public boolean isSpecial() {
		return special;
	}

	public void setRevenge(boolean revenge) {
		this.revenge = revenge;
	}

	public Cell getUnitLocation() {
		return unitCell;
	}

	public Cell getAimLocation() {
		return aimCell;
	}

	public boolean isShooting() {
		return shooting;
	}

	@Override
	public String toString() {
		return "AtackInfo [atack=" + atack + ", dead=" + dead + ", count="
				+ count + ", aimCount=" + aimCount + ", unit=" + unit.getType().getClass().getSimpleName()
				+ ", aim=" + aim.getType().getClass().getSimpleName() + ", unitCell=" + unitCell + ", aimCell="
				+ aimCell + ", revenge=" + revenge + ", shooting=" + shooting
				+ ", special=" + special + "]";
	}

}
