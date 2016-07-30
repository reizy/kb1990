package ru.reizy.kb1990.view.android.globalmap;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.globalmap.villains.Villain;
import ru.reizy.kb1990.view.android.KbAndroidMessagePanel;
import ru.reizy.kb1990.view.android.resource.VillainsTexture;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ImageView;

public abstract class KBInfoPanel extends KbAndroidMessagePanel {

	private final Drawable TRANSP;

	private final VillainsTexture villainsTexture;

	private final ImageView contractCell;
	private final ImageView siegeCell;
	private final ImageView magicCell;
	private final ImageView pasleCell;
	private final ImageView moneyCell;

	public KBInfoPanel(Window mWindow, Resources resources, int infoId) {
		super(mWindow, resources, infoId);

		TRANSP = (BitmapDrawable) getResources().getDrawable(R.drawable.transparent);

		this.villainsTexture = new VillainsTexture(getResources());

		contractCell = (ImageView) findViewById(R.id.field_5_0);
		siegeCell = (ImageView) findViewById(R.id.field_5_1);
		magicCell = (ImageView) findViewById(R.id.field_5_2);

		pasleCell = (ImageView) findViewById(R.id.field_5_3);
		{
			final Bitmap bm = Bitmap.createBitmap(96, 68, Bitmap.Config.ARGB_8888);
			this.pasleCell.setImageBitmap(bm);
		}
		this.moneyCell = (ImageView) findViewById(R.id.field_5_4);
		{
			final Bitmap bm = Bitmap.createBitmap(96, 68, Bitmap.Config.ARGB_8888);
			this.moneyCell.setImageBitmap(bm);
		}

	}

	public final void updatePasleMap() {
		final BitmapDrawable bmd = (BitmapDrawable) pasleCell.getDrawable();
		final Bitmap bm = bmd.getBitmap();
		final Canvas g = new Canvas(bm);
		final boolean[][] p = getGlobalPlayer().getHero().getPasleMask();
		final int b = 2;
		final int vb = 2;
		final int hb = 2;
		final float w = (1.0f * g.getWidth() - 2 * hb) / p.length;
		final float h = (1.0f * g.getHeight() - 2 * vb) / p[0].length;
		g.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[0].length; j++) {
				if (!p[i][j]) {
					Paint paint = new Paint();
					paint.setColor(get64(0));
					g.drawRect(hb + w * i, vb + h * j, hb + w * (i + 1), vb + h * (j + 1), paint);
					paint.setColor(get64(2));
					g.drawRect(hb + w * i, vb + h * j, hb + w * (i + 1) - b, vb + h * (j + 1) - b, paint);
				}
			}
		}
	}

	public final void updateMoney() {
		final int MONEY_COIN = 14;
		final int MONEY_VALUE_1 = MONEY_COIN * MONEY_COIN;
		final int MONEY_VALUE_2 = MONEY_VALUE_1 * MONEY_COIN;
		final int MONEY_VALUE_3 = MONEY_VALUE_2 * MONEY_COIN;
		final int MONEY_VALUE_MAX = MONEY_VALUE_3 * MONEY_COIN - 1;
		final Paint paint = new Paint();

		final BitmapDrawable bmd = (BitmapDrawable) moneyCell.getDrawable();
		final Bitmap bm = bmd.getBitmap();
		final Canvas g = new Canvas(bm);
		g.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
		// 4 - 8 - 6 - 8 - 6 - 8 - 7
		final int w = g.getWidth();
		final int h = g.getHeight();
		int[] hx = { w * 11 / 16, w * 13 / 32, w * 2 / 16 };
		int hy = h * 27 / 34;
		int hd = h * 2 / 34;
		int m = getGlobalPlayer().getHero().getMoney();
		m = Math.min(m, MONEY_VALUE_MAX);
		int[] dm = { m / MONEY_VALUE_1, m / MONEY_VALUE_2, m / MONEY_VALUE_3 };
		for (int k = 0; k < 3; k++) {
			int mm = dm[k] % MONEY_COIN;
			for (int i = 0; i < mm; i++) {
				g.drawBitmap(villainsTexture.MONEY[k], hx[k], hy - hd * i, paint);
			}
		}
	}

	public final void updateContract() {
		{
			Drawable o = contractCell.getBackground();
			if (o instanceof AnimationDrawable) {
				((AnimationDrawable) o).stop();
			}
		}
		final Villain contract = getGlobalPlayer().getContract();
		if (contract != null) {
			int resid = villainsTexture.villains_a.get(contract.getId());
			contractCell.setImageResource(resid);
			AnimationDrawable o = (AnimationDrawable) contractCell.getDrawable();
			o.start();
		} else {
			contractCell.setImageDrawable(TRANSP);
		}
	}

	public final void updateSiege() {
		{
			Drawable o = siegeCell.getBackground();
			if (o instanceof AnimationDrawable) {
				((AnimationDrawable) o).stop();
			}
		}
		if (getGlobalPlayer().hasSeigeWeapon()) {
			siegeCell.setImageResource(R.anim.siege);
			AnimationDrawable o = (AnimationDrawable) siegeCell.getDrawable();
			if (!o.isRunning()) {
				o.start();
			}
		} else {
			siegeCell.setImageDrawable(TRANSP);
		}
	}

	public final void updateMagic() {
		{
			Drawable o = magicCell.getBackground();
			if (o instanceof AnimationDrawable) {
				((AnimationDrawable) o).stop();
			}
		}
		if (getGlobalPlayer().getHero().isMagicActive()) {
			magicCell.setImageResource(R.anim.magic);
			AnimationDrawable o = (AnimationDrawable) magicCell.getDrawable();
			if (!o.isRunning()) {
				o.start();
			}
		} else {
			magicCell.setImageDrawable(TRANSP);
		}
	}

}
