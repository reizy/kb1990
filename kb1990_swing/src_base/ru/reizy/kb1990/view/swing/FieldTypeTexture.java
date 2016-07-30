package ru.reizy.kb1990.view.swing;

import static ru.reizy.kb1990.model.globalmap.FieldType.BONUS;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_B;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_I;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_ILB;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_ILT;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_IRB;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_IRT;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_L;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_O;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_OLB;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_OLT;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_ORB;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_ORT;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_R;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_T;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_B;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_BL;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_BR;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_S;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_T;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_TL;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_TR;
import static ru.reizy.kb1990.model.globalmap.FieldType.ENEMY;
import static ru.reizy.kb1990.model.globalmap.FieldType.GRASS;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_B;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_I;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_ILB;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_ILT;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_IRB;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_IRT;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_L;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_O;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_OLB;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_OLT;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_ORB;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_ORT;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_R;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_T;
import static ru.reizy.kb1990.model.globalmap.FieldType.MAGE;
import static ru.reizy.kb1990.model.globalmap.FieldType.PLAYER;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_B;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_I;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_ILB;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_ILT;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_IRB;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_IRT;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_L;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_O;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_OLB;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_OLT;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_ORB;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_ORT;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_R;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_T;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_B;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_I;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_ILB;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_ILT;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_IRB;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_IRT;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_L;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_O;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_OLB;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_OLT;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_ORB;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_ORT;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_R;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_T;
import static ru.reizy.kb1990.model.globalmap.FieldType.SHIP;
import static ru.reizy.kb1990.model.globalmap.FieldType.SIGNPOST;
import static ru.reizy.kb1990.model.globalmap.FieldType.TOWN;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import ru.reizy.kb1990.model.globalmap.FieldType;

public class FieldTypeTexture {

	private static final Map<FieldType, Point> bg = new HashMap<FieldType, Point>();
	private static final Map<Point, FieldType> bgInv = new HashMap<Point, FieldType>();

	static {
		put(HILL_ILB, 0, 0);
		put(SAND_ILB, 2, 0);
		put(BUSH_ILB, 4, 0);
		put(POOL_ILB, 6, 0);
		put(HILL_IRB, 1, 0);
		put(SAND_IRB, 3, 0);
		put(BUSH_IRB, 5, 0);
		put(POOL_IRB, 7, 0);
		put(HILL_ILT, 0, 1);
		put(SAND_ILT, 2, 1);
		put(BUSH_ILT, 4, 1);
		put(POOL_ILT, 6, 1);
		put(HILL_IRT, 1, 1);
		put(SAND_IRT, 3, 1);
		put(BUSH_IRT, 5, 1);
		put(POOL_IRT, 7, 1);
		put(HILL_OLB, 0, 2);
		put(SAND_OLB, 2, 2);
		put(BUSH_OLB, 4, 2);
		put(POOL_OLB, 6, 2);
		put(HILL_ORB, 1, 2);
		put(SAND_ORB, 3, 2);
		put(BUSH_ORB, 5, 2);
		put(POOL_ORB, 7, 2);
		put(HILL_OLT, 0, 3);
		put(SAND_OLT, 2, 3);
		put(BUSH_OLT, 4, 3);
		put(POOL_OLT, 6, 3);
		put(HILL_ORT, 1, 3);
		put(SAND_ORT, 3, 3);
		put(BUSH_ORT, 5, 3);
		put(POOL_ORT, 7, 3);
		put(HILL_L, 0, 4);
		put(SAND_L, 2, 4);
		put(BUSH_L, 4, 4);
		put(POOL_L, 6, 4);
		put(HILL_R, 1, 4);
		put(SAND_R, 3, 4);
		put(BUSH_R, 5, 4);
		put(POOL_R, 7, 4);
		put(HILL_T, 0, 5);
		put(SAND_T, 2, 5);
		put(BUSH_T, 4, 5);
		put(POOL_T, 6, 5);
		put(HILL_B, 1, 5);
		put(SAND_B, 3, 5);
		put(BUSH_B, 5, 5);
		put(POOL_B, 7, 5);
		put(HILL_O, 8, 3);
		put(SAND_O, 9, 3);
		put(BUSH_O, 10, 3);
		put(POOL_O, 8, 4);
		put(HILL_I, 10, 5);
		put(SAND_I, 9, 5);
		put(BUSH_I, 8, 5);
		put(POOL_I, 10, 4);
		put(CASTLE_TL, 8, 0);
		put(CASTLE_T, 9, 0);
		put(CASTLE_TR, 10, 0);
		put(CASTLE_BL, 8, 1);
		put(CASTLE_B, 9, 1);
		put(CASTLE_BR, 10, 1);
		put(CASTLE_S, 9, 2);
		put(GRASS, 9, 4);
		put(TOWN, 10, 2);
		put(SIGNPOST, 8, 2);
		put(ENEMY, 11, 1);
		put(BONUS, 11, 0);
		put(MAGE, 11, 2);
		put(SHIP, 11, 3);
		put(PLAYER, 11, 4);
	}

	private static void put(FieldType f, int x, int y) {
		Point p = new Point(x, y);
		bg.put(f, p);
		bgInv.put(p, f);
	}

	public static Point get(FieldType f) {
		if (f == null) {
			f = POOL_O;
		}
		Point p = bg.get(f);
		return p;
	}

	public static FieldType getInv(int x, int y) {
		FieldType f = bgInv.get(new Point(x, y));
		if (f == null) {
			f = POOL_O;
		}
		return f;
	}
}
