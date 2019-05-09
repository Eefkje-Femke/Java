

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {
	private Connection connection =  null;
	String url = "jdbc:mysql://localhost:3306/personen?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username = "root";
	String password = "";

	public ConnectDB() {
		System.out.println("Connecting database...");		
	}

	private void connect() {
		//making connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");

		} catch (SQLException | ClassNotFoundException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
	}

	public List<Persoon> getAllPersons() {
		//get all  names from the table
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
			writeResultSet(resultSet);//Show ResultSet in Console
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return personen;		
	}

	public void insertNewName(String FirstName, String LastName) {
		//insert new name to table
		connect();
		try {
			// create SQL Query
			String insertTableSQL = "INSERT INTO naam" + "(Naam) VALUES" + "(?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, FirstName + LastName);
			preparedStatement .executeUpdate();
			System.out.println("Name inserted into table");
			
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		//Show ResultSet in Console
		while (resultSet.next()) {
			String naam = resultSet.getString("Naam");
			System.out.println("Naam: " + naam);
		}
	}
}
