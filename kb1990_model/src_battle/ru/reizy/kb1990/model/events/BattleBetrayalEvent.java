package ru.reizy.kb1990.model.events;

import java.util.List;

import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;

public class BattleBetrayalEvent implements KBEvent {
	private List<UnitInModel> enemyArmy;

	public BattleBetrayalEvent(List<UnitInModel> enemyArmy) {
		super();
		this.enemyArmy = enemyArmy;
	}

	/**
	 * @return the enemyArmy
	 */
	public List<UnitInModel> getEnemyArmy() {
		return enemyArmy;
	}

}
