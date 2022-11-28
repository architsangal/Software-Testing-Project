import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


class TestRunAppWhileTwiceWithOption1 {
	@Test
	void testRunAppMenuOnce1IF() {
		System.out.println(PizzaParlour.runApp("1\nPizza\nS\nPepperoni\n1\nCheckout\nPickup\n6\n","Menu.txt"));
		// assertEquals(new ArrayList<>(), PizzaParlour.runApp("1\nPizza\nS\nPepperoni\n1\nCheckout\nPickup\n6\n","Menu.txt"));
	}
}
