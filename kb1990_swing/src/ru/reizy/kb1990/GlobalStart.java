package ru.reizy.kb1990;

import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.base.artifact.Artifact;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.Difficulty;
import ru.reizy.kb1990.model.globalmap.GlobalHero;
import ru.reizy.kb1990.model.globalmap.PlayerType;
import ru.reizy.kb1990.view.swing.View;

public class GlobalStart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.getProperties().put("log4j.configuration", "ru/reizy/kb1990/log4j.properties");

		KBModel model = new KBModelDefault("Username", PlayerType.SORCERESS, Difficulty.EASY);
		model.getGlobalPlayer().getHero().addSpell(TravelSpells.BridgeSpell);
		model.getGlobalPlayer().getHero().addLeadership(9999);
		model.getGlobalPlayer().getHero().addToArmy(UnitTypes.DRAGONS);
		for (int i = 0; i < model.getGlobalPlayer().getMaps().size(); i++) {
			System.out.println(model.getGlobalPlayer().getMaps().get(i).nextMapTreasureCell);
		}
		new View(model);

	}
	
	/**
	 * @param args
	 */
	public static void main2(String[] args) {

		System.getProperties().put("log4j.configuration", "ru/reizy/kb1990/log4j.properties");

		KBModel model = new KBModelDefault("Username", PlayerType.SORCERESS, Difficulty.EASY);
		model.getGlobalPlayer().getHero().addSpell(TravelSpells.BridgeSpell);
		model.getGlobalPlayer().getHero().addLeadership(99999);
		model.getGlobalPlayer().getHero().addToArmy(UnitTypes.ARCHERS, 150);
		model.getGlobalPlayer().getHero().addToArmy(UnitTypes.ELVES, 150);
		model.getGlobalPlayer().getHero().addToArmy(UnitTypes.ARCHMAGES, 25);
		model.getGlobalPlayer().getHero().addPasleElement(Artifact.artifacts[6]);
		for (int i = 0; i < model.getGlobalPlayer().getMaps().size(); i++) {
			System.out.println(model.getGlobalPlayer().getMaps().get(i).nextMapTreasureCell);
		}
		new View(model);

		Hero hero = new Hero(6, 99999);
		hero.addToArmy(UnitTypes.DRAGONS, 3);
		GlobalHero h = new GlobalHero(hero);
		h.goTo(model.getGlobalMap().getCell(10, 10));
	}
}
