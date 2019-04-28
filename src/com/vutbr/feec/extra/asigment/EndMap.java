package com.vutbr.feec.extra.asigment;

public class EndMap extends Map {

	public EndMap(int id, String name) {
		super(id = 17, name);
		// TODO Auto-generated constructor stub
	}

	// whats happening on the map
	public int mapTale(MapDatabase data, int mapId, Gamer gamer) {
		int gotMoney;
		System.out.println(
				"Finally, we can see city. There is where kings and his family lives. But this huge wall is cover with spell.\n"
						+ "Thats the reason why you can see only the tops of some main building");
		MilitaryWatcher militaryWatcher = new MilitaryWatcher(1, null, this.randomNumberForHp(), this.randomAge(),
				"MilitaryWatcher", null);
		gotMoney = militaryWatcher.whatYouWant(militaryWatcher, gamer, data, mapId);
		if (gotMoney != 1) {
			return 17;
		}
		King king = new King(2, null, this.randomNumberForHp(), this.randomAge(), "King", null);
		king.whatYouWant(king, gamer, data, mapId);
		return 18;
	}
}
