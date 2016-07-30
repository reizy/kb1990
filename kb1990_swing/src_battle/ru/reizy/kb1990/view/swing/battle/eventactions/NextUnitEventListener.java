package ru.reizy.kb1990.view.swing.battle.eventactions;

import ru.reizy.kb1990.model.battle.base.unit.MagicMark;
import ru.reizy.kb1990.model.battle.base.unit.ShooterUnit;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.FlyingUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInView;
import ru.reizy.kb1990.model.events.BattleNextUnitEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.battle.BattleView;

public class NextUnitEventListener implements KBEventListener {
	private BattleView view;

	public NextUnitEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof BattleNextUnitEvent);
	}

	public void onEvent(KBEvent e) {
		BattleNextUnitEvent event = (BattleNextUnitEvent) e;
		showNextUnit(event.getPrevUnit(), event.getActiveUnit());
	}

	private void showNextUnit(UnitInView prev, UnitInView active) {
		if (!(active instanceof MagicMark)) {
			UnitType type = active.getType();
			String s = NameResolver.getUnitName(type);
			if (active.getType() instanceof FlyingUnit) {
				s += " M:Fly";
			} else {
				s += " M:" + active.getMP();
			}
			if (active instanceof ShooterUnit) {
				s += " S:" + ((ShooterUnit) active).getShootCount();
			}
			view.showMessage(s);
		}
		view.updateCells(prev.getLocation(), active.getLocation());
		view.updatePanels();
	}
}
