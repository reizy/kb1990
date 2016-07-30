package kb.battle.view.swing.eventactions;

import kb.battle.view.swing.BattleView;
import kb.events.KBEvent;
import kb.events.KBEventListener;
import kb.events.StartBattleEvent;

public class StartBattleEventListener implements KBEventListener {
	private BattleView view;

	public StartBattleEventListener(BattleView view) {
		this.view = view;
	}

	public boolean isAplicable(KBEvent e) {
		return (e instanceof StartBattleEvent);
	}

	public void onEvent(KBEvent e) {
		view.updateField();
	}
}
