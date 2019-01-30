package VirtualPetShelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> pets = new HashMap<>();

	public void add(VirtualPet pet) {
		pets.put(pet.getPetName(), pet);
	}

	public VirtualPet findPet(String petName) {
		return pets.get(petName);
	}

	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

	public void adopt(VirtualPet pet) {
		pets.remove(pet.getPetName(), pet);
	}

	public void feedPet(String petName, int nom) {
		VirtualPet feedPetNoms = findPet(petName);
		feedPetNoms.feedPet(nom);
	}

	public void waterPet(String petName, int drip) {
		VirtualPet waterPetDrips = findPet(petName);
		waterPetDrips.waterPet(drip);

	}

	public void playWithPet(String petName, int amount) {
		VirtualPet playBallWithPet = findPet(petName);
		playBallWithPet.playBall(amount);
	}

}
