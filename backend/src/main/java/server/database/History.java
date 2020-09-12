package server;

import server.Factorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class History {

  private Connection connection;
	private Statement statement;

  public History() {
    this.connect();
  }

  private void connect() {
    try {
        this.connection = DriverManager.getConnection("jdbc:sqlite:history.sqlite");  
        System.out.println("Successfully connected to SQLite DB.");

        this.statement = connection.createStatement();
        String createTable =
            "CREATE TABLE IF NOT EXISTS history (" +
            "number INTEGER not null," +
            "factorial INTEGER not null)";
        statement.execute(createTable);

    } catch (SQLException e) {
      System.out.println("Error connecting to SQLite DB.");
      e.printStackTrace();
    }
  }

  public void saveFactorial(Factorial fac) {
    try {
			this.statement.executeUpdate("INSERT INTO history VALUES ("
				+ fac.getNumber() + ","
				+ fac.getNumberFactorial() + ")");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
  }

  public ResultSet getLastNFactorials(int n) {
    String query = "SELECT * FROM history ORDER BY _ROWID_ DESC LIMIT " + n;
    try {
			return this.statement.executeQuery(query);
		}
		catch (SQLException e) {
      e.printStackTrace();
      return null;
		}
  }

}