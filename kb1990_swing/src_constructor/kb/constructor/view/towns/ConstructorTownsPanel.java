package kb.constructor.view.towns;

import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;

import ru.reizy.kb1990.model.constructor.ConstructorCastles;
import ru.reizy.kb1990.model.constructor.ConstructorModel;
import ru.reizy.kb1990.model.globalmap.Cell;

public class ConstructorTownsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ConstructorTownsTableModel tm;
	private ConstructorModel model;
	private JComboBox<String> bx;

	public ConstructorTownsPanel(ConstructorModel model) {
		this.model = model;
		table = new JTable(10, 10);
		tm = new ConstructorTownsTableModel(model.getTowns());
		table.setModel(tm);
		bx = new JComboBox<String>();
		table.getColumnModel()
				.getColumn(ConstructorTownsTableModel.CASTLE_INDEX)
				.setCellEditor(new DefaultCellEditor(bx));
		table.setColumnSelectionAllowed(true);

		add(table);
	}

	@Override
	public void repaint() {
		if (tm != null) {
			tm.updateTable();
		}
		generateBox();
		super.repaint();
	}

	private void generateBox() {
		if (model != null) {
			final ConstructorCastles castles = model.getCastles();
			if (castles != null) {
				final Map<Cell, String> castles2 = castles.getCastles();
				if (castles2 != null) {
					bx.removeAllItems();
					bx.addItem("");
					for (Entry<Cell, String> e : castles2.entrySet()) {
						bx.addItem(e.getValue());
					}
				}
			}
		}
	}
}
