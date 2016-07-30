package ru.reizy.kb1990.model.base;


/**
 * Герой - это предводитель армии, который: - имеет ограничение по лидерству и
 * может быть предан - имеет модификаторы атаки, защиты, навыка [отрядов в бою]
 * - имеет деньги
 * 
 * 
 */
public class Hero extends ArmyHolder {

	public static final int MAX_LEADERSHIP = 65000;
	private int leadership;
	private double attack = 1.0;
	private double defence = 1.0;
	private double attackSkill = 0.0;
	private int money = 0;
	private int rank = 0;

	public Hero() {
	}

	public Hero(int rank, int leadership) {
		this.setRank(rank);
		this.leadership = leadership;
	}

	public int getRank() {
		return rank;
	}

	public int getLeadership() {
		if (leadership > MAX_LEADERSHIP) {
			return MAX_LEADERSHIP;
		} else {
			return leadership;
		}
	}

	public void setLeadership(int leadership) {
		this.leadership = leadership;
	}

	public double getAttack() {
		return attack;
	}

	public double getDefence() {
		return defence;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	public void setDefence(double defence) {
		this.defence = defence;
	}

	public int getMoney() {
		return money;
	}

	public void addMoney(int money) {
		this.money += money;
	}

	public double getAttackSkill() {
		return attackSkill;
	}

	public void setAttackSkill(double skill) {
		this.attackSkill = skill;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
