package ru.reizy.kb1990.model.base.artifact;

import ru.reizy.kb1990.model.base.PasleElement;
import ru.reizy.kb1990.model.base.Player;

public abstract class DefaultPasleElement implements PasleElement {

	private final int pasleX;
	private final int pasleY;

	DefaultPasleElement(int pasleX, int pasleY) {
		super();
		this.pasleX = pasleX;
		this.pasleY = pasleY;
	}

	@Override
	public void activate(Player player) {
		player.addPasleElement(this);
	}

	@Override
	public int getPasleX() {
		return pasleX;
	}

	@Override
	public int getPasleY() {
		return pasleY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pasleX;
		result = prime * result + pasleY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultPasleElement other = (DefaultPasleElement) obj;
		if (pasleX != other.pasleX)
			return false;
		if (pasleY != other.pasleY)
			return false;
		return true;
	}

}
