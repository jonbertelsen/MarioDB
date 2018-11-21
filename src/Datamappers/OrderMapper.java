package Datamappers;

import Model.Order;
import Model.OrderLine;
import Model.Pizza;
import Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;

public class OrderMapper implements IOrder {

    @Override
    public void insertOrders(Order order) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlQuery = "INSERT INTO mario.order (customer_id, order_time) VALUES (?,?)";

        try {
            connection = ConnectionConfiguration.getConnection();
            ps = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getCustomerID());
            ps.setString(2, order.getOrderTime().toString());
            int result = ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int orderID = ids.getInt(1);
            order.setOrderID(orderID);

            sqlQuery = "INSERT INTO mario.order_line (order_id, pizza_id, amount, price) VALUES (?, ?, ?, ?)";

            for (OrderLine ol : order.getOrderLines()) {
                ps = connection.prepareStatement(sqlQuery);
                ps.setInt(1, orderID);
                ps.setInt(2, ol.getPizzaID());
                ps.setInt(3, ol.getAmount());
                ps.setInt(4, ol.getPrice());
                result = ps.executeUpdate();
                ol.setOrderID(orderID);
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
    }

    @Override
    public ArrayList<Order> loadOrders() {
        return null;
    }
}
