package VirtualPetShelter;

import java.util.Scanner;

public class VirtualPetShelterApp {

	private static VirtualPet pet1;
	private static VirtualPet pet2;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int action =1;

		System.out.println("Welcome to your Virtual Pet Shelter!");
		System.out.println("There is a cat and a dog currently in your shelter.");
		System.out.println("Try and keep the Hunger, Thirst, and Play levels at 10.");
		System.out.println("Type \"quit\" to stop playing.");

		pet1 = new VirtualPet("Spot", "Dog", 10, 10, 10);
		pet2 = new VirtualPet("Felix", "Cat", 10, 10, 10);
		
		while (action != 0) {
			System.out.println("What would you like to do?\n1-->feed pets\n2-->water pets\n3-->play with a pet\n4-->add pet to shelter\n5-->adopt out a pet");
			System.out.println("|Name\t|Type\t|Hunger\t|Thirst\t|Play");
			System.out.println("|" + pet1.getPetName() + "\t|" + pet1.getType() + "\t|" + pet1.getHungerLevel() + "\t|" + pet1.getThistLevel() + "\t|" + pet1.getPlayLevel());
			action = 0;
		}
		
		System.out.println("Thank you for playing!");
	}

}
