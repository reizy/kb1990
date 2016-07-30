package ru.reizy.kb1990.controller.android.castle;

import ru.reizy.kb1990.view.android.KbAndroidModelUser;
import ru.reizy.kb1990.view.android.globalmap.castle.CastlePanel;
import android.view.View;

public class GarnisonListener extends KbAndroidModelUser implements View.OnClickListener {
	private int id;
	private CastlePanel view;

	public GarnisonListener(CastlePanel view, int id) {
		this.view = view;
		this.id = id;
	}

	@Override
	public void onClick(View v) {
		getGlobalPlayer().garnisonUnit(id, view.getGarnison());
	}
}
