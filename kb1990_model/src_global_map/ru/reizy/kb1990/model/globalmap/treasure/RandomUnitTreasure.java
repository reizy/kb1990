package ru.reizy.kb1990.model.globalmap.treasure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.UnitCounts;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//Вы захватили кучу 
//негодяев, тероризировав-
//ших окрестности.
//В обмен на их освобож-
//дение вы получили выкуп:
//	

//1)
//2)	2 святая вода заклн. (2*2000)
//		1 градврата (1*500)
//3)	1 - клон (1*2000)
//		1 - телепорт (1*500)
//4)
public class RandomUnitTreasure extends Treasure {
	private static final Logger log = LoggerFactory
			.getLogger(RandomUnitTreasure.class);
	private final UnitTypes unit;
	private final int count;

	@JsonCreator
	public RandomUnitTreasure(@JsonProperty("cell") Cell cell,
			@JsonProperty("power") int power,
			@JsonProperty("unit") UnitTypes unit,
			@JsonProperty("count") int count) {
		super(cell);
		this.power = power;
		this.unit = unit;
		this.count = count;
	}

	public RandomUnitTreasure(int power, Cell cell, UnitTypes unit) {
		this(cell, power, unit, UnitCounts.A[power].get(unit));
	}

	@Override
	protected void activateTreashure(GlobalPlayer player) {
		log.info("You activate random unit treasure: " + toString());

		final Player hero = player.getHero();
		if (canAttach(player)) {
			hero.addToArmy(unit, count);
		}
	}

	public boolean canAttach(GlobalPlayer player) {
		final Player hero = player.getHero();
		return ((!hero.isArmyFull()) || (hero.getArmy().contains(unit
				.getUnitType())));
	}

	public boolean willTerror(GlobalPlayer player) {
		final Player hero = player.getHero();
		final int indexOfUnit = hero.getArmy().indexOf(unit);
		final int oldCount = (indexOfUnit >= 0) ? hero
				.getArmyCount(indexOfUnit) : 0;
		final int newCount = oldCount + count;
		final int needLead = newCount * unit.getUnitType().getLeadership();
		final boolean b = (player.getHero().getLeadership() < needLead);

		return b;
	}

	@Override
	public String toString() {
		String s = "RandomUnitTreasure: (" + count + " " + unit + ")";
		return s;
	}

	public UnitTypes getUnit() {
		return unit;
	}

	public int getCount() {
		return count;
	}
}
