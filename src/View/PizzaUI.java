package View;

import Model.Menu;
import Model.Pizza;

public class PizzaUI {

    public static void viewMenuCard(Menu menuObject) {
        for (Pizza menuItem: menuObject.getMenuCard()) {
            System.out.println(menuItem.getPizzaID() + ": " +
                    menuItem.getName() + ", " +
                    menuItem.getIngredients() + ", " +
                    menuItem.getPrice());
        }
    }

    public static void viewPizza(Pizza pizzaObject) {
        System.out.println(pizzaObject.toString());
    }
}
