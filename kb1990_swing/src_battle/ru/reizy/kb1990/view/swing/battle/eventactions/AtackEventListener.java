package ru.reizy.kb1990.view.swing.battle.eventactions;

import static ru.reizy.kb1990.view.swing.KBResources.ANIMATION_SPEED;
import ru.reizy.kb1990.model.battle.base.AtackInfo;
import ru.reizy.kb1990.model.battle.unit.types.Demons;
import ru.reizy.kb1990.model.events.BattleUnitAtackEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.battle.BattleView;

public class AtackEventListener implements KBEventListener {
	private BattleView view;

	public AtackEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof BattleUnitAtackEvent);
	}

	public void onEvent(KBEvent e) {
		BattleUnitAtackEvent event = (BattleUnitAtackEvent) e;
		showAtacking(event.getAtackInfo());
	}

	// Крестьян -> крестьян убили 1
	// Крестьян отплатили убили 1
	// Орки стрел Крестьян убили 1
	private void showAtacking(AtackInfo a) {
		String n1 = NameResolver.getUnitName(a.getUnit().getType());
		String n2 = NameResolver.getUnitName(a.getAim().getType());
		String action = a.isShooting() ? " стреляет " : a.isRevenge() ? " мстит "
				: " атакует ";

		int c1 = a.getCount();
		int c2 = a.getAimCount();
		int a1 = a.getAtack();
		int d2 = a.getDead();
		if (a1 != -1) {
			view.showMessage(n1 + "(" + c1 + ")" + action + n2 + "(" + c2 + ")"
					+ " на " + a1 + " убивая " + d2);
			try {
				boolean half = ((a.isSpecial()) && (a.getUnit().getType() instanceof Demons));
				view.showDamage(a.getAim(), half);
				Thread.sleep(ANIMATION_SPEED * 4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (c2 == d2) {
				view.showMessage(n2 + " повержены");
			}

		} else {
			view.showMessage(c2 + " " + n2 + " имунны к атаке " + c1 + " " + n1);
		}
		view.updateCells(a.getUnitLocation(), a.getAimLocation());
	}
}
