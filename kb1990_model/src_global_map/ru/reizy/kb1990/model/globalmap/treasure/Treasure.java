package ru.reizy.kb1990.model.globalmap.treasure;

import java.util.Random;

import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.AbstractContent;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.events.TreasureActivateEvent;
import ru.reizy.kb1990.model.globalmap.residence.Bonus;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "@type")
public abstract class Treasure extends AbstractContent implements Bonus {
	protected static final Random RANDOM = new Random();
	protected int power;

	protected Treasure(Cell cell) {
		super(cell);
	}

	@Override
	public final boolean onActivate(GlobalPlayer player) {
		getCell().setContent(null);
		activateTreashure(player);
		KBEvent event = new TreasureActivateEvent(this);
		player.getActiveMap().onEvent(event);
		return true;
	}

	public final int getPower() {
		return power;
	}

	protected abstract void activateTreashure(GlobalPlayer player);
}
