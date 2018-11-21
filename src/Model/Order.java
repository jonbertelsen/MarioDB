package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private int orderID = 0;
    private int customerID;
    private LocalDateTime orderTime;
    private ArrayList<OrderLine> orderLines = null;

    public Order(int customerID, LocalDateTime orderTime) {
        this.customerID = customerID;
        this.orderTime = orderTime;
        this.orderLines = new ArrayList<>();
    }

    public void insertOrderLine(int pizza_id, int amount, int price){
        // Assume that orderID has been set
        orderLines.add(new OrderLine(this.orderID, pizza_id, price, amount));
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", orderTime=" + orderTime +
                '}';
    }
}
