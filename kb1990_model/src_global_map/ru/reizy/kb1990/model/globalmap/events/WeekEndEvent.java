package ru.reizy.kb1990.model.globalmap.events;

import java.util.List;

import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.events.ChangeCharacterEvent;

public class WeekEndEvent implements ChangeCharacterEvent {
	UnitTypes unit;
	int moneyBefore;
	int commision;
	int boatRent;
	int armyCost;
	int moneyAfter;
	int weekNum;
	List<UnitTypes> units;
	List<Integer> unitsCost;

	public WeekEndEvent(UnitTypes unit, int moneyBefore, int commision,
			int boatRent, int armyCost, int moneyAfter, int weekNum,
			List<UnitTypes> units, List<Integer> unitsCost) {
		super();

		this.unit = unit;
		this.moneyBefore = moneyBefore;
		this.commision = commision;
		this.boatRent = boatRent;
		this.armyCost = armyCost;
		this.moneyAfter = moneyAfter;
		this.weekNum = weekNum;
		this.units = units;
		this.unitsCost = unitsCost;

		System.out.println(this);
	}

	public UnitTypes getUnit() {
		return unit;
	}

	public int getMoneyBefore() {
		return moneyBefore;
	}

	public int getCommision() {
		return commision;
	}

	public int getBoatRent() {
		return boatRent;
	}

	public int getArmyCost() {
		return armyCost;
	}

	public int getMoneyAfter() {
		return moneyAfter;
	}

	public int getWeekNum() {
		return weekNum;
	}

	public List<UnitTypes> getUnits() {
		return units;
	}

	public List<Integer> getUnitsCost() {
		return unitsCost;
	}

	@Override
	public String toString() {
		return "WeekEndEvent [weekNum=" + weekNum + ", unit=" + unit
				+ ", moneyBefore=" + moneyBefore + ", commision=" + commision
				+ ", boatRent=" + boatRent + ", armyCost=" + armyCost
				+ ", moneyAfter=" + moneyAfter + ", units=" + units
				+ ", unitsCost=" + unitsCost + "]";
	}

}
