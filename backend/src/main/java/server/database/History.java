package server;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class History {

  public static void connect() {
    try (Connection connection = DriverManager.getConnection("jdbc:sqlite:history.sqlite")) {
        
        System.out.println("Successfully connected to SQLite DB.");

        Statement statement = connection.createStatement();
        String createTable =
            "CREATE TABLE IF NOT EXISTS history (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "number INTEGER not null," +
            "factorial INTEGER not null)";
        statement.execute(createTable);

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
  }

}