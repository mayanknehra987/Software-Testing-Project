package Eretail.FrameworkEretail.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection connection;

	static {
		try {
			// ✅ Load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://dev-vinaswsdevnew.cmnvnb81ejie.ap-south-1.rds.amazonaws.com:53306/bluedart?characterEncoding=UTF-8";
			// Establish Connection
			connection = DriverManager.getConnection(url, "eretailsupport", "Vin@#1234");
			System.out.println("✅ Database Connected Successfully!");

		} catch (ClassNotFoundException e) {
			System.out.println("❌ JDBC Driver not found: " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to connect to Database");
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
