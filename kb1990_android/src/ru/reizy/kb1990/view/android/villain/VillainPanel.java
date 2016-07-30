package ru.reizy.kb1990.view.android.villain;

import static ru.reizy.kb1990.view.strings.ru.StringConstants.NO_CONTRACT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.VILLAIN_ALIAS;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.VILLAIN_CASTLE_NAME;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.VILLAIN_CONTINENT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.VILLAIN_CRIMES;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.VILLAIN_FEATURES;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.VILLAIN_NAME;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.VILLAIN_REWARD;
import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.villains.Villain;
import ru.reizy.kb1990.view.android.KbAndroidMessagePanel;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import ru.reizy.kb1990.view.android.resource.VillainsTexture;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ImageView;

public class VillainPanel extends KbAndroidMessagePanel {
	private final Drawable TRANSP;

	private Drawable o;

	private final VillainsTexture villainsTexture;
	private final ImageView contractCell;
	private final Activity activity;

	public VillainPanel(Activity activity, Window mWindow, Resources resources) {
		super(mWindow, resources, R.id.villain_info);
		TRANSP = (BitmapDrawable) getResources().getDrawable(R.drawable.transparent);
		this.activity = activity;
		this.villainsTexture = new VillainsTexture(getResources());
		this.contractCell = (ImageView) findViewById(R.id.villain_logo);
		updateContract();
	}

	public void stopUnitAnimation() {
		if (o != null) {
			if (o instanceof AnimationDrawable) {
				if (((AnimationDrawable) o).isRunning()) {
					((AnimationDrawable) o).stop();
				}
			}
		}
	};

	public void defaultInfo() {
		final GlobalPlayer p = getGlobalPlayer();
		final Villain v = getGlobalPlayer().getContract();
		String s = "";
		if (v != null) {
			String ms;
			VilliansInfo _v = VilliansInfo.get(v);

			s += "         " + String.format(VILLAIN_NAME, _v.getName());
			s += "\n         " + String.format(VILLAIN_ALIAS, _v.getAlias());
			s += "\n         " + String.format(VILLAIN_REWARD, v.getBounty());

			s += "\n         " + String.format(VILLAIN_CONTINENT, NameResolver.getContinentName(v.getContinet()));
			final Castle castle = p.getContractersCastle();
			s += "\n         " + String.format(VILLAIN_CASTLE_NAME, NameResolver.getCastleName(castle));

			ms = _v.getFeatures();
			s += "\n";
			s += "\n" + String.format(VILLAIN_FEATURES, ms);
			ms = _v.getCrimes();
			s += "\n";
			s += "\n" + String.format(VILLAIN_CRIMES, ms);

		} else {
			s = "\n\n\n          " + NO_CONTRACT;
		}

		showMessage(s);

	}

	@Override
	public void onNoInfo() {
		defaultInfo();
		activity.finish();
	}

	void updateContract() {
		{
			o = contractCell.getBackground();
			if (o instanceof AnimationDrawable) {
				((AnimationDrawable) o).stop();
			}
		}
		final Villain contract = getGlobalPlayer().getContract();
		if (contract != null) {
			int resid = villainsTexture.villains_a.get(contract.getId());
			contractCell.setImageResource(resid);
			o = (AnimationDrawable) contractCell.getDrawable();
			((AnimationDrawable) o).start();
		} else {
			contractCell.setImageDrawable(TRANSP);
			o = null;
		}
		defaultInfo();
	}

}
