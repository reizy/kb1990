package ru.reizy.kb1990.model.globalmap.treasure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//После исследования зоны,
//вы обнаружили древнюю
//сокровищницу. Можете:
//А) Забрать 3700 монет
//В) Разделить золото между
//крестьянами, подняв свой
//авторитет вождя на 74.

//1) -  2-10
//2) - 10-40
//3) - 20-70
//4) - 40-100
public class GoldTreasure extends Treasure {
	private static final Logger log = LoggerFactory.getLogger(GoldTreasure.class);

	@JsonCreator
	private GoldTreasure(@JsonProperty("cell") Cell cell,
			@JsonProperty("power") int power) {
		super(cell);
		this.power = power;
	}
	
	public GoldTreasure(int power, Cell cell) {
		super(cell);
		switch (power) {
		case 0:
			this.power = 2 + 2 * RANDOM.nextInt(5);
			break;
		case 1:
			this.power = 10 + 2 * RANDOM.nextInt(15);
			break;
		case 2:
			this.power = 20 + 2 * RANDOM.nextInt(25);
			break;
		case 3:
			this.power = 40 + 2 * RANDOM.nextInt(30);
			break;
		default:
			break;
		}
	}

	@Override
	protected void activateTreashure(GlobalPlayer player) {
		log.info("You find " + power * 50 + " gold & " + power + " leadership");
		player.getHero().addMoney(power * 50);
		player.getHero().setLeadership(
				player.getHero().getLeadership()
						- player.getHero().getTempLeadership() + power);
	}

}
