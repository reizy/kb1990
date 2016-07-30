package ru.reizy.kb1990.model.battle;

import static ru.reizy.kb1990.model.battle.BattleModel.FIELD_HEIGHT;
import static ru.reizy.kb1990.model.battle.BattleModel.FIELD_WIDTH;
import ru.reizy.kb1990.model.battle.base.FieldType;
import ru.reizy.kb1990.model.battle.base.unit.MagicMark;
import ru.reizy.kb1990.model.battle.magic.abstraction.MagicBattleSpell;

public class PathField {
	private int[][] mask;
	private final int width;
	private final int heigth;
	private BattleModel model;

	public PathField(BattleModel model) {
		this(FIELD_WIDTH, FIELD_HEIGHT, model);
	}

	public PathField(int width, int heigth, BattleModel model) {
		super();
		this.width = width;
		this.heigth = heigth;
		this.mask = new int[width][heigth];
		this.model = model;
	}

	private void setBaseMask() {
		int maxN = width * heigth;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < heigth; j++) {
				if (model.getFieldType(i, j) == FieldType.GRASS) {
					if (model.getCell(i, j).getContent() == null) {
						mask[i][j] = maxN;
					} else if (model.isEnemy(model.getCell(i, j).getContent())) {
						mask[i][j] = -100 - maxN;
					} else {
						mask[i][j] = -2;
					}
				} else {
					mask[i][j] = -1;
				}
			}
		}
	}

	public void findPath(int startX, int startY) {
		setBaseMask();
		mask[startX][startY] = 0;
		setAroundCells(startX, startY);

	}

	private void setAroundCells(int x, int y) {
		int n = mask[x][y] + 1;
		setCellNRecursive(x - 1, y, n);
		setCellNRecursive(x + 1, y, n);
		setCellNRecursive(x, y - 1, n);
		setCellNRecursive(x, y + 1, n);
		// diagonal
		setCellNRecursive(x - 1, y - 1, n);
		setCellNRecursive(x + 1, y + 1, n);
		setCellNRecursive(x + 1, y - 1, n);
		setCellNRecursive(x - 1, y + 1, n);
	}

	private void setCellNRecursive(int x, int y, int n) {
		if (setCellN(x, y, n)) {
			setAroundCells(x, y);
		}
	}

	private boolean setCellN(int x, int y, final int n) {
		boolean changed = false;
		// in bounds of field
		if ((x >= 0) && (x < width) && (y >= 0) && (y < heigth)) {
			// there is no barier in field
			if (mask[x][y] > 0) {
				// no shoter way
				if (mask[x][y] > n) {
					mask[x][y] = n;
					changed = true;
				}
				// atacking
			} else if (mask[x][y] < -100) {
				// no shoter way
				if ((-100 - mask[x][y]) > n) {
					mask[x][y] = -100 - n;
					changed = false;
				}
			}
		}
		return changed;
	}

	public int[][] getMask() {
		return mask;
	}

	public void findSootingPath() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < heigth; j++) {
				if ((model.getCell(i, j).getContent() != null)
						&& (model.isEnemy(model.getCell(i, j).getContent()))) {
					mask[i][j] = -101;
				} else {
					mask[i][j] = 0;
				}
			}
		}
	}

	public void findFlyingPath(int startX, int startY) {
		findPath(startX, startY);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < heigth; j++) {
				if (mask[i][j] > 0) {
					mask[i][j] = 1;
				}
			}
		}
	}

	public void findMagicPath(MagicMark mark) {
		MagicBattleSpell spell = mark.getSpell();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < heigth; j++) {
				if (model.getFieldType(i, j) == FieldType.GRASS) {
					if (spell.canBeAim(model.getCell(i, j))) {
						mask[i][j] = -101;
					} else {
						mask[i][j] = 0;
					}
				} else {
					mask[i][j] = -1;
				}
			}
		}

	}
}
