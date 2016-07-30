package ru.reizy.kb1990.model.battle.magic.spells;

import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.BattleMagicBook;
import ru.reizy.kb1990.model.battle.magic.abstraction.AttackSpell;
import ru.reizy.kb1990.model.battle.magic.spells.events.LightingBoltSpellUsedEvent;
import ru.reizy.kb1990.model.events.KBEvent;

public final class LightingBoltSpell extends AttackSpell {
	private static final int BASE_POWER = 10;

	public LightingBoltSpell(BattleMagicBook battleMagicBook) {
		super(BASE_POWER, BattleSpells.LightingBoltSpell, battleMagicBook);
	}

	@Override
	protected KBEvent createEvent(UnitInMagica unit, Cell cell, int dead) {
		return new LightingBoltSpellUsedEvent(dead, this, unit, cell);
	}

}
