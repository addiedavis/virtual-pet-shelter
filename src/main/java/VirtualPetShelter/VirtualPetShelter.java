package VirtualPetShelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VirtualPetShelter {

	Map<String, VirtualPet> myShelter = new HashMap<>();

	public void add(VirtualPet pet) {
		myShelter.put(pet.getPetName(), pet);
	}

	public VirtualPet findPet(String petName) {
		return myShelter.get(petName);
	}

	public Collection<VirtualPet> availablePets() {
		return myShelter.values();
	}

	public void adopt(VirtualPet pet) {
		myShelter.remove(pet.getPetName());
	}

	public void playWithPet(String petName, int amount) {
		VirtualPet playBallWithPet = findPet(petName);
		playBallWithPet.playBall(amount);
	}


	public boolean isEmptyShelter() {
		return myShelter.isEmpty();
	}

	public void feedPets() {
		for (VirtualPet entries : availablePets()) {
			entries.feedPet();
		}
	}

	public void waterPets() {
		for (VirtualPet entries : availablePets()) {
			entries.waterPet();
		}
	}

	public void showPets(VirtualPet pet) {
		for (Entry<String, VirtualPet> pets : myShelter.entrySet()) {
			System.out.println("|Name : " + pets.getKey() + " \t|Type : " + pets.getValue().getType() + "\t|Play: "
					+ pets.getValue().getPlayLevel() + "\t|Hunger: " + pets.getValue().getHungerLevel() + "\t|Thirst: "
					+ pets.getValue().getThistLevel());
		}
	}

	public void callTick(VirtualPet adoptablePet) {
		for (VirtualPet entries : availablePets()) {
			entries.tick();
		}
	}

}
