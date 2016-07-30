package ru.reizy.kb1990.view.swing.globalmap.controller;

import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.ZOOM;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.view.swing.globalmap.view.GlobalFieldPanel;

public class GlobalFieldClickListener implements MouseListener {
	KBModel model;
	GlobalFieldPanel panelF;

	public GlobalFieldClickListener(KBModel model, GlobalFieldPanel panelF) {
		this.model = model;
		this.panelF = panelF;
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseReleased(MouseEvent event) {
		if (event.getButton() == MouseEvent.BUTTON1) {
			if ((!panelF.isInfoMode()) & (!panelF.updateInfo())) {
				int x = event.getX();
				int y = event.getY();
				x /= CELL_DIMENSION.width * ZOOM;
				y /= CELL_DIMENSION.height * ZOOM;
				Cell cell = model.getGlobalPlayer().getCell();
				x = x - (GlobalFieldPanel.FIELD_WIDTH / 2) + cell.getX();
				y = -y + (GlobalFieldPanel.FIELD_HEIGHT / 2) + cell.getY();
				model.getGlobalMap().goTo(x, y);
			}
		}
	}
}
