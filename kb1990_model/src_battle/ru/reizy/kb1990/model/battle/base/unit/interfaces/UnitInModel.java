package ru.reizy.kb1990.model.battle.base.unit.interfaces;

import ru.reizy.kb1990.model.battle.BattleHero;
import ru.reizy.kb1990.model.battle.base.AtackInfo;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;

public interface UnitInModel extends UnitInView, UnitInMagica {

	void setHero(BattleHero playerHero);

	Cell getLocation();

	int getCount();

	int getMP();

	void resetMP();

	void setLocation(Cell cell);

	/**
	 * Reducing move points after moving
	 * 
	 * @param mp move points to reducing
	 * @return true if MP is over
	 */
	boolean reduceMP(int mp);

	AtackInfo atack(UnitInModel aim);

	AtackInfo atack(int count, UnitInModel aim);

	UnitType getType();

	boolean tryRevenge(UnitInModel aim);

	boolean isOutOfControl();

	boolean isFreesed();

}
