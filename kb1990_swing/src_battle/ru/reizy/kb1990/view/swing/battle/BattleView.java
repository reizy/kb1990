package ru.reizy.kb1990.view.swing.battle;

import static ru.reizy.kb1990.view.swing.KBResources.ANIMATION_SPEED;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import ru.reizy.kb1990.BattleModelI;
import ru.reizy.kb1990.controller.swing.battle.BattleController;
import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.battle.BattleModel;
import ru.reizy.kb1990.model.battle.base.BattleViewInterface;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.swing.View;
import ru.reizy.kb1990.view.swing.battle.eventactions.AtackEventListener;
import ru.reizy.kb1990.view.swing.battle.eventactions.BattleWinEventListener;
import ru.reizy.kb1990.view.swing.battle.eventactions.BetrayalEventListener;
import ru.reizy.kb1990.view.swing.battle.eventactions.FreezedUnitEventListener;
import ru.reizy.kb1990.view.swing.battle.eventactions.InfoEventListener;
import ru.reizy.kb1990.view.swing.battle.eventactions.NextUnitEventListener;
import ru.reizy.kb1990.view.swing.battle.eventactions.StartBattleEventListener;
import ru.reizy.kb1990.view.swing.battle.eventactions.UnitMoveEventListener;
import ru.reizy.kb1990.view.swing.battle.magic.CloneSpellUsedEventListener;
import ru.reizy.kb1990.view.swing.battle.magic.FireballSpellUsedEventListener;
import ru.reizy.kb1990.view.swing.battle.magic.FreezeSpellUsedEventListener;
import ru.reizy.kb1990.view.swing.battle.magic.LightingBoltSpellUsedEventListener;
import ru.reizy.kb1990.view.swing.battle.magic.NewTurnEventListener;
import ru.reizy.kb1990.view.swing.battle.magic.RessurectSpellUsedEventListener;
import ru.reizy.kb1990.view.swing.battle.magic.SpellActivatedEventListener;
import ru.reizy.kb1990.view.swing.battle.magic.SpellResistantEventListener;
import ru.reizy.kb1990.view.swing.battle.magic.TeleportSpellUsedEventListener;
import ru.reizy.kb1990.view.swing.battle.magic.TurnUndeadSpellUsedEventListener;
import ru.reizy.kb1990.view.swing.prototype.KBTabPanel;

public class BattleView extends KBTabPanel implements BattleViewInterface {
	private static final long serialVersionUID = -8785953292113429350L;
	private final BattleModel model;
	private final BattlePanel panel;
	private final BattleController controller;

	private final BattleMagicPanel magicPanel;
	private final BattleControlPanel controlPanel;
	private final KBGlobalViewI gView;
	private final List<KBEventListener> kbEventListeners;

	static {
		final KBGlobalViewI view = View.getInstanse();
		BattleView battleView = new BattleView(view.getModel().getBattleModel(), view);
		view.addTab("Битва", battleView);
	}

	public BattleView(BattleModelI battleModelI, KBGlobalViewI gView) {
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
		magicPanel = new BattleMagicPanel(model);
		controlPanel = new BattleControlPanel(model, controller);
		eastPanel.add(controlPanel, BorderLayout.NORTH);
		eastPanel.add(magicPanel);

		kbEventListeners = new ArrayList<KBEventListener>();
		kbEventListeners.add(new CloneSpellUsedEventListener(this));
		kbEventListeners.add(new FireballSpellUsedEventListener(this));
		kbEventListeners.add(new FreezeSpellUsedEventListener(this));
		kbEventListeners.add(new LightingBoltSpellUsedEventListener(this));
		kbEventListeners.add(new RessurectSpellUsedEventListener(this));
		kbEventListeners.add(new TeleportSpellUsedEventListener(this));
		kbEventListeners.add(new TurnUndeadSpellUsedEventListener(this));
		kbEventListeners.add(new SpellResistantEventListener(this));
		kbEventListeners.add(new SpellActivatedEventListener(this));
		kbEventListeners.add(new NewTurnEventListener(this));
		kbEventListeners.add(new StartBattleEventListener(this));
		kbEventListeners.add(new BattleWinEventListener(this));
		kbEventListeners.add(new UnitMoveEventListener(this));
		kbEventListeners.add(new NextUnitEventListener(this));
		kbEventListeners.add(new AtackEventListener(this));
		kbEventListeners.add(new BetrayalEventListener(this));
		kbEventListeners.add(new InfoEventListener(this));
		kbEventListeners.add(new FreezedUnitEventListener(this));
	}

	public void showMoving(Cell from, Cell to, Boolean animation) {
		if (animation) {
			showMoving(from, to);
		} else {
			panel.updateCells(from, to);
		}
	}

	private void showMoving(Cell from, Cell to) {
		try {
			List<Cell> path = model.getPath(from, to);
			Cell p1 = from;
			model.getActiveUnit().setLocation(p1);
			int t = ANIMATION_SPEED * (5 - panel.getAnimation());
			for (Cell p2 : path) {
				Thread.sleep(t);
				synchronized (panel) {
					model.getActiveUnit().setLocation(p2);
					panel.updateCells(p1, p2);
					p1 = p2;
					t = (ANIMATION_SPEED * 4);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void updatePanels() {
		controlPanel.updateControls();
		magicPanel.updateMagic();
	}

	public void updateCells(Cell... cell) {
		panel.updateCells(cell);
	}

	public void showMessage(String s) {
		gView.showMessage(s);
	}

	@Override
	public void onEvent(KBEvent e) {
		boolean b = false;
		for (KBEventListener listener : kbEventListeners) {
			if (listener.isAplicable(e)) {
				listener.onEvent(e);
				b = true;
				break;
			}
		}
		if (b) {
			magicPanel.updateMagic();
		}
	}

	public void updateField() {
		panel.initiate();
		activatePanel();
	}

	public void init() {
		magicPanel.createButtons();
		updatePanels();
		updateField();
	}
	
	public void showWinInfo(Hero hero) {
		panel.showWinInfo(hero);
		panel.removeMouseListener(controller.getFieldClickListener());
		panel.addMouseListener(controller.getInfoClickListener());
	}

	public void deactivateInfo() {
		panel.deactivateInfo();
		panel.removeMouseListener(controller.getInfoClickListener());
		panel.addMouseListener(controller.getFieldClickListener());

	}

	@Override
	public void update() {
		magicPanel.updateMagic();
	}

	public void showDamage(UnitInModel aim, boolean half) {
		panel.showDamage(aim, half);
	}

}
