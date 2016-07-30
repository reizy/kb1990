package kb.globalmap.controller;

import static ru.reizy.kb1990.view.swing.KBResources.ZOOM;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import kb.globalmap.view.MapFieldPanel;
import ru.reizy.kb1990.KBModelI;

public class MapFieldClickListener implements MouseListener {
	KBModelI model;

	public MapFieldClickListener(KBModelI model) {
		this.model = model;
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
			int x = event.getX();
			int y = event.getY();
			x /= MapFieldPanel.CELL_DIMENSION.width * ZOOM;
			y /= MapFieldPanel.CELL_DIMENSION.height * ZOOM;
			y = MapFieldPanel.FIELD_HEIGHT - (y + 1);
			model.getGlobalMap().goTo(x, y);
		}
	}

}
