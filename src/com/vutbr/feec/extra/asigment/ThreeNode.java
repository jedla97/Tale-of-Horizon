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

	public int mapTale(MapDatabase data, int mapId, Gamer gamer) {
		int move, n = 0;
		final int MAPNODE = 3;
		switch (mapId) {
		case 2: // 3 4 5
			int[] array2 = { 3, 4, 5, 98, 99 };
			System.out.println("Story"); // TO-DO
			// data.vypisMapArrive(mapId);
			move = this.spawn(gamer, mapId, data);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array2, data, MAPNODE, gamer, false, false);
			return move;
		case 4: // 2 5 6 boss
			int[] array4 = { 2, 5, 6, 98, 99 };
			System.out.println("Story"); // TO-DO
			// data.vypisMapArrive(mapId);
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
			System.out.println("Story"); // TO-DO
			// data.vypisMapArrive(mapId);
			move = this.spawn(gamer, mapId, data);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array5, data, MAPNODE, gamer, false, false);
			return move;
		case 6: // 7 8 9
			int[] array6 = { 7, 8, 9, 98, 99 };
			System.out.println("Story"); // TO-DO
			// data.vypisMapArrive(mapId);
			move = this.spawn(gamer, mapId, data);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array6, data, MAPNODE, gamer, false, false);
			return move;
		case 10: // 11 13 14
			int[] array10 = { 11, 13, 14, 98, 99 };
			System.out.println("Story"); // TO-DO
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
			System.out.println("Story"); // TO-DO
			// data.vypisMapArrive(mapId);
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
