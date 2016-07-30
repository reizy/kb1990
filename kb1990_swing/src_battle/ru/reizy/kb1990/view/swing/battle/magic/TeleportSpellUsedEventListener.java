package ru.reizy.kb1990.view.swing.battle.magic;

import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInMagica;
import ru.reizy.kb1990.model.battle.magic.spells.events.TeleportSpellUsedEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.battle.BattleView;

public class TeleportSpellUsedEventListener implements KBEventListener {
	private BattleView view;

	public TeleportSpellUsedEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof TeleportSpellUsedEvent);
	}

	public void onEvent(KBEvent e) {
		TeleportSpellUsedEvent csuEvent = (TeleportSpellUsedEvent) e;
		UnitInMagica unit = csuEvent.getUnit();
		Cell cell = csuEvent.getCell();
		String n = NameResolver.getUnitName(unit.getType());
		view.showMessage("Вы телепортировали " + n);
		view.updateCells(cell);
		view.updateCells(unit.getLocation());
	}
}
