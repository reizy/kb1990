package ru.reizy.kb1990.view.swing.dialogs.view;

import static ru.reizy.kb1990.view.swing.KBResources.BATTLE_BG_GRASS;
import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.FONT;
import static ru.reizy.kb1990.view.swing.KBResources.FONT_ZOOMS;
import static ru.reizy.kb1990.view.swing.KBResources.UNITS_L;
import static ru.reizy.kb1990.view.swing.KBResources.UNIT_ANIMATION_COUNT;
import static ru.reizy.kb1990.view.swing.KBResources.countToView;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.COST;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.DAMAGE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.HIT_PTS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.MORALE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.MV;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.OUT_OF_CONTROL;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.SL;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.UnitsResidenceType;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.view.swing.ColorResolver;
import ru.reizy.kb1990.view.swing.KBPanel;
import ru.reizy.kb1990.view.swing.NameResolver;

public class ArmyPanel extends KBPanel {
	private static final long serialVersionUID = -6552295833824648767L;
	private final GlobalPlayer player;
	private final Image info;

	private int animation;

	public ArmyPanel(GlobalPlayer player) {
		super();
		this.player = player;
		info = new BufferedImage(FIELD_DIMENSION.width, FIELD_DIMENSION.height,
				BufferedImage.TYPE_4BYTE_ABGR);
		update();

		addAnimator(new Runnable() {
			public void run() {
				repaint(1000);
				animation = g_animation % UNIT_ANIMATION_COUNT;
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintZoomed(info, g);
		update();
	}

	public void update() {
		updateInfo();
		repaint();
	}

	private void updateInfo() {
		Graphics2D g = (Graphics2D) info.getGraphics();

		for (int i = 0; i < Player.ARMY_MAX_SIZE; i++) {
			UnitType type = null;
			int count = 0;
			int morale = 0;
			final Player p = player.getHero();
			if (i < p.getArmy().size()) {
				type = p.getArmy().get(i);
				count = p.getArmyCount().get(i);
				morale = p.getMorale(i);
				if (p.isOutOfControl(i)) {
					morale = -1;
				}
			}
			drawUnit(g, type, i, animation);
			drawUnitInfo(g, type, count, i, morale);
		}
	}

	private void drawUnit(Graphics2D g, UnitType unit, int i, int animation) {
		int x = 0;
		int y = i * CELL_DIMENSION.height + 1;
		// repaint
		g.drawImage(BATTLE_BG_GRASS, x, y, null);

		if (unit != null) {
			int unitId = unit.getId() - 1;
			int unitIdX = unitId % 5;
			int unitIdY = unitId / 5;
			g.drawImage(UNITS_L[animation], x, y, x + CELL_DIMENSION.width, y
					+ CELL_DIMENSION.height, CELL_DIMENSION.width * unitIdX,
					CELL_DIMENSION.height * unitIdY, CELL_DIMENSION.width
							* (unitIdX + 1), CELL_DIMENSION.height
							* (unitIdY + 1), null);
		}
	}

	private void drawUnitInfo(Graphics2D g, UnitType unit, int count, int i,
			int morale) {
		int x = CELL_DIMENSION.width;
		int y = i * CELL_DIMENSION.height;
		int h = FONT_ZOOMS.heigth + 1;
		int w1 = FONT_ZOOMS.widht;
		int w2 = w1 * 5;
		int w3 = w1 * 7;
		int w4 = w1 * 16;
		int bw = 1;

		g.setColor(new Color(255, 170, 85));
		g.fillRect(x, y, FIELD_DIMENSION.width - x, CELL_DIMENSION.height);
		g.setColor(ColorResolver.getResidenceColor(UnitsResidenceType.get(unit)));
		g.fillRect(x, y + bw, FIELD_DIMENSION.width - x, CELL_DIMENSION.height
				- bw);

		// show unit info
		if (unit != null) {
			g.setColor(Color.WHITE);
			g.setFont(FONT);
			String s;
			// строка 1
			s = countToView(count);
			g.drawString(s, x + w1, y + h * 1);

			s = NameResolver.getUnitName(unit);
			g.drawString(s, x + w2, y + h * 1);

			s = String.format(HIT_PTS,
					countToView(count * unit.getMaxHitPoints()));
			g.drawString(s, x + w4, y + h * 1);

			// строка 2
			s = String.format(SL, unit.getSkill());
			g.drawString(s, x + w1, y + h * 2);

			s = String.format(MV, unit.getMaxMovePoints());
			g.drawString(s, x + w3, y + h * 2);

			s = String.format(DAMAGE,//
					countToView(count * unit.getMinDamage()),//
					countToView(count * unit.getMaxDamage()));
			g.drawString(s, x + w4, y + h * 2);

			// строка 3
			if (morale >= 0) {
				s = String.format(MORALE, NameResolver.getMorale(morale));
			} else {
				s = OUT_OF_CONTROL;
			}
			g.drawString(s, x + w1, y + h * 3);

			s = String.format(COST, count * unit.getWeekCost());
			g.drawString(s, x + w4, y + h * 3);
		}
	}

}
