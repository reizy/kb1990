package ru.reizy.kb1990.view.android.battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.battle.BattleModel;
import ru.reizy.kb1990.model.battle.BattlePlayer;
import ru.reizy.kb1990.model.battle.base.unit.MagicMark;
import ru.reizy.kb1990.model.battle.magic.BattleMagicBook;
import ru.reizy.kb1990.view.android.KbAndroidPanel;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;

public class BattleMagicPanel extends KbAndroidPanel {
	private boolean visible = false;
	private FrameLayout panel;
	final List<Button> btnsM = new ArrayList<Button>();
	// cashe
	private BattleMagicBook magicBook;

	public BattleMagicPanel(Window mWindow, Resources resources) {
		super(mWindow, resources);
		this.panel = (FrameLayout) findViewById(R.id.btn_bar_m);
		btnsM.add((Button) findViewById(R.id.btn_m1));
		btnsM.add((Button) findViewById(R.id.btn_m2));
		btnsM.add((Button) findViewById(R.id.btn_m3));
		btnsM.add((Button) findViewById(R.id.btn_m4));
		btnsM.add((Button) findViewById(R.id.btn_m5));
		btnsM.add((Button) findViewById(R.id.btn_m6));
		btnsM.add((Button) findViewById(R.id.btn_m7));

		panel.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				hide();
			}
		});
	}

	private void init(BattleMagicBook magicBook) {
		this.magicBook = magicBook;
		if (magicBook != null) {
			int i = 0;
			for (Entry<BattleSpells, Integer> entry : magicBook.getBattleSpellCounts().entrySet()) {
				Button button = btnsM.get(i);
				final BattleSpells spell = entry.getKey();
				updateButton(button, spell);
				button.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						getBattleModel().activatePlayerMagic(spell);
						hide();
					}
				});
				i++;
			}
		}
	}

	private BattleModel getBattleModel() {
		return getModel().getBattleModel();
	}

	private BattleMagicBook getMagicBook() {
		final BattlePlayer player = getBattleModel().getPlayer();
		final BattleMagicBook magicBook = (player != null) ? player.getMagicBook() : null;
		if (this.magicBook != magicBook) {
			init(magicBook);
		}
		return magicBook;
	}

	private void updateButton(Button button, BattleSpells spell) {
		BattleMagicBook book = getMagicBook();
		boolean enabled = false;
		if (book != null) {
			Integer count = book.getBattleSpellCounts().get(spell);
			String name = NameResolver.getMagicName(spell) + "(" + count + ")";
			button.setText(name);
			enabled = count > 0;
			enabled = enabled && book.isActive();

			Object unit = getBattleModel().getActiveUnit();
			enabled = enabled && (!(unit instanceof MagicMark));

			enabled = enabled && getBattleModel().isUserControled();
		}
		button.setEnabled(enabled);

	}

	public void updateMagic() {
		int i = 0;
		final BattleMagicBook book = getMagicBook();
		if (book != null) {
			for (Entry<BattleSpells, Integer> entry : book.getBattleSpellCounts().entrySet()) {
				Button button = btnsM.get(i);
				final BattleSpells spell = entry.getKey();
				updateButton(button, spell);
				i++;
			}
		}
	}

	public boolean isVisible() {
		return visible;
	}

	public void hide() {
		visible = false;
		panel.setVisibility(View.GONE);
	}

	public void show() {
		visible = true;
		panel.setVisibility(View.VISIBLE);
		updateMagic();
	}

}
