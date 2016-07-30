package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInType;

public class Trolls extends UnitType {

	private static final int ID = 18;
	private static final int SKILL = 4;
	private static final int MAX_HP = 50;
	private static final int MAX_MP = 1;
	private static final int MIN_DAMAGE = 2;
	private static final int MAX_DAMAGE = 5;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 1000;
	private static final int RACE = 4;

	Trolls() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

	@Override
	public void onResetMP(UnitInType unit) {
		unit.setСurrentHitPoints(MAX_HP);
	}
}
