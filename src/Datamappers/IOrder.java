package Datamappers;

import Model.Order;

import java.util.ArrayList;

public interface IOrder {

    void insertOrders(Order order);

    ArrayList<Order> loadOrders();
}
