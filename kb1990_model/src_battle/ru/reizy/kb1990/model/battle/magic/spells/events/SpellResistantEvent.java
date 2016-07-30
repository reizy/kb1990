package ru.reizy.kb1990.model.battle.magic.spells.events;

import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.abstraction.MagicBattleSpell;
import ru.reizy.kb1990.model.events.KBEvent;

public class SpellResistantEvent implements KBEvent {

	private MagicBattleSpell spell;
	private UnitInMagica unit;

	public SpellResistantEvent(MagicBattleSpell spell, UnitInMagica unit) {
		super();
		this.spell = spell;
		this.unit = unit;
	}

	public UnitInMagica getUnit() {
		return unit;
	}

	public MagicBattleSpell getSpell() {
		return spell;
	}

}
