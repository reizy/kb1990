package ru.reizy.kb1990.model.battle.base.unit;

import ru.reizy.kb1990.model.battle.magic.abstraction.MagicBattleSpell;

public class MagicMarkType extends UnitType {
	private MagicBattleSpell spell;

	protected MagicMarkType(MagicBattleSpell spell) {
		super(0, 0, 0, 0, 0, 0, 0, 0, 0);
		this.spell = spell;
	}

	public MagicBattleSpell getSpell() {
		return spell;
	}

}
