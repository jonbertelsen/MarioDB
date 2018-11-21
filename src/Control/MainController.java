package Control;

import Model.MenuCard;
import Model.Order;
import Model.OrderLine;
import View.MenuUI;
import View.PizzaUI;
import View.UITools;

import java.util.ArrayList;

public class MainController {

    public static void mainControlLoop() {

        MenuCard menuCard = new MenuCard();
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
                    // opret ordrer
                    Order order = new Order(0,2030,1);
                    order.insertOrderLine(new OrderLine(0,11,3,183));
                    order.insertOrderLine(new OrderLine(0,2,1,53));
                    orderList.add(order);
                    order = new Order(0,1930,2);
                    order.insertOrderLine(new OrderLine(0,1,2,114));
                    orderList.add(order);
                    System.out.println("Ordre indsat");
                    break;
                case 4:
                    // vis ordrer
                    for (Order o: orderList) {
                        System.out.println(o.toString());
                    }
                    break;
                default: choice = 9; break;
            }
        }
    }

}
