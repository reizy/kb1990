package ru.reizy.kb1990.model.globalmap.residence;

import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.Cell;

public abstract class UnitResidence extends Residence {

	public UnitResidence(Cell cell) {
		super(cell);
	}

	public abstract UnitTypes getUnit();

}
