package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;

public class Nomads extends UnitType {

	private static final int ID = 12;
	private static final int SKILL = 3;
	private static final int MAX_HP = 15;
	private static final int MAX_MP = 2;
	private static final int MIN_DAMAGE = 2;
	private static final int MAX_DAMAGE = 4;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 300;
	private static final int RACE = 3;

	Nomads() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

}
