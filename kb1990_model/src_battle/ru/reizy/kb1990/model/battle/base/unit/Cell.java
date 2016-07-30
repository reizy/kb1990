package ru.reizy.kb1990.model.battle.base.unit;

public class Cell {
	private final int x;
	private final int y;
	private Unit content;

	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Cell() {
		this(0, 0);
	}

	public Cell(Cell p) {
		this(p.x, p.y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Unit getContent() {
		return content;
	}

	public void setContent(Unit content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Cell [x=" + x + ", y=" + y + "]";
	}

}
