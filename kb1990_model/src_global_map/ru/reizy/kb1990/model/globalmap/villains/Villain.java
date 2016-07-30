package ru.reizy.kb1990.model.globalmap.villains;

import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ARCHERS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ARCHMAGES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.BARBARIANS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.CAVALRY;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.DEMONS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.DRAGONS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.DRUIDS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.DWARVES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ELVES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.GHOSTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.GIANTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.GNOMES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.KNIGHTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.MILITIA;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.NOMADS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.OGRES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ORCS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.PEASANTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.PIKEMEN;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.SKELETONS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.SPRITES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.TROLLS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.VAMPIRES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.WOLVES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ZOMBIES;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.reizy.kb1990.model.base.Hero;
import ru.reizy.kb1990.model.base.PasleElement;
import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.base.unit.UnitType;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.residence.Castle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Villain extends Hero implements PasleElement, Comparable<Villain> {
	private static final Logger log = LoggerFactory.getLogger(Villain.class);
	private static GlobalMap[] maps;

	public static List<Villain> init(GlobalMap... continents) {
		maps = continents;
		final List<Villain> v = new ArrayList<Villain>();
		{ // Murray the Miser
			UnitTypes[] army = { MILITIA, PEASANTS, WOLVES, PEASANTS, PEASANTS };
			int[] armyCount = { 25, 50, 20, 30, 25 };// checked
			v.add(new Villain(v.size(), 3, 4, 5000, continents[0], army, armyCount));
		}
		{ // Hack the Rogue
			UnitTypes[] army = { MILITIA, NOMADS, MILITIA, PEASANTS, PEASANTS };
			int[] armyCount = { 20, 10, 30, 60, 40 };// checked
			v.add(new Villain(v.size(), 1, 4, 6000, continents[0], army, armyCount));
		}
		{ // Princess Aimola
			UnitTypes[] army = { SPRITES, SPRITES, SKELETONS, ZOMBIES, OGRES };
			int[] armyCount = { 50, 70, 20, 20, 4 }; // checked
			v.add(new Villain(v.size(), 4, 3, 7000, continents[0], army, armyCount));
		}
		{// Baron Johnno Makahl
			UnitTypes[] army = { ORCS, ARCHERS, TROLLS, DWARVES, WOLVES };
			int[] armyCount = { 20, 10, 2, 6, 30 }; // checked
			v.add(new Villain(v.size(), 0, 3, 8000, continents[0], army, armyCount));
		}
		{// Dread Pirate Rob
			UnitTypes[] army = { MILITIA, MILITIA, ARCHERS, ELVES, BARBARIANS };
			int[] armyCount = { 60, 50, 10, 10, 5 };// checked
			v.add(new Villain(v.size(), 4, 1, 9000, continents[0], army, armyCount));
		}
		{// Caneghor the Mystic
			UnitTypes[] army = { GHOSTS, SPRITES, KNIGHTS, ARCHMAGES, ARCHMAGES };
			int[] armyCount = { 10, 250, 10, 4, 4 }; // checked
			v.add(new Villain(v.size(), 0, 1, 10000, continents[0], army, armyCount));
		}
		{// Sir Moradon the Cruel
			UnitTypes[] army = { ARCHERS, PIKEMEN, MILITIA, CAVALRY, KNIGHTS };
			int[] armyCount = { 20, 20, 100, 15, 15 };// checked
			v.add(new Villain(v.size(), 3, 0, 12000, continents[1], army, armyCount));
		}
		{// Prince Barrowpine
			UnitTypes[] army = { ARCHMAGES, DRUIDS, SPRITES, PIKEMEN, ELVES };
			int[] armyCount = { 30, 10, 300, 35, 30 };
			v.add(new Villain(v.size(), 1, 0, 14000, continents[1], army, armyCount));
		}
		{// Bargash Eyesore
			UnitTypes[] army = { OGRES, TROLLS, GIANTS, WOLVES, ORCS };
			int[] armyCount = { 20, 10, 5, 80, 150 };// checked
			v.add(new Villain(v.size(), 3, 3, 16000, continents[1], army, armyCount));
		}
		{// Rinaldus Drybone
			UnitTypes[] army = { ZOMBIES, SKELETONS, GHOSTS, VAMPIRES, DEMONS };
			int[] armyCount = { 100, 500, 30, 14, 8 };
			v.add(new Villain(v.size(), 2, 3, 18000, continents[1], army, armyCount));
		}
		{// Ragface
			UnitTypes[] army = { ZOMBIES, SKELETONS, GHOSTS, VAMPIRES, DEMONS };
			int[] armyCount = { 220, 640, 50, 30, 10 };
			v.add(new Villain(v.size(), 1, 3, 20000, continents[2], army, armyCount));
		}
		{// Mahk Bellowspeak
			UnitTypes[] army = { DRAGONS, GIANTS, OGRES, ORCS, GNOMES };
			int[] armyCount = { 5, 30, 30, 200, 200 };
			v.add(new Villain(v.size(), 3, 2, 25000, continents[2], army, armyCount));
		}
		{// Auric Whiteskin
			UnitTypes[] army = { BARBARIANS, GIANTS, GNOMES, NOMADS, PEASANTS };
			int[] armyCount = { 45, 20, 300, 100, 750 };
			v.add(new Villain(v.size(), 1, 2, 30000, continents[2], army, armyCount));
		}
		{// Czar Nikolai the Mad
			UnitTypes[] army = { PIKEMEN, ARCHERS, CAVALRY, KNIGHTS, DRAGONS };
			int[] armyCount = { 110, 45, 85, 60, 5 };
			v.add(new Villain(v.size(), 3, 1, 35000, continents[2], army, armyCount));
		}
		{// Magus Deathspell
			UnitTypes[] army = { VAMPIRES, ARCHMAGES, DEMONS, GNOMES, PEASANTS };
			int[] armyCount = { 60, 100, 30, 500, 5000 };
			v.add(new Villain(v.size(), 2, 1, 40000, continents[3], army, armyCount));
		}
		{// Urthrax Killspite
			UnitTypes[] army = { DRAGONS, CAVALRY, DEMONS, KNIGHTS, ARCHMAGES };
			int[] armyCount = { 10, 200, 50, 250, 60 };
			v.add(new Villain(v.size(), 1, 1, 45000, continents[3], army, armyCount));
		}
		{// Arech Dragonbreath
			UnitTypes[] army = { DRAGONS, DRAGONS, DRAGONS, DEMONS, VAMPIRES };
			int[] armyCount = { 23, 24, 100, 100, 100 };
			v.add(new Villain(v.size(), 2, 2, 50000, continents[3], army, armyCount));
		}
		v.add(null);

		return v;
	}

	@JsonProperty("id")
	private final int id;
	private final int pasleX;
	private final int pasleY;
	private final int bounty;
	private int relocations;
	@JsonIgnore
	private Castle castle;

	private static Castle getRandomCastle(GlobalMap continet) {
		Castle c = null;
		if (continet != null) {
			// находим пустые замки
			List<Castle> list = new LinkedList<Castle>();
			for (Castle castle : continet.getCastles()) {
				Hero h = castle.getHero();
				if (!(h instanceof Villain)) {
					list.add(castle);
				}
			}
			// выбираем случайный
			Collections.shuffle(list);
			if (list.size() > 0) {
				c = list.get(0);
			}
		}
		return c;
	}

	@JsonCreator
	private Villain(@JsonProperty("id") int id, @JsonProperty("pasleX") int pasleX, @JsonProperty("pasleY") int pasleY, @JsonProperty("bounty") int bounty,
			@JsonProperty("castleCell") Cell castleCell, @JsonProperty("army") UnitTypes[] army, @JsonProperty("armyCount") int[] armyCount,
			@JsonProperty("relocations") int relocations) {
		this(id, pasleX, pasleY, bounty, //
				(Castle) (castleCell == null ? null : castleCell.getContent()), army, armyCount);
		this.relocations = relocations;
	}

	private Villain(int id, int pasleX, int pasleY, int bounty, GlobalMap continet, UnitTypes[] army, int[] armyCount) {
		this(id, pasleX, pasleY, bounty, getRandomCastle(continet), army, armyCount);
		log.info(this.toString());
	}

	private Villain(int id, int pasleX, int pasleY, int bounty, Castle castle, UnitTypes[] army, int[] armyCount) {
		super(id, Hero.MAX_LEADERSHIP);
		this.id = id;
		this.pasleX = pasleX;
		this.pasleY = pasleY;
		this.bounty = bounty;
		for (int i = 0; i < army.length; i++) {
			addToArmyInNewSlot(army[i], armyCount[i]);
		}
		setCastle(castle);
		log.info(this.toString());
	}

	@Override
	public void addToArmyInNewSlot(UnitType type, int count) {
		addMoney(type.getCost() * count / 2);
		super.addToArmyInNewSlot(type, count);
	}

	@Override
	public void addToArmy(UnitType type, int count) {
		addMoney(type.getCost() * count / 2);
		super.addToArmy(type, count);
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int getPasleX() {
		return pasleX;
	}

	@Override
	public int getPasleY() {
		return pasleY;
	}

	public int getBounty() {
		return bounty;
	}

	@JsonIgnore
	public GlobalMap getContinet() {

		GlobalMap map = null;
		if ((castle != null)) {
			map = getCastle().getCell().getMap();
		}
		return map;
	}

	public Castle getCastle() {
		return castle;
	}

	@Override
	public void activate(Player player) {
		if (player.getContract() == this) {
			player.addMoney(getBounty());
			player.addPasleElement(this);
			log.info("Villian " + id + " killed!");
		} else {
			player.removeCastle(castle);
			relocate();
			log.info("Villian " + id + " escaped!");
		}
	}

	@Override
	public String toString() {
		String s = "Villian " + id + " " + super.toString() + " in " + castle;
		return s;
	}

	private void relocate() {
		// находим пустые замки
		List<Castle> list = new LinkedList<Castle>();
		for (GlobalMap continet : maps) { // по всем континентам
			// if (continet != this.continet)
			{ // кроме текущего
				if (continet != null) { // кроме пустых
					for (Castle castle : continet.getCastles()) { // смотрим все
																	// замки
						Hero hero = castle.getHero();
						if (!(hero instanceof Villain)) { // запоминаем все
															// незанятые
							list.add(castle);
						}
					}
				}
			}
		}
		log.warn("Villain " + id + " relocated.");
		clear();
		// выбираем случайный
		Collections.shuffle(list);
		Castle castle = list.get(0);
		if (castle.getArmy().isEmpty()) {
			castle.setHero(castle.getCell().getMap().generateEnemy(GlobalMap.CASTLE_ENEMY_ARMY_SIZE));
		}

		// обнуляем трофеи
		addMoney(-getMoney());
		// копируем армию
		for (int i = 0; i < castle.getArmy().size(); i++) {
			UnitType type = castle.getArmy(i);
			int count = castle.getArmyCount(i);
			addToArmyInNewSlot(type, count);
		}
		// Помещаем злодея в замок
		setCastle(castle);

	}

	private void setCastle(Castle castle) {
		this.castle = castle;
		if (castle != null) {
			castle.setHero(this);
			relocations++;
		}
	}

	public int getRelocations() {
		return relocations;
	}

	@JsonProperty("castleCell")
	private Cell getCastleCell() {
		final Cell cell = castle == null ? null : castle.getCell();
		return cell;
	}

	public void clear() {
		this.castle = null;
		this.getArmy().clear();
		this.getArmyCount().clear();
	}

	@Override
	public int compareTo(Villain o) {
		return getId().compareTo((o != null) ? o.getId() : 1);
	}

	@JsonProperty("money")
	private void setMoney(int money) {
		// ignoring, money depends from army
	}
}
