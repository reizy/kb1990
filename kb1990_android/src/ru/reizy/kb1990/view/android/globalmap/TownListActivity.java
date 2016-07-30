package ru.reizy.kb1990.view.android.globalmap;

import java.util.Set;

import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.residence.Town;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class TownListActivity extends TeleportationListActivity<Town> {

	@Override
	protected Set<Town> getTSet() {
		final GlobalPlayer globalPlayer = getModel().getGlobalPlayer();
		final Set<Town> avaibleTowns = globalPlayer.getAvaibleTowns();
		return avaibleTowns;
	}

	@Override
	protected String objectToString(Town t) {
		String s = t.getName();
		if (isSpellOnTownPortalVisible()) {
			s += "\n( В продаже '" + NameResolver.getMagicName(t.getSpell()) + "')";
		}
		return s;
	}

	/** get options from xml */
	protected boolean isSpellOnTownPortalVisible() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		return prefs.getBoolean("spellOnTownPortalVisible", true);
	}
}
