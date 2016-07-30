package ru.reizy.kb1990.controller.swing.battle;

import java.awt.event.ActionListener;

import ru.reizy.kb1990.model.battle.BattleModel;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.swing.battle.BattleView;
import ru.reizy.kb1990.viewcontroller.swing.battle.InfoClickListener;

public class BattleController {
	private FieldClickListener fieldClickListener;
	private ShootController shootController;
	private UnitMissController unitMissController;
	private UnitWaitController unitWaitController;
	private GiveUpController giveUpController;
	private Thread thread = new Thread(new Fasade(), "Battle controller");
	private InfoClickListener infoClickListener;
	private volatile boolean lock = false;
	private volatile Runnable activeAction;

	public BattleController(BattleModel model, BattleView bView, KBGlobalViewI gView) {
		this.fieldClickListener = new FieldClickListener(model, this);
		this.shootController = new ShootController(model, this);
		this.unitMissController = new UnitMissController(model, this);
		this.unitWaitController = new UnitWaitController(model, this);
		this.infoClickListener = new InfoClickListener(gView, bView);
		this.giveUpController = new GiveUpController(model, this);
		thread.start();
	}

	public synchronized void runIt(Runnable runnable) {
		if (!thread.isAlive()) {
			thread = new Thread(new Fasade(), "Battle controller");
			thread.start();
			lock = false;
		}
		if (!lock) {
			lock = true;
			activeAction = runnable;
		}
	}

	public InfoClickListener getInfoClickListener() {
		return infoClickListener;
	}

	public FieldClickListener getFieldClickListener() {
		return fieldClickListener;
	}

	public ShootController getShootController() {
		return shootController;
	}

	public UnitWaitController getUnitWaitController() {
		return unitWaitController;
	}

	public UnitMissController getUnitPassController() {
		return unitMissController;
	}

	public ActionListener getGiveUpController() {
		return giveUpController;
	}

	// это чтобы избежать даблкликов, но оставить промежуточную перерисовку
	private class Fasade implements Runnable {
		public void run() {
			while (true) {
				if (activeAction != null) {
					activeAction.run();
					activeAction = null;
					lock = false;
				} else {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}

}
