package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {
    public static Connection getConnection(){

        Connection connection = null;

        String url = "jdbc:mysql://localhost:3306/mario?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        String user = "mario_db_user";
        String kodeord = "1234";

        try {
            connection = DriverManager.getConnection(url,user,kodeord);
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
