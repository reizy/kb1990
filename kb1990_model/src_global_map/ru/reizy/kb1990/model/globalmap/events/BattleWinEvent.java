package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.events.ChangeCharacterEvent;

public class BattleWinEvent implements ChangeCharacterEvent {

	private Hero enemy;

	public BattleWinEvent(Hero enemy) {
		this.enemy = enemy;
	}

	public Hero getHero() {
		return enemy;
	}

}
