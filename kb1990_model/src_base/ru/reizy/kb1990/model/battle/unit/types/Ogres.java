package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;

public class Ogres extends UnitType {

	private static final int ID = 16;
	private static final int SKILL = 4;
	private static final int MAX_HP = 40;
	private static final int MAX_MP = 1;
	private static final int MIN_DAMAGE = 3;
	private static final int MAX_DAMAGE = 5;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 750;
	private static final int RACE = 4;

	Ogres() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

}
