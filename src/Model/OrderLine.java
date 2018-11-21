package Model;

public class OrderLine {
    private int orderID;
    private int pizzaID;
    private int price;
    private int amount;

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public OrderLine(int orderID, int pizzaID, int price, int amount) {
        this.orderID = orderID;
        this.pizzaID = pizzaID;
        this.price = price;
        this.amount = amount;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getPizzaID() {
        return pizzaID;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("Ordre nr. %d: %d stk. pizza nr. %d til kr. %d",orderID, amount, pizzaID, price);
    }
}
