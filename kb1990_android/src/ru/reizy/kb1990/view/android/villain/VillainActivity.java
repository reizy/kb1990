package ru.reizy.kb1990.view.android.villain;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;
import ru.reizy.kb1990.view.android.KbAndroidActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VillainActivity extends KbAndroidActivity implements KBViewInterface {
	private VillainPanel panel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.villain_dialog);
		panel = new VillainPanel(this, getWindow(), getResources());
		panel.updateContract();
		Button btn = (Button) findViewById(R.id.btn_next1);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				panel.updateInfo();
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		panel.updateContract();
	};

	@Override
	protected void onPause() {
		super.onPause();
		panel.stopUnitAnimation();
	};

	@Override
	public void onEvent(KBEvent event) {
		panel.updateContract();
	}

}
