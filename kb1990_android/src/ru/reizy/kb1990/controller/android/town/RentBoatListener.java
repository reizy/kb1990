package ru.reizy.kb1990.controller.android.town;

import ru.reizy.kb1990.view.android.KbAndroidModelUser;
import android.view.View;

public class RentBoatListener extends KbAndroidModelUser implements View.OnClickListener {

	@Override
	public void onClick(View v) {
		getGlobalPlayer().buyShip();
	}
}
