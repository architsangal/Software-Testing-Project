import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestRunApp {
	
//	PizzaParlour p = new PizzaParlour();

	
//	@SuppressWarnings("static-access")
	@Test
	void testRunApp() {
		assertEquals(new ArrayList<>(), PizzaParlour.runApp("5\nFull\nDone\n6\n","Menu.txt"));
	}
}
