package kb.constructor.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import kb.constructor.view.ConstructorView;
import ru.reizy.kb1990.model.constructor.ConstructorModel;

public class ConstructorKeyListener implements KeyListener {

	private static final int KEY_UP = 38;
	private static final int KEY_DOWN = 40;
	private static final int KEY_LEFT = 37;
	private static final int KEY_RIGHT = 39;
	private static final int KEY_S = 83;
	private ConstructorModel model;
	private ConstructorView view;

	public ConstructorKeyListener(ConstructorModel model, ConstructorView view) {
		super();
		this.model = model;
		this.view = view;
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KEY_UP:
			view.setY(view.getY() + 1);
			break;
		case KEY_DOWN:
			view.setY(view.getY() - 1);
			break;
		case KEY_LEFT:
			view.setX(view.getX() - 1);
			break;
		case KEY_RIGHT:
			view.setX(view.getX() + 1);
			break;
		case KEY_S:
			model.save();
			break;

		default:
			System.out.println(e.getKeyCode());
			break;
		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
