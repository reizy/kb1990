package ru.reizy.kb1990.saveload.save;

import java.io.IOException;

import ru.reizy.kb1990.model.globalmap.residence.Castle;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CastleSerializer extends JsonSerializer<Castle> {

	@Override
	public void serialize(Castle o, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException,
			JsonProcessingException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeObjectField("cell", o.getCell());
		jsonGenerator.writeObjectField("armyHolder", o.getArmyHolder());
		jsonGenerator.writeObjectField("isEnemy", o.getHero()!=null);
		jsonGenerator.writeEndObject();
	}

}
