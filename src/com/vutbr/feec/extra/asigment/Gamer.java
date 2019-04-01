package com.vutbr.feec.extra.asigment;

import java.util.Random;

public class Gamer extends Npc {

	private String nickname;
	private int money;

	public Gamer(int id, String name, int hp, String nickname, int money) {
		super(id, name, hp);
		this.nickname = nickname;
		this.money = money;

	}

	public int damage() {
		Random rand = new Random();
		int dmg = rand.nextInt(40);
		dmg = dmg + 1;
		while (dmg < 25) {
			dmg = rand.nextInt(40);
			dmg = dmg + 1;
		}
		return dmg;
	}

	@Override
	public String toString() {
		return "Gamer [nickname=" + nickname + ", money=" + money + "]";
	}

	public void moneyBalance() {
		System.out.println("Hmmm look.\nI have " + money + " silvers");
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
