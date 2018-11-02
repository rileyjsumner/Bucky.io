package com.Model;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
/**
 *
 * Will be used to manipulate and get information from the DB
 */
public class DAO {
  public static Connection connection;
  private String table_name;

  /**
   * Accesses information from db.properties to instantiate a database connection.
   * When a DAO object is created, creates a public instance of the db.
   * For custom commands, {@code this.connection} can be used to write SQL
   */
  public DAO(String table_name) {
      this.table_name = table_name;
      try {
        Properties prop = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("db.properties");
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

  }

  /**
   * Create new entry in the database, inserts String text
   * @param insertVals Map where first index is the column, second index is the value
   */
  public boolean insertStr(Map<String, String> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, String> entry : insertVals.entrySet()) {
      columnList = columnList.concat(entry.getKey()+",");
      valueList  = valueList.concat("?,");
    }
    columnList = columnList.substring(0,columnList.length()-1);
    valueList  = valueList.substring(0,valueList.length()-1);

    try {
      // INSERT into table_name (col1, 11111111111123123123123123123123123123123121col2) VALUES (?, ?);
      preparedStatement = connection.prepareStatement("INSERT INTO " + table_name + " (" + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, String> entry : insertVals.entrySet()) {
        preparedStatement.setString(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      return true;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Creates a new entry in the database of type Int
   * @param insertVals Map of <String,Integer> where the String is the column name,
   * Integers are the values to be inserted
   */
  public boolean insertInt(Map<String, Integer> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Integer> entry : insertVals.entrySet()) {
      columnList = columnList.concat(entry.getKey()+",");
      valueList  = valueList.concat("?,");
    }
    columnList = columnList.substring(0,columnList.length()-1);
    valueList  = valueList.substring(0,valueList.length()-1);

    try {
      // INSERT into table_name (col1, col2) VALUES (?, ?);
      preparedStatement = connection.prepareStatement("INSERT INTO " + table_name + " (" + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, Integer> entry : insertVals.entrySet()) {
        preparedStatement.setInt(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      return true;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Creates a decimal entry in the database
   * @param insertVals values to insert into the database
   */
  public boolean insertDouble(Map<String, Double> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Double> entry : insertVals.entrySet()) {
      columnList = columnList.concat(entry.getKey()+",");
      valueList  = valueList.concat("?,");
    }
    columnList = columnList.substring(0,columnList.length()-1);
    valueList  = valueList.substring(0,valueList.length()-1);

    try {
      // INSERT into table_name (col1, col2) VALUES (?, ?);
      preparedStatement = connection.prepareStatement("INSERT INTO " + table_name + " (" + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, Double> entry : insertVals.entrySet()) {
        preparedStatement.setDouble(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      return true;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean insertLong(Map<String, Long> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Long> entry : insertVals.entrySet()) {
      columnList = columnList.concat(entry.getKey()+",");
      valueList = valueList.concat("?,");
    }
    columnList = columnList.substring(0, columnList.length()-1);
    valueList = valueList.substring(0, valueList.length()-1);

    try {
      preparedStatement  = connection.prepareStatement("INSERT INTO " + table_name + " ( " + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, Long> entry : insertVals.entrySet()) {
        preparedStatement.setLong(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      return true;

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean insertBoolean(Map<String, Boolean> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Boolean> entry : insertVals.entrySet()) {
      columnList = columnList.concat(entry.getKey()+",");
      valueList = valueList.concat("?,");
    }
    columnList = columnList.substring(0, columnList.length()-1);
    valueList = valueList.substring(0, valueList.length()-1);

    try {
      preparedStatement  = connection.prepareStatement("INSERT INTO " + table_name + " ( " + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, Boolean> entry : insertVals.entrySet()) {
        preparedStatement.setBoolean(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      return true;

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean insertFloat(Map<String, Float> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Float> entry : insertVals.entrySet()) {
      columnList = columnList.concat(entry.getKey()+",");
      valueList = valueList.concat("?,");
    }
    columnList = columnList.substring(0, columnList.length()-1);
    valueList = valueList.substring(0, valueList.length()-1);

    try {
      preparedStatement  = connection.prepareStatement("INSERT INTO " + table_name + " ( " + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, Float> entry : insertVals.entrySet()) {
        preparedStatement.setFloat(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      return true;

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean insertShort(Map<String, Short> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Short> entry : insertVals.entrySet()) {
      columnList = columnList.concat(entry.getKey()+",");
      valueList = valueList.concat("?,");
    }
    columnList = columnList.substring(0, columnList.length()-1);
    valueList = valueList.substring(0, valueList.length()-1);

    try {
      preparedStatement  = connection.prepareStatement("INSERT INTO " + table_name + " ( " + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, Short> entry : insertVals.entrySet()) {
        preparedStatement.setShort(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      return true;

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean insertObject(Map<String, Object> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Object> entry : insertVals.entrySet()) {
      columnList = columnList.concat(entry.getKey()+",");
      valueList = valueList.concat("?,");
    }
    columnList = columnList.substring(0, columnList.length()-1);
    valueList = valueList.substring(0, valueList.length()-1);

    try {
      preparedStatement  = connection.prepareStatement("INSERT INTO " + table_name + " ( " + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, Object> entry : insertVals.entrySet()) {
        preparedStatement.setObject(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      return true;

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean insertByte(Map<String, Byte> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Byte> entry : insertVals.entrySet()) {
      columnList = columnList.concat(entry.getKey()+",");
      valueList = valueList.concat("?,");
    }
    columnList = columnList.substring(0, columnList.length()-1);
    valueList = valueList.substring(0, valueList.length()-1);

    try {
      preparedStatement  = connection.prepareStatement("INSERT INTO " + table_name + " ( " + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, Byte> entry : insertVals.entrySet()) {
        preparedStatement.setByte(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      return true;

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean insertBigDecimal(Map<String, BigDecimal> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, BigDecimal> entry : insertVals.entrySet()) {
      columnList = columnList.concat(entry.getKey()+",");
      valueList = valueList.concat("?,");
    }
    columnList = columnList.substring(0, columnList.length()-1);
    valueList = valueList.substring(0, valueList.length()-1);

    try {
      preparedStatement  = connection.prepareStatement("INSERT INTO " + table_name + " ( " + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, BigDecimal> entry : insertVals.entrySet()) {
        preparedStatement.setBigDecimal(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      return true;

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean insertDate(Map<String, Date> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Date> entry : insertVals.entrySet()) {
      columnList = columnList.concat(entry.getKey()+",");
      valueList = valueList.concat("?,");
    }
    columnList = columnList.substring(0, columnList.length()-1);
    valueList = valueList.substring(0, valueList.length()-1);

    try {
      preparedStatement  = connection.prepareStatement("INSERT INTO " + table_name + " ( " + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, Date> entry : insertVals.entrySet()) {
        preparedStatement.setDate(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      return true;

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean insertTime(Map<String, Time> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Time> entry : insertVals.entrySet()) {
      columnList = columnList.concat(entry.getKey()+",");
      valueList = valueList.concat("?,");
    }
    columnList = columnList.substring(0, columnList.length()-1);
    valueList = valueList.substring(0, valueList.length()-1);

    try {
      preparedStatement  = connection.prepareStatement("INSERT INTO " + table_name + " ( " + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, Time> entry : insertVals.entrySet()) {
        preparedStatement.setTime(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      return true;

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean insertTimeStamp(Map<String, Timestamp> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Timestamp> entry : insertVals.entrySet()) {
      columnList = columnList.concat(entry.getKey()+",");
      valueList = valueList.concat("?,");
    }
    columnList = columnList.substring(0, columnList.length()-1);
    valueList = valueList.substring(0, valueList.length()-1);

    try {
      preparedStatement  = connection.prepareStatement("INSERT INTO " + table_name + " ( " + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, Timestamp> entry : insertVals.entrySet()) {
        preparedStatement.setTimestamp(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      return true;

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Update method for the database
   * @param updateVals values to be updated in the database
   * @param colCheck WHERE clause of SQL, column to compare equality
   * @param valCheck WHERE clause of SQL, value which colCheck should equal
   * @return boolean if statement was executed
   */
  public boolean updateStr(Map<String, String> updateVals, String colCheck, String valCheck) {
    String updateList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, String> entry : updateVals.entrySet()){
      updateList = updateList.concat(entry.getKey()+" = ?,");
    }
    updateList = updateList.substring(0,updateList.length()-1);
    try {
      // UPDATE table_name SET col1 = ?, col2 = ? WHERE col3 = ?
      preparedStatement = connection.prepareStatement("UPDATE " + table_name + " SET " + updateList + " WHERE " + colCheck +" = ?;");
      int i = 1;
      for(Map.Entry<String, String> entry : updateVals.entrySet()){
        preparedStatement.setString(i, entry.getValue());
        i++;
      }
      preparedStatement.setString(i, valCheck);
      preparedStatement.execute();
      return true;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Update method for integers to update in the database
   * @param updateVals Map of columns and values which should be updated
   * @param colCheck WHERE clause of SQL, column to check equality
   * @param valCheck WHERE clause of SQL, where value is equal to colCheck
   * @return boolean if SQL was successfully executed
   */
  public boolean updateInt(Map<String, Integer> updateVals, String colCheck, String valCheck) {
    String updateList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Integer> entry : updateVals.entrySet()){
      updateList = updateList.concat(entry.getKey()+" = ?,");
    }
    updateList = updateList.substring(0,updateList.length()-1);

    try {
      // UPDATE table_name SET col1 = ?, col2 = ? WHERE col3 = ?
      preparedStatement = connection.prepareStatement("UPDATE " + table_name + " SET " + updateList + " WHERE " + colCheck +" = ?;");
      int i = 1;
      for(Map.Entry<String, Integer> entry : updateVals.entrySet()){
        preparedStatement.setInt(i, entry.getValue());
        i++;
      }
      preparedStatement.setString(i, valCheck);
      preparedStatement.execute();
      return true;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Update method for doubles to be updated in the database
   * @param updateVals column, values Hashmap to update
   * @param colCheck column to check condition
   * @param valCheck value to check condition
   * @return boolean if update was successful
   */
  public boolean updateDouble(Map<String, Double> updateVals, String colCheck, String valCheck) {
    String updateList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Double> entry : updateVals.entrySet()){
      updateList = updateList.concat(entry.getKey()+" = ?,");
    }
    updateList = updateList.substring(0,updateList.length()-1);
    try {
      // UPDATE table_name SET col1 = ?, col2 = ? WHERE col3 = ?
      preparedStatement = connection.prepareStatement("UPDATE " + table_name + " SET " + updateList + " WHERE " + colCheck +" = ?;");
      int i = 1;
      for(Map.Entry<String, Double> entry : updateVals.entrySet()){
        preparedStatement.setDouble(i, entry.getValue());
        i++;
      }
      preparedStatement.setString(i, valCheck);
      preparedStatement.execute();
      return true;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Get information from the database
   * @return collection of values retrieved from database
   */
  public ResultSet select(ArrayList<String> colSelect, String whereCol, String whereVal) {
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    String columnList = "";

    for(String col : colSelect) {
      columnList = columnList.concat(col + ",");
    }
    columnList = columnList.substring(0,columnList.length()-1);
    try {
      // SELECT col1, col2 FROM table_name WHERE col3 = val;
      preparedStatement = connection.prepareStatement("SELECT " + columnList + " FROM " + table_name + " WHERE " + whereCol + " = ?;");
      preparedStatement.setString(1, whereVal);
      resultSet = preparedStatement.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return resultSet;
  }
  public boolean delete(String whereCol, String whereVal) {
    PreparedStatement preparedStatement;

    try {
      // DELETE col1, col2 FROM table_name WHERE col3 = val;
      preparedStatement = connection.prepareStatement("DELETE FROM " + table_name + " WHERE " + ((whereCol.equals(""))?"":whereCol+" = ") + "?;");
      preparedStatement.setString(1, whereVal);
      preparedStatement.execute();
      return true;
    } catch(SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
  public boolean clearTable() {
    return this.delete("", "1");
  }
}
