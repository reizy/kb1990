package ru.reizy.kb1990.view.android;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public abstract class KbAndroidMessagePanel extends KbAndroidPanel {

	public static final int FIELD_WIDTH = 6 - 1;
	public static final int FIELD_HEIGHT = 5;

	private final TextView infoImg;

	private Queue<String[]> infoQuery = new LinkedList<String[]>();
	private boolean infoMode;

	public KbAndroidMessagePanel(Window mWindow, Resources resources, int infoId) {
		super(mWindow, resources);
		if (infoId != 0) {
			this.infoImg = (TextView) findViewById(infoId);
			infoImg.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					KbAndroidMessagePanel.this.updateInfo();
				}
			});
		} else {
			this.infoImg = null;
		}

	}

	public boolean updateInfo() {
		String[] s = infoQuery.poll();
		if (infoImg != null) {

			infoMode = (s != null);

			if (infoMode) {
				infoImg.setVisibility(View.VISIBLE);
				String text = "";
				for (int i = 0; i < s.length; i++) {
					if (s[i] != null) {
						text += s[i] + "\n";
					}
				}
				infoImg.setText(text);
			} else {
				onNoInfo();
			}
		}
		return (infoMode);
	}

	protected abstract void onNoInfo();

	public void showMessage(String s) {
		String[] ss = s.split("\n");
		showMessage(ss);
	}

	public void showMessage(String[]... s) {
		infoQuery.addAll(Arrays.asList(s));
		updateInfo();
	}

	public boolean isInfoMode() {
		return infoMode;
	}

	public void hideInfo() {
		if (infoImg != null) {
			infoImg.setVisibility(View.GONE);
		}
	}

}
