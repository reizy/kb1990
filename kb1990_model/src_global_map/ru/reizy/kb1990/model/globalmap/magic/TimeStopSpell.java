package ru.reizy.kb1990.model.globalmap.magic;

import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;

public class TimeStopSpell extends MagicTravelSpell {
	private static final int BASE_POWER = 10;

	protected TimeStopSpell(TravelMagicBook book) {
		super(BASE_POWER, TravelSpells.TimeStopSpell, book);
	}

	public boolean use() {
		boolean b = false;
		if (reduse()) {
			Player p = getBook().getPlayer().getHero();
			int sp = p.getSpellPower();
			int mp = p.getTempMovePoints();
			mp += sp * getBasePower();
			p.setTempMovePoints(mp);
			b = true;
		}
		return b;
	}
}
