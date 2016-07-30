package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.MagicShooterUnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.FlyingUnit;

public class Archmages extends MagicShooterUnitType implements FlyingUnit {

	private static final int ID = 21;
	private static final int SKILL = 5;
	private static final int MAX_HP = 25;
	private static final int MAX_MP = 1;
	private static final int MIN_DAMAGE = 2;
	private static final int MAX_DAMAGE = 3;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 1200;
	private static final int RACE = 3;

	private static final int MIN_SHOOT_DAMAGE = 25;
	private static final int MAX_SHOOT_DAMAGE = 25;
	private static final int MAX_SHOOT_COUNT = 2;

	Archmages() {
		super(ID, SKILL, MAX_HP, MAX_MP, //
				MIN_DAMAGE, MAX_DAMAGE,//
				MIN_SHOOT_DAMAGE, MAX_SHOOT_DAMAGE, MAX_SHOOT_COUNT,//
				LEADERSHIP, COST, RACE);
	}

}
