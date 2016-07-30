package ru.reizy.kb1990.model.base.magic;

public abstract class MagicSpell {

	private MagicSpells type;

	protected MagicSpell(MagicSpells type) {
		super();
		this.type = type;
	}

	public MagicSpells getType() {
		return type;
	}

}
