package ru.reizy.kb1990.model.battle.base.unit;

import ru.reizy.kb1990.model.battle.BattleHero;
import ru.reizy.kb1990.model.battle.magic.abstraction.MagicBattleSpell;

public class MagicMark extends MarkUnit {
	private MagicBattleSpell spell;
	private MagicMarkType type;

	public MagicMark(MagicBattleSpell spell) {
		super();
		this.spell = spell;
		type = new MagicMarkType(spell);
	}

	@Override
	public UnitType getType() {
		return type;
	}

	public MagicBattleSpell getSpell() {
		return spell;
	}
	
	@Override
	public boolean isEnemy() {
		return false;
	}
	
	@Override
	public BattleHero getBattleHero() {
		return spell.getBook().getMagican().getArmyHolder();
	}
}
