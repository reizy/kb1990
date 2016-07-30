package ru.reizy.kb1990.model.globalmap;

public class Cell implements Comparable<Cell> {

	private static final int MAX_SIZE = (int) Math.sqrt(Math.sqrt(-((Integer.MIN_VALUE + 1) / 2 - 1)));
	private final int x;
	private final int y;
	private Content content;
	private final GlobalMap map;

	public Cell(int x, int y, GlobalMap map) {
		super();
		this.x = x;
		this.y = y;
		this.map = map;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public GlobalMap getMap() {
		return map;
	}

	public FieldType getFieldType() {
		return getMap().getFieldType(this);
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Cell{" + map.getId() + "}[" + x + "][" + y + "]";
	}

	@Override
	public int compareTo(Cell o) {
		final int mapid = (map != null) ? map.getId() : -1;
		final int omapid = (o.map != null) ? o.map.getId() : -1;
		int i = mapid * MAX_SIZE * MAX_SIZE + x * MAX_SIZE + y;
		int j = omapid * MAX_SIZE * MAX_SIZE + o.x * MAX_SIZE + o.y;
		return i - j;
	}
}
