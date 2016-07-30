package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.residence.KingCastle;

public class KingCastleInEvent implements KBEvent {

	private KingCastle castle;

	public KingCastleInEvent(KingCastle kingCastle) {
		this.castle = kingCastle;
	}

	public KingCastle getCastle() {
		return castle;
	}

}
