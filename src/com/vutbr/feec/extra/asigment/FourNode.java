package com.vutbr.feec.extra.asigment;

public class FourNode extends Map {

	public FourNode(int id, String name) {
		super(id, name);
		switch (id) {
		case 14:
			this.setName("Sando River");
			break;

		}
	}

	public int mapTale(MapDatabase data, int mapId, Gamer gamer) {
		int move;
		final int MAPNODE = 4;
		switch (mapId) {
		case 14: // 9 10 13 16
			int[] array14 = { 9, 10, 13, 16, 98, 99 };
			System.out.println("Story"); // TO-DO
			// data.vypisMapArrive(mapId);
			move = this.spawn(gamer, mapId, data);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array14, data, MAPNODE, gamer, false, false);
			return move;
		}
		return 596;
	}

}
