package ru.reizy.kb1990.view.swing.dialogs.view.control;

import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.EXIT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.KINGS_AUDIENCE;
import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;
import ru.reizy.kb1990.view.swing.dialogs.controller.BuyUnitListener;
import ru.reizy.kb1990.view.swing.dialogs.controller.ExitListener;
import ru.reizy.kb1990.view.swing.dialogs.controller.SelectUnitListener;
import ru.reizy.kb1990.view.swing.dialogs.view.KingCastlePanel;
import ru.reizy.kb1990.view.swing.prototype.KBControlPanel;

public class KingCastleControllerPanel extends KBControlPanel {
	private static final long serialVersionUID = -3862960522267763019L;
	private static final String[] UNITS = { "A", "B", "C", "D", "E" };
	private static final Integer[] COUNTS = { 1, 5, 10, 25, 50 };

	public KingCastleControllerPanel(KBModel model,
			KingCastlePanel castlePanel, KBViewInterface gView) {
		super(5, 7);
		for (int i = 0; i < UNITS.length; i++) {
			setButton(true, i, UNITS[i], "", new SelectUnitListener(model, i));
		}

		for (int i = 0; i < COUNTS.length; i++) {
			Integer j = COUNTS[i];
			setButton(false, i, j.toString(), "", new BuyUnitListener(model, j));
		}
		setButton(false, COUNTS.length, KINGS_AUDIENCE, "", new ExitListener(
				model));
		setButton(false, COUNTS.length + 1, EXIT, "", new ExitListener(model));
		update();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
