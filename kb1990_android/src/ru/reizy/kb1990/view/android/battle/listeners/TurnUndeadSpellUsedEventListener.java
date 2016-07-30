package ru.reizy.kb1990.view.android.battle.listeners;

import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.spells.events.TurnUndeadSpellUsedEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.android.battle.BattleView;
import ru.reizy.kb1990.view.android.resource.NameResolver;

public class TurnUndeadSpellUsedEventListener implements KBEventListener {
	private BattleView view;

	public TurnUndeadSpellUsedEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof TurnUndeadSpellUsedEvent);
	}

	public void onEvent(KBEvent e) {
		TurnUndeadSpellUsedEvent csuEvent = (TurnUndeadSpellUsedEvent) e;
		UnitInMagica unit = csuEvent.getUnit();
		int count = csuEvent.getCount();
		int sp = csuEvent.getSpell().getMagicanPower();
		String n = NameResolver.getUnitName(unit.getType());
		view.showMessage("Вы поразили святой водой (с силой " + sp + ") " + count + " " + n);
		view.updateCells(true, unit.getLocation());
	}
}
