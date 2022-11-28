import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


class TestRunAppWhileTwiceWithOption2 {
	// @Test
	// @Timeout(5)
	// void testRunAppUpdateOrderAddPizza() {

	// 	Order.orderCount = 1;
	// 	Pizza.currentId = 1;
	// 	Drink.drinkCount = 1;

	// 	PizzaParlour.runApp("1\nPizza\nS\nPepperoni\n1\nCheckout\nPickup\n2\n1\n1\n1\nL\nNeapolitan\n3\n4\n4\n6\n","Menu.txt").toString();
	// }
	@Test
	@Timeout(5)
	void testRunAppUpdateOrderAddPizza() {

		Order.orderCount = 1;
		Pizza.currentId = 1;
		Drink.drinkCount = 1;

		// PizzaParlour.runApp("1\nPizza\nS\nPepperoni\n1\nCheckout\nPickup\n2\n1\n1\n1\nL\nNeapolitan\n3\n4\n4\n6\n","Menu.txt").toString();
		assertEquals(false, true); 
		// Error couldn't propogate
		// The above statement is there just to signify a potential problem
	}
}
