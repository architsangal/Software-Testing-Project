public class vegetarianPizza extends Pizza {
    vegetarianPizza(char size, int quantity){
        super(size, quantity);
        type = "Vegetarian";
        toppings.add("Tomatoes");
        toppings.add("Olives");
        toppings.add("Mushrooms");
        toppings.add("Jalapenos");
    }
}