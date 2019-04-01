package com.vutbr.feec.extra.asigment;

import java.util.Random;
import java.util.Scanner;

public class Boss extends Monster {
	private String specialSkill;

	public Boss(int id, String name, int hp, String[] skills) {
		super(id, name, hp, skills);
		switch (id) {
		// Frint sea beach
		case 1:
			this.specialSkill = "Sand whirpool";
			this.setName("The crab of Frint beach \"Crabson\"");
			String[] array1 = { "Right claw punch", "Left punch punch", "Jump", "Sand throw" };
			this.setSkills(array1);
			break;
		// Dorangon's beach
		case 2:
			this.specialSkill = "Fire of The death";
			this.setName("Majestic Dragon \"Dorangon\"");
			String[] array2 = { "Fire ball", "Wings wind stream", "Claws whirlwind", "Tail whip" };
			this.setSkills(array2);
			break;
		// The Maelstrom whirlpool
		case 3:
			this.specialSkill = "Air, Fire, Water, Earth magic breath";
			this.setName("King of the Sea \"Hydra\"");
			String[] array3 = { "Multiple heads bite", "Neck whip", "Water ball", "Whirpool", "Leave" };
			this.setSkills(array3);
			break;
		}

	}

	// method for what do you want in the location and return player decision
	public int whatYouWant(Boss boss, Gamer gamer) {
		String[] optionsArray = { "Fight ", "Disapere to next location " };
		String[] optionsArray1 = { "Fight ", "Move back " };
		String name = boss.getName();
		int option = 0;
		int help = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("You are find " + name + " what you want to do: ");
		if (boss.getId() == 3) {
			for (int i = 0; i < optionsArray.length; i++) {
				System.out.println(optionsArray1[i] + "[input " + (i + 1) + "]");
			}
		} else {
			for (int i = 0; i < optionsArray.length; i++) {
				System.out.println(optionsArray[i] + "[input " + (i + 1) + "]");
			}
		}
		while (true) {
			option = sc.nextInt();
			if (option == 1) {
				help = boss.bossFight(boss, gamer);
				return help;

			} else if (option == 2) {
				if (boss.getId() == 3) {
					return -2;
				} else {
					return 0;
				}
			} else {
				System.out.println("Wrong input enter again");
			}
		}

	}

	// every move for boss fight
	public int bossFight(Boss boss, Gamer gamer) {
		String name = boss.getName();
		boolean flag = false;
		int help;
		int helpDmg;
		int helpHp;
		int helpDrop;
		while (true) {
			// Player attack
			helpHp = boss.getHp();
			helpDmg = gamer.damage();
			helpHp = helpHp - helpDmg;
			System.out.println(gamer.getNickname() + " attacking");
			System.out.println(gamer.getNickname() + " deal damage " + helpDmg);
			boss.setHp(helpHp);
			if (boss.getHp() <= 0) {
				helpDrop = boss.randomDrop();
				System.out.println("You have kill " + name + " and " + name + " dropped " + helpDrop + " silvers");
				help = gamer.getMoney();
				helpDrop = helpDrop + help;
				gamer.setMoney(helpDrop);
				return helpDrop;
			} else if (boss.getHp() <= 25) {
				flag = true;
			}

			// boss attack
			helpHp = gamer.getHp();
			if (flag == true) {
				System.out.println("The " + name + " use rage skill " + this.getSpecialSkill());
				helpDmg = boss.damage() * 2;
			} else {
				help = boss.usedSkill(boss.numberOfSkills());
				helpDmg = boss.damage();
			}
			System.out.println(name + " deal damage " + helpDmg);
			helpHp = helpHp - helpDmg;
			gamer.setHp(helpHp);
			if (gamer.getHp() <= 0) {
				System.out.println("You have die");
				gamer.whoAmI();
				return -1;
			}
		}

	}

	// method for boss dmg + critical dmg
	public int damage() {
		Random rand = new Random();
		int dmg = rand.nextInt(31);
		dmg = dmg + 1;
		if (dmg < 3) {
			dmg = rand.nextInt(31);
			dmg = dmg + 1;
			dmg = dmg * 2;
			return dmg;
		}
		while (dmg < 11) {
			dmg = rand.nextInt(31);
			dmg = dmg + 1;
		}
		return dmg;
	}

	// method for boss drop 33+
	@Override
	public int randomDrop() {
		Random rand = new Random();
		int n = rand.nextInt(11);
		n = n + 1;
		n = n * 7;
		while (n < 34) {
			n = rand.nextInt(11);
			n = n + 1;
			n = n * 7;
		}
		return n;
	}

	public String getSpecialSkill() {
		return specialSkill;
	}

	public void setSpecialSkill(String specialSkill) {
		this.specialSkill = specialSkill;
	}

}
