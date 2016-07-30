package ru.reizy.kb1990.view.android.globalmap.residence;

import static ru.reizy.kb1990.view.android.resource.Util.countToView;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.RESIDENCE_AVAIBLE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.RESIDENCE_COUNT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.RESIDENCE_LINE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.RESIDENCE_NAME;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.RESIDENCE_PRICE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.RESIDENCE_Q;
import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence;
import ru.reizy.kb1990.view.android.globalmap.KBInfoPanel;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import ru.reizy.kb1990.view.android.resource.UnitsTexture;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class ResidencePanel extends KBInfoPanel {
	private final ImageView exitBtn;
	private final ImageView unitImg;
	private final ImageView bgImg;
	private final UnitsTexture unitsTexture;
	private AnimationDrawable o;

	public ResidencePanel(Window mWindow, Resources resources) {
		super(mWindow, resources, R.id.info);
		this.unitsTexture = new UnitsTexture(resources);

		this.exitBtn = (ImageView) findViewById(R.id.exit);
		this.unitImg = (ImageView) findViewById(R.id.unit);
		this.bgImg = (ImageView) findViewById(R.id.bg);

		exitBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				getGlobalPlayer().goOut();
			}
		});
		updateInfo();
	}

	public void updateAndStartUnitAnimation() {
		if (o != null) {
			if (o.isRunning()) {
				o.stop();
			}
		}
		SimpleUnitResidence residence = getGlobalPlayer().getActiveResidence();
		if (residence != null) {
			UnitTypes type = residence.getUnit();
			int a = unitsTexture.units_l_a.get(type);
			unitImg.setBackgroundResource(a);
			o = (AnimationDrawable) unitImg.getBackground();
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

	private void updateBack() {
		SimpleUnitResidence residence = getGlobalPlayer().getActiveResidence();
		if (residence != null) {
			UnitType type = residence.getUnit().getUnitType();
			UnitsResidenceType tr = UnitsResidenceType.get(type);
			int img_id;
			switch (tr) {
			case CASTLE:
				img_id = R.drawable.residence_bg_castle;
				break;
			case PLAINS:
				img_id = R.drawable.residence_bg_plains;
				break;
			case FOREST:
				img_id = R.drawable.residence_bg_forests;
				break;
			case HILLS:
				img_id = R.drawable.residence_bg_hills;
				break;
			case DUNGEON:
				img_id = R.drawable.residence_bg_dungeons;
				break;
			default:
				img_id = R.drawable.residence_bg_plains;
			}
			Drawable img = ((BitmapDrawable) getResources().getDrawable(img_id));
			bgImg.setBackgroundDrawable(img);
		}
	}

	private void defaultInfo() {
		SimpleUnitResidence residence = getGlobalPlayer().getActiveResidence();
		if (residence != null) {
			String[] s = new String[10];
			s[0] = String.format(RESIDENCE_NAME, NameResolver.getResidenceName(residence.getType()));
			s[1] = RESIDENCE_LINE;
			s[3] = String.format(RESIDENCE_AVAIBLE, residence.getCount().toString(), NameResolver.getUnitName(residence.getUnit()));
			s[4] = String.format(RESIDENCE_PRICE, //
					residence.getUnit().getUnitType().getCost(), //
					countToView(getGlobalPlayer().getHero().getMoney()));
			int ll = getAvaibleCount();
			s[5] = String.format(RESIDENCE_COUNT, countToView(ll));
			s[6] = RESIDENCE_Q;
			showMessage(s);
		}
	}

	public int getAvaibleCount() {
		SimpleUnitResidence residence = getGlobalPlayer().getActiveResidence();
		if (residence == null)
			return 0;
		int mc = getGlobalPlayer().getHero().getMoney() / residence.getUnit().getUnitType().getCost();
		int ll = getGlobalPlayer().getHero().getLeadership() / residence.getUnit().getUnitType().getLeadership();
		int index = getGlobalPlayer().getHero().getArmy().indexOf(residence.getUnit().getUnitType());
		if (index >= 0) {
			ll -= getGlobalPlayer().getHero().getArmyCount().get(index);
		}
		ll = Math.min(mc, ll);
		ll = Math.max(ll, 0);
		return ll;
	}

	public void update(boolean isExitButtonVisible) {
		exitBtn.setVisibility(isExitButtonVisible ? View.VISIBLE : View.INVISIBLE);

		updateBack();
		updateAndStartUnitAnimation();
		updateInfo();
		updateContract();
		updateSiege();
		updateMagic();
		updatePasleMap();
		updateMoney();
	}

	@Override
	public void onNoInfo() {
		defaultInfo();
	}

}
