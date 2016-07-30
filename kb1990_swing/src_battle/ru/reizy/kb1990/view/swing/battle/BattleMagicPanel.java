package ru.reizy.kb1990.view.swing.battle;

import static ru.reizy.kb1990.view.swing.KBResources.FONT;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JPanel;

import ru.reizy.kb1990.controller.swing.battle.MagicController;
import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.BattleModel;
import ru.reizy.kb1990.model.battle.base.unit.MagicMark;
import ru.reizy.kb1990.model.battle.magic.BattleMagicBook;
import ru.reizy.kb1990.view.swing.NameResolver;

public class BattleMagicPanel extends JPanel {
	private static final long serialVersionUID = -598665102818786300L;
	private final Map<JButton, BattleSpells> buttons = new HashMap<JButton, BattleSpells>();
	private final BattleModel model;

	BattleMagicPanel(BattleModel model) {
		super(new GridLayout());
		this.model = model;
		createButtons();
		updateMagic();
	}

	/**
	 * @param model
	 */
	public void createButtons() {
		for (Entry<JButton, BattleSpells> button : buttons.entrySet()) {
			remove(button.getKey());
		}
		buttons.clear();
		if (model.getPlayer() != null) {
			((GridLayout) getLayout()).setRows(model.getPlayer().getMagicBook().getSize());
			BattleMagicBook book = model.getPlayer().getMagicBook();
			for (Entry<BattleSpells, Integer> spellEntry : book.getBattleSpellCounts().entrySet()) {
				BattleSpells spell = spellEntry.getKey();
				JButton button = new JButton("undefind");
				button.setFont(FONT);
				button.addActionListener(new MagicController(spell, model));
				add(button);
				buttons.put(button, spell);
			}
		}

	}

	private void updateButton(JButton button, BattleSpells spell) {
		BattleMagicBook book = model.getPlayer().getMagicBook();
		Integer count = book.getBattleSpellCounts().get(spell);
		String name = NameResolver.getMagicName(spell) + "(" + count + ")";
		button.setText(name);
		boolean enabled = count > 0;
		enabled = enabled && book.isActive();

		Object unit = model.getActiveUnit();
		enabled = enabled && (!(unit instanceof MagicMark));

		enabled = enabled && model.isUserControled();
		button.setEnabled(enabled);
	}

	public void updateMagic() {
		for (Entry<JButton, BattleSpells> buttonEntry : buttons.entrySet()) {
			JButton button = buttonEntry.getKey();
			BattleSpells spell = buttons.get(button);
			updateButton(button, spell);
		}
	}
}
