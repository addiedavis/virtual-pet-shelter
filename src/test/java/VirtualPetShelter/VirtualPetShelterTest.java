package VirtualPetShelter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest;
	VirtualPet pet1;
	VirtualPet pet2;
	VirtualPet pet3;

	@Before
	public void setUp() {
		underTest = new VirtualPetShelter();
		pet1 = new VirtualPet("Joe", "Dog", 10, 10, 10);
		pet2 = new VirtualPet("Beezle", "Cat", 10, 10, 10);
		pet3 = new VirtualPet("Bub", "Bird", 1, 1, 1);
		// String name, String type, int hungerLevel, int thirstLevel, int playLevel
	}

	@Test
	public void shouldBeAbleToAddAPet() {
		underTest.add(pet1);
		VirtualPet retrievePet = underTest.findPet("Joe");
		assertThat(retrievePet, is(pet1));
	}

	@Test
	public void shouldBeAbleToAddTwoPets() {
		underTest.add(pet1);
		underTest.add(pet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertThat(allPets, containsInAnyOrder(pet1, pet2));
	}

	@Test
	public void getPetAttributesNameTypeHungerThirstPlay() {
		underTest.add(pet1);
		assertThat(pet1.getPetName(), is("Joe"));
		assertThat(pet1.getType(), is("Dog"));
		assertThat(pet1.getHungerLevel(), is(10));
		assertThat(pet1.getThistLevel(), is(10));
		assertThat(pet1.getPlayLevel(), is(10));
	}

	@Test
	public void shouldBeAbleToAdoptAPet() {
		underTest.add(pet1);
		underTest.adopt(pet1);
		VirtualPet retrievePet = underTest.findPet(pet1.getPetName());
		assertThat(retrievePet, is(nullValue()));
	}

	@Test
	public void feedPetsInShelter() {
		underTest.add(pet1);
		underTest.feedPet(pet1.getPetName(), 1);
		assertThat(pet1.getHungerLevel(), is(11));
	}

	@Test
	public void waterPetsInShelter() {
		underTest.add(pet1);
		underTest.waterPet(pet1.getPetName(), 1);
		assertThat(pet1.getThistLevel(), is(11));
	}

	@Test
	public void playWithSinglePet() {
		underTest.add(pet1);
		underTest.playWithPet(pet1.getPetName(), 1);
		assertThat(pet1.getPlayLevel(), is(11));
	}

	@Test
	public void doesGameTick1DecreaseHungerThirstAndPlayBy1() {
		underTest.add(pet1);
		underTest.gameTick1(pet1.getPetName(), 1);
		assertThat(pet1.getHungerLevel(), is(9));
		assertThat(pet1.getThistLevel(), is(9));
		assertThat(pet1.getPlayLevel(), is(9));
	}

	@Test
	public void doesGameTick2DecreaseHungerbyandPlayBy1LeaveThirstAlone() {
		underTest.add(pet1);
		underTest.gameTick2(pet1.getPetName(), 1);
		assertThat(pet1.getHungerLevel(), is(9));
		assertThat(pet1.getThistLevel(), is(10));
		assertThat(pet1.getPlayLevel(), is(9));
	}

	@Test
	public void doesGameTick3DecreaseOnlyPlay() {
		underTest.add(pet1);
		underTest.gameTick3(pet1.getPetName(), 1);
		assertThat(pet1.getHungerLevel(), is(10));
		assertThat(pet1.getThistLevel(), is(10));
		assertThat(pet1.getPlayLevel(), is(9));
	}

	@Test
	public void levelsCannotGetBelowZeroTick1With1Down() {
		underTest.add(pet3);
		underTest.gameTick1(pet3.getPetName(), 1);
		assertThat(pet3.getHungerLevel(), is(0));
		assertThat(pet3.getThistLevel(), is(0));
		assertThat(pet3.getPlayLevel(), is(0));
	}

	@Test
	public void levelsCannotGetBelowZeroTick1With2Down() {
		underTest.add(pet3);
		underTest.gameTick1(pet3.getPetName(), 2);
		assertThat(pet3.getHungerLevel(), is(0));
		assertThat(pet3.getThistLevel(), is(0));
		assertThat(pet3.getPlayLevel(), is(0));
	}

	@Test
	public void levelsCannotGetBelowZeroTick2With1Down() {
		underTest.add(pet3);
		underTest.gameTick2(pet3.getPetName(), 1);
		assertThat(pet3.getHungerLevel(), is(0));
		assertThat(pet3.getThistLevel(), is(1));
		assertThat(pet3.getPlayLevel(), is(0));
	}

	@Test
	public void levelsCannotGetBelowZeroTick2With2Down() {
		underTest.add(pet3);
		underTest.gameTick2(pet3.getPetName(), 2);
		assertThat(pet3.getHungerLevel(), is(0));
		assertThat(pet3.getThistLevel(), is(1));
		assertThat(pet3.getPlayLevel(), is(0));
	}

	@Test
	public void levelsCannotGetBelowZeroTick3With1Down() {
		underTest.add(pet3);
		underTest.gameTick3(pet3.getPetName(), 1);
		assertThat(pet3.getHungerLevel(), is(1));
		assertThat(pet3.getThistLevel(), is(1));
		assertThat(pet3.getPlayLevel(), is(0));
	}

	@Test
	public void levelsCannotGetBelowZeroTick3With2Down() {
		underTest.add(pet3);
		underTest.gameTick3(pet3.getPetName(), 2);
		assertThat(pet3.getHungerLevel(), is(1));
		assertThat(pet3.getThistLevel(), is(1));
		assertThat(pet3.getPlayLevel(), is(0));
	}

	@Test
	public void seeIfIndividualPetIsAlive() {
		underTest.add(pet1);
		assertThat(pet1.isAlive(), is(true));
	}

}
