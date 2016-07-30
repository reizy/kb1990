package ru.reizy.kb1990.view.swing.battle.magic;

import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.spells.events.RessurectSpellUsedEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.battle.BattleView;

public class RessurectSpellUsedEventListener implements KBEventListener {
	private BattleView view;

	public RessurectSpellUsedEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof RessurectSpellUsedEvent);
	}

	public void onEvent(KBEvent e) {
		RessurectSpellUsedEvent csuEvent = (RessurectSpellUsedEvent) e;
		UnitInMagica unit = csuEvent.getUnit();
		int count = csuEvent.getCount();
		int sp = csuEvent.getSpell().getMagicanPower();
		String n = NameResolver.getUnitName(unit.getType());
		view.showMessage("Вы воскрешаете (с силой " + sp + ") " + count + " "
				+ n);
		view.updateCells(unit.getLocation());
	}
}
