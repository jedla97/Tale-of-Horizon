package com.vutbr.feec.extra.asigment;

import java.util.ArrayList;
import java.util.List;

public class MapDatabase {

	List<Map> database = new ArrayList<Map>();

	public void vypis() {
		for (int i = 0; i < database.size(); i++) {
			System.out.println(database.get(i));
		}
	}

	// for simply only name of the map
	public String vypisMapName(int id) {
		// System.out.println(database.get(id));
		return database.get(id).name();
	}

	// print for map name + string about arriving
	public void vypisMapArrive(int id) {
		// System.out.println(database.get(id));
		System.out.println("You have arrive at " + database.get(id).name());
	}

	// print for map id only test purpose
	public int vypisMapId(int id) {
		System.out.println(database.get(id).id());
		return id;
	}

}
