package kb.constructor.view.castles;

import javax.swing.JPanel;
import javax.swing.JTable;

import ru.reizy.kb1990.model.constructor.ConstructorModel;

public class ConstructorCastlesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ConstructorCastlesTableModel tm;

	public ConstructorCastlesPanel(ConstructorModel model) {
		table = new JTable(10, 10);
		tm = new ConstructorCastlesTableModel(model.getCastles());
		table.setModel(tm);
		add(table);
	}

	@Override
	public void repaint() {
		if (tm != null) {
			tm.updateTable();
		}
		super.repaint();
	}
}
