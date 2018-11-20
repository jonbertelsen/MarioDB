package View;

import Model.MenuCard;
import Model.Pizza;

public class PizzaUI {

    public static void viewMenuCard(MenuCard menuCardObject) {
        for (Pizza menuItem: menuCardObject.getMenuCard()) {
            System.out.println(menuItem.getPizzaID() + ": " +
                    menuItem.getName() + ", " +
                    menuItem.getIngredients() + ", " +
                    menuItem.getPrice());
        }
    }

    public static void viewPizza(Pizza pizzaObject) {
        if (pizzaObject != null) {
            System.out.println(pizzaObject.toString());
        } else
        {
            System.out.println("Der findes ikke en pizza med det nummer din tosse!");
        }
    }
}
