package ru.reizy.kb1990.controller.android.town;

import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.residence.Town;
import ru.reizy.kb1990.model.globalmap.villains.Villain;
import ru.reizy.kb1990.view.android.KbAndroidModelUser;
import ru.reizy.kb1990.view.android.globalmap.town.TownPanel;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import ru.reizy.kb1990.view.android.villain.VilliansInfo;
import ru.reizy.kb1990.view.strings.StringConstants;
import android.view.View;

public class TownInfoListener extends KbAndroidModelUser implements View.OnClickListener {
	private final TownPanel gView;

	public TownInfoListener(TownPanel gView) {
		this.gView = gView;
	}

	@Override
	public void onClick(View view) {
		Town town = getGlobalPlayer().getActiveTown();
		Castle castle = town.getCastle();
		final String name = NameResolver.getCastleName(castle);
		final String owner;
		final Hero hero = castle.getHero();
		if (hero instanceof Villain) {
			Villain v = (Villain) hero;
			owner = VilliansInfo.get(v).getName();
			getGlobalPlayer().checkCastleInfo(castle);
		} else if (hero == null) {
			owner = getGlobalPlayer().getHero().getName();
		} else {
			owner = StringConstants.BAND;
		}
		String[] unitsInfo = { "", "", "", "", "", "", "", "", "", "" };
		for (int i = 0; i < castle.getArmy().size(); i++) {
			unitsInfo[i] = NameResolver.getCountText(castle.getArmyCount(i)) + " " + NameResolver.getUnitName(castle.getArmy(i));
		}
		String s = String.format(StringConstants.TOWN_CASTLE_INFO_FULL, name, owner, //
				unitsInfo[0], unitsInfo[1], unitsInfo[2], unitsInfo[3], //
				unitsInfo[4], unitsInfo[5], unitsInfo[6], unitsInfo[7]);
		gView.showMessage(s);
	}
}
