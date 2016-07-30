package ru.reizy.kb1990.view.android.globalmap.town;

import static ru.reizy.kb1990.view.android.resource.Util.countToView;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TOWN_BOAT_CANCEL;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TOWN_BOAT_RENT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TOWN_CASTLE_INFO;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TOWN_CONTRACT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TOWN_GP;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TOWN_MAGIC;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TOWN_NAME;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TOWN_SEIGE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TOWN_SEIGE_HAD;
import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.residence.Town;
import ru.reizy.kb1990.view.android.globalmap.KBInfoPanel;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import ru.reizy.kb1990.view.android.resource.UnitsTexture;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class TownPanel extends KBInfoPanel {

	private final ImageView exitBtn;
	private final ImageView unitImg;
	private AnimationDrawable o;
	private final UnitsTexture unitsTexture;

	public TownPanel(Window mWindow, Resources resources) {
		super(mWindow, resources, R.id.info);
		unitsTexture = new UnitsTexture(resources);

		this.exitBtn = (ImageView) findViewById(R.id.exit);
		this.unitImg = (ImageView) findViewById(R.id.unit);

		exitBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				getGlobalPlayer().goOut();
			}
		});
		updateInfo();
	}

	public void switchAndStartUnitAnimation() {
		if (o != null) {
			if (o.isRunning()) {
				o.stop();
			}
		}
		int a = unitsTexture.units_l_a.get(UnitTypes.getRandom());
		unitImg.setBackgroundResource(a);
		o = (AnimationDrawable) unitImg.getBackground();
		if (!o.isRunning()) {
			o.start();
		}
	};

	public void startUnitAnimation() {
		if (o != null) {
			if (!o.isRunning()) {
				o.start();
			}
		}
	};

	public void stopUnitAnimation() {
		if (o != null) {
			if (o.isRunning()) {
				o.stop();
			}
		}
	};

	public void defaultInfo() {
		final GlobalPlayer p = getGlobalPlayer();
		final Player hero = p.getHero();
		final Town t = p.getActiveTown();
		if (t != null) {
			int k = 0;
			String[] s = new String[10];
			s[k++] = String.format(TOWN_NAME, t.getName()) + String.format(TOWN_GP, countToView(hero.getMoney()));
			s[k++] = TOWN_CONTRACT;
			s[k++] = (p.getShip().getCell() == null) ? String.format(TOWN_BOAT_RENT, hero.getBoatRent()) : TOWN_BOAT_CANCEL;
			s[k++] = TOWN_CASTLE_INFO;
			s[k++] = String.format(TOWN_MAGIC, NameResolver.getMagicName(t.getSpell()), t.getSpell().getCost());
			s[k++] = (p.hasSeigeWeapon()) ? TOWN_SEIGE_HAD : TOWN_SEIGE;
			showMessage(s);
		}
	}

	@Override
	public void onNoInfo() {
		defaultInfo();
	}

	public void updateControls(boolean isExitButtonVisible) {
		exitBtn.setVisibility(isExitButtonVisible ? View.VISIBLE : View.INVISIBLE);
	}
}
