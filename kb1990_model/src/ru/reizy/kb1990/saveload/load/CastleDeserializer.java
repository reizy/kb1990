package ru.reizy.kb1990.saveload.load;

import java.io.IOException;

import ru.reizy.kb1990.model.base.ArmyHolder;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.villains.Villain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CastleDeserializer extends JsonDeserializer<Castle> {

	private final GlobalPlayer model;
	private final ObjectMapper mapper;

	public CastleDeserializer(GlobalPlayer model, ObjectMapper mapper) {
		super();
		this.model = model;
		this.mapper = mapper;
	}

	@Override
	public Castle deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		final Cell cell = mapper.readValue(node.get("cell").toString(), Cell.class);
		final ArmyHolder armyHolder = mapper.readValue(node.get("armyHolder").toString(), ArmyHolder.class);

		Castle castle = (Castle) cell.getContent();
		if (armyHolder instanceof Villain) {
			model.getHero().addAliveVillain((Villain) armyHolder);
		}
		castle.setHero(armyHolder);
		return castle;
	}
}
