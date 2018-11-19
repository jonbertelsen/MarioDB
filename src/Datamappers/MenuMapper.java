package Datamappers;

import Model.Pizza;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MenuMapper implements IMenu {

    @Override
    public ArrayList<Pizza> getMenuItems() {

        Connection connection = null;
        ArrayList<Pizza> menuCard = new ArrayList<>();

        Statement statement = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * FROM pizza";

        try {
            connection = Util.ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int pizzaID = resultSet.getInt("pizza_id");
                String pizzaName = resultSet.getString("name");
                String ingredients = resultSet.getString("ingredients");
                int price = resultSet.getInt("price");
                Pizza pizza = new Pizza(pizzaID, pizzaName, ingredients, price);

                menuCard.add(pizza);
            }

            } catch (Exception e){
                e.printStackTrace();
            } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



        return menuCard;
    }

    @Override
    public Pizza getMenuItemById(int pizzaID) {

        // Skal kodes: hent pizza fra DB med pizza_id = pizzaID og returner et pizza-objekt med indholdet

        return new Pizza(42,"Magaritha", "Tomat, ost og oregano",51);
    }
}
