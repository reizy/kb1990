package ru.reizy.kb1990.view.swing.dialogs.view;

import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.FONT;
import static ru.reizy.kb1990.view.swing.KBResources.FONT_ZOOMS;
import static ru.reizy.kb1990.view.swing.KBResources.TEXTURES_TOWN;
import static ru.reizy.kb1990.view.swing.KBResources.UNITS_L;
import static ru.reizy.kb1990.view.swing.KBResources.UNIT_ANIMATION_COUNT;
import static ru.reizy.kb1990.view.swing.KBResources.countToView;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TOWN_BOAT_CANCEL;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TOWN_BOAT_RENT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TOWN_CASTLE_INFO;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TOWN_CONTRACT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TOWN_GP;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TOWN_MAGIC;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TOWN_NAME;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TOWN_SEIGE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TOWN_SEIGE_HAD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.events.TownActionEvent;
import ru.reizy.kb1990.model.globalmap.residence.Town;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.swing.KBPanel;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.dialogs.view.control.TownControllerPanel;
import ru.reizy.kb1990.view.swing.globalmap.view.GlobalInfoPanel;
import ru.reizy.kb1990.view.swing.prototype.KBControlPanel;
import ru.reizy.kb1990.view.swing.prototype.KBTabPanel;

public class TownPanel extends KBTabPanel {
	private static final long serialVersionUID = 8929688601276556500L;
	private final TownSubPanel panel;
	private final GlobalInfoPanel iPanel;
	private final KBControlPanel cPanel;

	public TownPanel(KBModel model, final KBGlobalViewI gView) {
		setLayout(new BorderLayout());
		JPanel central = new JPanel(new BorderLayout());
		add(central, BorderLayout.WEST);
		panel = new TownSubPanel(model);
		central.add(panel, BorderLayout.CENTER);
		iPanel = new GlobalInfoPanel(model, gView);
		central.add(iPanel, BorderLayout.EAST);

		cPanel = new TownControllerPanel(model, this, gView);
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

	@Override
	public void onEvent(KBEvent event) {
		if (event instanceof TownActionEvent) {
			update();
		}
	}
}

class TownSubPanel extends KBPanel {
	private static final long serialVersionUID = 7083102530236566099L;

	public static final int FIELD_WIDTH = ru.reizy.kb1990.view.swing.KBResources.FIELD_WIDTH - 1;
	public static final int FIELD_HEIGHT = ru.reizy.kb1990.view.swing.KBResources.FIELD_HEIGHT;

	private final Image unit;
	private final Image info;
	private final KBModel model;
	private int animation;
	UnitTypes unitType;

	TownSubPanel(KBModel model) {
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
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintZoomed(TEXTURES_TOWN, g);
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
				+CELL_DIMENSION.height, CELL_DIMENSION.width * unitIdX,
				CELL_DIMENSION.height * unitIdY, CELL_DIMENSION.width
						* (unitIdX + 1), CELL_DIMENSION.height * (unitIdY + 1),
				null);
	}

	private void updateUnit(int animation) {
		Graphics g = unit.getGraphics();
		final Town t = model.getGlobalPlayer().getActiveTown();
		if (t != null) {
			drawUnit(g, unitType, animation);
		}
	}

	private void updateInfo() {
		final GlobalPlayer p = model.getGlobalPlayer();
		final Player hero = p.getHero();
		final Town t = p.getActiveTown();
		if (t != null) {
			String[] s = new String[10];
			s[0] = String.format(TOWN_NAME, t.getName());
			s[1] = String.format(TOWN_GP, countToView(hero.getMoney()));

			s[2] = TOWN_CONTRACT;
			s[3] = TOWN_BOAT_CANCEL;
			if (p.getShip().getCell() == null) {
				s[3] = String.format(TOWN_BOAT_RENT, hero.getBoatRent());
			}

			s[4] = TOWN_CASTLE_INFO;
			s[5] = String.format(TOWN_MAGIC, NameResolver.getMagicName(t
					.getSpell()), t.getSpell().getCost());
			s[6] = TOWN_SEIGE;
			if (p.hasSeigeWeapon()) {
				s[6] = TOWN_SEIGE_HAD;
			}

			Graphics g = info.getGraphics();
			g.setColor(new Color(0, 0, 170));
			g.fillRect(0, 0, CELL_DIMENSION.width * 5,
					CELL_DIMENSION.height * 2);
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
	}
}
