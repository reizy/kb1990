package ru.reizy.kb1990.view.android;

import android.app.Activity;
import android.os.Bundle;

public class KbOptionsActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getFragmentManager().beginTransaction().replace(android.R.id.content, new KbOptionsFragment()).commit();

	}
}