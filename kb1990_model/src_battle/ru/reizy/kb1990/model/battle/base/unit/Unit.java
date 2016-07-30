package ru.reizy.kb1990.model.battle.base.unit;

import static ru.reizy.kb1990.model.battle.base.unit.UnitType.EOL;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.battle.BattleHero;
import ru.reizy.kb1990.model.battle.base.AtackInfo;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInView;

public class Unit implements UnitInModel, UnitInType, UnitInView {
	private static final Logger log = LoggerFactory.getLogger(Unit.class);
	private Cell location;
	UnitType type;
	private int mp;
	private int count;
	private int hp;
	private BattleHero hero;
	private boolean revenge;
	private int startCount;

	private int freesed;

	public Unit(BattleHero hero, Cell location, int count, UnitType type) {
		super();
		this.hero = hero;
		this.type = type;
		this.count = count;
		this.startCount = count;
		hp = type.getMaxHitPoints();
		mp = type.getMaxMovePoints();
		revenge = true;
		freesed = 0;
		this.setLocation(location);

	}

	public UnitType getType() {
		return type;
	}

	public Cell getLocation() {
		return location;
	}

	public void setLocation(Cell location) {
		if (location == this.location) {
			return;
		}
		if ((location != null) && (location.getContent() != null))
			throw new IllegalStateException(location.getContent().toString()+"_loc ="+location+"<>"+this.location);
		if (this.location != null) {
			this.location.setContent(null);
		}
		// TODO view moving
		this.location = location;
		if (location != null) {
			location.setContent(this);
		}
	}

	public int getMP() {
		return mp;
	}

	/**
	 * Reducing Movement Points
	 * 
	 * @param r count of MP to reduce
	 * @return true if mp==0
	 */
	public boolean reduceMP(int r) {
		if (r < 0) {
			throw new IllegalArgumentException("Fail mp " + r);
		}
		mp -= r;
		if (mp < 0) {
			mp = 0;
		}
		return mp == 0;
	}

	public void resetMP() {
		log.info(getType().getClass().getSimpleName() + "MP reseted");
		revenge = true;
		if (freesed > 0) {
			freesed--;
		}
		mp = type.getMaxMovePoints();
		type.onResetMP(this);
	}

	public AtackInfo atack(int count, UnitInModel aim) {
		int a = 0;
		int c2 = aim.getCount();
		int d = 0;
		boolean special = false;
		Cell l1 = getLocation();
		Cell l2 = aim.getLocation();
		if (aim instanceof Unit) {
			a = type.getDamage(count, this, (Unit) aim);
			if (a < 0) {
				a = -a;
				special = true;
			}
			if (a > 0) {
				d = ((Unit) aim).defence(this, a);
			}
		}
		return new AtackInfo(this, aim, l1, l2, a, count, c2, d, true, false,
				special);
	}

	public AtackInfo atack(UnitInModel aim) {
		AtackInfo a = atack(this.getCount(), aim);
		a.setRevenge(false);
		return a;
	}

	/**
	 * Get some damage
	 * 
	 * @param unit who atacks
	 * @param a amount of damage
	 * @return count of dead
	 */
	public int defence(UnitInModel unit, int a) {
		int dead = getCount();
		type.defence(this, a);
		dead -= getCount();
		return dead;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		if (count <= 0) {
			count = 0;
			kill();
		}
	}

	public int getСurrentHitPoints() {
		return hp;
	}

	public void setСurrentHitPoints(int hp) {
		this.hp = hp;
	}

	private void kill() {
		setСurrentHitPoints(0);
		if (getArmy() != null) {
			getArmy().remove(this);
		}
		if (getLocation() != null) {
			location.setContent(null);
		}
	}

	public List<UnitInModel> getArmy() {
		if (hero != null) {
			return hero.getArmy();
		} else {
			return null;
		}
	}

	public int getMorale() {
		int morale = Morale.MORALE_HIGH;
		if (getArmy() != null) {
			for (UnitInModel unit : getArmy()) {
				int cm = Morale.check(unit.getType(), type);
				if (cm < morale) {
					morale = cm;
				}
			}
		}
		return morale;
	}

	public String toString() {
		String s = type.toString();
		s += EOL + "count = " + count;
		String morale = (getMorale() == 0) ? "L" : (getMorale() == 1) ? "N"
				: "H";
		s += EOL + "morale = " + morale;
		s += EOL + "hp = " + hp;
		s += EOL + "location = (" + location.getX() + ";" + location.getY()
				+ ")";
		return s;

	}

	public boolean isEnemy() {
		return hero.getBattleModel().getEnemyArmy() == getArmy();
	}

	public Hero getHero() {
		return hero.getHero();
	}

	public BattleHero getBattleHero() {
		return hero;
	}

	public void setHero(BattleHero hero) {
		this.hero = hero;
	}

	// будет ли мстить цель
	public boolean tryRevenge(UnitInModel aim) {
		boolean b = false;
		if (!(aim instanceof ShootingMark)) {
			b = revenge;
			revenge = false;
		}
		return b;
	}

	public int getStartCount() {
		return startCount;
	}

	public boolean isOutOfControl() {
		int fullHP = getCount() * type.getMaxHitPoints();
		return (fullHP > hero.getHero().getLeadership());
	}

	public void setStartCount(int count) {
		this.startCount = count;
	}

	public void setFreesed(int freesed) {
		log.info(getType().getClass().getSimpleName() + "is freesed = "
				+ freesed);
		this.freesed = freesed;
	}

	public boolean isFreesed() {
		boolean b = true;
		b = (freesed > 0);
		return b;
	}
}
