package View;

import Model.MenuCard;
import Model.Order;
import Model.OrderLine;
import Model.Pizza;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class OrderUI {

    public static Order enterOrder(MenuCard menuCard) {
        Order order = null;
        String morePizzas = "ja";
        Pizza pizza = null;

        int customerID = UITools.getInputNumber("Indtast kundenr: ");
        LocalDateTime orderTime = UITools.getInputTime("Hvad tid vil du hente (hh.mm) ? ");
        order = new Order(customerID, orderTime);

        do {
            int pizzaID = UITools.getInputNumber("Indtast pizzanr: ");
            pizza = menuCard.getMenuItemById(pizzaID);
            int amount = UITools.getInputNumber("Hvor mange stk. skal du have (1-10)? ");
            order.insertOrderLine(pizzaID,amount,pizza.getPrice() * amount);
            morePizzas = UITools.getInputString("Flere pizzaer (ja/nej)? ");
        } while (morePizzas.equals("ja"));

        return order;
    }

    public static void showOrderList(ArrayList<Order> orderList) {
        for (Order order: orderList) {
            System.out.println(order.toString());
            for (OrderLine orderline: order.getOrderLines()) {
                System.out.println(orderline.toString());
            }

        }
    }
}
