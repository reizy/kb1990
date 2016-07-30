package ru.reizy.kb1990.model.base.magic.globalmap;

import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.BridgeSpell;
import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.CastleGate;
import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.FindVillain;
import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.InstantArmySpell;
import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.RaiseControlSpell;
import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.TimeStopSpell;
import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.TownGate;
import ru.reizy.kb1990.model.base.magic.MagicBook;

public class TravelMagicBook extends MagicBook<TravelSpells> {

	public TravelMagicBook() {
		putSpell(BridgeSpell);
		putSpell(TimeStopSpell);
		putSpell(FindVillain);
		putSpell(CastleGate);
		putSpell(TownGate);
		putSpell(InstantArmySpell);
		putSpell(RaiseControlSpell);
	}

}
