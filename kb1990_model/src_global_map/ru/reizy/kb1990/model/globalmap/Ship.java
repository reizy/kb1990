package ru.reizy.kb1990.model.globalmap;

public final class Ship {

	private Cell cell;

	public Ship(Cell cell) {
		setCell(cell);
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public Cell getCell() {
		return cell;
	}

}
