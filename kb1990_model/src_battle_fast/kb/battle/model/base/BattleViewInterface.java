package kb.battle.model.base;

import kb.events.KBEvent;

public interface BattleViewInterface {
	void info(String string);

	void onEvent(KBEvent startBattleEvent);
}
