package ru.reizy.kb1990.view.swing.battle.magic;

import ru.reizy.kb1990.model.battle.magic.abstraction.MagicBattleSpell;
import ru.reizy.kb1990.model.battle.magic.spells.events.SpellActivatedEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.battle.BattleView;

public class SpellActivatedEventListener implements KBEventListener {
	private BattleView view;

	public SpellActivatedEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof SpellActivatedEvent);
	}

	public void onEvent(KBEvent e) {
		SpellActivatedEvent csuEvent = (SpellActivatedEvent) e;
		MagicBattleSpell spell = csuEvent.getSpell();
		view.showMessage(NameResolver.getMagicName(spell) + " activated");
		view.updateCells(csuEvent.getPreviousUnitCell());
	}
}
