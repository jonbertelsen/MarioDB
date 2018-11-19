package Control;

import Model.Menu;
import View.MainMenu;
import View.PizzaUI;
import View.UITools;

public class MainController {

    public static void mainControlLoop() {
        Menu menuCard = new Menu();
        MainMenu mainMenu = new MainMenu();


        // ***** Menu ******* //
        int choice = 0;
        int pizzaID;

        while (choice != 9) {
            mainMenu.showMainMenu();
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
