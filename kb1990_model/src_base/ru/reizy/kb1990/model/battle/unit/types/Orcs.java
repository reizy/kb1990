package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.ShooterUnitType;

public class Orcs extends ShooterUnitType {

	private static final int ID = 8;
	private static final int SKILL = 2;
	private static final int MAX_HP = 5;
	private static final int MAX_MP = 2;
	private static final int MIN_DAMAGE = 2;
	private static final int MAX_DAMAGE = 3;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 75;
	private static final int RACE = 4;

	private static final int MIN_SHOOT_DAMAGE = 1;
	private static final int MAX_SHOOT_DAMAGE = 2;
	private static final int MAX_SHOOT_COUNT = 6;

	Orcs() {
		super(ID, SKILL, MAX_HP, MAX_MP, //
				MIN_DAMAGE, MAX_DAMAGE,//
				MIN_SHOOT_DAMAGE, MAX_SHOOT_DAMAGE, MAX_SHOOT_COUNT,//
				LEADERSHIP, COST, RACE);
	}

}
