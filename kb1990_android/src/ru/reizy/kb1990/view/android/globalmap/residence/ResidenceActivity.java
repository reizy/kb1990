package ru.reizy.kb1990.view.android.globalmap.residence;

import static ru.reizy.kb1990.view.strings.ru.StringConstants.CANCEL;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.HOW_MANY_UNITS;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.OK;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.RESIDENCE_BUY;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.RESIDENCE_NO_LEADERSHIP;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.RESIDENCE_NO_MONEY;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.RESIDENCE_NO_SLOTS;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.RESIDENCE_NO_UNITS;
import ru.reizy.kb1990.R;
import ru.reizy.kb1990.controller.android.residence.BuyUnitListener;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;
import ru.reizy.kb1990.model.globalmap.events.BuyUnitEvent;
import ru.reizy.kb1990.model.globalmap.events.ResidenceInEvent;
import ru.reizy.kb1990.model.globalmap.events.ResidenceOutEvent;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence.BuyStatus;
import ru.reizy.kb1990.view.android.KbAndroidActivity;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

public class ResidenceActivity extends KbAndroidActivity implements KBViewInterface {
	private ResidencePanel panel;
	private Button btn1;
	private Button btn2;
	private Button btn5;
	private Button btn10;
	private Button btn25;
	private Button btn99;
	private Button btnXX;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.residence_dialog);
		panel = new ResidencePanel(getWindow(), getResources());

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
		btn99 = (Button) findViewById(R.id.btn_buy_99);
		btn99.setOnClickListener(new BuyUnitListener(99));
		btnXX = (Button) findViewById(R.id.btn_buy_XX);
		btnXX.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getCountDialog().show();
			}
		});

		panel.updateInfo();
		updateButtons();
	}

	@Override
	protected void onResume() {
		super.onResume();
		panel.update(isExitButtonVisible());
		if (getGlobalPlayer().getActiveResidence() == null) {
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
		if (event instanceof ResidenceInEvent) {
			panel.update(isExitButtonVisible());
			updateButtons();
		} else if (event instanceof BuyUnitEvent) {
			update((BuyUnitEvent) event);
			updateButtons();
			panel.updateInfo();
		} else if (event instanceof ResidenceOutEvent) {
			finish();
		}
	}

	public void update(BuyUnitEvent event) {
		final BuyStatus status = event.getStatus();
		if (status != null) {
			SimpleUnitResidence residence = getGlobalPlayer().getActiveResidence();
			String unitName = NameResolver.getUnitName(residence.getUnit());
			switch (status) {
			case NO_UNITS:
				panel.showMessage(RESIDENCE_NO_UNITS);
				break;
			case NO_MONEY:
				panel.showMessage(RESIDENCE_NO_MONEY);
				break;
			case NO_LEADERSHIP:
				panel.showMessage(RESIDENCE_NO_LEADERSHIP);
				break;
			case NO_SLOTS:
				panel.showMessage(String.format(RESIDENCE_NO_SLOTS, unitName));
				break;
			default:
				panel.showMessage(String.format(RESIDENCE_BUY, unitName, event.getCount()));
			}
		}
		panel.update(isExitButtonVisible());
	}

	private void updateButtons() {
		int k = panel.getAvaibleCount();
		btn1.setEnabled(k >= 1);
		btn2.setEnabled(k >= 2);
		btn5.setEnabled(k >= 5);
		btn10.setEnabled(k >= 10);
		btn25.setEnabled(k >= 25);
		btn99.setEnabled(k >= 99);
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
