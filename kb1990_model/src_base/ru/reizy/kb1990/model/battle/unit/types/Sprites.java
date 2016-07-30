package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.FlyingUnit;

public class Sprites extends UnitType implements FlyingUnit {

	private static final int ID = 2;
	private static final int SKILL = 1;
	private static final int MAX_HP = 1;
	private static final int MAX_MP = 1;
	private static final int MIN_DAMAGE = 1;
	private static final int MAX_DAMAGE = 2;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 15;
	private static final int RACE = 3;

	Sprites() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

}
