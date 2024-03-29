package com.vutbr.feec.extra.asigment;

public class TwoNode extends Map {

	public TwoNode(int id, String name) {
		super(id, name);
		switch (id) {
		case 9:
			this.setName("\"Rightsword\"Tarague");
			break;
		case 16:
			this.setName("The Maelstrom Whirpool");
			break;
		}
	}

	// whats happening on the map
	public int mapTale(MapDatabase data, int mapId, Gamer gamer) {
		int move;
		final int MAPNODE = 2;
		switch (mapId) {
		case 9: // 5 14
			int[] array9 = { 5, 14, 98, 99 };
			System.out.println(
					"The biggest mountain in the world. The top is shrouded in the clouds. Nobody never been on the top.\n"
							+ "People who try to go to top never come back down. Some people say the monster live there.");
			move = this.spawn(gamer, mapId, data);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			}
			move = this.whereToGo(array9, data, MAPNODE, gamer, false, false);
			return move;
		case 16: // 14 17
			int[] array16 = { 14, 17, 98, 99 };
			System.out.println("The ship start being very dangerous place to travel. "
					+ "This whirpool is not dangerous as nature myth but also as home of one of the most dangerous spieces.\n");
			Boss boss = new Boss(3, null, 270, null);
			move = boss.whatYouWant(boss, gamer);
			if (move == -1) {
				System.out.println(gamer.getNickname() + " must start from scrach because you have die");
				return 98;
			} else if (move == -2) {
				move = 14;
				return move;
			}
			move = this.whereToGo(array16, data, MAPNODE, gamer, false, false);
			return move;
		}
		return 596;
	}
}
