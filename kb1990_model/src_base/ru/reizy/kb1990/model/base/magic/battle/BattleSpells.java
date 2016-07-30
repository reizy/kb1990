package ru.reizy.kb1990.model.base.magic.battle;

import ru.reizy.kb1990.model.base.magic.MagicSpells;

public enum BattleSpells implements MagicSpells {
	CloneSpell(2000), //
	TeleportSpell(500), //
	FireballSpell(1500), //
	LightingBoltSpell(500), //
	FreezeSpell(300), //
	RessurectSpell(5000), //
	TurnUndeadSpell(2000);//

	private final int cost;

	private BattleSpells(int cost) {
		this.cost = cost;
	}

	@Override
	public int getCost() {
		return cost;
	}

	public static BattleSpells valueByName(String name) {
		for (int i = 0; i < values().length; i++) {
			if (values()[i].name().equals(name)) {
				return values()[i];
			}
		}
		return null;
	}
}
