package ru.reizy.kb1990.model.constructor;

import java.util.Observable;

import ru.reizy.kb1990.model.constructor.filemanager.BinaryFileManager;
import ru.reizy.kb1990.model.constructor.filemanager.FileManager;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.FieldType;

public class ConstructorModel extends Observable {

	public static final int FIELD_HEIGHT = 64;
	public static final int FIELD_WIDTH = 64;
	FieldType[][] bgField;
	Cell[][] map;
	private int activeId = 0;
	private String name;
	private ConstructorCastles castles;
	private ConstructorTowns towns;
	private ConstructorSignPosts signPosts;
	private FileManager manager;
	private int fieldHeight = FIELD_HEIGHT;
	private int fieldWidth = FIELD_WIDTH;

	public ConstructorModel() {
		super();
		manager = new BinaryFileManager(this);
	}

	public void setByActive(int x, int y) {
		if ((x < 0) || (y < 0) || (x >= getFieldWidth()) || (y >= getFieldHeight())) {
			return;
		} else {
			bgField[x][y] = getActive();
			show();
		}
	}

	public void load(String name) {
		this.name = name;
		manager.load();
		show();
	}

	public void save() {
		// FileManager manager = new CharacterFileManager(this);
		manager.save();
	}

	public FieldType getActive() {
		return FieldType.values()[activeId];
	}

	public void nextActive() {
		nextActive(1);
	}

	public void nextActive(int i) {
		activeId += i;
		if (activeId >= FieldType.values().length) {
			activeId -= FieldType.values().length;
		}
		show();
	}

	void show() {
		setChanged();
		notifyObservers();
	}

	public FieldType getFieldType(int x, int y) {
		if ((x < 0) || (y < 0) || (x >= getFieldWidth()) || (y >= getFieldHeight())) {
			return null;
		} else {
			return bgField[x][y];
		}
	}

	public void setActive(int id) {
		activeId = id;
		show();
	}

	public int getFieldWidth() {
		return fieldWidth;
	}

	public int getFieldHeight() {
		return fieldHeight;
	}

	/**
	 * @return the objects
	 */
	public ConstructorCastles getCastles() {
		return castles;
	}

	public ConstructorTowns getTowns() {
		return towns;
	}

	public String getName() {
		return name;
	}

	public void setFieldType(int x, int y, FieldType fieldType) {
		bgField[x][y] = fieldType;
	}

	public void init(int x, int y) {
		fieldHeight = y;
		fieldWidth = x;
		map = new Cell[getFieldWidth()][getFieldHeight()];
		bgField = new FieldType[getFieldWidth()][getFieldHeight()];
		for (int i = 0; i < getFieldWidth(); i++) {
			for (int j = 0; j < getFieldHeight(); j++) {
				bgField[i][j] = FieldType.POOL_O;
				map[i][j] = new Cell(i, j, null);
			}
		}
		castles = new ConstructorCastles(this);
		towns = new ConstructorTowns(this);
		signPosts = new ConstructorSignPosts(this);
	}

	public ConstructorSignPosts getSignPosts() {
		return signPosts;
	}

}
