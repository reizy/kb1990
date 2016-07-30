package ru.reizy.kb1990;

import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;

public interface KBModelI {

	GlobalMapI getGlobalMap();

	BattleModelI getBattleModel();

	GlobalPlayerI getGlobalPlayer();

	void clearViews();

	void onEvent(KBEvent event);

	void addView(KBViewInterface view);

	void removeView(KBViewInterface view);

	void openMap(GlobalMap map);
}
