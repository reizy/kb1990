package kb.globalmap.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.border.LineBorder;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.FieldType;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.view.swing.ColorResolver;
import ru.reizy.kb1990.view.swing.KBPanel;
import ru.reizy.kb1990.view.swing.KBResources;

public class MapFieldPanel extends KBPanel {
	private static final long serialVersionUID = -8423167031246947361L;

	private static final int MAP_ZOOM = (int) (6 / KBResources.ZOOM);

	public static final Dimension CELL_DIMENSION = new Dimension(MAP_ZOOM, MAP_ZOOM);

	public static final int FIELD_WIDTH = 64;
	public static final int FIELD_HEIGHT = FIELD_WIDTH;

	private static final long MAP_ANIMATION_SPEED = 20;
	private static final int MAP_ANIMATION_COUNT = 4;
	private static final Color[] ANIMATION = { Color.GRAY, Color.WHITE, Color.GREEN, Color.RED, Color.YELLOW };

	private final Dimension FIELD_DIMENSION;
	private Image fieldImg;
	private Image playerImg;

	private KBModel model;
	private MapView view;

	private boolean masked = true;

	public MapFieldPanel(KBModel model, MapView view) {
		super(6, 4);
		this.model = model;
		this.view = view;
		setBorder(new LineBorder(Color.YELLOW));

		FIELD_DIMENSION = new Dimension( //
				(CELL_DIMENSION.width) * FIELD_WIDTH, // width
				(CELL_DIMENSION.height) * FIELD_HEIGHT); // height

		fieldImg = new BufferedImage(FIELD_DIMENSION.width, FIELD_DIMENSION.height, BufferedImage.TYPE_3BYTE_BGR);
		playerImg = new BufferedImage(FIELD_DIMENSION.width, FIELD_DIMENSION.height, BufferedImage.TYPE_4BYTE_ABGR);
		fillField();
		drawPlayer(0);

		new Thread(new Runnable() {

			public void run() {
				try {
					int animation = 0;
					while (true) {
						repaint(1000);
						Thread.sleep(MAP_ANIMATION_SPEED);
						animation = animation % MAP_ANIMATION_COUNT;
						drawPlayer(animation);
						animation++;

					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Map animation").start()/**/;

	}

	void fillField() {
		GlobalMap map = this.model.getGlobalMap();
		GlobalPlayer player = this.model.getGlobalPlayer();
		synchronized (view) {
			Graphics g = fieldImg.getGraphics();
			for (int i = 0; i < FIELD_WIDTH; i++) {
				for (int j = 0; j < FIELD_HEIGHT; j++) {
					int x = i * CELL_DIMENSION.width;
					int y = (FIELD_HEIGHT - j - 1) * CELL_DIMENSION.height;
					FieldType f = null;
					if (player.getUnhidden()[i][j] || (!isMasked())) {
						f = map.getFieldType(i, j);
					}

					// отрисовка за границей карты
					if (f == null) {
						g.clearRect(x, y, CELL_DIMENSION.width, CELL_DIMENSION.height);
					} else { // отрисовка элемента карты
						g.setColor(ColorResolver.getMinimapFieldColor(f));
						g.fillRect(x, y, CELL_DIMENSION.width, CELL_DIMENSION.height);
					}
				}
			}
		}
	}

	void drawPlayer(int a) {
		synchronized (view) {
			Graphics g = playerImg.getGraphics();
			((Graphics2D) g).setBackground(new Color(0, 0, 0, 0));
			g.clearRect(0, 0, FIELD_DIMENSION.width, FIELD_DIMENSION.height);

			Cell cell = model.getGlobalPlayer().getCell();
			if (cell != null) {
				int x = cell.getX() * CELL_DIMENSION.width;
				int y = (FIELD_HEIGHT - cell.getY() - 1) * CELL_DIMENSION.height;
				g.setColor(ANIMATION[a]);
				g.fillRect(x, y, CELL_DIMENSION.width, CELL_DIMENSION.height);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		synchronized (view) {
			paintZoomed(fieldImg, g);
			paintZoomed(playerImg, g);
		}
	}

	public boolean isMasked() {
		return masked;
	}

	public void setMasked(boolean masked) {
		this.masked = masked;
	}

}
