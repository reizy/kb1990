package kb.battle.model;

import kb.base.model.Hero;

public interface BattleFinishListener {
	void onBattleFail(Hero enemy);

	void onBattleWin(Hero enemy);

	Hero getHero();

}
