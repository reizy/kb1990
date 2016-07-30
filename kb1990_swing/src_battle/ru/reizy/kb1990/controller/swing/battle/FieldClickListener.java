package ru.reizy.kb1990.controller.swing.battle;

import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.ZOOM;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ru.reizy.kb1990.model.battle.BattleModel;

public class FieldClickListener implements MouseListener {
	private BattleModel model;
	private BattleController controller;

	FieldClickListener(BattleModel model, BattleController controller) {
		this.model = model;
		this.controller = controller;
	}

	public void mouseClicked(final MouseEvent event) {

	}

	public void mouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(final MouseEvent event) {
		if (event.getButton() == MouseEvent.BUTTON1) {
			controller.runIt(new Runnable() {
				public void run() {
					int x = event.getX();
					int y = event.getY();
					x /= CELL_DIMENSION.width*ZOOM;
					y /= CELL_DIMENSION.height*ZOOM;
					model.goActiveTo(x, y);
				}
			});
		} else if (event.getButton() != MouseEvent.BUTTON1) {
			controller.getUnitWaitController().actionPerformed(null);
		}
	}
}
