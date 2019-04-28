package com.vutbr.feec.extra.asigment;

import java.util.Random;

public class King extends Person {
	// constructor for 2 type of kings
	public King(int id, String name, int hp, int age, String calling, String[] options) {
		super(id, name, hp, age, calling, options);
		switch (id) {
		case 1:
			String[] array1 = { "Get instruction", "Get recomendetation", "Leave" };
			this.setName("Zeldys");
			this.setOptions(array1);
			break;
		case 2:
			String[] array2 = { "Hand over the letter and get praise and reward",
					"Hand over the letter and leave without nothing" };
			this.setOptions(array2);
			this.setName("Arumi");
			break;
		}
	}

	// conversation with player start location and end location is where kings
	// appear
	public int whatYouWant(King king, Gamer gamer, MapDatabase data, int mapId) {

		int helpId;
		int option, helpMoney, taskId, taskMoneyId = 0;
		helpId = king.getId();
		System.out.println("Welcome brave adventure " + gamer.getNickname() + ". My name is " + king.getName()
				+ " I am king of " + data.vypisMapName(mapId));
		switch (helpId) {
		case 1:
			taskId = 0;
			while (true) {
				option = king.printOptions(king.numberOfOptions(), taskId);
				if (option == 1) {
					if (taskMoneyId > 0) {
						System.out.println("I need to transport this letter to king of Isle of Hasitate.\nHurry "
								+ gamer.getNickname() + ". It's important for our kingdom\n");
					} else {
						System.out.println(
								"I need to transport this letter to king of Isle of Hasitate. I get you 100 silver coin for start your adventure\n");
						helpMoney = gamer.getMoney();
						helpMoney = helpMoney + 100;
						gamer.setMoney(helpMoney);
					}
					taskId++;
					taskMoneyId++;
				} else if (option == 2) {
					Random rand = new Random();
					int help = rand.nextInt(4);
					if (help == 0) {
						System.out.println("You are in king hall at " + data.vypisMapName(mapId));
					} else if (help == 1) {
						System.out.println(
								"I recomendet not to go to \"Frint sea beach\" because of the one of the monster lord\n");
					} else if (help == 2) {
						System.out.println("Qunpearl Remains is old casle with monster. It's located on east\n");
					} else if (help == 3) {
						System.out.println("Vulcan is located on south. Unfortunately we don't know anything else\n");
					}
					taskId++;
				} else if (option == 3) {
					System.out.println("Leaving the king hall\n");
					return 0;

				}
			}
		case 2:
			taskId = 0;
			System.out.println("Oh it's look like you have here to deliver letter from Uma Stronghold\n");
			while (true) {
				option = king.printOptions(king.numberOfOptions(), taskId);
				if (option == 1) {
					for (int i = 0; i < 5; i++) {
						Random rand = new Random();
						int help = rand.nextInt(4);
						if (help == 0) {
							System.out.println("Thank you very much\n");
						} else if (help == 1) {
							System.out.println("Here is some small money for your sake\n");
							helpMoney = gamer.getMoney();
							helpMoney = helpMoney + 1000;
							gamer.setMoney(helpMoney);
						} else if (help == 2) {
							System.out.println("You are brave adventure for your next here is some food and boze\n");

						}
					}
					return 0;
				} else if (option == 2) {
					System.out.println("Leaving the king hall\n");
					return 0;
				}
			}

		}
		return 0;

	}

}
