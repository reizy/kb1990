package ru.reizy.kb1990.view.swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class KBResources {

	private static final float INNER_ZOOM = 1.f;
	public static final float ZOOM = 3.f / INNER_ZOOM;
	public static final int ANIMATION_SPEED = 100;
	public static final int UNIT_ANIMATION_COUNT = 4;
	public static final int GLOBAL_ANIMATION_COUNT = 3;
	public static final FontZooms FONT_ZOOMS = FontZooms.get((int) (11.7 * INNER_ZOOM));
	public static final Font FONT = new Font("Courier New", Font.BOLD, FONT_ZOOMS.size);
	private static final Dimension IMG_DIMENSION = new Dimension(48, 34);
	public static final Dimension CELL_DIMENSION = new Dimension((int) (IMG_DIMENSION.width * INNER_ZOOM), (int) (IMG_DIMENSION.height * INNER_ZOOM));
	public static final int FIELD_WIDTH = 6;
	public static final int FIELD_HEIGHT = 5;

	public static final Image TEXTURES;
	public static final Image PLAYER_TEXTURES;
	public static final Image SHIP_TEXTURES;
	public static final Image INTERAVCTIVE_TEXTURES;
	public static final Image BATTLE_MARK;
	public static final Image BATTLE_MASK_M;
	public static final Image BATTLE_MASK_A;
	public static final Image BATTLE_ATACK;
	public static final Image BATTLE_ATACK_HALF;
	public static final Image BATTLE_CASTLE;
	public static final Image BATTLE_BG_BUSH;
	public static final Image BATTLE_BG_POOL;
	public static final Image BATTLE_BG_WALL;
	public static final Image BATTLE_BG_HILL;
	public static final Image BATTLE_BG_GRASS;
	public static final Image[] UNITS_L = new Image[UNIT_ANIMATION_COUNT];
	public static final Image[] UNITS_R = new Image[UNIT_ANIMATION_COUNT];
	public static final Image TEXTURES_PLAINS;
	public static final Image TEXTURES_CASTLE;
	public static final Image TEXTURES_DUNGEONS;
	public static final Image TEXTURES_HILLS;
	public static final Image TEXTURES_FORESTS;
	public static final Image TEXTURES_TOWN;
	public static final Image TEXTURES_CHAR;

	public static final Image GLOBAL_CONTROLS;
	private static final int MONEY_TYPE_COUNT = 3;
	public static final Image[] MONEY = new Image[MONEY_TYPE_COUNT];
	public static final Image[] VILLAINS = new Image[UNIT_ANIMATION_COUNT];

	static {
		BATTLE_CASTLE = loadImgT("/resources/background/castle.png");
		BATTLE_BG_BUSH = loadImgT("/resources/background/bush.png");
		BATTLE_BG_POOL = loadImgT("/resources/background/pool.png");
		BATTLE_BG_WALL = loadImgT("/resources/background/wall.png");
		BATTLE_BG_HILL = loadImgT("/resources/background/hill.png");
		BATTLE_BG_GRASS = loadImgT("/resources/background/grass.png");
		BATTLE_MARK = loadImgT("/resources/unit/mark.png");
		BATTLE_MASK_M = loadImgT("/resources/background/mask.png");
		BATTLE_MASK_A = loadImgT("/resources/background/maskA.png");
		BATTLE_ATACK = loadImgT("/resources/background/atack.png");
		BATTLE_ATACK_HALF = loadImgT("/resources/background/atackHalf.png");
		for (int j = 0; j < UNITS_L.length; j++) {
			UNITS_L[j] = loadImgT("/resources/unit/kbx_" + (j + 1) + "_L.png");
			UNITS_R[j] = loadImgT("/resources/unit/kbx_" + (j + 1) + "_R.png");
		}
		TEXTURES = loadImg("/resources/global/textures.png");
		INTERAVCTIVE_TEXTURES = loadImg("/resources/global/interactive.png");
		PLAYER_TEXTURES = loadImgT("/resources/global/player.png");
		SHIP_TEXTURES = loadImgT("/resources/global/ship.png");
		TEXTURES_PLAINS = loadImg("/resources/residence/plains.png");
		TEXTURES_DUNGEONS = loadImg("/resources/residence/dungeons.png");
		TEXTURES_FORESTS = loadImg("/resources/residence/forests.png");
		TEXTURES_HILLS = loadImg("/resources/residence/hills.png");
		TEXTURES_CASTLE = loadImg("/resources/residence/castle.png");
		TEXTURES_TOWN = loadImg("/resources/residence/town.png");
		TEXTURES_CHAR = loadImg("/resources/character/background.png");
		GLOBAL_CONTROLS = loadImg("/resources/global/controls.png");
		for (int j = 0; j < MONEY_TYPE_COUNT; j++) {
			MONEY[j] = loadImgT("/resources/global/money_" + (j + 1) + ".png");
		}
		for (int j = 0; j < UNIT_ANIMATION_COUNT; j++) {
			VILLAINS[j] = loadImgT("/resources/global/villains_" + (j + 1) + ".png");
		}

//		String[] c = { "l", "r" };
//		for (int k = 1; k < 5; k++) {
//			for (int m = 0; m < 2; m++) {
//				Image TMP = loadImgT("/resources/unit/transparent/kbx_" + k + "_" + c[m] + ".png");
//				for (int i = 0; i < 5; i++) {
//					for (int j = 0; j < 5; j++) {
//						try {
//							BufferedImage image = new BufferedImage(CELL_DIMENSION.width * 2, CELL_DIMENSION.height * 2, BufferedImage.TYPE_4BYTE_ABGR);
//							int x = i * CELL_DIMENSION.width * 2;
//							int y = j * CELL_DIMENSION.height * 2;
//							image.getGraphics().drawImage(TMP, 0, //
//									0,//
//									CELL_DIMENSION.width * 2, //
//									CELL_DIMENSION.height * 2, //
//									x, y, x + CELL_DIMENSION.width * 2, y + CELL_DIMENSION.height * 2, //
//									null);
//
//							int n = 1 + i + j * 5;
//							if (m == 1) {
//								n = 5 - i + j * 5;
//							}
//							File outputfile = new File("unit_" + c[m] + "_" + n + "_" + k + ".png");
//							ImageIO.write(image, "png", outputfile);
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//
//				}
//			}
//		}
	}

	private static Image zoomImage(Image image) {
		int widthS = image.getWidth(null);
		int heightS = image.getHeight(null);

		int widthD = (int) (widthS * CELL_DIMENSION.width / IMG_DIMENSION.width);
		int heightD = (int) (heightS * CELL_DIMENSION.height / IMG_DIMENSION.height);
		int imageType = BufferedImage.TYPE_4BYTE_ABGR;
		BufferedImage i = new BufferedImage(widthD, heightD, imageType);
		Graphics g = i.getGraphics();
		g.drawImage(image, //
				0, 0, widthD, heightD, //
				0, 0, widthS, heightS, //
				null);
		return i;
	}

	// for transpanent immages
	private static Image loadImgT(String path) {
		String sRes = path;
		URL resource = Object.class.getResource(sRes);
		ImageIcon ii = new ImageIcon(resource);
		return zoomImage(ii.getImage());
	}

	private static Image loadImg(String path) {
		String sRes = path;
		InputStream stream = Object.class.getResourceAsStream(sRes);
		BufferedImage i = null;
		try {
			i = ImageIO.read(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return zoomImage(i);
	}

	public static String countToView(int c) {
		String count = Integer.toString(c);
		if (c > 1000) {
			count = c / 1000 + "K";
		}
		return count;
	}

	public static String tabFormat(String sLeft, int l, String sRight) {
		l -= sLeft.length();
		while (l > sRight.length()) {
			sRight = " " + sRight;
		}
		return sLeft + sRight;
	}
}
