package ru.reizy.kb1990.model.globalmap.magic;

import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.BridgeSpell;
import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.CastleGate;
import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.FindVillain;
import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.InstantArmySpell;
import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.RaiseControlSpell;
import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.TimeStopSpell;
import static ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells.TownGate;

import java.util.HashMap;
import java.util.Map;

import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;

public class TravelMagicBook {
	public final Map<TravelSpells, MagicTravelSpell> battleSpells = new HashMap<TravelSpells, MagicTravelSpell>();
	private GlobalPlayer player;

	public TravelMagicBook(GlobalPlayer player) {
		this.player = player;
		battleSpells.put(BridgeSpell, new BridgeSpell(this));
		battleSpells.put(TimeStopSpell, new TimeStopSpell(this));
		battleSpells.put(FindVillain, new FindVillainSpell(this));
		battleSpells.put(CastleGate, new CastleGateSpell(this));
		battleSpells.put(TownGate, new TownGateSpell(this));
		battleSpells.put(InstantArmySpell, new InstantArmySpell(this));
		battleSpells.put(RaiseControlSpell, new RaiseControlSpell(this));
	}

	public MagicTravelSpell get(TravelSpells spellType) {
		return battleSpells.get(spellType);
	}

	public GlobalPlayer getPlayer() {
		return player;
	}

	public boolean reduse(TravelSpells spell) {
		return player.getHero().getTravelMagicBook().reduse(spell);
	}

}
