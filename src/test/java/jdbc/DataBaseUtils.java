package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtils {
	
	//Step1:  DB info
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","root");
	}
	
	//Step2: Create Connection to DB
	public static ResultSet executeQuery(String sqlQuery) throws SQLException {
		Connection connection = getConnection();
		//Step3: Create Statement
		Statement statement = connection.createStatement();
		return statement.executeQuery(sqlQuery);
	}
	
	//Step4: Execute SQL Query
	public static void dataFromDB() throws SQLException {
		String query = "select * from customers where country='USA'";
		ResultSet rs = DataBaseUtils.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString("customerName"));
		}
	}
	
	
	public static void getRowCount() throws SQLException {
		String query = "select COUNT(*) from products";
		ResultSet rs = DataBaseUtils.executeQuery(query);
		while(rs.next()) {
			System.out.println("Rows in products: "+rs.getString("COUNT(*)"));
		}
	}
	
	//Step5: Close connection DB 
		public static void closeConnectionDB() throws SQLException {
			Connection connection = getConnection();
			connection.close();
		}

}
