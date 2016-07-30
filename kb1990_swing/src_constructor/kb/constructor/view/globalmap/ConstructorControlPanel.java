package kb.constructor.view.globalmap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import kb.constructor.view.ConstructorView;
import ru.reizy.kb1990.model.constructor.ConstructorModel;
import ru.reizy.kb1990.model.globalmap.FieldType;
import ru.reizy.kb1990.view.swing.FieldTypeTexture;
import ru.reizy.kb1990.view.swing.FontZooms;

public class ConstructorControlPanel extends JPanel {
	private static final long serialVersionUID = -8423167031246947361L;

	public static final Dimension IMG_DIMENSION = new Dimension(48, 34);
	public static final Dimension CELL_DIMENSION = new Dimension(
			(int) (ConstructorFieldPanel.CELL_DIMENSION.width
					* ConstructorFieldPanel.FIELD_WIDTH / 5),
			(int) (ConstructorFieldPanel.CELL_DIMENSION.height
					* ConstructorFieldPanel.FIELD_HEIGHT / 5));

	private static final int FIELD_HEIGHT = 5;

	private static final FontZooms FONT_ZOOMS = FontZooms.get((int) (11));
	private static final Font countFont = new Font("Courier New", Font.BOLD,
			FONT_ZOOMS.size);

	private final Dimension FIELD_DIMENSION;
	private BufferedImage fieldImg;

	private ConstructorModel model;

	public ConstructorControlPanel(ConstructorModel model, ConstructorView view) {
		this.model = model;
		setBorder(new LineBorder(Color.YELLOW));

		FIELD_DIMENSION = new Dimension( //
				(int) (CELL_DIMENSION.width * 1.5f), // width
				(CELL_DIMENSION.height) * FIELD_HEIGHT); // height
		Dimension d = new Dimension( //
				(int) (CELL_DIMENSION.width * 1.5f), // width
				(CELL_DIMENSION.height - 2) * FIELD_HEIGHT); // height
		setSize(d);
		setPreferredSize(d);
		fieldImg = new BufferedImage(FIELD_DIMENSION.width,
				FIELD_DIMENSION.height, BufferedImage.TYPE_3BYTE_BGR);
		fillField(view.getX(), view.getY());
	}

	public void fillField(int vx, int vy) {
		Graphics g = fieldImg.getGraphics();
		// текущая текстура
		FieldType f = model.getActive();
		int fX = FieldTypeTexture.get(f).x;
		int fY = FieldTypeTexture.get(f).y;

		g.drawImage(ConstructorFieldPanel.TEXTURES, 0, 0, //
				CELL_DIMENSION.width, //
				CELL_DIMENSION.height, //
				IMG_DIMENSION.width * fX, //
				IMG_DIMENSION.height * fY,//
				IMG_DIMENSION.width * (fX + 1), //
				IMG_DIMENSION.height * (fY + 1), //
				null);

		// текущие координаты
		g.clearRect(CELL_DIMENSION.width, 0, CELL_DIMENSION.width,
				CELL_DIMENSION.height);
		g.setFont(countFont);
		String s;
		s = (vx < 10) ? " " + vx : "" + vx;
		g.drawString("X:" + s, CELL_DIMENSION.width + FONT_ZOOMS.widht,
				1 * FONT_ZOOMS.size);
		s = (vy < 10) ? " " + vy : "" + vy;
		g.drawString("Y:" + s, CELL_DIMENSION.width + FONT_ZOOMS.widht,
				2 * FONT_ZOOMS.size);

		// карта элементов
		{
			float mmzx = 1.5f;
			float mmzy = 2f;
			g.drawImage(ConstructorFieldPanel.TEXTURES,
					0,
					(int) (CELL_DIMENSION.height), //
					(int) (CELL_DIMENSION.width * mmzx), //
					(int) (CELL_DIMENSION.height + CELL_DIMENSION.height * mmzy), //
					0, 0, //
					IMG_DIMENSION.width * 6, IMG_DIMENSION.height * 6, null);
			g.drawImage(
					ConstructorFieldPanel.TEXTURES,
					0,
					(int) (CELL_DIMENSION.height + CELL_DIMENSION.height * mmzy), //
					(int) (CELL_DIMENSION.width * mmzx), //
					(int) (CELL_DIMENSION.height + 2 * CELL_DIMENSION.height
							* mmzy), //
					IMG_DIMENSION.width * 6, 0, //
					IMG_DIMENSION.width * 12, IMG_DIMENSION.height * 6, null);
			g.setColor(Color.RED);
			float w = (mmzx * CELL_DIMENSION.width / 6);
			float h = (mmzy * CELL_DIMENSION.height / 6);
			if (fX >= 6) {
				fX -= 6;
				fY += 6;
			}
			g.drawRect((int) (fX * w), (int) (CELL_DIMENSION.height + fY * h),
					(int) w - 1, (int) h);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fieldImg, 0, 0, null);
	}
}
