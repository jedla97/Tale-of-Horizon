package com.vutbr.feec.extra.asigment;

import java.util.Random;
import java.util.Scanner;

public class Map {
	private int id;
	private String name;

	public Map(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Map [id=" + id + ", name=" + name + "]";
	};

	public String name() {
		return name;
	};

	public String id() {
		return " " + id + " ";
	};

	// monster chance to spawn is 1:3
	public boolean monsterSpawnChance() {
		boolean flag = false;
		int n;
		Random rand = new Random();
		n = rand.nextInt(3);
		if (n == 1) {
			flag = true;
		}
		return flag;
	}

	// adventure chance to spawn is 1:2
	public boolean adventureSpawnChance() {
		boolean flag = false;
		int n;
		Random rand = new Random();
		n = rand.nextInt(2);
		if (n == 1) {
			flag = true;
		}
		return flag;
	}

	// Spawn both monster and adventurer
	public int spawn(Gamer gamer, int mapId, MapDatabase data) {
		Random rand = new Random();
		int n = rand.nextInt(2);
		int monsterFight, adventureFight;
		if (n == 0) {
			monsterFight = this.monsterSpawn(gamer, mapId);
			if (monsterFight == -1) {
				return monsterFight;
			}
			adventureFight = this.adventureSpawn(gamer, mapId, data);
			if (adventureFight == -1) {
				return adventureFight;
			}
		} else {
			adventureFight = this.adventureSpawn(gamer, mapId, data);
			if (adventureFight == -1) {
				return adventureFight;
			}
			monsterFight = this.monsterSpawn(gamer, mapId);
			if (monsterFight == -1) {
				return monsterFight;
			}
		}
		return 0;
	}

	// for spawn adventurer
	public int adventureSpawn(Gamer gamer, int mapId, MapDatabase data) {
		boolean flag = false;
		int monsterId = 0;
		int fightResult;
		int hp = this.randomNumberForHp();
		int age = this.randomAge();
		flag = this.adventureSpawnChance();
		if (flag == true) {
			if (mapId == 2 || mapId == 3 || mapId == 5 || mapId == 6 || mapId == 9 || mapId == 11 || mapId == 12
					|| mapId == 13 || mapId == 14 || mapId == 15) {
				while (true) {
					if (monsterId >= 1 && monsterId <= 3) {
						break;
					} else {
						monsterId = this.randomNumberForSpawn();
					}
				}
				Adventure adventure = new Adventure(monsterId, null, hp, age, "Adventure", null);
				fightResult = adventure.whatYouWant(adventure, gamer, data, mapId);
				return fightResult;
			}
		}
		return 0;
	}

	// for spawn monster without boss
	public int monsterSpawn(Gamer gamer, int mapId) {
		boolean flag = false;
		int monsterId = 0;
		int fightResult;
		flag = this.monsterSpawnChance();
		if (flag == true) {
			// Spawn water monster
			if (mapId == 11 || mapId == 12 || mapId == 15) {
				while (true) {
					if (monsterId == 1 || monsterId == 2) {
						break;
					} else {
						monsterId = this.randomNumberForSpawn();
					}
				}
				Casual casual = new Casual(monsterId, null, this.randomNumberForHp(), null);
				fightResult = casual.whatYouWant(casual, gamer);
				return fightResult;
			}
			// forest monster
			else if (mapId == 5 || mapId == 14) {
				while (true) {
					if (monsterId == 3 || monsterId == 4 || monsterId == 5 || monsterId == 6) {
						break;
					} else {
						monsterId = this.randomNumberForSpawn();
					}
				}
				Casual casual = new Casual(monsterId, null, this.randomNumberForHp(), null);
				fightResult = casual.whatYouWant(casual, gamer);
				return fightResult;
			}
			// hill monster
			else if (mapId == 2 || mapId == 3 || mapId == 9) {
				while (true) {
					if (monsterId == 6 || monsterId == 7 || monsterId == 8 || monsterId == 9) {
						break;
					} else {
						monsterId = this.randomNumberForSpawn();
					}
				}
				Casual casual = new Casual(monsterId, null, this.randomNumberForHp(), null);
				fightResult = casual.whatYouWant(casual, gamer);
				return fightResult;
			}
			// dungeon monster
			else if (mapId == 6 || mapId == 13) {
				while (true) {
					if (monsterId == 7 || monsterId == 10) {
						break;
					} else {
						monsterId = this.randomNumberForSpawn();
					}
				}
				Casual casual = new Casual(monsterId, null, this.randomNumberForHp(), null);
				fightResult = casual.whatYouWant(casual, gamer);
				return fightResult;
			}
		}
		return 0;

	}

	// map logic what is next location
	public int whereToGo(int[] array, MapDatabase data, int mapNode, Gamer gamer, boolean flag1, boolean flag2) {
		int move, j = 0, helpI = 0;
		String[] options = { "Restart game", "End game", "Ask for money ballance" };
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		if (flag1 == false) {
			System.out.println("Where you want to go: ");
		} else {
			System.out.println("What else you want to do: ");
		}
		for (int i = 0; i < array.length + 1; i++) {
			if (i <= (array.length - 3)) {
				System.out.println("for " + data.vypisMapName(array[i]) + " [input " + (i + 1) + "]");
			} else {
				System.out.println("for " + options[helpI] + " [input " + (i + 1) + "]");
				helpI++;
			}
		}
		move = sc.nextInt();
		while (true) {
			if (j > 0 && flag2 == false && flag1 == false) {
				move = sc.nextInt();
			} else if (j > 0 && flag2 == false && flag1 == true) {
				move = sc.nextInt();
			}
			if (mapNode == 1) {
				if (move == 1) {
					return array[0];
				} else if (move == 2) {
					return array[1];
				} else if (move == 3) {
					return array[2];
				} else if (move == 4) {
					gamer.moneyBalance();
					move = this.whereToGo(array, data, mapNode, gamer, true, false);
					j = 0;
					return move;
				} else {
					System.out.println("Wrong input enter again");
					j++;
				}
			} else if (mapNode == 2) {
				if (move == 1) {
					return array[0];
				} else if (move == 2) {
					return array[1];
				} else if (move == 3) {
					return array[2];
				} else if (move == 4) {
					return array[3];
				} else if (move == 5) {
					gamer.moneyBalance();
					move = this.whereToGo(array, data, mapNode, gamer, true, false);
					j = 0;
					return move;
				} else {
					System.out.println("Wrong input enter again");
					j++;
				}
			} else if (mapNode == 3) {
				if (move == 1) {
					return array[0];
				} else if (move == 2) {
					return array[1];
				} else if (move == 3) {
					return array[2];
				} else if (move == 4) {
					return array[3];
				} else if (move == 5) {
					return array[4];
				} else if (move == 6) {
					gamer.moneyBalance();
					move = this.whereToGo(array, data, mapNode, gamer, true, false);
					j = 0;
					return move;
				} else {
					System.out.println("Wrong input enter again");
					j++;
				}
			} else if (mapNode == 4) {
				if (move == 1) {
					return array[0];
				} else if (move == 2) {
					return array[1];
				} else if (move == 3) {
					return array[2];
				} else if (move == 4) {
					return array[3];
				} else if (move == 5) {
					return array[4];
				} else if (move == 6) {
					return array[5];
				} else if (move == 7) {
					gamer.moneyBalance();
					move = this.whereToGo(array, data, mapNode, gamer, true, false);
					j = 0;
					return move;
				} else {
					System.out.println("Wrong input enter again");
					j++;
				}
			}

		}
	}

	public int randomAge() {
		Random rand = new Random();
		int n = rand.nextInt(101);
		while (n < 15) {
			n = rand.nextInt(101);
		}
		return n;
	}

	public int randomNumberForSpawn() {
		Random rand = new Random();
		return rand.nextInt(11) + 1;
	}

	public int randomNumberForHp() {
		Random rand = new Random();
		return rand.nextInt(100) + 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
