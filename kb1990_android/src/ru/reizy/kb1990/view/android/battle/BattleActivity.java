package ru.reizy.kb1990.view.android.battle;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.view.android.KbAndroidActivity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;

public class BattleActivity extends KbAndroidActivity {

	private BattleView panel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battle);
		panel = new BattleView(this);
		updateOptions(panel.getOptions());
	}

	@Override
	protected void onResume() {
		super.onResume();
		updateOptions(panel.getOptions());
		panel.update();
		if ((getModel().getBattleModel() == null) //
				|| (getModel().getBattleModel().getPlayerArmy().size() == 0) //
				|| (getModel().getBattleModel().getEnemyArmy().size() == 0)) {
			finish();
		}
	};

	@Override
	protected void onPause() {
		super.onPause();
		panel.stopUnitAnimation();
	}

	@Override
	public void onEvent(KBEvent e) {
		panel.onEvent(e);
	};

	Builder getGiveUpDialog(DialogInterface.OnClickListener listener) {
		return new AlertDialog.Builder(this).setTitle("Сбежать с поля боя?")//
				.setMessage("Вы потеряете свою армию...")//
				.setPositiveButton("Да", listener).setNegativeButton("Нет", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// Do nothing.
					}
				});
	}

}
