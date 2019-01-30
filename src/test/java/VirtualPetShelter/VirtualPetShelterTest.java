package VirtualPetShelter;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {
	
	Pet underTest;
	
	@Before
	public void setUp() {
		underTest = new Pet();
		pet1 = new shelterPet("Joe", "Dog", 10, 10, 10);
		//name, type, hunger, thirst, playlevel
	}
	
	@Test
	public void shouldBeAbleToAddAPet() {
		
	}
}
