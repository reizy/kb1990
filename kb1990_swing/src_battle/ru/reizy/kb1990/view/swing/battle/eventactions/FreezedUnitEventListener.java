package ru.reizy.kb1990.view.swing.battle.eventactions;

import ru.reizy.kb1990.model.events.FreezedUnitEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.battle.BattleView;

public class FreezedUnitEventListener implements KBEventListener {
	private BattleView view;

	public FreezedUnitEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof FreezedUnitEvent);
	}

	public void onEvent(KBEvent e) {
		FreezedUnitEvent event = (FreezedUnitEvent) e;
		
		view.showMessage(NameResolver.getUnitName(event.getActiveUnit()
				.getType()) + " is freezed");
	}
}
