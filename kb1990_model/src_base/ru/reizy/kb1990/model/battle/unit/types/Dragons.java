package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.MagicShooterUnitType;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.FlyingUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.MagicImuneUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.MasteredUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInType;

public class Dragons extends UnitType implements FlyingUnit, MagicImuneUnit {

	private static final int ID = 25;
	private static final int SKILL = 6;
	private static final int MAX_HP = 200;
	private static final int MAX_MP = 1;
	private static final int MIN_DAMAGE = 25;
	private static final int MAX_DAMAGE = 50;
	private static final int LEADERSHIP = MAX_HP;
	private static final int COST = 5000;
	private static final int RACE = 4;

	Dragons() {
		super(ID, SKILL, MAX_HP, MAX_MP, MIN_DAMAGE, MAX_DAMAGE, LEADERSHIP,
				COST, RACE);
	}

	@Override
	protected boolean imune(UnitInType unit) {
		boolean b = false;
		if (unit instanceof MasteredUnit) {
			UnitInType master = ((MasteredUnit) unit).getMaster();
			b = (master.getType() instanceof MagicShooterUnitType);
		}
		return b;
	}
}
