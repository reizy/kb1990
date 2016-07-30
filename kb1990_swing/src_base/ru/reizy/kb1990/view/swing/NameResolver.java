package ru.reizy.kb1990.view.swing;

import static ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType.CASTLE;
import static ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType.DUNGEON;
import static ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType.FOREST;
import static ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType.HILLS;
import static ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType.PLAINS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ARCHERS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ARCHMAGES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.BARBARIANS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.CAVALRY;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.DEMONS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.DRAGONS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.DRUIDS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.DWARVES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ELVES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.GHOSTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.GIANTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.GNOMES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.KNIGHTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.MILITIA;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.NOMADS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.OGRES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ORCS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.PEASANTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.PIKEMEN;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.SKELETONS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.SPRITES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.TROLLS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.VAMPIRES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.WOLVES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ZOMBIES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CONTINENTS_NAMES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.COUNTS_NAMES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.MORALE_HIGH;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.MORALE_LOW;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.MORALE_NORM;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NAME_CASTLE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NAME_DUNGEON;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NAME_FOREST;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NAME_HILLS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NAME_PLAINS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_BATTLE_CLONE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_BATTLE_FIREBALL;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_BATTLE_FREEZE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_BATTLE_LIGHTING_BOLT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_BATTLE_RESSURECT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_BATTLE_TELEPORT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_BATTLE_TURN_UNDEAD;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_TRAVEL_BRIDGE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_TRAVEL_CASTLE_GATE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_TRAVEL_FIND_VILLAIN;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_TRAVEL_INSTANT_ARMY;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_TRAVEL_RAISE_CONTROL;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_TRAVEL_TIME_STOP;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SPELL_TRAVEL_TOWN_GATE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TITLES_BARBARIAN;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TITLES_KNIGHT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TITLES_PALADIN;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TITLES_SORCERESS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_ARCHERS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_ARCHMAGES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_BARBARIANS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_CAVALRY;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_DEMONS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_DRAGONS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_DRUIDS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_DWARVES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_ELVES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_GHOSTS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_GIANTS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_GNOMES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_KNIGHTS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_MILITIA;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_NOMADS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_OGRES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_ORCS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_PEASANTS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_PIKEMEN;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_SKELETONS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_SPRITES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_TROLLS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_VAMPIRES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_WOLVES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNIT_NAME_ZOMBIES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNKNOWN;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.UNKNOWN_CASTLE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import ru.reizy.kb1990.model.base.magic.MagicSpell;
import ru.reizy.kb1990.model.base.magic.MagicSpells;
import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.PlayerType;
import ru.reizy.kb1990.model.globalmap.residence.Castle;

public class NameResolver {
	private static final Map<UnitTypes, String> units = new HashMap<UnitTypes, String>();
	private static final Map<PlayerType, String[]> titles = new TreeMap<PlayerType, String[]>();
	private static final List<String> morales = new ArrayList<String>();
	private static final Map<TravelSpells, String> magicT = new HashMap<TravelSpells, String>();
	private static final Map<BattleSpells, String> magicB = new HashMap<BattleSpells, String>();
	private static final List<String> continents = new ArrayList<String>();
	private static final Map<Integer, String> counts = new TreeMap<Integer, String>();
	private static final Map<UnitsResidenceType, String> residence = new TreeMap<UnitsResidenceType, String>();
	static {
		{
			units.put(ARCHERS, UNIT_NAME_ARCHERS);
			units.put(ARCHMAGES, UNIT_NAME_ARCHMAGES);
			units.put(BARBARIANS, UNIT_NAME_BARBARIANS);
			units.put(CAVALRY, UNIT_NAME_CAVALRY);
			units.put(DEMONS, UNIT_NAME_DEMONS);
			units.put(DRAGONS, UNIT_NAME_DRAGONS);
			units.put(DRUIDS, UNIT_NAME_DRUIDS);
			units.put(DWARVES, UNIT_NAME_DWARVES);
			units.put(ELVES, UNIT_NAME_ELVES);
			units.put(GHOSTS, UNIT_NAME_GHOSTS);
			units.put(GIANTS, UNIT_NAME_GIANTS);
			units.put(GNOMES, UNIT_NAME_GNOMES);
			units.put(KNIGHTS, UNIT_NAME_KNIGHTS);
			units.put(MILITIA, UNIT_NAME_MILITIA);
			units.put(NOMADS, UNIT_NAME_NOMADS);
			units.put(OGRES, UNIT_NAME_OGRES);
			units.put(ORCS, UNIT_NAME_ORCS);
			units.put(PEASANTS, UNIT_NAME_PEASANTS);
			units.put(PIKEMEN, UNIT_NAME_PIKEMEN);
			units.put(SKELETONS, UNIT_NAME_SKELETONS);
			units.put(SPRITES, UNIT_NAME_SPRITES);
			units.put(TROLLS, UNIT_NAME_TROLLS);
			units.put(VAMPIRES, UNIT_NAME_VAMPIRES);
			units.put(WOLVES, UNIT_NAME_WOLVES);
			units.put(ZOMBIES, UNIT_NAME_ZOMBIES);
		}
		{
			residence.put(PLAINS/*-*/, RESIDENCE_NAME_PLAINS);
			residence.put(DUNGEON/**/, RESIDENCE_NAME_DUNGEON);
			residence.put(FOREST/*-*/, RESIDENCE_NAME_FOREST);
			residence.put(HILLS/*--*/, RESIDENCE_NAME_HILLS);
			residence.put(CASTLE/*-*/, RESIDENCE_NAME_CASTLE);
		}
		{
			titles.put(PlayerType.KNIGHT, TITLES_KNIGHT);
			titles.put(PlayerType.PALADIN, TITLES_PALADIN);
			titles.put(PlayerType.BARBARIAN, TITLES_BARBARIAN);
			titles.put(PlayerType.SORCERESS, TITLES_SORCERESS);
		}
		{
			morales.add(MORALE_LOW);
			morales.add(MORALE_NORM);
			morales.add(MORALE_HIGH);
		}
		{
			continents.addAll(Arrays.asList(CONTINENTS_NAMES));
		}
		{
			magicT.put(TravelSpells.BridgeSpell, SPELL_TRAVEL_BRIDGE);
			magicT.put(TravelSpells.TimeStopSpell, SPELL_TRAVEL_TIME_STOP);
			magicT.put(TravelSpells.FindVillain, SPELL_TRAVEL_FIND_VILLAIN);
			magicT.put(TravelSpells.CastleGate, SPELL_TRAVEL_CASTLE_GATE);
			magicT.put(TravelSpells.TownGate, SPELL_TRAVEL_TOWN_GATE);
			magicT.put(TravelSpells.InstantArmySpell, SPELL_TRAVEL_INSTANT_ARMY);
			magicT.put(TravelSpells.RaiseControlSpell, SPELL_TRAVEL_RAISE_CONTROL);
		}
		{
			magicB.put(BattleSpells.CloneSpell, SPELL_BATTLE_CLONE);
			magicB.put(BattleSpells.FireballSpell, SPELL_BATTLE_FIREBALL);
			magicB.put(BattleSpells.FreezeSpell, SPELL_BATTLE_FREEZE);
			magicB.put(BattleSpells.LightingBoltSpell, SPELL_BATTLE_LIGHTING_BOLT);
			magicB.put(BattleSpells.RessurectSpell, SPELL_BATTLE_RESSURECT);
			magicB.put(BattleSpells.TeleportSpell, SPELL_BATTLE_TELEPORT);
			magicB.put(BattleSpells.TurnUndeadSpell, SPELL_BATTLE_TURN_UNDEAD);
		}
		{
			counts.put(0, COUNTS_NAMES[0]);
			counts.put(10, COUNTS_NAMES[1]);
			counts.put(20, COUNTS_NAMES[2]);
			counts.put(50, COUNTS_NAMES[3]);
			counts.put(100, COUNTS_NAMES[4]);
			counts.put(500, COUNTS_NAMES[5]);

		}

	}

	public static String getUnitName(UnitTypes unit) {
		return units.get(unit);
	}

	public static String getUnitName(UnitType unit) {
		return units.get(UnitTypes.get(unit));
	}

	public static String getProfession(PlayerType type, int rank) {
		return titles.get(type)[rank];
	}

	public static String getMorale(int morale) {
		return morales.get(morale);
	}

	public static String getMagicName(MagicSpell magicSpells) {
		return getMagicName(magicSpells.getType());
	}

	public static String getMagicName(MagicSpells spell) {
		String s = magicT.get(spell);
		if (s == null) {
			s = magicB.get(spell);
			if (s == null) {
				s = UNKNOWN;
			}
		}
		return s;
	}

	public static String getContinentName(GlobalMap globalMap) {
		if (globalMap != null)
			return continents.get(globalMap.getId());
		else
			return UNKNOWN;
	}

	public static String getCountText(int count) {
		String s = UNKNOWN;
		for (Entry<Integer, String> e : counts.entrySet()) {
			if (e.getKey() <= count) {
				s = e.getValue();
			}
		}
		return s;
	}

	public static String getCastleName(Castle castle) {
		String s = UNKNOWN_CASTLE;
		if (castle != null) {
			s = castle.getName();
		}
		return s;
	}

	public static String getResidenceName(UnitsResidenceType type) {
		return residence.get(type);
	}
}
