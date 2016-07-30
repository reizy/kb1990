package ru.reizy.kb1990.controller.android.globalmap;

import static ru.reizy.kb1990.view.android.globalmap.GlobalFieldPanel.FIELD_HEIGHT;
import static ru.reizy.kb1990.view.android.globalmap.GlobalFieldPanel.FIELD_WIDTH;
import static ru.reizy.kb1990.view.android.globalmap.GlobalFieldPanel.MOVE_DISTANCE;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.view.android.KbAndroidModelUser;
import ru.reizy.kb1990.view.android.globalmap.GlobalFieldPanel;
import android.view.View;

public class GlobalFieldClickListener extends KbAndroidModelUser implements View.OnClickListener {
	private final int x;
	private final int y;
	private final GlobalFieldPanel p;

	public GlobalFieldClickListener(GlobalFieldPanel globalFieldPanel, int x, int y) {
		this.x = x;
		this.y = y;
		this.p = globalFieldPanel;
	}

	@Override
	public void onClick(View v) {
		if (!p.isInfoMode()) {
			// if (check(x, y)) {
			Cell cell = getGlobalPlayer().getCell();
			// делаемотносительно центра
			int _x = x - (FIELD_WIDTH / 2);
			int _y = -y + (FIELD_HEIGHT / 2);
			// делаем далекий клик близким
			_x = (_x != 0) ? _x / Math.abs(_x) : 0;
			_y = (_y != 0) ? _y / Math.abs(_y) : 0;
			// приводим к абсолютным координатам
			_x += cell.getX();
			_y += cell.getY();

			getGlobalMap().goTo(_x, _y);
			// }
		} else {
			p.updateInfo();
		}

	}

	static boolean check(int i, int j) {
		return ((i <= FIELD_WIDTH / 2 + MOVE_DISTANCE)//
				&& (i >= FIELD_WIDTH / 2 - MOVE_DISTANCE)//
				&& (j <= FIELD_HEIGHT / 2 + MOVE_DISTANCE)//
		&& (j >= FIELD_HEIGHT / 2 - MOVE_DISTANCE)//
		);
	}
}
