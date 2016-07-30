package ru.reizy.kb1990.model.battle.base.unit;


public class ShootingMarkType extends UnitType {

	protected ShootingMarkType(ShooterUnitType masterType) {
		super(masterType.id, masterType.getSkill(), masterType.maxHitPoints,
				masterType.getMaxMovePoints(), masterType.minShootDamage,
				masterType.maxShootDamage, masterType.getLeadership(),
				masterType.getCost(), masterType.getRace());
	}

}
