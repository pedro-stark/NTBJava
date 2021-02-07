package FIFA;

import java.sql.*;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DataAccessLayer {
	SQLServerDataSource ds;
	Connection conn;
	Statement stmt;

	// TODO PreparedStatements
	String SQL_tableJoin;
	PreparedStatement tableJoin;

	public DataAccessLayer() {
		ds = new SQLServerDataSource();
		ds.setUser("Neuchatel");
		ds.setPassword("DB19");
		ds.setServerName("inf008.ntb.ch");
		ds.setPortNumber(Integer.parseInt("1433"));
		ds.setDatabaseName("STARK");
		conn = null;
		stmt = null;
	}
	
	// TODO public void updateClubByPlayerID(int playerID, int clubID)
	
	public DataAccessLayer(String user, String pwd, String server, String port, String dbName) {
		ds = new SQLServerDataSource();
		ds.setUser(user);
		ds.setPassword(pwd);
		ds.setServerName(server);
		ds.setPortNumber(Integer.parseInt(port));
		ds.setDatabaseName(dbName);     
		conn = null;
		stmt = null;
	}

	public String getClubnameByPlayerID(int ID) {
		String out = null;
		String sql = null;
		try {
			// Open a connection
			conn = ds.getConnection();

			// Execute a query
			stmt = conn.createStatement();
			sql = "SELECT Players.Name AS Name, Players.age,Clubs.Name AS ClubName, Nations.Name AS NationenName FROM Players inner join Clubs ON Players.Club_ID = Clubs.CLUB_ID inner join Nations ON Players.Nation_ID = Nations.NATION_ID WHERE Players.PLAYER_ID = " + ID;
			ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			rs.next();
			// Retrieve by column name
			out = rs.getString("ClubName");

			// Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
			return out;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
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
		}
		return null;
	}

	public String getPlayerNameByID(int ID) {
		String out = null;
		String sql = null;
		try {
			// Open a connection
			conn = ds.getConnection();

			// Execute a query
			stmt = conn.createStatement();
			sql = "SELECT Name, Age, Player_ID, Club_ID, Nation_ID FROM Players WHERE " + ID + "= Player_ID";
			ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				out = rs.getString("Name");
			}

			// Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
			return out;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
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
		}
		return null;
	}

	public static void main(String[] args) {
		DataAccessLayer DAL = new DataAccessLayer();
		System.out.println(DAL.getPlayerNameByID(201377));
		System.out.println(DAL.getClubnameByPlayerID(201377));
		
	}

}
