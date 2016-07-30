package ru.reizy.kb1990.model.base.artifact;

import ru.reizy.kb1990.model.base.Player;

//Following rumors of a great 
//and powerful sword, you 
//defeat its fearsome guardian
//and gain possession of: Меч
//Истины...

// 4 континент
public class SwordOfProwess extends DefaultPasleElement implements Artifact {

	SwordOfProwess() {
		super(0, 0);
	}

	@Override
	public void activate(Player player) {
		super.activate(player);
		player.setAttack(3 / 2);
	}

}
