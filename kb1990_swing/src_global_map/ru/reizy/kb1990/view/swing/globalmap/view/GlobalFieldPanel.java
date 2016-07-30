package ru.reizy.kb1990.view.swing.globalmap.view;

import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.FONT;
import static ru.reizy.kb1990.view.swing.KBResources.FONT_ZOOMS;
import static ru.reizy.kb1990.view.swing.KBResources.GLOBAL_ANIMATION_COUNT;
import static ru.reizy.kb1990.view.swing.KBResources.INTERAVCTIVE_TEXTURES;
import static ru.reizy.kb1990.view.swing.KBResources.PLAYER_TEXTURES;
import static ru.reizy.kb1990.view.swing.KBResources.SHIP_TEXTURES;
import static ru.reizy.kb1990.view.swing.KBResources.TEXTURES;
import static ru.reizy.kb1990.view.swing.KBResources.UNITS_L;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.WEEKEND_BALANCE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.WEEKEND_INFO;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.WEEKEND_LEAVE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.border.LineBorder;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.Content;
import ru.reizy.kb1990.model.globalmap.FieldType;
import ru.reizy.kb1990.model.globalmap.GlobalHero;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.events.WeekEndEvent;
import ru.reizy.kb1990.model.globalmap.magic.Bridge;
import ru.reizy.kb1990.model.globalmap.residence.Bonus;
import ru.reizy.kb1990.view.swing.FieldTypeTexture;
import ru.reizy.kb1990.view.swing.KBPanel;
import ru.reizy.kb1990.view.swing.NameResolver;

public class GlobalFieldPanel extends KBPanel {
	private static final long serialVersionUID = -8423167031246947361L;

	public static final int FIELD_WIDTH = ru.reizy.kb1990.view.swing.KBResources.FIELD_WIDTH - 1;
	public static final int FIELD_HEIGHT = ru.reizy.kb1990.view.swing.KBResources.FIELD_HEIGHT;
	private static final int FIELD_HEIGHT_M = 2;

	private final Image fieldImg;
	private final Image playerImg;
	private final Image info;

	private KBModel model;
	private GlobalView view;

	private boolean leftPlayer = false;
	private boolean leftShip = false;

	private int oldX = 0;

	private int animation;

	private Queue<String[]> infoQuery = new LinkedList<String[]>();
	private boolean infoMode;

	public GlobalFieldPanel(KBModel model, GlobalView view) {
		super(FIELD_WIDTH, FIELD_HEIGHT);
		this.model = model;
		this.view = view;
		setBorder(new LineBorder(Color.YELLOW));
		fieldImg = new BufferedImage(FIELD_DIMENSION.width, FIELD_DIMENSION.height, BufferedImage.TYPE_3BYTE_BGR);
		playerImg = new BufferedImage(CELL_DIMENSION.width, CELL_DIMENSION.height, BufferedImage.TYPE_4BYTE_ABGR);
		Cell cell = model.getGlobalPlayer().getCell();
		info = new BufferedImage(FIELD_DIMENSION.width, CELL_DIMENSION.height * FIELD_HEIGHT_M, BufferedImage.TYPE_4BYTE_ABGR);
		fillField(cell.getX(), cell.getY());
		drawPlayer(0);

		addAnimator(new Runnable() {
			public void run() {
				repaint(1000);
				animation = g_animation % GLOBAL_ANIMATION_COUNT;
			}
		});
	}

	void fillField(int vx, int vy) {
		final GlobalMap map = model.getGlobalMap();
		synchronized (view) {
			if (oldX > vx) {
				leftPlayer = true;
			} else if (oldX < vx) {
				leftPlayer = false;
			}
			oldX = vx;

			Graphics g = fieldImg.getGraphics();
			for (int i = 0; i < FIELD_WIDTH; i++) {
				for (int j = 0; j < FIELD_HEIGHT; j++) {
					int x = i * CELL_DIMENSION.width;
					int y = (FIELD_HEIGHT - j - 1) * CELL_DIMENSION.height;
					FieldType f = map.getFieldType(vx - FIELD_WIDTH / 2 + i, vy - FIELD_HEIGHT / 2 + j);
					// исключение для врагов - они анимируются
					if (f == FieldType.ENEMY) {
						f = FieldType.GRASS;
					}
					// отрисовка за границей карты
					if (f == null) {
						g.clearRect(x, y, CELL_DIMENSION.width, CELL_DIMENSION.height);
					} else { // отрисовка элемента карты
						int fX = FieldTypeTexture.get(f).x;
						int fY = FieldTypeTexture.get(f).y;

						g.drawImage(TEXTURES, x, y, x + CELL_DIMENSION.width, y + CELL_DIMENSION.height, //
								CELL_DIMENSION.width * fX, //
								CELL_DIMENSION.height * fY,//
								CELL_DIMENSION.width * (fX + 1), //
								CELL_DIMENSION.height * (fY + 1), //
								null);

					}
					Cell cell = map.getCell(vx - FIELD_WIDTH / 2 + i, vy - FIELD_HEIGHT / 2 + j);
					if (cell != null) {
						// отрисовка бонуса
						final Content content = cell.getContent();
						if (content instanceof Bonus) {
							drawBonus(g, content, x, y);
						}
						if (content instanceof GlobalHero) {
							final GlobalHero gHero = (GlobalHero) content;
							drawHero(g, gHero, x, y);
						}
						if (content instanceof Bridge) {
							int fX = FieldTypeTexture.get(FieldType.SAND_O).x;
							int fY = FieldTypeTexture.get(FieldType.SAND_O).y;
							g.drawImage(TEXTURES, x, y, x + CELL_DIMENSION.width, y + CELL_DIMENSION.height, //
									CELL_DIMENSION.width * fX, //
									CELL_DIMENSION.height * fY,//
									CELL_DIMENSION.width * (fX + 1), //
									CELL_DIMENSION.height * (fY + 1), //
									null);
						}
						// отрисовка неактивного корабля
						if ((model.getGlobalPlayer().getShip().getCell() == cell) && (!model.getGlobalPlayer().inShip())//
						) {
							int fX = leftShip ? 1 : 0;
							g.drawImage(SHIP_TEXTURES, x, y, //
									x + CELL_DIMENSION.width, //
									y + CELL_DIMENSION.height, //
									CELL_DIMENSION.width * fX, //
									CELL_DIMENSION.height * 0,//
									CELL_DIMENSION.width * (fX + 1), //
									CELL_DIMENSION.height * 1, //
									null);
						}
					}
				}
			}
		}
	}

	private void drawBonus(Graphics g, Content с, int x, int y) {
		Point p = ActiveTexture.get(с);
		int xx = p.x;
		int yy = p.y;
		g.drawImage(INTERAVCTIVE_TEXTURES, x, y, //
				x + CELL_DIMENSION.width, //
				y + CELL_DIMENSION.height, //
				CELL_DIMENSION.width * xx, //
				CELL_DIMENSION.height * yy,//
				CELL_DIMENSION.width * (xx + 1), //
				CELL_DIMENSION.height * (yy + 1), //
				null);
	}

	private void drawHero(Graphics g, GlobalHero gHero, int x, int y) {
		if (gHero.getHero().getRank() > 0) {
			drawBonus(g, gHero, x, y);
		} else {
			drawUnit(g, gHero.getHero().getArmy(0), x, y);
		}
	}

	private void drawUnit(Graphics g, UnitType unit, int x, int y) {
		drawUnit(g, UnitTypes.get(unit), x, y);
	}

	private void drawUnit(Graphics g, UnitTypes unit, int x, int y) {
		synchronized (view) {
			Graphics2D g2d = (Graphics2D) g;
			int unitId = unit.getUnitType().getId() - 1;
			int unitIdX = unitId % 5;
			int unitIdY = unitId / 5;
			g2d.drawImage(UNITS_L[animation], x, y, x + CELL_DIMENSION.width, y + CELL_DIMENSION.height, CELL_DIMENSION.width * unitIdX, CELL_DIMENSION.height
					* unitIdY, CELL_DIMENSION.width * (unitIdX + 1), CELL_DIMENSION.height * (unitIdY + 1), null);
		}
	}

	void drawPlayer(int fY) {
		synchronized (view) {
			Graphics g = playerImg.getGraphics();
			((Graphics2D) g).setBackground(new Color(0, 0, 0, 0));
			g.clearRect(0, 0, CELL_DIMENSION.width, CELL_DIMENSION.height);

			int fX = leftPlayer ? 1 : 0;

			fX += model.getGlobalPlayer().isFlying() ? 2 : 0;
			Image textures = PLAYER_TEXTURES;
			if (model.getGlobalPlayer().inShip()) {
				leftShip = leftPlayer;
				textures = SHIP_TEXTURES;
			}
			g.drawImage(textures, 0, 0, //
					CELL_DIMENSION.width,//
					CELL_DIMENSION.height, //
					CELL_DIMENSION.width * fX, //
					CELL_DIMENSION.height * fY,//
					CELL_DIMENSION.width * (fX + 1), //
					CELL_DIMENSION.height * (fY + 1), //
					null);
		}
	}

	public boolean updateInfo() {
		String[] s = infoQuery.poll();
		Graphics2D g = (Graphics2D) info.getGraphics();
		infoMode = (s != null);
		if (infoMode) {
			g.setColor(new Color(255, 255, 85));
			g.fillRect(0, 0, CELL_DIMENSION.width * FIELD_WIDTH, CELL_DIMENSION.height * FIELD_HEIGHT_M);
			int dx = 3;
			int dy = 2;
			g.setColor(new Color(0, 0, 170));
			g.fillRect(dx, dy, CELL_DIMENSION.width * FIELD_WIDTH - dx * 2, CELL_DIMENSION.height * FIELD_HEIGHT_M - dy * 2);
			g.setColor(Color.WHITE);
			g.setFont(FONT);

			int h = FONT_ZOOMS.heigth;
			dx += FONT_ZOOMS.widht;

			for (int i = 0; i < s.length; i++) {
				if (s[i] != null) {
					g.drawString(s[i], dx, dy + h * (i + 1));
				}
			}
		} else {
			g.setBackground(new Color(0, 0, 0, 0));
			g.clearRect(0, 0, info.getWidth(null), info.getHeight(null));
		}
		return (infoMode);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		synchronized (view) {
			paintZoomed(fieldImg, g);
			paintZoomed(playerImg, g, CELL_DIMENSION.width * (FIELD_WIDTH / 2), CELL_DIMENSION.height * (FIELD_HEIGHT / 2));
			paintZoomed(info, g, 0, CELL_DIMENSION.height * (FIELD_HEIGHT - FIELD_HEIGHT_M));
		}
		Cell cell = model.getGlobalPlayer().getCell();
		fillField(cell.getX(), cell.getY());
		drawPlayer(animation);
	}

	@Override
	public void onEvent(KBEvent event) {
		if (event instanceof WeekEndEvent) {
			WeekEndEvent weekEndEvent = (WeekEndEvent) event;
			onWeekEndEvent(weekEndEvent);
		}
	}

	private void onWeekEndEvent(WeekEndEvent e) {
		String s1 = String.format(WEEKEND_INFO, e.getWeekNum(),//
				NameResolver.getUnitName(e.getUnit()));

		final String[] a = { "", "", "", "", "" };
		final String[] p = { "", "", "", "", "" };
		for (int i = 0; i < e.getUnits().size(); i++) {
			a[i] = NameResolver.getUnitName(e.getUnits().get(i));
			final Integer c = e.getUnitsCost().get(i);
			p[i] = (c > 0) ? c.toString() : WEEKEND_LEAVE;
		}

		String s2 = String.format(WEEKEND_BALANCE, e.getWeekNum(),//
				e.getMoneyBefore(), e.getCommision(), e.getBoatRent(), e.getArmyCost(), e.getMoneyAfter(),//
				a[0], a[1], a[2], a[3], a[4],//
				p[0], p[1], p[2], p[3], p[4]//

				);
		showMessage(s1.split("\n"), s2.split("\n"));
	}

	public void showMessage(String[]... s) {
		infoQuery.addAll(Arrays.asList(s));
		updateInfo();
	}

	public boolean isInfoMode() {
		return infoMode;
	}
}
