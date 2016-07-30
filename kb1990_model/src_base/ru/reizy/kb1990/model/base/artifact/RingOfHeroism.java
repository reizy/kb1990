package ru.reizy.kb1990.model.base.artifact;

import ru.reizy.kb1990.model.base.Player;

//Облетая пределы страны на 
//летучем чудовище, Ма-
//гистр наградил вас по-
//дарком - Кольцом Героизма...

//1 континети
public class RingOfHeroism extends DefaultPasleElement implements Artifact {

	RingOfHeroism() {
		super(0, 4);
	}

	@Override
	public void activate(Player player) {
		super.activate(player);
		player.setAttackSkill(1);
	}
}
