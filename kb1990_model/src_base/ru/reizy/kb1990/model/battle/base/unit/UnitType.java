package ru.reizy.kb1990.model.battle.base.unit;

import java.util.Random;

import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Вид юнита
 * 
 * 
 */
public class UnitType {
	protected static final Random RANDOM = new Random();
	public static final String EOL = "\n";
	protected int maxHitPoints;
	private int maxMovePoints;
	private int leadership;
	protected int maxDamage;
	protected int minDamage;
	protected int id;
	private int race;
	private int cost;
	private int skill;

	@JsonCreator
	private static UnitType get(String name) {
		return UnitTypes.get(name).getUnitType();
	}

	protected UnitType(int id, int skill, int maxHitPoints, int maxMovePoints,
			int minDamage, int maxDamage, int leadership, int cost, int race) {
		init(id, skill, maxHitPoints, maxMovePoints, minDamage, maxDamage,
				leadership, cost, race);
	}

	private void init(int id, int skill, int maxHitPoints, int maxMovePoints,
			int minDamage, int maxDamage, int leadership, int cost, int race) {
		this.id = id;
		this.maxHitPoints = maxHitPoints;
		this.maxMovePoints = maxMovePoints;
		this.leadership = leadership;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.skill = skill;
		this.cost = cost;
		this.race = race;

	}

	@Override
	public String toString() {
		String s = "";
		s += EOL + "id = " + id;
		s += EOL + "skill = " + getSkill();
		s += EOL + "maxHitPoints = " + getMaxHitPoints();
		s += EOL + "maxMovePoimts = " + getMaxMovePoints();
		s += EOL + "damage = " + minDamage + "-" + maxDamage;
		s += EOL + "leadership = " + getLeadership();
		s += EOL + "cost = " + getCost();
		s += EOL + "race = " + getRace();
		return s;
	}

	public int getId() {
		return id;
	}

	private static double setBetween(double min, double x, double max) {
		return Math.max(min, Math.min(x, max));
	}

	public int getDamage(int count, UnitInType unit, UnitInType aim) {
		if (!aim.getType().imune(unit)) {
			// BASE
			double a = minDamage * count;
			double b = maxDamage * count;
			// MORALE
			double mkA = 1.0;
			double mkB = 1.0;
			switch (unit.getMorale()) {
			case Morale.MORALE_HIGH:
				mkA = 1.5f;
				mkB = 1.5f;
				break;
			case Morale.MORALE_LOW:
				mkA = 0.5f;
				mkB = 0.5f;
				break;
			}
			a *= mkA;
			b *= mkB;
			// RANDOM
			b -= a;
			a += RANDOM.nextDouble() * b;
			// SKILL
			double sk = unit.getHero().getAttackSkill() + getSkill()
					- aim.getType().getSkill();
			a *= setBetween(0.0, (5 + sk) / 10, 1.0);
			// HERO BONUSES
			a *= unit.getHero().getAttack() / aim.getHero().getDefence();
			// MAX FULL HP
			int max = (aim.getCount() - 1) * aim.getType().getMaxHitPoints()
					+ aim.getСurrentHitPoints() + 1;
			if (a > max) {
				a = max;
			}
			// END
			return (int) a;
		} else {
			return -1;
		}
	}

	protected boolean imune(UnitInType type) {
		return false;
	}

	public void defence(UnitInType that, int a) {
		int fullHp = that.getСurrentHitPoints() + (that.getCount() - 1)
				* getMaxHitPoints();
		fullHp -= a;
		if (fullHp <= 0) {
			that.setCount(0);
		} else {
			fullHp--;
			that.setCount(1 + (fullHp) / getMaxHitPoints());
			that.setСurrentHitPoints((fullHp % getMaxHitPoints()) + 1);
		}
	}

	public int getMaxHitPoints() {
		return maxHitPoints;
	}

	public int getRace() {
		return race;
	}

	public void onResetMP(UnitInType unit) {
	}

	public int getSkill() {
		return skill;
	}

	public int getCost() {
		return cost;
	}

	public int getWeekCost() {
		return cost / 10;
	}

	public int getLeadership() {
		return leadership;
	}

	public int getMaxMovePoints() {
		return maxMovePoints;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public int getMinDamage() {
		return minDamage;
	}

}
