package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.ShooterUnitType;

public class Archers extends ShooterUnitType {

	private static final int ID = 9;
	private static final int SKILL = 2;
	private static final int MAX_HP = 10;
	private static final int MAX_MP = 2;
	private static final int MIN_DAMAGE = 1;
	private static final int MAX_DAMAGE = 2;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 250;
	private static final int RACE = 2;

	private static final int MIN_SHOOT_DAMAGE = 1;
	private static final int MAX_SHOOT_DAMAGE = 3;
	private static final int MAX_SHOOT_COUNT = 12;

	Archers() {
		super(ID, SKILL, MAX_HP, MAX_MP, //
				MIN_DAMAGE, MAX_DAMAGE,//
				MIN_SHOOT_DAMAGE, MAX_SHOOT_DAMAGE, MAX_SHOOT_COUNT,//
				LEADERSHIP, COST, RACE);
	}

}
