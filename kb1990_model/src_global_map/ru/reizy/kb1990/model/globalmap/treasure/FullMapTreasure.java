package ru.reizy.kb1990.model.globalmap.treasure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FullMapTreasure extends Treasure {
	private static final Logger log = LoggerFactory
			.getLogger(FullMapTreasure.class);

	@JsonCreator
	public FullMapTreasure(@JsonProperty("cell") Cell cell) {
		super(cell);
		log.info("FullMapTreasure on {}", cell);
	}

	@Override
	protected void activateTreashure(GlobalPlayer player) {
		log.info("You find full map: {}", player.getActiveMap().getId());
		player.addFullMap(player.getActiveMap());
	}

}
