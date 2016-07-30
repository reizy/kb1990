package kb.battle.model;

import kb.BattleModelI;
import kb.base.model.Hero;
import kb.battle.model.base.BattleViewInterface;
import kb.events.StartBattleEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BattleModel implements BattleModelI {
	private static final Logger log = LoggerFactory.getLogger(BattleModel.class);
	private BattleFinishListener playerHero;
	private BattleFinishListener enemyHero;
	private BattleViewInterface view;

	public BattleModel(BattleFinishListener hero) {
		playerHero = hero;
		enemyHero = null;
	}

	@Override
	public void startBattle(boolean b, BattleFinishListener enemy) {
		enemyHero = enemy;
		view.onEvent(new StartBattleEvent());
		tryFinish();
	}

	private void tryFinish() {
		log.info("Check on battle finish");

		updateHero(enemyHero);
		BattleFinishListener winner;
		BattleFinishListener looser;

		log.info("Enemy army is void.");
		winner = playerHero;
		looser = enemyHero;
		Hero wHero = winner.getHero();
		Hero lHero = looser.getHero();
		looser.onBattleFail(wHero);
		winner.onBattleWin(lHero);

	}

	public void updateHero(BattleFinishListener hero) {
		hero.getHero().getArmy().clear();
		hero.getHero().getArmyCount().clear();

	}

	public void addView(BattleViewInterface view) {
		this.view = view;
	}

	public Hero getPlayer() {
		return playerHero.getHero();
	}
}
