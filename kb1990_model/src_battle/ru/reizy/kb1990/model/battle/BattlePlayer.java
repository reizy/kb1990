package ru.reizy.kb1990.model.battle;

import java.util.Map;

import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;
import ru.reizy.kb1990.model.battle.magic.BattleMagicBook;
import ru.reizy.kb1990.model.battle.magic.Magican;
import ru.reizy.kb1990.model.events.BattleFinishListener;

public class BattlePlayer extends BattleHero implements Magican {
	private BattleMagicBook magicBook;

	public BattlePlayer(BattleFinishListener player, BattleModel battleModel) {
		super(player, battleModel);
		this.magicBook = new BattleMagicBook(this);
	}

	public BattleMagicBook getMagicBook() {
		return magicBook;
	}

	public Player getHero() {
		return (Player) super.getHero();
	}

	public boolean isMagicActive() {
		return getHero().isMagicActive();
	}

	@Override
	public void useMagic(BattleSpells spell) {
		getHero().useMagic(spell);
	}

	@Override
	public BattleHero getArmyHolder() {
		return this;
	}

	@Override
	public int getSpellPower() {
		return getHero().getSpellPower();
	}

	@Override
	public Map<BattleSpells, Integer> getBattleSpellCounts() {
		return getHero().getBattleMagicBook().getSpells();
	}

	@Override
	public void updateHero() {
		int k = 0;
		for (UnitInModel unit : getArmy()) {
			int id = getHero().getArmy().indexOf(unit.getType());
			int i = getHero().getArmyCount(id) - unit.getCount();
			if (i > 0) {
				k += i;
			}
		}
		getHero().addUnitsKilledCount(k);
		super.updateHero();
	}
}
