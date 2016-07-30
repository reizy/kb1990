package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;

public class Peasants extends UnitType {

	private static final int ID = 1;
	private static final int SKILL = 1;
	private static final int MAX_HP = 1;
	private static final int MAX_MP = 1;
	private static final int MIN_DAMAGE = 1;
	private static final int MAX_DAMAGE = 1;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 10;
	private static final int RACE = 1;

	Peasants() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

}
