package ru.reizy.kb1990.view.swing.dialogs.view.control;

import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.EXIT;
import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;
import ru.reizy.kb1990.view.swing.dialogs.controller.BuyUnitListener;
import ru.reizy.kb1990.view.swing.dialogs.controller.ExitListener;
import ru.reizy.kb1990.view.swing.dialogs.view.ResidencePanel;
import ru.reizy.kb1990.view.swing.prototype.KBControlPanel;

public class ResidenceControllerPanel extends KBControlPanel {
	private static final Integer[] COUNTS = { 1, 2, 3, 5, 10, 25, 50 };
	private final ResidencePanel rPanel;

	public ResidenceControllerPanel(KBModel model, ResidencePanel panel,
			final KBViewInterface gView) {
		super(5, COUNTS.length);
		this.rPanel = panel;
		for (int i = 0; i < COUNTS.length; i++) {
			Integer j = COUNTS[i];
			setButton(false, i, j.toString(), "", new BuyUnitListener(model, j));
		}
		setButton(true, 4, "E", EXIT, new ExitListener(model));

		update();
	}

	private static final long serialVersionUID = 774380151402890483L;

	@Override
	public void update() {
		boolean[] b = new boolean[COUNTS.length];
		for (int i = 0; i < COUNTS.length; i++) {
			Integer j = COUNTS[i];
			b[i] = rPanel.getAvaibleCount() >= j;
		}
		updateControlsL(b);

	}
}
