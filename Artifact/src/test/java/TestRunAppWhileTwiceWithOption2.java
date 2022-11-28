import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


class TestRunAppWhileTwiceWithOption2 {
	@Test
	void testRunAppMenuOnce1IF() {
		ArrayList<Pizza> p = new ArrayList<>();
		p.add(PizzaFactory.makePepperoniPizza('S', 1));
		ArrayList<Order> o = new ArrayList<>();
		Order firstOrder = OrderFactory.getOrder(p, new ArrayList<>(), "309 Pizza Parlour", "Pickup");
		Order.orderCount = 1;
		Pizza.currentId = 1;
		Drink.drinkCount = 1;
		o.add(firstOrder);
		String str = PizzaParlour.runApp("1\nPizza\nS\nPepperoni\n1\nCheckout\nPickup\n6\n","Menu.txt").toString();
		System.out.println(o);
		System.out.println(str);
		// assertEquals(true, false);
		assertEquals(true, o.toString().equals(str));
	}
}
