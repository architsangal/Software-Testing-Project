import java.util.List;

public class customPizza extends Pizza {
    customPizza(char size, int quantity, List<String> pizzaToppings){
        super(size, quantity);
        type = "Custom";
        toppings = pizzaToppings;
    }
}