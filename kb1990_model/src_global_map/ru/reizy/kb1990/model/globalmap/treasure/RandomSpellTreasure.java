package ru.reizy.kb1990.model.globalmap.treasure;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.base.magic.MagicSpells;
import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//Вы захватили кучу 
//негодяев, тероризировав-
//ших окрестности.
//В обмен на их освобож-
//дение вы получили выкуп:
//	

//1)
//2)	2 святая вода заклн. (2*2000)
//		1 градврата (1*500)
//3)	1 - клон (1*2000)
//		1 - телепорт (1*500)
//4)
public class RandomSpellTreasure extends Treasure {
	private static final Logger log = LoggerFactory
			.getLogger(RandomSpellTreasure.class);
	private final Map<MagicSpells, Integer> spells;

	@JsonCreator
	private RandomSpellTreasure(@JsonProperty("cell") Cell cell,
			@JsonProperty("power") int power,
			@JsonProperty("spells") Map<String, Integer> spells) {
		super(cell);
		this.power = power;

		this.spells = new HashMap<MagicSpells, Integer>();
		for (String spellName : spells.keySet()) {
			MagicSpells spell = TravelSpells.valueByName(spellName);
			if (spell == null) {
				spell = BattleSpells.valueByName(spellName);
			}
			this.spells.put(spell, spells.get(spellName));
		}

	}

	public RandomSpellTreasure(int power, Cell cell) {
		super(cell);
		this.power = 50 * ((10 + 15 * power) + RANDOM.nextInt(10 + 15 * power));
		int sum = this.power;
		Map<MagicSpells, Integer> sp = new HashMap<MagicSpells, Integer>();
		while (sum > 0) {
			final MagicSpells spell = getRandomSpell(sp);
			Integer k = sp.get(spell);
			sp.put(spell, k == null ? 1 : k + 1);
			sum -= spell.getCost();
		}
		spells = Collections.unmodifiableMap(sp);
	}

	private MagicSpells getRandomSpell() {
		int n = TravelSpells.values().length + BattleSpells.values().length;
		int x = RANDOM.nextInt(n);
		MagicSpells spell;
		if (x >= TravelSpells.values().length) {
			x -= TravelSpells.values().length;
			spell = BattleSpells.values()[x];
		} else {
			spell = TravelSpells.values()[x];
		}
		return spell;
	}

	private MagicSpells getRandomSpell(Map<MagicSpells, Integer> sp) {
		MagicSpells spell;
		if (sp.size() < 3) {
			spell = getRandomSpell();
		} else {
			int x = RANDOM.nextInt(sp.size());
			spell = (MagicSpells) sp.keySet().toArray()[x];
		}
		return spell;
	}

	@Override
	protected void activateTreashure(GlobalPlayer player) {
		log.info("You activate random spell treasure: " + toString());
		for (Entry<MagicSpells, Integer> spellEntry : spells.entrySet()) {
			MagicSpells spell = spellEntry.getKey();
			for (int i = 0; i < spellEntry.getValue(); i++) {
				player.getHero().addSpell(spell);
			}
		}
	}

	public Map<MagicSpells, Integer> getSpells() {
		return spells;
	}

	@Override
	public String toString() {
		String s = "RandomSpellTreasure(" + power + "): [";
		boolean b = false;
		for (Entry<MagicSpells, Integer> spellEntry : spells.entrySet()) {
			if (b) {
				s += "; ";
			}
			b = true;
			MagicSpells spell = spellEntry.getKey();
			int k = spellEntry.getValue();
			s += spell + ":" + k;
		}
		s += "]";
		return s;
	}
}
