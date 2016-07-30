package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.events.ChangeCharacterEvent;
import ru.reizy.kb1990.model.globalmap.treasure.Treasure;

public class TreasureActivateEvent implements ChangeCharacterEvent {
	private Treasure treasure;

	public TreasureActivateEvent(Treasure treasure) {
		this.treasure = treasure;
	}

	public Treasure getTreasure() {
		return treasure;
	}

}
