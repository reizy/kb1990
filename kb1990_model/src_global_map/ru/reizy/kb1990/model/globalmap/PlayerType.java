package ru.reizy.kb1990.model.globalmap;

public enum PlayerType {

	KNIGHT(0, 2, 8, 14,// xp
			100, 100, 300, 500,// leadership
			2, 3, 4, 6,// spellCapasity
			false, 1, 1, 1, 2,// spellPower
			1000, 1000, 2000, 4000), // commission
	PALADIN(0, 2, 7, 13,// xp
			80, 80, 240, 400,// leadership
			3, 3, 5, 6,// spellCapasity
			false, 1, 1, 2, 2,// spellPower
			1000, 1000, 2000, 4000), // commission
	BARBARIAN(0, 1, 5, 10,// xp
			100, 100, 300, 500,// leadership
			2, 2, 3, 3,// spellCapasity
			false, 0, 1, 1, 1,// spellPower
			2000, 2000, 2000, 2000), // commission
	SORCERESS(0, 3, 6, 12,// xp
			60, 60, 180, 300,// leadership
			5, 8, 10, 12,// spellCapasity
			true, 2, 3, 5, 5,// spellPower
			3000, 1000, 1000, 1000); // commission;

	public final static int MAX_RANK = 3;

	private final int[] xp;
	private final int[] leadership;
	private final int[] spellCapasity;
	private final boolean magican;
	private final int[] spellPower;
	private final int[] commission;

	private PlayerType(int xp1, int xp2, int xp3, int xp4,//
			int leadership1, int leadership2, int leadership3, int leadership4,//
			int spellCapasity1, int spellCapasity2, int spellCapasity3, int spellCapasity4, //
			boolean magican,//
			int spellPower1, int spellPower2, int spellPower3, int spellPower4, //
			int commission1, int commission2, int commission3, int commission4) {
		int[] xp = { xp1, xp2, xp3, xp4 };
		int[] leadership = { leadership1, leadership2, leadership3, leadership4 };
		int[] spellCapasity = { spellCapasity1, spellCapasity2, spellCapasity3, spellCapasity4 };
		int[] spellPower = { spellPower1, spellPower2, spellPower3, spellPower4 };
		int[] commission = { commission1, commission2, commission3, commission4 };
		this.xp = xp;
		this.leadership = leadership;
		this.spellCapasity = spellCapasity;
		this.magican = magican;
		this.spellPower = spellPower;
		this.commission = commission;
	}

	public int[] getCommission() {
		return commission;
	}

	public int[] getXp() {
		return xp;
	}

	public int[] getLeadership() {
		return leadership;
	}

	public boolean isMagican() {
		return magican;
	}

	public int[] getSpellPower() {
		return spellPower;
	}

	public int[] getSpellCapasity() {
		return spellCapasity;
	}
}
