package ru.reizy.kb1990.model.base.magic.globalmap;

import ru.reizy.kb1990.model.base.magic.MagicSpells;

public enum TravelSpells implements MagicSpells {
	BridgeSpell(100), //
	TimeStopSpell(200), //
	FindVillain(1000), //
	CastleGate(1000), //
	TownGate(500), //
	InstantArmySpell(1000), //
	RaiseControlSpell(500);

	private final int cost;

	private TravelSpells(int cost) {
		this.cost = cost;
	}

	@Override
	public int getCost() {
		return cost;
	}

	public static TravelSpells valueByName(String name) {
		for (int i = 0; i < values().length; i++) {
			if (values()[i].name().equals(name)) {
				return values()[i];
			}
		}
		return null;
	}
}
