package ru.reizy.kb1990.view.swing.dialogs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.reizy.kb1990.KBModel;

public class ExitListener implements ActionListener {
	private final KBModel gModel;

	public ExitListener(KBModel gModel) {
		this.gModel = gModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gModel.getGlobalPlayer().goOut();
	}
}