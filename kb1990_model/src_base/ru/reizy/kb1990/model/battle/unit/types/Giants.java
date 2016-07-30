package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.ShooterUnitType;

public class Giants extends ShooterUnitType {

	private static final int ID = 23;
	private static final int SKILL = 5;
	private static final int MAX_HP = 60;
	private static final int MAX_MP = 3;
	private static final int MIN_DAMAGE = 10;
	private static final int MAX_DAMAGE = 20;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 2000;
	private static final int RACE = 3;

	private static final int MIN_SHOOT_DAMAGE = 5;
	private static final int MAX_SHOOT_DAMAGE = 10;
	private static final int MAX_SHOOT_COUNT = 6;

	Giants() {
		super(ID, SKILL, MAX_HP, MAX_MP, //
				MIN_DAMAGE, MAX_DAMAGE,//
				MIN_SHOOT_DAMAGE, MAX_SHOOT_DAMAGE, MAX_SHOOT_COUNT,//
				LEADERSHIP, COST, RACE);
	}

}
