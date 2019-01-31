package VirtualPetShelter;

import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		VirtualPet pet = new VirtualPet("Spot", "Dog", 10, 10, 10);
		VirtualPetShelter shelterPets = new VirtualPetShelter();
		shelterPets.add(pet);

		System.out.println("Welcome to your Virtual Pet Shelter!");
		System.out.println("There is a dog, Spot, currently in your shelter.");
		System.out.println("Try and keep the Hunger, Thirst, and Play levels at 10.");

		String newName = "";
		String newType = "";
		String showMenu = "\n\t	What would you like to do next?\n" + "\n\t" + "1. Feed the pets\n\t"
				+ "2. Water the pets\n\t" + "3. Play with a pet\n\t" + "4. Adopt a pet\n\t" + "5. Admit a pet\n\t"
				+ "6. Show all pets.\n\t" + "7. Quit\n";

		int userInput = 0;
		String typedIn = "";
		while (!shelterPets.isEmptyShelter()) {
			System.out.println(showMenu);
			boolean validInput = false;
			while (!validInput) {
				try {
					typedIn = input.nextLine();
					if (typedIn.toLowerCase().equals("quit") || typedIn.equals("7")) {
						System.out.println("Thank you for playing");
						System.exit(0);
					}
					Integer.parseInt(typedIn);
					validInput = true;
				} catch (NumberFormatException e) {
					System.out.println("Please enter a whole number");
				}
			}
			userInput = Integer.parseInt(typedIn);
			if (userInput == 1) {
				shelterPets.feedPets();
			} else if (userInput == 2) {
				shelterPets.waterPets();
			} else if (userInput == 3) {
//				shelterPets.playWithPet(petName, amount);
			} else if (userInput == 4) {			
			} else if (userInput == 5) {
				System.out.println("What is the name of the pet?");
				newName = input.nextLine();
				System.out.println("What type of animal is " + newName + "?");
				newType = input.nextLine();
				VirtualPet newPet = new VirtualPet(newName, newType, 10, 10, 10);
				shelterPets.add(newPet);
				newName = "";
				
				newType = "";	
			} else if (userInput == 6) {
				shelterPets.showPets(pet);
			} else {
				System.out.println("That did not make sense... Please check on the pets.");
			}
			
			

		}

		System.out.println("Thank you for playing!");
	}

}
