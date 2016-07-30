package ru.reizy.kb1990.view.swing.globalmap.view;

public enum TroopsCount {
	A_FEW, SOME, MANY, A_LOT, A_HORDE, A_MULTITUDE;

	public static TroopsCount get(int count) {
		if (count <= 9) {
			return A_FEW;
		} else if (count <= 19) {
			return SOME;
		} else if (count <= 49) {
			return MANY;
		} else if (count <= 99) {
			return A_LOT;
		} else if (count <= 499) {
			return A_HORDE;
		} else {
			return A_MULTITUDE;
		}
	}

}
