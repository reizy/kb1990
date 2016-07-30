package ru.reizy.kb1990.view.android.battle.listeners;

import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.spells.events.FreezeSpellUsedEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.android.battle.BattleView;
import ru.reizy.kb1990.view.android.resource.NameResolver;

public class FreezeSpellUsedEventListener implements KBEventListener {
	private BattleView view;

	public FreezeSpellUsedEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof FreezeSpellUsedEvent);
	}

	public void onEvent(KBEvent e) {
		FreezeSpellUsedEvent csuEvent = (FreezeSpellUsedEvent) e;
		UnitInMagica unit = csuEvent.getUnit();
		String n = NameResolver.getUnitName(unit.getType());
		view.showMessage("Вы заморозили " + n);

	}
}
