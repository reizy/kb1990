package ru.reizy.kb1990.view.android.resource;

import static ru.reizy.kb1990.R.anim.unit_l_1;
import static ru.reizy.kb1990.R.anim.unit_l_10;
import static ru.reizy.kb1990.R.anim.unit_l_11;
import static ru.reizy.kb1990.R.anim.unit_l_12;
import static ru.reizy.kb1990.R.anim.unit_l_13;
import static ru.reizy.kb1990.R.anim.unit_l_14;
import static ru.reizy.kb1990.R.anim.unit_l_15;
import static ru.reizy.kb1990.R.anim.unit_l_16;
import static ru.reizy.kb1990.R.anim.unit_l_17;
import static ru.reizy.kb1990.R.anim.unit_l_18;
import static ru.reizy.kb1990.R.anim.unit_l_19;
import static ru.reizy.kb1990.R.anim.unit_l_2;
import static ru.reizy.kb1990.R.anim.unit_l_20;
import static ru.reizy.kb1990.R.anim.unit_l_21;
import static ru.reizy.kb1990.R.anim.unit_l_22;
import static ru.reizy.kb1990.R.anim.unit_l_23;
import static ru.reizy.kb1990.R.anim.unit_l_24;
import static ru.reizy.kb1990.R.anim.unit_l_25;
import static ru.reizy.kb1990.R.anim.unit_l_3;
import static ru.reizy.kb1990.R.anim.unit_l_4;
import static ru.reizy.kb1990.R.anim.unit_l_5;
import static ru.reizy.kb1990.R.anim.unit_l_6;
import static ru.reizy.kb1990.R.anim.unit_l_7;
import static ru.reizy.kb1990.R.anim.unit_l_8;
import static ru.reizy.kb1990.R.anim.unit_l_9;
import static ru.reizy.kb1990.R.anim.unit_r_1;
import static ru.reizy.kb1990.R.anim.unit_r_10;
import static ru.reizy.kb1990.R.anim.unit_r_11;
import static ru.reizy.kb1990.R.anim.unit_r_12;
import static ru.reizy.kb1990.R.anim.unit_r_13;
import static ru.reizy.kb1990.R.anim.unit_r_14;
import static ru.reizy.kb1990.R.anim.unit_r_15;
import static ru.reizy.kb1990.R.anim.unit_r_16;
import static ru.reizy.kb1990.R.anim.unit_r_17;
import static ru.reizy.kb1990.R.anim.unit_r_18;
import static ru.reizy.kb1990.R.anim.unit_r_19;
import static ru.reizy.kb1990.R.anim.unit_r_2;
import static ru.reizy.kb1990.R.anim.unit_r_20;
import static ru.reizy.kb1990.R.anim.unit_r_21;
import static ru.reizy.kb1990.R.anim.unit_r_22;
import static ru.reizy.kb1990.R.anim.unit_r_23;
import static ru.reizy.kb1990.R.anim.unit_r_24;
import static ru.reizy.kb1990.R.anim.unit_r_25;
import static ru.reizy.kb1990.R.anim.unit_r_3;
import static ru.reizy.kb1990.R.anim.unit_r_4;
import static ru.reizy.kb1990.R.anim.unit_r_5;
import static ru.reizy.kb1990.R.anim.unit_r_6;
import static ru.reizy.kb1990.R.anim.unit_r_7;
import static ru.reizy.kb1990.R.anim.unit_r_8;
import static ru.reizy.kb1990.R.anim.unit_r_9;
import static ru.reizy.kb1990.R.drawable.*;
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

import java.util.HashMap;
import java.util.Map;

import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;

public class UnitsTexture extends Texture {
	public final Map<UnitTypes, Integer> units_l_a = new HashMap<UnitTypes, Integer>();
	public final Map<UnitTypes, Integer> units_r_a = new HashMap<UnitTypes, Integer>();
	public final Map<UnitTypes, Integer> units_l_1 = new HashMap<UnitTypes, Integer>();
	public final Map<UnitTypes, Integer> units_l_2 = new HashMap<UnitTypes, Integer>();
	public final Map<UnitTypes, Integer> units_l_3 = new HashMap<UnitTypes, Integer>();
	public final Map<UnitTypes, Integer> units_l_4 = new HashMap<UnitTypes, Integer>();
	public final Map<UnitTypes, Integer> units_r_1 = new HashMap<UnitTypes, Integer>();
	public final Map<UnitTypes, Integer> units_r_2 = new HashMap<UnitTypes, Integer>();
	public final Map<UnitTypes, Integer> units_r_3 = new HashMap<UnitTypes, Integer>();
	public final Map<UnitTypes, Integer> units_r_4 = new HashMap<UnitTypes, Integer>();

	public UnitsTexture(Resources resources) {
		super(resources);
		// l a
		put(units_l_a, PEASANTS, unit_l_1);
		put(units_l_a, SPRITES, unit_l_2);
		put(units_l_a, MILITIA, unit_l_3);
		put(units_l_a, WOLVES, unit_l_4);
		put(units_l_a, SKELETONS, unit_l_5);
		put(units_l_a, ZOMBIES, unit_l_6);
		put(units_l_a, GNOMES, unit_l_7);
		put(units_l_a, ORCS, unit_l_8);
		put(units_l_a, ARCHERS, unit_l_9);
		put(units_l_a, ELVES, unit_l_10);
		put(units_l_a, PIKEMEN, unit_l_11);
		put(units_l_a, NOMADS, unit_l_12);
		put(units_l_a, DWARVES, unit_l_13);
		put(units_l_a, GHOSTS, unit_l_14);
		put(units_l_a, KNIGHTS, unit_l_15);
		put(units_l_a, OGRES, unit_l_16);
		put(units_l_a, BARBARIANS, unit_l_17);
		put(units_l_a, TROLLS, unit_l_18);
		put(units_l_a, CAVALRY, unit_l_19);
		put(units_l_a, DRUIDS, unit_l_20);
		put(units_l_a, ARCHMAGES, unit_l_21);
		put(units_l_a, VAMPIRES, unit_l_22);
		put(units_l_a, GIANTS, unit_l_23);
		put(units_l_a, DEMONS, unit_l_24);
		put(units_l_a, DRAGONS, unit_l_25);

		// r a

		put(units_r_a, PEASANTS, unit_r_1);
		put(units_r_a, SPRITES, unit_r_2);
		put(units_r_a, MILITIA, unit_r_3);
		put(units_r_a, WOLVES, unit_r_4);
		put(units_r_a, SKELETONS, unit_r_5);
		put(units_r_a, ZOMBIES, unit_r_6);
		put(units_r_a, GNOMES, unit_r_7);
		put(units_r_a, ORCS, unit_r_8);
		put(units_r_a, ARCHERS, unit_r_9);
		put(units_r_a, ELVES, unit_r_10);
		put(units_r_a, PIKEMEN, unit_r_11);
		put(units_r_a, NOMADS, unit_r_12);
		put(units_r_a, DWARVES, unit_r_13);
		put(units_r_a, GHOSTS, unit_r_14);
		put(units_r_a, KNIGHTS, unit_r_15);
		put(units_r_a, OGRES, unit_r_16);
		put(units_r_a, BARBARIANS, unit_r_17);
		put(units_r_a, TROLLS, unit_r_18);
		put(units_r_a, CAVALRY, unit_r_19);
		put(units_r_a, DRUIDS, unit_r_20);
		put(units_r_a, ARCHMAGES, unit_r_21);
		put(units_r_a, VAMPIRES, unit_r_22);
		put(units_r_a, GIANTS, unit_r_23);
		put(units_r_a, DEMONS, unit_r_24);
		put(units_r_a, DRAGONS, unit_r_25);

		// l 1

		put(units_l_1, PEASANTS, unit_l_1_1);
		put(units_l_1, SPRITES, unit_l_2_1);
		put(units_l_1, MILITIA, unit_l_3_1);
		put(units_l_1, WOLVES, unit_l_4_1);
		put(units_l_1, SKELETONS, unit_l_5_1);
		put(units_l_1, ZOMBIES, unit_l_6_1);
		put(units_l_1, GNOMES, unit_l_7_1);
		put(units_l_1, ORCS, unit_l_8_1);
		put(units_l_1, ARCHERS, unit_l_9_1);
		put(units_l_1, ELVES, unit_l_10_1);
		put(units_l_1, PIKEMEN, unit_l_11_1);
		put(units_l_1, NOMADS, unit_l_12_1);
		put(units_l_1, DWARVES, unit_l_13_1);
		put(units_l_1, GHOSTS, unit_l_14_1);
		put(units_l_1, KNIGHTS, unit_l_15_1);
		put(units_l_1, OGRES, unit_l_16_1);
		put(units_l_1, BARBARIANS, unit_l_17_1);
		put(units_l_1, TROLLS, unit_l_18_1);
		put(units_l_1, CAVALRY, unit_l_19_1);
		put(units_l_1, DRUIDS, unit_l_20_1);
		put(units_l_1, ARCHMAGES, unit_l_21_1);
		put(units_l_1, VAMPIRES, unit_l_22_1);
		put(units_l_1, GIANTS, unit_l_23_1);
		put(units_l_1, DEMONS, unit_l_24_1);
		put(units_l_1, DRAGONS, unit_l_25_1);

		// l 2

		put(units_l_2, PEASANTS, unit_l_1_2);
		put(units_l_2, SPRITES, unit_l_2_2);
		put(units_l_2, MILITIA, unit_l_3_2);
		put(units_l_2, WOLVES, unit_l_4_2);
		put(units_l_2, SKELETONS, unit_l_5_2);
		put(units_l_2, ZOMBIES, unit_l_6_2);
		put(units_l_2, GNOMES, unit_l_7_2);
		put(units_l_2, ORCS, unit_l_8_2);
		put(units_l_2, ARCHERS, unit_l_9_2);
		put(units_l_2, ELVES, unit_l_10_2);
		put(units_l_2, PIKEMEN, unit_l_11_2);
		put(units_l_2, NOMADS, unit_l_12_2);
		put(units_l_2, DWARVES, unit_l_13_2);
		put(units_l_2, GHOSTS, unit_l_14_2);
		put(units_l_2, KNIGHTS, unit_l_15_2);
		put(units_l_2, OGRES, unit_l_16_2);
		put(units_l_2, BARBARIANS, unit_l_17_2);
		put(units_l_2, TROLLS, unit_l_18_2);
		put(units_l_2, CAVALRY, unit_l_19_2);
		put(units_l_2, DRUIDS, unit_l_20_2);
		put(units_l_2, ARCHMAGES, unit_l_21_2);
		put(units_l_2, VAMPIRES, unit_l_22_2);
		put(units_l_2, GIANTS, unit_l_23_2);
		put(units_l_2, DEMONS, unit_l_24_2);
		put(units_l_2, DRAGONS, unit_l_25_2);

		// l 3

		put(units_l_3, PEASANTS, unit_l_1_3);
		put(units_l_3, SPRITES, unit_l_2_3);
		put(units_l_3, MILITIA, unit_l_3_3);
		put(units_l_3, WOLVES, unit_l_4_3);
		put(units_l_3, SKELETONS, unit_l_5_3);
		put(units_l_3, ZOMBIES, unit_l_6_3);
		put(units_l_3, GNOMES, unit_l_7_3);
		put(units_l_3, ORCS, unit_l_8_3);
		put(units_l_3, ARCHERS, unit_l_9_3);
		put(units_l_3, ELVES, unit_l_10_3);
		put(units_l_3, PIKEMEN, unit_l_11_3);
		put(units_l_3, NOMADS, unit_l_12_3);
		put(units_l_3, DWARVES, unit_l_13_3);
		put(units_l_3, GHOSTS, unit_l_14_3);
		put(units_l_3, KNIGHTS, unit_l_15_3);
		put(units_l_3, OGRES, unit_l_16_3);
		put(units_l_3, BARBARIANS, unit_l_17_3);
		put(units_l_3, TROLLS, unit_l_18_3);
		put(units_l_3, CAVALRY, unit_l_19_3);
		put(units_l_3, DRUIDS, unit_l_20_3);
		put(units_l_3, ARCHMAGES, unit_l_21_3);
		put(units_l_3, VAMPIRES, unit_l_22_3);
		put(units_l_3, GIANTS, unit_l_23_3);
		put(units_l_3, DEMONS, unit_l_24_3);
		put(units_l_3, DRAGONS, unit_l_25_3);

		// l 4

		put(units_l_4, PEASANTS, unit_l_1_4);
		put(units_l_4, SPRITES, unit_l_2_4);
		put(units_l_4, MILITIA, unit_l_3_4);
		put(units_l_4, WOLVES, unit_l_4_4);
		put(units_l_4, SKELETONS, unit_l_5_4);
		put(units_l_4, ZOMBIES, unit_l_6_4);
		put(units_l_4, GNOMES, unit_l_7_4);
		put(units_l_4, ORCS, unit_l_8_4);
		put(units_l_4, ARCHERS, unit_l_9_4);
		put(units_l_4, ELVES, unit_l_10_4);
		put(units_l_4, PIKEMEN, unit_l_11_4);
		put(units_l_4, NOMADS, unit_l_12_4);
		put(units_l_4, DWARVES, unit_l_13_4);
		put(units_l_4, GHOSTS, unit_l_14_4);
		put(units_l_4, KNIGHTS, unit_l_15_4);
		put(units_l_4, OGRES, unit_l_16_4);
		put(units_l_4, BARBARIANS, unit_l_17_4);
		put(units_l_4, TROLLS, unit_l_18_4);
		put(units_l_4, CAVALRY, unit_l_19_4);
		put(units_l_4, DRUIDS, unit_l_20_4);
		put(units_l_4, ARCHMAGES, unit_l_21_4);
		put(units_l_4, VAMPIRES, unit_l_22_4);
		put(units_l_4, GIANTS, unit_l_23_4);
		put(units_l_4, DEMONS, unit_l_24_4);
		put(units_l_4, DRAGONS, unit_l_25_4);
		// r 1

		put(units_r_1, PEASANTS, unit_r_1_1);
		put(units_r_1, SPRITES, unit_r_2_1);
		put(units_r_1, MILITIA, unit_r_3_1);
		put(units_r_1, WOLVES, unit_r_4_1);
		put(units_r_1, SKELETONS, unit_r_5_1);
		put(units_r_1, ZOMBIES, unit_r_6_1);
		put(units_r_1, GNOMES, unit_r_7_1);
		put(units_r_1, ORCS, unit_r_8_1);
		put(units_r_1, ARCHERS, unit_r_9_1);
		put(units_r_1, ELVES, unit_r_10_1);
		put(units_r_1, PIKEMEN, unit_r_11_1);
		put(units_r_1, NOMADS, unit_r_12_1);
		put(units_r_1, DWARVES, unit_r_13_1);
		put(units_r_1, GHOSTS, unit_r_14_1);
		put(units_r_1, KNIGHTS, unit_r_15_1);
		put(units_r_1, OGRES, unit_r_16_1);
		put(units_r_1, BARBARIANS, unit_r_17_1);
		put(units_r_1, TROLLS, unit_r_18_1);
		put(units_r_1, CAVALRY, unit_r_19_1);
		put(units_r_1, DRUIDS, unit_r_20_1);
		put(units_r_1, ARCHMAGES, unit_r_21_1);
		put(units_r_1, VAMPIRES, unit_r_22_1);
		put(units_r_1, GIANTS, unit_r_23_1);
		put(units_r_1, DEMONS, unit_r_24_1);
		put(units_r_1, DRAGONS, unit_r_25_1);

		// r 2

		put(units_r_2, PEASANTS, unit_r_1_2);
		put(units_r_2, SPRITES, unit_r_2_2);
		put(units_r_2, MILITIA, unit_r_3_2);
		put(units_r_2, WOLVES, unit_r_4_2);
		put(units_r_2, SKELETONS, unit_r_5_2);
		put(units_r_2, ZOMBIES, unit_r_6_2);
		put(units_r_2, GNOMES, unit_r_7_2);
		put(units_r_2, ORCS, unit_r_8_2);
		put(units_r_2, ARCHERS, unit_r_9_2);
		put(units_r_2, ELVES, unit_r_10_2);
		put(units_r_2, PIKEMEN, unit_r_11_2);
		put(units_r_2, NOMADS, unit_r_12_2);
		put(units_r_2, DWARVES, unit_r_13_2);
		put(units_r_2, GHOSTS, unit_r_14_2);
		put(units_r_2, KNIGHTS, unit_r_15_2);
		put(units_r_2, OGRES, unit_r_16_2);
		put(units_r_2, BARBARIANS, unit_r_17_2);
		put(units_r_2, TROLLS, unit_r_18_2);
		put(units_r_2, CAVALRY, unit_r_19_2);
		put(units_r_2, DRUIDS, unit_r_20_2);
		put(units_r_2, ARCHMAGES, unit_r_21_2);
		put(units_r_2, VAMPIRES, unit_r_22_2);
		put(units_r_2, GIANTS, unit_r_23_2);
		put(units_r_2, DEMONS, unit_r_24_2);
		put(units_r_2, DRAGONS, unit_r_25_2);

		// r 3

		put(units_r_3, PEASANTS, unit_r_1_3);
		put(units_r_3, SPRITES, unit_r_2_3);
		put(units_r_3, MILITIA, unit_r_3_3);
		put(units_r_3, WOLVES, unit_r_4_3);
		put(units_r_3, SKELETONS, unit_r_5_3);
		put(units_r_3, ZOMBIES, unit_r_6_3);
		put(units_r_3, GNOMES, unit_r_7_3);
		put(units_r_3, ORCS, unit_r_8_3);
		put(units_r_3, ARCHERS, unit_r_9_3);
		put(units_r_3, ELVES, unit_r_10_3);
		put(units_r_3, PIKEMEN, unit_r_11_3);
		put(units_r_3, NOMADS, unit_r_12_3);
		put(units_r_3, DWARVES, unit_r_13_3);
		put(units_r_3, GHOSTS, unit_r_14_3);
		put(units_r_3, KNIGHTS, unit_r_15_3);
		put(units_r_3, OGRES, unit_r_16_3);
		put(units_r_3, BARBARIANS, unit_r_17_3);
		put(units_r_3, TROLLS, unit_r_18_3);
		put(units_r_3, CAVALRY, unit_r_19_3);
		put(units_r_3, DRUIDS, unit_r_20_3);
		put(units_r_3, ARCHMAGES, unit_r_21_3);
		put(units_r_3, VAMPIRES, unit_r_22_3);
		put(units_r_3, GIANTS, unit_r_23_3);
		put(units_r_3, DEMONS, unit_r_24_3);
		put(units_r_3, DRAGONS, unit_r_25_3);

		// r 4

		put(units_r_4, PEASANTS, unit_r_1_4);
		put(units_r_4, SPRITES, unit_r_2_4);
		put(units_r_4, MILITIA, unit_r_3_4);
		put(units_r_4, WOLVES, unit_r_4_4);
		put(units_r_4, SKELETONS, unit_r_5_4);
		put(units_r_4, ZOMBIES, unit_r_6_4);
		put(units_r_4, GNOMES, unit_r_7_4);
		put(units_r_4, ORCS, unit_r_8_4);
		put(units_r_4, ARCHERS, unit_r_9_4);
		put(units_r_4, ELVES, unit_r_10_4);
		put(units_r_4, PIKEMEN, unit_r_11_4);
		put(units_r_4, NOMADS, unit_r_12_4);
		put(units_r_4, DWARVES, unit_r_13_4);
		put(units_r_4, GHOSTS, unit_r_14_4);
		put(units_r_4, KNIGHTS, unit_r_15_4);
		put(units_r_4, OGRES, unit_r_16_4);
		put(units_r_4, BARBARIANS, unit_r_17_4);
		put(units_r_4, TROLLS, unit_r_18_4);
		put(units_r_4, CAVALRY, unit_r_19_4);
		put(units_r_4, DRUIDS, unit_r_20_4);
		put(units_r_4, ARCHMAGES, unit_r_21_4);
		put(units_r_4, VAMPIRES, unit_r_22_4);
		put(units_r_4, GIANTS, unit_r_23_4);
		put(units_r_4, DEMONS, unit_r_24_4);
		put(units_r_4, DRAGONS, unit_r_25_4);
	}

	public int get_l(UnitTypes unit) {
		int p = 0;
		if (unit != null) {
			p = units_l_1.get(unit);
		}
		return p;
	}

	public int get_r(UnitTypes unit) {
		int p = 0;
		if (unit != null) {
			p = units_r_1.get(unit);
		}
		return p;
	}

	public int get_l_anim(UnitTypes unit) {
		int p = 0;
		if (unit != null) {
			p = units_l_a.get(unit);
		}
		return p;
	}

	public int get_r_anim(UnitTypes unit) {
		int p = 0;
		if (unit != null) {
			p = units_r_a.get(unit);
		}
		return p;
	}

	private void put(Map<UnitTypes, Integer> units, UnitTypes unit, int p) {
		// BitmapDrawable b = ((BitmapDrawable) getResources().getDrawable(p));
		// put(units, unit, b);
		units.put(unit, p);
	}

	@SuppressWarnings("unused")
	private void put(Map<UnitTypes, BitmapDrawable> units, UnitTypes unit, BitmapDrawable d) {
		units.put(unit, d);
	}

}
