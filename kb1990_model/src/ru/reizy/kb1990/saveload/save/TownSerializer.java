package ru.reizy.kb1990.saveload.save;

import java.io.IOException;

import ru.reizy.kb1990.model.globalmap.residence.Town;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class TownSerializer extends JsonSerializer<Town> {

	@Override
	public void serialize(Town o, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException,
			JsonProcessingException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeObjectField("cell", o.getCell());
		jsonGenerator.writeObjectField("spell", o.getSpell());
		jsonGenerator.writeEndObject();
	}

}
