package kb.battle.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import kb.battle.view.swing.BattleView;
import kb.globalmap.model.KBGlobalViewI;

public class InfoClickListener implements MouseListener {

	private KBGlobalViewI gView;
	private BattleView bView;

	InfoClickListener(KBGlobalViewI gView, BattleView bView) {
		this.gView = gView;
		this.bView = bView;
	}

	public void mouseClicked(final MouseEvent event) {

	}

	public void mouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(final MouseEvent event) {
		bView.deactivateInfo();
		gView.toNext();
	}
}
