package ru.reizy.kb1990.controller.android.castle;

import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.view.android.KbAndroidModelUser;
import ru.reizy.kb1990.view.android.globalmap.castle.CastleActivity;
import android.view.View;

public class CastleActionListener extends KbAndroidModelUser implements View.OnClickListener {
	private CastleActivity view;

	public CastleActionListener(CastleActivity view) {
		this.view = view;
	}

	@Override
	public void onClick(View v) {
		GlobalPlayer player = getGlobalPlayer();
		Castle activeCastle = player.getActiveCastle();
		boolean e1 = (activeCastle == null);
		boolean e2 = ((!e1) && (activeCastle.getHero() == null));
		boolean e3 = e2 && view.getGarnison();
		boolean e4 = e2 && !view.getGarnison();
		boolean e5 = ((!e1) && (!e2) && (player.hasSeigeWeapon()));
		if (e5) {
			actionAtack();
		} else if (e3) {
			actionRemove();
		} else if (e4) {
			actionGarnison();
		}
	}

	private void actionRemove() {
		view.setGarrison(false);
		view.update();
	}

	private void actionGarnison() {
		view.setGarrison(true);
		view.update();
	}

	private void actionAtack() {
		if (getGlobalPlayer().hasSeigeWeapon()) {
			getGlobalPlayer().getActiveCastle().atackEnemy();
		}
	}

}
