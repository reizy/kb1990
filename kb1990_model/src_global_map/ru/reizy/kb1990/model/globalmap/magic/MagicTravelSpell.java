package ru.reizy.kb1990.model.globalmap.magic;

import ru.reizy.kb1990.model.base.magic.MagicSpell;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;

public abstract class MagicTravelSpell extends MagicSpell {
	private final TravelMagicBook book;
	private final int basePower;

	protected MagicTravelSpell(int basePower, TravelSpells type,
			TravelMagicBook book) {
		super(type);
		this.book = book;
		this.basePower = basePower;
	}

	protected MagicTravelSpell(TravelSpells type, TravelMagicBook book) {
		this(1, type, book);
	}

	public TravelMagicBook getBook() {
		return book;
	}

	public int getBasePower() {
		return basePower;
	}

	public abstract boolean use();

	@Override
	public TravelSpells getType() {
		return (TravelSpells) super.getType();
	}

	protected boolean reduse() {
		return getBook().reduse(getType());
	}
}