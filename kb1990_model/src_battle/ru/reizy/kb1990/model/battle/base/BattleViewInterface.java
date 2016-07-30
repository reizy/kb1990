package ru.reizy.kb1990.model.battle.base;

import ru.reizy.kb1990.model.events.KBEvent;

public interface BattleViewInterface {
	/**
	 * View attacking
	 * 
	 * @param unit attacking unit
	 * @param aim defending unit
	 * @param a1 attacking unit damage
	 * @param a2 defending unit damage
	 * @param c1 attacking unit count was
	 * @param c2 defending unit count was
	 * @param d1 attacking unit count die
	 * @param d2 defending unit count die
	 */

	void onEvent(KBEvent startBattleEvent);
}
