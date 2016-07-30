package ru.reizy.kb1990.view.swing.prototype;

import java.awt.event.ActionListener;

public abstract class KBTabPanel extends KBGlobalViewPanel {
	private static final long serialVersionUID = -6950877206595298095L;

	private ActionListener mainViewListener;

	public void setMainViewListener(ActionListener actionListener) {
		mainViewListener = actionListener;
	}

	protected void activatePanel() {
		mainViewListener.actionPerformed(null);
	}

	public void updateAndActivate() {
		activatePanel();
		update();
	}

	public void update() {
		// TODO Auto-generated method stub
	}

	


}
