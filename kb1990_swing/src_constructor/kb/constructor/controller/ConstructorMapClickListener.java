package kb.constructor.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import kb.constructor.view.globalmap.ConstructorControlPanel;
import ru.reizy.kb1990.model.constructor.ConstructorModel;
import ru.reizy.kb1990.model.globalmap.FieldType;
import ru.reizy.kb1990.view.swing.FieldTypeTexture;

public class ConstructorMapClickListener implements MouseListener {

	private ConstructorModel model;
	public ConstructorMapClickListener(ConstructorModel model) {
		super();
		this.model = model;
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
			int x = event.getX();
			int y = event.getY()
					- ConstructorControlPanel.CELL_DIMENSION.height;
			x /= (ConstructorControlPanel.CELL_DIMENSION.width / 4);
			y /= (ConstructorControlPanel.CELL_DIMENSION.height / 3);
			if (y >= 6) {
				y -= 6;
				x += 6;
			}
			int id = Arrays.binarySearch(FieldType.values(),
					FieldTypeTexture.getInv(x, y));
			model.setActive(id);
		}
	}
}
