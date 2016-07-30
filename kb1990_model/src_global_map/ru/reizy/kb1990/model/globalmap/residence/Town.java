package ru.reizy.kb1990.model.globalmap.residence;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.base.magic.MagicSpells;
import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.FieldType;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.events.TownInEvent;

public class Town extends Residence {
	private static final Logger log = LoggerFactory.getLogger(Town.class);

	private MagicSpells spell;
	private final String name;
	private final Castle castle;

	public Town(Cell cell, String name, Castle castle) {
		super(cell);
		this.name = name;
		this.castle = castle;
		// generate random spell
		int r = (int) (Math.random() * (BattleSpells.values().length + TravelSpells.values().length));
		if (r < BattleSpells.values().length) {
			spell = BattleSpells.values()[r];
		} else {
			spell = TravelSpells.values()[r - BattleSpells.values().length];
		}
	}

	public MagicSpells getSpell() {
		return spell;
	}

	public Cell getShipCell() {
		final Set<FieldType> set = FieldType.POOLS;
		return getFirstCell(set);
	}

	public Cell getFirstCell(final Set<FieldType> set) {
		Cell shipCell = null;
		log.info("Try to find cell for ship");
		// try to find water with grass
		int[] x = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] y = { 0, -1, -1, -1, 0, 1, 1, 1 };
		for (int i = 0; i < y.length; i++) {
			int xx = getCell().getX() + x[i];
			int yy = getCell().getY() + y[i];
			shipCell = getCell().getMap().getCell(xx, yy);
			Cell nearShipCell = null;

			if (set.contains(shipCell.getFieldType())) {
				for (int j = 0; j < y.length; j++) {
					int xx2 = shipCell.getX() + x[j];
					int yy2 = shipCell.getY() + y[j];
					nearShipCell = getCell().getMap().getCell(xx2, yy2);
					if (FieldType.MOVABLE.contains(nearShipCell.getFieldType())) {
						break;
					}
					nearShipCell = null;
				}
				if (nearShipCell != null) {
					log.info("cell finded");
					break;
				}
			}
		}
		log.info("Trying to find cell for ship is finished");
		return shipCell;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean onActivate(GlobalPlayer player) {
		player.setActiveContentCell(getCell());
		setOutCell(player.getCell());
		player.checkTown(this);
		player.getActiveMap().onEvent(new TownInEvent(this));
		return true;
	}

	public Castle getCastle() {
		return castle;
	}

	// для загрузки
	public void setSpell(MagicSpells spell) {
		this.spell = spell;
	}

	@Override
	public Cell getOutCell() {
		Cell outCell = super.getOutCell();
		if (outCell == null) {
			final Set<FieldType> set = FieldType.MOVABLE;
			outCell = getFirstCell(set);
		}
		return outCell;
	}
}
