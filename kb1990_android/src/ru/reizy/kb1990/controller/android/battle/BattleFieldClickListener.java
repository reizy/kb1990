package ru.reizy.kb1990.controller.android.battle;

import ru.reizy.kb1990.model.battle.KBModelBattleI;
import android.view.View;

public class BattleFieldClickListener implements View.OnClickListener {
	private final KBModelBattleI gModel;
	private final int x;
	private final int y;
	private final BattleFieldClickController controller;

	public BattleFieldClickListener(KBModelBattleI gModel, BattleFieldClickController controller, int x, int y) {
		this.gModel = gModel;
		this.controller = controller;
		this.x = x;
		this.y = y;
	}

	@Override
	public void onClick(View v) {
		controller.runIt(new Runnable() {
			@Override
			public void run() {
				gModel.getBattleModel().goActiveTo(x, y);
			}
		});
	}

}
