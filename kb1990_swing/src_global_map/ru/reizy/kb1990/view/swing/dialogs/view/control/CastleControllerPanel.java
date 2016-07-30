package ru.reizy.kb1990.view.swing.dialogs.view.control;

import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.ATTACK;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.EXIT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.GARNISON;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.REMOVE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.swing.dialogs.controller.ExitListener;
import ru.reizy.kb1990.view.swing.dialogs.controller.GarnisonListener;
import ru.reizy.kb1990.view.swing.dialogs.view.CastlePanel;
import ru.reizy.kb1990.view.swing.prototype.KBControlPanel;

public class CastleControllerPanel extends KBControlPanel {
	final KBModel model;
	final CastlePanel castlePanel;

	public CastleControllerPanel(final KBModel model,
			final CastlePanel castlePanel, final KBGlobalViewI gView) {
		super(5, 7);
		this.model = model;
		this.castlePanel = castlePanel;
		setButton(true, 0, "A", "", new GarnisonListener(model, castlePanel, 0));
		setButton(true, 1, "B", "", new GarnisonListener(model, castlePanel, 1));
		setButton(true, 2, "C", "", new GarnisonListener(model, castlePanel, 2));
		setButton(true, 3, "D", "", new GarnisonListener(model, castlePanel, 3));
		setButton(true, 4, "E", "", new GarnisonListener(model, castlePanel, 4));
		setButton(false, 0, REMOVE, "", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castlePanel.setGarrison(false);
				castlePanel.update();
			}
		});
		setButton(false, 1, GARNISON, "", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castlePanel.setGarrison(true);
				castlePanel.update();
			}
		});
		setButton(false, 2, ATTACK, "", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (model.getGlobalPlayer().hasSeigeWeapon()) {
					model.getGlobalPlayer().getActiveCastle().atackEnemy();
				}
			}
		});
		setButton(false, 6, EXIT, "", new ExitListener(model));
		update();
	}

	private static final long serialVersionUID = 774380151402890483L;

	@Override
	public void update() {
		// наш ли замок
		GlobalPlayer player = model.getGlobalPlayer();
		Castle activeCastle = player.getActiveCastle();
		boolean e1 = (activeCastle == null);
		boolean e2 = ((!e1) && (activeCastle.getHero() == null));
		boolean e3 = e2 && castlePanel.getGarnison();
		boolean e4 = e2 && !castlePanel.getGarnison();
		boolean e5 = ((!e1) && (!e2) && (player.hasSeigeWeapon()));
		updateControlsC(e2, e2, e2, e2, e2);
		updateControlsL(e3, e4, e5);

	}

}
