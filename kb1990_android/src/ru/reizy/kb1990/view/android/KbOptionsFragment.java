package ru.reizy.kb1990.view.android;

import ru.reizy.kb1990.R;
import android.os.Bundle;
import android.preference.PreferenceFragment;

public class KbOptionsFragment extends PreferenceFragment {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.options);
	}

	
}