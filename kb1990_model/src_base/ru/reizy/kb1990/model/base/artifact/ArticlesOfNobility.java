package ru.reizy.kb1990.model.base.artifact;

import ru.reizy.kb1990.model.base.Player;

//Freeing a virtuous maiden
//from the clutches of a
//despicable criminal, you
//have been granted: Гра-
//моту Дворянства...

//1 континент
public class ArticlesOfNobility extends DefaultPasleElement implements Artifact {

	ArticlesOfNobility() {
		super(0, 2);
	}

	@Override
	public void activate(Player player) {
		super.activate(player);
		player.addCommission(2000);
	}
}
