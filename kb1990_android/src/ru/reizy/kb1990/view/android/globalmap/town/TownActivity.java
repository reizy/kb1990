package ru.reizy.kb1990.view.android.globalmap.town;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.controller.android.town.BuySiegeListener;
import ru.reizy.kb1990.controller.android.town.BuySpellListener;
import ru.reizy.kb1990.controller.android.town.NewContractListener;
import ru.reizy.kb1990.controller.android.town.RentBoatListener;
import ru.reizy.kb1990.controller.android.town.TownInfoListener;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;
import ru.reizy.kb1990.model.globalmap.events.ResidenceOutEvent;
import ru.reizy.kb1990.model.globalmap.events.ShowContractEvent;
import ru.reizy.kb1990.model.globalmap.events.TownActionEvent;
import ru.reizy.kb1990.model.globalmap.events.TownInEvent;
import ru.reizy.kb1990.model.globalmap.residence.Town;
import ru.reizy.kb1990.view.android.KbAndroidActivity;
import ru.reizy.kb1990.view.android.villain.VillainActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class TownActivity extends KbAndroidActivity implements KBViewInterface {
	private TownPanel panel;
	private Button btnA;
	private Button btnB;
	private Button btnC;
	private Button btnD;
	private Button btnE;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.town_dialog);
		panel = new TownPanel(getWindow(), getResources());

		btnA = (Button) findViewById(R.id.btn_town_a);
		btnA.setOnClickListener(new NewContractListener());
		btnB = (Button) findViewById(R.id.btn_town_b);
		btnB.setOnClickListener(new RentBoatListener());
		btnC = (Button) findViewById(R.id.btn_town_c);
		btnC.setOnClickListener(new TownInfoListener(panel));
		btnD = (Button) findViewById(R.id.btn_town_d);
		btnD.setOnClickListener(new BuySpellListener());
		btnE = (Button) findViewById(R.id.btn_town_e);
		btnE.setOnClickListener(new BuySiegeListener());
		panel.updateInfo();
		panel.switchAndStartUnitAnimation();
		updateButtons();
	}

	@Override
	protected void onResume() {
		super.onResume();
		panel.updateControls(isExitButtonVisible());
		panel.updateContract();
		panel.updateSiege();
		panel.updateMagic();
		panel.updatePasleMap();
		panel.updateMoney();
		panel.startUnitAnimation();

		if (getGlobalPlayer().getActiveTown() == null) {
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
		if (event instanceof TownInEvent) {
			panel.updateContract();
			panel.updateSiege();
			panel.updateMagic();
			panel.updatePasleMap();
			panel.updateMoney();
			panel.switchAndStartUnitAnimation();
		} else if (event instanceof TownActionEvent) {
			panel.updateInfo();
			panel.updateSiege();
			panel.updateMoney();
			updateButtons();
		} else if (event instanceof ResidenceOutEvent) {
			finish();
		} else if (event instanceof ShowContractEvent) {
			panel.updateContract();
			showVillainInfo();
		}
	}

	private void updateButtons() {
		final Town activeTown = getGlobalPlayer().getActiveTown();
		if (activeTown != null) {
			final Player hero = getGlobalPlayer().getHero();
			btnA.setEnabled(!hero.getAliveVillains().isEmpty());
			btnB.setEnabled(getGlobalPlayer().getShip().getCell() != activeTown.getOutCell());
			btnC.setEnabled(true);
			final boolean hasMoneyToBuySpell = hero.getMoney() >= activeTown.getSpell().getCost();
			final boolean fullSpellCapacity = hero.getSpellCapacity() <= hero.getSpellsCount();
			btnD.setEnabled(hasMoneyToBuySpell && !fullSpellCapacity);
			btnE.setEnabled(!getGlobalPlayer().hasSeigeWeapon());
		}
	}

	private void showVillainInfo() {
		Intent intent = new Intent(this, VillainActivity.class);
		startActivity(intent);
	}
}
