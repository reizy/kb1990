package ru.reizy.kb1990.model.battle.magic;

import java.util.Map;

import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.BattleHero;

public interface Magican {

	boolean isMagicActive();

	void useMagic(BattleSpells spell);

	BattleHero getArmyHolder();

	int getSpellPower();

	Map<BattleSpells, Integer> getBattleSpellCounts();

}
