package com.vutbr.feec.extra.asigment;

import java.util.Random;

public class Monster extends Npc {
	private String[] skills;

	public Monster(int id, String name, int hp, String[] skills) {
		super(id, name, hp);
		this.skills = skills;
		// TODO Auto-generated constructor stub
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	// print which skill monster use and return skill number
	public int usedSkill(int numberOfSkills) {
		String[] helpSkills = this.getSkills();
		Random rand = new Random();
		int n = rand.nextInt(numberOfSkills);
		System.out.println("The " + this.getName() + " use " + helpSkills[n]);
		return n;
	}

	// number of skills in array
	public int numberOfSkills() {
		String[] helpSkills = this.getSkills();
		return helpSkills.length;
	}

	// for drop money 4+
	public int randomDrop() {
		Random rand = new Random();
		int n = rand.nextInt(7);
		n = n + 1;
		n = n * 3;
		while (n < 5) {
			n = rand.nextInt(7);
			n = n + 1;
			n = n * 3;
		}
		return n;
	}

}
