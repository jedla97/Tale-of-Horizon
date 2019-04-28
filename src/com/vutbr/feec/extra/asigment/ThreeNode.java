package com.vutbr.feec.extra.asigment;

import java.util.Random;

public class ThreeNode extends Map {

	public ThreeNode(int id, String name) {
		super(id, name);
		switch (id) {
		case 2:
			this.setName("Unknown Vulcano");
			break;
		case 4:
			this.setName("Doragon's Beach");
			break;
		case 5:
			this.setName("Sword of Fourland");
			break;
		case 6:
			this.setName("Fallen's Jungle Fortress");
			break;
		case 10:
			this.setName("Qunpearl Remains");
			break;
		case 13:
			this.setName("Cianu Ruin");
			break;
		}
	}

	// whats happening on the map
	public int mapTale(MapDatabase data, int mapId, Gamer gamer) {
		int move, n = 0;
		final int MAPNODE = 3;
		switch (mapId) {
		case 2: // 3 4 5
			int[] array2 = { 3, 4, 5, 98, 99 };
			System.out.println("The vulcano who every body know but noone has been brave to name it.\n"
					+ "Ahh wait someone has been but nobody know that name that is why is unknow.\n"
					+ "The prophecy told story one day this mass of energy explode and destroy hole word but no worry in near time is it ok");
			move = this.spawn(gamer, mapId, data);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array2, data, MAPNODE, gamer, false, false);
			return move;
		case 4: // 2 5 6 boss
			int[] array4 = { 2, 5, 6, 98, 99 };
			System.out.println(
					"Whole beach is red and air is smell as cementary. That is home of one sea king. One of most dangerous place");
			Boss boss = new Boss(2, null, 250, null);
			move = boss.whatYouWant(boss, gamer);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array4, data, MAPNODE, gamer, false, false);
			return move;
		case 5: // 4 6 9
			int[] array5 = { 4, 6, 9, 98, 99 };
			System.out.println(
					"Whatever you look you can se hills and forest. Oh wait you don't see nothing but trees than that is true.\n"
							+ "This forest is like maze but with litle orientation is no problem to go where you want.");
			move = this.spawn(gamer, mapId, data);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array5, data, MAPNODE, gamer, false, false);
			return move;
		case 6: // 7 8 9
			int[] array6 = { 7, 8, 9, 98, 99 };
			System.out.println(
					"The city in the jungle what else can say. The ancient nation live here but long time they left.\n"
							+ "Nobody know where thye live now even when they live.");
			move = this.spawn(gamer, mapId, data);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array6, data, MAPNODE, gamer, false, false);
			return move;
		case 10: // 11 13 14
			int[] array10 = { 11, 13, 14, 98, 99 };
			System.out.println(
					"Not long time ago was here big fire. But the leaders of the city still hold the rights and laws.\n"
							+ "This few building left here. lots of citizens left but the loyal still serve the city");
			Random rand = new Random();
			MilitaryWatcher militaryWatcher = new MilitaryWatcher((rand.nextInt(2) + 1), null, this.randomNumberForHp(),
					this.randomAge(), "MilitaryWatcher", null);
			move = militaryWatcher.whatYouWant(militaryWatcher, gamer, data, mapId);
			// entered city
			if (move == 1) {
				// barman
				if (rand.nextInt(2) == n) {
					Barthender barthender1 = new Barthender(1, null, this.randomNumberForHp(), this.randomAge(),
							"Barthender", null);
					barthender1.whatYouWant(barthender1, gamer, data, mapId);
				}
				move = this.whereToGo(array10, data, MAPNODE, gamer, false, false);
			} else {
				move = this.whereToGo(array10, data, MAPNODE, gamer, false, false);
			}
			return move;
		case 13: // 14 15 16
			int[] array13 = { 14, 15, 16, 98, 99 };
			System.out.println(
					"The ruin as the name say the Cianu family lived here. But after that accident nobody they disapere.\n"
							+ "Hey, hold up you don't know about that big accident. Even now the goose bumps is on my whole body");
			move = this.spawn(gamer, mapId, data);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array13, data, MAPNODE, gamer, false, false);
			return move;
		}
		return 596;
	}

}
