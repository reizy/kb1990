package ru.reizy.kb1990.model.events;

import ru.reizy.kb1990.model.battle.base.AtackInfo;

public class BattleUnitAtackEvent implements KBEvent {

	private final AtackInfo atackInfo;

	public BattleUnitAtackEvent(AtackInfo atackInfo) {
		this.atackInfo = atackInfo;
	}

	public AtackInfo getAtackInfo() {
		return atackInfo;
	}

}
