package ru.reizy.kb1990.model.globalmap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import ru.reizy.kb1990.BattleModelI;
import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.events.BattleFinishListener;
import ru.reizy.kb1990.model.globalmap.events.EnemyActionEvent;

public class GlobalHero implements Content, BattleFinishListener {
	private Hero hero;
	private Cell cell;

	public GlobalHero(Hero hero) {
		this.hero = hero;
	}

	@JsonCreator
	public GlobalHero(@JsonProperty("cell") Cell cell, @JsonProperty("hero") Hero hero) {
		this.hero = hero;
		goTo(cell);
	}

	@Override
	public Hero getHero() {
		return hero;
	}

	@Override
	public Cell getCell() {
		return cell;
	}

	protected void setCell(Cell cell) {
		this.cell = cell;
	}

	public void goTo(Cell cell) {
		if (this.cell != null) {
			this.cell.setContent(null);
		}
		setCell(cell);
		if (cell != null) {
			cell.setContent(this);
		}
	}

	@Override
	public boolean onActivate(GlobalPlayer player) {
		if (player.getActiveEnemy() == this) {
			attackEnemy(player);
		} else {
			player.setActiveContentCell(getCell());
			getCell().getMap().onEvent(new EnemyActionEvent(this));
		}
		return false;
	}

	public void attackEnemy(GlobalPlayer player) {
		BattleModelI battleModel = getCell().getMap().getBattleModel();
		player.setActiveContentCell(this.cell);
		battleModel.startBattle(false, this);
	}

	@Override
	public void onBattleFail(Hero enemy) {
		goTo(null);
	}

	@Override
	public void onBattleWin(Hero enemy) {
		// TODO Nothing
	}
}
