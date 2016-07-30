package kb.constructor.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import kb.constructor.view.ConstructorView;
import kb.constructor.view.globalmap.ConstructorFieldPanel;
import ru.reizy.kb1990.model.constructor.ConstructorModel;

public class ConstructorFieldClickListener implements MouseListener {

	private ConstructorModel model;
	private ConstructorView view;

	public ConstructorFieldClickListener(ConstructorModel model,
			ConstructorView view) {
		super();
		this.model = model;
		this.view = view;
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
			int y = event.getY();
			x /= ConstructorFieldPanel.CELL_DIMENSION.width;
			y /= ConstructorFieldPanel.CELL_DIMENSION.height;
			
			x = x - (ConstructorFieldPanel.FIELD_WIDTH / 2) + view.getX();
			y = -y + ((ConstructorFieldPanel.FIELD_HEIGHT - 1) / 2)
					+ view.getY();
			System.out.println(x + " " + y);
			model.setByActive(x, y);

		} else if (event.getButton() != MouseEvent.BUTTON2) {
			model.nextActive();
		} else if (event.getButton() != MouseEvent.BUTTON3) {
			model.nextActive(4);
		}
	}
}
