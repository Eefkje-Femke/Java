

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Date;

public class ConnectDB {
	private Connection connection =  null;
	String url = "jdbc:mysql://localhost:3306/personen?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username = "root";
	String password = "";
	
	public ConnectDB() {
		System.out.println("Connecting database...");		
	}
	
	private void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");
			
		} catch (SQLException | ClassNotFoundException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public List<Persoon> getAllPersons() {
		ResultSet resultSet = null;
		connect();
		Statement statement;
		ArrayList<Persoon> personen = new ArrayList<Persoon>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM naam");
			
			while(resultSet.next()) {
				Persoon p = new Persoon();
				p.voorNaam = resultSet.getString("Naam");
				personen.add(p);
			}
//			writeResultSet(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		 
		
		return personen;		
	}
	
	private void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			String naam = resultSet.getString("Naam");
//			String website = resultSet.getString("webpage");
//			String summary = resultSet.getString("summary");
//			Date date = resultSet.getDate("datum");
//			String comment = resultSet.getString("comments");
			System.out.println("Naam: " + naam);
//			System.out.println("Website: " + website);
//			System.out.println("summary: " + summary);
//			System.out.println("Date: " + date);
//			System.out.println("Comment: " + comment);
		}
	}

}


//private Connection connect = null;
//private Statement statement = null;
//private PreparedStatement preparedStatement = null;
//private ResultSet resultSet = null;
//
//public void readDataBase() throws Exception {
//	try {
//		// This will load the MySQL driver, each DB has its own driver
//		Class.forName("com.mysql.jdbc.Driver");
//		// Setup the connection with the DB
//		connect = DriverManager
//				.getConnection("jdbc:mysql://localhost/feedback?"
//						+ "user=sqluser&password=sqluserpw");
//
//		// Statements allow to issue SQL queries to the database
//		statement = connect.createStatement();
//		// Result set get the result of the SQL query
//		resultSet = statement
//				.executeQuery("select * from feedback.comments");
//		writeResultSet(resultSet);
//
//		// PreparedStatements can use variables and are more efficient
//		preparedStatement = connect
//				.prepareStatement("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)");
//		// "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
//		// Parameters start with 1
//		preparedStatement.setString(1, "Test");
//		preparedStatement.setString(2, "TestEmail");
//		preparedStatement.setString(3, "TestWebpage");
//		preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
//		preparedStatement.setString(5, "TestSummary");
//		preparedStatement.setString(6, "TestComment");
//		preparedStatement.executeUpdate();
//
//		preparedStatement = connect
//				.prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from feedback.comments");
//		resultSet = preparedStatement.executeQuery();
//		writeResultSet(resultSet);
//
//		// Remove again the insert comment
//		preparedStatement = connect
//				.prepareStatement("delete from feedback.comments where myuser= ? ; ");
//		preparedStatement.setString(1, "Test");
//		preparedStatement.executeUpdate();
//
//		resultSet = statement
//				.executeQuery("select * from feedback.comments");
//		writeMetaData(resultSet);
//
//	} catch (Exception e) {
//		throw e;
//	} finally {
//		close();
//	}
//
//}
//
//private void writeMetaData(ResultSet resultSet) throws SQLException {
//	//  Now get some metadata from the database
//	// Result set get the result of the SQL query
//
//	System.out.println("The columns in the table are: ");
//
//	System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
//	for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
//		System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
//	}
//}
//
//private void writeResultSet(ResultSet resultSet) throws SQLException {
//	// ResultSet is initially before the first data set
//	while (resultSet.next()) {
//		// It is possible to get the columns via name
//		// also possible to get the columns via the column number
//		// which starts at 1
//		// e.g. resultSet.getSTring(2);
//		String user = resultSet.getString("myuser");
//		String website = resultSet.getString("webpage");
//		String summary = resultSet.getString("summary");
//		Date date = resultSet.getDate("datum");
//		String comment = resultSet.getString("comments");
//		System.out.println("User: " + user);
//		System.out.println("Website: " + website);
//		System.out.println("summary: " + summary);
//		System.out.println("Date: " + date);
//		System.out.println("Comment: " + comment);
//	}
//}
//
//// You need to close the resultSet
//private void close() {
//	try {
//		if (resultSet != null) {
//			resultSet.close();
//		}
//
//		if (statement != null) {
//			statement.close();
//		}
//
//		if (connect != null) {
//			connect.close();
//		}
//	} catch (Exception e) {
//
//	}
//}