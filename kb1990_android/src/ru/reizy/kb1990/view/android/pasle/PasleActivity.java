package ru.reizy.kb1990.view.android.pasle;

import ru.reizy.kb1990.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PasleActivity extends Activity {
	private PaslePanel panel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pasle);

		panel = new PaslePanel(this, getWindow(), getResources());

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
		panel.stopAnimation();
	};
}
