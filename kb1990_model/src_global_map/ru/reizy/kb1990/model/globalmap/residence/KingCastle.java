package ru.reizy.kb1990.model.globalmap.residence;

import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.events.KingCastleInEvent;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence.BuyStatus;

public class KingCastle extends UnitResidence {

	private final UnitTypes[] types = UnitsResidenceType.CASTLE.getUnitTypes();
	private int unitIndex;
	private final String name;

	public KingCastle(Cell cell, String name) {
		super(cell);
		this.name = name;
	}

	public UnitTypes[] getUnitTypes() {
		return types;
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
					p.addToArmy(getUnit(), count);
					p.addMoney(-price);
					r = BuyStatus.SUCCESFULL;
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
	public UnitTypes getUnit() {
		if (unitIndex >= 0) {
			return types[unitIndex];
		} else {
			return null;
		}
	}

	public int getUnitIndex() {
		return unitIndex;
	}

	public void setUnitIndex(int unitIndex) {
		this.unitIndex = unitIndex;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean onActivate(GlobalPlayer player) {
		player.setActiveContentCell(getCell());
		getCell().getMap().onEvent(new KingCastleInEvent(this));
		return false;
	}

}
