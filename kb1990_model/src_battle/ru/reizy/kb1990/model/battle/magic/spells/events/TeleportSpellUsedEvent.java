package ru.reizy.kb1990.model.battle.magic.spells.events;

import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.abstraction.MagicBattleSpell;
import ru.reizy.kb1990.model.events.KBEvent;

public class TeleportSpellUsedEvent implements KBEvent {

	private Cell cell;
	private MagicBattleSpell spell;
	private UnitInMagica unit;

	public TeleportSpellUsedEvent(MagicBattleSpell spell, UnitInMagica unit,
			Cell oldCell) {
		super();
		this.cell = oldCell;
		this.spell = spell;
		this.unit = unit;
	}

	public UnitInMagica getUnit() {
		return unit;
	}

	public MagicBattleSpell getSpell() {
		return spell;
	}

	public Cell getCell() {
		return cell;
	}

}
