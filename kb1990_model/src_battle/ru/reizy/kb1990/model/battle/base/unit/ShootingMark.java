package ru.reizy.kb1990.model.battle.base.unit;

import static ru.reizy.kb1990.model.battle.BattleModel.FIELD_SIZE;
import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.battle.BattleHero;
import ru.reizy.kb1990.model.battle.base.AtackInfo;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.MasteredUnit;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;

public class ShootingMark extends MarkUnit implements MasteredUnit {
	private ShooterUnit master;
	private Cell cell;
	private ShootingMarkType type;

	protected ShootingMark(ShooterUnit unit) {
		super();
		master = unit;
		cell = unit.getLocation();
		type = new ShootingMarkType((ShooterUnitType) master.type);
	}

	@Override
	public boolean isEnemy() {
		return master.isEnemy();
	}

	@Override
	public Cell getLocation() {
		return cell;
	}

	@Override
	public int getCount() {
		return master.getCount();
	}

	@Override
	public int getMP() {
		return FIELD_SIZE;
	}

	@Override
	public boolean reduceMP(int mp) {
		return master.reduceMP(mp);
	}

	@Override
	public AtackInfo atack(UnitInModel aim) {
		master.reduseShootCount();
		int a = 0;
		int c2 = aim.getCount();
		int d = 0;
		boolean special = false;
		Cell l1 = getLocation();
		Cell l2 = aim.getLocation();
		if (aim instanceof Unit) {
			a = type.getDamage(getCount(), this, (Unit) aim);
			if (a < 0) {
				a = -a;
				special = true;
			}
			if (a > 0) {
				d = ((Unit) aim).defence(this, a);
			}
		}
		return new AtackInfo(this, aim, l1, l2, a, getCount(), c2, d, false,
				true, special);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UnitType getType() {
		return master.getType();
	}

	@Override
	public ShooterUnit getMaster() {
		return master;
	}

	@Override
	public int getMorale() {
		return master.getMorale();
	}

	@Override
	public Hero getHero() {
		return master.getHero();
	}

	@Override
	public int getСurrentHitPoints() {
		return master.getСurrentHitPoints();
	}

	@Override
	public int getStartCount() {
		return master.getStartCount();
	}

	@Override
	public boolean isOutOfControl() {
		return master.isOutOfControl();
	}

	@Override
	public BattleHero getBattleHero() {
		return getMaster().getBattleHero();
	}

}
