package kb.battle.view.swing;

import static kb.KBResources.FONT;
import static kb.KBResources.FONT_ZOOMS;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import kb.KBPanel;
import kb.NameResolver;
import kb.base.model.Hero;
import kb.base.model.Player;
import kb.battle.controller.BattleController;
import kb.battle.model.BattleModel;

public class BattlePanel extends KBPanel {
	private static final long serialVersionUID = 8994994357492230422L;

	private final BattleModel model;
	private final Image fieldImg;
	private final Image infoImg;

	public BattlePanel(BattleModel model, BattleController controller) {
		this.model = model;
		fieldImg = new BufferedImage(FIELD_DIMENSION.width,
				FIELD_DIMENSION.height, BufferedImage.TYPE_3BYTE_BGR);
		infoImg = new BufferedImage(FIELD_DIMENSION.width,
				FIELD_DIMENSION.height, BufferedImage.TYPE_4BYTE_ABGR);
	}

	@Override
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintZoomed(fieldImg, g);
		paintZoomed(infoImg, g);
	}

	public synchronized void showWinInfo(Hero hero) {
		final int h = FONT_ZOOMS.heigth;
		final int dx = FONT_ZOOMS.widht;
		final int dy = 11;
		final int bw = 1;
		final int mh = 12;

		Player p = (Player) model.getPlayer();
		final String name = p.getName();
		final String profession = NameResolver.getProfession(p.getType(),
				p.getRank());

		String[] s = new String[10];

		s[0] = "               Победа!";
		s[1] = "Прекрасно " + name + " - " + profession + ",";
		s[2] = "Вы превосходно справились с этой";
		s[3] = "бандой. ";
		s[5] = "Военная добыча: " + hero.getMoney() + " золотых.";

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

	public synchronized void deactivateInfo() {
		Graphics2D g = (Graphics2D) infoImg.getGraphics();
		g.setBackground(new Color(0, 0, 0, 0));
		g.clearRect(0, 0, FIELD_DIMENSION.width, FIELD_DIMENSION.height);
	}

}
