package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.residence.Residence;

public class ResidenceOutEvent implements KBEvent {

	private Residence residence;

	public ResidenceOutEvent(Residence residence) {
		this.residence = residence;
	}

	public Residence getResidence() {
		return residence;
	}

}
