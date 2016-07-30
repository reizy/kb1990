package ru.reizy.kb1990.controller.android.residence;

import ru.reizy.kb1990.view.android.KbAndroidModelUser;
import android.view.View;

public class BuyUnitListener extends KbAndroidModelUser implements View.OnClickListener {
	private int count;

	public BuyUnitListener(int count) {
		this.count = count;
	}

	@Override
	public void onClick(View v) {
		getGlobalPlayer().buyUnit(count);
	}
}
