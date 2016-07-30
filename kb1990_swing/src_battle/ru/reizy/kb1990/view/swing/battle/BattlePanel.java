package ru.reizy.kb1990.view.swing.battle;

import static ru.reizy.kb1990.model.battle.BattleModel.FIELD_HEIGHT;
import static ru.reizy.kb1990.model.battle.BattleModel.FIELD_WIDTH;
import static ru.reizy.kb1990.view.swing.KBResources.BATTLE_ATACK;
import static ru.reizy.kb1990.view.swing.KBResources.BATTLE_ATACK_HALF;
import static ru.reizy.kb1990.view.swing.KBResources.BATTLE_BG_BUSH;
import static ru.reizy.kb1990.view.swing.KBResources.BATTLE_BG_GRASS;
import static ru.reizy.kb1990.view.swing.KBResources.BATTLE_BG_HILL;
import static ru.reizy.kb1990.view.swing.KBResources.BATTLE_BG_POOL;
import static ru.reizy.kb1990.view.swing.KBResources.BATTLE_BG_WALL;
import static ru.reizy.kb1990.view.swing.KBResources.BATTLE_MARK;
import static ru.reizy.kb1990.view.swing.KBResources.BATTLE_MASK_A;
import static ru.reizy.kb1990.view.swing.KBResources.BATTLE_MASK_M;
import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.FONT;
import static ru.reizy.kb1990.view.swing.KBResources.FONT_ZOOMS;
import static ru.reizy.kb1990.view.swing.KBResources.UNITS_L;
import static ru.reizy.kb1990.view.swing.KBResources.UNIT_ANIMATION_COUNT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.BATTLE_RESULT_BOUNTY;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.BATTLE_RESULT_GLORY;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.BATTLE_RESULT_TITLE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.BATTLE_RESULT_VILLIAN;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.BATTLE_RESULT_VILLIAN_FAIL;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.BATTLE_RESULT_VILLIAN_WIN;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.controller.swing.battle.BattleController;
import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.BattleModel;
import ru.reizy.kb1990.model.battle.base.FieldType;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.ShooterUnit;
import ru.reizy.kb1990.model.battle.base.unit.ShootingMark;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInView;
import ru.reizy.kb1990.model.globalmap.villains.Villain;
import ru.reizy.kb1990.view.swing.KBPanel;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.VilliansInfo;

public class BattlePanel extends KBPanel {
	private static final long serialVersionUID = 8994994357492230422L;
	private static final Logger logger = LoggerFactory
			.getLogger(BattlePanel.class);
	private static final Color countColor = Color.WHITE;

	private final BattleModel model;
	private final Image fieldImg;
	private final Image maskImg;
	private final Image unitImg;
	private final Image infoImg;

	private volatile int animation = 1;

	public BattlePanel(BattleModel model, BattleController controller) {
		this.model = model;
		fieldImg = new BufferedImage(FIELD_DIMENSION.width, FIELD_DIMENSION.height,
				BufferedImage.TYPE_3BYTE_BGR);
		maskImg = new BufferedImage(FIELD_DIMENSION.width, FIELD_DIMENSION.height,
				BufferedImage.TYPE_4BYTE_ABGR);
		unitImg = new BufferedImage(FIELD_DIMENSION.width, FIELD_DIMENSION.height,
				BufferedImage.TYPE_4BYTE_ABGR);
		infoImg = new BufferedImage(FIELD_DIMENSION.width, FIELD_DIMENSION.height,
				BufferedImage.TYPE_4BYTE_ABGR);

		addAnimator(new Runnable() {

			public void run() {
				repaint(1000);
				animation = g_animation % UNIT_ANIMATION_COUNT;
			}
		});

		// initiation imgs
		initiate();

		addMouseListener(controller.getFieldClickListener());
	}

	public void initiate() {
		// initiation imgs
		fillField();
		printMask(maskImg.getGraphics());
		drawArmies(unitImg.getGraphics(), model.getPlayerArmy(),
				model.getEnemyArmy());
	}

	private void fillField() {
		Graphics g = fieldImg.getGraphics();
		if (model.getFieldType(0, 0) == FieldType.WALL) {
			String sRes = "/resources/background/castle.png";
			InputStream stream = getClass().getResourceAsStream(sRes);
			try {
				Image img = ImageIO.read(stream);
				g.drawImage(img, 0, 0, FIELD_DIMENSION.width, FIELD_DIMENSION.height,
						null);
			} catch (IOException e) {
				logger.error("Error", e);
			}
		} else {
			for (int i = 0; i < FIELD_WIDTH; i++) {
				for (int j = 0; j < FIELD_HEIGHT; j++) {
					int x = i * CELL_DIMENSION.width;
					int y = j * CELL_DIMENSION.height;
					Image img;
					switch (model.getFieldType(i, j)) {
					case BUSH:
						img = BATTLE_BG_BUSH;
						break;
					case POOL:
						img = BATTLE_BG_POOL;
						break;
					case WALL:
						img = BATTLE_BG_WALL;
						break;
					case HILL:
						img = BATTLE_BG_HILL;
						break;
					default:
						img = BATTLE_BG_GRASS;
						break;
					}
					g.drawImage(img, x, y, CELL_DIMENSION.width, CELL_DIMENSION.height,
							null);
				}
			}
		}
	}

	@Override
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawActiveUnitAnimation();
		paintZoomed(fieldImg, g);
		paintZoomed(unitImg, g);
		paintZoomed(maskImg, g);
		paintZoomed(infoImg, g);
	}

	private synchronized void drawActiveUnitAnimation() {
		drawUnit(model.getActiveUnit(), getAnimation());
	}

	private synchronized void drawUnit(ShootingMark unit, int animation) {
		drawUnit(unit.getLocation().getContent(), 0);
		Graphics2D g = (Graphics2D) unitImg.getGraphics();
		int x = unit.getLocation().getX() * CELL_DIMENSION.width;
		int y = unit.getLocation().getY() * CELL_DIMENSION.height;

		// clear
		if (unit.getLocation().getContent() == null) {
			g.setBackground(new Color(0, 0, 0, 0));
			g.clearRect(x, y, CELL_DIMENSION.width, CELL_DIMENSION.height);
		}
		// repaint
		g.drawImage(BATTLE_MARK, x, y, x + CELL_DIMENSION.width, y
				+ CELL_DIMENSION.height, 0, CELL_DIMENSION.height * (animation - 1),
				CELL_DIMENSION.width, CELL_DIMENSION.height * (animation), null);

	}

	private synchronized void drawUnit(UnitInView unit, int animation) {
		if (unit == null) {
			return;
		}
		if (unit.getLocation() == null) {
			return;
		}
		if (unit instanceof ShootingMark) {
			drawUnit((ShootingMark) unit, animation);
			return;
		}

		Graphics2D g = (Graphics2D) unitImg.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias!
        RenderingHints.VALUE_ANTIALIAS_ON);
		
		boolean reflection = unit.isEnemy();
		int reflect = 1;
		if (reflection) {
			// reflect grafics
			g.transform(new AffineTransform(0.0, 1.0, 1.0, 0.0, CELL_DIMENSION
					.getWidth(), 0.0));
			g.rotate(Math.toRadians(-90));
			reflect = -1;
		}

		int x = reflect * unit.getLocation().getX() * CELL_DIMENSION.width;
		int y = unit.getLocation().getY() * CELL_DIMENSION.height;

		int unitId = unit.getType().getId() - 1;
		int unitIdX = unitId % 5;
		int unitIdY = unitId / 5;
		// clear
		g.setBackground(new Color(0, 0, 0, 0));
		g.clearRect(x, y, CELL_DIMENSION.width, CELL_DIMENSION.height);
		// repaint
		g.drawImage(UNITS_L[animation], x, y, x + CELL_DIMENSION.width, y
				+ CELL_DIMENSION.height, CELL_DIMENSION.width * unitIdX,
				CELL_DIMENSION.height * unitIdY, CELL_DIMENSION.width * (unitIdX + 1),
				CELL_DIMENSION.height * (unitIdY + 1), null);
		if (reflection) {
			// reflect grafics back
			g.rotate(Math.toRadians(90));
			g.transform(new AffineTransform(0.0, 1.0, 1.0, 0.0, 0.0, -CELL_DIMENSION
					.getWidth()));
			reflect = 1;
		}

		// lifebar
		x = (unit.getLocation().getX()) * CELL_DIMENSION.width;
		y = (unit.getLocation().getY()) * CELL_DIMENSION.height;
		int d = FONT_ZOOMS.heigth;

		g.setColor(Color.GRAY);
		g.fillOval(x, y, d, d);

		Color mColor;
		switch (unit.getMorale()) {
		case 0:
			mColor = new Color(175,0,150);
			break;
		case 1:
			mColor = Color.YELLOW;
			break;
		default:
			mColor = Color.CYAN;
		}
		if (unit.isOutOfControl()) {
			mColor = Color.RED;
		}

		g.setColor(mColor);
		g.fillArc(x + 1, y + 1, d - 2, d - 2, 0, 360 * unit.getСurrentHitPoints()
				/ unit.getType().getMaxHitPoints());
		

		// show unit count
		String count = Integer.toString(unit.getCount());
		if (unit.getCount() > 1000) {
			count = unit.getCount() / 1000 + "K";
		}
		int textWidth = count.length() * FONT_ZOOMS.widht;
		x = (unit.getLocation().getX() + 1) * CELL_DIMENSION.width - textWidth;
		y = (unit.getLocation().getY() + 1) * CELL_DIMENSION.height;
		g.setColor(Color.BLACK);
		int textHeight = FONT_ZOOMS.heigth;
		g.fillRect(x, y - textHeight, textWidth, textHeight);
		g.setColor(countColor);
		g.setFont(FONT);
		g.drawString(count, x, y);

	}

	private void drawArmies(Graphics g, List<? extends UnitInView> list,
			List<? extends UnitInView> list2) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(new Color(0, 0, 0, 0));
		g.clearRect(0, 0, FIELD_DIMENSION.width, FIELD_DIMENSION.height);
		drawArmy(g2d, list, false);
		drawArmy(g2d, list2, true);
	}

	private void drawArmy(Graphics2D g, List<? extends UnitInView> list,
			boolean reflection) {
		if (list == null) {
			return;
		}
		for (UnitInView unit : list) {
			drawUnit(unit, 0);
		}

	}

	private synchronized void printMask(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(new Color(0, 0, 0, 0));
		g.clearRect(0, 0, FIELD_DIMENSION.width, FIELD_DIMENSION.height);
		if (model.getActiveUnit() != null) {
			int[][] mask = model.getMPMask();
			for (int i = 0; i < FIELD_WIDTH; i++) {
				for (int j = 0; j < FIELD_HEIGHT; j++) {
					Image img = null;
					// moving
					if ((mask[i][j] <= model.getActiveUnit().getMP()) && (mask[i][j] > 0)) {
						img = BATTLE_MASK_M;
						// atacking
					} else if ((mask[i][j] == -101)
							&& (model.getActiveUnit().getMP() > 0)) {
						img = BATTLE_MASK_A;
						// shoot atacking
					} else if ((mask[i][j] < -101)
							&& (ShooterUnit.canShoot(model.getActiveUnit(), mask))
							&& (model.getActiveUnit().getMP() > 0)) {
						img = BATTLE_MASK_A;

					}
					if (img != null) {
						int x = i * CELL_DIMENSION.width;
						int y = j * CELL_DIMENSION.height;
						g.drawImage(img, x, y, CELL_DIMENSION.width, CELL_DIMENSION.height,
								null);
					}
				}
			}
		}
	}

	void updateCells(Cell... cells) {
		updateCells(Arrays.asList(cells));
	}

	void updateCells(List<Cell> cells) {
		Graphics g = unitImg.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(new Color(0, 0, 0, 0));
		for (Cell cell : cells) {
			if (cell != null) {
				int x = cell.getX() * CELL_DIMENSION.width;
				int y = cell.getY() * CELL_DIMENSION.height;
				g.clearRect(x, y, CELL_DIMENSION.width, CELL_DIMENSION.height);
				if (cell.getContent() != null) {
					drawUnit(cell.getContent(), 0);
				}
			}
		}
		printMask(maskImg.getGraphics());
		repaint(1000);
	}

	synchronized void showDamage(UnitInView unit, boolean half) {
		Graphics2D g = (Graphics2D) maskImg.getGraphics();
		int x = unit.getLocation().getX() * CELL_DIMENSION.width;
		int y = unit.getLocation().getY() * CELL_DIMENSION.height;
		Image atackType = half ? BATTLE_ATACK_HALF : BATTLE_ATACK;
		g.drawImage(atackType, x, y, CELL_DIMENSION.width, CELL_DIMENSION.height,
				null);
		repaint(1000);
	}

	public int getAnimation() {
		return animation;
	}

	public void resetAnimation(int animation) {
		this.animation = 0;
	}

	public synchronized void showWinInfo(Hero hero) {
		final int h = FONT_ZOOMS.heigth;
		final int dx = FONT_ZOOMS.widht;
		final int dy = 11;
		final int bw = 1;
		String[] s = getWinInfoText(hero);

		final int mh = s.length + 1;

		Graphics g = infoImg.getGraphics();
		g.setColor(new Color(255, 255, 85));
		g.fillRect(0, dy, FIELD_DIMENSION.width, h * mh + bw * 2);
		g.setColor(new Color(0, 0, 170));
		g.fillRect(bw, dy + bw, FIELD_DIMENSION.width - bw * 2, h * mh);

		g.setColor(Color.WHITE);
		g.setFont(FONT);
		for (int i = 0; i < s.length; i++) {
			if (s[i] != null) {
				g.drawString(s[i], dx + bw, dy + bw + h * (i + 1));
			}
		}

	}

	private String[] getWinInfoText(Hero hero) {
		String[] s = new String[14];
		Player p = model.getPlayer().getHero();
		final String name = p.getName();
		final String profession = NameResolver.getProfession(p.getType(),
				p.getRank());

		s[0] = BATTLE_RESULT_TITLE;
		s[1] = "";
		s[2] = String.format(BATTLE_RESULT_GLORY[0], name, profession);
		s[3] = BATTLE_RESULT_GLORY[1];
		s[4] = BATTLE_RESULT_GLORY[2];
		s[5] = "";
		s[6] = String.format(BATTLE_RESULT_BOUNTY, hero.getMoney());
		if (hero instanceof Villain) {
			Villain villain = (Villain) hero;
			final VilliansInfo _v = VilliansInfo.get(villain);
			s[6] += BATTLE_RESULT_VILLIAN[0];
			s[7] = String.format(BATTLE_RESULT_VILLIAN[1],
					((_v != null) ? _v.getName() : ""));
			s[8] = "";
			if (p.getContract() == villain) {
				s[9] = BATTLE_RESULT_VILLIAN_WIN[0];
				s[10] = String.format(BATTLE_RESULT_VILLIAN_WIN[1],
						((_v != null) ? villain.getBounty() : ""));
				s[11] = BATTLE_RESULT_VILLIAN_WIN[2];
				s[12] = BATTLE_RESULT_VILLIAN_WIN[3];
			} else {
				s[9] = BATTLE_RESULT_VILLIAN_FAIL[0];
				s[10] = BATTLE_RESULT_VILLIAN_FAIL[1];
				s[11] = BATTLE_RESULT_VILLIAN_FAIL[2];
			}
		}
		return s;
	}

	public synchronized void deactivateInfo() {
		Graphics2D g = (Graphics2D) infoImg.getGraphics();
		g.setBackground(new Color(0, 0, 0, 0));
		g.clearRect(0, 0, FIELD_DIMENSION.width, FIELD_DIMENSION.height);
	}

}
