package com.vutbr.feec.extra.asigment;

import java.util.Random;

public class OneNodeWithout extends Map {

	public OneNodeWithout(int id, String name) {
		super(id, name);
		switch (id) {
		case 1:
			this.setName("Frint Sea Beach");
			break;
		case 3:
			this.setName("Fall of Outfoxing");
			break;

		case 7:
			this.setName("Cape Typhon");
			break;
		case 8:
			this.setName("Old Wasa Port");
			break;

		case 15:
			this.setName("Nadel Sea Beach");
			break;
		}
	}

	// whats happening on the map
	public int mapTale(MapDatabase data, int mapId, Gamer gamer) {
		int move, n = 0;
		Random rand = new Random();
		final int MAPNODE = 1;
		switch (mapId) {
		case 1:// boss
			int[] array1 = { 0, 98, 99 };
			System.out.println(
					"Beatiful sight of sun dawn at the end of sea. But something more dangerous is under water ");
			Boss boss = new Boss(1, null, 230, null);
			move = boss.whatYouWant(boss, gamer);

			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array1, data, MAPNODE, gamer, false, false);
			return move;
		case 3: // 2
			int[] array3 = { 2, 98, 99 };
			System.out.println("Dark place to live but some trace of live is here in these small mountains");
			move = this.spawn(gamer, mapId, data);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array3, data, MAPNODE, gamer, false, false);
			return move;
		case 7: // 6
			int[] array7 = { 6, 98, 99 };
			System.out.println("The small seaport with red-white stripe lighthouse and wall of stones around.\n"
					+ "On the sea you see ships big or small with merchants, mercenaries and pirates");
			MilitaryWatcher militaryWatcher1 = new MilitaryWatcher((rand.nextInt(2) + 1), null,
					this.randomNumberForHp(), this.randomAge(), "MilitaryWatcher", null);
			move = militaryWatcher1.whatYouWant(militaryWatcher1, gamer, data, mapId);
			// entered city
			if (move == 1) {
				// barman
				if (rand.nextInt(2) == n) {
					Barthender barthender1 = new Barthender(1, null, this.randomNumberForHp(), this.randomAge(),
							"Barthender", null);
					barthender1.whatYouWant(barthender1, gamer, data, mapId);
				}
				move = this.whereToGo(array7, data, MAPNODE, gamer, false, false);
			} else {
				move = this.whereToGo(array7, data, MAPNODE, gamer, false, false);
			}
			return move;
		case 8: // 6
			int[] array8 = { 6, 98, 99 };
			System.out.println("In the small bay is located Old Wase know as pirates dream.\n"
					+ "Nobody know how many people die here but all well-know emperors of the seas was born here.\n"
					+ "But this unlawful city is well prospered");
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
				move = this.whereToGo(array8, data, MAPNODE, gamer, false, false);
			} else {
				move = this.whereToGo(array8, data, MAPNODE, gamer, false, false);
			}

			return move;
		case 15: // 13
			int[] array15 = { 13, 98, 99 };
			System.out.println(
					"What expected from Nadel beach. Beatiful sand ready for relax and some sporting matches.\nOn the long distance can be seen ships.");
			move = this.spawn(gamer, mapId, data);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array15, data, MAPNODE, gamer, false, false);
			return move;
		}
		return 596;

	}
}
