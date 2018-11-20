package Datamappers;

import Model.Pizza;
import Util.ConnectionConfiguration;

import java.sql.*;
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

        } catch (Exception e) {
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

        Connection connection = null;
        Pizza pizza = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * FROM pizza where pizza_id = ?";

        try {
            connection = ConnectionConfiguration.getConnection();
            ps = connection.prepareStatement(sqlQuery);
            ps.setInt(1, pizzaID);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                pizzaID = resultSet.getInt("pizza_id");
                String pizzaName = resultSet.getString("name");
                String ingredients = resultSet.getString("ingredients");
                int price = resultSet.getInt("price");
                pizza = new Pizza(pizzaID, pizzaName, ingredients, price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
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
        return pizza;
    }
}
