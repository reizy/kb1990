package ru.reizy.kb1990.model.battle.magic.abstraction;

import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.MagicMark;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.MagicImuneUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.BattleMagicBook;
import ru.reizy.kb1990.model.events.KBEvent;

public abstract class AttackSpell extends MagicBattleSpell {

	protected AttackSpell(int basePower, BattleSpells type, BattleMagicBook book) {
		super(basePower, type, book);
	}

	protected boolean activate(MagicMark mark, Cell cell) {
		UnitInMagica unit = cell.getContent();
		Boolean used = false;
		if (canBeAim(cell)) {
			int sp = getMagicanPower();
			int a = -1;
			int dead = 0;
			if (!(unit.getType() instanceof MagicImuneUnit)) {
				a = sp * getBasePower();
				dead = unit.defence(null, a);

			}
			showMagic(createEvent(unit, cell, dead));
			used = true;
		}
		return used;
	}

	protected abstract KBEvent createEvent(UnitInMagica unit, Cell cell,
			int dead);

	@Override
	public boolean canBeAim(Cell cell) {
		UnitInMagica unit = cell.getContent();
		boolean b = canBeAttacted(unit);
		return b;
	}
}
