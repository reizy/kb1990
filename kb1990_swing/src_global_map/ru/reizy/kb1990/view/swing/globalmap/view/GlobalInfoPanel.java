package ru.reizy.kb1990.view.swing.globalmap.view;

import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.FIELD_HEIGHT;
import static ru.reizy.kb1990.view.swing.KBResources.GLOBAL_CONTROLS;
import static ru.reizy.kb1990.view.swing.KBResources.MONEY;
import static ru.reizy.kb1990.view.swing.KBResources.UNIT_ANIMATION_COUNT;
import static ru.reizy.kb1990.view.swing.KBResources.VILLAINS;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;
import ru.reizy.kb1990.model.globalmap.villains.Villain;
import ru.reizy.kb1990.view.swing.ColorResolver;
import ru.reizy.kb1990.view.swing.KBPanel;

public class GlobalInfoPanel extends KBPanel {
	private static final int MONEY_COIN = 14;
	private static final int MONEY_VALUE_1 = MONEY_COIN * MONEY_COIN;
	private static final int MONEY_VALUE_2 = MONEY_VALUE_1 * MONEY_COIN;
	private static final int MONEY_VALUE_3 = MONEY_VALUE_2 * MONEY_COIN;
	private static final int MONEY_VALUE_MAX = MONEY_VALUE_3 * MONEY_COIN - 1;
	private static final int ANIMATION_PAUSE_MODIFICATOR = 5;
	private static final long serialVersionUID = -7538709813296905350L;
	private static final int FIELD_WIDTH = 1;
	private final Image info;
	private int animation;
	private final KBModel model;

	public GlobalInfoPanel(KBModel model, KBViewInterface gView) {
		super(FIELD_WIDTH, FIELD_HEIGHT);
		this.model = model;
		info = new BufferedImage(CELL_DIMENSION.width, CELL_DIMENSION.height
				* FIELD_HEIGHT, BufferedImage.TYPE_3BYTE_BGR);

		addAnimator(new Runnable() {
			public void run() {
				animation = (g_animation / ANIMATION_PAUSE_MODIFICATOR)
						% UNIT_ANIMATION_COUNT;
				updateInfo();
				repaint(1000);
			}
		});
		update();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintZoomed(info, g);
	}

	public void update() {
		updateInfoFull();
		repaint(1000);
	}

	private synchronized void updateInfo() {
		Graphics2D g = (Graphics2D) info.getGraphics();
		updateAnimation(g, animation);
	}

	private synchronized void updateInfoFull() {
		Graphics2D g = (Graphics2D) info.getGraphics();
		updateContract(g, UNIT_ANIMATION_COUNT);
		updateSeigeWeapon(g, UNIT_ANIMATION_COUNT);
		updateMagic(g, UNIT_ANIMATION_COUNT);
		updatePasleMap(g);
		updateMoney(g);
		updateAnimation(g, animation);
	}

	private void updateAnimation(Graphics2D g, int a) {
		final Villain contract = model.getGlobalPlayer().getContract();
		if ((contract != null)
				&& (model.getGlobalPlayer().getHero().getAliveVillains()
						.contains(contract))) {
			updateContract(g, a);
		}
		if (model.getGlobalPlayer().hasSeigeWeapon()) {
			updateSeigeWeapon(g, a);
		}
		if (model.getGlobalPlayer().getHero().isMagicActive()) {
			updateMagic(g, a);
		}
	}

	private static void updateMagic(Graphics2D g, int a) {
		drawFromSource(g, 1, a, 2);
	}

	private static void updateSeigeWeapon(Graphics2D g, int a) {
		drawFromSource(g, 2, a, 1);
	}

	private void updateContract(Graphics2D g, int a) {
		final Villain contract = model.getGlobalPlayer().getContract();
		if (a == UNIT_ANIMATION_COUNT) {
			drawFromSource(g, 0, 0, 0);
		} else {
			int sx = contract.getPasleX();
			int sy = contract.getPasleY();
			g.drawImage(VILLAINS[a], 0, 0, CELL_DIMENSION.width,
					CELL_DIMENSION.height, CELL_DIMENSION.width * sx,
					CELL_DIMENSION.height * sy,
					CELL_DIMENSION.width * (sx + 1), CELL_DIMENSION.height
							* (sy + 1), null);
		}
	}

	private void updateMoney(Graphics2D g) {
		int dy = 4;
		drawFromSource(g, 0, 3, dy);
		// 4 - 8 - 6 - 8 - 6 - 8 - 7
		int w = CELL_DIMENSION.width;
		int h = CELL_DIMENSION.height;
		int[] hx = { w * 11 / 16, w * 13 / 32, w * 2 / 16 };
		int hy = h * 27 / 34;
		int hd = h * 2 / 34;
		int m = model.getGlobalPlayer().getHero().getMoney();
		m = Math.min(m, MONEY_VALUE_MAX);
		int[] dm = { m / MONEY_VALUE_1, m / MONEY_VALUE_2, m / MONEY_VALUE_3 };
		for (int k = 0; k < 3; k++) {
			int mm = dm[k] % MONEY_COIN;
			for (int i = 0; i < mm; i++) {
				g.drawImage(MONEY[k], hx[k], CELL_DIMENSION.height * dy + hy
						- hd * i, null);
			}
		}
	}

	private void updatePasleMap(Graphics2D g) {
		final boolean[][] p = model.getGlobalPlayer().getHero().getPasleMask();
		final int b = 1;
		final int vb = 2;
		final int hb = 2;
		final int w = CELL_DIMENSION.width / p.length;
		final int h = CELL_DIMENSION.height / p[0].length;
		final int dy = 3;
		drawFromSource(g, 0, 1, dy);
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[0].length; j++) {
				if (!p[i][j]) {
					g.setColor(ColorResolver.C_PASLE_SMOG_2);
					g.fillRect(hb + w * i, vb + CELL_DIMENSION.height * dy + h
							* j, w, h);
					g.setColor(ColorResolver.C_PASLE_SMOG_1);
					g.fillRect(hb + w * i, vb + CELL_DIMENSION.height * dy + h
							* j, w - b, h - b);
				}
			}
		}
	}

	private static void drawFromSource(Graphics2D g, final int sx,
			final int sy, final int dy) {
		g.drawImage(GLOBAL_CONTROLS, 0, CELL_DIMENSION.height * dy,
				CELL_DIMENSION.width, CELL_DIMENSION.height * (dy + 1),
				CELL_DIMENSION.width * sx, CELL_DIMENSION.height * sy,
				CELL_DIMENSION.width * (sx + 1), CELL_DIMENSION.height
						* (sy + 1), null);
	}

	@Override
	public void onEvent(KBEvent event) {
		// TODO Auto-generated method stub

	}

}
