package rough;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RoughDB {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
		String dbUrl = "jdbc:mysql://localhost:3306/testjavadb";
		String username = "root";
		String password = "root";
		
		
		String startDate="01-02-2013";
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = sdf1.parse(startDate);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		Calendar calendar = Calendar.getInstance();
		//java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

		String query = " insert into users (goalDate,goalDetail,goalStatus)"
				+ " values (?, ?, ?)";

		PreparedStatement preparedStmt = con.prepareStatement(query);

		preparedStmt.setDate(1, sqlStartDate);

		preparedStmt.setString(2, "Rubble21");
		preparedStmt.setBoolean(3, false);

		// execute the preparedstatement
		preparedStmt.execute();

		con.close();

	}
}
