package ru.reizy.kb1990.view.swing.dialogs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.view.swing.dialogs.view.CastlePanel;

public class GarnisonListener implements ActionListener {
	private KBModel model;
	private int id;
	private CastlePanel view;

	public GarnisonListener(KBModel model, CastlePanel view, int id) {
		this.model = model;
		this.view = view;
		this.id = id;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		model.getGlobalPlayer().garnisonUnit(id, view.getGarnison());
	}
}
