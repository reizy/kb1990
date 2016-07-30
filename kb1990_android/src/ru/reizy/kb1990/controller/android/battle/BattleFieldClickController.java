package ru.reizy.kb1990.controller.android.battle;

public class BattleFieldClickController {

	// todo fix it to unstatic
	private volatile Fasade fasade;
	private volatile Thread thread;
	private volatile boolean lock = false;
	private volatile Runnable activeAction;

	public BattleFieldClickController() {
		renewThread();
	}

	public synchronized void runIt(Runnable runnable) {
		if (!thread.isAlive()) {
			renewThread();
			lock = false;
		}
		if (!lock) {
			lock = true;
			activeAction = runnable;
		}
	}

	private synchronized void renewThread() {
		if (fasade != null) {
			fasade.alive = false;
		}
		fasade = new Fasade();
		thread = new Thread(fasade, "Battle controller");
		thread.setDaemon(true);
		thread.start();
	}

	// это чтобы избежать даблкликов, но оставить промежуточную перерисовку
	private class Fasade implements Runnable {
		boolean alive = true;

		public void run() {
			while (alive) {
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
