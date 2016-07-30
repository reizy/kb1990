package ru.reizy.kb1990.model.base.artifact;

import ru.reizy.kb1990.model.base.Player;

//Resting on a throne in a
//phantom castle? you have
//found: Корона Управления.

//3 континент
public class CrownOfCommand extends DefaultPasleElement implements Artifact {

	CrownOfCommand() {
		super(4, 0);
	}

	@Override
	public void activate(Player player) {
		super.activate(player);
		player.setLeadership((player.getLeadership()-player.getTempLeadership()) * 2);
	}
}
