package ru.reizy.kb1990.view.swing.battle.eventactions;

import ru.reizy.kb1990.model.battle.base.unit.interfaces.FlyingUnit;
import ru.reizy.kb1990.model.events.BattleUnitMoveEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.swing.battle.BattleView;

public class UnitMoveEventListener implements KBEventListener {
	private BattleView view;

	public UnitMoveEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof BattleUnitMoveEvent);
	}

	public void onEvent(KBEvent e) {
		BattleUnitMoveEvent moveEvent = (BattleUnitMoveEvent) e;
		boolean f = (moveEvent.getActiveUnit().getType() instanceof FlyingUnit);
		view.showMoving(moveEvent.getFrom(), moveEvent.getActiveUnit()
				.getLocation(), !f);
	}
}
