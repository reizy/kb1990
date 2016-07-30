package ru.reizy.kb1990.view.android.pasle;

import java.util.List;
import java.util.Set;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.base.artifact.Artifact;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.Content;
import ru.reizy.kb1990.model.globalmap.FieldType;
import ru.reizy.kb1990.model.globalmap.GlobalHero;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.residence.Bonus;
import ru.reizy.kb1990.model.globalmap.villains.Villain;
import ru.reizy.kb1990.view.android.globalmap.KBInfoPanel;
import ru.reizy.kb1990.view.android.resource.FieldTypeTexture;
import ru.reizy.kb1990.view.android.resource.VillainsTexture;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ImageView;

public class PaslePanel extends KBInfoPanel {

	public static final int FIELD_WIDTH = 6 - 1;
	public static final int FIELD_HEIGHT = 5;
	private final Drawable TRANSP;

	private final ImageView[][] fieldImg;
	private final FieldTypeTexture texture;
	private final VillainsTexture villainsTexture;

	public PaslePanel(PasleActivity pasleActivity, Window mWindow, Resources resources) {
		super(mWindow, resources, 0);

		TRANSP = (BitmapDrawable) getResources().getDrawable(R.drawable.transparent);

		this.fieldImg = getImageViewField(
		//
				R.id.field_0_0, R.id.field_1_0, R.id.field_2_0, R.id.field_3_0, R.id.field_4_0, R.id.field_5_0, //
				R.id.field_0_1, R.id.field_1_1, R.id.field_2_1, R.id.field_3_1, R.id.field_4_1, R.id.field_5_1, //
				R.id.field_0_2, R.id.field_1_2, R.id.field_2_2, R.id.field_3_2, R.id.field_4_2, R.id.field_5_2, //
				R.id.field_0_3, R.id.field_1_3, R.id.field_2_3, R.id.field_3_3, R.id.field_4_3, R.id.field_5_3, //
				R.id.field_0_4, R.id.field_1_4, R.id.field_2_4, R.id.field_3_4, R.id.field_4_4, R.id.field_5_4 //
		);

		this.texture = new FieldTypeTexture(getResources());
		this.villainsTexture = new VillainsTexture(getResources());

		Cell cell = getGlobalPlayer().getCell();
		fillField(cell.getX(), cell.getY());

		update();
	}

	private ImageView[][] getImageViewField(int... ids) {
		final ImageView[][] field = new ImageView[6][5];
		final int W = field.length;
		final int H = field[0].length;
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				final int n = i + j * W;
				if (ids.length > n) {
					field[i][j] = (ImageView) findViewById(ids[n]);
				}
			}
		}
		return field;
	}

	private void fillField(int vx, int vy) {
		final GlobalMap map = getGlobalPlayer().getPasleAimCell().getMap();
		BitmapDrawable transparent = (BitmapDrawable) getResources().getDrawable(R.drawable.transparent);
		for (int i = 0; i < FIELD_WIDTH; i++) {
			for (int j = 0; j < FIELD_HEIGHT; j++) {
				int x = i;
				int y = (FIELD_HEIGHT - j - 1);
				fieldImg[x][y].setImageDrawable(transparent);
				FieldType f = map.getFieldType(vx - FIELD_WIDTH / 2 + i, vy - FIELD_HEIGHT / 2 + j);
				// исключение для врагов - они анимируются
				if ((f == FieldType.ENEMY) || (f == FieldType.BONUS)) {
					f = FieldType.GRASS;
				}
				// отрисовка за границей карты
				if (f == null) {
					fieldImg[x][y].setBackgroundColor(Color.BLACK);
				} else { // отрисовка элемента карты
					BitmapDrawable k = texture.getTexture(f);
					fieldImg[x][y].setBackgroundDrawable(k);
				}

				Cell cell = map.getCell(vx - FIELD_WIDTH / 2 + i, vy - FIELD_HEIGHT / 2 + j);
				if (cell != null) {
					// отрисовка бонуса
					final Content content = cell.getContent();
					if (content instanceof Bonus) {
						drawBonus(fieldImg[x][y], content);
					}
					if (content instanceof GlobalHero) {
						drawHero(fieldImg[x][y], (GlobalHero) content);
					}
				}
			}
		}
	}

	private void drawBonus(ImageView g, Content content) {
		Drawable k = texture.getActive(content);
		g.setImageDrawable(k);
	}

	private void drawHero(ImageView g, GlobalHero gHero) {
		if (gHero.getHero().getRank() > 0) {
			drawBonus(g, gHero);
		} else {
			drawUnit(g, gHero.getHero().getArmy(0));
		}
	}

	private void drawUnit(ImageView g, UnitType unit) {
		drawUnit(g, UnitTypes.get(unit));
	}

	private void drawUnit(ImageView g, UnitTypes unit) {
		BitmapDrawable k = texture.getUnit(unit);
		g.setBackgroundDrawable(k);
	}

	private void updateMask() {
		stopAnimation();
		boolean[][] b = getGlobalPlayer().getHero().getPasleMask();
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				fieldImg[i][j].setImageDrawable(TRANSP);
			}
		}
		List<Villain> av = getGlobalPlayer().getHero().getAliveVillains();
		for (Villain v : av) {
			if (v != null) {
				int resId = villainsTexture.villains_a.get(v.getId());
				int i = v.getPasleX();
				int j = v.getPasleY();
				fieldImg[i][j].setImageResource(resId);
				Drawable d = fieldImg[i][j].getDrawable();
				if (d instanceof AnimationDrawable) {
					AnimationDrawable o = (AnimationDrawable) d;
					if (!o.isRunning()) {
						o.start();
					}
				}
			}
		}
		Artifact[] af = Artifact.artifacts;
		Set<Artifact> af_opened = getGlobalPlayer().getHero().getArtifacts();
		for (int i = 0; i < af.length; i++) {
			Artifact v = af[i];
			if (v != null) {
				if (!af_opened.contains(v)) {
					int resId = villainsTexture.artifacts_i.get(i);
					int x = v.getPasleX();
					int y = v.getPasleY();
					fieldImg[x][y].setImageResource(resId);
				}
			}
		}
	}

	public void stopAnimation() {
		for (int i = 0; i < fieldImg.length; i++) {
			for (int j = 0; j < fieldImg[i].length; j++) {
				Drawable d = fieldImg[i][j].getDrawable();
				if (d instanceof AnimationDrawable) {
					AnimationDrawable o = (AnimationDrawable) d;
					if (o.isRunning()) {
						o.stop();
					}
				}
			}
		}
	}

	public void update() {
		Cell cell = getGlobalPlayer().getPasleAimCell();
		fillField(cell.getX(), cell.getY());
		updatePasleMap();
		updateMoney();
		updateContract();
		updateSiege();
		updateMagic();
		updateMask();
	}

	@Override
	protected void onNoInfo() {
		// TODO Auto-generated method stub
	}

}
