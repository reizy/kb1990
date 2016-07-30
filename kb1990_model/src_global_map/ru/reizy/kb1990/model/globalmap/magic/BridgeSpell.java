package ru.reizy.kb1990.model.globalmap.magic;

import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;

public class BridgeSpell extends MagicTravelSpell {

	private static final int SPELL_POWER_NEEDED_FOR_ADITIONAL_BLOCK = 5;

	protected BridgeSpell(TravelMagicBook book) {
		super(TravelSpells.BridgeSpell, book);
	}

	public boolean use() {
		boolean b = false;
		if (reduse()) {
			int sp = getBasePower() + getBook().getPlayer().getHero().getSpellPower() / SPELL_POWER_NEEDED_FOR_ADITIONAL_BLOCK;
			getBook().getPlayer().setBrigeMaker(sp);
			b = true;
		}
		return b;
	}
}
