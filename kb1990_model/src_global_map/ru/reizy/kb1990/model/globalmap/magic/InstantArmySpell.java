package ru.reizy.kb1990.model.globalmap.magic;

import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ARCHERS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ARCHMAGES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.CAVALRY;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.DRUIDS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ELVES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.GIANTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.GNOMES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.KNIGHTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.MILITIA;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.OGRES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.PEASANTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.PIKEMEN;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.SPRITES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.WOLVES;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.PlayerType;

public class InstantArmySpell extends MagicTravelSpell {
	private static final Logger log = LoggerFactory.getLogger(InstantArmySpell.class);
	private static final int BASE_POWER = 1;

	private static Map<PlayerType, UnitTypes[]> types = new HashMap<PlayerType, UnitTypes[]>();
	static { //
		UnitTypes[] types1 = { PEASANTS, MILITIA, ARCHERS, KNIGHTS };
		UnitTypes[] types2 = { MILITIA, ARCHERS, CAVALRY, ARCHMAGES };
		UnitTypes[] types3 = { SPRITES, GNOMES, ELVES, DRUIDS };
		UnitTypes[] types4 = { WOLVES, PIKEMEN, OGRES, GIANTS };
		types.put(PlayerType.KNIGHT, types1);
		types.put(PlayerType.PALADIN, types2);
		types.put(PlayerType.BARBARIAN, types3);
		types.put(PlayerType.SORCERESS, types4);
	}

	protected InstantArmySpell(TravelMagicBook book) {
		super(BASE_POWER, TravelSpells.InstantArmySpell, book);

	}

	public boolean use() {
		boolean b = false;
		if (reduse()) {
			Player p = getBook().getPlayer().getHero();
			int sp = p.getSpellPower();
			int r = 3 - p.getRank();
			if (r == 0) {
				r++;
			}
			int count = (sp + 1) * getBasePower() * (r);
			UnitTypes type = types.get(p.getType())[p.getRank()];
			if ((!p.isArmyFull()) || (p.getArmy().contains(type.getUnitType()))) {
				p.addToArmy(type, count);
				log.info("You summon " + count + " " + type);
				// TODO событие для вывода пользователю инфы
			} else {
				log.info("В армии нет слотов");
			}
			b = true;
		}
		return b;
	}

}
