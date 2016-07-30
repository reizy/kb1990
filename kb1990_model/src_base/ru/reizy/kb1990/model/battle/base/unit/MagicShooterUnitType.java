package ru.reizy.kb1990.model.battle.base.unit;

public class MagicShooterUnitType extends ShooterUnitType {

	protected MagicShooterUnitType(int id, int skill, int maxHitPoints,
			int maxMovePoints, int minDamage, int maxDamage,
			int minShootDamage, int maxShootDamage, int maxShootCount,
			int leadership, int cost, int race) {
		super(id, skill, maxHitPoints, maxMovePoints, minDamage, maxDamage,
				minShootDamage, maxShootDamage, maxShootCount, leadership,
				cost, race);
	}

}
