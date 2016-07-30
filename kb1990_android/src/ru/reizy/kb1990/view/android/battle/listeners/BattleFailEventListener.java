package ru.reizy.kb1990.view.android.battle.listeners;

import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.model.globalmap.events.BattleFailEvent;
import ru.reizy.kb1990.view.android.battle.BattleView;

public class BattleFailEventListener implements KBEventListener {
	private BattleView view;

	public BattleFailEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof BattleFailEvent);
	}

	public void onEvent(KBEvent e) {
		view.setBattleResult(BattleView.BATTLE_FAIL_RESULT);
		view.showFailInfo(((BattleFailEvent) e).getHero());
	}
}
