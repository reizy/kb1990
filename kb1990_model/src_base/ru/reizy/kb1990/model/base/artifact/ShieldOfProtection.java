package ru.reizy.kb1990.model.base.artifact;

import ru.reizy.kb1990.model.base.Player;

//Вызванные на дуэль безжал-
//остным Темным Рыцарем, 
//вы быстро уложили его и
//добыли: Защитный Щит.

//2 континент
public class ShieldOfProtection extends DefaultPasleElement implements Artifact {
	ShieldOfProtection() {
		super(2, 0);
	}

	@Override
	public void activate(Player player) {
		super.activate(player);
		player.setDefence(4 / 3);
	}

}
