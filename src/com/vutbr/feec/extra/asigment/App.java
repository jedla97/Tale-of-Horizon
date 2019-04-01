/*
 * Create by Jakub Jedlicka
 * School project BPC2I
 * School BUT FEEC
 * school login: xjedli24 ; Id: 198597 ; email: xjedli24@stud.feec.vutbr.cz
 * personal email: jedlayt@gmail.com !for communication use this email and always subject with name of app
 */
//for execute app in cmd java -jar <file>.jar
package com.vutbr.feec.extra.asigment;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String helpForTesting;
		String name;
		String nickname;
		boolean flag = false;
		int helpId1 = 0;
		int helpId2 = 0;
		int gamerHp = 500;
		int gamerMoney = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name: ");
		name = sc.nextLine();
		System.out.println("Enter nickname: ");
		nickname = sc.nextLine();
		Gamer gamer = new Gamer(0, name, gamerHp, nickname, gamerMoney);
		MapDatabase data = new MapDatabase();
		// Creating maps
		StartMap m1 = new StartMap(0, "Uma Ruined Stronghold");
		OneNodeWithout m2 = new OneNodeWithout(1, "");
		ThreeNode m3 = new ThreeNode(2, "");
		OneNodeWithout m4 = new OneNodeWithout(3, "");
		ThreeNode m5 = new ThreeNode(4, "");
		ThreeNode m6 = new ThreeNode(5, "");
		ThreeNode m7 = new ThreeNode(6, "");
		OneNodeWithout m8 = new OneNodeWithout(7, "");
		OneNodeWithout m9 = new OneNodeWithout(8, "");
		TwoNode m10 = new TwoNode(9, "");
		ThreeNode m11 = new ThreeNode(10, "");
		OneNode m12 = new OneNode(11, "");
		OneNode m13 = new OneNode(12, "");
		ThreeNode m14 = new ThreeNode(13, "");
		FourNode m15 = new FourNode(14, "");
		OneNodeWithout m16 = new OneNodeWithout(15, "");
		TwoNode m17 = new TwoNode(16, "");
		EndMap m18 = new EndMap(17, "Isle Of Hasitate");
		// add to map database
		data.database.add(m1);
		data.database.add(m2);
		data.database.add(m3);
		data.database.add(m4);
		data.database.add(m5);
		data.database.add(m6);
		data.database.add(m7);
		data.database.add(m8);
		data.database.add(m9);
		data.database.add(m10);
		data.database.add(m11);
		data.database.add(m12);
		data.database.add(m13);
		data.database.add(m14);
		data.database.add(m15);
		data.database.add(m16);
		data.database.add(m17);
		data.database.add(m18);
		/*
		 * movement mechanic between maps + case 99 for end program case 98 for start
		 * over from scratch case 97 is when player wrong move that doesn't exist
		 */
		while (helpId1 != 18) {

			switch (helpId1) {
			case 0:
				helpId2 = helpId1;
				helpId1 = m1.mapTale(data, helpId1, gamer, flag);
				flag = true;
				break;
			case 1:
				helpId2 = helpId1;
				helpId1 = m2.mapTale(data, helpId1, gamer);
				break;
			case 2:
				helpId1 = m3.mapTale(data, helpId1, gamer);
				break;
			case 3:
				helpId1 = m4.mapTale(data, helpId1, gamer);
				break;
			case 4:
				helpId1 = m5.mapTale(data, helpId1, gamer);
				break;
			case 5:
				helpId1 = m6.mapTale(data, helpId1, gamer);
				break;
			case 6:
				helpId1 = m7.mapTale(data, helpId1, gamer);
				break;
			case 7:
				helpId1 = m8.mapTale(data, helpId1, gamer);
				break;
			case 8:
				helpId1 = m9.mapTale(data, helpId1, gamer);
				break;
			case 9:
				helpId1 = m10.mapTale(data, helpId1, gamer);
				break;
			case 10:
				helpId1 = m11.mapTale(data, helpId1, gamer);
				break;
			case 11:
				helpId1 = m12.mapTale(data, helpId1, gamer);
				break;
			case 12:
				helpId1 = m13.mapTale(data, helpId1, gamer);
				break;
			case 13:
				helpId1 = m14.mapTale(data, helpId1, gamer);
				break;
			case 14:
				helpId1 = m15.mapTale(data, helpId1, gamer);
				break;
			case 15:
				helpId1 = m16.mapTale(data, helpId1, gamer);
				break;
			case 16:
				helpId1 = m17.mapTale(data, helpId1, gamer);
				break;
			case 17:
				helpId1 = m18.mapTale(data, helpId1, gamer);
				break;
			case 97: // for new try
				helpId1 = helpId2;
				break;
			case 98:
				helpId1 = 0;
				flag = false;
				gamer.setHp(gamerHp);
				gamer.setMoney(gamerMoney);
				data.vypisMapArrive(helpId1);
				break;
			case 99: // for end game
				System.out.println("program has been ended due to player end");
				System.exit(99);
				break;
			}
		}

	}

}
