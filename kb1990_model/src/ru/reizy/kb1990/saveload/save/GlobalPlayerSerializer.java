package ru.reizy.kb1990.saveload.save;

import java.io.IOException;
import java.util.Set;

import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.residence.Town;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class GlobalPlayerSerializer extends JsonSerializer<GlobalPlayer> {

	@Override
	public void serialize(GlobalPlayer o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeObjectField("cell", o.getCell());
		jsonGenerator.writeObjectField("hero", o.getHero());
		jsonGenerator.writeObjectField("ship", o.getShip());
		jsonGenerator.writeObjectField("maps", o.getMaps());
		jsonGenerator.writeObjectField("openedMaps", o.getOpenedMaps().keySet());
		jsonGenerator.writeObjectField("fullMaps", o.getFullMaps().keySet());
		{
			Set<Town> avaibleTowns = o.getAvaibleTowns();
			Cell[] c = new Cell[avaibleTowns.size()];
			int i = 0;
			for (Town town : avaibleTowns) {
				c[i++] = town.getCell();
			}
			jsonGenerator.writeObjectField("avaibleTowns", c);
		}
		{
			Set<Castle> avaibleCastles = o.getAvaibleCastles();
			Cell[] c = new Cell[avaibleCastles.size()];
			int i = 0;
			for (Castle castle : avaibleCastles) {
				c[i++] = castle.getCell();
			}
			jsonGenerator.writeObjectField("avaibleCastles", c);
		}
		jsonGenerator.writeObjectField("pasleAimCell", o.getPasleAimCell());
		jsonGenerator.writeNumberField("time", o.getTime());
		jsonGenerator.writeNumberField("maxWeek", o.getMaxWeek());
		jsonGenerator.writeBooleanField("siegeWeapon", o.hasSeigeWeapon());
		jsonGenerator.writeBooleanField("flying", o.isFlying());
		jsonGenerator.writeObjectField("unhiddens", o.getUnhiddens());
		jsonGenerator.writeEndObject();
	}
}
