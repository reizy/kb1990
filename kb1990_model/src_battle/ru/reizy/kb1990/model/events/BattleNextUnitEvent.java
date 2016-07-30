package ru.reizy.kb1990.model.events;

import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;

public class BattleNextUnitEvent implements KBEvent {

	private final UnitInModel prevUnit;
	private final UnitInModel activeUnit;

	public BattleNextUnitEvent( UnitInModel prevUnit, UnitInModel activeUnit) {
		this.prevUnit = prevUnit;
		this.activeUnit = activeUnit;
	}

	/**
	 * @return the from
	 */
	public UnitInModel getPrevUnit() {
		return prevUnit;
	}

	/**
	 * @return the activeUnit
	 */
	public UnitInModel getActiveUnit() {
		return activeUnit;
	}

}
