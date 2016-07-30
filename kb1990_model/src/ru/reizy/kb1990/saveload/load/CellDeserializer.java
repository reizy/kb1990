package ru.reizy.kb1990.saveload.load;

import java.io.IOException;

import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class CellDeserializer extends JsonDeserializer<Cell> {

	private final GlobalPlayer model;

	public CellDeserializer(GlobalPlayer model) {
		super();
		this.model = model;
	}

	@Override
	public Cell deserialize(JsonParser jsonParser,
			DeserializationContext context) throws IOException,
			JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		int mapId = node.get("map").asInt();
		GlobalMap map = model.getMaps().get(mapId);
		int x = node.get("x").asInt();
		int y = node.get("y").asInt();
		Cell cell = map.getCell(x, y);

		return cell;
	}

}
