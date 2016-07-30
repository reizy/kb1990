package ru.reizy.kb1990.view.android.battle.listeners;

import ru.reizy.kb1990.model.events.BattleStartEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.android.battle.BattleView;

public class StartBattleEventListener implements KBEventListener {
	private BattleView view;

	public StartBattleEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof BattleStartEvent);
	}

	public void onEvent(KBEvent e) {
		view.updateField();
		view.updatePanels();
	}
}
