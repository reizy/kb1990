package ru.reizy.kb1990.model.globalmap.treasure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//Племя кочевников тепло вст-
//ретило вас и вашу армию. Их 
//шаман, предвидя ваш 
//дальнейший путь обучил 
//вас секретам своего мастерства.
//Ваша способность к заклинаниям 
//увеличилась на 1

//1) - 1 шт
//2) - 1 шт
//3)
//4) - 2 шт
public class SpellCapacityIncreasesTreasure extends Treasure {
	private static final Logger log = LoggerFactory
			.getLogger(SpellCapacityIncreasesTreasure.class);

	@JsonCreator
	private SpellCapacityIncreasesTreasure(@JsonProperty("cell") Cell cell,
			@JsonProperty("power") int power) {
		super(cell);
		this.power = power;
	}

	public SpellCapacityIncreasesTreasure(int power, Cell cell) {
		super(cell);
		this.power = 1 + power / 3 + RANDOM.nextInt(6 + power) / 6;
	}

	@Override
	protected void activateTreashure(GlobalPlayer player) {
		log.info("You activate spell-сapacity treasure: +" + power);
		int spellCapacity = player.getHero().getSpellCapacity();
		spellCapacity += power;
		player.getHero().setSpellCapacity(spellCapacity);
	}

}
