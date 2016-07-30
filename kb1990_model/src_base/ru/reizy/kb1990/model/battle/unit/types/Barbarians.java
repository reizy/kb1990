package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;

public class Barbarians extends UnitType {

	private static final int ID = 17;
	private static final int SKILL = 4;
	private static final int MAX_HP = 40;
	private static final int MAX_MP = 3;
	private static final int MIN_DAMAGE = 1;
	private static final int MAX_DAMAGE = 6;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 750;
	private static final int RACE = 3;

	Barbarians() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

}
