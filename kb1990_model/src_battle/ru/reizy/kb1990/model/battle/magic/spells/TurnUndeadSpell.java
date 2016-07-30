package ru.reizy.kb1990.model.battle.magic.spells;

import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.MagicMark;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UndeadUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.BattleMagicBook;
import ru.reizy.kb1990.model.battle.magic.abstraction.AttackSpell;
import ru.reizy.kb1990.model.battle.magic.spells.events.TurnUndeadSpellUsedEvent;
import ru.reizy.kb1990.model.events.KBEvent;

public class TurnUndeadSpell extends AttackSpell {
	private static final int BASE_POWER = 50;

	public TurnUndeadSpell(BattleMagicBook battleMagicBook) {
		super(BASE_POWER, BattleSpells.TurnUndeadSpell, battleMagicBook);
	}

	@Override
	protected boolean checkResistant(MagicMark mark,
			ru.reizy.kb1990.model.battle.base.unit.Cell cell) {
		boolean resistant = super.checkResistant(mark, cell);
		UnitInMagica unit = cell.getContent();
		resistant = resistant || !(unit.getType() instanceof UndeadUnit);
		return resistant;
	}

	@Override
	protected KBEvent createEvent(UnitInMagica unit, Cell cell, int dead) {
		return new TurnUndeadSpellUsedEvent(dead, this, unit, cell);
	}
}
