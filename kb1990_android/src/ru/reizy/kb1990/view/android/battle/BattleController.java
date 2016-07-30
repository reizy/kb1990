package ru.reizy.kb1990.view.android.battle;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.controller.android.battle.BattleFieldClickController;
import ru.reizy.kb1990.model.battle.KBModelBattleI;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class BattleController {
	public static final int FIELD_WIDTH = 6;
	public static final int FIELD_HEIGHT = 5;

	private final Window mWindow;

	BattleController(final KBModelBattleI gModel, final BattleView battleView, Window mWindow, Resources resources,
			final BattleFieldClickController bfController, final BattleMagicPanel magicPanel) {
		this.mWindow = mWindow;
		final ImageButton btnW = (ImageButton) findViewById(R.id.btn_wait);
		btnW.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				bfController.runIt(new Runnable() {
					@Override
					public void run() {
						gModel.getBattleModel().waitPlayerUnit();
					}
				});
			}
		});

		final ImageButton btnP = (ImageButton) findViewById(R.id.btn_pass);
		btnP.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				bfController.runIt(new Runnable() {
					@Override
					public void run() {
						gModel.getBattleModel().missPlayerUnit();
					}
				});
			}
		});
		final ImageButton btnM = (ImageButton) findViewById(R.id.btn_magic);
		btnM.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (magicPanel.isVisible()) {
					magicPanel.hide();
				} else {
					magicPanel.show();
				}
			}
		});

		final ImageButton btnG = (ImageButton) findViewById(R.id.btn_giveUp);
		btnG.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				battleView.getGiveUpDialog(new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						gModel.getBattleModel().giveUp();
					}
				}).show();
			}
		});
	}

	protected View findViewById(int id) {
		return mWindow.findViewById(id);
	}

	public void updateControls() {

	}

}
