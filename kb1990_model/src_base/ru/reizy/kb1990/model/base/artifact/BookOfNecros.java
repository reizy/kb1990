package ru.reizy.kb1990.model.base.artifact;

import ru.reizy.kb1990.model.base.Player;

//Im the study of a deserted
//wizard's tower, you have
//found: Книгу мертвых...

//3 континент
public class BookOfNecros extends DefaultPasleElement implements Artifact {

	BookOfNecros() {
		super(2, 4);
	}

	@Override
	public void activate(Player player) {
		super.activate(player);
		player.setSpellCapacity(player.getSpellCapacity() * 2);
	}

}
