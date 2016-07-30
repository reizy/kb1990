package ru.reizy.kb1990.view.android.globalmap.castle;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.controller.android.castle.CastleActionListener;
import ru.reizy.kb1990.controller.android.castle.GarnisonListener;
import ru.reizy.kb1990.model.base.ArmyHolder;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.events.BattleStartEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;
import ru.reizy.kb1990.model.globalmap.events.CastleActionEvent;
import ru.reizy.kb1990.model.globalmap.events.CastleInEvent;
import ru.reizy.kb1990.model.globalmap.events.ResidenceOutEvent;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.view.android.KbAndroidActivity;
import ru.reizy.kb1990.view.android.battle.BattleActivity;
import ru.reizy.kb1990.view.android.battle.BattleView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CastleActivity extends KbAndroidActivity implements KBViewInterface {
	private static final int BATTLE_ACTIVITY_ID = 3;
	private CastlePanel panel;
	private Button btnAction;
	private Button btnA;
	private Button btnB;
	private Button btnC;
	private Button btnD;
	private Button btnE;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.castle_dialog);
		panel = new CastlePanel(getWindow(), getResources());

		btnAction = (Button) findViewById(R.id.btn_action);
		btnAction.setOnClickListener(new CastleActionListener(this));
		btnA = (Button) findViewById(R.id.btn_a);
		btnA.setOnClickListener(new GarnisonListener(panel, 0));
		btnB = (Button) findViewById(R.id.btn_b);
		btnB.setOnClickListener(new GarnisonListener(panel, 1));
		btnC = (Button) findViewById(R.id.btn_c);
		btnC.setOnClickListener(new GarnisonListener(panel, 2));
		btnD = (Button) findViewById(R.id.btn_d);
		btnD.setOnClickListener(new GarnisonListener(panel, 3));
		btnE = (Button) findViewById(R.id.btn_e);
		btnE.setOnClickListener(new GarnisonListener(panel, 4));
		panel.update(isExitButtonVisible());
		updateButtons();
	}

	@Override
	protected void onResume() {
		super.onResume();
		panel.switchAndStartUnitAnimation();
		update();
		if (getGlobalPlayer().getActiveCastle() == null) {
			finish();
		}
	};

	@Override
	protected void onPause() {
		super.onPause();
		panel.stopUnitAnimation();
	};

	@Override
	public void onEvent(KBEvent event) {
		if (event instanceof CastleInEvent) {
			// on battle win it can be another
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					panel.switchAndStartUnitAnimation();
					update();
				}
			});
		} else if (event instanceof CastleActionEvent) {
			update();
		} else if (event instanceof ResidenceOutEvent) {
			finish();
		} else if (event instanceof BattleStartEvent) {
			onBattleStartEvent();
		}
	}

	public void update() {
		panel.updateContract();
		panel.updateSiege();
		panel.updateMagic();
		panel.updatePasleMap();
		panel.updateInfo();
		panel.updateMoney();
		panel.update(isExitButtonVisible());
		updateButtons();
	}

	private void updateButtons() {
		GlobalPlayer player = getGlobalPlayer();
		Castle activeCastle = player.getActiveCastle();
		boolean e1 = (activeCastle == null);
		boolean e2 = ((!e1) && (activeCastle.getHero() == null));
		boolean e3 = e2 && panel.getGarnison();
		boolean e4 = e2 && !panel.getGarnison();
		boolean e5 = ((!e1) && (!e2) && (player.hasSeigeWeapon()));

		btnAction.setEnabled(e2 || e5);
		boolean[] b = { false, false, false, false, false };
		if (e4) {
			if (player.getHero().getArmy().size() < ArmyHolder.ARMY_MAX_SIZE) {
				for (int i = 0; i < activeCastle.getArmy().size(); i++) {
					b[i] = true;
				}
			}
		} else if (e3) {
			if (player.getHero().getArmy().size() > 1) {
				if (activeCastle.getArmy().size() < ArmyHolder.ARMY_MAX_SIZE) {
					Player p = player.getHero();
					for (int i = 0; i < player.getHero().getArmy().size(); i++) {
						Integer c = p.getArmyCount(i);
						c *= p.getArmy(i).getWeekCost();
						b[i] = p.getMoney() >= c;
					}
				}
			}
		}
		btnA.setEnabled(b[0]);
		btnB.setEnabled(b[1]);
		btnC.setEnabled(b[2]);
		btnD.setEnabled(b[3]);
		btnE.setEnabled(b[4]);
	}

	public boolean getGarnison() {
		return panel.getGarnison();
	}

	public void setGarrison(boolean garnison) {
		panel.setGarrison(garnison);
	}

	private void onBattleStartEvent() {
		Intent intent = new Intent(this, BattleActivity.class);
		startActivityForResult(intent, BATTLE_ACTIVITY_ID);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == BATTLE_ACTIVITY_ID) {
			if (resultCode == BattleView.BATTLE_FAIL_RESULT) {
				setResult(BattleView.BATTLE_FAIL_RESULT);
				finish();
			} else {
				panel.updateContract();
			}
		}
	}

}
