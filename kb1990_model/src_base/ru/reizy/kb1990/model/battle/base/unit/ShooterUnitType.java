package ru.reizy.kb1990.model.battle.base.unit;

public class ShooterUnitType extends UnitType {
	int minShootDamage;
	int maxShootDamage;
	int maxShootCount;

	protected ShooterUnitType(int id, int skill, int maxHitPoints,
			int maxMovePoints, int minDamage, int maxDamage,
			int minShootDamage, int maxShootDamage, int maxShootCount,
			int leadership, int cost, int race) {
		super(id, skill, maxHitPoints, maxMovePoints, minDamage, maxDamage,
				leadership, cost, race);
		this.minShootDamage = minShootDamage;
		this.maxShootDamage = maxShootDamage;
		this.maxShootCount = maxShootCount;
	}
}
