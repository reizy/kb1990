package ru.reizy.kb1990;

import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.base.magic.MagicSpells;
import ru.reizy.kb1990.model.base.magic.battle.BattleSpells;
import ru.reizy.kb1990.model.base.magic.globalmap.TravelSpells;
import ru.reizy.kb1990.model.battle.BattleModel;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.Difficulty;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;
import ru.reizy.kb1990.model.globalmap.PlayerType;
import ru.reizy.kb1990.model.globalmap.residence.Town;

public class KBModelDefault implements KBModel {
	private GlobalPlayer gPlayer;
	private final BattleModel battleModel;
	protected final Set<KBViewInterface> views = new HashSet<KBViewInterface>();

	public KBModelDefault(String name, PlayerType type, Difficulty difficulty, InputStream... maps) {
		super();
		init(name, type, difficulty, maps);
		battleModel = new BattleModel(this);
	}

	public void init(String name, PlayerType type, Difficulty difficulty, InputStream... maps) {
		clearViews();
		Player player = new Player(name, type, 9999, difficulty);
		gPlayer = new GlobalPlayer(this, player);
		GlobalMap[] map = { null, null, null, null };
		Cell firstCell = null;
		Cell playerCell = null;
		int[] pow = { 0, 1, 2, 3 };
		for (int i = 0; i < map.length; i++) {
			map[i] = new GlobalMap(this, pow[i], gPlayer);
			firstCell = maps.length > 0 ? map[i].firstLoad(maps[i]) : map[i].firstLoad((i + 1) + ".bmap");
			if (firstCell != null) {
				playerCell = firstCell;
			}
			if (i > 0) {
				map[i - 1].setNextMap(map[i]);
			}

		}
		map[map.length - 1].setLastMap();

		// balance town's spells
		Set<MagicSpells> sp = new HashSet<MagicSpells>();
		Map<MagicSpells, List<Town>> spT = new HashMap<MagicSpells, List<Town>>();
		for (TravelSpells i : TravelSpells.values()) {
			sp.add(i);
			spT.put(i, new LinkedList<Town>());
		}
		for (BattleSpells i : BattleSpells.values()) {
			sp.add(i);
			spT.put(i, new LinkedList<Town>());
		}
		for (int i = 0; i < map.length; i++) {
			Set<Town> t = map[i].getTowns();
			for (Town town : t) {
				List<Town> l = spT.get(town.getSpell());
				l.add(town);
				sp.remove(town.getSpell());
			}
		}
		for (MagicSpells magicSpells0 : sp) {
			Town town = null;
			for (Entry<MagicSpells, List<Town>> e : spT.entrySet()) {
				if (e.getValue().size() > 1) {
					town = e.getValue().remove(0);
					break;
				}
			}
			if (town != null) {
				town.setSpell(magicSpells0);
			}
		}

		gPlayer.init(map);

		map[0].goTo(playerCell.getX(), playerCell.getY());
	}

	@Override
	public GlobalMap getGlobalMap() {
		return gPlayer.getActiveMap();
	}

	@Override
	public BattleModel getBattleModel() {
		return battleModel;
	}

	@Override
	public GlobalPlayer getGlobalPlayer() {
		return gPlayer;
	}

	@Override
	public void clearViews() {
		views.clear();
	}

	public void onEvent(KBEvent event) {
		synchronized (views) {
			for (KBViewInterface view : views) {
				if (view != null) {
					view.onEvent(event);
				}
			}
		}
	}

	@Override
	public void addView(KBViewInterface view) {
		synchronized (views) {
			views.add(view);
		}
	}

	@Override
	public void removeView(KBViewInterface view) {
		synchronized (views) {
			views.remove(view);
		}
	}

	@Override
	public void openMap(GlobalMap map) {
		gPlayer.openMap(map);
	}
}
