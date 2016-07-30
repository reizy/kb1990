package ru.reizy.kb1990.view.swing.battle.magic;

import ru.reizy.kb1990.model.events.BattleNewTurnEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.swing.battle.BattleView;

public class NewTurnEventListener implements KBEventListener {
	private BattleView view;

	public NewTurnEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof BattleNewTurnEvent);
	}

	public void onEvent(KBEvent e) {
		// NewTurnEvent csuEvent = (NewTurnEvent) e;
		view.showMessage("New turn started");
	}
}
