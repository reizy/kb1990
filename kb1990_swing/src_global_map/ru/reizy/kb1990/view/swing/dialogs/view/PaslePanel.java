package ru.reizy.kb1990.view.swing.dialogs.view;

import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.TEXTURES;
import static ru.reizy.kb1990.view.swing.KBResources.UNIT_ANIMATION_COUNT;
import static ru.reizy.kb1990.view.swing.KBResources.VILLAINS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.FieldType;
import ru.reizy.kb1990.model.globalmap.events.TreasureActivateEvent;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence.BuyStatus;
import ru.reizy.kb1990.model.globalmap.treasure.ArtifactTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.Treasure;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.defaults.DefaultMouseListener;
import ru.reizy.kb1990.view.swing.FieldTypeTexture;
import ru.reizy.kb1990.view.swing.KBPanel;
import ru.reizy.kb1990.view.swing.globalmap.view.GlobalInfoPanel;
import ru.reizy.kb1990.view.swing.prototype.KBTabPanel;

public class PaslePanel extends KBTabPanel {
	private static final long serialVersionUID = 8929688601276556500L;
	private final PasleSubPanel panel;
	private final GlobalInfoPanel iPanel;

	// private final KBControlPanel cPanel;
	// private final KBGlobalViewI gView;

	public PaslePanel(KBModel model, final KBGlobalViewI gView) {
		setLayout(new BorderLayout());
		// this.gView = gView;
		JPanel central = new JPanel(new BorderLayout());
		add(central, BorderLayout.WEST);
		panel = new PasleSubPanel(model);
		central.add(panel, BorderLayout.CENTER);
		iPanel = new GlobalInfoPanel(model, gView);
		central.add(iPanel, BorderLayout.EAST);

		panel.addMouseListener(new DefaultMouseListener() {
			@Override
			public void mouseClicked(MouseEvent event) {
				gView.toGlobalMap();
			}
		});

		// cPanel = new ResidenceControllerPanel(model, this, gView);
		// add(cPanel, BorderLayout.CENTER);
	}

	public void update(BuyStatus status) {
		activatePanel();
		panel.update();
		iPanel.update();
		// cPanel.update();
	}

	@Override
	public void onEvent(KBEvent event) {
		if (event instanceof TreasureActivateEvent) {
			TreasureActivateEvent e = (TreasureActivateEvent) event;
			Treasure bonus = e.getTreasure();
			if (bonus instanceof ArtifactTreasure) {
				update();
			}
		}
	}
}

class PasleSubPanel extends KBPanel {
	private static final long serialVersionUID = 7083102530236566099L;

	public static final int FIELD_WIDTH = ru.reizy.kb1990.view.swing.KBResources.FIELD_WIDTH - 1;
	public static final int FIELD_HEIGHT = ru.reizy.kb1990.view.swing.KBResources.FIELD_HEIGHT;

	private final Image pasle;
	private final Image background;
	private final KBModel model;
	private int animation;

	PasleSubPanel(KBModel model) {
		super(FIELD_WIDTH, FIELD_HEIGHT);
		setLayout(new BorderLayout());
		this.model = model;

		pasle = new BufferedImage(CELL_DIMENSION.width * FIELD_WIDTH,
				CELL_DIMENSION.height * FIELD_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
		background = new BufferedImage(CELL_DIMENSION.width * FIELD_WIDTH,
				CELL_DIMENSION.height * FIELD_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);

		updateBackground();

		addAnimator(new Runnable() {
			public void run() {
				repaint(1000);
				animation = g_animation % UNIT_ANIMATION_COUNT;
			}
		});

	}

	public void update() {
		updatePalse(animation);
		repaint(1000);
	}

	private void updateBackground() {
		final Cell pasleAimCell = model.getGlobalPlayer().getPasleAimCell();
		int vx = pasleAimCell.getX();
		int vy = pasleAimCell.getY();

		Graphics g = background.getGraphics();
		for (int i = 0; i < FIELD_WIDTH; i++) {
			for (int j = 0; j < FIELD_HEIGHT; j++) {
				int x = i * CELL_DIMENSION.width;
				int y = (FIELD_HEIGHT - j - 1) * CELL_DIMENSION.height;
				FieldType f = pasleAimCell.getMap().getFieldType(
						vx - FIELD_WIDTH / 2 + i, vy - FIELD_HEIGHT / 2 + j);
				// отрисовка элемента карты
				if (f != null) {
					int fX = FieldTypeTexture.get(f).x;
					int fY = FieldTypeTexture.get(f).y;
					g.drawImage(TEXTURES, x, y, x + CELL_DIMENSION.width, y
							+ CELL_DIMENSION.height, //
							CELL_DIMENSION.width * fX, //
							CELL_DIMENSION.height * fY,//
							CELL_DIMENSION.width * (fX + 1), //
							CELL_DIMENSION.height * (fY + 1), //
							null);
				}
			}
		}
	}

	private void updatePalse(int animation) {
		Graphics g = pasle.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		boolean[][] p = model.getGlobalPlayer().getHero().getPasleMask();
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {

				int sX1 = CELL_DIMENSION.width * i;
				int sY1 = CELL_DIMENSION.height * j;
				int sX2 = CELL_DIMENSION.width * (i + 1);
				int sY2 = CELL_DIMENSION.height * (j + 1);

				// clear
				g2d.setBackground(new Color(0, 0, 0, 0));
				g2d.clearRect(sX1, sY1, sX2, sY2);
				if (!p[i][j]) {
					// repaint
					g2d.drawImage(VILLAINS[animation], //
							sX1, sY1, sX2, sY2, //
							sX1, sY1, sX2, sY2, null);

				}
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintZoomed(background, g);
		paintZoomed(pasle, g);
		updatePalse(animation);
	}

}
