package kb.battle.controller;

import kb.battle.model.BattleModel;
import kb.battle.view.swing.BattleView;
import kb.globalmap.model.KBGlobalViewI;

public class BattleController {

	private Thread thread = new Thread(new Fasade(), "Battle controller");
	private InfoClickListener infoClickListener;
	private volatile boolean lock = false;
	private volatile Runnable activeAction;

	public BattleController(BattleModel model, BattleView bView,
			KBGlobalViewI gView) {

		this.infoClickListener = new InfoClickListener(gView, bView);
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
