package ru.reizy.kb1990.model.base.artifact;

import ru.reizy.kb1990.model.base.Player;

//You discover ancient scrolls
//that describe the patterns
//of the oceans. Mariners, in
//gratitude, bestow upon you:
//Якорь Адмиралтейства...			

//2 континент
public class AnchorOfAdmiralty extends DefaultPasleElement implements Artifact {

	AnchorOfAdmiralty() {
		super(4, 4);
	}

	@Override
	public void activate(Player player) {
		super.activate(player);
		player.setBoatRent(100);
	}

}
