package com.vutbr.feec.extra.asigment;

import java.util.Random;

public class Npc {
	private int id;
	private String name;
	private int hp;

	public Npc(int id, String name, int hp) {
		this.id = id;
		this.name = name;
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String whoAmI() {
		return "Hi my name is " + name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

// hp generator
	public int randomHp() {
		Random rand = new Random();
		int n = rand.nextInt(50);
		n = n + 1;
		while (n < 20) {
			n = rand.nextInt(50);
			n = n + 1;
		}
		return n;
	}
}
