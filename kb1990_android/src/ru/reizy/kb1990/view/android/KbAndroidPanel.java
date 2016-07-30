package ru.reizy.kb1990.view.android;

import android.content.res.Resources;
import android.view.View;
import android.view.Window;

public class KbAndroidPanel extends KbAndroidModelUser {
	private final Resources resources;
	private final Window mWindow;

	public KbAndroidPanel(Window mWindow, Resources resources) {
		this.resources = resources;
		this.mWindow = mWindow;
	}

	protected Resources getResources() {
		return resources;
	}

	protected View findViewById(int id) {
		return mWindow.findViewById(id);
	}

}
