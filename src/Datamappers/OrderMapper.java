package Datamappers;

import Model.Order;
import Model.OrderLine;
import Util.ConnectionConfiguration;

import java.sql.*;

public class OrderMapper implements IOrderMapper {


    @Override
    public void createOrder(Order order) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlQuery = "";

        try {
            connection = ConnectionConfiguration.getConnection();
            sqlQuery = "INSERT INTO mario.order (customer_id, order_time) VALUES (?,?)";
            ps = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getCustomerID());
            ps.setInt(2, order.getOrderTime());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            int orderID = rs.getInt(1);
            order.setOrderID(orderID);

            sqlQuery = "INSERT INTO mario.order_line (order_id, pizza_id, amount, price) VALUES (?,?,?,?)";
            
            for (OrderLine ol: order.getOrderLines()){
                ps = connection.prepareStatement(sqlQuery);
                ps.setInt(1,orderID);
                ps.setInt(2,ol.getPizzaID());
                ps.setInt(3,ol.getAmount());
                ps.setInt(4,ol.getTotalPrice());
                ps.executeUpdate();
                ol.setOrderID(orderID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
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
}
