package ru.reizy.kb1990.model.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.reizy.kb1990.model.battle.base.unit.Morale;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "@type")
public class ArmyHolder {
	public static final int ARMY_MAX_SIZE = 5;
	private final List<UnitType> army = new ArrayList<UnitType>(5);
	private final List<Integer> armyCount = new ArrayList<Integer>(5);

	public List<UnitType> getArmy() {
		return army;
	}

	public List<Integer> getArmyCount() {
		return armyCount;
	}

	public UnitType getArmy(int i) {
		UnitType unit = null;
		if (i < getArmy().size()) {
			unit = getArmy().get(i);
		}
		return unit;
	}

	public Integer getArmyCount(int i) {
		Integer unit = null;
		if (i < getArmy().size()) {
			unit = getArmyCount().get(i);
		}
		return unit;
	}

	public void addToArmy(UnitType type, int count) {
		int i = getArmy().indexOf(type);
		if (i < 0) {
			army.add(type);
			armyCount.add(count);
		} else {
			getArmyCount().set(i, getArmyCount().get(i) + count);
		}
	}

	public void addToArmy(UnitTypes type, int count) {
		addToArmy(type.getUnitType(), count);
	}

	public void addToArmyInNewSlot(UnitTypes type, int count) {
		addToArmyInNewSlot(type.getUnitType(), count);
	}

	public void addToArmyInNewSlot(UnitType type, int count) {
		army.add(type);
		armyCount.add(count);
	}

	public int getMorale(int i) {
		UnitType type = getArmy().get(i);
		int morale = Morale.MORALE_HIGH;
		if (getArmy() != null) {
			for (UnitType unit : getArmy()) {
				int cm = Morale.check(unit, type);
				if (cm < morale) {
					morale = cm;
				}
			}
		}
		return morale;
	}

	public void removeFromArmy(int id) {
		if (id < army.size()) {
			army.remove(id);
			armyCount.remove(id);
		}
	}

	@Override
	public String toString() {
		String s = "{";
		for (int i = 0; i < army.size(); i++) {
			s += armyCount.get(i) + " " + army.get(i).getClass().getSimpleName() + ";";
		}
		s += "}";
		return s;
	}

	protected void setArmy(UnitType[] army, Integer[] armyCount) {
		this.army.clear();
		this.army.addAll(Arrays.asList(army));
		this.armyCount.clear();
		this.armyCount.addAll(Arrays.asList(armyCount));
	}
}
