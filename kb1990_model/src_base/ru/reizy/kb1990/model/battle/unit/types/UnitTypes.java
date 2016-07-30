package ru.reizy.kb1990.model.battle.unit.types;

import ru.reizy.kb1990.model.battle.base.unit.UnitType;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum UnitTypes {

	MILITIA(new Militia()), ARCHERS(new Archers()), PIKEMEN(new Pickmen()), CAVALRY(
			new Cavalry()), KNIGHTS(new Knights()), //
	PEASANTS(new Peasants()), WOLVES(new Wolves()), NOMADS(new Nomads()), BARBARIANS(
			new Barbarians()), ARCHMAGES(new Archmages()), //
	SPRITES(new Sprites()), GNOMES(new Gnomes()), ELVES(new Elves()), TROLLS(
			new Trolls()), DRUIDS(new Druids()), //
	SKELETONS(new Skeletons()), ZOMBIES(new Zombies()), GHOSTS(new Ghosts()), VAMPIRES(
			new Vampires()), DEMONS(new Demons()), //
	ORCS(new Orcs()), DWARVES(new Dwarves()), OGRES(new Ogres()), GIANTS(
			new Giants()), DRAGONS(new Dragons())//
	;

	private UnitType type;

	private UnitTypes() {
		this.type = null;
	}
	
	private UnitTypes(UnitType type) {
		this.type = type;
	}

	public UnitType getUnitType() {
		return type;
	}

	public static UnitTypes get(UnitType unit) {
		for (UnitTypes u : values()) {
			if (u.type == unit)
				return u;
		}
		return null;
	}

	public static UnitTypes get(int id) {
		for (UnitTypes u : values()) {
			if (u.getUnitType().getId() == id)
				return u;
		}
		return null;
	}

	@JsonCreator
	public static UnitTypes get(String unit) {
		for (UnitTypes u : values()) {
			if (u.toString().equals(unit))
				return u;
		}
		return null;
	}

	public static UnitTypes getRandom() {
		return values()[(int) (Math.random() * values().length)];
	}
}
