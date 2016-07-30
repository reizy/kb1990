package ru.reizy.kb1990.view.android;

import java.io.InputStream;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.KBModelDefault;
import ru.reizy.kb1990.model.globalmap.Difficulty;
import ru.reizy.kb1990.model.globalmap.PlayerType;

public final class ModelSingletonFactory {
	private static KBModelDefault model;

	private ModelSingletonFactory() {
		// nothing
	}

	public static KBModel init(String name, PlayerType type, Difficulty difficulty, InputStream... s) {
		if (model == null) {
			model = new KBModelDefault(name, type, difficulty, s);
		} else {
			model.init(name, type, difficulty, s);
		}
		return getInstance();
	}

	public static KBModel getInstance() {
		return model;
	}

	public static void clearInstance() {
		if (model != null) {
			model.clearViews();
		}
	}
}
