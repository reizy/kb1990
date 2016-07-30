package ru.reizy.kb1990.view.swing.prototype;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class KBControlPanel extends JPanel {
	private static final long serialVersionUID = 2535512615902384109L;
	private static final Font FONT_C = new Font("Courier New", Font.BOLD, 50);
	private static final Font FONT_L = new Font("Courier New", Font.BOLD, 20);

	private JPanel cPanel;
	private JPanel lPanel;
	private JButton[] cButtons;
	private JButton[] lButtons;

	protected KBControlPanel(int c, int l) {
		setLayout(new BorderLayout());
		cButtons = new JButton[c];
		lButtons = new JButton[l];
		cPanel = new JPanel(new GridLayout(1, 0));
		lPanel = new JPanel(new GridLayout(0, 1));
		add(cPanel, BorderLayout.NORTH);
		add(lPanel, BorderLayout.CENTER);
		for (int i = 0; i < c; i++) {
			JButton b = new JButton();
			cPanel.add(b);
			cButtons[i] = b;
		}
		for (int i = 0; i < l; i++) {
			JButton b = new JButton();
			lPanel.add(b);
			lButtons[i] = b;
		}
	}

	public final void updateControlsC(boolean... e) {
		int c = e.length;
		for (int i = 0; i < c; i++) {
			cButtons[i].setEnabled(e[i]);
		}
	}

	public final void updateControlsL(boolean... e) {
		int l = e.length;
		for (int i = 0; i < l; i++) {
			lButtons[i].setEnabled(e[i]);
		}
	}

	protected final JButton setButton(boolean c, int ind, String name,
			String caption, ActionListener listener) {
		JButton button = c ? cButtons[ind] : lButtons[ind];
		final Font font = c ? FONT_C : FONT_L;

		button.setText(name);
		button.setToolTipText(caption);
		button.setFont(font);
		if (listener != null) {
			button.addActionListener(listener);
		}
		return button;
	}

	public abstract void update();

}
