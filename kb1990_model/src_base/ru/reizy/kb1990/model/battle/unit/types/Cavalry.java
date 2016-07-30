package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;

public class Cavalry extends UnitType {

	private static final int ID = 19;
	private static final int SKILL = 4;
	private static final int MAX_HP = 20;
	private static final int MAX_MP = 4;
	private static final int MIN_DAMAGE = 3;
	private static final int MAX_DAMAGE = 5;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 800;
	private static final int RACE = 2;

	Cavalry() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

}
