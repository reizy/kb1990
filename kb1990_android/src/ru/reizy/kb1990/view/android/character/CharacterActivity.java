package ru.reizy.kb1990.view.android.character;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.view.android.KbAndroidActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CharacterActivity extends KbAndroidActivity {
	private CharacterPanel panel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.character);

		panel = new CharacterPanel(this, getWindow(), getResources());

		Button btnExit = (Button) findViewById(R.id.btn_exit);
		btnExit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		panel.update();
	}

	@Override
	protected void onResume() {
		super.onResume();
		panel.update();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	public void onEvent(KBEvent arg0) {
		panel.update();
	};
}
