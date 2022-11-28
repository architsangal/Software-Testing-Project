import java.util.List;

public class OrderFactory {
	// compressed 1013
    static Order getOrder(List<Pizza> pizzas, List<Drink> drinks, String address, String type) { // Node 48
        switch (type) {// Node 49
            case "Pickup": // Node 50
                return new PickupOrder(pizzas, drinks); // Node 51
            case "Delivery": // Node 52
                return new DeliveryOrder(pizzas, drinks, address); // Node 53
            case "Uber": // Node 54
                return new UberOrder(pizzas, drinks, address); // Node 55
            case "Foodora": // Node 56
                return new FoodoraOrder(pizzas, drinks, address); // Node 57
            default: // Node 58
                return null; // Node 59
        }
    }
}
