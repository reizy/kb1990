package ru.reizy.kb1990.model.globalmap;

public abstract class AbstractContent implements Content {

	private Cell cell;

	protected AbstractContent(Cell cell) {
		super();
		setCell(cell);
	}

	public Cell getCell() {
		return cell;
	}

	protected void setCell(Cell cell) {
		this.cell = cell;
		if (cell != null) {
			cell.setContent(this);
		}
	}

	public abstract boolean onActivate(GlobalPlayer player);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cell == null) ? 0 : cell.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractContent))
			return false;
		AbstractContent other = (AbstractContent) obj;
		if (cell == null) {
			if (other.cell != null)
				return false;
		} else if (!cell.equals(other.cell))
			return false;
		return true;
	}

}
