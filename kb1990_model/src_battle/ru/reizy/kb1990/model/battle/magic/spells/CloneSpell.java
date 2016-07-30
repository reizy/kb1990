package ru.reizy.kb1990.model.battle.magic.spells;

import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.MagicMark;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.BattleMagicBook;
import ru.reizy.kb1990.model.battle.magic.abstraction.SupportSpell;
import ru.reizy.kb1990.model.battle.magic.spells.events.CloneSpellUsedEvent;

public class CloneSpell extends SupportSpell {
	private static final int BASE_POWER = 10;

	public CloneSpell(BattleMagicBook battleMagicBook) {
		super(BASE_POWER, BattleSpells.CloneSpell, battleMagicBook);
	}

	@Override
	protected boolean activate(MagicMark mark, Cell cell) {
		UnitInMagica unit = cell.getContent();
		int hp = unit.getСurrentHitPoints();
		hp += getMagicanPower() * getBasePower();
		hp--;
		int count = hp / unit.getType().getMaxHitPoints();
		hp %= unit.getType().getMaxHitPoints();
		hp++;
		unit.setCount(unit.getCount() + count);
		unit.setСurrentHitPoints(hp);
		if (unit.getCount() > unit.getStartCount()) {
			unit.setStartCount(unit.getCount());
		}
		showMagic(new CloneSpellUsedEvent(count, this, unit));
		return true;
	}

	
}
