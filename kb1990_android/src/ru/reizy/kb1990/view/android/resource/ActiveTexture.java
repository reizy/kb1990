package ru.reizy.kb1990.view.android.resource;

import static ru.reizy.kb1990.R.drawable.bridge_h;
import static ru.reizy.kb1990.R.drawable.bridge_v;
import static ru.reizy.kb1990.R.drawable.interactive_artifact_1;
import static ru.reizy.kb1990.R.drawable.interactive_artifact_2;
import static ru.reizy.kb1990.R.drawable.interactive_artifact_3;
import static ru.reizy.kb1990.R.drawable.interactive_artifact_4;
import static ru.reizy.kb1990.R.drawable.interactive_artifact_5;
import static ru.reizy.kb1990.R.drawable.interactive_artifact_6;
import static ru.reizy.kb1990.R.drawable.interactive_artifact_7;
import static ru.reizy.kb1990.R.drawable.interactive_artifact_8;
import static ru.reizy.kb1990.R.drawable.interactive_enemy_1;
import static ru.reizy.kb1990.R.drawable.interactive_enemy_2;
import static ru.reizy.kb1990.R.drawable.interactive_enemy_3;
import static ru.reizy.kb1990.R.drawable.interactive_enemy_4;
import static ru.reizy.kb1990.R.drawable.interactive_residence_dungeon;
import static ru.reizy.kb1990.R.drawable.interactive_residence_forest;
import static ru.reizy.kb1990.R.drawable.interactive_residence_hills;
import static ru.reizy.kb1990.R.drawable.interactive_residence_plains;
import static ru.reizy.kb1990.R.drawable.textures_active_treshure;
import ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.Content;
import ru.reizy.kb1990.model.globalmap.GlobalHero;
import ru.reizy.kb1990.model.globalmap.magic.Bridge;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence;
import ru.reizy.kb1990.model.globalmap.treasure.ArtifactTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.RandomUnitTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.Treasure;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class ActiveTexture extends Texture {
	private static int SIZE = 0;
	private static final int ENEMY_1 = SIZE++;
	private static final int ENEMY_2 = SIZE++;
	private static final int ENEMY_3 = SIZE++;
	private static final int ENEMY_4 = SIZE++;
	private static final int ART_1 = SIZE++;
	private static final int ART_2 = SIZE++;
	private static final int ART_3 = SIZE++;
	private static final int ART_4 = SIZE++;
	private static final int ART_5 = SIZE++;
	private static final int ART_6 = SIZE++;
	private static final int ART_7 = SIZE++;
	private static final int ART_8 = SIZE++;
	private static final int HOUSE_1 = SIZE++;
	private static final int HOUSE_2 = SIZE++;
	private static final int HOUSE_3 = SIZE++;
	private static final int HOUSE_4 = SIZE++;
	private static final int TREASHURE = SIZE++;
	private static final int BRIDGE_V = SIZE++;
	private static final int BRIDGE_H = SIZE++;
	private final BitmapDrawable[] bg = new BitmapDrawable[SIZE];
	private final UnitsTexture unitsTexture;

	public ActiveTexture(Resources resources, UnitsTexture unitsTexture) {
		super(resources);
		this.unitsTexture = unitsTexture;
		put(ENEMY_1, interactive_enemy_1);
		put(ENEMY_2, interactive_enemy_2);
		put(ENEMY_3, interactive_enemy_3);
		put(ENEMY_4, interactive_enemy_4);
		put(ART_1, interactive_artifact_1);
		put(ART_3, interactive_artifact_3);
		put(ART_5, interactive_artifact_5);
		put(ART_7, interactive_artifact_7);
		put(ART_2, interactive_artifact_2);
		put(ART_4, interactive_artifact_4);
		put(ART_6, interactive_artifact_6);
		put(ART_8, interactive_artifact_8);
		put(HOUSE_1, interactive_residence_plains);
		put(HOUSE_2, interactive_residence_forest);
		put(HOUSE_3, interactive_residence_hills);
		put(HOUSE_4, interactive_residence_dungeon);
		put(TREASHURE, textures_active_treshure);
		put(BRIDGE_V, bridge_v);
		put(BRIDGE_H, bridge_h);

	}

	public Drawable get(Content f) {
		Drawable p = null;
		if (f != null) {
			if (f instanceof Treasure) {
				p = get((Treasure) f);
			} else if (f instanceof GlobalHero) {
				p = get((GlobalHero) f);
			} else if (f instanceof SimpleUnitResidence) {
				p = get((SimpleUnitResidence) f);
			} else if (f instanceof Bridge) {
				p = get((Bridge) f);
			}
		}
		return p;

	}

	private BitmapDrawable get(Bridge f) {
		BitmapDrawable p = null;
		if (f.isVertical()) {
			p = bg[BRIDGE_V];
		} else {
			p = bg[BRIDGE_H];
		}
		return p;
	}

	private Drawable get(Treasure f) {
		Drawable p = null;
		if (f instanceof ArtifactTreasure) {
			p = bg[ART_1 + ((ArtifactTreasure) f).getPower()];
		} else if (f instanceof RandomUnitTreasure) {
			UnitTypes unit = ((RandomUnitTreasure) f).getUnit();
			Integer img_id = unitsTexture.units_l_a.get(unit);
			try {
				p = Drawable.createFromXml(getResources(), getResources().getXml(img_id));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			p = bg[TREASHURE];
		}
		return p;
	}

	private BitmapDrawable get(SimpleUnitResidence f) {
		BitmapDrawable p = null;
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

	private BitmapDrawable get(GlobalHero f) {
		BitmapDrawable p = null;
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

	private void put(int type, int p) {
		BitmapDrawable b = ((BitmapDrawable) getResources().getDrawable(p));
		put(type, b);
	}

	private void put(int type, BitmapDrawable d) {
		bg[type] = d;
	}

}
