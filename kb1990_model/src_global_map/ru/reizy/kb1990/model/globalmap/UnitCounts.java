package ru.reizy.kb1990.model.globalmap;

import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ARCHMAGES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.BARBARIANS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.DEMONS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.DRAGONS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.DRUIDS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.DWARVES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ELVES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.GHOSTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.GIANTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.GNOMES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.NOMADS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.OGRES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ORCS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.PEASANTS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.SKELETONS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.SPRITES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.TROLLS;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.VAMPIRES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.WOLVES;
import static ru.reizy.kb1990.model.battle.unit.types.UnitTypes.ZOMBIES;

import java.util.HashMap;
import java.util.Map;

import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;

public class UnitCounts {
	@SuppressWarnings("unchecked")
	/** 
	 * массив карт пар "тип юнита - число" в армиях врагов в зависимости от силы
	 */
	public static final Map<UnitTypes, Integer>[] A = new Map[4];
	/**
	 * карта пар "тип юнита - число" в резиденциях
	 */
	public static final Map<UnitTypes, Integer> R = new HashMap<UnitTypes, Integer>();

	static {
		{
			R.put(ARCHMAGES, 25);
			R.put(BARBARIANS, 100);
			R.put(DEMONS, 25);
			R.put(DRAGONS, 25);
			R.put(DRUIDS, 25);
			R.put(DWARVES, 100);
			R.put(ELVES, 100);
			R.put(GHOSTS, 25);
			R.put(GIANTS, 50);
			R.put(GNOMES, 250);
			R.put(NOMADS, 100);
			R.put(OGRES, 200);
			R.put(ORCS, 200);
			R.put(PEASANTS, 250);
			R.put(SKELETONS, 150);
			R.put(SPRITES, 200);
			R.put(TROLLS, 25);
			R.put(VAMPIRES, 50);
			R.put(WOLVES, 100);
			R.put(ZOMBIES, 100);

		}

		{
			A[0] = new HashMap<UnitTypes, Integer>();
			A[0].put(ARCHMAGES, 2);
			A[0].put(BARBARIANS, 2);
			// A[0].put(DEMONS, 1); не должно их тут быть
			// A[0].put(DRAGONS, 1); не должно их тут быть
			A[0].put(DRUIDS, 2);
			A[0].put(DWARVES, 4);
			A[0].put(ELVES, 5);
			A[0].put(GHOSTS, 2);
			A[0].put(GIANTS, 2);
			A[0].put(GNOMES, 10);
			A[0].put(NOMADS, 4);
			A[0].put(OGRES, 2);
			A[0].put(ORCS, 5);
			A[0].put(PEASANTS, 10);
			A[0].put(SKELETONS, 5);
			A[0].put(SPRITES, 20);
			A[0].put(TROLLS, 2);
			A[0].put(VAMPIRES, 2);
			A[0].put(WOLVES, 5);
			A[0].put(ZOMBIES, 5);

		}
		{
			A[1] = new HashMap<UnitTypes, Integer>();
			A[1].put(ARCHMAGES, 2);
			A[1].put(BARBARIANS, 4);
			A[1].put(DEMONS, 1);
			// A[1].put(DRAGONS, 1); не должно их тут быть
			A[1].put(DRUIDS, 4);
			A[1].put(DWARVES, 10);
			A[1].put(ELVES, 10);
			A[1].put(GHOSTS, 4);
			A[1].put(GIANTS, 2);
			A[1].put(GNOMES, 25);
			A[1].put(NOMADS, 8);
			A[1].put(OGRES, 4);
			A[1].put(ORCS, 15);
			A[1].put(PEASANTS, 20);
			A[1].put(SKELETONS, 10);
			A[1].put(SPRITES, 50);
			A[1].put(TROLLS, 4);
			A[1].put(VAMPIRES, 4);
			A[1].put(WOLVES, 15);
			A[1].put(ZOMBIES, 10);
		}
		{
			A[2] = new HashMap<UnitTypes, Integer>();
			A[2].put(ARCHMAGES, 4);
			A[2].put(BARBARIANS, 10);
			A[2].put(DEMONS, 4);
			A[2].put(DRAGONS, 2);
			A[2].put(DRUIDS, 6);
			A[2].put(DWARVES, 20);
			A[2].put(ELVES, 25);
			A[2].put(GHOSTS, 10);
			A[2].put(GIANTS, 5);
			A[2].put(GNOMES, 50);
			A[2].put(NOMADS, 15);
			A[2].put(OGRES, 8);
			A[2].put(ORCS, 30);
			A[2].put(PEASANTS, 50);
			A[2].put(SKELETONS, 25);
			A[2].put(SPRITES, 100);
			A[2].put(TROLLS, 8);
			A[2].put(VAMPIRES, 10);
			A[2].put(WOLVES, 30);
			A[2].put(ZOMBIES, 25);
		}
		{
			A[3] = new HashMap<UnitTypes, Integer>();
			A[3].put(ARCHMAGES, 8);
			A[3].put(BARBARIANS, 20);
			A[3].put(DEMONS, 8);
			A[3].put(DRAGONS, 2);
			A[3].put(DRUIDS, 10);
			A[3].put(DWARVES, 50);
			A[3].put(ELVES, 50);
			A[3].put(GHOSTS, 20);
			A[3].put(GIANTS, 10);
			A[3].put(GNOMES, 100);
			A[3].put(NOMADS, 30);
			A[3].put(OGRES, 15);
			A[3].put(ORCS, 80);
			A[3].put(PEASANTS, 100);
			A[3].put(SKELETONS, 75);
			A[3].put(SPRITES, 127);
			A[3].put(TROLLS, 15);
			A[3].put(VAMPIRES, 25);
			A[3].put(WOLVES, 80);
			A[3].put(ZOMBIES, 75);
		}
		/*-
		 A1.put(MILITIA, 1);
		 A1.put(ARCHERS, 1);
		 A1.put(PIKEMEN, 1);
		 A1.put(CAVALRY, 1);
		 A1.put(KNIGHTS, 1);
		 A1.put(PEASANTS, 1);
		 A1.put(WOLFS, 1);
		 A1.put(NOMADS, 1);
		 A1.put(BARBARIANS, 1);
		 A1.put(ARCHMAGES, 1);
		 A1.put(SPIRITES, 1);
		 A1.put(GNOMES, 1);
		 A1.put(ELVES, 1);
		 A1.put(TROLLS, 1);
		 A1.put(DRUIDS, 1);
		 A1.put(SKELETONS, 1);
		 A1.put(ZOMBIES, 1);
		 A1.put(GHOSTS, 1);
		 A1.put(VAMPIRES, 1);
		 A1.put(DEMONS, 1);
		 A1.put(ORCS, 1);
		 A1.put(DWARVES, 1);
		 A1.put(OGRES, 1);
		 A1.put(GIANTS, 1);
		 A1.put(DRAGONS, 1);
		 // */
		{
		}
	}
}
