package ru.reizy.kb1990.view.android.battle;

import static ru.reizy.kb1990.view.strings.ru.StringConstants.BATTLE_RESULT_BOUNTY;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.BATTLE_RESULT_GLORY;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.BATTLE_RESULT_TITLE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.BATTLE_RESULT_VILLIAN;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.BATTLE_RESULT_VILLIAN_FAIL;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.BATTLE_RESULT_VILLIAN_WIN;

import java.util.Arrays;
import java.util.List;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.controller.android.battle.BattleFieldClickController;
import ru.reizy.kb1990.controller.android.battle.BattleFieldClickListener;
import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.BattleModel;
import ru.reizy.kb1990.model.battle.base.FieldType;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.ShooterUnit;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInView;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.villains.Villain;
import ru.reizy.kb1990.view.android.KbAndroidMessagePanel;
import ru.reizy.kb1990.view.android.KbViewOptions;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import ru.reizy.kb1990.view.android.resource.UnitsTexture;
import ru.reizy.kb1990.view.android.villain.VilliansInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ImageView;

public class BattleFieldPanel extends KbAndroidMessagePanel {
	public static final int FIELD_WIDTH = 6;
	public static final int FIELD_HEIGHT = 5;

	private final Drawable BATTLE_ATACK;
	private final Drawable BATTLE_ATACK_HALF;
	private final Drawable TRANSP;
	private final Drawable[] BATTLE_MASK_M = new Drawable[4];
	private final Drawable[] BATTLE_MASK_A = new Drawable[4];

	private final ImageView backGround;
	private final ImageView[][] fieldImg;
	private final ImageView[][] maskImg;

	private AnimationDrawable o;
	private final UnitsTexture unitsTexture;
	private final KbViewOptions kbViewOptions;

	public BattleFieldPanel(Window mWindow, Resources resources, BattleFieldClickController controller) {
		super(mWindow, resources, R.id.gInfo);

		kbViewOptions = new KbViewOptions();

		TRANSP = (BitmapDrawable) getResources().getDrawable(R.drawable.transparent);

		BATTLE_MASK_M[0] = (BitmapDrawable) getResources().getDrawable(R.drawable.transparent);
		BATTLE_MASK_A[0] = (BitmapDrawable) getResources().getDrawable(R.drawable.transparent);
		BATTLE_MASK_M[1] = (BitmapDrawable) getResources().getDrawable(R.drawable.battle_mask_1_m);
		BATTLE_MASK_A[1] = (BitmapDrawable) getResources().getDrawable(R.drawable.battle_mask_1_a);
		BATTLE_MASK_M[2] = (BitmapDrawable) getResources().getDrawable(R.drawable.battle_mask_2_m);
		BATTLE_MASK_A[2] = (BitmapDrawable) getResources().getDrawable(R.drawable.battle_mask_2_a);
		BATTLE_MASK_M[3] = (BitmapDrawable) getResources().getDrawable(R.drawable.battle_mask_3_m);
		BATTLE_MASK_A[3] = (BitmapDrawable) getResources().getDrawable(R.drawable.battle_mask_3_a);

		BATTLE_ATACK = (BitmapDrawable) getResources().getDrawable(R.drawable.battle_atack);
		BATTLE_ATACK_HALF = (BitmapDrawable) getResources().getDrawable(R.drawable.battle_atack_half);

		this.fieldImg = getImageViewField(null, //
				R.id.field_0_0, R.id.field_1_0, R.id.field_2_0, R.id.field_3_0, R.id.field_4_0, R.id.field_5_0, //
				R.id.field_0_1, R.id.field_1_1, R.id.field_2_1, R.id.field_3_1, R.id.field_4_1, R.id.field_5_1, //
				R.id.field_0_2, R.id.field_1_2, R.id.field_2_2, R.id.field_3_2, R.id.field_4_2, R.id.field_5_2, //
				R.id.field_0_3, R.id.field_1_3, R.id.field_2_3, R.id.field_3_3, R.id.field_4_3, R.id.field_5_3, //
				R.id.field_0_4, R.id.field_1_4, R.id.field_2_4, R.id.field_3_4, R.id.field_4_4, R.id.field_5_4 //
		);
		final int W = fieldImg.length;
		final int H = fieldImg[0].length;
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				final Bitmap bm = Bitmap.createBitmap(96, 68, Bitmap.Config.ARGB_8888);
				fieldImg[i][j].setImageBitmap(bm);
			}
		}
		this.maskImg = getImageViewField(controller, //
				R.id.mask_0_0, R.id.mask_1_0, R.id.mask_2_0, R.id.mask_3_0, R.id.mask_4_0, R.id.mask_5_0, //
				R.id.mask_0_1, R.id.mask_1_1, R.id.mask_2_1, R.id.mask_3_1, R.id.mask_4_1, R.id.mask_5_1, //
				R.id.mask_0_2, R.id.mask_1_2, R.id.mask_2_2, R.id.mask_3_2, R.id.mask_4_2, R.id.mask_5_2, //
				R.id.mask_0_3, R.id.mask_1_3, R.id.mask_2_3, R.id.mask_3_3, R.id.mask_4_3, R.id.mask_5_3, //
				R.id.mask_0_4, R.id.mask_1_4, R.id.mask_2_4, R.id.mask_3_4, R.id.mask_4_4, R.id.mask_5_4 //
		);
		this.backGround = (ImageView) findViewById(R.id.battle_bg);
		this.unitsTexture = new UnitsTexture(getResources());

		fillField();
	}

	private BattleModel getBattleModel() {
		return getModel().getBattleModel();
	}

	KbViewOptions getOptions() {
		return kbViewOptions;
	}

	private int getUnitAnim(UnitTypes unit, boolean isEnemy) {
		int img_id;
		if (isEnemy) {
			img_id = unitsTexture.units_r_a.get(unit);
		} else {
			img_id = unitsTexture.units_l_a.get(unit);
		}
		return img_id;
	}

	private ImageView[][] getImageViewField(final BattleFieldClickController controller, int... ids) {
		final ImageView[][] field = new ImageView[6][5];
		final int W = field.length;
		final int H = field[0].length;
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				final int n = i + j * W;
				if (ids.length > n) {
					field[i][j] = (ImageView) findViewById(ids[n]);
				}
				if (controller != null) {
					field[i][j].setOnClickListener(new BattleFieldClickListener(getModel(), controller, i, j));
				}
			}
		}
		return field;
	}

	public void initiate() {
		// initiation imgs
		fillField();
		printMask(true);
		drawArmies(getBattleModel().getPlayerArmy(), getBattleModel().getEnemyArmy());
	}

	private void fillField() {
		if (getBattleModel().getFieldType(0, 0) == FieldType.WALL) {
			backGround.setBackgroundDrawable((BitmapDrawable) getResources().getDrawable(R.drawable.battle_bg_castle));
			for (int i = 0; i < FIELD_WIDTH; i++) {
				for (int j = 0; j < FIELD_HEIGHT; j++) {
					fieldImg[i][j].setBackgroundDrawable(TRANSP);
				}
			}
		} else {
			backGround.setBackgroundDrawable((BitmapDrawable) getResources().getDrawable(R.drawable.battle_bg_grass));
			for (int i = 0; i < FIELD_WIDTH; i++) {
				for (int j = 0; j < FIELD_HEIGHT; j++) {
					BitmapDrawable img;
					switch (getBattleModel().getFieldType(i, j)) {
					case BUSH:
						img = (BitmapDrawable) getResources().getDrawable(R.drawable.battle_bg_bush);
						break;
					case POOL:
						img = (BitmapDrawable) getResources().getDrawable(R.drawable.battle_bg_pool);
						break;
					case WALL:
						img = (BitmapDrawable) getResources().getDrawable(R.drawable.battle_bg_wall);
						break;
					case HILL:
						img = (BitmapDrawable) getResources().getDrawable(R.drawable.battle_bg_hill);
						break;
					default:
						img = (BitmapDrawable) getResources().getDrawable(R.drawable.transparent);
						break;
					}
					fieldImg[i][j].setBackgroundDrawable(img);
				}
			}
		}
	}

	private void drawUnit(ImageView g, UnitType unit, boolean isEnemy) {
		drawUnit(g, UnitTypes.get(unit), isEnemy);
	}

	private void drawUnit(ImageView g, UnitTypes unit, boolean isEnemy) {
		int img_id = 0;
		if (isEnemy) {
			img_id = unitsTexture.get_r(unit);
		} else {
			img_id = unitsTexture.get_l(unit);
		}
		BitmapDrawable k = (BitmapDrawable) getResources().getDrawable(img_id);
		g.setBackgroundDrawable(k);
	}

	private void clearFieldImg(ImageView imageView) {
		BitmapDrawable k = (BitmapDrawable) imageView.getDrawable();
		Canvas g = new Canvas(k.getBitmap());
		g.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
	}

	private void drawUnitIndicators(Canvas g, int morale, boolean ooc, int hp, int maxHp, int count) {
		// lifebar
		int d = g.getHeight() / 4;
		Paint paint = new Paint();
		if ((getOptions().isLifeBarVisible()) || (getOptions().isMoraleVisible())) {
			RectF oval = new RectF(0, 0, d, d);
			paint.setColor(Color.GRAY);
			g.drawOval(oval, paint);

			int mColor = Color.RED;
			if (getOptions().isMoraleVisible()) {
				switch (morale) {
				case 0:
					mColor = Color.rgb(175, 0, 150);
					break;
				case 1:
					mColor = Color.YELLOW;
					break;
				default:
					mColor = Color.CYAN;
				}
				if (ooc) {
					mColor = Color.RED;
				}
			}

			paint.setColor(mColor);
			oval = new RectF(1, 1, d - 2, d - 2);
			final float life = 360.0f * hp / maxHp;
			if (getOptions().isLifeBarVisible()) {
				g.drawArc(oval, -90.0f, life, true, paint);
			} else {
				g.drawOval(oval, paint);
			}
		}
		// show unit count
		if (getOptions().isUnitCountVisible()) {
			String countStr = Integer.toString(count);
			if (count > 1000) {
				countStr = count / 1000 + "K";
			}
			paint.setTextSize(d);
			Rect bounds = new Rect();
			paint.getTextBounds(countStr, 0, countStr.length(), bounds);
			int textWidth = bounds.width() + 2;
			int textHeight = bounds.height() + 2;
			int x = g.getWidth() - 1 - textWidth;
			int y = g.getHeight() - 1;
			paint.setColor(Color.BLACK);
			g.drawRect(x, y - textHeight, g.getWidth(), g.getHeight(), paint);
			paint.setColor(Color.WHITE);
			g.drawText(countStr, x, y, paint);
		}
	}

	public void drawActiveUnit(ImageView g, UnitType unit, boolean isEnemy) {

		if (o != null) {
			if (o.isRunning()) {
				o.stop();
			}
		}
		if (unit != null) {
			int a = getUnitAnim(UnitTypes.get(unit), isEnemy);
			g.setBackgroundResource(a);
			o = (AnimationDrawable) g.getBackground();
			if (!o.isRunning()) {
				o.start();
			}
		}
	}

	private void drawUnit(UnitInView unit) {
		int x = unit.getLocation().getX();
		int y = unit.getLocation().getY();
		final UnitType type = unit.getType();
		if (unit == getBattleModel().getActiveUnit()) {
			drawActiveUnit(fieldImg[x][y], type, unit.isEnemy());
		} else {
			drawUnit(fieldImg[x][y], type, unit.isEnemy());
		}

		BitmapDrawable k = (BitmapDrawable) fieldImg[x][y].getDrawable();
		drawUnitIndicators(new Canvas(k.getBitmap()), unit.getMorale(), unit.isOutOfControl(), unit.getСurrentHitPoints(), unit.getType().getMaxHitPoints(),
				unit.getCount());

	}

	private void drawArmies(List<? extends UnitInView> list, List<? extends UnitInView> list2) {
		drawArmy(list);
		drawArmy(list2);
	}

	private void drawArmy(List<? extends UnitInView> list) {
		if (list != null) {
			for (UnitInView unit : list) {
				drawUnit(unit);
			}
		}
	}

	private synchronized void printMask(boolean maskVisible) {
		if ((maskVisible) //
				&& (getBattleModel().getActiveUnit() != null) //
				&& (!getBattleModel().getActiveUnit().isEnemy())) //
		{
			int[][] mask = getBattleModel().getMPMask();
			for (int i = 0; i < FIELD_WIDTH; i++) {
				for (int j = 0; j < FIELD_HEIGHT; j++) {
					Drawable img = TRANSP;
					int bm = getOptions().getBattleGridVisible();
					System.out.println(bm);
					// moving
					if ((mask[i][j] <= getBattleModel().getActiveUnit().getMP()) && (mask[i][j] > 0)) {
						img = BATTLE_MASK_M[bm];
						// atacking
					} else if ((mask[i][j] == -101) && (getBattleModel().getActiveUnit().getMP() > 0)) {
						img = BATTLE_MASK_A[bm];
						// shoot atacking
					} else if ((mask[i][j] < -101) && (ShooterUnit.canShoot(getBattleModel().getActiveUnit(), mask))
							&& (getBattleModel().getActiveUnit().getMP() > 0)) {
						img = BATTLE_MASK_A[bm];
					}
					if (img != null) {
						maskImg[i][j].setBackgroundDrawable(img);
					}
				}
			}
		} else {
			for (int i = 0; i < FIELD_WIDTH; i++) {
				for (int j = 0; j < FIELD_HEIGHT; j++) {
					maskImg[i][j].setBackgroundDrawable(TRANSP);
				}
			}
		}
	}

	void updateCells(boolean mask, Cell... cells) {
		updateCells(Arrays.asList(cells), mask);
	}

	void updateCells(List<Cell> cells, boolean mask) {
		for (Cell cell : cells) {
			if (cell != null) {
				int x = cell.getX();
				int y = cell.getY();
				clearFieldImg(fieldImg[x][y]);
				maskImg[x][y].setBackgroundDrawable(TRANSP);
				fieldImg[x][y].setBackgroundDrawable(TRANSP);
				if (cell.getContent() != null) {
					drawUnit(cell.getContent());
				}
			}
		}
		printMask(mask);
	}

	synchronized void showDamage(UnitInView unit, boolean half) {
		int x = unit.getLocation().getX();
		int y = unit.getLocation().getY();
		Drawable atackType = half ? BATTLE_ATACK_HALF : BATTLE_ATACK;
		maskImg[x][y].setBackgroundDrawable(atackType);
	}

	public synchronized void showWinInfo(Hero hero) {
		String[] s = getWinInfoText(hero);
		showMessage(s);
	}

	private String[] getWinInfoText(Hero hero) {
		String[] s = new String[14];
		Player p = getBattleModel().getPlayer().getHero();
		final String name = p.getName();
		final String profession = NameResolver.getProfession(p.getType(), p.getRank());

		s[0] = BATTLE_RESULT_TITLE;
		s[1] = "";
		s[2] = String.format(BATTLE_RESULT_GLORY[0], name, profession);
		s[3] = BATTLE_RESULT_GLORY[1];
		s[4] = BATTLE_RESULT_GLORY[2];
		s[5] = "";
		s[6] = String.format(BATTLE_RESULT_BOUNTY, hero.getMoney());
		if (hero instanceof Villain) {
			Villain villain = (Villain) hero;
			final VilliansInfo _v = VilliansInfo.get(villain);
			s[6] += BATTLE_RESULT_VILLIAN[0];
			s[7] = String.format(BATTLE_RESULT_VILLIAN[1], ((_v != null) ? _v.getName() : ""));
			s[8] = "";
			if (p.getKilledVillains().contains(villain)) {
				s[9] = BATTLE_RESULT_VILLIAN_WIN[0];
				s[10] = String.format(BATTLE_RESULT_VILLIAN_WIN[1], ((_v != null) ? villain.getBounty() : ""));
				s[11] = BATTLE_RESULT_VILLIAN_WIN[2];
				s[12] = BATTLE_RESULT_VILLIAN_WIN[3];
			} else {
				s[9] = BATTLE_RESULT_VILLIAN_FAIL[0];
				s[10] = BATTLE_RESULT_VILLIAN_FAIL[1];
				s[11] = BATTLE_RESULT_VILLIAN_FAIL[2];
			}
		}
		return s;
	}

	@Override
	public void onNoInfo() {
		hideInfo();
	}

	public int getAnimationDuration() {
		int i = 1;
		if (o != null) {
			i = o.getDuration(0) * o.getNumberOfFrames();
		}
		return i;
	}

	public void stopAnimation() {
		if (o != null) {
			if (o.isRunning()) {
				o.stop();
			}
		}
	}
}
