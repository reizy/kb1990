package ru.reizy.kb1990.model.events;



public class BattleInfoEvent implements KBEvent {

	private final String message;

	public BattleInfoEvent(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}



}
