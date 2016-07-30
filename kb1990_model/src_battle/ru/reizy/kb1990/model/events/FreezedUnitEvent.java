package ru.reizy.kb1990.model.events;

import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;

public class FreezedUnitEvent implements KBEvent {

	private final UnitInModel activeUnit;

	public FreezedUnitEvent(UnitInModel activeUnit) {
		this.activeUnit = activeUnit;
	}


	/**
	 * @return the activeUnit
	 */
	public UnitInModel getActiveUnit() {
		return activeUnit;
	}

}
