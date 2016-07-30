package ru.reizy.kb1990.viewcontroller.swing.battle;

import java.awt.event.MouseEvent;

import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.defaults.DefaultMouseListener;
import ru.reizy.kb1990.view.swing.battle.BattleView;

public class InfoClickListener extends DefaultMouseListener {

	private KBGlobalViewI gView;
	private BattleView bView;

	public InfoClickListener(KBGlobalViewI gView, BattleView bView) {
		this.gView = gView;
		this.bView = bView;
	}

	@Override
	public void mouseReleased(final MouseEvent event) {
		bView.deactivateInfo();
		gView.toNext();
	}
}
