package FIFA;
//STEP 1. Import required packages
import java.sql.*;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class FirstExample {
//	// JDBC driver name and database URL
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	static final String DB_URL = "inf008.ntb.ch";
//
//	// Database credentials
//	static final String USER = "username";
//	static final String PASS = "password";

	public static void main(String[] args){
		// Create datasource.
		 SQLServerDataSource ds = new SQLServerDataSource(); 
		 ds.setUser("Neuchatel"); 
		 ds.setPassword("DB19"); 
		 ds.setServerName("inf008.ntb.ch"); 
		 ds.setPortNumber(Integer.parseInt("1433"));
		ds.setDatabaseName("STARK");
		Connection conn = null;
		Statement stmt = null;

		try {
			// STEP 2: Register JDBC driver
			//Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
//			System.out.println("Connecting to database...");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn = ds.getConnection(); 

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT Name, Age, Player_ID, Club_ID, Nation_ID FROM Players";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String name = rs.getString("Name");
				int age = rs.getInt("Age");
				int player_ID = rs.getInt("Player_ID");
				int club_ID = rs.getInt("Club_ID");
				int nation_ID = rs.getInt("Nation_ID");
				

				// Display values
				System.out.print("Name: " + name);
				System.out.print(", Age: " + age);
				System.out.print(", ID: " + player_ID);
				System.out.print(", Club_ID: " + club_ID);
				System.out.println(", Nation_ID: " + nation_ID);
			}
			
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main
}// end FirstExample