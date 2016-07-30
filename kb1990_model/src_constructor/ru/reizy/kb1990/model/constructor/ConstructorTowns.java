package ru.reizy.kb1990.model.constructor;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.FieldType;

public class ConstructorTowns {
	Map<Cell, String> towns = new TreeMap<Cell, String>();
	Map<Cell, String> townscastles = new TreeMap<Cell, String>();
	ConstructorModel model;
	Cell[][] map;

	public ConstructorTowns(ConstructorModel model) {
		this.model = model;
		map = new Cell[model.getFieldWidth()][model.getFieldHeight()];
		for (int i = 0; i < model.getFieldWidth(); i++) {
			for (int j = 0; j < model.getFieldHeight(); j++) {
				map[i][j] = new Cell(i, j, null);
			}
		}

	}

	/**
	 * @return the castles
	 */
	private Map<Cell, String> getCastles() {
		return townscastles;
	}

	/**
	 * @return the towns
	 */
	public Map<Cell, String> getTowns() {
		return towns;
	}

	public Set<Cell> getMapCastlesSet() {
		Set<Cell> towns = new TreeSet<Cell>();
		for (int i = 0; i < model.getFieldWidth(); i++) {
			for (int j = 0; j < model.getFieldHeight(); j++) {
				if (model.bgField[i][j] == FieldType.TOWN) {
					towns.add(map[i][j]);
				}
			}
		}
		return towns;
	}

	public void removeTown(Integer x, Integer y) {
		towns.remove(map[x][y]);
		townscastles.remove(map[x][y]);
		model.show();
	}

	public void setTown(Integer x, Integer y, String town, String castle) {
		towns.put(map[x][y], town);
		townscastles.put(map[x][y], castle);
	}

	public String getCastle(Cell key) {
		return getCastles().get(key);
	}

	public void setTown(Integer x, Integer y, String name) {
		String castle = townscastles.get(map[x][y]);
		setTown(x, y, name, castle);
	}

	public void setCastle(Integer x, Integer y, String name) {
		String town = towns.get(map[x][y]);
		if (town != null) {
			townscastles.put(map[x][y], name);
		}

	}

	public Cell getCastleCell(String castle) {
		Cell cell = null;
		if ((castle != null) && (castle.length() > 0)) {
			for (Entry<Cell, String> e : model.getCastles().getCastles()
					.entrySet()) {
				if (e.getValue().equals(castle)) {
					cell = e.getKey();
					break;
				}
			}
		}
		return cell;
	}

}
