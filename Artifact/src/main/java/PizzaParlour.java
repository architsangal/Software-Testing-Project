import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
// Stubed
// import org.json.JSONObject;

public class PizzaParlour {

    private static boolean isInteger(String possibleInt) throws NumberFormatException, NullPointerException {
        // CREDIT: https://www.baeldung.com/java-check-string-number
        try {
            Integer.parseInt(possibleInt);
        }
        catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    private static boolean isPositiveInteger(String possiblePosInt) {
        return isInteger(possiblePosInt) && Integer.valueOf(possiblePosInt) > 0;
    }

    // compressed 1006
    static Drink getDrinksLoop(Scanner scanner) {
    	// 1044
        Map<String, String> validDrinks = new HashMap<>();
        validDrinks.put("1", "Coke");
        validDrinks.put("2", "Diet Coke");
        validDrinks.put("3", "Coke Zero");
        validDrinks.put("4", "Pepsi");
        validDrinks.put("5", "Diet Pepsi");
        validDrinks.put("6", "Dr. Pepper");
        validDrinks.put("7", "Water");
        validDrinks.put("8", "Juice");
        validDrinks.put("9", "Cancel");
        String userInput;
        // -------

        while (true) { // 1045
        	
        	// 1046
            System.out.println("What drink do you want? Enter a number for the corresponding drink:");
            System.out.println("[(1) Coke, (2) Diet Coke, (3) Coke Zero, (4) Pepsi, (5) Diet Pepsi, (6) Dr. Pepper, (7) Water, (8) Juice, (9) Cancel]");
            userInput = scanner.nextLine().trim();
            // -------
            if (validDrinks.containsKey(userInput)) {
                if (userInput.equals("9")) { // 1047
                    return null; // 1048
                }
                break;
            }
        } // 1049
        
        // 1050
        String name = validDrinks.get(userInput);

        Integer quantity;
        // ----
        while (true) { // 1051
        	
        	// 1052
            System.out.println("How many of this drink do you want?");
            System.out.println("[Enter a number > 0 or type 'Cancel']");
            userInput = scanner.nextLine().trim();
            // ------
            
            if (userInput.equals("Cancel")) {
                return null; // 1053
            }
            else if (isPositiveInteger(userInput)) {
                quantity = Integer.valueOf(userInput); // 1054
                break;
            }
        }

        return new Drink(name, quantity); // 1055
    }

    
    // compressed node 1004
    static Pizza getPizzasLoop(Scanner scanner) {
    	// node 1014
        List<String> validSizes = new ArrayList<>(Arrays.asList("S", "M", "L", "Cancel"));
        List<String> validTypes = new ArrayList<>(Arrays.asList("Pepperoni", "Margherita", "Vegetarian", "Neapolitan", "Custom", "Cancel"));
        List<String> validToppings = new ArrayList<>(Arrays.asList("Olives", "Tomatoes", "Mushrooms", "Jalapenos", "Chicken", "Beef", "Pepperoni", "Undo", "Done", "Cancel"));
        String userInput;

        char size;
        // --------
        
        while (true) { // node 1015
        	// node 1016
            System.out.println("What size pizza do you want? Enter one of the following commands:");
            System.out.println("[S, M, L, Cancel]");
            userInput = scanner.nextLine().trim();
            
            if (userInput.equals("Cancel")) {
                return null; // node 1017
            } else if (validSizes.contains(userInput)) {
                break;
            }
        } // node 1018
        
        // node 1019
        size = userInput.charAt(0);

        String type;
        // -----
        while (true) { // node 1020
        	
        	// node 1021
            System.out.println("What type of pizza do you want?");
            System.out.println("[Pepperoni, Margherita, Vegetarian, Neapolitan, Custom, Cancel]");
            userInput = scanner.nextLine().trim();
            // -------
            if (userInput.equals("Cancel")) {
                return null; // 1022
            } else if (validTypes.contains(userInput)) {
                break;
            }
        } // 1023
        
        // 1024
        type = userInput;

        List<String> toppings = new ArrayList<>();
        // --------
        if (type.equals("Custom")) {
        	// 1025
            String next_topping = "SENTINEL";
            while (!next_topping.equals("Done")) { // 1026
            	
            	// 1027
                System.out.println("Pick a topping! [Olives, Tomatoes, Mushrooms, Jalapenos, Chicken, Beef, Pepperoni, Undo, Done, Cancel]");
                next_topping = scanner.nextLine().trim();
                // ---
                if (next_topping.equals("Cancel")) {
                    return null; // 1028
                } else if (next_topping.equals("Done")) {
                    break;
                } else if (next_topping.equals("Undo")) {
                    if (toppings.size() > 0) { // 1029
                        toppings.remove(toppings.size() - 1); // 1031
                    }
                } else if (validToppings.contains(next_topping)) {
                    toppings.add(next_topping); // 1033
                }
            }
        } // 1032

        int quantity; // 1030
        while (true) { // 1034
        	
        	// 1035
            System.out.println("How many pizzas do you want? Enter a number > 0 or 'Cancel'");
            userInput = scanner.nextLine().trim();
            // ----
            
            if (userInput.equals("Cancel")) {
                return null;
            } else if (isPositiveInteger(userInput)) {
                break;
            }
        }
        
        // 1037
        quantity = Integer.parseInt(userInput);

        Pizza customerPizza = null;
        switch (type) {
            case "Pepperoni":
                customerPizza = PizzaFactory.makePepperoniPizza(size, quantity); // 1038
                break;
            case "Margherita":
                customerPizza = PizzaFactory.makeMargheritaPizza(size, quantity); // 1039
                break;
            case "Vegetarian":
                customerPizza = PizzaFactory.makeVegetarianPizza(size, quantity); // 1040
                break;
            case "Neapolitan":
                customerPizza = PizzaFactory.makeNeapolitanPizza(size, quantity); // 1041
                break;
            case "Custom":
                customerPizza = PizzaFactory.makeCustomPizza(size, quantity, toppings); // 1042
                break;
        }

        return customerPizza; // 1043
    }

    // compressed 1008
    private static String[] getAddressAndDelivery(Scanner scanner) {
    	// 1057
        String[] addressAndDelivery = new String[2];
        List<String> validDeliveries = new ArrayList<>(Arrays.asList("Pickup", "Delivery", "Uber", "Foodora"));
        String userInput;
        // -------
        
        while (true) { // 1058
        	
        	// 1059
            System.out.println("What delivery type do you want? Option 2 uses our parlour's own delivery system.");
            System.out.println("[Pickup, Delivery, Uber, Foodora, Cancel]");
            userInput = scanner.nextLine().trim();
            // ------
            
            if (userInput.equals("Cancel")) {
                return null; // 1060
            } else if (validDeliveries.contains(userInput)) {
                break;
            }
        }
        addressAndDelivery[1] = userInput; // 1061
        
        if (!addressAndDelivery[1].equals("Pickup")) {
        	// 1062
            System.out.println("Please enter your address:");
            userInput = scanner.nextLine().trim();
            // --------
            if (userInput.equals("Cancel")) {
                return null; // 1063
            }
            addressAndDelivery[0] = userInput; // 1064
        }

        return addressAndDelivery; // 1065
    }

    // Compressed Node 9
    static Order createOrder(Scanner newOrderScanner) {
        // node 1001
    	List<Pizza> pizzas = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        String address;
        String type;

        String userInput;
        // ----------
        
        label:
        while (true) { // node 1002
        	// node 1003
            System.out.println("What would you like to order? Enter one of the following commands:");
            System.out.println("[Pizza, Drink, Checkout, Cancel]");
            userInput = newOrderScanner.nextLine().trim();
            // ------------------------
            switch (userInput) {
                case "Pizza":
                    Pizza nextPizza = getPizzasLoop(newOrderScanner); // node 1004
                    if (nextPizza != null) {
                        pizzas.add(nextPizza); // node 1005
                    }
                    break;
                case "Drink":
                    Drink nextDrink = getDrinksLoop(newOrderScanner); // node 1006
                    if (nextDrink != null) {
                        drinks.add(nextDrink); // node 1007
                    }
                    break;
                case "Checkout":
                    String[] addressAndDelivery = getAddressAndDelivery(newOrderScanner); // node 1008
                    if (addressAndDelivery == null) {
                        return null; // node 1009
                    }
                    
                    // node 1010
                    address = addressAndDelivery[0];
                    type = addressAndDelivery[1];
                    // -----
                    break label;
                case "Cancel":
                    return null; // node 1011
            }
        
        } // node 1012

        return OrderFactory.getOrder(pizzas, drinks, address, type); // node 1013
    }

    // Compressed 15
    private static int getOrderNumber(List<Order> orders, Scanner scanner) {
    	// 1066 to 1069
        for (Order order : orders) {
            System.out.println(order); /// 1068
        }
        // ---------
        
        // 1070
        System.out.println("Choose an order number or 'Cancel':");
        String userInput = scanner.nextLine().trim();
        // ------
        if (userInput.equals("Cancel") || !isPositiveInteger(userInput)) {
            return -1; // 1071
        }
        return Integer.valueOf(userInput); // 1072
    }

    // compressed Node 24
    private static int getOrderIndex(List<Order> orders, int orderNumber) {

        // 1072 to 1076
        for (int i = 0; i < orders.size(); i += 1) {
            if (orders.get(i).getOrderNum() == orderNumber) {
                return i; // 1075
            }
        }
        // -------

        return -1; // 1077
    }


    // Compressed 40
    private static String getMenuCommandFromUser(Scanner scanner) {
        System.out.println("Enter one of the following commands:");
        System.out.println("'Full': the full menu");
        System.out.println("'Pizzas': the pizzas");
        System.out.println("'Toppings': the toppings");
        System.out.println("'Drinks': the drinks");
        System.out.println("You can also get an individual item such as 'Coke' or 'Beef'");
        System.out.println("Type 'Done' to exit the menu");
        return scanner.nextLine().trim();
    }

    // Compressed Node 41
    private static String getMenuInfo(String command) {
        return Menu.displayMenu("Menu-" + command);
    }

    // Compressed 32
    private static String submitPickup(Order order) {
        String result = "Your order will be available for pickup in 15 to 20 minutes. You are order #";
        result += String.valueOf(order.getOrderNum());
        result += "!";
        return result;
    }

    // Compressed 33
    static String submitDelivery(Order order) {
        String result = "Your order #" + String.valueOf(order.getOrderNum()) + " will be delivered as soon as possible to: ";
        result += order.getAddress();
        result += "!";
        return result;
    }

    // Compressed 34
    static String submitUber(Order order) {
        // Stub Called
        // JSONObject orderJson = new JSONObject();
        // orderJson.put("Address", order.getAddress());
        // orderJson.put("Order Number", order.getOrderNum());
        // String pizzas = order.getPizzas().toString();
        // String drinks = order.getDrinks().toString();
        // String orderDetails = "Pizzas: " + pizzas + " & " + "Drinks: " + drinks;
        // orderJson.put("Order Details", orderDetails);
        // String result = orderJson.toString();
        // try (PrintWriter o = new PrintWriter(System.getProperty("user.dir") + "/Result.txt")) {
        //     o.println(result);
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // }
        // return result;
        return "Stub Called";
    }

    // Compressed 35
    static String submitFoodora(Order order) {
        // Create comma separated line for each part of delivery details
        String result = "";
        String address = "Address," + order.getAddress() + "\n";
        String pizzas = order.getPizzas().toString();
        String drinks = order.getDrinks().toString();
        String foodDetails = "Pizzas: " + pizzas + " & " + "Drinks: " + drinks;
        String orderDetails = "Order Details," + foodDetails + "\n";
        String orderNumber = "Order Number," + order.getOrderNum() + "\n";
        result += address;
        result += orderDetails;
        result += orderNumber;
        try (PrintWriter o = new PrintWriter("src/main/java/Result.txt")) {
        // try (PrintWriter o = new PrintWriter(System.getProperty("user.dir") + "/Result.txt")) {
            o.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }


    static String getUserAddress(Scanner scanner) {
        System.out.println("Please enter your address:");
        return scanner.nextLine().trim();
    }


    static int getDrinkNumber(List<Drink> drinks, Scanner scanner) {
        for (Drink drink : drinks) {
            System.out.println(drink);
        }
        System.out.println("Choose a drink number or 'Cancel':");
        String userInput = scanner.nextLine().trim();
        if (userInput.equals("Cancel") || !isPositiveInteger(userInput)) {
            return -1;
        }
        return Integer.valueOf(userInput);
    }


    static int getDrinkIndex(List<Drink> drinks, int drinkNumber) {
        for (int i = 0; i < drinks.size(); i += 1) {
            if (drinks.get(i).getDrinkNum() == drinkNumber) {
                return i;
            }
        }
        return -1;
    }


    private static Drink changeDrink(Drink drink, Scanner scanner) {
        System.out.println(drink);
        System.out.println("Enter a new quantity [provide a number > 0]:");
        String userInput = scanner.nextLine().trim();
        if (isPositiveInteger(userInput) && Integer.valueOf(userInput) > 0) {
            drink.setQuantity(Integer.valueOf(userInput));
        }
        return drink;
    }


    static List<Drink> updateDrinks(List<Drink> drinks, Scanner scanner) {
        String userInput = "";
        while (!userInput.equals("4")) {
            System.out.println("Enter a number for the corresponding command:");
            System.out.println("[(1) Add Drink, (2) Remove Drink, (3) Change Drink, (4) Done]");
            userInput = scanner.nextLine().trim();
            if (userInput.equals("1")) {
                Drink drink = getDrinksLoop(scanner);
                drinks.add(drink);
            } else if (userInput.equals("2")) {
                int drinkNumber = getDrinkNumber(drinks, scanner);
                if (drinkNumber != -1) {
                    int drinkIndex = getDrinkIndex(drinks, drinkNumber);
                    if (drinkIndex != -1) {
                        drinks.remove(drinkIndex);
                    }
                }
            } else if (userInput.equals("3")) {
                int drinkNumber = getDrinkNumber(drinks, scanner);
                if (drinkNumber != -1) {
                    int drinkIndex = getDrinkIndex(drinks, drinkNumber);
                    if (drinkIndex != -1) {
                        Drink drink = drinks.get(drinkIndex);
                        Drink newDrink = changeDrink(drink, scanner);
                        drinks.set(drinkIndex, newDrink);
                    }
                }
            }
        }
        return drinks;
    }


    private static int getPizzaNumber(List<Pizza> pizzas, Scanner scanner) {
        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }
        System.out.println("Choose a pizza number or 'Cancel':");
        String userInput = scanner.nextLine().trim();
        if (userInput.equals("Cancel") || !isPositiveInteger(userInput)) {
            return -1;
        }
        return Integer.valueOf(userInput);
    }


    private static int getPizzaIndex(List<Pizza> pizzas, int pizzaNumber) {
        for (int i = 0; i < pizzas.size(); i += 1) {
            if (pizzas.get(i).getPizzaId() == pizzaNumber) {
                return i;
            }
        }
        return -1;
    }


    private static Pizza changePizza(Pizza pizza, Scanner scanner) {
        System.out.println(pizza);
        List<String> validSizes = new ArrayList<>(Arrays.asList("S", "M", "L"));
        List<String> validTypes = new ArrayList<>(Arrays.asList("Pepperoni", "Margherita", "Vegetarian", "Neapolitan", "Custom"));
        List<String> validToppings = new ArrayList<>(Arrays.asList("Olives", "Tomatoes", "Mushrooms", "Jalapenos", "Chicken", "Beef", "Pepperoni", "Undo", "Done"));
        String userInput;

        char size = pizza.getSize();
        int quantity = pizza.getQuantity();
        String type = pizza.getType();
        List<String> toppings = pizza.getToppings();

        System.out.println("What size pizza do you want?");
        System.out.println("[S, M, L, Keep]");
        System.out.println("Current: " + size);
        userInput = scanner.nextLine().trim();
        if (validSizes.contains(userInput) && !userInput.equals("Keep")) {
            size = userInput.charAt(0);
        }

        System.out.println("How many pizzas do you want? Enter a number > 0 or 'Keep'");
        System.out.println("Current: " + quantity);
        userInput = scanner.nextLine().trim();
        if (isPositiveInteger(userInput)) {
            quantity = Integer.parseInt(userInput);
        }


        System.out.println("What type of pizza do you want?");
        System.out.println("[Pepperoni, Margherita, Vegetarian, Neapolitan, Custom, Keep]");
        System.out.println("Current: " + type);
        userInput = scanner.nextLine().trim();
        if (validTypes.contains(userInput)) {
            type = userInput;
        }

        String next_topping;
        while (type.equals("Custom")) {
            System.out.println("Pick a topping! [Olives, Tomatoes, Mushrooms, Jalapenos, Chicken, Beef, Pepperoni, Undo, Done, Clear]");
            System.out.println("Current: " + toppings);
            next_topping = scanner.nextLine().trim();
            if (next_topping.equals("Done")) {
                break;
            } else if (next_topping.equals("Undo")) {
                if (toppings.size() > 0) {
                    toppings.remove(toppings.size() - 1);
                }
            } else if (next_topping.equals("Clear")) {
                toppings.clear();
            } else if (validToppings.contains(next_topping)) {
                toppings.add(next_topping);
            }
        }

        Pizza customerPizza = null;
        switch (type) {
            case "Pepperoni":
                customerPizza = PizzaFactory.makePepperoniPizza(size, quantity);
                break;
            case "Margherita":
                customerPizza = PizzaFactory.makeMargheritaPizza(size, quantity);
                break;
            case "Vegetarian":
                customerPizza = PizzaFactory.makeVegetarianPizza(size, quantity);
                break;
            case "Neapolitan":
                customerPizza = PizzaFactory.makeNeapolitanPizza(size, quantity);
                break;
            case "Custom":
                customerPizza = PizzaFactory.makeCustomPizza(size, quantity, toppings);
                break;
        }

        return customerPizza;
    }


    static List<Pizza> updatePizzas(List<Pizza> pizzas, Scanner scanner) {
        String userInput = "";
        while (!userInput.equals("4")) {
            System.out.println("Enter a number for the corresponding command:");
            System.out.println("[(1) Add Pizza, (2) Remove Pizza, (3) Change Pizza, (4) Done]");
            userInput = scanner.nextLine().trim();
            if (userInput.equals("1")) {
                Pizza pizza = getPizzasLoop(scanner);
                pizzas.add(pizza);
            } else if (userInput.equals("2")) {
                int pizzaNumber = getPizzaNumber(pizzas, scanner);
                if (pizzaNumber != -1) {
                    int pizzaIndex = getPizzaIndex(pizzas, pizzaNumber);
                    if (pizzaIndex != -1) {
                        pizzas.remove(pizzaIndex);
                    }
                }
            } else if (userInput.equals("3")) {
                int pizzaNumber = getPizzaNumber(pizzas, scanner);
                if (pizzaNumber != -1) {
                    int pizzaIndex = getPizzaIndex(pizzas, pizzaNumber);
                    if (pizzaIndex != -1) {
                        Pizza pizza = pizzas.get(pizzaIndex);
                        Pizza newPizza = changePizza(pizza, scanner);
                        pizzas.set(pizzaIndex, newPizza);
                    }
                }
            }
        }
        return pizzas;
    }

    // compressed Node 20
    static Order getUpdatedOrder(Order order, Scanner scanner) {

        // 1078
        List<Pizza> newPizzas = order.getPizzas();
        List<Drink> newDrinks = order.getDrinks();
        String newAddress = order.getAddress();
        String userInput = "";
        // -------

        while (!userInput.equals("4")) { // 1079

            // 1080
            System.out.println("Enter a number for the corresponding command:");
            System.out.println("[(1) Update Pizzas, (2) Update Drinks, (3) Update Address, (4) Done]");
            userInput = scanner.nextLine().trim();
            // -----

            switch (userInput) {
                case "1":
                    newPizzas = updatePizzas(newPizzas, scanner); // 1083
                    break;
                case "2":
                    newDrinks = updateDrinks(newDrinks, scanner); // 1084
                    break;
                case "3":
                    newAddress = getUserAddress(scanner); // 1085
                    break;
            }
        } // 1086

        // 1081
        order.setPizzas(newPizzas);
        order.setDrinks(newDrinks);
        order.setAddress(newAddress);
        // --------

        // 1082
        return order;
        // -------
    }


    // Node 2 compressed
    public static int runApp(String input) {// Node 4
        Menu.setMenu(); // Node 5
        
        // Node 6
        List<Order> orders = new ArrayList<>();
        Scanner orderScanner = new Scanner(input);
        System.out.println("Welcome to 301 Pizza!: ");
        String userInput;
        //--------------------------
        
        while (true) {
        	
        	// Node 7
            System.out.println("What would you like to do? Enter a number for the corresponding option:");
            System.out.println("[(1) Create an Order, (2) Update an Order, (3) Delete an Order, (4) Submit an Order, (5) View Menu, (6) Quit App]");
            userInput = orderScanner.nextLine().trim();
            // ------------------------------------------
            
            // Node 8
            if (userInput.equals("1")) { // Create an Order
                Order newOrder = createOrder(orderScanner); // Node 9
                if (newOrder != null) { // Node 10
                    orders.add(newOrder);// Node 11
                    String total = Menu.getTotal(newOrder);// Node 12
                    System.out.println(total);// Node 13
                }
            } else if (userInput.equals("2")) { // Update an Order // Node 14
                int orderToModify = getOrderNumber(orders, orderScanner); // Node 15
                if (orderToModify != -1) { // Node 16
                    int indexToModify = getOrderIndex(orders, orderToModify); // Node 17
                    if (indexToModify != -1) { // Node 18
                    	// Node 19
                        Order order = orders.get(indexToModify);
                        Scanner scanner = new Scanner(System.in);
                        // ----------------------
                        Order newOrder = getUpdatedOrder(order, scanner); // Node 20 
                        String total = Menu.getTotal(newOrder); // Node 12
                        System.out.println(total);// Node 21
                    }
                }
            } else if (userInput.equals("3")) { // Delete an Order // Node 22
                int orderToRemove = getOrderNumber(orders, orderScanner); // Node 15
                if (orderToRemove != -1) { // Node 23
                    int indexToRemove = getOrderIndex(orders, orderToRemove); // Node 24
                    if (indexToRemove != -1) { // Node 25
                        orders.remove(indexToRemove); // Node 26
                    }
                }
            } else if (userInput.equals("4")) { // Submit an Order // Node 27
                int orderToSubmit = getOrderNumber(orders, orderScanner); // Node 15
                if (orderToSubmit != -1) { //  Node 28
                    int indexToSubmit = getOrderIndex(orders, orderToSubmit); // Node 24
                    if (indexToSubmit != -1) { // Node 29
                    	// Node 30
                        Order order = orders.get(indexToSubmit);
                        String type = order.getType();
                        String result = "";
                        // ------------------------------------------
                        
                        // Node 31
                        switch (type) {
                            case "Pickup":
                                result = submitPickup(order); // Node 32
                                break;
                            case "Delivery":
                                result = submitDelivery(order); // Node 33
                                break;
                            case "Uber":
                                result = submitUber(order); // Node 34
                                break;
                            case "Foodora":
                                result = submitFoodora(order); // Node 35
                                break;
                        }
                        // Node 36
                        System.out.println(result);
                        orders.remove(indexToSubmit);
                        // ---------------------------------
                    }
                }
            } else if (userInput.equals("5")) { // View Menu // Node 37
                String menuCommand = ""; // Node 38
                while (!menuCommand.equals("Done")) { // Node 39
                    menuCommand = getMenuCommandFromUser(orderScanner); // Node 40
                    String menuInfo = getMenuInfo(menuCommand); // Node 41
                    System.out.println("RESULT BEGIN\n" + menuInfo + "RESULT END\n"); // Node 42
                }
            } else if (userInput.equals("6")) { // Quit App // Node 43
            	break; // Node 44
            } else { // Node 45
                System.out.println("Invalid Command, Try Again."); // Node 46
            }
//            System.out.println("Current Orders:");
//            System.out.println(orders);
        }
        // TODO return orders
        return 0;// Node 47
    }


    public static void main(String[] args) { // Node 1
        runApp("6\n"); // Node 2
    }// Node 3

}