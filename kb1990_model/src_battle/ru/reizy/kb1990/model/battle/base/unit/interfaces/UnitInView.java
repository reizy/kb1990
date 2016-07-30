package ru.reizy.kb1990.model.battle.base.unit.interfaces;

import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;

public interface UnitInView {

	Cell getLocation();

	boolean isEnemy();

	UnitType getType();

	int getCount();

	int getMP();

	void setLocation(Cell p2);

	int getMorale();

	public boolean isOutOfControl();

	int getСurrentHitPoints();
}
