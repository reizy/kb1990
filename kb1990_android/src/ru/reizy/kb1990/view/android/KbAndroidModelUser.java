package ru.reizy.kb1990.view.android;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import android.graphics.Color;

public class KbAndroidModelUser {

	protected static int get64(int i) {
		return Color.rgb(i % 4 * 85, i / 4 % 4 * 85, i / 16 % 4 * 85);
	}

	protected KBModel getModel() {
		return ModelSingletonFactory.getInstance();
	}

	protected GlobalPlayer getGlobalPlayer() {
		return getModel().getGlobalPlayer();
	}

	protected GlobalMap getGlobalMap() {
		return getModel().getGlobalMap();
	}

}
