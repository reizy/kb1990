package ru.reizy.kb1990.model.globalmap.treasure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//После исследования земли
//вы обнаружили, что она
//богата минералами. 
//
//Король наградил вас за 
//находку повышением еже-
//недельной зарплаты на 50

//1) - 10-49
//2) - 50-99
//3) - 75-175
//4) - 150- 300
public class RichMineralDepositsTreasure extends Treasure {

	private static final Logger log = LoggerFactory.getLogger(RichMineralDepositsTreasure.class);

	@JsonCreator
	private RichMineralDepositsTreasure(@JsonProperty("cell") Cell cell, @JsonProperty("power") int power) {
		super(cell);
		this.power = power;
	}

	public RichMineralDepositsTreasure(int power, Cell cell) {
		super(cell);
		switch (power) {
		case 0:
			this.power = 10 + 1 * RANDOM.nextInt(40);
			break;
		case 1:
			this.power = 50 + 1 * RANDOM.nextInt(50);
			break;
		case 2:
			this.power = 75 + 1 * RANDOM.nextInt(100);
			break;
		case 3:
			this.power = 150 + 1 * RANDOM.nextInt(150);
			break;
		default:
			break;
		}
	}

	@Override
	protected void activateTreashure(GlobalPlayer player) {
		log.info("You activate commission treasure: +" + power);
		player.getHero().addCommission(power);
	}

}
