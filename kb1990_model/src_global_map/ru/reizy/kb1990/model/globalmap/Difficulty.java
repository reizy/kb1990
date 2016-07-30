package ru.reizy.kb1990.model.globalmap;

public enum Difficulty {
	EASY(900, 0.5f), NORMAL(600, 1.0f), DIFFICULT(400, 2.0f), IMPOSIBLE(200, 4.0f);

	private final int days;
	private final float scoreMultiplier;

	private Difficulty(int days, float scoreMultiplier) {
		this.days = days;
		this.scoreMultiplier = scoreMultiplier;
	}

	/**
	 * @return the days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * @return the scoreMultiplier
	 */
	public float getScoreMultiplier() {
		return scoreMultiplier;
	}

}
