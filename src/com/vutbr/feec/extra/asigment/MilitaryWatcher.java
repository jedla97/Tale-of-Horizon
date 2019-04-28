package com.vutbr.feec.extra.asigment;

import java.util.Random;

public class MilitaryWatcher extends Person {
	// constructor for 2 type of military watcher
	public MilitaryWatcher(int id, String name, int hp, int age, String calling, String[] options) {
		super(id, name, hp, age, calling, options);
		Random rand = new Random();
		String[] nameArray = { "Naotsugu", "Minori", "Isuzu", "Shiroe", "Akatsuki", "Nyanta", "Krusty", "Isaac",
				"Maryelle", "Charasin", "Michitaka" };
		switch (id) {
		case 1:
			String[] array1 = { "Pay toll and enter", "Don't enter the city", "Have some meaninfull conversation",
					"Ask for tips" };
			this.setOptions(array1);
			this.setName(nameArray[rand.nextInt(11)]);
			break;
		case 2:
			String[] array2 = { "Have some meaninfull conversation", "Ask for tips", "Leave" };
			this.setOptions(array2);
			this.setName(nameArray[rand.nextInt(11)]);
			break;
		}

	}

	// conversation with player + get in last location 100 coins and on different
	// place is needed 0+ coins all is rng
	public int whatYouWant(MilitaryWatcher militaryWatcher, Gamer gamer, MapDatabase data, int mapId) {

		int helpId;
		int option, taskId, helpToll, n;
		Random rand = new Random();
		helpId = militaryWatcher.getId();
		switch (helpId) {
		case 1:
			taskId = 0;
			if (mapId == 17) {
				n = 100;
			} else {
				n = rand.nextInt(15) + 1;
			}
			System.out.println(
					"Welcome at the " + data.vypisMapName(mapId) + ".\nYou need pay " + n + " silver to enter\n");
			while (true) {
				option = militaryWatcher.printOptions(militaryWatcher.numberOfOptions(), taskId);
				if (option == 1) {
					System.out.println("So give me a money\n");
					helpToll = gamer.getMoney();
					helpToll = helpToll - n;
					if (helpToll < 0) {
						System.out.println("You don't have enough money\n");
						taskId++;
					} else {
						System.out.println("Entering the city\n");
						gamer.setMoney(helpToll);
						return 1;
					}

				} else if (option == 2) {
					System.out.println("Have a nice day\n");
					return 0;
				} else if (option == 3) {
					int help = rand.nextInt(6);
					if (help == 0) {
						System.out.println("Today is nice weather\n");
					} else if (help == 1) {
						System.out.println("On long journy need something to eat\n");
					} else if (help == 2) {
						System.out.println("You can rest only on safe place\n");
					} else if (help == 3) {
						System.out.println("My name is " + militaryWatcher.getName() + "\n");
					} else if (help == 4) {
						System.out.println("I'm " + militaryWatcher.getAge() + " years old\n");
					} else if (help == 5) {
						System.out.println("I'm the " + militaryWatcher.getCalling() + "\n");
					}
					taskId++;
				} else if (option == 4) {
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
				}
			}
		case 2:
			taskId = 0;
			System.out.println("Welcome at the " + data.vypisMapName(mapId) + "\n");
			while (true) {
				option = militaryWatcher.printOptions(militaryWatcher.numberOfOptions(), taskId);
				if (option == 1) {
					int help = rand.nextInt(6);
					if (help == 0) {
						System.out.println("Today is nice weather\n");
					} else if (help == 1) {
						System.out.println("On long journy need something to eat\n");
					} else if (help == 2) {
						System.out.println("You can rest only on safe place\n");
					} else if (help == 3) {
						System.out.println("My name is " + militaryWatcher.getName() + "\n");
					} else if (help == 4) {
						System.out.println("I'm " + militaryWatcher.getAge() + " years old\n");
					} else if (help == 5) {
						System.out.println("I'm the " + militaryWatcher.getCalling() + "\n");
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
					return 1;
				}
			}
		}
		return 0;
	}

}
