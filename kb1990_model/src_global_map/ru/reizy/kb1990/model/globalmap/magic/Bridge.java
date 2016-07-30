package ru.reizy.kb1990.model.globalmap.magic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import ru.reizy.kb1990.model.globalmap.AbstractContent;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;

public final class Bridge extends AbstractContent {
	private final boolean vertical;

	@JsonCreator
	public Bridge(@JsonProperty("cell") Cell cell, @JsonProperty("vertical") boolean vertical) {
		super(cell);
		this.vertical = vertical;
	}

	@Override
	public boolean onActivate(GlobalPlayer player) {
		// nothing
		return false;
	}

	public boolean isVertical() {
		return vertical;
	}
}
