package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.residence.Residence;

public class ResidenceInEvent implements KBEvent {

	private Residence residence;

	public ResidenceInEvent(Residence residence) {
		this.residence = residence;
	}

	public Residence getResidence() {
		return residence;
	}

}
