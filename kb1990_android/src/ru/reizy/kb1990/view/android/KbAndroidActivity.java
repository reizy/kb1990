package ru.reizy.kb1990.view.android;

import java.io.InputStream;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.globalmap.Difficulty;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;
import ru.reizy.kb1990.model.globalmap.PlayerType;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;

public abstract class KbAndroidActivity extends Activity implements KBViewInterface {

	protected static int get64(int i) {
		return Color.rgb(i % 4 * 85, i / 4 % 4 * 85, i / 16 % 4 * 85);
	}

	protected GlobalPlayer getGlobalPlayer() {
		return getModel().getGlobalPlayer();
	}

	protected GlobalMap getGlobalMap() {
		return getModel().getGlobalMap();
	}

	protected KBModel getModel() {
		if (ModelSingletonFactory.getInstance() == null) {
			reloadModel("Username", PlayerType.SORCERESS, Difficulty.EASY);
		}
		return ModelSingletonFactory.getInstance();
	}

	protected void reloadModel(String name, PlayerType type, Difficulty difficulty) {
		ModelSingletonFactory.clearInstance();
		InputStream[] s = { getResources().openRawResource(R.raw.m1), getResources().openRawResource(R.raw.m2), getResources().openRawResource(R.raw.m3),
				getResources().openRawResource(R.raw.m4) };
		ModelSingletonFactory.init(name, type, difficulty, s);
		if (getModel() != null) {
			getModel().addView(this);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getModel().addView(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		getModel().removeView(this);
	};

	@Override
	protected void onResume() {
		super.onResume();
		getModel().addView(this);
	};

	@Override
	protected void onPause() {
		super.onPause();
		getModel().removeView(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getClass().getName() == null) ? 0 : getClass().getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof KbAndroidActivity))
			return false;
		KbAndroidActivity other = (KbAndroidActivity) obj;
		if (!getClass().getName().equals(other.getClass().getName()))
			return false;
		return true;
	};

	/** get options from xml */
	protected void updateOptions(KbViewOptions o) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

		int bg = Integer.parseInt(prefs.getString("battleGridVisible", "2"));
		o.setBattleGridVisible(bg);
		o.setExitButtonVisible(prefs.getBoolean("exitButtonVisible", true));
		o.setLifeBarVisible(prefs.getBoolean("lifeBarVisible", true));
		o.setMoraleVisible(prefs.getBoolean("moraleVisible", true));
		o.setRichMinimap(prefs.getBoolean("richMinimap", true));
		o.setSpellOnTownPortalVisible(prefs.getBoolean("spellOnTownPortalVisible", true));
		o.setUnitCountVisible(prefs.getBoolean("unitCountVisible", true));

	}

	/** get option from xml */
	protected boolean isExitButtonVisible() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		return prefs.getBoolean("exitButtonVisible", true);
	}
}
