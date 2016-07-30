package ru.reizy.kb1990.model.globalmap.residence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.BattleModelI;
import ru.reizy.kb1990.model.base.ArmyHolder;
import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.events.BattleFinishListener;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.events.CastleInEvent;
import ru.reizy.kb1990.model.globalmap.villains.Villain;

public class Castle extends Residence implements BattleFinishListener {

	private static final Logger log = LoggerFactory.getLogger(Castle.class);
	private ArmyHolder armyHolder;
	private final String name;
	private final Cell outCell;

	public Castle(Cell cell, String name) {
		super(cell);
		this.name = name;
		if (name == null) {
			log.warn("Нет имени для замка!{}", cell);
		}
		if (cell != null) {
			final GlobalMap map = cell.getMap();
			final int x = cell.getX();
			final int y = cell.getY();
			this.outCell = map.getCell(x, y - 1);
		} else {
			this.outCell = null;
		}
	}

	@Override
	public Hero getHero() {
		if (armyHolder instanceof Hero) {
			return (Hero) armyHolder;
		} else {
			return null;
		}
	}

	public ArmyHolder getArmyHolder() {
		return armyHolder;
	}

	public void setHero(ArmyHolder armyHolder) {
		this.armyHolder = armyHolder;
	}

	public UnitType getArmy(int i) {
		UnitType unit = null;
		if (armyHolder != null) {
			unit = armyHolder.getArmy(i);
		}
		return unit;
	}

	public Integer getArmyCount(int i) {
		Integer unit = null;
		if (armyHolder != null) {
			unit = armyHolder.getArmyCount(i);
		}
		return unit;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean onActivate(GlobalPlayer player) {
		player.checkCastle(this); // Добавляем замок в список телекортации
		player.checkCastleInfo(this); // Добавляем информацию о хозяине замка
		player.setActiveContentCell(getCell()); // Устанавливаем точку выхода
		// если замок пустой
		if (getArmyHolder() == null) {
			setHero(player.createGarnison());
			player.getHero().addCastle(this);
		}
		getCell().getMap().onEvent(new CastleInEvent(this));
		return true;
	}

	public void atackEnemy() {
		BattleModelI battleModel = getCell().getMap().getBattleModel();
		battleModel.startBattle(true, this);
	}

	@Override
	public void onBattleFail(Hero enemy) {
		if (armyHolder instanceof Villain) {
			Villain villain = (Villain) armyHolder;
			if (enemy instanceof Player) {
				Player player = (Player) enemy;
				villain.activate(player);
			}
		}
		setHero(null);
	}

	@Override
	public void onBattleWin(Hero enemy) {
		// TODO nothing
	}

	@Override
	public String toString() {
		return "Caslte " + name + " on " + getCell();
	}

	public List<UnitType> getArmy() {
		if (armyHolder == null) {
			setHero(new ArmyHolder());
		}
		return armyHolder.getArmy();
	}

	public List<Integer> getArmyCount() {
		if (armyHolder != null) {
			return armyHolder.getArmyCount();
		} else {
			return null;
		}
	}

	@Override
	public Cell getOutCell() {
		return outCell;
	}
}
