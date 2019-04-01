package com.vutbr.feec.extra.asigment;

import java.util.Random;
import java.util.Scanner;

public class Casual extends Monster {

	public Casual(int id, String name, int hp, String[] skills) {
		super(id, name, hp, skills);
		switch (id) {
		// Water
		case 1:
			this.setName("Ascot Crab");
			String[] array1 = { "Claw", "Sand" };
			this.setSkills(array1);
			break;
		// water
		case 2:
			this.setName("Sahuagin");
			String[] array6 = { "Spear throw", "Spear charge" };
			this.setSkills(array6);
			break;
		// forest
		case 3:
			this.setName("Brier Weasel");
			String[] array2 = { "Jump", "Bite", "Tail" };
			this.setSkills(array2);
			break;
		// forest
		case 4:
			this.setName("Boar");
			String[] array4 = { "Rushing tusk", "Kick", "Charge" };
			this.setSkills(array4);
			break;
		// forest
		case 5:
			this.setName("Triffid");
			String[] array9 = { "Venom spit", "Venom whip" };
			this.setSkills(array9);
			break;
		// forest hill
		case 6:
			this.setName("Dire Wolf");
			String[] array10 = { "Bite", "Claw", "Charge" };
			this.setSkills(array10);
			break;
		// hill and caves
		case 7:
			this.setName("Goblin");
			String[] array3 = { "Poison", "Knife" };
			this.setSkills(array3);
			break;

		// hill
		case 8:
			this.setName("Ogre");
			String[] array5 = { "Wind magic", "Long sword" };
			this.setSkills(array5);
			break;
		// hill
		case 9:
			this.setName("Wyvern");
			String[] array8 = { "Lightning magic bolt", "Ice flames", "Fire ball" };
			this.setSkills(array8);
			break;
		// dungeons
		case 10:
			this.setName("Skeleton");
			String[] array7 = { "The undeath magic", "Sword charge", "Mirage" };
			this.setSkills(array7);
			break;

		}

	}

	// method for what do you want in the location and return player decision
	public int whatYouWant(Casual casual, Gamer gamer) {
		String[] optionsArray = { "Fight ", "Qietly move to next location " };
		String name = casual.getName();
		int option = 0;
		int help = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("You see " + name + " what you want to do: ");
		for (int i = 0; i < optionsArray.length; i++) {
			System.out.println(optionsArray[i] + "[input " + (i + 1) + "]");
		}
		// option <= 0 || option > 0
		while (true) {
			option = sc.nextInt();
			if (option == 1) {
				help = casual.fight(casual, gamer);
				return help;

			} else if (option == 2) {
				return 0;
			} else {
				System.out.println("Wrong input enter again");
			}
		}

	}

	// every move for fight
	public int fight(Casual casual, Gamer gamer) {
		String name = casual.getName();
		int help;
		int helpDmg;
		int helpHp;
		int helpDrop;
		while (true) {
			// Player attack
			helpHp = casual.getHp();
			helpDmg = gamer.damage();
			helpHp = helpHp - helpDmg;
			System.out.println(gamer.getNickname() + " attacking ");
			System.out.println(gamer.getNickname() + " deal damage " + helpDmg);
			casual.setHp(helpHp);
			if (casual.getHp() <= 0) {
				helpDrop = casual.randomDrop();
				System.out.println("You have kill " + name + " and " + name + " dropped " + helpDrop + " silvers");
				help = gamer.getMoney();
				helpDrop = helpDrop + help;
				gamer.setMoney(helpDrop);
				return helpDrop;
			}

			// boss attack
			helpHp = gamer.getHp();

			casual.usedSkill(casual.numberOfSkills());
			helpDmg = casual.damage();
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

	// method for dmg
	public int damage() {
		Random rand = new Random();
		int dmg = rand.nextInt(13);
		dmg = dmg + 1;
		return dmg;
	}

	// method for boss drop 33
	@Override
	public int randomDrop() {
		Random rand = new Random();
		int n = rand.nextInt(5);
		n = n * 2;
		return n;
	}

}
