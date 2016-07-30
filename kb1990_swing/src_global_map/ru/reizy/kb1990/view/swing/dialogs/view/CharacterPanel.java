package ru.reizy.kb1990.view.swing.dialogs.view;

import static ru.reizy.kb1990.view.swing.KBResources.CELL_DIMENSION;
import static ru.reizy.kb1990.view.swing.KBResources.FONT;
import static ru.reizy.kb1990.view.swing.KBResources.FONT_ZOOMS;
import static ru.reizy.kb1990.view.swing.KBResources.TEXTURES_CHAR;
import static ru.reizy.kb1990.view.swing.KBResources.VILLAINS;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CHARACTER_ARTIFACT_COUNT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CHARACTER_CASTLES_COUNT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CHARACTER_COMMISSION;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CHARACTER_FOLLOWERS_KILLED;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CHARACTER_GOLD;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CHARACTER_LEAD;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CHARACTER_NAME;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CHARACTER_SCORE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CHARACTER_SPELLS_COUNT;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CHARACTER_SPELLS_POWER;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.CHARACTER_VILLIANS_COUNT;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.base.artifact.Artifact;
import ru.reizy.kb1990.model.events.ChangeCharacterEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.view.swing.KBPanel;
import ru.reizy.kb1990.view.swing.NameResolver;

public class CharacterPanel extends KBPanel {
	private static final Logger log = LoggerFactory.getLogger(CharacterPanel.class);
	private static final long serialVersionUID = 1266691898425074470L;

	private final KBModel model;
	private final Image info;
	private final Image artifacts;

	public CharacterPanel(KBModel model) {
		super();
		this.model = model;
		info = new BufferedImage(FIELD_DIMENSION.width, FIELD_DIMENSION.height, BufferedImage.TYPE_4BYTE_ABGR);
		artifacts = new BufferedImage(FIELD_DIMENSION.width, CELL_DIMENSION.height * 2, BufferedImage.TYPE_4BYTE_ABGR);
		update();
	}

	public Player getPlayer() {
		return model.getGlobalPlayer().getHero();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintZoomed(TEXTURES_CHAR, g);
		paintZoomed(info, g);
		paintZoomed(artifacts, g, 0, CELL_DIMENSION.height * 3);
	}

	public void update() {
		log.info("Character panel updated");
		updateInfo();
		updateArtifacts();
		repaint();
	}

	private void updateArtifacts() {
		final int[] artSX = { 0, 0, 4, 2, 2, 4, 0, 4 };
		final int[] artSY = { 4, 2, 4, 0, 4, 0, 0, 2 };
		Graphics g = artifacts.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		Set<Artifact> p = getPlayer().getArtifacts();
		g2d.setBackground(new Color(0, 0, 0, 0));
		g2d.clearRect(0, 0, FIELD_DIMENSION.width, FIELD_DIMENSION.height);
		for (int i = 0; i < Artifact.artifacts.length; i++) {
			int dX1 = CELL_DIMENSION.width * (i % 4);
			int dY1 = CELL_DIMENSION.height * (i / 4);
			int dX2 = dX1 + CELL_DIMENSION.width;
			int dY2 = dY1 + CELL_DIMENSION.height;
			int sX1 = CELL_DIMENSION.width * artSX[i];
			int sY1 = CELL_DIMENSION.height * artSY[i];
			int sX2 = sX1 + CELL_DIMENSION.width;
			int sY2 = sY1 + CELL_DIMENSION.height;

			if (p.contains(Artifact.artifacts[i]))
				g2d.drawImage(VILLAINS[0], //
						dX1, dY1, dX2, dY2, //
						sX1, sY1, sX2, sY2, null);

		}
	}

	private void updateInfo() {
		Player p = getPlayer();
		final String name = p.getName();

		final String profession = NameResolver.getProfession(p.getType(), p.getRank());

		String[] s = new String[11];

		s[0] = String.format(CHARACTER_NAME, name, profession);
		s[1] = String.format(CHARACTER_LEAD, p.getLeadership());
		s[2] = String.format(CHARACTER_COMMISSION, p.getCommission());
		s[3] = String.format(CHARACTER_GOLD, p.getMoney());
		s[4] = String.format(CHARACTER_SPELLS_POWER, p.getSpellPower());
		s[5] = String.format(CHARACTER_SPELLS_COUNT, p.getSpellCapacity());
		s[6] = String.format(CHARACTER_VILLIANS_COUNT, p.getKilledVillains().size());
		s[7] = String.format(CHARACTER_ARTIFACT_COUNT, p.getArtifacts().size());
		s[8] = String.format(CHARACTER_CASTLES_COUNT, 0);
		s[9] = String.format(CHARACTER_FOLLOWERS_KILLED, 0);
		s[10] = String.format(CHARACTER_SCORE, 0);

		final int dy = 1;
		final int dx = CELL_DIMENSION.width * 2;
		final int h = FONT_ZOOMS.heigth;

		Graphics2D g = (Graphics2D) info.getGraphics();
		g.setBackground(new Color(0, 0, 0, 0));
		g.clearRect(0, 0, FIELD_DIMENSION.width, FIELD_DIMENSION.height);

		g.setColor(Color.WHITE);
		g.setFont(FONT);
		for (int i = 0; i < 10; i++) {
			if (s[i] != null) {
				g.drawString(s[i], dx, dy + h * (i + 1) + (i + 1) % 2);
			}
		}
		g.drawString(s[10], dx, dy + h * (11) - 1);

	}

	@Override
	public void onEvent(KBEvent event) {
		if ((event instanceof ChangeCharacterEvent)) {
			update();
		}
	}

}
