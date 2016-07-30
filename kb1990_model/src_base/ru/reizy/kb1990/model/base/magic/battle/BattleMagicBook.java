package ru.reizy.kb1990.model.base.magic.battle;

import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.CloneSpell;
import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.FireballSpell;
import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.FreezeSpell;
import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.LightingBoltSpell;
import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.RessurectSpell;
import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.TeleportSpell;
import static ru.reizy.kb1990.model.base.magic.battle.BattleSpells.TurnUndeadSpell;
import ru.reizy.kb1990.model.base.magic.MagicBook;

public class BattleMagicBook extends MagicBook<BattleSpells>{

	public BattleMagicBook() {
		putSpell(CloneSpell);
		putSpell(TeleportSpell);
		putSpell(FireballSpell);
		putSpell(LightingBoltSpell);
		putSpell(FreezeSpell);
		putSpell(RessurectSpell);
		putSpell(TurnUndeadSpell);
	}

}
