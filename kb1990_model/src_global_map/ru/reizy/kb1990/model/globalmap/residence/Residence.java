package ru.reizy.kb1990.model.globalmap.residence;

import ru.reizy.kb1990.model.globalmap.AbstractContent;
import ru.reizy.kb1990.model.globalmap.Cell;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Residence extends AbstractContent {
	private Cell outCell;

	public Residence(Cell cell) {
		super(cell);
	}

	public void setOutCell(Cell cell) {
		this.outCell = cell;
	}

	@JsonIgnore
	public Cell getOutCell() {
		return this.outCell;
	}

}
