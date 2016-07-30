package ru.reizy.kb1990.model.base.magic;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MagicBook<T extends MagicSpells> {

	private final Map<T, Integer> spells;

	protected MagicBook() {
		spells = new TreeMap<T, Integer>();
	}

	public boolean reduse(T spell) {
		boolean b = false;
		int count = spells.get(spell);
		if (count > 0) {
			count--;
			spells.put(spell, count);
			b = true;
		}
		return b;
	}

	public Map<T, Integer> getSpells() {
		return spells;
	}

	public void addSpell(T spell) {
		spells.put(spell, spells.get(spell) + 1);
	}

	@JsonIgnore
	public int getSpellsCount() {
		int c = 0;
		for (Entry<T, Integer> e : spells.entrySet()) {
			c += e.getValue();
		}
		return c;
	}

	protected final void putSpell(T spell) {
		spells.put(spell, 0);
	}

	@JsonIgnore
	public int getSize() {
		return spells.size();
	}
}
