import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


class TestRunAppWhileTwiceWithOption2 {
	@Test
	void testRunAppUpdateOrderAddPizza() {

		Order.orderCount = 1;
		Pizza.currentId = 1;
		Drink.drinkCount = 1;

		// add order
		String o1 = PizzaParlour.runApp("1\nPizza\nS\nPepperoni\n1\nCheckout\nPickup\n2\n1\n1\n1\nL\nNeapolitan\n3\n4\n4\n6\n","Menu.txt").toString();

		// System.out.println(o1);

		// // update order
		// String o2 = PizzaParlour.runApp("2\n1\n1\n1\nL\nNeapolitan\n3\n4\n4\n6\n","Menu.txt").toString();
		
		System.out.println(o1);

		Order.orderCount = 1;
		Pizza.currentId = 1;
		Drink.drinkCount = 1;

		ArrayList<Pizza> p = new ArrayList<>();
		p.add(PizzaFactory.makePepperoniPizza('S', 1));
		p.add(PizzaFactory.makeNeapolitanPizza('L', 3));
		ArrayList<Order> o = new ArrayList<>();
		Order firstOrder = OrderFactory.getOrder(p, new ArrayList<>(), "309 Pizza Parlour", "Pickup");
		o.add(firstOrder);

		System.out.println(o);

		// assertEquals(true, o.toString().equals(o2));
	}
}
