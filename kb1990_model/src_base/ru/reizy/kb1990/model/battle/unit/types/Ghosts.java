package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UndeadUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInType;

public class Ghosts extends UnitType implements UndeadUnit {

	private static final int ID = 14;
	private static final int SKILL = 4;
	private static final int MAX_HP = 10;
	private static final int MAX_MP = 3;
	private static final int MIN_DAMAGE = 3;
	private static final int MAX_DAMAGE = 4;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 400;
	private static final int RACE = 5;

	Ghosts() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

	@Override
	public int getDamage(int count, UnitInType unit, UnitInType aim) {
		int a = super.getDamage(count, unit, aim);
		vampire(unit, aim, a);
		return a;
	}

	private void vampire(UnitInType unit, UnitInType aim, int a) {
		a -= aim.getСurrentHitPoints();
		if (a > 0) {
			a /= aim.getType().getMaxHitPoints();
			a++;
			unit.setCount(unit.getCount() + a);
		}
	}

}
