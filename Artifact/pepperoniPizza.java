public class pepperoniPizza extends Pizza {
    pepperoniPizza(char size, int quantity){
        super(size, quantity);
        type = "Pepperoni";
        toppings.add("Pepperoni");
    }
}
