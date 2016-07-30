package ru.reizy.kb1990.view.android.globalmap.kingcastle;

import static ru.reizy.kb1990.view.android.resource.Util.countToView;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.EMPTY;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.KINGCASTLE_INIT_INFO;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.KINGCASTLE_NO_SLOTS;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.KINGCASTLE_SLOTS_COUNT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.KINGCASTLE_UNIT_COUNT_INFO;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.KINGCASTLE_UNIT_INFO;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.KING_DIALOG_DEAR;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.KING_DIALOG_MAX;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.KING_DIALOG_NEED_MORE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.KING_DIALOG_PROMOTON;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.KING_DIALOG_WELCOME;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.N_A;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TITLES_BARBARIAN;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TITLES_KNIGHT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TITLES_PALADIN;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.TITLES_SORCERESS;
import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.PlayerType;
import ru.reizy.kb1990.model.globalmap.residence.KingCastle;
import ru.reizy.kb1990.view.android.globalmap.KBInfoPanel;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import ru.reizy.kb1990.view.android.resource.UnitsTexture;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.view.Window;
import android.widget.ImageView;

public class KingCastlePanel extends KBInfoPanel {
	static final int BASE_AVAIBLE_UNITS_COUNT = 3;

	private ImageView unitImg;
	private AnimationDrawable o;
	private UnitsTexture unitsTexture;

	private int index = 0;

	public KingCastlePanel(Window mWindow, Resources resources) {
		super(mWindow, resources, R.id.info);
		unitsTexture = new UnitsTexture(resources);

		this.unitImg = (ImageView) findViewById(R.id.unit);

		updateInfo();
	}

	public void switchAndStartUnitAnimation() {
		if (o != null) {
			if (o.isRunning()) {
				o.stop();
			}
		}
		int a = unitsTexture.units_l_a.get(UnitsResidenceType.CASTLE.getRandom());
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
		final KingCastle t = p.getActiveKingCastle();
		if (t != null) {
			String s;
			switch (index) {
			case 0:
				s = String.format(KINGCASTLE_INIT_INFO, t.getName());
				break;
			case 1:
				s = getUnitsInfo(hero, t);
				break;
			case 2:
				s = getUnitsCountInfo(hero, t);
				break;
			case 3:
				s = KING_DIALOG_WELCOME;
				break;
			case 4:
				s = getAudienceInfo(hero);
				break;
			default:
				s = "-";
				break;
			}
			showMessage(s);
		}
	}

	private String getUnitsInfo(Player hero, KingCastle castle) {
		String[] ch = { N_A, "A-A", "A-B", "A-C", "A-D", "A-E" };
		String[] ss = { "", "", "", "", "" };
		String[] sc = { "", "", "", "", "" };
		int k = -1;
		for (int i = 0; i < 5; i++) {
			final UnitTypes unit = castle.getUnitTypes()[i];
			String us = NameResolver.getUnitName(unit);
			us = (us == null) ? EMPTY : us;
			ss[i] = us;
			Integer c = unit.getUnitType().getCost();
			if (i >= (hero.getRank() + BASE_AVAIBLE_UNITS_COUNT)) {
				sc[i] = N_A;
			} else {
				sc[i] = c.toString();
			}
			if (c != null) {
				k = i;
			}
		}
		String select = hero.isArmyFull() ? KINGCASTLE_NO_SLOTS : String.format(KINGCASTLE_SLOTS_COUNT, hero.getArmyFreeCount());
		String s = String.format(KINGCASTLE_UNIT_INFO, //
				castle.getName(), countToView(hero.getMoney()),//
				ss[0], ss[1], ss[2], ss[3], ss[4], //
				sc[0], sc[1], sc[2], sc[3], sc[4], //
				ch[k + 1], select);
		return s;
	}

	private String getUnitsCountInfo(Player hero, KingCastle castle) {
		String[] ch = { N_A, "A", "B", "C", "D", "E" };
		String[] ss = { "", "", "", "", "" };
		String[] sc = { "", "", "", "", "" };
		for (int i = 0; i < 5; i++) {
			final UnitTypes unit = castle.getUnitTypes()[i];
			String us = NameResolver.getUnitName(unit);
			us = (us == null) ? EMPTY : us;
			ss[i] = us;
			Integer c = unit.getUnitType().getCost();
			if (i >= (hero.getRank() + BASE_AVAIBLE_UNITS_COUNT)) {
				sc[i] = N_A;
			} else {
				sc[i] = c.toString();
			}
		}
		int k = castle.getUnitIndex();
		int n = getAvaibleCount();

		String s = String.format(KINGCASTLE_UNIT_COUNT_INFO, //
				castle.getName(), countToView(hero.getMoney()),//
				ss[0], ss[1], ss[2], ss[3], ss[4], //
				sc[0], sc[1], sc[2], sc[3], sc[4], //
				ch[k + 1], n);
		return s;
	}

	int getAvaibleCount() {
		KingCastle kingCastle = getGlobalPlayer().getActiveKingCastle();
		if (kingCastle == null)
			return 0;
		int mc = getGlobalPlayer().getHero().getMoney() / kingCastle.getUnit().getUnitType().getCost();
		int ll = getGlobalPlayer().getHero().getLeadership() / kingCastle.getUnit().getUnitType().getLeadership();
		int index = getGlobalPlayer().getHero().getArmy().indexOf(kingCastle.getUnit().getUnitType());
		if (index >= 0) {
			ll -= getGlobalPlayer().getHero().getArmyCount().get(index);
		}
		ll = Math.min(mc, ll);
		ll = Math.max(ll, 0);
		return ll;
	}

	private String getAudienceInfo(Player hero) {
		final String[] titlels;
		switch (hero.getType()) {
		case KNIGHT:
			titlels = TITLES_KNIGHT;
			break;
		case PALADIN:
			titlels = TITLES_PALADIN;
			break;
		case SORCERESS:
			titlels = TITLES_SORCERESS;
			break;
		default:
			titlels = TITLES_BARBARIAN;
			break;
		}
		String s = String.format(KING_DIALOG_DEAR, hero.getName());
		if (hero.getRank() == PlayerType.MAX_RANK) {
			s += "\n" + KING_DIALOG_MAX;
		} else if (hero.canLevelUp()) {
			hero.levelUp();
			s += "\n" + String.format(KING_DIALOG_PROMOTON, titlels[hero.getRank()]);
		} else {
			int r = hero.getRank() + 1;
			int xp = hero.getType().getXp()[r];
			int n = xp - hero.getKilledVillains().size();
			s += "\n" + String.format(KING_DIALOG_NEED_MORE, n);
		}
		return s;
	}

	@Override
	public void onNoInfo() {
		defaultInfo();
	}

	public void update() {
		updateInfo();
		updateMoney();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
		update();
	}

}
