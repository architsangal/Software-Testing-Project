import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    static private Map<String, String> pizzas = new HashMap<>();
    static private Map<String, String> toppings = new HashMap<>();
    static private Map<String, String> drinks = new HashMap<>();
    static private Map<String, Float> prices = new HashMap<>();

    // Compressed Node 5
    static void setMenu(String menuName){ // Node 81
        // CREDIT https://www.journaldev.com/709/java-read-file-line-by-line
        BufferedReader reader; // Node 82
        try {
        	
        	// Node 83
            reader = new BufferedReader(new FileReader("src/main/java/"+menuName)); // Node 83a
            String item = reader.readLine().trim();// Node 83b
            item = reader.readLine().trim(); // Need to skip a line// Node 83c
            // --------------------------------------------------------
            
            while (!item.equals("TOPPINGS")) { // Node 84
            	
            	// Node 85
                String delims = "[_]";
                String[] pizzaTokens = item.split(delims);
                pizzas.put(pizzaTokens[0], pizzaTokens[1]);
                String[] priceTokens = pizzaTokens[1].split(" ");
                int index = 0;
                float price;
                // ------------------------------------------------------
                
                for (String s : priceTokens) { // Node 86
                    index += 1; // Node 87
                    if (s.equals("S:")) {
                    	// Node 88
                        price = Float.parseFloat((priceTokens[index].substring(1)));
                        prices.put(pizzaTokens[0]+"_S", price);
                        // --------------------------------------
                    } else if (s.equals("M:")) {
                    	// Node 89
                        price = Float.parseFloat((priceTokens[index].substring(1)));
                        prices.put(pizzaTokens[0]+"_M", price);
                        // --------------------------------------
                    } else if (s.equals("L:")) {
                    	// Node 90
                        price = Float.parseFloat((priceTokens[index].substring(1)));
                        prices.put(pizzaTokens[0]+"_L", price);
                        // --------------------------------------
                    }
                }
                item = reader.readLine(); // Node 91
            }
            item = reader.readLine(); // Node 92
            while (!item.equals("DRINKS")) { // Node 93
            	// Node 94
                String delims = "[_]";
                String[] toppingTokens = item.split(delims);
                toppings.put(toppingTokens[0], toppingTokens[1]);
                String toppingPrice = toppingTokens[1].substring(1);
                prices.put(toppingTokens[0], Float.parseFloat(toppingPrice));
                //----------------------------------------------
                item = reader.readLine(); // Node 95
            }
            item = reader.readLine(); // Node 96
            while (item != null) { // Node 97
            	
            	// Node 98
                String delims = "[_]";
                String[] drinkTokens = item.split(delims);
                drinks.put(drinkTokens[0], drinkTokens[1]);
                String drinkPrice = drinkTokens[1].substring(1);
                prices.put(drinkTokens[0], Float.parseFloat(drinkPrice));
                
                // ------------------------------------
                item = reader.readLine();// Node 99
            }
            reader.close();// Node 100
        } catch (IOException e) { // Node 101
            e.printStackTrace();
        }
        
        // Node 102 return;
    }
    
    // Compressed Node 41
	static String displayMenu(String userCommand) {
		// Node 103
        String delims = "[-]";
        String[] commandTokens = userCommand.split(delims);
        String command = commandTokens[1];
        String msg = command + " is not a valid menu item";
        // ----------------------------------------------------------
        switch (command) {// Node 104
            case "Full":
                msg = displayFullMenu(); // Node 105
                break;
            case "Pizzas":
                msg = displayPizzaMenu(); // Node 106
                break;
            case "Toppings":
                msg = displayToppingsMenu(); // Node 107
                break;
            case "Drinks":
                msg = displayDrinksMenu(); // Node 108
                break;
            default:
                String value = pizzas.get(command);// Node 109
                if (value != null) { // Node 110
                    msg = command + " ==> " + value;
                }
                value = toppings.get(command); // Node 111
                if (value != null) { // Node 112
                    msg = command + " ==> " + value;
                }
                value = drinks.get(command); // Node 113
                if (value != null) { // Node 114
                    msg = command + " ==> " + value;
                }
                //System.out.println(msg);
                break;
        }
        return msg; // Node 115
    }
	
	// Compressed Node 105
    private static String displayFullMenu(){
        return displayPizzaMenu() // Node 106
        		+ displayToppingsMenu() // Node 107 
        		+ displayDrinksMenu(); // Node 108
        // Node 109 return;
    }

    // Compressed Node 106
    private static String displayPizzaMenu() { 
        String result = "== PIZZAS ==============================\n";// Node 116
        //System.out.println("== PIZZAS ==============================");
        for (String key : pizzas.keySet()){ // Node 117
            result = String.format("%s%s\n", result, key + " ==> " + pizzas.get(key)); // Node 118
        }
        return result; // Node 119
    }

    // Compressed Node 107
    private static String displayToppingsMenu() {
        String result = " == TOPPINGS ==============================\n";
        //System.out.println(" == TOPPINGS ==============================");
        for (String key : toppings.keySet()) {
            result = String.format("%s%s ==> %s\n", result, key, toppings.get(key));
        }
        return result;
    }

    // Compressed Node 108
    private static String displayDrinksMenu() {
        StringBuilder result = new StringBuilder("== DRINKS ==============================\n");
        //System.out.println("== DRINKS ==============================");
        for (String key : drinks.keySet()){
            result.append(key).append(" ==> ").append(drinks.get(key)).append("\n");
        }
        return result.toString();
    }

    // Compressed Node 12
    static String getTotal(Order order){ // Node 70
        double total = 0.0; // Node 71
        for (Pizza p: order.getPizzas()){ // Node 72
        	
        	// Node 73
            String item = p.getType() + " Pizza_" + p.getSize();
            double price = prices.get(item);
            // --------------------------------

            if (p.getType().equals("Custom")){ // Node 74
                for (String t: p.getToppings()){ // Node 75
                    price += prices.get(t); // Node 76
                }
            }
            total += price * p.getQuantity(); // Node 77
        }
        for (Drink d: order.getDrinks()){ // Node 78
            total += prices.get(d.getName()) * d.getQuantity(); // Node 79
        }
        return "Total: $" + Double.toString(total); // Node 80
    }
}
