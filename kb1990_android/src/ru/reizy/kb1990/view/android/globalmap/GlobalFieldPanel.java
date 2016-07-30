package ru.reizy.kb1990.view.android.globalmap;

import static ru.reizy.kb1990.view.android.globalmap.MinimapUtils.MAP_SIZE;
import static ru.reizy.kb1990.view.android.globalmap.MinimapUtils.SIZE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.ARTIFACT_FOUND_INFO;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.ARTIFACT_FOUND_INFO_PASLE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.ARTIFACT_NAME;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.ENEMY_ARMY_INFO;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TREASURE_FOUND_INFO_FULL_MAP;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TREASURE_FOUND_INFO_GOLD;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TREASURE_FOUND_INFO_NEXT_MAP;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TREASURE_FOUND_INFO_RANDOM_SPELL;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TREASURE_FOUND_INFO_RICH_MINERAL;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TREASURE_FOUND_INFO_SPELL_CAPACITY;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TREASURE_FOUND_INFO_SPELL_POWER;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TREASURE_FOUND_INFO_UNIT1;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TREASURE_FOUND_INFO_UNIT2;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TREASURE_FOUND_INFO_UNIT3;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.WEEKEND_BALANCE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.WEEKEND_INFO;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.WEEKEND_LEAVE;

import java.util.Arrays;
import java.util.Map.Entry;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.controller.android.globalmap.GlobalFieldClickListener;
import ru.reizy.kb1990.model.base.artifact.Artifact;
import ru.reizy.kb1990.model.base.magic.MagicSpells;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.Content;
import ru.reizy.kb1990.model.globalmap.FieldType;
import ru.reizy.kb1990.model.globalmap.GlobalHero;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.events.BattleFailEvent;
import ru.reizy.kb1990.model.globalmap.events.BattleWinEvent;
import ru.reizy.kb1990.model.globalmap.events.BrigeBuiltEvent;
import ru.reizy.kb1990.model.globalmap.events.BuyMagicEvent;
import ru.reizy.kb1990.model.globalmap.events.EnemyActionEvent;
import ru.reizy.kb1990.model.globalmap.events.GlobalPlayerMoveEvent;
import ru.reizy.kb1990.model.globalmap.events.RemoveUnitEvent;
import ru.reizy.kb1990.model.globalmap.events.ResidenceOutEvent;
import ru.reizy.kb1990.model.globalmap.events.ShowContractEvent;
import ru.reizy.kb1990.model.globalmap.events.SignPostActivateEvent;
import ru.reizy.kb1990.model.globalmap.events.TownActionEvent;
import ru.reizy.kb1990.model.globalmap.events.TravelSpellActivatinoEvent;
import ru.reizy.kb1990.model.globalmap.events.TreasureActivateEvent;
import ru.reizy.kb1990.model.globalmap.events.WeekEndEvent;
import ru.reizy.kb1990.model.globalmap.magic.Bridge;
import ru.reizy.kb1990.model.globalmap.residence.Bonus;
import ru.reizy.kb1990.model.globalmap.treasure.ArtifactTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.FullMapTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.GoldTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.NextMapTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.RandomSpellTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.RandomUnitTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.RichMineralDepositsTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.SpellCapacityIncreasesTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.SpellPowerIncreasesTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.Treasure;
import ru.reizy.kb1990.view.android.KbViewOptions;
import ru.reizy.kb1990.view.android.resource.FieldTypeTexture;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import ru.reizy.kb1990.view.strings.StringConstants;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class GlobalFieldPanel extends KBInfoPanel {

	public static final int FIELD_WIDTH = 6 - 1;
	public static final int FIELD_HEIGHT = 5;
	public static final int MOVE_DISTANCE = 1;

	private static final int ANIMATION_SPEED = 250;

	private final ImageView[][] fieldImg;
	private final FieldTypeTexture texture;
	private int oldX = 0;

	private boolean leftPlayer = false;
	private boolean leftShip = false;
	private final ImageView playerCell;
	private final TextView calendar;
	private final AnimationDrawable[] anim;
	private AnimationDrawable o;

	private final ImageButton btnMove;
	private final ImageView minimap;
	private final Bitmap minimapBitmap;
	private final Bitmap minimapMaskBitmap1;
	private final Bitmap minimapMaskBitmap2;
	private final Bitmap minimapMaskBitmap3;
	private final AnimationDrawable minimapAnimation;
	private boolean showingMinimap = false;
	boolean minimapMasked = true;
	private final KbViewOptions kbViewOptions;

	public GlobalFieldPanel(Window mWindow, Resources resources) {
		super(mWindow, resources, R.id.gInfo);
		kbViewOptions = new KbViewOptions();
		this.fieldImg = getImageViewField(
		//
				R.id.field_0_0, R.id.field_1_0, R.id.field_2_0, R.id.field_3_0, R.id.field_4_0, R.id.field_5_0, //
				R.id.field_0_1, R.id.field_1_1, R.id.field_2_1, R.id.field_3_1, R.id.field_4_1, R.id.field_5_1, //
				R.id.field_0_2, R.id.field_1_2, R.id.field_2_2, R.id.field_3_2, R.id.field_4_2, R.id.field_5_2, //
				R.id.field_0_3, R.id.field_1_3, R.id.field_2_3, R.id.field_3_3, R.id.field_4_3, R.id.field_5_3, //
				R.id.field_0_4, R.id.field_1_4, R.id.field_2_4, R.id.field_3_4, R.id.field_4_4, R.id.field_5_4 //
		);

		this.texture = new FieldTypeTexture(getResources());
		this.anim = getPlayerAnims();

		playerCell = (ImageView) findViewById(R.id.player_cell);
		calendar = (TextView) findViewById(R.id.days_counter);
		minimap = (ImageView) findViewById(R.id.minimap);
		{
			minimapBitmap = Bitmap.createBitmap(MAP_SIZE * SIZE, MAP_SIZE * SIZE, Bitmap.Config.ARGB_8888);
			final BitmapDrawable d = new BitmapDrawable(getResources(), minimapBitmap);
			this.minimap.setBackgroundDrawable(d);
		}
		{
			minimapMaskBitmap1 = Bitmap.createBitmap(MAP_SIZE * SIZE, MAP_SIZE * SIZE, Bitmap.Config.ARGB_8888);
			final BitmapDrawable mmb1 = new BitmapDrawable(getResources(), minimapMaskBitmap1);
			minimapMaskBitmap2 = Bitmap.createBitmap(MAP_SIZE * SIZE, MAP_SIZE * SIZE, Bitmap.Config.ARGB_8888);
			final BitmapDrawable mmb2 = new BitmapDrawable(getResources(), minimapMaskBitmap2);
			minimapMaskBitmap3 = Bitmap.createBitmap(MAP_SIZE * SIZE, MAP_SIZE * SIZE, Bitmap.Config.ARGB_8888);
			final BitmapDrawable mmb3 = new BitmapDrawable(getResources(), minimapMaskBitmap3);
			minimapAnimation = new AnimationDrawable();
			minimapAnimation.setOneShot(false);
			minimapAnimation.addFrame(mmb1, 250);
			minimapAnimation.addFrame(mmb2, 250);
			minimapAnimation.addFrame(mmb3, 250);
			minimapAnimation.start();
			this.minimap.setImageDrawable(minimapAnimation);
		}

		final AnimationDrawable a = anim[0];
		playerCell.post(new Runnable() {
			@Override
			public void run() {
				o = a;
				drawPlayer();
			}
		});
		Cell cell = getGlobalPlayer().getCell();
		fillField(cell.getX(), cell.getY());
		btnMove = (ImageButton) findViewById(R.id.btn_move);
		btnMove.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				GlobalPlayer p = getGlobalPlayer();
				if (p.isFlying()) {
					p.tryLand();
				} else {
					if (p.inShip()) {
						GlobalMap map = p.getOpenedMaps().get((p.getActiveMap().getId() + 1) % p.getOpenedMaps().size());
						Cell playerCell = map.getStartCell();
						map.goTo(playerCell.getX(), playerCell.getY());
					} else {
						p.tryFly();
					}
				}
			}
		});

		fullUpdate();
		ImageButton btnMap = (ImageButton) findViewById(R.id.btn_map);
		final View.OnClickListener mapListener = new View.OnClickListener() {
			public void onClick(View v) {
				showingMinimap = !showingMinimap;
				if (showingMinimap) {
					minimapMasked = true;
					updateMinimap();
					minimap.setVisibility(View.VISIBLE);
				} else {
					minimap.setVisibility(View.GONE);
				}
				updateControls();
			}
		};
		btnMap.setOnClickListener(mapListener);
		calendar.setOnClickListener(mapListener);
		minimap.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				boolean b = getGlobalPlayer().hasFullMap(getModel().getGlobalMap());
				minimapMasked = !b || !minimapMasked;
				updateMinimap();
			};
		});
	}

	KbViewOptions getOptions() {
		return kbViewOptions;
	}

	private AnimationDrawable[] getPlayerAnims() {
		AnimationDrawable[] anims = new AnimationDrawable[6];
		int k = 0;
		anims[k++] = getPlayerAnim(R.drawable.player_l_2, R.drawable.player_l_1, R.drawable.player_l_0);
		anims[k++] = getPlayerAnim(R.drawable.player_r_2, R.drawable.player_r_1, R.drawable.player_r_0);
		anims[k++] = getPlayerAnim(R.drawable.player_l_b_0, R.drawable.player_l_b_1, R.drawable.player_l_b_2);
		anims[k++] = getPlayerAnim(R.drawable.player_r_b_0, R.drawable.player_r_b_1, R.drawable.player_r_b_2);
		anims[k++] = getPlayerAnim(R.drawable.player_l_f_2, R.drawable.player_l_f_1, R.drawable.player_l_f_0);
		anims[k++] = getPlayerAnim(R.drawable.player_r_f_2, R.drawable.player_r_f_1, R.drawable.player_r_f_0);
		return anims;
	}

	private AnimationDrawable getPlayerAnim(int... r) {
		final AnimationDrawable anim = new AnimationDrawable();
		anim.setOneShot(false);
		for (int i = 0; i < r.length; i++) {
			anim.addFrame(((BitmapDrawable) getResources().getDrawable(r[i])), ANIMATION_SPEED * 1);
		}
		return anim;
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
				if (i < FIELD_WIDTH) {
					field[i][j].setOnClickListener(new GlobalFieldClickListener(this, i, j));
				}
			}
		}
		return field;
	}

	void fillField(int vx, int vy) {
		final GlobalMap map = getModel().getGlobalMap();
		final GlobalPlayer player = getModel().getGlobalPlayer();
		if (oldX > vx) {
			leftPlayer = true;
		} else if (oldX < vx) {
			leftPlayer = false;
		}
		oldX = vx;
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
					if (content instanceof Bridge) {
						final Drawable k = texture.getActive(content);
						fieldImg[x][y].setBackgroundDrawable(k);
					}
					// отрисовка неактивного корабля
					if ((player.getShip().getCell() == cell) && (!player.inShip())//
					) {
						BitmapDrawable k = null;
						int ship = leftShip ? R.drawable.player_l_b_2 : R.drawable.player_r_b_2;
						k = (BitmapDrawable) getResources().getDrawable(ship);
						if (k != null) {
							fieldImg[x][y].setImageDrawable(k);
						}
					}
				}
			}
		}
	}

	private void drawBonus(ImageView g, Content content) {
		Drawable k = null;
		k = texture.getActive(content);
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
		BitmapDrawable k = null;
		k = texture.getUnit(unit);
		g.setBackgroundDrawable(k);
	}

	void drawPlayer() {
		if (o != null) {
			AnimationDrawable a;
			int startStep;
			if (getModel().getGlobalPlayer().isFlying()) {
				if (leftPlayer) {
					a = anim[4];
					startStep = R.drawable.player_l_f_3;
				} else {
					a = anim[5];
					startStep = R.drawable.player_r_f_3;
				}
			} else {
				if (getModel().getGlobalPlayer().inShip()) {
					leftShip = leftPlayer;
					if (leftPlayer) {
						a = anim[2];
						startStep = R.drawable.player_l_b_3;
					} else {
						a = anim[3];
						startStep = R.drawable.player_r_b_3;
					}
				} else {
					if (leftPlayer) {
						a = anim[0];
						startStep = R.drawable.player_l_3;
					} else {
						a = anim[1];
						startStep = R.drawable.player_r_3;
					}
				}
			}
			if (o != a) {
				if (o != null) {
					if (o.isRunning()) {
						o.stop();
					}
				}
				o = a;
				if (!o.isRunning()) {
					o.start();
				}

			}
			a = new AnimationDrawable();
			a.setOneShot(true);
			a.addFrame((BitmapDrawable) getResources().getDrawable(startStep), ANIMATION_SPEED);
			a.addFrame(o, 9999);
			playerCell.setImageDrawable(a);
			a.start();
		}
	}

	public void update() {
		Cell cell = getGlobalPlayer().getCell();
		if (cell != null) {
			fillField(cell.getX(), cell.getY());
			updatePasleMap();
			drawPlayer();
			updateMoney();
			updateControls();
			updateMinimap();
		}
	}

	public void fullUpdate() {
		update();
		updateContract();
		updateSiege();
		updateMagic();
	}

	public void onEvent(KBEvent event) {

		if (event instanceof BattleWinEvent) {
			update();
			updateContract();
		} else if (event instanceof BattleFailEvent) {
			update();
			String[] s = { StringConstants.BATTLE_RESULT_FAIL };
			showMessage(s);
			updateSiege();
		} else if (event instanceof GlobalPlayerMoveEvent) {
			update();
		} else if (event instanceof BrigeBuiltEvent) {
			update();
		} else if (event instanceof TravelSpellActivatinoEvent) {
			update();
		} else if (event instanceof ResidenceOutEvent) {
			update();
		} else if (event instanceof RemoveUnitEvent) {
			update();
		} else if (event instanceof TownActionEvent) {
			update();
			updateSiege();
		} else if (event instanceof TreasureActivateEvent) {
			TreasureActivateEvent bonusEvent = (TreasureActivateEvent) event;
			onTreasureActivateEvent(bonusEvent);
		} else if (event instanceof EnemyActionEvent) {
			EnemyActionEvent enemyActionEvent = (EnemyActionEvent) event;
			onEnemyActivateEvent(enemyActionEvent);
		} else if (event instanceof WeekEndEvent) {
			WeekEndEvent weekEndEvent = (WeekEndEvent) event;
			onWeekEndEvent(weekEndEvent);
			update();
		} else if (event instanceof SignPostActivateEvent) {
			showMessage(((SignPostActivateEvent) event).getResidence().getText());
		} else if (event instanceof ShowContractEvent) {
			updateContract();
		} else if (event instanceof BuyMagicEvent) {
			updateMagic();
		}
	}

	private void onWeekEndEvent(WeekEndEvent e) {
		String s1 = String.format(WEEKEND_INFO, e.getWeekNum(),//
				NameResolver.getUnitName(e.getUnit()));

		final String[] a = { "", "", "", "", "" };
		final String[] p = { "", "", "", "", "" };
		for (int i = 0; i < e.getUnits().size(); i++) {
			a[i] = NameResolver.getUnitName(e.getUnits().get(i));
			final Integer c = e.getUnitsCost().get(i);
			p[i] = (c > 0) ? c.toString() : WEEKEND_LEAVE;
		}

		String s2 = String.format(WEEKEND_BALANCE, e.getWeekNum(),//
				e.getMoneyBefore(), e.getCommision(), e.getBoatRent(), e.getArmyCost(), e.getMoneyAfter(),//
				a[0], a[1], a[2], a[3], a[4],//
				p[0], p[1], p[2], p[3], p[4]//

				);
		showMessage(s1.split("\n"), s2.split("\n"));
	}

	public void onEnemyActivateEvent(EnemyActionEvent event) {
		GlobalHero gHero = event.getEnemy();
		Object[] args = { "", "", "", "", "", "", "", "", "", "" };
		for (int i = 0; i < gHero.getHero().getArmy().size(); i++) {
			args[i * 2] = NameResolver.getCountText(gHero.getHero().getArmyCount(i));
			args[i * 2 + 1] = NameResolver.getUnitName(gHero.getHero().getArmy(i));
		}
		String s = String.format(ENEMY_ARMY_INFO, args);
		showMessage(s);
	}

	private void onTreasureActivateEvent(TreasureActivateEvent e) {
		Treasure bonus = e.getTreasure();
		int power = bonus.getPower();
		String s = "???";
		if (bonus instanceof GoldTreasure) {
			s = String.format(TREASURE_FOUND_INFO_GOLD, 50 * power, power);
		} else if (bonus instanceof ArtifactTreasure) {
			int i = Arrays.asList(Artifact.artifacts).indexOf(((ArtifactTreasure) bonus).getArtifact());
			s = String.format(ARTIFACT_FOUND_INFO[i], ARTIFACT_NAME[i]) + ARTIFACT_FOUND_INFO_PASLE;
		} else if (bonus instanceof FullMapTreasure) {
			s = String.format(TREASURE_FOUND_INFO_FULL_MAP);
		} else if (bonus instanceof NextMapTreasure) {
			s = String.format(TREASURE_FOUND_INFO_NEXT_MAP, NameResolver.getContinentName(bonus.getCell().getMap().getNextMap()));
		} else if (bonus instanceof RandomSpellTreasure) {
			boolean firstElement = true;
			String t = "";
			for (Entry<MagicSpells, Integer> rs : ((RandomSpellTreasure) bonus).getSpells().entrySet()) {
				if (!firstElement) {
					t += ", \n ";
				}
				firstElement = false;
				t = t + rs.getValue() + "*" + NameResolver.getMagicName(rs.getKey());
			}
			s = String.format(TREASURE_FOUND_INFO_RANDOM_SPELL, t);

		} else if (bonus instanceof RichMineralDepositsTreasure) {
			s = String.format(TREASURE_FOUND_INFO_RICH_MINERAL, power);
		} else if (bonus instanceof SpellCapacityIncreasesTreasure) {
			s = String.format(TREASURE_FOUND_INFO_SPELL_CAPACITY, power);
		} else if (bonus instanceof SpellPowerIncreasesTreasure) {
			s = String.format(TREASURE_FOUND_INFO_SPELL_POWER, power);
		} else if (bonus instanceof RandomUnitTreasure) {
			RandomUnitTreasure rutBonus = (RandomUnitTreasure) bonus;
			UnitTypes unit = rutBonus.getUnit();
			int count = rutBonus.getCount();
			final String t;

			if (rutBonus.canAttach(getGlobalPlayer())) {
				if (rutBonus.willTerror(getGlobalPlayer())) {
					t = TREASURE_FOUND_INFO_UNIT2;
				} else {
					t = TREASURE_FOUND_INFO_UNIT1;
				}
			} else {
				t = TREASURE_FOUND_INFO_UNIT3;
			}
			s = String.format(t, NameResolver.getCountText(count), NameResolver.getUnitName(unit));
		}
		showMessage(s);
	}

	@Override
	protected void onNoInfo() {
		hideInfo();
	}

	private void updateControls() {
		GlobalPlayer player = getGlobalPlayer();
		boolean e1 = (//
		/*-----------*/(//
		/*-------------*/((player.canFly()) && (!player.isFlying()))//
		/*-------------*/|| ((player.canLand()) && (player.isFlying()))//
		/*-----------*/)//
		/*-----------*/|| (player.inShip())//
		/*---------*/);
		btnMove.setEnabled(e1);
		int idMove = player.inShip() ? R.drawable.icon_gn //
				: player.isFlying() //
				? e1 ? R.drawable.icon_gl : R.drawable.icon_gl_dis //
						: e1 ? R.drawable.icon_gf : R.drawable.icon_gf_dis;
		BitmapDrawable drMove = ((BitmapDrawable) getResources().getDrawable(idMove));
		btnMove.setImageDrawable(drMove);
		int tmp = player.getHero().getTempMovePoints();
		if (!showingMinimap) {
			if (tmp > 0) {
				calendar.setTextColor(Color.rgb(175, 0, 150));
				calendar.setText("" + tmp + "\n");
			} else {
				calendar.setTextColor(Color.WHITE);
				calendar.setText("" + player.getDays() + "\n");
			}
		} else {
			calendar.setTextColor(Color.WHITE);
			calendar.setText(String.format("x:%1$2s\ny:%2$2s", player.getCell().getX(), player.getCell().getY()));
		}
	}

	private void updateMinimap() {
		final Canvas g = new Canvas(minimapBitmap);
		final Canvas g1 = new Canvas(minimapMaskBitmap1);
		final Canvas g2 = new Canvas(minimapMaskBitmap2);
		final Canvas g3 = new Canvas(minimapMaskBitmap3);
		GlobalMap map = getModel().getGlobalMap();
		MinimapUtils.fillMinimap(g, g1, g2, g3, map, getGlobalPlayer(), minimapMasked, getOptions());
	}
}
