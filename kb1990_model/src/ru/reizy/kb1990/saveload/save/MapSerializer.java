package ru.reizy.kb1990.saveload.save;

import java.io.IOException;

import ru.reizy.kb1990.model.globalmap.GlobalHero;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.magic.Bridge;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence;
import ru.reizy.kb1990.model.globalmap.treasure.Treasure;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MapSerializer extends JsonSerializer<GlobalMap> {

	@Override
	public void serialize(GlobalMap o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeObjectField("id", o.getId());
		jsonGenerator.writeObjectField("castles", o.getCastles());
		jsonGenerator.writeObjectField("towns", o.getTowns());
		jsonGenerator.writeObjectField("heroes", o.getHeroes().values().toArray(new GlobalHero[0]));
		jsonGenerator.writeObjectField("treasures", o.getTreasures().values().toArray(new Treasure[0]));
		jsonGenerator.writeObjectField("residences", o.getResidences().values().toArray(new SimpleUnitResidence[0]));
		jsonGenerator.writeObjectField("bridges", o.getBridges().values().toArray(new Bridge[0]));
		jsonGenerator.writeEndObject();
	}

}
