package ru.reizy.kb1990.saveload.save;

import java.io.IOException;

import ru.reizy.kb1990.model.globalmap.GlobalHero;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class GlobalHeroSerializer extends JsonSerializer<GlobalHero> {

	@Override
	public void serialize(GlobalHero o, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException,
			JsonProcessingException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeObjectField("cell", o.getCell());
		jsonGenerator.writeObjectField("hero", o.getHero());

		jsonGenerator.writeEndObject();
	}

}
