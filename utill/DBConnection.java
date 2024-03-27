package utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static Connection conn;

    public static Connection getConnection() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/insuranceManagementSystem", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();          }

        return conn;
    }
}
