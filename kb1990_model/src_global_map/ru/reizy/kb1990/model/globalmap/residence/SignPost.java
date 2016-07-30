package ru.reizy.kb1990.model.globalmap.residence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.events.SignPostActivateEvent;

public class SignPost extends Residence {
	private static final Logger log = LoggerFactory.getLogger(SignPost.class);
	private final String text;

	public SignPost(Cell cell, String text) {
		super(cell);
		this.text = text;
		log.info("SignPost '" + text + "' created at " + cell);
	}

	@Override
	public boolean onActivate(GlobalPlayer player) {
		log.info("SignPost '" + text + "' activated at " + getCell());
		player.setActiveContentCell(getCell()); 
		setOutCell(getCell());
		player.getActiveMap().onEvent(new SignPostActivateEvent(this));
		return true;
	}

	public String getText() {
		return text;
	}

}
