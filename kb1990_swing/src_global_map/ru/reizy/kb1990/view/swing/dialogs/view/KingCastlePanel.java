package ru.reizy.kb1990.view.swing.dialogs.view;

import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.FONT;
import static ru.reizy.kb1990.view.swing.KBResources.FONT_ZOOMS;
import static ru.reizy.kb1990.view.swing.KBResources.TEXTURES_CASTLE;
import static ru.reizy.kb1990.view.swing.KBResources.UNITS_L;
import static ru.reizy.kb1990.view.swing.KBResources.UNIT_ANIMATION_COUNT;
import static ru.reizy.kb1990.view.swing.KBResources.countToView;
import static ru.reizy.kb1990.view.swing.KBResources.tabFormat;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CASTLE_NAME;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.EMPTY;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.GP;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.N_A;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_BUY;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NO_LEADERSHIP;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NO_MONEY;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NO_SLOTS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.RESIDENCE_NO_UNITS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.events.BuyUnitEvent;
import ru.reizy.kb1990.model.globalmap.events.CastleInEvent;
import ru.reizy.kb1990.model.globalmap.events.KingCastleInEvent;
import ru.reizy.kb1990.model.globalmap.events.ResidenceInEvent;
import ru.reizy.kb1990.model.globalmap.residence.KingCastle;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence.BuyStatus;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.swing.KBPanel;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.dialogs.view.control.KingCastleControllerPanel;
import ru.reizy.kb1990.view.swing.globalmap.view.GlobalInfoPanel;
import ru.reizy.kb1990.view.swing.prototype.KBControlPanel;
import ru.reizy.kb1990.view.swing.prototype.KBTabPanel;

public class KingCastlePanel extends KBTabPanel {
	private static final long serialVersionUID = 8929688601276556500L;
	private final KingCastleSubPanel panel;
	private final GlobalInfoPanel iPanel;
	private final KBControlPanel cPanel;
	private final KBGlobalViewI gView;

	public KingCastlePanel(KBModel model, final KBGlobalViewI gView) {
		this.gView = gView;
		setLayout(new BorderLayout());
		JPanel central = new JPanel(new BorderLayout());
		add(central, BorderLayout.WEST);
		panel = new KingCastleSubPanel(model);
		central.add(panel, BorderLayout.CENTER);
		iPanel = new GlobalInfoPanel(model, gView);
		central.add(iPanel, BorderLayout.EAST);
		cPanel = new KingCastleControllerPanel(model, this, gView);
		add(cPanel, BorderLayout.CENTER);

	}

	@Override
	public void update() {
		panel.update();
		iPanel.update();
		cPanel.update();
		repaint();
	}

	public void setUnit(UnitTypes unit) {
		panel.unitType = unit;
	}

	private void update(BuyUnitEvent event) {
		BuyStatus status = event.getStatus();
		String unitName = NameResolver.getUnitName(event.getResidence()
				.getUnit());
		if (status != null) {
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

	private void showMessage(String s) {
		gView.showMessage(s);
	}

	@Override
	public void onEvent(KBEvent event) {
		if (event instanceof CastleInEvent) {
			// nothing
		} else if (event instanceof KingCastleInEvent) {
			setUnit(UnitsResidenceType.CASTLE.getRandom());
			update();

		} else if (event instanceof ResidenceInEvent) {
			// nothing
		} else if (event instanceof BuyUnitEvent) {
			BuyUnitEvent e = (BuyUnitEvent) event;
			if (e.getResidence() instanceof KingCastle) {
				update(((BuyUnitEvent) event));
			}
		}
	}
}

class KingCastleSubPanel extends KBPanel {
	private static final long serialVersionUID = 7083102530236566099L;

	public static final int FIELD_WIDTH = ru.reizy.kb1990.view.swing.KBResources.FIELD_WIDTH - 1;
	public static final int FIELD_HEIGHT = ru.reizy.kb1990.view.swing.KBResources.FIELD_HEIGHT;

	private static final int FIELD_HEIGHT_M = 2;

	private final Image unit;
	private final Image info;
	private final KBModel model;
	private int animation;
	UnitTypes unitType;

	KingCastleSubPanel(KBModel model) {
		super(FIELD_WIDTH, FIELD_HEIGHT);
		setLayout(new BorderLayout());
		this.model = model;

		unit = new BufferedImage(CELL_DIMENSION.width, CELL_DIMENSION.height,
				BufferedImage.TYPE_4BYTE_ABGR);
		info = new BufferedImage(CELL_DIMENSION.width * FIELD_WIDTH,
				CELL_DIMENSION.height * FIELD_HEIGHT_M,
				BufferedImage.TYPE_3BYTE_BGR);

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
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintZoomed(TEXTURES_CASTLE, g);
		paintZoomed(unit, g, CELL_DIMENSION.width * 1,
				CELL_DIMENSION.height * 2 - 1);
		paintZoomed(info, g, 0, CELL_DIMENSION.height * 3);
		updateUnit(animation);
	}

	private void drawUnit(Graphics g, UnitTypes unit, int animation) {
		Graphics2D g2d = (Graphics2D) g;
		if (unit == null) {
			return;
		}
		int unitId = unit.getUnitType().getId() - 1;
		int unitIdX = unitId % 5;
		int unitIdY = unitId / 5;
		// clear
		g2d.setBackground(new Color(0, 0, 0, 0));
		g2d.clearRect(0, 0, CELL_DIMENSION.width, CELL_DIMENSION.height);
		// repaint
		g2d.drawImage(UNITS_L[animation], 0, 0, CELL_DIMENSION.width,
				+CELL_DIMENSION.height, CELL_DIMENSION.width * unitIdX,
				CELL_DIMENSION.height * unitIdY, CELL_DIMENSION.width
						* (unitIdX + 1), CELL_DIMENSION.height * (unitIdY + 1),
				null);
	}

	private void updateUnit(int animation) {
		Graphics g = unit.getGraphics();
		final KingCastle t = model.getGlobalPlayer().getActiveKingCastle();
		if (t != null) {
			drawUnit(g, unitType, animation);
		}
	}

	private void updateInfo() {
		final GlobalPlayer p = model.getGlobalPlayer();
		final Player hero = p.getHero();
		final KingCastle t = p.getActiveKingCastle();
		if (t != null) {
			String[][] s = getCastleInfo(hero, t);
			Graphics g = info.getGraphics();
			g.setColor(new Color(255, 255, 85));
			g.fillRect(0, 0, CELL_DIMENSION.width * FIELD_WIDTH,
					CELL_DIMENSION.height * FIELD_HEIGHT_M);
			int dx = 3;
			int dy = 2;
			g.setColor(new Color(0, 0, 170));
			g.fillRect(dx, dy, CELL_DIMENSION.width * FIELD_WIDTH - dx * 2,
					CELL_DIMENSION.height * FIELD_HEIGHT_M - dy * 2);
			g.setColor(Color.WHITE);
			g.setFont(FONT);

			int h = FONT_ZOOMS.heigth;
			dx += FONT_ZOOMS.widht;
			int[] d = { 1, 12, 17 };

			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 10; i++) {
					if (s[i][j] != null) {
						g.drawString(s[i][j], dx * d[j], dy + h * (i + 1));
					}
				}
			}
		}
	}

	private String[][] getCastleInfo(Player hero, KingCastle t) {
		String[][] s = new String[10][3];
		s[0][0] = String.format(CASTLE_NAME, t.getName());
		s[0][2] = String.format(GP, countToView(hero.getMoney()));

		String[] ch = { "A", "B", "C", "D", "E" };
		int k = -1;
		for (int i = 0; i < 5; i++) {
			String us = NameResolver.getUnitName(t.getUnitTypes()[i]);
			String pr = (us == null) ? "(" + N_A + ")" : ""
					+ t.getUnitTypes()[i].getUnitType().getCost();
			us = (us == null) ? EMPTY : us;
			us = ch[i] + ") " + us;
			s[i + 2][0] = tabFormat(us, 20, pr);
		}

		if (k >= 0) {
			s[3][2] = "(A-" + ch[k] + ")";
		}

		return s;
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
		return ll;
	}
}
