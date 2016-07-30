package ru.reizy.kb1990.view.android.globalmap;

import java.util.Set;

import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.residence.Castle;

public class CastleListActivity extends TeleportationListActivity<Castle> {

	@Override
	protected Set<Castle> getTSet() {
		final GlobalPlayer globalPlayer = getModel().getGlobalPlayer();
		final Set<Castle> avaibleCastles = globalPlayer.getAvaibleCastles();
		return avaibleCastles;
	}

	@Override
	protected String objectToString(Castle t) {
		return t.getName();
	}

}
