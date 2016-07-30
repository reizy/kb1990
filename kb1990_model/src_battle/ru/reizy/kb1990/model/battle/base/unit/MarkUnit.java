package ru.reizy.kb1990.model.battle.base.unit;

import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.battle.BattleHero;
import ru.reizy.kb1990.model.battle.base.AtackInfo;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInType;

public abstract class MarkUnit implements UnitInModel, UnitInType {
	@Override
	public AtackInfo atack(UnitInModel aim) {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public AtackInfo atack(int count, UnitInModel aim) {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public int getCount() {
		// always alive
		return 1;
	}

	@Override
	public Cell getLocation() {
		// have no location
		return null;
	}

	@Override
	public int getMP() {
		// always can move
		return 1;
	}

	@Override
	public boolean isOutOfControl() {
		return false;
	}

	@Override
	public boolean reduceMP(int mp) {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public void resetMP() {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public void setHero(BattleHero playerHero) {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public void setLocation(Cell cell) {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public boolean tryRevenge(UnitInModel aim) {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public boolean isEnemy() {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public Hero getHero() {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public int getСurrentHitPoints() {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public int getStartCount() {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public void setCount(int i) {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public void setСurrentHitPoints(int maxHitPoints) {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public void setStartCount(int count) {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public int getMorale() {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public int defence(UnitInModel object, int a) {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public void setFreesed(int freesed) {
		throw new IllegalAccessError(" this method cat't be used ");
	}

	@Override
	public boolean isFreesed() {
		throw new IllegalAccessError(" this method cat't be used ");
	}


}
