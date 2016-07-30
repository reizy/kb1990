package ru.reizy.kb1990.view.swing;

import static ru.reizy.kb1990.model.globalmap.FieldType.ACTIVE;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSHES;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLES;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_S;
import static ru.reizy.kb1990.model.globalmap.FieldType.ENEMY;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILLS;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOLS;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_O;
import static ru.reizy.kb1990.model.globalmap.FieldType.SANDS;

import java.awt.Color;

import ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType;
import ru.reizy.kb1990.model.globalmap.FieldType;

public class ColorResolver {

	// миникарта
	private static final Color C_HILL = get64(18);
	private static final Color C_SAND = get64(31);// new Color(255, 255, 85);
	private static final Color C_SEA = get64(32);// new Color(0, 0, 170);
	private static final Color C_POOL = get64(53);// new Color(85, 85, 255);
	private static final Color C_BUSH = get64(8);// new Color(0, 170, 0);
	private static final Color C_GRASS = get64(29);// new Color(85, 255, 85);
	private static final Color C_ACTIVE = get64(23);// new Color(255, 85, 85);
	private static final Color C_ACTIVEX = get64(55);// new Color(255, 85, 255);
	private static final Color C_CASTLE = get64(63);

	// миникарта
	private static final Color C_RES_CASTLE = get64(34);
	private static final Color C_RES_PLAINS = get64(42);
	private static final Color C_RES_FOREST = get64(8);
	private static final Color C_RES_HILLS = get64(32);
	private static final Color C_RES_DUNGEON = get64(2);
	private static final Color C_RES_NULL = get64(21);

	// other
	public static final Color C_PASLE_SMOG_1 = get64(2);
	public static final Color C_PASLE_SMOG_2 = get64(0);
	
	private static Color get64(int i) {
		return new Color(i % 4 * 85, i / 4 % 4 * 85, i / 16 % 4 * 85);
	}

	public static Color getMinimapFieldColor(FieldType f) {
		Color p = Color.BLACK;
		if (f != null) {
			if (ACTIVE.contains(f)) {
				p = C_ACTIVE;
				if (f == ENEMY) {
					p = C_ACTIVEX;
				}
			} else if (SANDS.contains(f)) {
				p = C_SAND;
			} else if (BUSHES.contains(f)) {
				p = C_BUSH;
			} else if (HILLS.contains(f)) {
				p = C_HILL;
			} else if (POOLS.contains(f)) {
				if (f == POOL_O) {
					p = C_SEA;
				} else {
					p = C_POOL;
				}
			} else if (CASTLES.contains(f)) {
				if (f == CASTLE_S) {
					p = C_GRASS;
				} else {
					p = C_CASTLE;
				}
			} else {
				p = C_GRASS;
			}
		}

		return p;
	}

	public static Color getResidenceColor(UnitsResidenceType r) {
		if (r == null) {
			return C_RES_NULL;
		}
		switch (r) {
		case CASTLE:
			return C_RES_CASTLE;
		case PLAINS:
			return C_RES_PLAINS;
		case FOREST:
			return C_RES_FOREST;
		case HILLS:
			return C_RES_HILLS;
		case DUNGEON:
			return C_RES_DUNGEON;
		default:
			return C_RES_NULL;
		}

	}
}
