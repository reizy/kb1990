package ru.reizy.kb1990.model.globalmap.residence;

import ru.reizy.kb1990.model.base.Player;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.events.ResidenceInEvent;

/*Славный супермаг Авранж обучит вас секретам волшебства за 5000 золотых. Принять (y/n)?*/
public class MageResidence extends Residence implements Bonus {
	public static enum BuyStatus {
		NO_MONEY, SUCCESFULL
	}

	private static final int PRICE = 5000;

	public MageResidence(UnitTypes unit, Cell cell) {
		super(cell);
	}

	public BuyStatus buy(final Player p) {
		BuyStatus r;
		final int price = getPrice();
		if (p.getMoney() >= price) {
			p.setMagicActive(true);
			p.addMoney(-price);
			r = BuyStatus.SUCCESFULL;
		} else {
			r = BuyStatus.NO_MONEY;
		}
		return r;
	}

	@Override
	public boolean onActivate(GlobalPlayer player) {
		player.setActiveContentCell(getCell());
		setOutCell(player.getCell());
		player.getActiveMap().onEvent(new ResidenceInEvent(this));
		return true;
	}

	public int getPrice() {
		return PRICE;
	}
}
