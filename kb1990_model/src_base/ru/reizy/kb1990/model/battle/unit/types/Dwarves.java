package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;

public class Dwarves extends UnitType {

	private static final int ID = 13;
	private static final int SKILL = 3;
	private static final int MAX_HP = 20;
	private static final int MAX_MP = 1;
	private static final int MIN_DAMAGE = 2;
	private static final int MAX_DAMAGE = 4;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 350;
	private static final int RACE = 3;

	Dwarves() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

}
