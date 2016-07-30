package ru.reizy.kb1990.view.swing.battle.eventactions;

import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.model.globalmap.events.BattleWinEvent;
import ru.reizy.kb1990.view.swing.battle.BattleView;

public class BattleWinEventListener implements KBEventListener {
	private BattleView view;

	public BattleWinEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof BattleWinEvent);
	}

	public void onEvent(KBEvent e) {
		view.showWinInfo(((BattleWinEvent) e).getHero());
		view.updateAndActivate();
	}
}
