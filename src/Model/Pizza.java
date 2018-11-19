package Model;

public class Pizza {
    private int pizzaID = 0;
    private String name = "";
    private String ingredients = "";
    private int price = 0;

    public Pizza(int pizzaID, String name, String ingredients, int price) {
        this.pizzaID = pizzaID;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public int getPizzaID() {
        return pizzaID;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return String.format("%d. %s, %s, %d kr", pizzaID, name, ingredients, price);
    }

}
