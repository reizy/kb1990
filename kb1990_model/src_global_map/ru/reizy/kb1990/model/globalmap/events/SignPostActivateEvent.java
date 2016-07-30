package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.residence.SignPost;

public class SignPostActivateEvent implements KBEvent {
	private SignPost signPost;

	public SignPostActivateEvent(SignPost signPost) {
		this.signPost = signPost;
	}

	public SignPost getResidence() {
		return signPost;
	}

}
