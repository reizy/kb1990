package ru.reizy.kb1990.view.swing.globalmap.view;

import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.ARTIFACT_FOUND_INFO;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.ARTIFACT_FOUND_INFO_PASLE;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.ARTIFACT_NAME;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.ENEMY_ARMY_INFO;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TREASURE_FOUND_INFO_FULL_MAP;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TREASURE_FOUND_INFO_GOLD;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TREASURE_FOUND_INFO_NEXT_MAP;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TREASURE_FOUND_INFO_RANDOM_SPELL;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TREASURE_FOUND_INFO_RICH_MINERAL;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TREASURE_FOUND_INFO_SPELL_CAPACITY;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TREASURE_FOUND_INFO_SPELL_POWER;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TREASURE_FOUND_INFO_UNIT1;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TREASURE_FOUND_INFO_UNIT2;
import static ru.reizy.kb1990.view.swing.strings.ru.StringConstants.TREASURE_FOUND_INFO_UNIT3;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;

import javax.swing.JPanel;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.base.artifact.Artifact;
import ru.reizy.kb1990.model.base.magic.MagicSpells;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalHero;
import ru.reizy.kb1990.model.globalmap.events.BattleFailEvent;
import ru.reizy.kb1990.model.globalmap.events.BattleWinEvent;
import ru.reizy.kb1990.model.globalmap.events.EnemyActionEvent;
import ru.reizy.kb1990.model.globalmap.events.GlobalPlayerMoveEvent;
import ru.reizy.kb1990.model.globalmap.events.ResidenceOutEvent;
import ru.reizy.kb1990.model.globalmap.events.TownActionEvent;
import ru.reizy.kb1990.model.globalmap.events.TravelSpellActivatinoEvent;
import ru.reizy.kb1990.model.globalmap.events.TreasureActivateEvent;
import ru.reizy.kb1990.model.globalmap.treasure.ArtifactTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.FullMapTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.GoldTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.NextMapTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.RandomSpellTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.RandomUnitTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.RichMineralDepositsTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.SpellCapacityIncreasesTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.SpellPowerIncreasesTreasure;
import ru.reizy.kb1990.model.globalmap.treasure.Treasure;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.events.ShowGlobalMapEvent;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.View;
import ru.reizy.kb1990.view.swing.globalmap.controller.GlobalFieldClickListener;
import ru.reizy.kb1990.view.swing.prototype.KBControlPanel;
import ru.reizy.kb1990.view.swing.prototype.KBTabPanel;

public class GlobalView extends KBTabPanel {
	private static final long serialVersionUID = 7906405279378066763L;

	private final KBModel model;
	private final GlobalFieldPanel panelF;
	private final GlobalInfoPanel panelI;
	private final KBControlPanel panelC;
	private final KBGlobalViewI view;

	static {
		KBGlobalViewI view = View.getInstanse();
		GlobalView globalView = new GlobalView(view.getModel(), view);
		view.addTab("Глобальная игра", globalView);
	}

	public GlobalView(final KBModel model, KBGlobalViewI gView) {
		view = gView;
		setLayout(new BorderLayout());
		this.model = model;
		panelF = new GlobalFieldPanel(model, this);
		panelF.addMouseListener(new GlobalFieldClickListener(model, panelF));
		panelI = new GlobalInfoPanel(model, gView);
		panelC = new GlobalControlPanel(model);

		JPanel centralPanel = new JPanel(new BorderLayout());

		add(centralPanel, BorderLayout.CENTER);
		add(panelC, BorderLayout.EAST);

		centralPanel.add(panelF, BorderLayout.CENTER);
		centralPanel.add(panelI, BorderLayout.EAST);

	}

	@Override
	public void update() {
		Cell cell = model.getGlobalPlayer().getCell();
		panelF.fillField(cell.getX(), cell.getY());
		panelF.drawPlayer(3);
		panelI.update();
		panelC.update();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	@Override
	public void onEvent(KBEvent event) {
		if (event instanceof BattleWinEvent) {
			update();
		} else if (event instanceof BattleFailEvent) {
			updateAndActivate();
		} else if (event instanceof GlobalPlayerMoveEvent) {
			update();
		} else if (event instanceof TravelSpellActivatinoEvent) {
			update();
		} else if (event instanceof ShowGlobalMapEvent) {
			updateAndActivate();
			view.setNext(this);
		} else if (event instanceof ResidenceOutEvent) {
			updateAndActivate();
			view.setNext(this);
		} else if (event instanceof TownActionEvent) {
			update();
		} else if (event instanceof TreasureActivateEvent) {
			TreasureActivateEvent bonusEvent = (TreasureActivateEvent) event;
			onTreasureActivateEvent(bonusEvent);
		} else if (event instanceof EnemyActionEvent) {
			EnemyActionEvent enemyActionEvent = (EnemyActionEvent) event;
			onEnemyActivateEvent(enemyActionEvent);
		}

		panelF.onEvent(event);
	}

	public void showMessage(String[]... s) {
		panelF.showMessage(s);
	}

	private void showMessage(String s) {
		ArrayList<String> as = new ArrayList<String>();
		String[] ss = s.split("\n");
		for (int i = 0; i < ss.length; i++) {
			as.addAll(Arrays.asList(drawTextByWords(ss[i], 32)));
		}
		showMessage(as.toArray(new String[0]));
	}

	public void onEnemyActivateEvent(EnemyActionEvent event) {
		GlobalHero gHero = event.getEnemy();
		Object[] args ={"","","","","","","","","",""};
		for (int i = 0; i < gHero.getHero().getArmy().size(); i++) {
			args[i*2] = NameResolver.getCountText(gHero.getHero().getArmyCount(i));
			args[i*2+1] = NameResolver.getUnitName(gHero.getHero().getArmy(i));
		}
		String s = String.format(ENEMY_ARMY_INFO, args);
		showMessage(s);
	}

	private void onTreasureActivateEvent(TreasureActivateEvent e) {
		Treasure bonus = e.getTreasure();
		int power = bonus.getPower();
		String s = "???";
		if (bonus instanceof GoldTreasure) {
			s = String.format(TREASURE_FOUND_INFO_GOLD, 50 * power, power);
		} else if (bonus instanceof ArtifactTreasure) {
			int i = Arrays.asList(Artifact.artifacts).indexOf(
					((ArtifactTreasure) bonus).getArtifact());
			s = String.format(ARTIFACT_FOUND_INFO[i], ARTIFACT_NAME[i])
					+ ARTIFACT_FOUND_INFO_PASLE;
		} else if (bonus instanceof FullMapTreasure) {
			s = String.format(TREASURE_FOUND_INFO_FULL_MAP);
		} else if (bonus instanceof NextMapTreasure) {
			s = String.format(TREASURE_FOUND_INFO_NEXT_MAP,
					NameResolver.getContinentName(bonus.getCell().getMap()));
		} else if (bonus instanceof RandomSpellTreasure) {
			boolean firstElement = true;
			String t = "";
			for (Entry<MagicSpells, Integer> rs : ((RandomSpellTreasure) bonus)
					.getSpells().entrySet()) {
				if (!firstElement) {
					t += ", \n ";
				}
				firstElement = false;
				t = t + rs.getValue() + "*"
						+ NameResolver.getMagicName(rs.getKey());
			}
			s = String.format(TREASURE_FOUND_INFO_RANDOM_SPELL, t);

		} else if (bonus instanceof RichMineralDepositsTreasure) {
			s = String.format(TREASURE_FOUND_INFO_RICH_MINERAL, power);
		} else if (bonus instanceof SpellCapacityIncreasesTreasure) {
			s = String.format(TREASURE_FOUND_INFO_SPELL_CAPACITY, power);
		} else if (bonus instanceof SpellPowerIncreasesTreasure) {
			s = String.format(TREASURE_FOUND_INFO_SPELL_POWER, power);
		} else if (bonus instanceof RandomUnitTreasure) {
			RandomUnitTreasure rutBonus = (RandomUnitTreasure) bonus;
			UnitTypes unit = rutBonus.getUnit();
			int count = rutBonus.getCount();
			String t;

			if (rutBonus.canAttach(model.getGlobalPlayer())) {
				if (rutBonus.willTerror(model.getGlobalPlayer())) {
					t = TREASURE_FOUND_INFO_UNIT2;
				} else {
					t = TREASURE_FOUND_INFO_UNIT1;
				}
			} else {
				t = TREASURE_FOUND_INFO_UNIT3;
			}
			s = String.format(t, NameResolver.getCountText(count),
					NameResolver.getUnitName(unit));
		}
		showMessage(s);
	}

}
