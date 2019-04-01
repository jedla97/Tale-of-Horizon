package com.vutbr.feec.extra.asigment;

import java.util.Random;
import java.util.Scanner;

public class Adventure extends Person {
	private String[] weapons;
	private String[] attacks;

	public Adventure(int id, String name, int hp, int age, String calling, String[] options) {
		super(id, name, hp, age, calling, options);
		Random rand = new Random();
		String[] nameArray = { "Naotsugu", "Minori", "Isuzu", "Shiroe", "Akatsuki", "Nyanta", "Krusty", "Isaac",
				"Maryelle", "Charasin", "Michitaka" };
		String[] weapon = { "spear", "mace", "sword", "dagger", "axe" };
		String[] attack = { "fire ball", "ice ball", "throw", "left stroke", "right stroke" };

		switch (id) {
		case 1:
			String[] array1 = { "Have some meaninfull conversation", "Get some travel tips", "Say hi" };
			this.setName(nameArray[rand.nextInt(11)]);
			this.setOptions(array1);
			this.setAttacks(attack);
			this.setWeapons(weapon);
			break;
		case 2:
			String[] array2 = { "Get some travel tips", "Start fight him", "Say hi" };
			this.setName(nameArray[rand.nextInt(11)]);
			this.setOptions(array2);
			this.setAttacks(attack);
			this.setWeapons(weapon);
			break;
		case 3:
			String[] array3 = { "Fight back", "Be a coward and runaway" };
			this.setName(nameArray[rand.nextInt(11)]);
			this.setOptions(array3);
			this.setAttacks(attack);
			this.setWeapons(weapon);
			break;
		}

	}

	public int whatYouWant(Adventure adventure, Gamer gamer, MapDatabase data, int mapId) {

		Random rand = new Random();
		int option, taskId, help1, helpId;
		helpId = adventure.getId();
		switch (helpId) {
		case 1:
			taskId = 0;
			System.out.println("You sea someone on the your way\n");
			while (true) {
				option = adventure.printOptions(adventure.numberOfOptions(), taskId);
				if (option == 1) {
					int help = rand.nextInt(6);
					if (help == 0) {
						System.out.println("Today is nice weather\n");
					} else if (help == 1) {
						System.out.println("On long journy need something to eat\n");
					} else if (help == 2) {
						System.out.println("You can rest only on safe place\n");
					} else if (help == 3) {
						System.out.println("My name is " + adventure.getName() + "\n");
					} else if (help == 4) {
						System.out.println("I'm " + adventure.getAge() + " years old\n");
					} else if (help == 5) {
						System.out.println("I'm the " + adventure.getCalling() + "\n");
					}
					taskId++;
				} else if (option == 2) {
					int help = rand.nextInt(3);
					if (help == 0) {
						System.out.println("You are in " + data.vypisMapName(mapId) + " area\n");
					} else if (help == 1) {
						System.out.println("The air is feeling uneasy\n");
					} else if (help == 2) {
						System.out.println(
								"In " + data.vypisMapName(rand.nextInt(17)) + " is some monster ready to be slay\n");
					}
					taskId++;
				} else if (option == 3) {
					if (taskId > 0) {
						System.out.println("Let the luck is with you friend\n");
					} else {
						System.out.println("Hello\n");
					}
					return 0;
				}
			}
		case 2:
			taskId = 0;
			System.out.println("You sea someone on the your way\n");
			while (true) {
				option = adventure.printOptions(adventure.numberOfOptions(), taskId);
				if (option == 1) {
					int help = rand.nextInt(3);
					if (help == 0) {
						System.out.println("You are in " + data.vypisMapName(mapId) + " area\n");
					} else if (help == 1) {
						System.out.println("The air is feeling uneasy\n");
					} else if (help == 2) {
						System.out.println(
								"In " + data.vypisMapName(rand.nextInt(17)) + " is some monster ready to be slay\n");
					}
					taskId++;
				} else if (option == 2) {
					help1 = adventure.Fight(adventure, gamer, 0, false);
					if (help1 == -1) {
						return -1;// for death player
					} else {
						return 0;
					}
				} else if (option == 3) {
					if (taskId > 0) {
						System.out.println("Let the luck is with you friend\n");
					} else {
						System.out.println("Hello\n");
					}
					return 0;
				}
			}
		case 3:
			boolean flag = true;
			String[] weapons = adventure.getWeapons();
			int weapon = this.chooseWeapon(adventure);
			System.out.println("Dangerous adventurer rush against you with " + weapons[weapon] + " in his hands\n");
			while (true) {
				option = adventure.printOptions(adventure.numberOfOptions(), 0);
				if (option == 1) {
					help1 = adventure.Fight(adventure, gamer, weapon, flag);
					if (help1 == -1) {
						return -1;// for death player
					} else {
						return 0;
					}
				} else if (option == 2) {
					System.out.println("Wait you coward\n");
					return 0;
				}
			}

		}
		return 0;
	}

	@Override
	public int printOptions(int numberOfOptions, int taskId) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int option;
		String[] helpOptions = this.getOptions();
		if (taskId == 0) {
		} else {
			System.out.println("need something else: ");
		}
		for (int i = 0; i < numberOfOptions; i++) {
			System.out.println(helpOptions[i] + " [input " + (i + 1) + "]");
		}
		while (true) {
			option = sc.nextInt();
			if (option >= 1 && option < numberOfOptions + 1) {
				return option;
			} else {
				System.out.println("Wrong input enter again");
			}

		}
	}

	public int Fight(Adventure adventure, Gamer gamer, int weaponNumber, boolean flag) {
		String name = adventure.getCalling();
		int help;
		if (flag == true) {
			help = weaponNumber;
		} else {
			help = adventure.chooseWeapon(adventure);
		}
		int helpDmg;
		int helpHp;
		int helpDrop;
		while (true) {
			// Player attack
			helpHp = adventure.getHp();
			helpDmg = gamer.damage();
			helpHp = helpHp - helpDmg;
			adventure.setHp(helpHp);
			System.out.println(gamer.getNickname() + " attacking ");
			System.out.println(gamer.getNickname() + " deal damage " + helpDmg);
			if (adventure.getHp() <= 0) {
				helpDrop = adventure.randomDrop();
				System.out.println("You have kill " + name + " and " + name + " dropped " + helpDrop + " silvers");
				help = gamer.getMoney();
				helpDrop = helpDrop + help;
				gamer.setMoney(helpDrop);
				return helpDrop;
			}

			// boss attack
			helpHp = gamer.getHp();
			adventure.usedAttack(adventure, help);
			helpDmg = adventure.damage();
			System.out.println(adventure.getCalling() + " deal damage " + helpDmg);
			helpHp = helpHp - helpDmg;
			gamer.setHp(helpHp);
			if (gamer.getHp() <= 0) {
				System.out.println("You have die");
				gamer.whoAmI();
				return -1;
			}
		}

	}

	public int chooseWeapon(Adventure adventure) {
		Random rand = new Random();
		return rand.nextInt(adventure.getWeapons().length);
	}

	public void usedAttack(Adventure adventure, int weapon) {
		String[] helpAttack = adventure.getAttacks();
		String[] helpWeapon = adventure.getWeapons();
		Random rand = new Random();
		int n = rand.nextInt(adventure.getAttacks().length);
		System.out.println("The " + adventure.getCalling() + " use " + helpWeapon[weapon] + " " + helpAttack[n]);

	}

	// method for dmg
	public int damage() {
		Random rand = new Random();
		int dmg = rand.nextInt(41);
		dmg = dmg + 1;
		while (dmg > 17) {
			dmg = rand.nextInt(41);
			dmg = dmg + 1;
		}
		return dmg;
	}

	// method for drop
	public int randomDrop() {
		Random rand = new Random();
		int n = rand.nextInt(7);
		n = n * 5;
		return n;
	}

	public String[] getWeapons() {
		return weapons;
	}

	public void setWeapons(String[] weapons) {
		this.weapons = weapons;
	}

	public String[] getAttacks() {
		return attacks;
	}

	public void setAttacks(String[] attacks) {
		this.attacks = attacks;
	}

}
