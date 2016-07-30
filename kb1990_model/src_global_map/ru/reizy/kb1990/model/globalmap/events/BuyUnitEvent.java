package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.events.ChangeCharacterEvent;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence.BuyStatus;
import ru.reizy.kb1990.model.globalmap.residence.UnitResidence;

public class BuyUnitEvent implements ChangeCharacterEvent {

	private UnitResidence residence;
	private BuyStatus status;
	private int count;

	public BuyUnitEvent(UnitResidence residence, int count, BuyStatus status) {
		super();
		this.residence = residence;
		this.status = status;
		this.count = count;
	}

	public UnitResidence getResidence() {
		return residence;
	}

	public int getCount() {
		return count;
	}

	public BuyStatus getStatus() {
		return status;
	}

}
