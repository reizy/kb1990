package ru.reizy.kb1990.model.battle.magic.spells;

import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.BattleMagicBook;
import ru.reizy.kb1990.model.battle.magic.abstraction.AttackSpell;
import ru.reizy.kb1990.model.battle.magic.spells.events.FireballSpellUsedEvent;
import ru.reizy.kb1990.model.events.KBEvent;

public class FireballSpell extends AttackSpell {
	private static final int BASE_POWER = 25;

	public FireballSpell(BattleMagicBook battleMagicBook) {
		super(BASE_POWER, BattleSpells.FireballSpell, battleMagicBook);
	}

	@Override
	protected KBEvent createEvent(UnitInMagica unit, Cell cell, int dead) {
		return new FireballSpellUsedEvent(dead, this, unit, cell);
	}

}
