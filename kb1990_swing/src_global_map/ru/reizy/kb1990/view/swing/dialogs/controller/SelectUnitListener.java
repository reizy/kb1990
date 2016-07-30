package ru.reizy.kb1990.view.swing.dialogs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.globalmap.residence.KingCastle;

public class SelectUnitListener implements ActionListener {
	private static final Logger log = LoggerFactory.getLogger(SelectUnitListener.class);
	private int index;
	private KBModel model;

	public SelectUnitListener(KBModel model, int index) {
		this.index = index;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		KingCastle activeKingCastle = model.getGlobalPlayer().getActiveKingCastle();
		if (activeKingCastle != null) {
			activeKingCastle.setUnitIndex(index);
		} else {
			log.error("вы не в замке короля");
		}
	}
}
