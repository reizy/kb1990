package ru.reizy.kb1990.view.android.globalmap;

import static ru.reizy.kb1990.model.globalmap.FieldType.ACTIVE;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSHES;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLES;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_S;
import static ru.reizy.kb1990.model.globalmap.FieldType.ENEMY;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILLS;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOLS;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_O;
import static ru.reizy.kb1990.model.globalmap.FieldType.SANDS;
import static ru.reizy.kb1990.model.globalmap.FieldType.SIGNPOST;
import static ru.reizy.kb1990.model.globalmap.FieldType.TOWN;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.Content;
import ru.reizy.kb1990.model.globalmap.FieldType;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.magic.Bridge;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.residence.Residence;
import ru.reizy.kb1990.model.globalmap.residence.Town;
import ru.reizy.kb1990.model.globalmap.treasure.Treasure;
import ru.reizy.kb1990.view.android.KbViewOptions;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;

public class MinimapUtils {
	public static final int SIZE = 4;
	public static final int MAP_SIZE = 64;

	private static final int C_HILL = get64(18);
	private static final int C_SAND = get64(31);// new Color(255, 255, 85);
	private static final int C_SEA = get64(32);// new Color(0, 0, 170);
	private static final int C_POOL = get64(53);// new Color(85, 85, 255);
	private static final int C_BUSH = get64(8);// new Color(0, 170, 0);
	private static final int C_GRASS = get64(29);// new Color(85, 255, 85);
	private static final int C_ACTIVE = get64(23);// new Color(255, 85, 85);
	private static final int C_ENEMY = get64(3);// new Color(255, 85, 255);
	private static final int C_TOWN = get64(54);// new Color(255, 85, 255);
	private static final int C_SIGNPOST = C_TOWN;// new Color(255, 85, 255);
	private static final int C_TREASURE = get64(10);// new Color(255, 85, 255);
	private static final int C_RESIDENCE = get64(59);// new Color(255, 85, 255);
	private static final int C_CASTLE = get64(63);
	private static final int C_CASTLE_PLAYER = C_TREASURE;
	private static final int C_CASTLE_ENEMY = C_ENEMY;

	protected static int get64(int i) {
		return Color.rgb(i % 4 * 85, i / 4 % 4 * 85, i / 16 % 4 * 85);
	}

	static void fillMinimap(Canvas g, Canvas g1, Canvas g2, Canvas g3, GlobalMap map, GlobalPlayer player, boolean masked, KbViewOptions options) {
		final int FIELD_WIDTH = map.getFieldWidth();
		final int FIELD_HEIGHT = map.getFieldHeight();
		final Paint paint = new Paint();
		final Cell cell = player.getCell();
		g1.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
		g2.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
		g3.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
		for (int i = 0; i < FIELD_WIDTH; i++) {
			for (int j = 0; j < FIELD_HEIGHT; j++) {
				int x = i * SIZE;
				int y = (FIELD_HEIGHT - j - 1) * SIZE;
				FieldType f = null;
				boolean unhidden = player.getUnhidden()[i][j];
				if (unhidden || (!masked)) {
					if (map.getCell(i, j).getContent() instanceof Bridge) {
						paint.setColor(Color.LTGRAY);
					} else {
						f = map.getFieldType(i, j);
						Content c = map.getCell(i, j).getContent();
						paint.setColor(getMinimapFieldColor(f, c, options));
					}
				} else {
					paint.setColor(Color.BLACK);
				}

				g.drawRect(x, y, x + SIZE, y + SIZE, paint);

				if ((cell.getX() == i) && (cell.getY() == j)) {
					paint.setColor(Color.RED);
					g1.drawRect(x, y, x + SIZE, y + SIZE, paint);
					paint.setColor(Color.BLACK);
					g2.drawRect(x, y, x + SIZE, y + SIZE, paint);
					paint.setColor(Color.BLUE);
					g3.drawRect(x, y, x + SIZE, y + SIZE, paint);
				}
			}
		}
	}

	private static int getMinimapFieldColor(FieldType f, Content c, KbViewOptions options) {
		int p = Color.BLACK;
		if (f != null) {
			if (ACTIVE.contains(f)) {
				p = C_ACTIVE;
				if (options.isRichMinimap()) {
					if (f == ENEMY) {
						p = C_ENEMY;
					} else if (f == SIGNPOST) {
						p = C_SIGNPOST;
					} else if (f == TOWN) {
						p = C_TOWN;
					} else if (c != null) {
						if (c instanceof Castle) {
							Castle castle = (Castle) c;
							if (castle.getHero() == null) {
								p = C_CASTLE_PLAYER;
							} else {
								p = C_CASTLE_ENEMY;
							}
						} else if (c instanceof Town) {
							p = C_TOWN;
						} else if (c instanceof Residence) {
							p = C_RESIDENCE;
						} else if (c instanceof Treasure) {
							p = C_TREASURE;
						}
					}
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
}
