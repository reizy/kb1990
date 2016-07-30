package ru.reizy.kb1990.controller.swing.battle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.BattleModel;

public class MagicController implements ActionListener {
	private final BattleSpells spell;
	private final BattleModel model;

	public MagicController(BattleSpells spell, BattleModel model) {
		this.spell = spell;
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		model.activatePlayerMagic(spell);
	}

}
