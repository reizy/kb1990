package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.events.ChangeCharacterEvent;

public class RemoveUnitEvent implements ChangeCharacterEvent {

	final private UnitType unit;
	final private int count;

	public RemoveUnitEvent(UnitType unit, int count) {
		super();
		this.unit = unit;
		this.count = count;
	}

	public UnitType getUnit() {
		return unit;
	}

	public int getCount() {
		return count;
	}

}
