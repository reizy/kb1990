package ru.reizy.kb1990.view.swing.prototype;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.KBViewInterface;

public abstract class KBGlobalViewPanel extends JPanel implements
		KBViewInterface {

	private static final long serialVersionUID = 1L;

	@Override
	public abstract void onEvent(KBEvent event);

	protected static String[] drawTextByWords(final String s, final int LENGTH) {
		return drawTextByWords(s, LENGTH, "", "");
	}

	protected static String[] drawTextByWords(final String s, final int LENGTH,
			String STMP1, String STMP) {
		final ArrayList<String> r = new ArrayList<String>();
		String tmp = "";
		String next = "";
		ArrayList<String> words = new ArrayList<String>();
		words.addAll(Arrays.asList(s.split(" ")));
		for (int i = 0; i <= words.size(); i++) {
			tmp += next;
			if (i < words.size()) {
				next = words.get(i);
			} else {
				next = "";
			}
			if (((tmp.length() + next.length() + 1) > LENGTH)
					|| (i == words.size())) {
				if (i < words.size()) {
					tmp = stretchOnWidth(tmp, LENGTH);
				}
				r.add(tmp);
				tmp = STMP;
			} else {
				if (i > 0) {
					tmp += " ";
				}
			}
		}
		return r.toArray(new String[0]);
	}

	protected static String stretchOnWidth(String s, final int w) {
		ArrayList<String> words = new ArrayList<String>();
		int dw = w - s.length();
		words.addAll(Arrays.asList(s.split(" ")));
		s = "";
		for (int i = 0; i < words.size(); i++) {
			if (i > 0) {
				s += " ";
			}
			s += words.get(i);
			if ((!words.get(i).equals("")) && (dw > 0)) {
				s += " ";
				dw--;
				if (dw > (words.size() - 2 - i)) {
					s += " ";
					dw--;
				}
				if (dw > 2 * (words.size() - 2 - i)) {
					s += " ";
					dw--;
				}
			}
		}
		return s;
	}
}
