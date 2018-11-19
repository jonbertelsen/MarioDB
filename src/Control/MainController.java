package Control;

import Model.MenuCard;
import View.MenuUI;
import View.PizzaUI;
import View.UITools;

public class MainController {

    public static void mainControlLoop() {
        MenuCard menuCard = new MenuCard();

        // ***** MenuCard ******* //
        int choice = 0;
        int pizzaID;

        while (choice != 9) {
            MenuUI.showMainMenu();
            choice = UITools.getInputNumber("Indtast valg: ");
            switch (choice){
                case 1:
                    PizzaUI.viewMenuCard(menuCard);
                    break;
                case 2:
                    pizzaID = UITools.getInputNumber("Indtast pizza nummer: ");
                    PizzaUI.viewPizza(menuCard.getMenuItemById(pizzaID)); break;
                default: choice = 9; break;
            }
        }
    }

}
