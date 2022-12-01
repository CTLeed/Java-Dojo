package com.codingdojo.zoo;

public class Gorilla extends Mammal {

	public Gorilla() {
		super();
	}

	public void throwSomething() {
		this.energyLevel -= 5;
		System.out.println("The gorilla has thrown something!");
		this.displayEnergy();
	}
	
	public void eatBananas() {
		this.energyLevel += 10;
		System.out.println("The gorilla is very satisfied with the bananas.");
		this.displayEnergy();
	}
	
	public void climb() {
		this.energyLevel -= 10;
		System.out.println("The gorilla has climbed a tree!");
		this.displayEnergy();
	}
}
