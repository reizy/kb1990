package ru.reizy.kb1990.model.battle.unit.types;

import java.util.Random;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.FlyingUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInType;

public class Demons extends UnitType implements FlyingUnit {

	private static final double HALF_CHANCE = 0.2;
	private static final int ID = 24;
	private static final int SKILL = 6;
	private static final int MAX_HP = 50;
	private static final int MAX_MP = 1;
	private static final int MIN_DAMAGE = 5;
	private static final int MAX_DAMAGE = 7;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 3000;
	private static final int RACE = 5;

	private static Random r = new Random();

	Demons() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

	@Override
	public int getDamage(int count, UnitInType unit, UnitInType aim) {
		int a = super.getDamage(count, unit, aim);
		if (r.nextDouble() > (1 - HALF_CHANCE)) {
			int d = (aim.getCount() - 1) * aim.getType().getMaxHitPoints()
					+ aim.getСurrentHitPoints();
			d /= 2;
			a = (a > d) ? a : d;
			a = -a;
		}
		return a;
	}
}
