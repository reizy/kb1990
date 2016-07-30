package ru.reizy.kb1990.view.swing.dialogs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.reizy.kb1990.KBModel;

public class RentBoatListener implements ActionListener {
	private KBModel model;

	public RentBoatListener(KBModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		model.getGlobalPlayer().buyShip();
	}
}
