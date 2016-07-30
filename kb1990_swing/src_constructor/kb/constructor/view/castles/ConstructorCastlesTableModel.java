package kb.constructor.view.castles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import ru.reizy.kb1990.model.constructor.ConstructorCastles;
import ru.reizy.kb1990.model.globalmap.Cell;

public class ConstructorCastlesTableModel implements TableModel {

	private static final int X_COL_INDEX = 0;
	private static final int Y_COL_INDEX = 1;
	private static final int NAME_COL_INDEX = 2;
	private static final int IS_ON_MAP_COL_INDEX = 3;
	private final String[] colNames = { "X", "Y", "Name", "Is on map" };
	private final List<Row> values = new ArrayList<Row>();
	private final ConstructorCastles model;

	ConstructorCastlesTableModel(ConstructorCastles model) {
		this.model = model;
	}

	@Override
	public int getRowCount() {
		return values.size() + 1;
	}

	@Override
	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return colNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		boolean b;
		b = rowIndex > 0;
		b &= columnIndex == NAME_COL_INDEX;
		return b;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object s;
		if (rowIndex > 0) {
			Row r = values.get(rowIndex - 1);
			switch (columnIndex) {
			case X_COL_INDEX:
				s = r.x;
				break;
			case Y_COL_INDEX:
				s = r.y;
				break;
			case IS_ON_MAP_COL_INDEX:
				s = r.isOnMap;
				break;
			default:
				s = r.name;
				break;
			}
		} else {
			s = colNames[columnIndex];
		}
		return s;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Row r = values.get(rowIndex - 1);
		changeName(r.x, r.y, aValue.toString());
	}

	private void changeName(Integer x, Integer y, String name) {
		if (name.length() == 0) {
			model.removeCastle(x, y);
		} else {
			model.setCastle(x, y, name);
		}
		updateTable();
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	private void addRow(int x, int y, String name, boolean isOnMap) {
		Row s = new Row(x, y, name, isOnMap);
		values.add(s);
	}

	public void updateTable() {
		Set<Cell> realCell = model.getMapCastlesSet();
		values.clear();
		for (Entry<Cell, String> e : model.getCastles().entrySet()) {
			addRow(//
			e.getKey().getX(), //
					e.getKey().getY(), //
					e.getValue(),//
					realCell.remove(e.getKey()));
		}
		for (Cell e : realCell) {
			addRow(e.getX(), e.getY(), "", true);
		}
	}

	private class Row {
		Integer x;
		Integer y;
		String name;
		Boolean isOnMap;

		private Row(Integer x, Integer y, String name, Boolean isOnMap) {
			super();
			this.x = x;
			this.y = y;
			this.name = name;
			this.isOnMap = isOnMap;
		}

	}
}
