package ru.reizy.kb1990.saveload.save;

import java.io.IOException;

import ru.reizy.kb1990.model.globalmap.Cell;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CellSerializer extends JsonSerializer<Cell> {

	@Override
	public void serialize(Cell o, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException,
			JsonProcessingException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField("x", o.getX());
		jsonGenerator.writeNumberField("y", o.getY());
		jsonGenerator.writeNumberField("map", o.getMap().getId());
		jsonGenerator.writeEndObject();
	}

}
