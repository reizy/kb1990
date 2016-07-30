package ru.reizy.kb1990.model.base.artifact;

import ru.reizy.kb1990.model.base.Player;

//Hidden within an enchanted
//grove, you find: Амулет уб-
//еждения.

//4 континети
public class AmuletOfAugmentation extends DefaultPasleElement implements
		Artifact {

	AmuletOfAugmentation() {
		super(4, 2);
	}

	@Override
	public void activate(Player player) {
		super.activate(player);
		player.setSpellPower(player.getSpellPower() + 5);
	}
}
