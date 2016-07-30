package ru.reizy.kb1990.saveload.load;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalHero;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.magic.Bridge;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence;
import ru.reizy.kb1990.model.globalmap.residence.Town;
import ru.reizy.kb1990.model.globalmap.treasure.Treasure;
import ru.reizy.kb1990.model.globalmap.villains.Villain;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GlobalPlayerDeserializer extends JsonDeserializer<GlobalPlayer> {

	private final GlobalPlayer model;
	private final ObjectMapper mapper;

	public GlobalPlayerDeserializer(GlobalPlayer model, ObjectMapper mapper) {
		super();
		this.model = model;
		this.mapper = mapper;
	}

	// jsonGenerator.writeObjectField("hero", o.getHero());

	@Override
	public GlobalPlayer deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);
		model.clear();

		Player p = mapper.readValue(node.get("hero").toString(), Player.class);
		model.setPlayer(p);

		for (Iterator<JsonNode> iterator = node.get("maps").elements(); iterator.hasNext();) {
			JsonNode mapNode = iterator.next();
			parceMap(mapNode);
		}

		final Cell cell = mapper.readValue(node.get("cell").toString(), Cell.class);
		final boolean fly = node.get("flying").asBoolean();
		final boolean siegeWeapon = node.get("siegeWeapon").asBoolean();
		final Cell shipCell = mapper.readValue(node.get("ship").get("cell").toString(), Cell.class);
		final Cell pasleAimCell = mapper.readValue(node.get("pasleAimCell").toString(), Cell.class);
		final Cell[] avaibleCastlesCells = mapper.readValue(node.get("avaibleCastles").toString(), Cell[].class);
		final Cell[] avaibleTownsCells = mapper.readValue(node.get("avaibleTowns").toString(), Cell[].class);
		final int time = node.get("time").asInt();
		final int maxWeek = node.get("maxWeek").asInt();

		final int[] openedMaps = mapper.readValue(node.get("openedMaps").toString(), int[].class);
		final int[] fullMaps = mapper.readValue(node.get("fullMaps").toString(), int[].class);
		@SuppressWarnings("unchecked")
		final Map<String, List<List<Boolean>>> unhiddenTmp = mapper.readValue(node.get("unhiddens").toString(), Map.class);
		final Map<Integer, boolean[][]> unhidden = new HashMap<Integer, boolean[][]>();

		for (Entry<String, List<List<Boolean>>> entry : unhiddenTmp.entrySet()) {
			Integer key = Integer.decode(entry.getKey());
			int h = entry.getValue().size();
			int w = entry.getValue().get(0).size();
			final boolean[][] value = new boolean[w][h];
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					value[i][j] = entry.getValue().get(i).get(j);
				}
			}
			unhidden.put(key, value);
		}

		model.load(cell, shipCell, pasleAimCell, time, maxWeek, fly, siegeWeapon, avaibleCastlesCells, avaibleTownsCells, openedMaps, fullMaps, unhidden);
		Cell contractCell = mapper.readValue(node.get("hero").get("contractCell").toString(), Cell.class);
		if (contractCell != null) {
			Castle c = (Castle) (contractCell.getContent());
			Villain v = (Villain) (c.getHero());
			p.setContract(v);
		}
		return model;
	}

	/**
	 * @param mapNode
	 * @throws IOException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 */
	private void parceMap(JsonNode mapNode) throws IOException, JsonParseException, JsonMappingException {
		int mapId = mapNode.get("id").asInt();
		GlobalMap map = model.getMaps().get(mapId);
		map.clear();
		for (Iterator<JsonNode> iterator = mapNode.get("castles").elements(); iterator.hasNext();) {
			mapper.readValue(iterator.next().toString(), Castle.class);
		}
		for (Iterator<JsonNode> iterator = mapNode.get("towns").elements(); iterator.hasNext();) {
			mapper.readValue(iterator.next().toString(), Town.class);
		}
		for (Iterator<JsonNode> iterator = mapNode.get("treasures").elements(); iterator.hasNext();) {
			mapper.readValue(iterator.next().toString(), Treasure.class);
		}
		for (Iterator<JsonNode> iterator = mapNode.get("residences").elements(); iterator.hasNext();) {
			mapper.readValue(iterator.next().toString(), SimpleUnitResidence.class);
		}
		for (Iterator<JsonNode> iterator = mapNode.get("heroes").elements(); iterator.hasNext();) {
			// при создании автоматически располагается на карте
			mapper.readValue(iterator.next().toString(), GlobalHero.class);
		}
		for (Iterator<JsonNode> iterator = mapNode.get("bridges").elements(); iterator.hasNext();) {
			// при создании автоматически располагается на карте
			mapper.readValue(iterator.next().toString(), Bridge.class);
		}
	}

}
