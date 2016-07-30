package ru.reizy.kb1990.view.swing.globalmap.view;

import java.awt.Point;

import ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType;
import ru.reizy.kb1990.model.globalmap.Content;
import ru.reizy.kb1990.model.globalmap.GlobalHero;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence;
import ru.reizy.kb1990.model.globalmap.treasure.ArtifactTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.Treasure;

public class ActiveTexture {

	private static final Point[] bg = new Point[20];
	private static final int ENEMY_1 = 0;
	private static final int ENEMY_2 = 1;
	private static final int ENEMY_3 = 2;
	private static final int ENEMY_4 = 3;
	private static final int ART_1 = 4;
	private static final int ART_2 = 5;
	private static final int ART_3 = 6;
	private static final int ART_4 = 7;
	private static final int ART_5 = 8;
	private static final int ART_6 = 9;
	private static final int ART_7 = 10;
	private static final int ART_8 = 11;
	private static final int HOUSE_1 = 12;
	private static final int HOUSE_2 = 13;
	private static final int HOUSE_3 = 14;
	private static final int HOUSE_4 = 15;
	private static final int TREASHURE = 16;

	static {
		put(ENEMY_1, 0, 0);
		put(ENEMY_2, 0, 1);
		put(ENEMY_3, 0, 2);
		put(ENEMY_4, 0, 3);
		put(ART_1, 1, 0);
		put(ART_3, 1, 1);
		put(ART_5, 1, 2);
		put(ART_7, 1, 3);
		put(ART_2, 2, 0);
		put(ART_4, 2, 1);
		put(ART_6, 2, 2);
		put(ART_8, 2, 3);
		put(HOUSE_1, 3, 0);
		put(HOUSE_2, 3, 1);
		put(HOUSE_3, 3, 2);
		put(HOUSE_4, 3, 3);
		put(TREASHURE, 4, 0);

	}

	public static Point get(Content f) {
		Point p = null;
		if (f != null) {
			if (f instanceof Treasure) {
				p = get((Treasure) f);
			} else if (f instanceof GlobalHero) {
				p = get((GlobalHero) f);
			} else if (f instanceof SimpleUnitResidence) {
				p = get((SimpleUnitResidence) f);
			}
		}
		return p;

	}

	private static Point get(Treasure f) {
		Point p = null;
		if (f instanceof ArtifactTreasure) {
			p = bg[ART_1 + ((ArtifactTreasure) f).getPower()];
		} else {
			p = bg[TREASHURE];
		}
		return p;
	}

	private static Point get(SimpleUnitResidence f) {
		Point p = null;
		SimpleUnitResidence ur = (SimpleUnitResidence) f;
		UnitsResidenceType type = ur.getType();
		switch (type) {
		case DUNGEON:
			p = bg[HOUSE_4];
			break;
		case FOREST:
			p = bg[HOUSE_2];
			break;
		case HILLS:
			p = bg[HOUSE_3];
			break;
		default:
			p = bg[HOUSE_1];
			break;
		}
		return p;
	}

	private static Point get(GlobalHero f) {
		Point p = null;
		switch (f.getHero().getRank()) {
		case 1:
			p = bg[ENEMY_1];
			break;
		case 2:
			p = bg[ENEMY_2];
			break;
		case 3:
			p = bg[ENEMY_3];
			break;
		case 4:
			p = bg[ENEMY_4];
			break;
		default:
			p = bg[ENEMY_1];
			break;
		}
		return p;
	}

	private static void put(int type, int i, int j) {
		bg[type] = new Point(i, j);
	}

}
