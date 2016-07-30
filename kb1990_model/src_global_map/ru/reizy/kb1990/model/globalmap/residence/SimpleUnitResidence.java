package ru.reizy.kb1990.model.globalmap.residence;

import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.UnitCounts;
import ru.reizy.kb1990.model.globalmap.events.ResidenceInEvent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleUnitResidence extends UnitResidence implements Bonus {
	public static enum BuyStatus {
		NO_SLOTS, NO_LEADERSHIP, NO_MONEY, NO_UNITS, SUCCESFULL
	}

	private UnitTypes unit;
	private Integer count;

	public SimpleUnitResidence(UnitTypes unit, Cell cell) {
		this(unit, cell, UnitCounts.R.get(unit));
	}

	@JsonCreator
	public SimpleUnitResidence(@JsonProperty("unit") UnitTypes unit, @JsonProperty("cell") Cell cell, @JsonProperty("count") int count) {
		super(cell);
		if (unit == null)
			System.out.println("!!!");
		this.unit = unit;
		this.count = count;
	}

	public void refresh() {
		count = UnitCounts.R.get(unit);
	}

	@Override
	public UnitTypes getUnit() {
		return unit;
	}

	public Integer getCount() {
		return count;
	}

	@JsonIgnore
	public UnitsResidenceType getType() {
		return UnitsResidenceType.get(unit);
	}

	public BuyStatus buy(final Player p, final int count) {
		final UnitType unit = getUnit().getUnitType();
		BuyStatus r;
		if ((!p.isArmyFull()) || (p.getArmy().contains(unit))) {
			int index = p.getArmy().indexOf(unit);
			int ll = p.getLeadership() / unit.getLeadership();
			if (index >= 0) {
				ll -= p.getArmyCount().get(index);
			}
			if (count <= ll) {
				int price = count * unit.getCost();
				if (p.getMoney() >= price) {
					if (this.count >= count) {
						this.count -= count;
						p.addToArmy(getUnit(), count);
						p.addMoney(-price);
						r = BuyStatus.SUCCESFULL;
					} else {
						r = BuyStatus.NO_UNITS;
					}
				} else {
					r = BuyStatus.NO_MONEY;
				}
			} else {
				r = BuyStatus.NO_LEADERSHIP;
			}
		} else {
			r = BuyStatus.NO_SLOTS;
		}
		return r;
	}

	@Override
	public boolean onActivate(GlobalPlayer player) {
		player.setActiveContentCell(getCell());
		setOutCell(player.getCell());
		player.getActiveMap().onEvent(new ResidenceInEvent(this));
		return true;
	}
}
