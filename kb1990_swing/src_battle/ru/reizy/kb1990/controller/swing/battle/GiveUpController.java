package ru.reizy.kb1990.controller.swing.battle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.reizy.kb1990.model.battle.BattleModel;

public class GiveUpController implements ActionListener {
	private BattleModel model;
	private BattleController controller;

	GiveUpController(BattleModel model, BattleController controller) {
		this.model = model;
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		controller.runIt(new Runnable() {
			public void run() {
				model.giveUp();
			}
		});
	}
}
