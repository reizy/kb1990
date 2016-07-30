package ru.reizy.kb1990.model.globalmap.magic;

import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.villains.Villain;

public class FindVillainSpell extends MagicTravelSpell {

	protected FindVillainSpell(TravelMagicBook book) {
		super(TravelSpells.FindVillain, book);
	}

	public boolean use() {
		boolean b = false;
		if (reduse()) {
			final GlobalPlayer player = getBook().getPlayer();
			Player p = player.getHero();
			Villain villain = p.getContract();
			if (villain != null) {
				Castle castle = villain.getCastle();
				player.checkCastleInfo(castle);
			}
			b = true;
		}
		return b;
	}
}
