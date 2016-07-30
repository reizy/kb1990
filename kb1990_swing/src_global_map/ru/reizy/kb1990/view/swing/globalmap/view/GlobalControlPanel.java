package ru.reizy.kb1990.view.swing.globalmap.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelMagicBook;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.saveload.KBSaver;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.globalmap.controller.GlobalMagicController;
import ru.reizy.kb1990.view.swing.prototype.KBControlPanel;

//Вы еще не обучены магическо-
//му исскуству. Посетите Вели-
//кого Волшебника Авранжа из
//Континентии в доме на 11,19 
//для обучения.

public class GlobalControlPanel extends KBControlPanel {
	private static final long serialVersionUID = -598665102818786300L;

	private KBModel model;
	private final Map<JButton, TravelSpells> buttons = new HashMap<JButton, TravelSpells>();

	GlobalControlPanel(final KBModel model) {
		super(5, model.getGlobalPlayer().getHero().getTravelMagicBook().getSize());
		this.model = model;

		int i = 0;
		// setButton(true, i++,"A", "View Army", null);
		// setButton(true, i++,"I", "Contract Info", null);
		// setButton(true, i++,"M", "Auto-mapping", null);
		// setButton(true, i++,"P", "Puzzle Solve", null);
		// setButton(true, i++,"V", "View Character", null);

		setButton(true, i++, "F", "Fly", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				final GlobalPlayer p = model.getGlobalPlayer();
				if (p.isFlying()) {
					p.tryLand();
				} else {
					p.tryFly();
				}

			}
		});
		setButton(true, i++, "S", "Search Area", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new KBSaver(model).load();
			}
		});
		setButton(true, i++, "W", "Wait End Week", null);
		setButton(true, i++, "Q", "Quit and Save", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new KBSaver(model).save();
			}
		});
		setButton(true, i++, "T", "Travel", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				final GlobalPlayer p = model.getGlobalPlayer();
				if (p.inShip()) {
					GlobalMap map = p.getOpenedMaps().get(
							(p.getActiveMap().getId() + 1)
									% p.getOpenedMaps().size());
					Cell playerCell = map.getStartCell();
					map.goTo(playerCell.getX(), playerCell.getY());
				}
			}
		});

		TravelMagicBook book = model.getGlobalPlayer().getHero().getTravelMagicBook();
		i = 0;
		for (Entry<TravelSpells, Integer> spellEntry : book.getSpells()
				.entrySet()) {
			TravelSpells spell = spellEntry.getKey();
			JButton button = setButton(false, i++, "", "",
					new GlobalMagicController(spell, model));
			buttons.put(button, spell);
		}
		update();
	}

	public void updateMagic() {
		for (Entry<JButton, TravelSpells> buttonEntry : buttons.entrySet()) {
			JButton button = buttonEntry.getKey();
			TravelSpells spell = buttons.get(button);
			updateButton(button, spell);
		}
	}

	private void updateButton(JButton button, TravelSpells spell) {
		TravelMagicBook book = model.getGlobalPlayer().getHero().getTravelMagicBook();
		Integer count = book.getSpells().get(spell);
		String name = NameResolver.getMagicName(spell) + "(" + count + ")";
		button.setText(name);
		boolean enabled = count > 0;
		enabled = enabled && model.getGlobalPlayer().getHero().isMagicActive();
		button.setEnabled(enabled);
	}

	public void updateControls() {
		GlobalPlayer player = model.getGlobalPlayer();
		boolean e1 = (//
		/*-----------*/(//
		/*-------------*/((player.canFly()) && (!player.isFlying()))//
		/*-------------*/|| ((player.canLand()) && (player.isFlying()))//
		/*-----------*/)//
		/*-----------*/&& (!player.inShip())//
		/*---------*/);
		boolean e2 = true;
		boolean e3 = false;
		boolean e4 = true;
		boolean e5 = (player.inShip());
		updateControlsC(e1, e2, e3, e4, e5);
	}

	@Override
	public void update() {
		updateControls();
		updateMagic();
	}

}
