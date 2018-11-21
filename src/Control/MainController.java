package Control;

import Model.MenuCard;
import Model.Order;
import View.MenuUI;
import View.OrderUI;
import View.PizzaUI;
import View.UITools;
import Datamappers.OrderMapper;

import java.util.ArrayList;

public class MainController {

    public static void mainControlLoop() {

        MenuCard menuCard = new MenuCard();
        OrderMapper ordermapper = new OrderMapper();
        ArrayList<Order> orderList = new ArrayList<>();

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
                case 3:
                    Order newOrder = OrderUI.enterOrder(menuCard);
                    orderList.add(newOrder);
                    ordermapper.insertOrders(newOrder);
                    break;
                case 4:
                    OrderUI.showOrderList(orderList);
                default: choice = 9; break;
            }
        }
    }

}
