package Eretail.FrameworkEretail.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Eretail.FrameworkEretail.utils.DatabaseConnection;

public class TestDb {
	public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from userparams where ParamCode='uniqueslno'");

            while (rs.next()) {
                System.out.println("Order ID: " + rs.getString("key2"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 
//        finally {
//            DatabaseConnection.closeConnection();
//        }
    }

}
