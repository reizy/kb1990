package ru.reizy.kb1990.model.battle.magic.spells;

import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.MagicMark;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.BattleMagicBook;
import ru.reizy.kb1990.model.battle.magic.abstraction.MagicBattleSpell;
import ru.reizy.kb1990.model.battle.magic.spells.events.FreezeSpellUsedEvent;

public class FreezeSpell extends MagicBattleSpell {

	public FreezeSpell(BattleMagicBook book) {
		super(BattleSpells.FreezeSpell, book);
	}

	@Override
	public boolean activate(MagicMark mark, Cell cell) {
		UnitInMagica unit = cell.getContent();
		unit.setFreesed(2);
		showMagic(new FreezeSpellUsedEvent(this, unit));
		return true;
	}

	@Override
	public boolean canBeAim(Cell cell) {
		UnitInMagica unit = cell.getContent();
		boolean b = canBeAttacted(unit);
		return b;
	}
}
