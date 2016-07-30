package kb.globalmap.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.swing.prototype.KBControlPanel;

public class MapControlPanel extends KBControlPanel {
	private static final long serialVersionUID = -8196121417584034475L;

	private final KBModel model;

	MapControlPanel(final KBModel model, final MapFieldPanel view,
			final MapView mapTab, final KBGlobalViewI gView) {
		super(5, 7);
		this.model = model;
		setButton(false, 0, "Показать всю карту", "", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (model.getGlobalMap().hasFullMap()) {
					view.setMasked(!view.isMasked());
					update();
					mapTab.update();
				}
			}
		});
		setButton(true, 4, "E", "Выход", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gView.toGlobalMap();
			}
		});
		update();
	}

	@Override
	public void update() {
		updateControlsL(model.getGlobalMap().hasFullMap());
	}
}
