package kb.constructor.view.globalmap;

import static kb.constructor.view.ConstructorView.ZOOM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import kb.constructor.view.ConstructorView;
import ru.reizy.kb1990.model.constructor.ConstructorModel;
import ru.reizy.kb1990.model.globalmap.FieldType;
import ru.reizy.kb1990.view.swing.FieldTypeTexture;

public class ConstructorFieldPanel extends JPanel {
	private static final long serialVersionUID = -8423167031246947361L;

	public static final Dimension IMG_DIMENSION = new Dimension(48, 34);
	public static final Dimension CELL_DIMENSION = new Dimension(
			(int) (IMG_DIMENSION.width * ZOOM),
			(int) (IMG_DIMENSION.height * ZOOM));
	static final Image TEXTURES;

	static {
		String sRes = "/resources/global/textures.png";
		InputStream stream = ConstructorFieldPanel.class
				.getResourceAsStream(sRes);
		BufferedImage i = null;
		try {
			i = ImageIO.read(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		TEXTURES = i;
	}

	public static final int FIELD_WIDTH = 18; //18
	public static final int FIELD_HEIGHT = 14; //12

	private final Dimension FIELD_DIMENSION;
	private BufferedImage fieldImg;

	private ConstructorModel model;
	private ConstructorView view;

	public ConstructorFieldPanel(ConstructorModel model, ConstructorView view) {
		this.model = model;
		this.view = view;
		setBorder(new LineBorder(Color.YELLOW));

		FIELD_DIMENSION = new Dimension( //
				(CELL_DIMENSION.width) * FIELD_WIDTH, // width
				(CELL_DIMENSION.height) * FIELD_HEIGHT); // height
		Dimension d = new Dimension( //
				(CELL_DIMENSION.width) * FIELD_WIDTH, // width
				(CELL_DIMENSION.height) * FIELD_HEIGHT); // height
		setSize(d);
		setPreferredSize(d);
		fieldImg = new BufferedImage(FIELD_DIMENSION.width,
				FIELD_DIMENSION.height, BufferedImage.TYPE_3BYTE_BGR);
		fillField(view.getX(), view.getY());
	}

	public void fillField(int vx, int vy) {
		synchronized (view) {
			Graphics g = fieldImg.getGraphics();
			for (int i = 0; i < FIELD_WIDTH; i++) {
				for (int j = 0; j < FIELD_HEIGHT; j++) {
					int x = i * CELL_DIMENSION.width;
					int y = (FIELD_HEIGHT - j - 1) * CELL_DIMENSION.height;
					FieldType f = model.getFieldType(vx - FIELD_WIDTH / 2 + i,
							vy - FIELD_HEIGHT / 2 + j);
					if (f == null) {
						g.clearRect(x, y, CELL_DIMENSION.width,
								CELL_DIMENSION.height);
					} else {
						int fX = FieldTypeTexture.get(f).x;
						int fY = FieldTypeTexture.get(f).y;

						g.drawImage(TEXTURES, x, y, x + CELL_DIMENSION.width, y
								+ CELL_DIMENSION.height, //
								IMG_DIMENSION.width * fX, //
								IMG_DIMENSION.height * fY,//
								IMG_DIMENSION.width * (fX + 1), //
								IMG_DIMENSION.height * (fY + 1), //
								null);

					}

				}
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		synchronized (view) {
			g.drawImage(fieldImg, 0, 0, null);
			int x = (FIELD_WIDTH / 2) * CELL_DIMENSION.width;
			int y = (FIELD_HEIGHT / 2 - 1) * CELL_DIMENSION.height;
			g.setColor(Color.RED);
			g.drawRect(x, y, CELL_DIMENSION.width, CELL_DIMENSION.height);
		}
	}
}
