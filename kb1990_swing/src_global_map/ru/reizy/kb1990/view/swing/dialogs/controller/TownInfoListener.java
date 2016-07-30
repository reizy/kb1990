package ru.reizy.kb1990.view.swing.dialogs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.residence.Town;
import ru.reizy.kb1990.model.globalmap.villains.Villain;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.VilliansInfo;

public class TownInfoListener implements ActionListener {
	private final KBModel model;
	private final KBGlobalViewI gView;

	public TownInfoListener(KBModel model, KBGlobalViewI gView) {
		this.model = model;
		this.gView = gView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Town town = model.getGlobalPlayer().getActiveTown();
		Castle castle = town.getCastle();
		String s;
		s = "Замок " + NameResolver.getCastleName(castle) + " под ";
		final Hero hero = castle.getHero();
		if (hero instanceof Villain) {
			Villain v = (Villain) hero;
			s += " управлением " + VilliansInfo.get(v).getName() + "\n";
			model.getGlobalPlayer().checkCastleInfo(castle);
		} else {
			s += "ничьим управлением.\n";
		}
		for (int i = 0; i < castle.getArmy().size(); i++) {
			s += NameResolver.getCountText(castle.getArmyCount(i)) + " ";
			s += NameResolver.getUnitName(castle.getArmy(i)) + "\n";
		}

		gView.showMessage(s);
	}
}
