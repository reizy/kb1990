package ru.reizy.kb1990.view.android.battle;

import java.util.ArrayList;
import java.util.List;

import ru.reizy.kb1990.R;
import ru.reizy.kb1990.controller.android.battle.BattleFieldClickController;
import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.battle.BattleModel;
import ru.reizy.kb1990.model.battle.base.unit.Cell;
import ru.reizy.kb1990.model.battle.base.unit.ShooterUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.events.KBEventListener;
import ru.reizy.kb1990.view.android.KbAndroidModelUser;
import ru.reizy.kb1990.view.android.KbViewOptions;
import ru.reizy.kb1990.view.android.battle.listeners.AtackEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.BattleFailEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.BattleWinEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.BetrayalEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.CloneSpellUsedEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.FireballSpellUsedEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.FreezeSpellUsedEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.FreezedUnitEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.InfoEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.LightingBoltSpellUsedEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.NewTurnEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.NextUnitEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.RessurectSpellUsedEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.SpellActivatedEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.SpellResistantEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.StartBattleEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.TeleportSpellUsedEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.TurnUndeadSpellUsedEventListener;
import ru.reizy.kb1990.view.android.battle.listeners.UnitMoveEventListener;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.widget.ScrollView;
import android.widget.TextView;

public class BattleView extends KbAndroidModelUser {
	public final static int BATTLE_FAIL_RESULT = 1;
	public final static int BATTLE_WIN_RESULT = 2;

	private final BattleActivity activity;

	private final BattleFieldPanel panel;
	private final BattleController controller;
	private final BattleMagicPanel magicPanel;

	private final List<KBEventListener> kbEventListeners;
	private final TextView unitInfo;
	private final TextView userLog;

	private ScrollView userLogScroll;

	public void setBattleResult(int battleResult) {
		activity.setResult(battleResult);
	}

	public BattleView(final BattleActivity activity) {

		super();
		this.activity = activity;

		final BattleFieldClickController bfController = new BattleFieldClickController();
		unitInfo = (TextView) activity.findViewById(R.id.unit_info);
		magicPanel = new BattleMagicPanel(activity.getWindow(), activity.getResources());
		controller = new BattleController(getModel(), this, activity.getWindow(), activity.getResources(), bfController, magicPanel);

		panel = new BattleFieldPanel(activity.getWindow(), activity.getResources(), bfController) {

			@Override
			public void onNoInfo() {
				activity.finish();
			}
		};

		kbEventListeners = new ArrayList<KBEventListener>();
		kbEventListeners.add(new CloneSpellUsedEventListener(this));
		kbEventListeners.add(new FireballSpellUsedEventListener(this));
		kbEventListeners.add(new FreezeSpellUsedEventListener(this));
		kbEventListeners.add(new LightingBoltSpellUsedEventListener(this));
		kbEventListeners.add(new RessurectSpellUsedEventListener(this));
		kbEventListeners.add(new TeleportSpellUsedEventListener(this));
		kbEventListeners.add(new TurnUndeadSpellUsedEventListener(this));
		kbEventListeners.add(new SpellResistantEventListener(this));
		kbEventListeners.add(new SpellActivatedEventListener(this));
		kbEventListeners.add(new NewTurnEventListener(this));
		kbEventListeners.add(new StartBattleEventListener(this));
		kbEventListeners.add(new BattleWinEventListener(this));
		kbEventListeners.add(new BattleFailEventListener(this));
		kbEventListeners.add(new UnitMoveEventListener(this));
		kbEventListeners.add(new NextUnitEventListener(this));
		kbEventListeners.add(new AtackEventListener(this));
		kbEventListeners.add(new BetrayalEventListener(this));
		kbEventListeners.add(new InfoEventListener(this));
		kbEventListeners.add(new FreezedUnitEventListener(this));
		updateUnitShortInfo();

		userLog = (TextView) activity.findViewById(R.id.log);
		userLogScroll = (ScrollView) activity.findViewById(R.id.log_scroll);
	}

	private BattleModel getBattleModel() {
		return getModel().getBattleModel();
	}

	public void showMoving(Cell from, Cell to, Boolean animation) {
		if (animation) {
			showMoving(from, to);
		} else {
			panelUpdateCells(true, from, to);
		}
	}

	private void showMoving(final Cell from, final Cell to) {
		try {
			List<Cell> path = getBattleModel().getPath(from, to);
			Cell p1 = from;
			getBattleModel().getActiveUnit().setLocation(p1);
			int t = panel.getAnimationDuration();
			for (Cell p2 : path) {
				getBattleModel().getActiveUnit().setLocation(p2);
				panelUpdateCells(false, p1, p2);
				p1 = p2;
				Thread.sleep(t);
			}
			// Thread.sleep(t);
			panelUpdateCells(true, p1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param p1
	 * @param p2
	 */
	private void panelUpdateCells(final boolean mask, final Cell... c) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				panel.updateCells(mask, c);
			}
		});
	}

	public void updatePanels() {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				controller.updateControls();
				magicPanel.updateMagic();
			}
		});

	}

	public void initPanels() {
		controller.updateControls();
		magicPanel.updateMagic();
	}

	public void updateCells(boolean mask, Cell... cell) {
		panelUpdateCells(mask, cell);
	}

	public void showMessage(final String s) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				userLog.append("\n" + s);
				userLogScroll.post(new Runnable() {
					@Override
					public void run() {
						userLogScroll.fullScroll(ScrollView.FOCUS_DOWN);
					}
				});
			}
		});

	}

	public void onEvent(KBEvent e) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				magicPanel.hide();
			}
		});
		boolean b = false;
		for (KBEventListener listener : kbEventListeners) {
			if (listener.isAplicable(e)) {
				listener.onEvent(e);
				b = true;
				break;
			}
		}
		if (b) {
			activity.runOnUiThread(new Runnable() {

				@Override
				public void run() {
					magicPanel.updateMagic();
				}
			});

		}

		updateUnitShortInfo();
	}

	/**
	 * 
	 */
	private void updateUnitShortInfo() {
		final UnitInModel activeUnit = getBattleModel().getActiveUnit();
		if (activeUnit != null) {
			final int mp = activeUnit.getMP();
			final String ammo;
			if (activeUnit instanceof ShooterUnit) {
				ammo = "" + ((ShooterUnit) activeUnit).getShootCount();
			} else {
				ammo = "--";
			}
			activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					unitInfo.setText(String.format("M%1$2s\nS%2$2s", mp, ammo));
				}
			});
		}
	}

	public void updateField() {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				panel.initiate();
			}
		});
	}

	public void showWinInfo(final Hero hero) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				panel.showWinInfo(hero);
			}
		});

	}

	public void showFailInfo(Hero hero) {
		activity.finish();
	}

	public void update() {
		updateField();
		magicPanel.updateMagic();
	}

	public void showDamage(final UnitInModel aim, final boolean half) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				panel.showDamage(aim, half);
			}
		});
	}

	public void stopUnitAnimation() {
		panel.stopAnimation();
	}

	public Builder getGiveUpDialog(DialogInterface.OnClickListener listener) {
		return activity.getGiveUpDialog(listener);
	}

	KbViewOptions getOptions() {
		return panel.getOptions();
	}
}
