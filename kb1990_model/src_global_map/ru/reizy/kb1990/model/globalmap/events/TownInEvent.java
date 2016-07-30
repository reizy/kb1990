package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.residence.Town;

public class TownInEvent implements KBEvent {

	private Town town;

	public TownInEvent(Town town) {
		this.town = town;
	}

	public Town getResidence() {
		return town;
	}

}
