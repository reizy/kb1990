package kb.battle.view.swing.eventactions;

import kb.battle.view.swing.BattleView;
import kb.events.KBEvent;
import kb.events.KBEventListener;
import kb.globalmap.model.events.BattleWinEvent;

public class BattleWinEventListener implements KBEventListener {
	private BattleView view;

	public BattleWinEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof BattleWinEvent);
	}

	public void onEvent(KBEvent e) {
		System.out.println("You win");
		view.showWinInfo(((BattleWinEvent) e).getHero());
		view.updateAndActivate();
	}
}
