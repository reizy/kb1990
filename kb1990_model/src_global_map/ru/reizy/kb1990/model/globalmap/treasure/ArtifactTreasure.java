package ru.reizy.kb1990.model.globalmap.treasure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.base.artifact.Artifact;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtifactTreasure extends Treasure {
	private static final Logger log = LoggerFactory
			.getLogger(ArtifactTreasure.class);
	private final Artifact artifact;

	@JsonCreator
	public ArtifactTreasure(@JsonProperty("cell") Cell cell,
			@JsonProperty("power") int power) {
		super(cell);
		this.power = power;
		this.artifact = Artifact.artifacts[power];
		log.info("Artifact {} on {}", artifact.getClass().getSimpleName(), cell);
	}

	@Override
	protected void activateTreashure(GlobalPlayer player) {
		log.info("You find artifact: {}", artifact);
		artifact.activate(player.getHero());
	}

	@JsonIgnore
	public Artifact getArtifact() {
		return artifact;
	}

}
