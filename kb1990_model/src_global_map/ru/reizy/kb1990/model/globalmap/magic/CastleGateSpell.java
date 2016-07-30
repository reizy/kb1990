package ru.reizy.kb1990.model.globalmap.magic;

import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.events.CastleTeleportEvent;

public class CastleGateSpell extends MagicTravelSpell {

	protected CastleGateSpell(TravelMagicBook book) {
		super(TravelSpells.CastleGate, book);
	}

	public boolean use() {
		boolean b = false;
		if (reduse()) {
			GlobalPlayer p = getBook().getPlayer();
			p.onEvent(new CastleTeleportEvent());
			b = true;
		}
		return b;
	}
}
