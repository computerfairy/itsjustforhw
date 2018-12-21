import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContact() {
		Contact cont = new Contact("ȫ�浿", "01012345678", "hong@gmail.com");
		assertTrue(cont.getName().equals("ȫ�浿") && cont.getNumber().equals("01012345678") && cont.getEmail().equals("hong@gmail.com"));
	}

	@Test
	void testGetName() {
		Contact cont = new Contact("ȫ�浿", "01012345678", "hong@gmail.com");
		assertEquals("ȫ�浿", cont.getName());
	}

}
