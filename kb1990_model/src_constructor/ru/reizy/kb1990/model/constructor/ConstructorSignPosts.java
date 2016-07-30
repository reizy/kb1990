package ru.reizy.kb1990.model.constructor;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.FieldType;

public class ConstructorSignPosts {
	final Map<Cell, String> signPosts = new TreeMap<Cell, String>();
	final ConstructorModel model;
	final Cell[][] map;

	public ConstructorSignPosts(ConstructorModel model) {
		this.model = model;
		map = model.map;
	}

	/**
	 * @return the SignPosts
	 */
	public Map<Cell, String> getSignPosts() {
		return signPosts;
	}

	public Set<Cell> getMapSignPostsSet() {
		Set<Cell> signPosts = new TreeSet<Cell>();
		for (int i = 0; i < model.getFieldWidth(); i++) {
			for (int j = 0; j < model.getFieldHeight(); j++) {
				if (model.bgField[i][j] == FieldType.SIGNPOST) {
					signPosts.add(map[i][j]);
				}
			}
		}
		return signPosts;
	}

	public void removeSignPost(int x, int y) {
		signPosts.remove(map[x][y]);
		model.show();
	}

	public String getSignPost(int x, int y) {
		return signPosts.get(map[x][y]);
	}

	public void setSignPost(int x, int y, String text) {
		signPosts.put(map[x][y], text);
		model.show();
	}

}
