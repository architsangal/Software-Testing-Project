import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


class TestRunAppWhileOnceAndTwiceWithOption5 {
	@Test
	void whileLoopOnce() {
		assertEquals(new ArrayList<>(), PizzaParlour.runApp("6\n","Menu.txt"));
	}
	@Test
	void testRunAppMenuOnce1While() {
		assertEquals(new ArrayList<>(), PizzaParlour.runApp("5\nFull\nDone\n6\n","Menu.txt"));
	}
	@Test
	void testRunAppMenuOnce2While() {
		assertEquals(new ArrayList<>(), PizzaParlour.runApp("5\nPizzas\nDone\n6\n","Menu.txt"));
	}
	@Test
	void testRunAppMenuOnce3While() {
		assertEquals(new ArrayList<>(), PizzaParlour.runApp("5\nToppings\nDone\n6\n","Menu.txt"));
	}
	@Test
	void testRunAppMenuOnce4While() {
		assertEquals(new ArrayList<>(), PizzaParlour.runApp("5\nDrinks\nDone\n6\n","Menu.txt"));
	}
	@Test
	void testRunAppMenuTwice1While() {
		assertEquals(new ArrayList<>(), PizzaParlour.runApp("5\nFull\nFull\nDone\n6\n","Menu.txt"));
	}
	@Test
	void testRunAppMenuTwice2While() {
		assertEquals(new ArrayList<>(), PizzaParlour.runApp("5\nFull\nPizzas\nDone\n6\n","Menu.txt"));
	}
	@Test
	void testRunAppMenuTwice3While() {
		assertEquals(new ArrayList<>(), PizzaParlour.runApp("5\nFull\nToppings\nDone\n6\n","Menu.txt"));
	}
	@Test
	void testRunAppMenuTwice4While() {
		assertEquals(new ArrayList<>(), PizzaParlour.runApp("5\nFull\nDrinks\nDone\n6\n","Menu.txt"));
	}
	@Test
	void testRunAppInvalidOnce() {
		assertEquals(new ArrayList<>(), PizzaParlour.runApp("7\n6\n","Menu.txt"));
	}
	@Test
	void testRunAppInvalidTwice() {
		assertEquals(new ArrayList<>(), PizzaParlour.runApp("7\n7\n6\n","Menu.txt"));
	}
}
