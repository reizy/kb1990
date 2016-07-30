package kb.constructor.view.signposts;

import javax.swing.JPanel;
import javax.swing.JTable;

import ru.reizy.kb1990.model.constructor.ConstructorModel;

public class ConstructorSignPostsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ConstructorSignPostsTableModel tm;


	public ConstructorSignPostsPanel(ConstructorModel model) {
		table = new JTable(10, 10);
		tm = new ConstructorSignPostsTableModel(model.getSignPosts());
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
