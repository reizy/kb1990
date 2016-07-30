package ru.reizy.kb1990.model.battle.base.unit;

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

import java.util.HashMap;
import java.util.Map;

import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;

public enum UnitsResidenceType {
	CASTLE(MILITIA, ARCHERS, PIKEMEN, CAVALRY, KNIGHTS), //
	PLAINS(PEASANTS, WOLVES, NOMADS, BARBARIANS, ARCHMAGES), //
	FOREST(SPRITES, GNOMES, ELVES, TROLLS, DRUIDS), //
	HILLS(ORCS, DWARVES, OGRES, GIANTS, DRAGONS), //
	DUNGEON(SKELETONS, ZOMBIES, GHOSTS, VAMPIRES, DEMONS);//

	private final UnitTypes[] unitTypes;

	private static class x {
		private static Map<UnitTypes, UnitsResidenceType> mapTypeEnum = new HashMap<UnitTypes, UnitsResidenceType>();
		private static Map<UnitType, UnitsResidenceType> mapType = new HashMap<UnitType, UnitsResidenceType>();
	}

	private UnitsResidenceType(UnitTypes... types) {
		unitTypes = types;
		for (int i = 0; i < types.length; i++) {
			x.mapTypeEnum.put(types[i], this);
			x.mapType.put(types[i].getUnitType(), this);
		}
	}

	public static UnitsResidenceType get(UnitTypes type) {
		return x.mapTypeEnum.get(type);
	}

	public static UnitsResidenceType get(UnitType type) {
		return x.mapType.get(type);
	}

	public UnitTypes[] getUnitTypes() {
		return unitTypes;
	}

	public UnitTypes getRandom() {
		return getUnitTypes()[(int) (Math.random() * getUnitTypes().length)];
	}
}
