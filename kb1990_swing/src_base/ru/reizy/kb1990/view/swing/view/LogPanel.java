package ru.reizy.kb1990.view.swing.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogPanel extends JPanel {
	private static final int LINE_COUNT = 10;
	private static final long serialVersionUID = -187956574737504392L;
	private JLabel[] log = new JLabel[LINE_COUNT];

	public LogPanel() {
		super(new GridLayout(LINE_COUNT, 1));
		for (int i = 0; i < LINE_COUNT; i++) {
			log[i] = new JLabel();
			add(log[i]);
		}
		showMessage("The game begins");
	}

	public void showMessage(String s) {
		for (int i = 0; i < LINE_COUNT - 1; i++) {
			log[i].setText(log[i + 1].getText());
		}
		log[LINE_COUNT - 1].setText(s);
	}
}
