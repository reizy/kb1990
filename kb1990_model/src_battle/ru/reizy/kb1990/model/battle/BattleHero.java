package ru.reizy.kb1990.model.battle;

import java.util.ArrayList;
import java.util.List;

import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.battle.base.unit.ShooterUnit;
import ru.reizy.kb1990.model.battle.base.unit.ShooterUnitType;
import ru.reizy.kb1990.model.battle.base.unit.Unit;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.base.unit.interfaces.UnitInModel;
import ru.reizy.kb1990.model.events.BattleFinishListener;

public class BattleHero {
	private Hero hero;
	private BattleFinishListener l;
	private List<UnitInModel> army = new ArrayList<UnitInModel>();
	private BattleModel model;

	public BattleHero(BattleFinishListener l, BattleModel model) {
		super();
		this.model = model;
		this.l = l;
		this.hero = l.getHero();
		for (int i = 0; i < hero.getArmy().size(); i++) {
			army.add(getUnit(hero.getArmy().get(i), hero.getArmyCount().get(i)));
		}
	}

	public void updateHero() {
		hero.getArmy().clear();
		hero.getArmyCount().clear();
		for (UnitInModel unit : army) {
			hero.addToArmy(unit.getType(), unit.getCount());
		}
	}

	public Hero getHero() {
		return hero;
	}

	public List<UnitInModel> getArmy() {
		return army;
	}

	private UnitInModel getUnit(UnitType type, int count) {
		UnitInModel unit = null;
		if (type instanceof ShooterUnitType) {
			unit = new ShooterUnit(this, null, count, (ShooterUnitType) type);
		} else {
			unit = new Unit(this, null, count, type);
		}
		return unit;
	}

	public BattleModel getBattleModel() {
		return model;
	}

	public BattleFinishListener getBattleListener() {
		return l;
	}

}
