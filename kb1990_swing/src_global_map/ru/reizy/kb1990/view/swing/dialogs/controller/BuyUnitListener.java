package ru.reizy.kb1990.view.swing.dialogs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.reizy.kb1990.KBModel;

public class BuyUnitListener implements ActionListener {
	private int count;
	private KBModel model;

	public BuyUnitListener(KBModel model, int count) {
		this.count = count;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		model.getGlobalPlayer().buyUnit(count);
	}
}
