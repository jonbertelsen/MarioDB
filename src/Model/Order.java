package Model;

import java.util.ArrayList;

public class Order {

    private int orderID;
    private int orderTime;
    private int customerID;

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    private ArrayList<OrderLine> orderLines = null;

    public Order(int orderID, int orderTime, int customerID) {
        this.orderID = orderID;
        this.orderTime = orderTime;
        this.customerID = customerID;
        orderLines = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", orderTime=" + orderTime +
                ", customerID=" + customerID +
                ", orderLines=" + orderLines +
                '}';
    }

    public int getOrderID() {
        return orderID;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void insertOrderLine(OrderLine orderLine){
        orderLines.add(orderLine);
    }
}
