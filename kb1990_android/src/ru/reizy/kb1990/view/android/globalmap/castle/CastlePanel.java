package ru.reizy.kb1990.view.android.globalmap.castle;

import static ru.reizy.kb1990.view.android.resource.Util.countToView;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CASTLE_ATTACK_Q;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CASTLE_BAND;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CASTLE_GARNISON_INFO;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CASTLE_LORD;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CASTLE_NAME;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CASTLE_NEED_SEIGE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CASTLE_PLAYER_INFO;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.EMPTY;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.N_A;
import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.base.ArmyHolder;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.villains.Villain;
import ru.reizy.kb1990.view.android.globalmap.KBInfoPanel;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import ru.reizy.kb1990.view.android.resource.UnitsTexture;
import ru.reizy.kb1990.view.android.villain.VilliansInfo;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class CastlePanel extends KBInfoPanel {

	private ImageView exitBtn;
	private ImageView unitImg;
	private AnimationDrawable o;
	private UnitsTexture unitsTexture;
	private boolean garnison;

	public CastlePanel(Window mWindow, Resources resources) {
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
		final Castle t = p.getActiveCastle();
		if (t != null) {
			String s;
			if (t.getHero() == null) {
				if (garnison) {
					s = getPlayerInfo(hero, t);
				} else {
					s = getCastleInfo(hero, t);
				}
			} else {
				s = getEnemyInfo(p, t);
			}
			showMessage(s);
		}
	}

	private String getEnemyInfo(GlobalPlayer player, Castle t) {
		String[] ss = new String[6];
		ss[0] = String.format(CASTLE_NAME, t.getName());
		if (t.getHero() instanceof Villain) {
			ss[1] = String.format(CASTLE_LORD[0], VilliansInfo.get((Villain) t.getHero()).getName());
			ss[2] = CASTLE_LORD[1];
		} else {
			ss[1] = CASTLE_BAND[0];
			ss[2] = CASTLE_BAND[1];
		}
		ss[3] = "";
		if (player.hasSeigeWeapon()) {
			ss[4] = CASTLE_ATTACK_Q;
			ss[5] = "";
		} else {
			ss[4] = CASTLE_NEED_SEIGE[0];
			ss[5] = CASTLE_NEED_SEIGE[1];
		}
		String s = "";
		for (int i = 0; i < ss.length; i++) {
			s += ss[i] + "\n";
		}
		return s;
	}

	private String getGarnisonInfo(String template, String name, int money, ArmyHolder t) {
		String[] ch = { N_A, "A-A", "A-B", "A-C", "A-D", "A-E" };
		String[] ss = { "", "", "", "", "" };
		String[] sc = { "", "", "", "", "" };
		int k = -1;
		for (int i = 0; i < 5; i++) {
			String us = NameResolver.getUnitName(t.getArmy(i));
			us = (us == null) ? EMPTY : us;
			ss[i] = us;
			Integer c = t.getArmyCount(i);

			if (c == null) {
				sc[i] = N_A;
			} else {
				if (t instanceof Player) {
					c *= t.getArmy(i).getWeekCost();
				}
				sc[i] = c.toString();
			}
			if (c != null) {
				k = i;
			}
		}
		String s = String.format(template, //
				name, countToView(money),//
				ss[0], ss[1], ss[2], ss[3], ss[4], //
				sc[0], sc[1], sc[2], sc[3], sc[4], //
				ch[k + 1]);
		return s;
	}

	private String getCastleInfo(Player hero, Castle castle) {
		String s = getGarnisonInfo(CASTLE_GARNISON_INFO, //
				castle.getName(), hero.getMoney(),//
				castle.getArmyHolder());
		return s;
	}

	private String getPlayerInfo(Player hero, Castle castle) {
		String s = getGarnisonInfo(CASTLE_PLAYER_INFO, //
				castle.getName(), hero.getMoney(),//
				hero);
		return s;
	}

	@Override
	public void onNoInfo() {
		defaultInfo();
	}

	public boolean getGarnison() {
		return garnison;
	}

	public void setGarrison(boolean garnison) {
		this.garnison = garnison;
	}

	public void update(boolean isExitButtonVisible) {
		exitBtn.setVisibility(isExitButtonVisible ? View.VISIBLE : View.INVISIBLE);
		updateInfo();
		updateMoney();
	}

}
