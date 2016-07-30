package ru.reizy.kb1990.model.globalmap.magic;

import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;

public class RaiseControlSpell extends MagicTravelSpell {
	private static final int BASE_POWER = 100;

	protected RaiseControlSpell(TravelMagicBook book) {
		super(BASE_POWER, TravelSpells.RaiseControlSpell, book);
	}

	public boolean use() {
		boolean b = false;
		if (reduse()) {
			Player p = getBook().getPlayer().getHero();
			int sp = p.getSpellPower();
			int //lead = p.getTempLeadership();
			lead = sp * getBasePower();
			p.setTempLeadership(lead);
			b = true;
		}
		return b;
	}
}
