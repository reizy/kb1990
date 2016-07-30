package ru.reizy.kb1990.model.battle.magic.spells;

import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.MagicMark;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.BattleMagicBook;
import ru.reizy.kb1990.model.battle.magic.abstraction.MagicBattleSpell;
import ru.reizy.kb1990.model.battle.magic.spells.events.TeleportSpellUsedEvent;

public class TeleportSpell extends MagicBattleSpell {
	private SubTeleportSpell subSpell;

	public TeleportSpell(BattleMagicBook battleMagicBook) {
		super(BattleSpells.TeleportSpell, battleMagicBook);
	}

	@Override
	public void prepair() {
		subSpell = new TargeeTeleportSpell();
	}

	@Override
	public boolean canBeAim(Cell cell) {
		return subSpell.canBeAim(cell);
	}

	@Override
	public boolean activate(MagicMark mark, Cell cell) {
		return subSpell.activate(mark, cell);
	}

	private abstract class SubTeleportSpell extends MagicBattleSpell {
		protected SubTeleportSpell() {
			super(null, null);
		}

		protected abstract boolean activate(MagicMark mark, Cell cell);
	}

	private class TargeeTeleportSpell extends SubTeleportSpell {

		public TargeeTeleportSpell() {
			super();
		}

		@Override
		protected boolean activate(MagicMark mark, Cell cell) {
			UnitInMagica unit = cell.getContent();
			TeleportSpell.this.subSpell = new ReleaseTeleportSpell(unit);
			return false;
		}

		@Override
		public boolean canBeAim(Cell cell) {
			UnitInMagica unit = cell.getContent();
			boolean b = isUnit(unit);
			return b;
		}
	}

	public class ReleaseTeleportSpell extends SubTeleportSpell {
		private final UnitInMagica unit;

		protected ReleaseTeleportSpell(UnitInMagica unit) {
			super();
			this.unit = unit;
		}

		@Override
		protected boolean activate(MagicMark mark, Cell cell) {
			Cell oldCell = unit.getLocation();
			unit.setLocation(cell);
			TeleportSpell.this.showMagic(new TeleportSpellUsedEvent(this, unit,
					oldCell));
			TeleportSpell.this.subSpell = null;
			return true;
		}

		@Override
		public boolean canBeAim(Cell cell) {
			UnitInMagica unit = cell.getContent();
			boolean b = !isUnit(unit);
			return b;
		}

	}

}
