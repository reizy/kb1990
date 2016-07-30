package ru.reizy.kb1990.view.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import kb.globalmap.view.MapView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;
import ru.reizy.kb1990.model.globalmap.events.BattleFailEvent;
import ru.reizy.kb1990.model.globalmap.events.BattleWinEvent;
import ru.reizy.kb1990.model.globalmap.events.BuyUnitEvent;
import ru.reizy.kb1990.model.globalmap.events.CastleInEvent;
import ru.reizy.kb1990.model.globalmap.events.KingCastleInEvent;
import ru.reizy.kb1990.model.globalmap.events.ResidenceInEvent;
import ru.reizy.kb1990.model.globalmap.events.SignPostActivateEvent;
import ru.reizy.kb1990.model.globalmap.events.TownInEvent;
import ru.reizy.kb1990.model.globalmap.residence.KingCastle;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.events.ShowGlobalMapEvent;
import ru.reizy.kb1990.view.swing.dialogs.view.ArmyPanel;
import ru.reizy.kb1990.view.swing.dialogs.view.CastlePanel;
import ru.reizy.kb1990.view.swing.dialogs.view.CharacterPanel;
import ru.reizy.kb1990.view.swing.dialogs.view.ContractPanel;
import ru.reizy.kb1990.view.swing.dialogs.view.KingCastlePanel;
import ru.reizy.kb1990.view.swing.dialogs.view.PaslePanel;
import ru.reizy.kb1990.view.swing.dialogs.view.ResidencePanel;
import ru.reizy.kb1990.view.swing.dialogs.view.TownPanel;
import ru.reizy.kb1990.view.swing.prototype.KBTabPanel;
import ru.reizy.kb1990.view.swing.view.LogPanel;

public class View extends JFrame implements KBGlobalViewI {
	private static final long serialVersionUID = -6627794197637800934L;
	private static final Logger log = LoggerFactory.getLogger(View.class);

	public ContractPanel contractView;

	private MapView mapView;
	private final List<KBTabPanel> panels = new ArrayList<KBTabPanel>();
	private final ResidencePanel residenceView;
	public final TownPanel townView;
	private final CharacterPanel characterPanel;
	private final LogPanel logPanel;
	private final ArmyPanel armyPanel;
	private final CastlePanel castleView;
	private final PaslePanel paslePanel;

	private KingCastlePanel kingCastleView;

	private final JTabbedPane tabs = new JTabbedPane();

	private KBTabPanel next;

	private static View view;
	private KBModel model;

	public static View getInstanse() {
		return view;
	}

	public KBModel getModel() {
		return model;
	}

	private void registerPanels() {

		tryRegisterPanel("ru.reizy.kb1990.view.swing.globalmap.view.GlobalView");
		tryRegisterPanel("ru.reizy.kb1990.view.swing.battle.BattleView");

	}

	private void tryRegisterPanel(String s) {
		try {
			Class.forName(s);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public View(KBModel model) {
		super();
		this.model = model;
		view = this;

		model.addView(this);

		setLayout(new BorderLayout());

		add(tabs);

		logPanel = new LogPanel();
		add(logPanel, BorderLayout.SOUTH);

		registerPanels();

		mapView = new MapView(model, this);
		addTab("Миникарта", mapView);

		residenceView = new ResidencePanel(model, this);
		addTab("Убежище", residenceView);

		townView = new TownPanel(model, this);
		addTab("Город", townView);

		characterPanel = new CharacterPanel(model);
		addTab("Характеристики", characterPanel);

		armyPanel = new ArmyPanel(model.getGlobalPlayer());
		addTab("Армия", armyPanel);

		contractView = new ContractPanel(model, this);
		addTab("Инфо", contractView);

		paslePanel = new PaslePanel(model, this);
		addTab("Пазл", paslePanel);

		castleView = new CastlePanel(model, this);
		addTab("Замок", castleView);

		kingCastleView = new KingCastlePanel(model, this);
		addTab("Королевский замок", kingCastleView);

		/**/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		pack();

	}

	@SuppressWarnings("serial")
	void addTab(String name, final KBPanel view) {
		KBTabPanel tabView = new KBTabPanel() {
			@Override
			public void onEvent(KBEvent event) {
				view.onEvent(event);
			}
		};
		tabView.setLayout(new BorderLayout());
		tabView.add(view, BorderLayout.WEST);
		addTab(name, tabView);
		view.setTab(tabView);
	}

	public void addTab(String name, KBTabPanel tabView) {
		panels.add(tabView);
		final int id = tabs.getTabCount();
		tabView.setMainViewListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabs.setSelectedIndex(id);
			}
		});
		tabs.addTab(name, tabView);

	}

	private void onBattleWin(KBEvent event) {
		showMessage("The battle finished. You win!");// TODO статистику
		mapView.update();
		for (KBTabPanel panel : panels) {
			panel.onEvent(event);
		}
	}

	@Override
	public void toGlobalMap() {
		mapView.update();
		for (KBViewInterface panel : panels) {
			KBEvent event = new ShowGlobalMapEvent();
			panel.onEvent(event);
		}
	}

	public void showMessage(String s) {
		s += "\n---";
		final String[] split = s.split("\n");
		for (String string : split) {
			logPanel.showMessage(string);
		}
	}

	private void onBattleFail(KBEvent event) {
		showMessage("The battle finished. Enemy wins!"); // TODO статистику
		mapView.update();
		for (KBTabPanel panel : panels) {
			panel.onEvent(event);
		}
	}

	private void onTown() {
		townView.setUnit(UnitTypes.getRandom());
		townView.updateAndActivate();
		next = townView;
	}

	private void onCastle() {
		castleView.setUnit(UnitTypes.getRandom());
		castleView.update();
		next = castleView;
		toNext();
	}

	@Override
	public void toNext() {
		if (next == null) {
			next = panels.get(0);
		}
		next.updateAndActivate();
	}

	public void setNext(KBTabPanel panel) {
		next = panel;
	}

	@Override
	public void onEvent(KBEvent event) {
		log.info("onEvent - " + event.getClass().getSimpleName());
		if (event instanceof CastleInEvent) {
			onCastle();
		} else if (event instanceof KingCastleInEvent) {
			kingCastleView.onEvent(event);
			setNext(kingCastleView);
			toNext();
		} else if (event instanceof ResidenceInEvent) {
			setNext(residenceView);
		} else if (event instanceof TownInEvent) {
			onTown();
		} else if (event instanceof BattleWinEvent) {
			onBattleWin(event);
		} else if (event instanceof BattleFailEvent) {
			onBattleFail(event);
		} else if (event instanceof BuyUnitEvent) {
			BuyUnitEvent e = (BuyUnitEvent) event;
			KBTabPanel next;
			if (e.getResidence() instanceof KingCastle) {
				next = kingCastleView;
			} else {
				next = residenceView;
			}
			setNext(next);
			toNext();
		} else if (event instanceof SignPostActivateEvent) {
			showMessage(((SignPostActivateEvent) event).getResidence().getText());
		}
		for (KBTabPanel panel : panels) {
			panel.onEvent(event);
		}
	}

}
