package ru.reizy.kb1990.model.globalmap;


public interface Content {

	Cell getCell();

	boolean onActivate(GlobalPlayer player);
}
