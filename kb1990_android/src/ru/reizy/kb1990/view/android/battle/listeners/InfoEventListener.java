package ru.reizy.kb1990.view.android.battle.listeners;

import ru.reizy.kb1990.model.events.BattleInfoEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.android.battle.BattleView;

public class InfoEventListener implements KBEventListener {
	private BattleView view;

	public InfoEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof BattleInfoEvent);
	}

	public void onEvent(KBEvent e) {
		BattleInfoEvent event = (BattleInfoEvent) e;
		view.showMessage(event.getMessage());
	}

}
