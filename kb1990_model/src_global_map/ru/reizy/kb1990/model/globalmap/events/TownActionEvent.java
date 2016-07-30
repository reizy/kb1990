package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.events.ChangeCharacterEvent;
import ru.reizy.kb1990.model.globalmap.residence.Town;

public class TownActionEvent implements ChangeCharacterEvent {

	private Town town;

	public TownActionEvent(Town town) {
		this.town = town;
	}

	public Town getTown() {
		return town;
	}

}
