package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.residence.Castle;

public class CastleActionEvent implements KBEvent {

	private Castle castle;

	public CastleActionEvent(Castle castle) {
		this.castle = castle;
	}

	public Castle getCastle() {
		return castle;
	}

}
