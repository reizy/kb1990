package ru.reizy.kb1990.view.android.army;

import static ru.reizy.kb1990.view.strings.ru.StringConstants.ARMY_INFO;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.MORALE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.OUT_OF_CONTROL;
import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.view.android.KbAndroidPanel;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import ru.reizy.kb1990.view.android.resource.UnitsTexture;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class ArmyPanel extends KbAndroidPanel {
	private final Drawable TRANSP;
	private final UnitsTexture unitsTexture;
	private AnimationDrawable[] anims = new AnimationDrawable[5];
	private ImageView[] slots = new ImageView[5];
	private TextView[] slotsInfo = new TextView[5];

	public ArmyPanel(Window mWindow, Resources resources) {
		super(mWindow, resources);
		TRANSP = (BitmapDrawable) getResources().getDrawable(R.drawable.transparent);

		slots[0] = (ImageView) findViewById(R.id.slot_0);
		slots[1] = (ImageView) findViewById(R.id.slot_1);
		slots[2] = (ImageView) findViewById(R.id.slot_2);
		slots[3] = (ImageView) findViewById(R.id.slot_3);
		slots[4] = (ImageView) findViewById(R.id.slot_4);

		slotsInfo[0] = (TextView) findViewById(R.id.slot_0_info);
		slotsInfo[1] = (TextView) findViewById(R.id.slot_1_info);
		slotsInfo[2] = (TextView) findViewById(R.id.slot_2_info);
		slotsInfo[3] = (TextView) findViewById(R.id.slot_3_info);
		slotsInfo[4] = (TextView) findViewById(R.id.slot_4_info);

		this.unitsTexture = new UnitsTexture(resources);
		update();
	}

	private void updateAndStartUnitAnimation() {
		for (int i = 0; i < anims.length; i++) {
			AnimationDrawable o = anims[i];
			if (o != null) {
				if (o.isRunning()) {
					o.stop();
				}
			}
			UnitType unit = getGlobalPlayer().getHero().getArmy(i);
			if (unit != null) {
				UnitTypes type = UnitTypes.get(unit);
				int resId = getUnitAnim(type);
				slots[i].setImageResource(resId);
				o = (AnimationDrawable) slots[i].getDrawable();
				if (!o.isRunning()) {
					o.start();
				}
			} else {
				o = null;
				slots[i].setImageDrawable(TRANSP);
			}
			anims[i] = o;
		}
	};

	public void stopUnitAnimation() {
		for (AnimationDrawable o : anims) {
			if (o != null) {
				if (o.isRunning()) {
					o.stop();
				}
			}
		}
	};

	private int getUnitAnim(UnitTypes unit) {
		int img_id = unitsTexture.units_l_a.get(unit);
		return img_id;
	}

	public void update() {
		updateAndStartUnitAnimation();
		updateInfo();
	}

	private void updateInfo() {
		for (int i = 0; i < Player.ARMY_MAX_SIZE; i++) {
			UnitType type = null;
			int count = 0;
			int morale = 0;
			final Player p = getGlobalPlayer().getHero();
			if (i < p.getArmy().size()) {
				type = p.getArmy().get(i);
				count = p.getArmyCount().get(i);
				morale = p.getMorale(i);
				if (p.isOutOfControl(i)) {
					morale = -1;
				}
			}
			drawUnitInfo(slotsInfo[i], type, count, morale);
		}
	}

	private void drawUnitInfo(TextView g, UnitType unit, int count, int morale) {
		String s = "";
		int color = get64(21);
		// show unit info
		if (unit != null) {
			String sCount = countToView(count);
			String sName = NameResolver.getUnitName(unit);
			String sHp = countToView(count * unit.getMaxHitPoints());
			int sSl = unit.getSkill();
			int sMv = unit.getMaxMovePoints();
			String sDMin = countToView(count * unit.getMinDamage());
			String sDMax = countToView(count * unit.getMaxDamage());
			String sMoral;
			if (morale >= 0) {
				sMoral = String.format(MORALE, NameResolver.getMorale(morale));
			} else {
				sMoral = OUT_OF_CONTROL;
			}
			int sPrise = count * unit.getWeekCost();

			s = String.format(ARMY_INFO, sCount, sName, sHp, sSl, sMv, sDMin, sDMax, sMoral, sPrise);

			switch (UnitsResidenceType.get(unit)) {
			case CASTLE:
				color = get64(38);
				break;
			case DUNGEON:
				color = get64(1);
				break;
			case FOREST:
				color = get64(8);
				break;
			case HILLS:
				color = get64(16);
				break;
			case PLAINS:
				color = get64(42);
				break;
			default:
				color = get64(21);
				break;
			}
		}
		g.setBackgroundColor(color);
		g.setText(s);
	}

	private static String countToView(int c) {
		String count = Integer.toString(c);
		if (c > 1000) {
			count = c / 1000 + "K";
		}
		return count;
	}
}
