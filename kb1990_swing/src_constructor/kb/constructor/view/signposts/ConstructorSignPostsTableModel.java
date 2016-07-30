package kb.constructor.view.signposts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import ru.reizy.kb1990.model.constructor.ConstructorSignPosts;
import ru.reizy.kb1990.model.globalmap.Cell;

public class ConstructorSignPostsTableModel implements TableModel {

	private static final int X_COL_INDEX = 0;
	private static final int Y_COL_INDEX = 1;
	private static final int NAME_COL_INDEX = 2;
	private static final int IS_ON_MAP_COL_INDEX = 3;

	private final String[] colNames = { "X", "Y", "Name", "Is on map" };
	private final List<Row> values = new ArrayList<Row>();
	private final ConstructorSignPosts model;

	ConstructorSignPostsTableModel(ConstructorSignPosts constructorSignPosts) {
		this.model = constructorSignPosts;
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
			model.removeSignPost(x, y);
		} else {
			model.setSignPost(x, y, name);
			System.out.println(x + " " + y + " " + name);
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
		Set<Cell> cells = new TreeSet<Cell>();
		values.clear();
		final Set<Cell> realCell = model.getMapSignPostsSet();
		final Map<Cell, String> signPosts = model.getSignPosts();
		cells.addAll(realCell);
		cells.addAll(signPosts.keySet());

		for (Cell e : cells) {
			addRow(e.getX(), e.getY(), signPosts.get(e), realCell.contains(e));
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
