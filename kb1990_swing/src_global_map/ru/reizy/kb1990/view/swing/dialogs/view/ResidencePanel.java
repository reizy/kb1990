package ru.reizy.kb1990.view.swing.dialogs.view;

import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.FONT;
import static ru.reizy.kb1990.view.swing.KBResources.FONT_ZOOMS;
import static ru.reizy.kb1990.view.swing.KBResources.TEXTURES_CASTLE;
import static ru.reizy.kb1990.view.swing.KBResources.TEXTURES_DUNGEONS;
import static ru.reizy.kb1990.view.swing.KBResources.TEXTURES_FORESTS;
import static ru.reizy.kb1990.view.swing.KBResources.TEXTURES_HILLS;
import static ru.reizy.kb1990.view.swing.KBResources.TEXTURES_PLAINS;
import static ru.reizy.kb1990.view.swing.KBResources.UNITS_L;
import static ru.reizy.kb1990.view.swing.KBResources.UNIT_ANIMATION_COUNT;
import static ru.reizy.kb1990.view.swing.KBResources.countToView;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_AVAIBLE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_BUY;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_COUNT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_LINE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NAME;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NO_LEADERSHIP;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NO_MONEY;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NO_SLOTS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NO_UNITS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_PRICE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_Q;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.events.BuyUnitEvent;
import ru.reizy.kb1990.model.globalmap.events.ResidenceInEvent;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence.BuyStatus;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.swing.KBPanel;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.dialogs.view.control.ResidenceControllerPanel;
import ru.reizy.kb1990.view.swing.globalmap.view.GlobalInfoPanel;
import ru.reizy.kb1990.view.swing.prototype.KBControlPanel;
import ru.reizy.kb1990.view.swing.prototype.KBTabPanel;

public class ResidencePanel extends KBTabPanel {
	private static final long serialVersionUID = 8929688601276556500L;
	private final ResidenceSubPanel panel;
	private final GlobalInfoPanel iPanel;
	private final KBControlPanel cPanel;
	private final KBGlobalViewI gView;
	private final KBModel model;

	public ResidencePanel(KBModel model, final KBGlobalViewI gView) {
		setLayout(new BorderLayout());
		this.gView = gView;
		this.model = model;
		JPanel central = new JPanel(new BorderLayout());
		add(central, BorderLayout.WEST);
		panel = new ResidenceSubPanel(model);
		central.add(panel, BorderLayout.CENTER);
		iPanel = new GlobalInfoPanel(model, gView);
		central.add(iPanel, BorderLayout.EAST);

		cPanel = new ResidenceControllerPanel(model, this, gView);
		add(cPanel, BorderLayout.CENTER);
	}

	public void update(BuyUnitEvent event) {
		final BuyStatus status = event.getStatus();
		if (status != null) {
			SimpleUnitResidence residence = model.getGlobalPlayer()
					.getActiveResidence();
			String unitName = NameResolver.getUnitName(residence.getUnit());
			switch (status) {
			case NO_UNITS:
				showMessage(RESIDENCE_NO_UNITS);
				break;
			case NO_MONEY:
				showMessage(RESIDENCE_NO_MONEY);
				break;
			case NO_LEADERSHIP:
				showMessage(RESIDENCE_NO_LEADERSHIP);
				break;
			case NO_SLOTS:
				showMessage(String.format(RESIDENCE_NO_SLOTS, unitName));
				break;
			default:
				showMessage(String.format(RESIDENCE_BUY, unitName,
						event.getCount()));
			}
		}
		activatePanel();
		panel.update();
		cPanel.update();
	}

	public Integer getAvaibleCount() {
		return panel.getAvaibleCount();
	}

	private void showMessage(String s) {
		gView.showMessage(s);
	}

	@Override
	public void onEvent(KBEvent event) {
		if (event instanceof ResidenceInEvent) {
			activatePanel();
			panel.update();
			cPanel.update();
		} else if (event instanceof BuyUnitEvent) {
			BuyUnitEvent e = (BuyUnitEvent) event;
			if (e.getResidence() instanceof SimpleUnitResidence) {
				update(e);
			}
		}
	}
}

class ResidenceSubPanel extends KBPanel {
	private static final long serialVersionUID = 7083102530236566099L;

	public static final int FIELD_WIDTH = ru.reizy.kb1990.view.swing.KBResources.FIELD_WIDTH - 1;
	public static final int FIELD_HEIGHT = ru.reizy.kb1990.view.swing.KBResources.FIELD_HEIGHT;

	private final Image unit;
	private final Image info;
	private Image background = TEXTURES_PLAINS;
	private final KBModel model;
	private int animation;

	ResidenceSubPanel(KBModel model) {
		super(FIELD_WIDTH, FIELD_HEIGHT);
		setLayout(new BorderLayout());
		this.model = model;

		unit = new BufferedImage(CELL_DIMENSION.width, CELL_DIMENSION.height,
				BufferedImage.TYPE_4BYTE_ABGR);
		info = new BufferedImage(CELL_DIMENSION.width * 5,
				CELL_DIMENSION.height * 2, BufferedImage.TYPE_3BYTE_BGR);

		addAnimator(new Runnable() {
			public void run() {
				repaint(1000);
				animation = g_animation % UNIT_ANIMATION_COUNT;
			}
		});

	}

	public void update() {
		updateUnit(animation);
		updateInfo();
		updateBack();
		repaint(1000);
	}

	private void updateBack() {
		SimpleUnitResidence residence = model.getGlobalPlayer().getActiveResidence();
		if (residence != null) {
			UnitType type = residence.getUnit().getUnitType();
			UnitsResidenceType tr = UnitsResidenceType.get(type);
			switch (tr) {
			case CASTLE:
				background = TEXTURES_CASTLE;
				break;
			case PLAINS:
				background = TEXTURES_PLAINS;
				break;
			case FOREST:
				background = TEXTURES_FORESTS;
				break;
			case HILLS:
				background = TEXTURES_HILLS;
				break;
			case DUNGEON:
				background = TEXTURES_DUNGEONS;
				break;
			default:
				background = TEXTURES_PLAINS;
				break;
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintZoomed(background, g);
		paintZoomed(unit, g, CELL_DIMENSION.width * 1,
				CELL_DIMENSION.height * 2 - 1);
		paintZoomed(info, g, 0, CELL_DIMENSION.height * 3);
		updateUnit(animation);
	}

	private void drawUnit(Graphics g, UnitTypes unit, int animation) {
		Graphics2D g2d = (Graphics2D) g;
		int unitId = unit.getUnitType().getId() - 1;
		int unitIdX = unitId % 5;
		int unitIdY = unitId / 5;
		// clear
		g2d.setBackground(new Color(0, 0, 0, 0));
		g2d.clearRect(0, 0, CELL_DIMENSION.width, CELL_DIMENSION.height);
		// repaint
		g2d.drawImage(UNITS_L[animation], 0, 0, CELL_DIMENSION.width,
				CELL_DIMENSION.height, CELL_DIMENSION.width * unitIdX,
				CELL_DIMENSION.height * unitIdY, CELL_DIMENSION.width
						* (unitIdX + 1), CELL_DIMENSION.height * (unitIdY + 1),
				null);
	}

	private void updateUnit(int animation) {
		SimpleUnitResidence residence = model.getGlobalPlayer().getActiveResidence();
		if (residence != null) {
			Graphics g = unit.getGraphics();
			drawUnit(g, residence.getUnit(), animation);
		}
	}

	private void updateInfo() {

		SimpleUnitResidence residence = model.getGlobalPlayer().getActiveResidence();
		String[] s = new String[10];
		s[0] = String.format(RESIDENCE_NAME,
				NameResolver.getResidenceName(residence.getType()));
		s[1] = RESIDENCE_LINE;

		s[3] = String.format(RESIDENCE_AVAIBLE,
				residence.getCount().toString(),
				NameResolver.getUnitName(residence.getUnit()));

		s[4] = String.format(RESIDENCE_PRICE, //
				residence.getUnit().getUnitType().getCost(), //
				countToView(model.getGlobalPlayer().getHero().getMoney()));
		int ll = getAvaibleCount();
		s[5] = String.format(RESIDENCE_COUNT, countToView(ll));
		s[6] = RESIDENCE_Q;

		Graphics g = info.getGraphics();
		g.setColor(new Color(0, 0, 170));
		g.fillRect(0, 0, CELL_DIMENSION.width * 5, CELL_DIMENSION.height * 2);
		g.setColor(Color.WHITE);
		g.setFont(FONT);

		int h = FONT_ZOOMS.heigth;
		int dx = FONT_ZOOMS.widht;

		for (int i = 0; i < 10; i++) {
			if (s[i] != null) {
				g.drawString(s[i], dx, h * (i + 1));
			}
		}
	}

	public int getAvaibleCount() {
		SimpleUnitResidence residence = model.getGlobalPlayer().getActiveResidence();
		if (residence == null)
			return 0;
		int mc = model.getGlobalPlayer().getHero().getMoney()
				/ residence.getUnit().getUnitType().getCost();
		int ll = model.getGlobalPlayer().getHero().getLeadership()
				/ residence.getUnit().getUnitType().getLeadership();
		int index = model.getGlobalPlayer().getHero().getArmy()
				.indexOf(residence.getUnit().getUnitType());
		if (index >= 0) {
			ll -= model.getGlobalPlayer().getHero().getArmyCount().get(index);
		}
		ll = Math.min(mc, ll);
		ll = Math.max(ll, 0);
		return ll;
	}

}
