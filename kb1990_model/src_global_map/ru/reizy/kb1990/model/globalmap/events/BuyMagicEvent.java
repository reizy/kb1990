package ru.reizy.kb1990.model.globalmap.events;

import ru.reizy.kb1990.model.events.ChangeCharacterEvent;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.FieldType;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;

public class BuyMagicEvent implements ChangeCharacterEvent {
	private final GlobalPlayer player;
	private final Cell cell;

	public BuyMagicEvent(GlobalPlayer player, Cell cell) {
		super();
		this.player = player;
		this.cell = cell;
	}

	public void onActivate() {
		if (cell != null) {
			if (player.buyMagic()) {
				cell.getMap().clearFieldType(cell);
				player.goTo(cell, FieldType.MAGE);
			} else {
				// nothing
			}
		}
	}

	public Cell getCell() {
		return cell;
	}
}
