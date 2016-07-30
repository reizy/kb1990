package ru.reizy.kb1990.model.events;

import ru.reizy.kb1990.model.base.Hero;

public interface BattleFinishListener {
	void onBattleFail(Hero enemy);

	void onBattleWin(Hero enemy);

	Hero getHero();

}
