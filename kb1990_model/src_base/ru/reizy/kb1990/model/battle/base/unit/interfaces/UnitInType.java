package ru.reizy.kb1990.model.battle.base.unit.interfaces;

import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;

public interface UnitInType {

	int getCount();

	int getMorale();

	Hero getHero();

	int getСurrentHitPoints();

	void setCount(int i);

	void setСurrentHitPoints(int i);

	int getStartCount();

	UnitType getType();

}
