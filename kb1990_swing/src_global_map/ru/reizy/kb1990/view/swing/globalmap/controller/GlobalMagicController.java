package ru.reizy.kb1990.view.swing.globalmap.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;

public class GlobalMagicController implements ActionListener {
	private final TravelSpells spell;
	private final KBModel model;

	public GlobalMagicController(TravelSpells spell, KBModel model) {
		this.spell = spell;
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		model.getGlobalMap().activateMagic(spell);
	}

}
