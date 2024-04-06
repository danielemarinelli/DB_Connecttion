package tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import jdbc.DataBaseUtils;

public class regressions extends DataBaseUtils{
	
	@Test(priority=1)
	public void checkConnection() throws SQLException {
		getConnection();
		//System.out.println("connection ok");
	}
	
	
	@Test(priority=2)
	public void verifyData() throws SQLException {
		dataFromDB();
		//System.out.println("query executed...");
		//closeConnectionDB();
		getRowCount();
	}
	
	@Test(priority=3)
	public void closeDB() throws SQLException {
		closeConnectionDB();
	}
	
}
