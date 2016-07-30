package ru.reizy.kb1990.model.battle.magic.abstraction;

import ru.reizy.kb1990.model.base.magic.MagicSpell;
import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.BattleHero;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.MagicMark;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.MagicImuneUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.BattleMagicBook;
import ru.reizy.kb1990.model.battle.magic.Magican;
import ru.reizy.kb1990.model.battle.magic.spells.events.SpellResistantEvent;
import ru.reizy.kb1990.model.events.KBEvent;

public abstract class MagicBattleSpell extends MagicSpell {
	private final BattleMagicBook book;
	private final int basePower;

	protected MagicBattleSpell(int basePower, BattleSpells type,
			BattleMagicBook battleMagicBook) {
		super(type);
		this.book = battleMagicBook;
		this.basePower = basePower;
	}

	protected MagicBattleSpell(BattleSpells type, BattleMagicBook book) {
		this(1, type, book);
	}

	public BattleMagicBook getBook() {
		return book;
	}

	public final int getBasePower() {
		return basePower;
	}

	public final int getMagicanPower() {
		return getBook().getMagican().getSpellPower();
	}

	public abstract boolean canBeAim(Cell cell);

	/**
	 * Try to use magic
	 * 
	 * @param mark magic mark in battle model
	 * @param cell target cell
	 * @return true if (target can be an aim & spell was activated
	 */
	public final boolean use(MagicMark mark, Cell cell) {
		boolean used = false;
		if (canBeAim(cell)) {
			boolean resistant = checkResistant(mark, cell);
			if (!resistant) {
				used = activate(mark, cell);
			} else {
				showMagic(new SpellResistantEvent(this, cell.getContent()));
				used = true;
			}
		}
		if (used) {
			reduseFromMagicBook();
		}
		return used;
	}

	protected boolean checkResistant(MagicMark mark, Cell cell) {
		Boolean resistant = true;
		UnitInMagica unit = cell.getContent();
		if (unit == null) {
			resistant = false;
		} else {
			resistant = (unit.getType() instanceof MagicImuneUnit);
		}
		return resistant;
	}

	protected abstract boolean activate(MagicMark mark, Cell cell);

	@Override
	public final BattleSpells getType() {
		return (BattleSpells) super.getType();
	}

	private void reduseFromMagicBook() {
		getBook().reduse(getType());
	}

	protected final void showMagic(KBEvent e) {
		getBook().showMagic(e);
	}

	protected final boolean canBeAttacted(UnitInMagica unit) {
		boolean b = isUnit(unit);
		b = b && (!isMyUnit(unit) || (unit.isOutOfControl()));
		return b;
	}

	protected final boolean isMyUnit(UnitInMagica unit) {
		boolean b = isUnit(unit);
		if (b) {
			final BattleHero unitHero = unit.getBattleHero();
			final Magican magican = getBook().getMagican();
			final BattleHero magicanHero = magican.getArmyHolder();
			b = (unitHero == magicanHero);
		}
		return b;
	}

	protected final boolean isUnit(UnitInMagica unit) {
		boolean b = true;
		b = b && (unit != null);
		return b;
	}

	public void prepair() {
	}
}
