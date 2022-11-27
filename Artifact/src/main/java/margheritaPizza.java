public class margheritaPizza extends Pizza {
    margheritaPizza(char size, int quantity){
        super(size, quantity);
        type = "Margherita";
        toppings.add("Tomatoes");
        toppings.add("Olives");
    }
}
