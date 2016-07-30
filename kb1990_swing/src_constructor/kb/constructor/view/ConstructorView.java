package kb.constructor.view;

import java.awt.BorderLayout;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kb.constructor.controller.ConstructorFieldClickListener;
import kb.constructor.controller.ConstructorKeyListener;
import kb.constructor.controller.ConstructorMapClickListener;
import kb.constructor.view.castles.ConstructorCastlesPanel;
import kb.constructor.view.globalmap.ConstructorControlPanel;
import kb.constructor.view.globalmap.ConstructorFieldPanel;
import kb.constructor.view.signposts.ConstructorSignPostsPanel;
import kb.constructor.view.towns.ConstructorTownsPanel;
import ru.reizy.kb1990.model.constructor.ConstructorModel;

public class ConstructorView extends JFrame implements Observer {
	private static final long serialVersionUID = 7906405279378066763L;

	public static final float ZOOM = 1.0000f;

	final private ConstructorFieldPanel panelF;
	final private ConstructorControlPanel panelC;
	final private ConstructorCastlesPanel panelCastles;
	final private ConstructorTownsPanel panelTowns;
	final private ConstructorSignPostsPanel panelSignPosts;

	private int x;
	private int y;

	public ConstructorView(final ConstructorModel model) {
		super();
		Map<String, JPanel> panels = new TreeMap<String, JPanel>();
		setLayout(new BorderLayout());
		final ConstructorKeyListener keyListener = new ConstructorKeyListener(
				model, this);
		final JPanel mapPanel = new JPanel();
		mapPanel.setFocusable(true);
		mapPanel.addKeyListener(keyListener);
		panels.put("_Карта", mapPanel);
		panelF = new ConstructorFieldPanel(model, this);
		mapPanel.add(panelF);
		panelC = new ConstructorControlPanel(model, this);
		mapPanel.add(panelC, BorderLayout.EAST);

		model.addObserver(this);
		panelF.addMouseListener(new ConstructorFieldClickListener(model, this));
		addKeyListener(keyListener);
		panelC.addMouseListener(new ConstructorMapClickListener(model));

		panelCastles = new ConstructorCastlesPanel(model);
		panels.put("Замки", panelCastles);
		panelTowns = new ConstructorTownsPanel(model);
		panels.put("Города", panelTowns);
		panelSignPosts = new ConstructorSignPostsPanel(model);
		panels.put("Указатели", panelSignPosts);

		generateCardPanel(panels);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setResizable(false);
		setVisible(true);

	}

	private void generateCardPanel(Map<String, JPanel> panels) {
		final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFocusable(false);
		for (Entry<String, JPanel> e : panels.entrySet()) {
			tabbedPane.addTab(e.getKey(), e.getValue());
		}
		add(tabbedPane);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public synchronized void setX(int x) {
		if ((x >= 0) && (x < ConstructorModel.FIELD_WIDTH)) {
			this.x = x;
			updateUI();
		}
	}

	public synchronized void setY(int y) {
		if ((y >= 0) && (y < ConstructorModel.FIELD_HEIGHT)) {
			this.y = y;
			updateUI();
		}
	}

	private void updateUI() {
		update(null, null);
	}

	public void update(Observable o, Object arg) {
		panelF.fillField(getX(), getY());
		panelF.repaint();
		panelC.fillField(getX(), getY());
		panelC.repaint();
		panelCastles.repaint();
	}

}
