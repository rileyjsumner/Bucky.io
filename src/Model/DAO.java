package Model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @class DAO
 *
 * Will be used to manipulate and get information from the DB
 */
public class DAO {
  private static Connection connection;

  /**
   *
   * @return the database connection
   */
  public static Connection getConnection() {
    if (connection != null)
      return connection;
    else {
      try {
        Properties prop = new Properties();
        InputStream inputStream = DAO.class.getClassLoader().getResourceAsStream("/db.properties");
        prop.load(inputStream);
        // Get the properties from db.properties file
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
      } catch (ClassNotFoundException | SQLException | IOException e) {
        e.printStackTrace();
      }
      return connection;
    }

  }

}
