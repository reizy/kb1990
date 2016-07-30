package ru.reizy.kb1990.model.battle.base.unit.interfaces;

import ru.reizy.kb1990.model.battle.BattleHero;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;

public interface UnitInMagica {

	BattleHero getBattleHero();

	UnitType getType();

	int getCount();

	void setCount(int i);

	int getStartCount();

	void setStartCount(int count);

	void setСurrentHitPoints(int maxHitPoints);

	int getСurrentHitPoints();

	Cell getLocation();

	int defence(UnitInModel object, int a);

	int getMP();

	boolean reduceMP(int mp);

	void setLocation(Cell cell);

	void setFreesed(int freesed);

	boolean isOutOfControl();

}
