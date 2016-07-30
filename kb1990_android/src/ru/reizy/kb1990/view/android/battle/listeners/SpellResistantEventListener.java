package ru.reizy.kb1990.view.android.battle.listeners;

import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.spells.events.SpellResistantEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.android.battle.BattleView;
import ru.reizy.kb1990.view.android.resource.NameResolver;

public class SpellResistantEventListener implements KBEventListener {
	private BattleView view;

	public SpellResistantEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof SpellResistantEvent);
	}

	public void onEvent(KBEvent e) {
		SpellResistantEvent csuEvent = (SpellResistantEvent) e;
		UnitInMagica unit = csuEvent.getUnit();
		String n = NameResolver.getUnitName(unit.getType());
		view.showMessage("Ваше заклинание не возымело действия на " + n);
		view.updateCells(true, unit.getLocation());
	}
}
