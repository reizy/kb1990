package ru.reizy.kb1990.view.android.globalmap.kingcastle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.globalmap.residence.KingCastle;
import ru.reizy.kb1990.view.android.KbAndroidModelUser;
import android.view.View;

public class SelectUnitListener extends KbAndroidModelUser implements View.OnClickListener {
	private static final Logger log = LoggerFactory.getLogger(SelectUnitListener.class);
	private int index;
	private KingCastleActivity view;

	SelectUnitListener(KingCastleActivity view, int index) {
		this.index = index;
		this.view = view;
	}

	@Override
	public void onClick(View v) {
		KingCastle activeKingCastle = getGlobalPlayer().getActiveKingCastle();
		if (activeKingCastle != null) {
			activeKingCastle.setUnitIndex(index);
			view.showCount();
		} else {
			log.error("вы не в замке короля");
		}
	}
}
