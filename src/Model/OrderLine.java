package Model;

public class OrderLine {

    private int orderID;
    private int pizzaID;
    private int amount;
    private int totalPrice;

    public int getOrderID() {
        return orderID;
    }

    public int getPizzaID() {
        return pizzaID;
    }

    public int getAmount() {
        return amount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public OrderLine(int orderID, int pizzaID, int amount, int totalPrice) {
        this.orderID = orderID;
        this.pizzaID = pizzaID;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "orderID=" + orderID +
                ", pizzaID=" + pizzaID +
                ", amount=" + amount +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
