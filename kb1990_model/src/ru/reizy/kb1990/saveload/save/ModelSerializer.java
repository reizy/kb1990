package ru.reizy.kb1990.saveload.save;

import java.io.IOException;

import ru.reizy.kb1990.KBModelI;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ModelSerializer extends JsonSerializer<KBModelI> {

	@Override
	public void serialize(KBModelI o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeObjectField("player", o.getGlobalPlayer());
		jsonGenerator.writeEndObject();
	}

}
