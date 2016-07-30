package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.GlobalHero;

public class EnemyActionEvent implements KBEvent {

	private GlobalHero enemy;

	public EnemyActionEvent(GlobalHero enemy) {
		this.enemy = enemy;
	}

	public GlobalHero getEnemy() {
		return enemy;
	}

}
