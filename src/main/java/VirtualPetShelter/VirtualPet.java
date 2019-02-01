package VirtualPetShelter;

public class VirtualPet {

	private String petName;
	private String petType;
	private int hungerLevel;
	private int thirstLevel;
	private int playLevel;

	public String getPetName() {
		return petName;
	}

	public Object getType() {
		return petType;
	}

	public Object getHungerLevel() {
		return hungerLevel;
	}

	public Object getThistLevel() {
		return thirstLevel;
	}

	public Object getPlayLevel() {
		return playLevel;
	}

	public VirtualPet(String petName, String petType, int hungerLevel, int thirstLevel, int playLevel) {
		this.petName = petName;
		this.petType = petType;
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
		this.playLevel = playLevel;
	}

	public void feedPet() {
		hungerLevel++;
	}

	public void waterPet() {
		thirstLevel++;
	}

	public void playBall(int amount) {
		playLevel += amount;
	}

	public void tick() {
		hungerLevel--;
		thirstLevel--;
		playLevel--;
		if (hungerLevel < 0) {
			hungerLevel = 0;
		}
		if (thirstLevel < 0) {
			thirstLevel = 0;
		}
		if (playLevel < 0) {
			playLevel = 0;
		}
	}




}
