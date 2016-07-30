package ru.reizy.kb1990.view.swing.dialogs.view;

import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.FIELD_WIDTH;
import static ru.reizy.kb1990.view.swing.KBResources.FONT;
import static ru.reizy.kb1990.view.swing.KBResources.FONT_ZOOMS;
import static ru.reizy.kb1990.view.swing.KBResources.GLOBAL_CONTROLS;
import static ru.reizy.kb1990.view.swing.KBResources.UNIT_ANIMATION_COUNT;
import static ru.reizy.kb1990.view.swing.KBResources.VILLAINS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.NO_CONTRACT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.VILLAIN_ALIAS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.VILLAIN_CASTLE_NAME;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.VILLAIN_CONTINENT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.VILLAIN_CRIMES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.VILLAIN_FEATURES;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.VILLAIN_NAME;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.VILLAIN_REWARD;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.events.GlobalPlayerMoveEvent;
import ru.reizy.kb1990.model.globalmap.events.ShowContractEvent;
import ru.reizy.kb1990.model.globalmap.events.TownActionEvent;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.villains.Villain;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.swing.KBPanel;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.VilliansInfo;
import ru.reizy.kb1990.view.swing.prototype.ClickListener;

public class ContractPanel extends KBPanel {
	private static final long serialVersionUID = -6824986425537752627L;
	private static final int FIELD_HEIGHT_M = 4;
	private final KBModel model;
	private final Image info;
	private int animation;

	public ContractPanel(KBModel model, final KBGlobalViewI gView) {
		this.model = model;
		info = new BufferedImage(CELL_DIMENSION.width * FIELD_WIDTH, CELL_DIMENSION.height * FIELD_HEIGHT_M, BufferedImage.TYPE_3BYTE_BGR);

		addAnimator(new Runnable() {
			public void run() {
				repaint(1000);
				animation = g_animation % UNIT_ANIMATION_COUNT;
				updateFoto();
			}
		});
		update();
		addMouseListener(new ClickListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gView.toNext();
			}
		});
	}

	public void update() {
		updateInfo();
		updateFoto();
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintZoomed(info, g, 0, CELL_DIMENSION.height / 2);
	}

	private void updateNoContract() {
		Graphics2D g = (Graphics2D) info.getGraphics();

		int dx = FONT_ZOOMS.widht;
		int dy = 6;

		final int x = 0;
		final int y = 0;

		g.drawImage(GLOBAL_CONTROLS, dx, dy, //
				CELL_DIMENSION.width + dx, CELL_DIMENSION.height + dy, //
				CELL_DIMENSION.width * x, CELL_DIMENSION.height * y, //
				CELL_DIMENSION.width * (x + 1), CELL_DIMENSION.height * (y + 1), null);

	}

	private void updateFoto() {
		final Villain v = model.getGlobalPlayer().getContract();
		Graphics2D g = (Graphics2D) info.getGraphics();
		if (v != null) {

			int dx = FONT_ZOOMS.widht;
			int dy = 6;

			final int x = v.getPasleX();
			final int y = v.getPasleY();

			g.drawImage(VILLAINS[animation], dx, dy, //
					CELL_DIMENSION.width + dx, CELL_DIMENSION.height + dy, //
					CELL_DIMENSION.width * x, CELL_DIMENSION.height * y, //
					CELL_DIMENSION.width * (x + 1), CELL_DIMENSION.height * (y + 1), null);
		} else {
			updateNoContract();
		}
	}

	private void updateInfo() {
		final GlobalPlayer p = model.getGlobalPlayer();
		final Villain v = p.getContract();
		final VilliansInfo _v = VilliansInfo.get(v);
		Graphics2D g = (Graphics2D) info.getGraphics();
		g.setColor(new Color(255, 255, 85));
		g.fillRect(0, 0, CELL_DIMENSION.width * FIELD_WIDTH, CELL_DIMENSION.height * FIELD_HEIGHT_M);
		int dx = 3;
		int dy = 2;
		g.setColor(new Color(0, 0, 170));
		g.fillRect(dx, dy, CELL_DIMENSION.width * FIELD_WIDTH - dx * 2, CELL_DIMENSION.height * FIELD_HEIGHT_M - dy * 2);
		g.setColor(Color.WHITE);
		g.setFont(FONT);

		dy += 2;
		int dx1 = CELL_DIMENSION.width + FONT_ZOOMS.widht;
		int dx2 = FONT_ZOOMS.widht;
		int h = FONT_ZOOMS.heigth;

		if (v != null) {
			if (_v != null) {
				int k = 1;

				String[] ss;
				String ms;
				String s;

				s = String.format(VILLAIN_NAME, _v.getName());
				g.drawString(s, dx1, dy + h * (k++));
				s = String.format(VILLAIN_ALIAS, _v.getAlias());
				g.drawString(s, dx1, dy + h * (k++));
				s = String.format(VILLAIN_REWARD, v.getBounty()) + " + " + v.getMoney();
				g.drawString(s, dx1, dy + h * (k++));
				s = String.format(VILLAIN_CONTINENT, NameResolver.getContinentName(v.getContinet()));
				g.drawString(s, dx1, dy + h * (k++));
				final Castle castle = p.getContractersCastle();
				s = String.format(VILLAIN_CASTLE_NAME, NameResolver.getCastleName(castle));
				g.drawString(s, dx1, dy + h * (k++));

				ms = _v.getFeatures();
				ms = String.format(VILLAIN_FEATURES, ms);
				final int LENGTH = 38;
				ss = drawTextByWords(ms, LENGTH, "", "  ");
				for (int i = 0; i < ss.length; i++) {
					if (ss[i] != null) {
						g.drawString(ss[i], dx2, dy + h * (k++));
					}

				}

				k = 10;
				ms = _v.getCrimes();
				ms = String.format(VILLAIN_CRIMES, ms);
				ss = drawTextByWords(ms, LENGTH, "", "  ");
				for (int i = 0; i < ss.length; i++) {
					if (ss[i] != null) {
						g.drawString(ss[i], dx2, dy + h * (k++));
					}

				}
			}
		} else {
			g.drawString(NO_CONTRACT, dx1, dy + h * 7);
		}
	}

	public void updateAndActivate() {
		tab.updateAndActivate();
		update();
	}

	@Override
	public void onEvent(KBEvent event) {
		if (event instanceof ShowContractEvent) {
			updateAndActivate();
		} else if (event instanceof GlobalPlayerMoveEvent) {
			update();
		} else if (event instanceof TownActionEvent) {
			update();
		}
	}
}
