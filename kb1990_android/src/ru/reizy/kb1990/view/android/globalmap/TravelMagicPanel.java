package ru.reizy.kb1990.view.android.globalmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelMagicBook;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.view.android.KbAndroidPanel;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;

public class TravelMagicPanel extends KbAndroidPanel {
	private boolean visible = false;
	private FrameLayout panel;
	final List<Button> btnsM = new ArrayList<Button>();

	public TravelMagicPanel(Window mWindow, Resources resources) {
		super(mWindow, resources);
		this.panel = (FrameLayout) findViewById(R.id.btn_bar_m);
		btnsM.add((Button) findViewById(R.id.btn_m1));
		btnsM.add((Button) findViewById(R.id.btn_m2));
		btnsM.add((Button) findViewById(R.id.btn_m3));
		btnsM.add((Button) findViewById(R.id.btn_m4));
		btnsM.add((Button) findViewById(R.id.btn_m5));
		btnsM.add((Button) findViewById(R.id.btn_m6));
		btnsM.add((Button) findViewById(R.id.btn_m7));
		final TravelMagicBook magicBook = getGlobalPlayer().getHero().getTravelMagicBook();

		int i = 0;
		for (Entry<TravelSpells, Integer> entry : magicBook.getSpells().entrySet()) {
			Button button = btnsM.get(i);
			final TravelSpells spell = entry.getKey();
			updateButton(button, spell);
			button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					getModel().getGlobalMap().activateMagic(spell);
					hide();
				}
			});
			i++;
		}

		panel.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				hide();
			}
		});
	}

	private void updateButton(Button button, TravelSpells spell) {
		TravelMagicBook book = getGlobalPlayer().getHero().getTravelMagicBook();
		Integer count = book.getSpells().get(spell);
		String name = NameResolver.getMagicName(spell) + "(" + count + ")";
		button.setText(name);
		boolean enabled = count > 0;
		enabled = enabled && getGlobalPlayer().getHero().isMagicActive();
		button.setEnabled(enabled);
	}

	public void updateMagic() {
		int i = 0;
		final TravelMagicBook magicBook = getGlobalPlayer().getHero().getTravelMagicBook();
		for (Entry<TravelSpells, Integer> entry : magicBook.getSpells().entrySet()) {
			Button button = btnsM.get(i);
			final TravelSpells spell = entry.getKey();
			updateButton(button, spell);
			i++;
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
