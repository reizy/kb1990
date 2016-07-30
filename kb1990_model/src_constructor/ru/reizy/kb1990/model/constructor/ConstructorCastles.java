package ru.reizy.kb1990.model.constructor;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.FieldType;

public class ConstructorCastles {
	final Map<Cell, String> castles = new TreeMap<Cell, String>();
	final ConstructorModel model;
	final Cell[][] map;

	public ConstructorCastles(ConstructorModel model) {
		this.model = model;
		map = model.map;

		{
			// castles.put(map[06][57], "Ophiraund");//
			// castles.put(map[11][07], "King Maximus");//
			// castles.put(map[11][30], "Irok");//
			// castles.put(map[22][49], "Faxis");//
			// castles.put(map[22][24], "Nilslag");//
			// castles.put(map[30][27], "Azram");//
			// castles.put(map[36][49], "Cancomar");//
			// castles.put(map[40][41], "Wankelforte");//
			// castles.put(map[54][06], "Rythacon");//
			// castles.put(map[57][58], "Kookamunga");//
			// castles.put(map[58][23], "Portalis");//
			// castles.put(map[40][05], "Vutar");//

		}
	}

	/**
	 * @return the castles
	 */
	public Map<Cell, String> getCastles() {
		return castles;
	}

	public Set<Cell> getMapCastlesSet() {
		Set<Cell> castles = new TreeSet<Cell>();
		for (int i = 0; i < model.getFieldWidth(); i++) {
			for (int j = 0; j < model.getFieldHeight(); j++) {
				if (model.bgField[i][j] == FieldType.CASTLE_B) {
					castles.add(map[i][j]);
				}
			}
		}
		return castles;
	}

	public void removeCastle(int x, int y) {
		castles.remove(map[x][y]);
		model.show();
	}

	public String getCastle(int x, int y) {
		return castles.get(map[x][y]);
	}

	public void setCastle(int x, int y, String name) {
		castles.put(map[x][y], name);
		model.show();
	}

}
