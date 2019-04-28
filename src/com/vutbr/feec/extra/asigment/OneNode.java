package com.vutbr.feec.extra.asigment;

public class OneNode extends Map {

	public OneNode(int id, String name) {
		super(id, name);
		switch (id) {
		case 11:
			this.setName("San­Nou Archipelago");
			break;
		case 12:
			this.setName("Lost Bridge");
			break;
		}
	}

	public int mapTale(MapDatabase data, int mapId, Gamer gamer) {
		int move;
		final int MAPNODE = 1;
		switch (mapId) {
		case 11:
			int[] array11 = { 12, 98, 99 };
			System.out.println(
					"Beatiful longlife tree showing on small islands conected by bridges. In the air is smell of ocean");
			move = this.spawn(gamer, mapId, data);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array11, data, MAPNODE, gamer, false, false);
			return move;
		case 12:
			int[] array12 = { 13, 98, 99 };
			System.out.println(
					"The 1000 old demolished bridge. Every step is dangerous because some strong adventures die here."
							+ " These who survived saying be always at attention never know when monster attack.");
			move = this.spawn(gamer, mapId, data);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array12, data, MAPNODE, gamer, false, false);
			return move;

		}
		return 596;
	}
}
