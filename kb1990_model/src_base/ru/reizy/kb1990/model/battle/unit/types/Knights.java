package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInType;

public class Knights extends UnitType {

	private static final int ID = 15;
	private static final int SKILL = 5;
	private static final int MAX_HP = 35;
	private static final int MAX_MP = 1;
	private static final int MIN_DAMAGE = 6;
	private static final int MAX_DAMAGE = 10;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 1000;
	private static final int RACE = 2;

	private static final float ADITIONAL_DEFENCE = 0.2f;

	Knights() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

	@Override
	public void defence(UnitInType that, int a) {
		super.defence(that, (int) (a * (1 - ADITIONAL_DEFENCE)));
	}
}
