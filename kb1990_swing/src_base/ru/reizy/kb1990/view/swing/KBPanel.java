package ru.reizy.kb1990.view.swing;

import static ru.reizy.kb1990.view.swing.KBResources.ANIMATION_SPEED;
import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.FIELD_HEIGHT;
import static ru.reizy.kb1990.view.swing.KBResources.FIELD_WIDTH;
import static ru.reizy.kb1990.view.swing.KBResources.ZOOM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import javax.swing.border.LineBorder;

import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.view.swing.prototype.KBGlobalViewPanel;
import ru.reizy.kb1990.view.swing.prototype.KBTabPanel;

public abstract class KBPanel extends KBGlobalViewPanel {

	private static final long serialVersionUID = 2455860697249766845L;
	public static final int JPANEL_BORDERS = 0;
	protected KBTabPanel tab;

	public final Dimension FIELD_DIMENSION;

	protected static short g_animation = 0;
	private static final List<Runnable> animators = new LinkedList<Runnable>();
	static {
		new Thread(new Runnable() {
			public void run() {
				try {
					while (true) {
						for (g_animation = 0; g_animation >= 0; g_animation++) {
							Thread.sleep(ANIMATION_SPEED);
							synchronized (KBPanel.class) {
								// TODO optimize sync
								for (Runnable a : animators) {
									a.run();
								}
							}
						}

					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Animation").start()/**/;
	}

	protected static synchronized void addAnimator(Runnable r) {
		animators.add(r);
	}

	public KBPanel() {
		this(FIELD_WIDTH, FIELD_HEIGHT);
	}

	public KBPanel(int w, int h) {
		setBorder(new LineBorder(Color.YELLOW));
		FIELD_DIMENSION = new Dimension( //
				(int) ((CELL_DIMENSION.width) * w), // width
				(int) ((CELL_DIMENSION.height) * h)); // height
		Dimension d = new Dimension( //
				(int) (FIELD_DIMENSION.width * ZOOM) - JPANEL_BORDERS, // width
				(int) (FIELD_DIMENSION.height * ZOOM) - JPANEL_BORDERS); // height
		setSize(d);
		setMinimumSize(d);
		setPreferredSize(d);
	}

	public static void paintZoomed(Image img, Graphics g) {
		int sx1 = 0;
		int sy1 = 0;
		int sx2 = img.getWidth(null);
		int sy2 = img.getHeight(null);
		int dx1 = 0;
		int dy1 = 0;
		int dx2 = sx2;
		int dy2 = sy2;
		paintZoomed(img, g, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2);
	}

	public static void paintZoomed(Image img, Graphics g, int dx1, int dy1) {
		int sx1 = 0;
		int sy1 = 0;
		int sx2 = img.getWidth(null);
		int sy2 = img.getHeight(null);
		int dx2 = dx1 + sx2;
		int dy2 = dy1 + sy2;
		paintZoomed(img, g, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2);
	}

	public static void paintZoomed(Image img, Graphics g, int dx1, int dy1,
			int dx2, int dy2, int sx1, int sy1, int sx2, int sy2) {
		dx1 *= ZOOM;
		dy1 *= ZOOM;
		dx2 *= ZOOM;
		dy2 *= ZOOM;
		g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
	}

	public void setTab(KBTabPanel tab) {
		this.tab = tab;
	}

	@Override
	public void onEvent(KBEvent event) {
		// TODO Auto-generated method stub

	}
}
