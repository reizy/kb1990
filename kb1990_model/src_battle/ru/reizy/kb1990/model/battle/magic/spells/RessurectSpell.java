package ru.reizy.kb1990.model.battle.magic.spells;

import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.MagicMark;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.BattleMagicBook;
import ru.reizy.kb1990.model.battle.magic.abstraction.SupportSpell;
import ru.reizy.kb1990.model.battle.magic.spells.events.RessurectSpellUsedEvent;

public class RessurectSpell extends SupportSpell {
	private static final int BASE_POWER = 1;

	public RessurectSpell(BattleMagicBook battleMagicBook) {
		super(BASE_POWER, BattleSpells.RessurectSpell, battleMagicBook);
	}

	@Override
	public boolean activate(MagicMark mark, Cell cell) {
		UnitInMagica unit = cell.getContent();
		int sp = getMagicanPower();
		int count = sp * getBasePower();
		if ((unit.getCount() + count) > unit.getStartCount()) {
			count = unit.getStartCount() - unit.getCount();
			unit.setСurrentHitPoints(unit.getType().getMaxHitPoints());
		}
		unit.setCount(unit.getCount() + count);
		showMagic(new RessurectSpellUsedEvent(count, this, unit, cell));
		return true;
	}

}
