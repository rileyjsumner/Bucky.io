package Model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/**
 * @class DAO
 *
 * Will be used to manipulate and get information from the DB
 */
public class DAO {
  private static Connection connection;

  /**
   * Accesses information from db.properties to instantiate a database connection
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

  /**
   * Create new entry in the database
   * @param tablename is the name of table which data is inserting into
   * @param insertVals Map where first index is the column, second index is the value
   */
  public static void insert(String tablename, Map<String, String> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, String> entry : insertVals.entrySet()) {
      columnList += entry.getKey()+", ";
      valueList  += "?,";
    }

    try {
      // INSERT into tablename (col1, col2) VALUES (?, ?);
      preparedStatement = connection.prepareStatement("INSERT INTO " + tablename + "(" + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, String> entry : insertVals.entrySet()) {
        preparedStatement.setString(i, entry.getValue());
        i++;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   *
   * @param tablename
   * @param updateVals
   * @param colCheck
   * @param valCheck
   */
  public static void update(String tablename, Map<String, String> updateVals, String colCheck, String valCheck) {
    String updateList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, String> entry : updateVals.entrySet()){
      updateList+=entry.getKey()+" = ?,";
    }
    try {
      // UPDATE tablename SET col1 = ?, col2 = ? WHERE col3 = ?
      preparedStatement = connection.prepareStatement("UPDATE " + tablename + " SET " + updateList + " WHERE " + colCheck +" = ?;");
      int i = 1;
      for(Map.Entry<String, String> entry : updateVals.entrySet()){
        preparedStatement.setString(i, entry.getValue());
        i++;
      }
      preparedStatement.setString(i, valCheck);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Get information from the database
   */
  public static ArrayList<String> select() {
    ArrayList<String> collection = new ArrayList<>();
    return collection;
  }


}
