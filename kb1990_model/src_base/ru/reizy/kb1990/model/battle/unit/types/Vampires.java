package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.FlyingUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UndeadUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInType;

public class Vampires extends UnitType implements FlyingUnit, UndeadUnit {

	private static final int ID = 22;
	private static final int SKILL = 5;
	private static final int MAX_HP = 30;
	private static final int MAX_MP = 1;
	private static final int MIN_DAMAGE = 3;
	private static final int MAX_DAMAGE = 6;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 1500;
	private static final int RACE = 5;

	Vampires() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

	@Override
	public int getDamage(int count, UnitInType unit, UnitInType aim) {
		int a = super.getDamage(count, unit, aim);
		if (unit.getCount() <= unit.getStartCount()) {
			vampire(unit, a);
		}
		return a;
	}

	private void vampire(UnitInType unit, int a) {
		a += unit.getСurrentHitPoints();
		int c = unit.getCount() + a / getMaxHitPoints();
		a %= getMaxHitPoints();
		if (c > unit.getStartCount()) {
			c = unit.getStartCount();
			a = getMaxHitPoints();
		}
		unit.setСurrentHitPoints(a);
		unit.setCount(c);
	}
}
