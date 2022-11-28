import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class TestRunApp {
	
//	PizzaParlour p = new PizzaParlour();

	
//	@SuppressWarnings("static-access")
	@Test
	void testRunApp() {
		assertEquals(0, PizzaParlour.runApp("6\n","Menu.txt"));
	}

}
