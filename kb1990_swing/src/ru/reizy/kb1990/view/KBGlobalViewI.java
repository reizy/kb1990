package ru.reizy.kb1990.view;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;
import ru.reizy.kb1990.view.swing.prototype.KBTabPanel;

public interface KBGlobalViewI extends KBViewInterface {

	void toNext();

	void showMessage(String s);

	void toGlobalMap();

	void addTab(String string, KBTabPanel tab);

	KBModel getModel();

	void setNext(KBTabPanel tab);

}
