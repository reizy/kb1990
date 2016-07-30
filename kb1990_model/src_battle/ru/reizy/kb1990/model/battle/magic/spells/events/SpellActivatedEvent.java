package ru.reizy.kb1990.model.battle.magic.spells.events;

import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.magic.abstraction.MagicBattleSpell;
import ru.reizy.kb1990.model.events.KBEvent;

public class SpellActivatedEvent implements KBEvent {

	private MagicBattleSpell spell;
	private Cell previousUnitCell;

	public SpellActivatedEvent(MagicBattleSpell spell, Cell previousUnitCell) {
		super();
		this.spell = spell;
		this.previousUnitCell = previousUnitCell;
	}

	public MagicBattleSpell getSpell() {
		return spell;
	}

	public Cell getPreviousUnitCell() {
		return previousUnitCell;
	}

}
