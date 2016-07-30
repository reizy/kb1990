package ru.reizy.kb1990.model.events;

import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;

public class BattleUnitMoveEvent implements KBEvent {

	private final Cell from;
	private final UnitInModel activeUnit;

	public BattleUnitMoveEvent(Cell from, UnitInModel activeUnit) {
		this.from = from;
		this.activeUnit = activeUnit;
	}

	/**
	 * @return the from
	 */
	public Cell getFrom() {
		return from;
	}

	/**
	 * @return the activeUnit
	 */
	public UnitInModel getActiveUnit() {
		return activeUnit;
	}

}
