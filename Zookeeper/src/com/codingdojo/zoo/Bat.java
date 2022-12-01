package com.codingdojo.zoo;

public class Bat extends Mammal {

	public Bat() {
		super();
		this.energyLevel = 300;
	}
	
	public void fly() {
		this.energyLevel -= 50;
		System.out.println("Silence...");
		this.displayEnergy();
	}
	
	public void eatHumans() {
		this.energyLevel += 25;
		System.out.println("Sluuurp");
		this.displayEnergy();
	}
	
	public void attackTown() {
		this.energyLevel -= 100;
		System.out.println("Screams and panic fill the air!");
		this.displayEnergy();
	}

}
