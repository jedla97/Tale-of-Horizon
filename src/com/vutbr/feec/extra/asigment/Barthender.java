package com.vutbr.feec.extra.asigment;

import java.util.Random;

public class Barthender extends Person {
	private String[] drinks;
	private String[] food;

	// construcor for barthender
	public Barthender(int id, String name, int hp, int age, String calling, String[] options) {
		super(id, name, hp, age, calling, options);
		switch (id) {
		case 1:
			Random rand = new Random();
			String[] nameArray = { "Naotsugu", "Minori", "Isuzu", "Shiroe", "Akatsuki", "Nyanta", "Krusty", "Isaac",
					"Maryelle", "Charasin", "Michitaka" };
			String[] array1 = { "Get something to drink", "Get something to eat", "Get both", "Get some intel",
					"Have meaningfull converation", "Leave" };
			String[] drinkArray = { "watter", "juice", "bear", "wine", "whisky" };
			String[] foodArray = { "chicken fillet with rice", "chicken fillet with potato", "pork filet with potato",
					"grilled pork with bread", "the hot \"Stones\"" };
			this.setOptions(array1);
			this.setName(nameArray[rand.nextInt(11)]);
			this.drinks = drinkArray;
			this.food = foodArray;
			break;
		}
	}

	// conversation with player + get some drink and food
	public void whatYouWant(Barthender barthender, Gamer gamer, MapDatabase data, int mapId) {
		int option, helpMoney, chargeMoney, helpHp, taskId = 0;
		Random rand = new Random();
		while (true) {
			option = barthender.printOptions(barthender.numberOfOptions(), taskId);
			if (option == 1) {
				this.product(option);
				chargeMoney = this.charge(option);
				helpMoney = gamer.getMoney();
				helpHp = gamer.getHp();
				helpHp = helpHp + helpMoney * 3;
				helpMoney = helpMoney - chargeMoney;
				if (helpMoney < 0) {
					System.out.println("You don't have enough money\n");
					taskId++;
				} else {
					gamer.setMoney(helpMoney);
					gamer.setHp(helpHp);
					taskId++;
				}

			} else if (option == 2) {
				this.product(option);
				chargeMoney = this.charge(option);
				helpMoney = gamer.getMoney();
				helpHp = gamer.getHp();
				helpHp = helpHp + helpMoney * 3;
				helpMoney = helpMoney - chargeMoney;
				if (helpMoney < 0) {
					System.out.println("You don't have enough money\n");
					taskId++;
				} else {
					gamer.setMoney(helpMoney);
					gamer.setHp(helpHp);
					taskId++;
				}
			} else if (option == 3) {
				this.product(option);
				chargeMoney = this.charge(option);
				helpMoney = gamer.getMoney();
				helpHp = gamer.getHp();
				helpHp = helpHp + helpMoney * 3;
				helpMoney = helpMoney - chargeMoney;
				if (helpMoney < 0) {
					System.out.println("You don't have enough money\n");
					taskId++;
				} else {
					gamer.setMoney(helpMoney);
					gamer.setHp(helpHp);
					taskId++;
				}
			} else if (option == 4) {
				int help = rand.nextInt(4);
				if (help == 0) {
					System.out.println("You are located at " + data.vypisMapName(mapId) + "\n");
				} else if (help == 1) {
					System.out.println("In the air is feeling of bloodthirsty\n");
				} else if (help == 2) {
					System.out.println(
							"In " + data.vypisMapName(rand.nextInt(17)) + " is some monster ready to be slay\n");
				} else if (help == 3) {
					System.out.println("The food and drink is good for your hp\n");
				} else if (help == 4) {
					System.out.println("The city of " + data.vypisMapName(mapId) + " is well secure\n");
				}
				taskId++;
			} else if (option == 5) {
				int help = rand.nextInt(6);
				if (help == 0) {
					System.out.println("Today is nice weather\n");
				} else if (help == 1) {
					System.out.println("On long journy need something to eat\n");
				} else if (help == 2) {
					System.out.println("You can rest only on safe place\n");
				} else if (help == 3) {
					System.out.println("My name is " + barthender.getName() + "\n");
				} else if (help == 4) {
					System.out.println("I'm " + barthender.getAge() + " years old\n");
				} else if (help == 5) {
					System.out.println("I'm the " + barthender.getCalling() + "\n");
				}
				taskId++;
			} else if (option == 6) {
				System.out.println("Leaving the bar\n");
				break;
			}
		}

	}

	@Override
	public int charge(int forWhat) {

		Random rand = new Random();
		if (forWhat == 1) {
			int n = rand.nextInt(3);
			n = n + 1;
			return n;
		}
		if (forWhat == 2) {
			int n = rand.nextInt(10);
			n = +1;
			while (n < 4) {
				n = rand.nextInt(10);
				n = n + 1;
			}
			return n;
		}
		if (forWhat == 3) {
			int n = rand.nextInt(13);
			n = +1;
			while (n < 6) {
				n = rand.nextInt(13);
				n = n + 1;
			}
			return n;
		}
		return 0;
	}

	// generate name of product
	public void product(int forWhat) {
		String[] drink = this.getDrinks();
		String[] food = this.getFood();
		Random rand = new Random();
		if (forWhat == 1) {
			int drink1 = rand.nextInt(drink.length);
			System.out.println("Here you have glass of " + drink[drink1]);
		}
		if (forWhat == 2) {
			int food1 = rand.nextInt(food.length);
			System.out.println("Here you have " + food[food1]);
		}
		if (forWhat == 3) {
			int drink1 = rand.nextInt(drink.length);
			int food1 = rand.nextInt(food.length);
			System.out.println("Here you have " + food[food1] + " and glass of " + drink[drink1]);

		}
	}

	public String[] getDrinks() {
		return drinks;
	}

	public void setDrinks(String[] drinks) {
		this.drinks = drinks;
	}

	public String[] getFood() {
		return food;
	}

	public void setFood(String[] food) {
		this.food = food;
	}

}
