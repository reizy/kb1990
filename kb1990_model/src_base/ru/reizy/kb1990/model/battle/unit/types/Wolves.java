package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;

public class Wolves extends UnitType {

	private static final int ID = 4;
	private static final int SKILL = 2;
	private static final int MAX_HP = 3;
	private static final int MAX_MP = 3;
	private static final int MIN_DAMAGE = 1;
	private static final int MAX_DAMAGE = 3;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 40;
	private static final int RACE = 4;

	Wolves() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

}
