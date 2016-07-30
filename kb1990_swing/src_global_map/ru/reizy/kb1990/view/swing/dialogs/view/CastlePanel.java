package ru.reizy.kb1990.view.swing.dialogs.view;

import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.FONT;
import static ru.reizy.kb1990.view.swing.KBResources.FONT_ZOOMS;
import static ru.reizy.kb1990.view.swing.KBResources.TEXTURES_CASTLE;
import static ru.reizy.kb1990.view.swing.KBResources.UNITS_L;
import static ru.reizy.kb1990.view.swing.KBResources.UNIT_ANIMATION_COUNT;
import static ru.reizy.kb1990.view.swing.KBResources.countToView;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CASTLE_ATTACK_Q;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CASTLE_BAND;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CASTLE_LORD;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CASTLE_NAME;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CASTLE_NEED_SEIGE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CLICK_TO;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.EMPTY;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.GARNISON;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.GP;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.N_A;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.REMOVE;

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
import ru.reizy.kb1990.model.globalmap.events.CastleActionEvent;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.villains.Villain;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.swing.KBPanel;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.VilliansInfo;
import ru.reizy.kb1990.view.swing.dialogs.view.control.CastleControllerPanel;
import ru.reizy.kb1990.view.swing.globalmap.view.GlobalInfoPanel;
import ru.reizy.kb1990.view.swing.prototype.KBControlPanel;
import ru.reizy.kb1990.view.swing.prototype.KBTabPanel;

public class CastlePanel extends KBTabPanel {
	private static final long serialVersionUID = 8929688601276556500L;
	private final CastleSubPanel panel;
	private final GlobalInfoPanel iPanel;
	private final KBControlPanel cPanel;

	public CastlePanel(KBModel model, final KBGlobalViewI gView) {
		setLayout(new BorderLayout());
		JPanel central = new JPanel(new BorderLayout());
		add(central, BorderLayout.WEST);
		panel = new CastleSubPanel(model);
		central.add(panel, BorderLayout.CENTER);
		iPanel = new GlobalInfoPanel(model, gView);
		central.add(iPanel, BorderLayout.EAST);

		cPanel = new CastleControllerPanel(model, this, gView);
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

	public void setGarrison(boolean garrison) {
		panel.garnison = garrison;
	}

	public boolean getGarnison() {
		return panel.garnison;
	}

	@Override
	public void onEvent(KBEvent event) {
		if (event instanceof CastleActionEvent) {
			updateAndActivate();
		}
	}
}

class CastleSubPanel extends KBPanel {
	private static final long serialVersionUID = 7083102530236566099L;

	public static final int FIELD_WIDTH = ru.reizy.kb1990.view.swing.KBResources.FIELD_WIDTH - 1;
	public static final int FIELD_HEIGHT = ru.reizy.kb1990.view.swing.KBResources.FIELD_HEIGHT;

	private static final int FIELD_HEIGHT_M = 2;

	private final Image unit;
	private final Image info;
	private final KBModel model;
	private int animation;
	boolean garnison;
	UnitTypes unitType;

	CastleSubPanel(KBModel model) {
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
		final Castle t = model.getGlobalPlayer().getActiveCastle();
		if (t != null) {
			drawUnit(g, unitType, animation);
		}
	}

	private void updateInfo() {
		final GlobalPlayer p = model.getGlobalPlayer();
		final Player hero = p.getHero();
		final Castle t = p.getActiveCastle();
		if (t != null) {
			String[][] s;
			if (t.getHero() == null) {
				if (garnison) {
					s = getPlayerInfo(hero, t);
				} else {
					s = getCastleInfo(hero, t);
				}
			} else {
				s = getEnemyInfo(p, t);
			}
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

	private String[][] getEnemyInfo(GlobalPlayer player, Castle t) {
		String[][] s = new String[10][3];
		s[0][0] = String.format(CASTLE_NAME, t.getName());
		if (t.getHero() instanceof Villain) {
			s[2][0] = String.format(CASTLE_LORD[0],
					VilliansInfo.get((Villain) t.getHero()).getName());
			s[3][0] = CASTLE_LORD[1];
		} else {
			s[2][0] = CASTLE_BAND[0];
			s[3][0] = CASTLE_BAND[1];
		}
		if (player.hasSeigeWeapon()) {
			s[5][0] = CASTLE_ATTACK_Q;
		} else {
			s[5][0] = CASTLE_NEED_SEIGE[0];
			s[6][0] = CASTLE_NEED_SEIGE[1];
		}
		return s;
	}

	private String[][] getCastleInfo(Player hero, Castle t) {
		String[][] s = new String[10][3];
		s[0][0] = String.format(CASTLE_NAME, t.getName());
		s[0][2] = String.format(GP, countToView(hero.getMoney()));

		String[] ch = { "A", "B", "C", "D", "E" };
		int k = -1;
		for (int i = 0; i < 5; i++) {
			String us = NameResolver.getUnitName(t.getArmy(i));
			us = (us == null) ? EMPTY : us;
			s[i + 2][0] = ch[i] + ") " + us;
			Integer c = t.getArmyCount(i);
			us = (c == null) ? N_A : c.toString();
			s[i + 2][1] = us;
			if (c != null) {
				k = i;
			}
		}
		s[2][2] = REMOVE;
		if (k >= 0) {
			s[3][2] = "(A-" + ch[k] + ")";
		}
		s[5][2] = CLICK_TO;
		s[6][2] = GARNISON;
		return s;
	}

	private String[][] getPlayerInfo(Player hero, Castle t) {
		String[][] s = new String[10][3];
		s[0][0] = String.format(CASTLE_NAME, t.getName());
		s[0][2] = String.format(GP, countToView(hero.getMoney()));

		String[] ch = { "A", "B", "C", "D", "E" };
		int k = -1;
		for (int i = 0; i < 5; i++) {
			String us = NameResolver.getUnitName(hero.getArmy(i));
			us = (us == null) ? EMPTY : us;
			s[i + 2][0] = ch[i] + ") " + us;
			Integer c = hero.getArmyCount(i);

			if (c == null) {
				us = N_A;
			} else {
				c *= hero.getArmy(i).getWeekCost();
				us = c.toString();
			}
			s[i + 2][1] = us;
			if (c != null) {
				k = i;
			}
		}
		s[2][2] = GARNISON;
		if (k >= 0) {
			s[3][2] = "(A-" + ch[k] + ")";
		}
		s[5][2] = CLICK_TO;
		s[6][2] = REMOVE;
		return s;
	}

}
