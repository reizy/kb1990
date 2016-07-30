package ru.reizy.kb1990.view.android.army;

import java.util.ArrayList;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.base.ArmyHolder;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.view.android.KbAndroidActivity;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class ArmyActivity extends KbAndroidActivity {
	private ArmyPanel panel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.army);
		panel = new ArmyPanel(getWindow(), getResources());

		setMoveListeners();
		Button btnExit = ((Button) findViewById(R.id.btn_army_exit));
		btnExit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	private void setMoveListeners() {
		ArrayList<View> lines = new ArrayList<View>();
		lines.add((View) findViewById(R.id.line_0));
		lines.add((View) findViewById(R.id.line_1));
		lines.add((View) findViewById(R.id.line_2));
		lines.add((View) findViewById(R.id.line_3));
		lines.add((View) findViewById(R.id.line_4));
		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).setOnTouchListener(new ArmyTouchListener(i));
			lines.get(i).setOnDragListener(new ArmyDragListener(i));
		}

		View base = ((View) findViewById(R.id.base));
		base.setOnDragListener(new ArmyDragListener(ArmyHolder.ARMY_MAX_SIZE));

		View remove = ((View) findViewById(R.id.remove));
		remove.setOnDragListener(new ArmyRemoveDragListener());
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	};

	@Override
	protected void onResume() {
		super.onResume();
		panel.update();
	};

	@Override
	protected void onPause() {
		super.onPause();
		panel.stopUnitAnimation();
	};

	private final class ArmyTouchListener implements OnTouchListener {
		private final int id;

		public ArmyTouchListener(int id) {
			this.id = id;
		}

		@SuppressLint("ClickableViewAccessibility")
		@Override
		public boolean onTouch(View view, MotionEvent motionEvent) {
			if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
				ClipData data = ClipData.newPlainText("id", "" + id);
				DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
				view.startDrag(data, shadowBuilder, view, 0);
				// view.setVisibility(View.INVISIBLE);
				return true;
			}
			return false;
		}
	}

	private final class ArmyDragListener implements OnDragListener {
		private final int id;

		public ArmyDragListener(int id) {
			this.id = id;
		}

		@Override
		public boolean onDrag(View v, DragEvent event) {
			switch (event.getAction()) {
			case DragEvent.ACTION_DROP:
				Player player = getGlobalPlayer().getHero();
				final CharSequence cs_id2 = event.getClipData().getItemAt(0).getText();
				int id2 = Integer.parseInt(cs_id2.toString());
				player.switchInArmy(id, id2);
				panel.update();
				Object view = (View) event.getLocalState();
				if ((view != null) && (view instanceof View)) {
					((View) view).setVisibility(View.VISIBLE);
				}
				break;
			default:
				break;
			}
			return true;
		}
	}

	private final class ArmyRemoveDragListener implements OnDragListener {

		@Override
		public boolean onDrag(View v, DragEvent event) {
			switch (event.getAction()) {
			case DragEvent.ACTION_DROP:
				GlobalPlayer player = getGlobalPlayer();
				final CharSequence cs_id = event.getClipData().getItemAt(0).getText();
				int id = Integer.parseInt(cs_id.toString());
				player.removeFromArmy(id);
				panel.update();
				Object view = (View) event.getLocalState();
				if ((view != null) && (view instanceof View)) {
					((View) view).setVisibility(View.VISIBLE);
				}
				break;
			default:
				break;
			}
			return true;
		}
	}

	@Override
	public void onEvent(KBEvent e) {
		panel.update();
	}

}
