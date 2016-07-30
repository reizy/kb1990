package kb.globalmap.view;

import static ru.reizy.kb1990.view.swing.KBResources.FONT;

import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.JPanel;

import kb.globalmap.controller.MapFieldClickListener;
import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.events.GlobalPlayerMoveEvent;
import ru.reizy.kb1990.model.globalmap.events.ResidenceOutEvent;
import ru.reizy.kb1990.model.globalmap.events.ShowContractEvent;
import ru.reizy.kb1990.model.globalmap.events.TravelSpellActivatinoEvent;
import ru.reizy.kb1990.model.globalmap.events.TreasureActivateEvent;
import ru.reizy.kb1990.view.KBGlobalViewI;
import ru.reizy.kb1990.view.events.ShowGlobalMapEvent;
import ru.reizy.kb1990.view.swing.NameResolver;
import ru.reizy.kb1990.view.swing.prototype.KBTabPanel;

public class MapView extends KBTabPanel {
	private static final long serialVersionUID = 7906405279378066763L;

	private final KBModel model;
	private final MapFieldPanel panelF;
	private final MapControlPanel panelС;
	private final Label mapName;
	private final Label playerPosition;

	public MapView(final KBModel model, final KBGlobalViewI gView) {
		super();
		setLayout(new BorderLayout());
		this.model = model;

		JPanel central = new JPanel(new BorderLayout());
		add(central, BorderLayout.WEST);
		panelF = new MapFieldPanel(model, this);
		central.add(panelF);

		mapName = new Label();
		mapName.setFont(FONT);
		central.add(mapName, BorderLayout.NORTH);
		playerPosition = new Label();
		playerPosition.setFont(FONT);
		central.add(playerPosition, BorderLayout.SOUTH);

		panelF.addMouseListener(new MapFieldClickListener(model));

		panelС = new MapControlPanel(model, panelF, this, gView);
		add(panelС);

		update();

	}

	public void update() {
		panelF.fillField();
		panelF.drawPlayer(3);
		panelС.update();
		mapName.setText(NameResolver.getContinentName(model.getGlobalMap()));
		Cell c = model.getGlobalPlayer().getCell();
		playerPosition.setText("X=" + c.getX() + " Позиция Y=" + c.getY());
		repaint();
	}

	public void updateAndActivate() {
		activatePanel();
		update();
	}

	@Override
	public void onEvent(KBEvent event) {
		if (event instanceof GlobalPlayerMoveEvent) {
			update();
		} else if (event instanceof TravelSpellActivatinoEvent) {
			update();
		} else if (event instanceof ShowGlobalMapEvent) {
			update();
		} else if (event instanceof ResidenceOutEvent) {
			update();
		} else if (event instanceof ShowContractEvent) {
			update();
		} else if (event instanceof TreasureActivateEvent) {
			update();
		}
	}
}
