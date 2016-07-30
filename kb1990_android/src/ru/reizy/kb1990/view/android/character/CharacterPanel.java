package ru.reizy.kb1990.view.android.character;

import static ru.reizy.kb1990.R.drawable.map_0;
import static ru.reizy.kb1990.R.drawable.map_1;
import static ru.reizy.kb1990.R.drawable.map_2;
import static ru.reizy.kb1990.R.drawable.map_3;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CHARACTER_ARTIFACT_COUNT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CHARACTER_CASTLES_COUNT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CHARACTER_COMMISSION;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CHARACTER_FOLLOWERS_KILLED;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CHARACTER_GOLD;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CHARACTER_LEAD;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CHARACTER_NAME;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CHARACTER_SCORE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CHARACTER_SPELLS_COUNT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CHARACTER_SPELLS_POWER;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CHARACTER_VILLIANS_COUNT;

import java.util.Map;
import java.util.Set;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.base.artifact.Artifact;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.view.android.KbAndroidPanel;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import ru.reizy.kb1990.view.android.resource.VillainsTexture;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class CharacterPanel extends KbAndroidPanel {

	public static final int FIELD_WIDTH = 6 - 1;
	public static final int FIELD_HEIGHT = 5;
	private final int[] maps = { map_0, map_1, map_2, map_3 };
	private final Drawable TRANSP;

	private final ImageView[][] fieldImg;
	private final ImageView avatar;
	private final TextView text;
	private final VillainsTexture villainsTexture;

	public CharacterPanel(CharacterActivity pasleActivity, Window mWindow, Resources resources) {
		super(mWindow, resources);

		TRANSP = (BitmapDrawable) getResources().getDrawable(R.drawable.transparent);

		this.fieldImg = getImageViewField(//
				R.id.field_0_3, R.id.field_1_3, R.id.field_2_3, R.id.field_3_3, R.id.field_4_3, R.id.field_5_3, //
				R.id.field_0_4, R.id.field_1_4, R.id.field_2_4, R.id.field_3_4, R.id.field_4_4, R.id.field_5_4 //
		);
		this.text = (TextView) findViewById(R.id.character_text);
		this.avatar = (ImageView) findViewById(R.id.character_avatar);
		this.villainsTexture = new VillainsTexture(getResources());

		update();
	}

	private ImageView[][] getImageViewField(int... ids) {
		final ImageView[][] field = new ImageView[6][2];
		final int W = field.length;
		final int H = field[0].length;
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				final int n = i + j * W;
				if (ids.length > n) {
					field[i][j] = (ImageView) findViewById(ids[n]);
				}
			}
		}
		return field;
	}

	private void updateInfo() {
		GlobalPlayer c = getGlobalPlayer();
		Player p = c.getHero();
		final String name = p.getName();

		final String profession = NameResolver.getProfession(p.getType(), p.getRank());

		String[] s = new String[11];

		s[0] = String.format(CHARACTER_NAME, name, profession);
		s[1] = String.format(CHARACTER_LEAD, p.getLeadership());
		s[2] = String.format(CHARACTER_COMMISSION, p.getCommission());
		s[3] = String.format(CHARACTER_GOLD, p.getMoney());
		s[4] = String.format(CHARACTER_SPELLS_POWER, p.getSpellPower());
		s[5] = String.format(CHARACTER_SPELLS_COUNT, p.getSpellsCount() + "/" + p.getSpellCapacity());
		s[6] = String.format(CHARACTER_VILLIANS_COUNT, p.getKilledVillains().size());
		s[7] = String.format(CHARACTER_ARTIFACT_COUNT, p.getArtifacts().size());
		s[8] = String.format(CHARACTER_CASTLES_COUNT, p.getCastles().size());
		s[9] = String.format(CHARACTER_FOLLOWERS_KILLED, p.getUnitsKilledCount());
		s[10] = String.format(CHARACTER_SCORE, p.getScore());

		String ss = "";
		for (int i = 0; i < s.length; i++) {
			ss += s[i] + "\n";
		}
		text.setText(ss);
	}

	private void updateArtifacts() {
		Artifact[] af = Artifact.artifacts;
		Set<Artifact> af_opened = getGlobalPlayer().getHero().getArtifacts();
		final int atrifactW = fieldImg.length - 2;
		final int atrifactH = fieldImg[0].length;
		for (int i = 0; i < atrifactW; i++) {
			for (int j = 0; j < atrifactH; j++) {
				final int id = j * atrifactW + i;
				Artifact v = af[id];
				if (af_opened.contains(v)) {
					int resId = villainsTexture.artifacts_i.get(id);
					fieldImg[i][j].setImageResource(resId);
				} else {
					fieldImg[i][j].setImageDrawable(TRANSP);
				}
			}
		}
		for (int i = atrifactW; i < fieldImg.length; i++) {
			for (int j = 0; j < atrifactH; j++) {
				final int id = j + (i - atrifactW) * atrifactH;
				final Map<Integer, GlobalMap> m = getGlobalPlayer().getOpenedMaps();
				if (m.get(id) != null) {
					final int resId = maps[id];
					fieldImg[i][j].setImageResource(resId);
				} else {
					fieldImg[i][j].setImageDrawable(TRANSP);
				}
			}
		}
	}

	private void updateAvatar() {
		GlobalPlayer c = getGlobalPlayer();
		Player p = c.getHero();
		switch (p.getType()) {
		case KNIGHT:
			avatar.setImageResource(R.drawable.character_knight);
			break;
		case PALADIN:
			avatar.setImageResource(R.drawable.character_paladin);
			break;
		case SORCERESS:
			avatar.setImageResource(R.drawable.character_sorceress);
			break;
		default:
			avatar.setImageResource(R.drawable.character_barbarian);
			break;
		}

	}

	public void update() {
		updateAvatar();
		updateArtifacts();
		updateInfo();
	}

}
