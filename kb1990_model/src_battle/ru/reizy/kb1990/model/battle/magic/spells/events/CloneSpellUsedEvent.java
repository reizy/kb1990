package ru.reizy.kb1990.model.battle.magic.spells.events;

import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.abstraction.MagicBattleSpell;
import ru.reizy.kb1990.model.events.KBEvent;

public class CloneSpellUsedEvent implements KBEvent {

	private int count;
	private MagicBattleSpell spell;
	private UnitInMagica unit;

	public CloneSpellUsedEvent(int count, MagicBattleSpell spell,
			UnitInMagica unit) {
		super();
		this.count = count;
		this.spell = spell;
		this.unit = unit;
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

}
