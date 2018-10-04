package baseSetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

	private static Connection con;

	public static void createConnection(String dbUrl, String username, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, username, password);

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static Connection getConnection()
	{
		return con;
	}
	public static  void  insertData(String query)
	{
		Statement stmt = null;
	
		try {
			stmt = con.prepareStatement(query);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public static ResultSet sendQuery(String query) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}
	
	
	public static void closeConnection()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
