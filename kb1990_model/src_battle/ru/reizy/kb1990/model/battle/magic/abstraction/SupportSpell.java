package ru.reizy.kb1990.model.battle.magic.abstraction;

import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.BattleMagicBook;

public abstract class SupportSpell extends MagicBattleSpell {

	protected SupportSpell(int basePower, BattleSpells type,
			BattleMagicBook book) {
		super(basePower, type, book);
	}

	@Override
	public boolean canBeAim(Cell cell) {
		UnitInMagica unit = cell.getContent();
		boolean b = isMyUnit(unit);
		return b;
	}
}
