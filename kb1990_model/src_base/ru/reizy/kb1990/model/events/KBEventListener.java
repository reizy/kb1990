package ru.reizy.kb1990.model.events;



public interface KBEventListener {
	boolean isAplicable(KBEvent e);
	void onEvent(KBEvent e);
}
