package ru.reizy.kb1990.model.globalmap.magic;

import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.events.TownTeleportEvent;

public class TownGateSpell extends MagicTravelSpell {

	protected TownGateSpell(TravelMagicBook book) {
		super(TravelSpells.TownGate, book);
	}

	public boolean use() {
		boolean b = false;
		if (reduse()) {
			GlobalPlayer p = getBook().getPlayer();
			p.onEvent(new TownTeleportEvent());
			b = true;
		}
		return b;
	}
}
