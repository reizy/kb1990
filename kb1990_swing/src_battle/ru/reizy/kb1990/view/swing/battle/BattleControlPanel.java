package ru.reizy.kb1990.view.swing.battle;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ru.reizy.kb1990.controller.swing.battle.BattleController;
import ru.reizy.kb1990.model.battle.BattleModel;

public class BattleControlPanel extends JPanel {
	private static final long serialVersionUID = -598665102818786300L;
	private static final Font FONT = new Font("Courier New", Font.BOLD, 50);

	private BattleModel model;
	private JButton[] buttons = new JButton[5];
	private int i = 0;

	BattleControlPanel(BattleModel model, BattleController controller) {
		super(new GridLayout(0, 5));
		this.model = model;
		addButton("A", "View Army", null);
		addButton("G", "Give Up", controller.getGiveUpController());
		addButton("V", "View Char", null);
		addButton("W", "Wait", controller.getUnitWaitController());
		addButton("P", "Pass", controller.getUnitPassController());
	}

	private void addButton(String name, String caption, ActionListener listener) {
		JButton button = new JButton(name);
		button.setFont(FONT);
		if (listener != null) {
			button.addActionListener(listener);
		}
		add(button);
		buttons[i] = button;
		i++;
	}

	public void updateControls() {
		boolean b = model.isUserControled();
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setEnabled(b);

		}
	}
}
