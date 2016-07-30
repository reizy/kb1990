package ru.reizy.kb1990.view.swing.dialogs.view.control;

import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.EXIT;
import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.swing.dialogs.controller.BuySiegeListener;
import ru.reizy.kb1990.view.swing.dialogs.controller.BuySpellListener;
import ru.reizy.kb1990.view.swing.dialogs.controller.ExitListener;
import ru.reizy.kb1990.view.swing.dialogs.controller.NewContractListener;
import ru.reizy.kb1990.view.swing.dialogs.controller.RentBoatListener;
import ru.reizy.kb1990.view.swing.dialogs.controller.TownInfoListener;
import ru.reizy.kb1990.view.swing.dialogs.view.TownPanel;
import ru.reizy.kb1990.view.swing.prototype.KBControlPanel;

public class TownControllerPanel extends KBControlPanel {
	public TownControllerPanel(KBModel model, TownPanel view,
			final KBGlobalViewI gView) {
		super(5, 7);
		setButton(true, 0, "A", "", new NewContractListener(model));
		setButton(true, 1, "B", "", new RentBoatListener(model));
		setButton(true, 2, "C", "", new TownInfoListener(model, gView));
		setButton(true, 3, "D", "", new BuySpellListener(model));
		setButton(true, 4, "E", "", new BuySiegeListener(model));
		setButton(false, 6, EXIT, "", new ExitListener(model));
		update();
	}

	private static final long serialVersionUID = 774380151402890483L;

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
