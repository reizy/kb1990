package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.events.KBEvent;

public class BattleFailEvent implements KBEvent {

	private Hero enemy;

	public BattleFailEvent(Hero enemy) {
		this.enemy = enemy;
	}

	public Hero getHero() {
		return enemy;
	}

}
