package ru.reizy.kb1990.model.battle.magic;

import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.CloneSpell;
import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.FireballSpell;
import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.FreezeSpell;
import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.LightingBoltSpell;
import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.RessurectSpell;
import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.TeleportSpell;
import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.TurnUndeadSpell;

import java.util.HashMap;
import java.util.Map;

import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.magic.abstraction.MagicBattleSpell;
import ru.reizy.kb1990.model.battle.magic.spells.CloneSpell;
import ru.reizy.kb1990.model.battle.magic.spells.FireballSpell;
import ru.reizy.kb1990.model.battle.magic.spells.FreezeSpell;
import ru.reizy.kb1990.model.battle.magic.spells.LightingBoltSpell;
import ru.reizy.kb1990.model.battle.magic.spells.RessurectSpell;
import ru.reizy.kb1990.model.battle.magic.spells.TeleportSpell;
import ru.reizy.kb1990.model.battle.magic.spells.TurnUndeadSpell;
import ru.reizy.kb1990.model.events.KBEvent;

public class BattleMagicBook {
	public final Map<BattleSpells, MagicBattleSpell> battleSpells = new HashMap<BattleSpells, MagicBattleSpell>();
	private Magican magican;
	private boolean active;

	public BattleMagicBook(Magican magican) {
		this.magican = magican;
		// TODO fill from magican book
		battleSpells.put(CloneSpell, new CloneSpell(this));
		battleSpells.put(TeleportSpell, new TeleportSpell(this));
		battleSpells.put(FireballSpell, new FireballSpell(this));
		battleSpells.put(LightingBoltSpell, new LightingBoltSpell(this));
		battleSpells.put(FreezeSpell, new FreezeSpell(this));
		battleSpells.put(RessurectSpell, new RessurectSpell(this));
		battleSpells.put(TurnUndeadSpell, new TurnUndeadSpell(this));
		active = magican.isMagicActive();
	}

	public MagicBattleSpell get(BattleSpells spellType) {
		return battleSpells.get(spellType);
	}

	public void reduse(BattleSpells spell) {
		magican.useMagic(spell);
		active = false;
	}

	public boolean isActive() {
		return active;
	}

	public void refreshMagic() {
		active = magican.isMagicActive();
	}

	public Magican getMagican() {
		return magican;
	}

	public int getSize() {
		return battleSpells.size();
	}

	public Map<BattleSpells, Integer> getBattleSpellCounts() {
		return magican.getBattleSpellCounts();
	}

	public void showMagic(KBEvent e) {
		getMagican().getArmyHolder().getBattleModel().onEvent(e);
	}

}
