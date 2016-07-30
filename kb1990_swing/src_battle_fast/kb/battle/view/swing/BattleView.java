package kb.battle.view.swing;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import kb.BattleModelI;
import kb.View;
import kb.base.model.Hero;
import kb.battle.controller.BattleController;
import kb.battle.model.BattleModel;
import kb.battle.model.base.BattleViewInterface;
import kb.battle.view.swing.eventactions.BattleWinEventListener;
import kb.battle.view.swing.eventactions.StartBattleEventListener;
import kb.events.KBEvent;
import kb.events.KBEventListener;
import kb.prototype.KBTabPanel;

public class BattleView extends KBTabPanel implements BattleViewInterface {
	private static final long serialVersionUID = -8785953292113429350L;
	private BattleModel model;
	private BattlePanel panel;
	private BattleController controller;

	private View gView;
	private List<KBEventListener> kbEventListeners;

	static {
		final View view = View.getInstanse();
		BattleView battleView = new BattleView(
				view.getModel().getBattleModel(), view);
		view.addTab("Битва", battleView);
	}

	public BattleView(BattleModelI battleModelI, View gView) {
		super();
		this.gView = gView;
		this.model = (BattleModel) battleModelI;
		model.addView(this);

		controller = new BattleController(this.model, this, gView);

		setLayout(new BorderLayout());

		panel = new BattlePanel(this.model, this.controller);
		add(panel);

		JPanel eastPanel = new JPanel(new BorderLayout());
		add(eastPanel, BorderLayout.EAST);

		model.addView(this);

		kbEventListeners = new ArrayList<KBEventListener>();
		kbEventListeners.add(new StartBattleEventListener(this));
		kbEventListeners.add(new BattleWinEventListener(this));
	}

	@Override
	public void info(String s) {
		showMessage(s);
	}

	public void showMessage(String s) {
		gView.showMessage(s);
	}

	@Override
	public void onEvent(KBEvent e) {
		for (KBEventListener listener : kbEventListeners) {
			if (listener.isAplicable(e)) {
				listener.onEvent(e);
				break;
			}
		}
	}

	public void updateField() {
		activatePanel();
	}

	public void showWinInfo(Hero hero) {
		panel.showWinInfo(hero);
		panel.addMouseListener(controller.getInfoClickListener());
	}

	public void deactivateInfo() {
		panel.deactivateInfo();
		panel.removeMouseListener(controller.getInfoClickListener());

	}

	@Override
	public void update() {

	}

}
