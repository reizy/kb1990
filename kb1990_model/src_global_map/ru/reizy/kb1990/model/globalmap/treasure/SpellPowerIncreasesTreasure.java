package ru.reizy.kb1990.model.globalmap.treasure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//Путешествуя по земле, вы 
//споткнулись о древний сосуд.
//Заинтересовавшись, вы распе-
//чатали сосуд, освободив могу-
//чего джина, который увеличил 
//вашу волшебную силу на 1

import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//1) - 1 шт
//2) - 1 шт
//3) - 1 шт
//4) - 2 шт
public class SpellPowerIncreasesTreasure extends Treasure {

	private static final Logger log = LoggerFactory
			.getLogger(SpellPowerIncreasesTreasure.class);

	@JsonCreator
	private SpellPowerIncreasesTreasure(@JsonProperty("cell") Cell cell,
			@JsonProperty("power") int power) {
		super(cell);
		this.power = power;
	}
	
	public SpellPowerIncreasesTreasure(int power, Cell cell) {
		super(cell);
		this.power = 1 + power / 3 + RANDOM.nextInt(6 + power) / 6;
	}

	@Override
	protected void activateTreashure(GlobalPlayer player) {
		log.info("You activate spell-power treasure: +" + power);
		int spellPower = player.getHero().getSpellPower();
		spellPower += power;
		player.getHero().setSpellPower(spellPower);
	}
}
