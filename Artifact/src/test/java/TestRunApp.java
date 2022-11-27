import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestRunApp {
	
//	PizzaParlour p = new PizzaParlour();

	
	@SuppressWarnings("static-access")
	@Test
	void testRunApp() {
		assertEquals(1, PizzaParlour.runApp());
	}

}
