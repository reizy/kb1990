package ru.reizy.kb1990.view.android.globalmap.kingcastle;

import static ru.reizy.kb1990.view.android.globalmap.kingcastle.KingCastlePanel.BASE_AVAIBLE_UNITS_COUNT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CANCEL;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.HOW_MANY_UNITS;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.OK;
import ru.reizy.kb1990.R;
import ru.reizy.kb1990.controller.android.residence.BuyUnitListener;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;
import ru.reizy.kb1990.model.globalmap.events.BuyUnitEvent;
import ru.reizy.kb1990.model.globalmap.events.CastleInEvent;
import ru.reizy.kb1990.model.globalmap.events.ResidenceOutEvent;
import ru.reizy.kb1990.model.globalmap.residence.KingCastle;
import ru.reizy.kb1990.view.android.KbAndroidActivity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class KingCastleActivity extends KbAndroidActivity implements KBViewInterface {
	private KingCastlePanel panel;
	// welcome
	private Button btnDialogA;
	private Button btnDialogB;
	// unit
	private Button btnBackWelcome;
	private Button btnA;
	private Button btnB;
	private Button btnC;
	private Button btnD;
	private Button btnE;
	// unit count
	private Button btnBackUnit;
	private Button btn1;
	private Button btn2;
	private Button btn5;
	private Button btn10;
	private Button btn25;
	private Button btnXX;
	// next
	private Button btnNext1;
	private Button btnNext2;
	// exit
	private ImageView exitBtn;

	private final LinearLayout[] btnPanels = new LinearLayout[5];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kingcastle_dialog);
		panel = new KingCastlePanel(getWindow(), getResources());

		// welcome
		btnDialogA = (Button) findViewById(R.id.btn_dialog_a);
		btnDialogA.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showUnits();
			}
		});
		btnDialogB = (Button) findViewById(R.id.btn_dialog_b);
		btnDialogB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showAudience1();
			}
		});
		// buy units
		btnBackWelcome = (Button) findViewById(R.id.btn_back_to_welcome);
		btnBackWelcome.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showWelcome();
			}
		});

		btnA = (Button) findViewById(R.id.btn_a);
		btnA.setOnClickListener(new SelectUnitListener(this, 0));
		btnB = (Button) findViewById(R.id.btn_b);
		btnB.setOnClickListener(new SelectUnitListener(this, 1));
		btnC = (Button) findViewById(R.id.btn_c);
		btnC.setOnClickListener(new SelectUnitListener(this, 2));
		btnD = (Button) findViewById(R.id.btn_d);
		btnD.setOnClickListener(new SelectUnitListener(this, 3));
		btnE = (Button) findViewById(R.id.btn_e);
		btnE.setOnClickListener(new SelectUnitListener(this, 4));

		// buy units count
		btnBackUnit = (Button) findViewById(R.id.btn_back_to_buy_unit);
		btnBackUnit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showUnits();
			}
		});
		btn1 = (Button) findViewById(R.id.btn_buy_1);
		btn1.setOnClickListener(new BuyUnitListener(1));
		btn2 = (Button) findViewById(R.id.btn_buy_2);
		btn2.setOnClickListener(new BuyUnitListener(2));
		btn5 = (Button) findViewById(R.id.btn_buy_5);
		btn5.setOnClickListener(new BuyUnitListener(5));
		btn10 = (Button) findViewById(R.id.btn_buy_10);
		btn10.setOnClickListener(new BuyUnitListener(10));
		btn25 = (Button) findViewById(R.id.btn_buy_25);
		btn25.setOnClickListener(new BuyUnitListener(25));
		btnXX = (Button) findViewById(R.id.btn_buy_XX);
		btnXX.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getCountDialog().show();
			}
		});
		// next
		btnNext1 = (Button) findViewById(R.id.btn_next1);
		btnNext1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showAudience2();
			}
		});
		btnNext2 = (Button) findViewById(R.id.btn_next2);
		btnNext2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showWelcome();
			}
		});

		// exit
		this.exitBtn = (ImageView) findViewById(R.id.exit);
		exitBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				getGlobalPlayer().goOut();
			}
		});

		btnPanels[0] = (LinearLayout) findViewById(R.id.panel_welcome);
		btnPanels[1] = (LinearLayout) findViewById(R.id.panel_buy_unit);
		btnPanels[2] = (LinearLayout) findViewById(R.id.panel_buy_count);
		btnPanels[3] = (LinearLayout) findViewById(R.id.panel_audience1);
		btnPanels[4] = (LinearLayout) findViewById(R.id.panel_audience2);

		panel.updateInfo();
		updateButtons();
	}

	@Override
	protected void onResume() {
		super.onResume();
		panel.switchAndStartUnitAnimation();
		panel.updateContract();
		panel.updateSiege();
		panel.updateMagic();
		panel.updatePasleMap();
		showWelcome();
		exitBtn.setVisibility(isExitButtonVisible() ? View.VISIBLE : View.INVISIBLE);
		if (getGlobalPlayer().getActiveKingCastle() == null) {
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
					panel.updateContract();
					panel.updateSiege();
					panel.updateMagic();
					panel.updatePasleMap();
					update();
				}
			});
		} else if (event instanceof BuyUnitEvent) {
			update();
		} else if (event instanceof ResidenceOutEvent) {
			finish();
		}
	}

	public void update() {
		panel.updateInfo();
		panel.updateMoney();
		updateButtons();
	}

	private void updateButtons() {
		final GlobalPlayer p = getGlobalPlayer();
		final Player hero = p.getHero();
		final KingCastle castle = p.getActiveKingCastle();
		final int avaible_units_index = hero.getRank() + BASE_AVAIBLE_UNITS_COUNT;
		final boolean isArmyFull = hero.isArmyFull();
		boolean[] b = { false, false, false, false, false };
		if (castle != null) {
			for (int i = 0; i < b.length; i++) {
				boolean hasUnitInArmy = hero.getArmy().contains(castle.getUnitTypes()[i].getUnitType());
				b[i] = ((hasUnitInArmy) || (!isArmyFull)) && (i < avaible_units_index);
			}
		}
		btnA.setEnabled(b[0]);
		btnB.setEnabled(b[1]);
		btnC.setEnabled(b[2]);
		btnD.setEnabled(b[3]);
		btnE.setEnabled(b[4]);

		final int avaible_unit_count = panel.getAvaibleCount();

		btn1.setEnabled(1 <= avaible_unit_count);
		btn2.setEnabled(2 <= avaible_unit_count);
		btn5.setEnabled(5 <= avaible_unit_count);
		btn10.setEnabled(10 <= avaible_unit_count);
		btn25.setEnabled(25 <= avaible_unit_count);
	}

	/**
	 * @param x
	 */
	private void showPanel(int x) {
		for (int i = 0; i < btnPanels.length; i++) {
			if (i == x) {
				btnPanels[i].setVisibility(View.VISIBLE);
			} else {
				btnPanels[i].setVisibility(View.GONE);
			}
		}
		panel.setIndex(x);
		panel.updateMoney();
		updateButtons();
	}

	public void showWelcome() {
		showPanel(0);
	}

	public void showUnits() {
		showPanel(1);
	}

	public void showCount() {
		showPanel(2);
	}

	public void showAudience1() {
		showPanel(3);
	}

	public void showAudience2() {
		showPanel(4);
	}

	private Builder getCountDialog() {
		final EditText inputName = new EditText(this);
		inputName.setLines(1);
		inputName.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
		return new AlertDialog.Builder(this).setTitle(HOW_MANY_UNITS).setMessage("")//
				.setView(inputName)//
				.setPositiveButton(OK, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						Editable value = inputName.getText();
						final String string = value.toString();
						if ((string.length() > 0) && (string.length() < 8)) {
							int count = Integer.parseInt(string);
							getGlobalPlayer().buyUnit(count);
						}
					}
				}).setNegativeButton(CANCEL, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// nothing to do
					}
				});
	}
}
