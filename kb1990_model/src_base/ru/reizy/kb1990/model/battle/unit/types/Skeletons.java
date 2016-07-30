package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UndeadUnit;

public class Skeletons extends UnitType implements UndeadUnit {

	private static final int ID = 5;
	private static final int SKILL = 2;
	private static final int MAX_HP = 3;
	private static final int MAX_MP = 2;
	private static final int MIN_DAMAGE = 1;
	private static final int MAX_DAMAGE = 2;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 40;
	private static final int RACE = 5;

	Skeletons() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

}
