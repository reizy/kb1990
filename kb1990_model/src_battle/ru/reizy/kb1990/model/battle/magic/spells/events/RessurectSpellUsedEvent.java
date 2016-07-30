package ru.reizy.kb1990.model.battle.magic.spells.events;

import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.abstraction.MagicBattleSpell;
import ru.reizy.kb1990.model.events.KBEvent;

public class RessurectSpellUsedEvent implements KBEvent {

	private int count;
	private MagicBattleSpell spell;
	private UnitInMagica unit;
	private Cell cell;

	public RessurectSpellUsedEvent(int count, MagicBattleSpell spell,
			UnitInMagica unit, Cell cell) {
		super();
		this.count = count;
		this.spell = spell;
		this.unit = unit;
		this.cell = cell;
	}

	public UnitInMagica getUnit() {
		return unit;
	}

	public MagicBattleSpell getSpell() {
		return spell;
	}

	public int getCount() {
		return count;
	}

	public Cell getCell() {
		return cell;
	}
}
