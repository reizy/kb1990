package ru.reizy.kb1990.saveload;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalHero;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.events.GlobalPlayerMoveEvent;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.residence.Town;
import ru.reizy.kb1990.saveload.load.CastleDeserializer;
import ru.reizy.kb1990.saveload.load.CellDeserializer;
import ru.reizy.kb1990.saveload.load.GlobalPlayerDeserializer;
import ru.reizy.kb1990.saveload.load.TownDeserializer;
import ru.reizy.kb1990.saveload.save.CastleSerializer;
import ru.reizy.kb1990.saveload.save.CellSerializer;
import ru.reizy.kb1990.saveload.save.GlobalHeroSerializer;
import ru.reizy.kb1990.saveload.save.GlobalPlayerSerializer;
import ru.reizy.kb1990.saveload.save.MapSerializer;
import ru.reizy.kb1990.saveload.save.TownSerializer;
import ru.reizy.kb1990.saveload.save.UnitTypeSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class KBSaver {
	private static final Logger log = LoggerFactory.getLogger(KBSaver.class);
	public static final String EXT = ".sav";
	private final ObjectMapper MAPPER = new ObjectMapper();

	private final KBModel model;
	private final File dir;

	public KBSaver(KBModel model) {
		this(model, null);
	}

	public KBSaver(KBModel model, File dir) {
		super();
		this.model = model;
		this.dir = dir;
		GlobalPlayer gPlayer = model.getGlobalPlayer();
		SimpleModule module = new SimpleModule("KBModule");
		module.addSerializer(GlobalPlayer.class, new GlobalPlayerSerializer());
		module.addSerializer(Cell.class, new CellSerializer());
		module.addSerializer(UnitType.class, new UnitTypeSerializer());
		module.addSerializer(Castle.class, new CastleSerializer());
		module.addSerializer(Town.class, new TownSerializer());
		module.addSerializer(GlobalMap.class, new MapSerializer());
		module.addSerializer(GlobalHero.class, new GlobalHeroSerializer());

		module.addDeserializer(GlobalPlayer.class, new GlobalPlayerDeserializer(gPlayer, MAPPER));
		module.addDeserializer(Castle.class, new CastleDeserializer(gPlayer, MAPPER));
		module.addDeserializer(Town.class, new TownDeserializer(MAPPER));
		module.addDeserializer(Cell.class, new CellDeserializer(gPlayer));

		MAPPER.registerModule(module);
	}

	public void save() {
		save(model.getGlobalPlayer().getHero().getName());
	};

	public void save(String name) {
		File f = new File(dir, name + EXT);
		PrintWriter writer = null;
		try {
			f.createNewFile();
			writer = new PrintWriter(f);
			MAPPER.writerWithDefaultPrettyPrinter().writeValue(writer, model.getGlobalPlayer());

		} catch (Throwable e) {
			e.printStackTrace();
			log.error(e.toString());
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	public void load() {
		load(model.getGlobalPlayer().getHero().getName());

	}

	public void load(String name) {
		File f = new File(dir, name + EXT);
		if (f.exists()) {
			BufferedReader reader = null;
			try {
				MAPPER.readValue(f, GlobalPlayer.class);
			} catch (Throwable e) {

				log.error(e.toString());
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			model.getGlobalPlayer().onEvent(new GlobalPlayerMoveEvent());
			log.info(model.getGlobalPlayer().getHero().getName() + EXT + " - file loaded");
		} else {
			log.warn(model.getGlobalPlayer().getHero().getName() + EXT + " - file not founded");
		}
	};
}