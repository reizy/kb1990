package ru.reizy.kb1990.view.android.resource;

import android.content.res.Resources;

public class Texture {
	private final Resources resources;

	protected Texture(Resources resources) {
		this.resources = resources;
	}

	protected Resources getResources() {
		return resources;
	}
}
