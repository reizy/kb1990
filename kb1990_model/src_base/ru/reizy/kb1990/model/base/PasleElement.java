package ru.reizy.kb1990.model.base;


public interface PasleElement {
	public static final int PASLE_H = 5;
	public static final int PASLE_W = 5;

	void activate(Player player);

	int getPasleX();

	int getPasleY();

}
