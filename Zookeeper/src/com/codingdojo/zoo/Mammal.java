package com.codingdojo.zoo;

public class Mammal {
	protected int energyLevel;

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyChange) {
		System.out.println(energyChange);
		if(energyChange < 0 ) {
			this.energyLevel -= energyChange;			
		} else if(energyChange >= 0) {
			this.energyLevel += energyChange;
		}
	}

	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int displayEnergy() {
		System.out.println("Energy level is: " + this.energyLevel);
		return this.energyLevel;
	}
}
