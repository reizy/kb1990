package ru.reizy.kb1990.saveload.load;

import java.io.IOException;

import ru.reizy.kb1990.model.base.magic.MagicSpells;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.residence.Town;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TownDeserializer extends JsonDeserializer<Town> {

	private final ObjectMapper mapper;

	public TownDeserializer(ObjectMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public Town deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		final Cell cell = mapper.readValue(node.get("cell").toString(), Cell.class);
		final MagicSpells spell = mapper.readValue(node.get("spell").toString(), MagicSpells.class);

		Town town = (Town) cell.getContent();
		town.setSpell(spell);
		return town;
	}
}
