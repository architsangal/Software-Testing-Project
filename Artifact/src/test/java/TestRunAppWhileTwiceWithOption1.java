import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


class TestRunAppWhileTwiceWithOption1 {
	@Test
	void testRunAppCreateOrderOnce() {

		// Infesible Test Case

		List<Order> res = PizzaParlour.runApp("1\nCheckout\nPickup\n6\n","Menu.txt");
		assertEquals(new ArrayList<>(), res);
	}

	@Test
	void testRunAppCreateOrderTwice() {
		Order.orderCount = 1;
		Pizza.currentId = 1;
		Drink.drinkCount = 1;

		String str = PizzaParlour.runApp("1\nPizza\nS\nPepperoni\n1\nCheckout\nPickup\n6\n","Menu.txt").toString();

		Order.orderCount = 1;
		Pizza.currentId = 1;
		Drink.drinkCount = 1;

		ArrayList<Pizza> p = new ArrayList<>();
		p.add(PizzaFactory.makePepperoniPizza('S', 1));
		ArrayList<Order> o = new ArrayList<>();
		Order firstOrder = OrderFactory.getOrder(p, new ArrayList<>(), "309 Pizza Parlour", "Pickup");
		o.add(firstOrder);

		System.out.println(o);
		System.out.println(str);

		assertEquals(true, o.toString().equals(str));
	}

	@Test
	void testRunAppCreateOrderCancellingOrderWhileChoosingSize() {
		Order.orderCount = 1;
		Pizza.currentId = 1;
		Drink.drinkCount = 1;

		List<Order> orderList = PizzaParlour.runApp("1\nPizza\nCancel\nCheckout\nPickup\n6\n","Menu.txt");

		assertEquals(new ArrayList<>(), orderList);
	}


	@Test
	void testRunAppCreateOrderCustomPizza() {
		Order.orderCount = 1;
		Pizza.currentId = 1;
		Drink.drinkCount = 1;

		List<Order> orderList = PizzaParlour.runApp("1\nPizza\nM\nCustom\nJalapenos\nMushrooms\nUndo\nDone\n1\nCheckout\nDelivery\n309 Pizza Parlour\n6\n","Menu.txt");
		System.out.println(orderList);

		Order.orderCount = 1;
		Pizza.currentId = 1;
		Drink.drinkCount = 1;

		ArrayList<Pizza> p = new ArrayList<>();
		ArrayList<String> toppings = new ArrayList<>();
		toppings.add("Jalapenos");
		p.add(PizzaFactory.makeCustomPizza('M', 1, toppings));
		ArrayList<Order> o = new ArrayList<>();
		Order firstOrder = OrderFactory.getOrder(p, new ArrayList<>(), "309 Pizza Parlour", "Pickup");
		o.add(firstOrder);

		System.out.println(o);
		assertEquals(true, o.toString().equals(orderList.toString()));
	}

	@Test
	void testRunAppCreateOrderDrinks() {
		Order.orderCount = 1;
		Pizza.currentId = 1;
		Drink.drinkCount = 1;

		List<Order> orderList = PizzaParlour.runApp("1\nDrink\nM\n4\n2\nCheckout\nFoodora\n309 Pizza Parlour\n6\n","Menu.txt");
		System.out.println(orderList);

		Order.orderCount = 1;
		Pizza.currentId = 1;
		Drink.drinkCount = 1;

		ArrayList<Drink> d = new ArrayList<>();
		d.add(new Drink("Pepsi",2));
		ArrayList<Order> o = new ArrayList<>();
		Order firstOrder = OrderFactory.getOrder(new ArrayList<>(), d, "309 Pizza Parlour", "Pickup");
		o.add(firstOrder);

		assertEquals(true, o.toString().equals(orderList.toString()));
	}
}
