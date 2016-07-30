package ru.reizy.kb1990.view.swing;

import java.util.HashMap;
import java.util.Map;

public class FontZooms {
	private static final Map<Integer, FontZooms> list;
	public final int heigth;
	public final int widht;
	public final int size;

	private FontZooms(int size, int heigth, int widht) {
		super();
		this.heigth = heigth;
		this.widht = widht;
		this.size = size;

	}

	private static void add(int s, int h, int w) {
		list.put(s, new FontZooms(s, h, w));
	}

	static {
		list = new HashMap<Integer, FontZooms>();
		add(24, 20, 16);
		add(23, 18, 15);
		add(20, 16, 13);
		add(19, 17, 13);
		add(18, 14, 12);
		add(16, 14, 10);
		add(14, 14, 8);
		add(12, 10, 8);
		add(11, 9, 7);
		add(9, 8, 6);
	}

	public static FontZooms get(int s) {
		FontZooms z = list.get(s);
		int i = -1;
		while (z == null) {
			s += i;
			z = list.get(s);
			if (s < 1) {
				i *= -1;
			}
		}
		return list.get(s);
	}
}
