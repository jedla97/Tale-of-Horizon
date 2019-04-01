package com.vutbr.feec.extra.asigment;

import java.util.Scanner;

public class Person extends Npc {
	private int age;
	private String calling;
	private String[] options;

	public Person(int id, String name, int hp, int age, String calling, String[] options) {
		super(id, name, hp);
		this.age = age;
		this.calling = calling;
		this.options = options;
		// TODO Auto-generated constructor stub
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCalling() {
		return calling;
	}

	public void setCalling(String calling) {
		this.calling = calling;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public String whatIsMyCalling(Person person) {
		String mil = "MilitaryWatch";
		String adv = "Adventure";
		String bar = "Barthender";
		String king = "King";
		int mil1 = mil.compareTo(person.getCalling());
		int adv1 = adv.compareTo(person.getCalling());
		int bar1 = bar.compareTo(person.getCalling());
		int king1 = king.compareTo(person.getCalling());
		if (mil1 == 0) {

			return "My calling is " + person.getCalling();
		} else if (adv1 == 0) {

			return "My calling is " + person.getCalling();
		} else if (bar1 == 0) {

			return "My calling is " + person.getCalling();
		} else if (king1 == 0) {

			return "My calling is " + person.getCalling();
		} else {
			return "My calling is " + person.getCalling() + "but I can't help you";
		}
	}

	public int printOptions(int numberOfOptions, int taskId) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int option;
		String[] helpOptions = this.getOptions();
		if (taskId == 0) {
			System.out.println("What can I do for you: ");
		} else {
			System.out.println("need something else: ");
		}
		for (int i = 0; i < numberOfOptions; i++) {
			System.out.println(helpOptions[i] + " [input " + (i + 1) + "]");
		}
		while (true) {
			option = sc.nextInt();
			if (option >= 1 && option < numberOfOptions + 1) {
				return option;
			} else {
				System.out.println(" wrong input try again ");
			}

		}
	}

	public int numberOfOptions() {
		String[] helpOptions = this.getOptions();
		return helpOptions.length;
	}

	public int charge(int forWhat) {
		return 0;

	}

}
