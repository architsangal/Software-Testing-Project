public class neapolitanPizza extends Pizza {
    neapolitanPizza(char size, int quantity){
        super(size, quantity);
        type = "Neapolitan";
        toppings.add("Tomatoes");
    }
}