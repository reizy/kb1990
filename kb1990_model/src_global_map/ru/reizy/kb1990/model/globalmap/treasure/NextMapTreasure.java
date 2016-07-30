package ru.reizy.kb1990.model.globalmap.treasure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NextMapTreasure extends Treasure {
	private static final Logger log = LoggerFactory
			.getLogger(NextMapTreasure.class);

	@JsonCreator
	public NextMapTreasure(@JsonProperty("cell") Cell cell) {
		super(cell);
		log.info("NextMapTreasure on {}", cell);
	}

	@Override
	protected void activateTreashure(GlobalPlayer player) {
		log.info("You find next continent: {}", player.getActiveMap().getNextMap()
				.getId());
		// todo
		player.openMap(player.getActiveMap().getNextMap());
	}

}
