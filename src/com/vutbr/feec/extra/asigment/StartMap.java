package com.vutbr.feec.extra.asigment;

import java.util.Random;

public class StartMap extends Map {

	public StartMap(int id, String name) {
		super(id = 0, name);
		// TODO Auto-generated constructor stub
	}

	public int mapTale(MapDatabase data, int mapId, Gamer gamer, boolean flag) {
		int move, n = 0;
		final int MAPNODE = 3;
		int[] array0 = { 1, 2, 10, 98, 99 };
		System.out.println("Story"); // TO-DO
		// data.vypisMapArrive(mapId);
		if (flag == false) {
			King king = new King(1, null, this.randomNumberForHp(), this.randomAge(), "King", null);
			move = king.whatYouWant(king, gamer, data, mapId);
			move = this.whereToGo(array0, data, MAPNODE, gamer, false, false);
		} else {
			Random rand = new Random();
			MilitaryWatcher militaryWatcher = new MilitaryWatcher((rand.nextInt(2) + 1), null, this.randomNumberForHp(),
					this.randomAge(), "MilitaryWatcher", null);
			move = militaryWatcher.whatYouWant(militaryWatcher, gamer, data, mapId);
			// entered city
			if (move == 1) {
				if (rand.nextInt(2) == n) {
					Barthender barthender1 = new Barthender(1, null, this.randomNumberForHp(), this.randomAge(),
							"Barthender", null);
					barthender1.whatYouWant(barthender1, gamer, data, mapId);
				}
				move = this.whereToGo(array0, data, MAPNODE, gamer, false, false);
			} else {
				move = this.whereToGo(array0, data, MAPNODE, gamer, false, false);
			}
		}
		return move;
	}

}