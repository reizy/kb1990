package ru.reizy.kb1990.view.swing.battle.eventactions;

import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInView;
import ru.reizy.kb1990.model.events.BattleBetrayalEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.swing.battle.BattleView;

public class BetrayalEventListener implements KBEventListener {
	private BattleView view;

	public BetrayalEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof BattleBetrayalEvent);
	}

	public void onEvent(KBEvent e) {
		for (UnitInView unit : ((BattleBetrayalEvent) e).getEnemyArmy()) {
			view.updateCells(unit.getLocation());
		}
	}
}
