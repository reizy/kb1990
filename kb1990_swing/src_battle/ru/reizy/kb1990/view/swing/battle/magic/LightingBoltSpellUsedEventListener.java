package ru.reizy.kb1990.view.swing.battle.magic;

import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.spells.events.LightingBoltSpellUsedEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.battle.BattleView;

public class LightingBoltSpellUsedEventListener implements KBEventListener {
	private BattleView view;

	public LightingBoltSpellUsedEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof LightingBoltSpellUsedEvent);
	}

	public void onEvent(KBEvent e) {
		LightingBoltSpellUsedEvent csuEvent = (LightingBoltSpellUsedEvent) e;
		UnitInMagica unit = csuEvent.getUnit();
		int count = csuEvent.getCount();
		int sp = csuEvent.getSpell().getMagicanPower();
		String n = NameResolver.getUnitName(unit.getType());
		view.showMessage(
				"Вы поразили молнией (с силой " + sp + ") " + count + " " + n);
		view.updateCells(unit.getLocation());
	}
}
