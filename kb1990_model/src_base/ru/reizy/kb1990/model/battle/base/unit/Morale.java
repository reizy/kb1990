package ru.reizy.kb1990.model.battle.base.unit;

public final class Morale {
	public static final int MORALE_LOW = 0;
	public static final int MORALE_NORM = 1;
	public static final int MORALE_HIGH = 2;
	public static final int L = MORALE_LOW;
	public static final int N = MORALE_NORM;
	public static final int H = MORALE_HIGH;
	private static final int[][] MORAL_CHART = //
	{/*---*/{ N, N, N, N, N }, //
			{ N, N, N, N, N }, //
			{ N, N, H, N, N }, //
			{ L, N, L, H, N }, //
			{ L, L, L, N, N } //
	};

	private Morale() {
	}

	public static int check(final UnitType other, final UnitType that) {
		return MORAL_CHART[other.getRace() - 1][that.getRace() - 1];
	}
}
