package com.Model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * Will be used to manipulate and get information from the DB
 */
public class DAO {
  public static Connection connection;

  /**
   * Accesses information from db.properties to instantiate a database connection.
   * When a DAO object is created, creates a public instance of the db.
   * For custom commands, {@code this.connection} can be used to write SQL
   */
  public DAO() {
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
   * @param tablename is the name of table which data is inserting into
   * @param insertVals Map where first index is the column, second index is the value
   */
  public static void insertStr(String tablename, Map<String, String> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, String> entry : insertVals.entrySet()) {
      columnList += entry.getKey()+",";
      valueList  += "?,";
    }
    columnList = columnList.substring(0,columnList.length()-1);
    valueList = valueList.substring(0,valueList.length()-1);

    try {
      // INSERT into tablename (col1, col2) VALUES (?, ?);
      System.out.println("INSERT INTO " + tablename + " (" + columnList + ") VALUES (" + valueList + ");");
      preparedStatement = connection.prepareStatement("INSERT INTO " + tablename + " (" + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, String> entry : insertVals.entrySet()) {
        System.out.println(entry.getValue());
        preparedStatement.setString(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates a new entry in the database of type Int
   * @param tablename name of table to be manipulated
   * @param insertVals Map of <String,Integer> where the String is the column name,
   * Integers are the values to be inserted
   */
  public static void insertInt(String tablename, Map<String, Integer> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Integer> entry : insertVals.entrySet()) {
      columnList += entry.getKey()+", ";
      valueList  += "?,";
    }
    columnList = columnList.substring(0,columnList.length()-1);
    valueList = valueList.substring(0,valueList.length()-1);

    try {
      // INSERT into tablename (col1, col2) VALUES (?, ?);
      preparedStatement = connection.prepareStatement("INSERT INTO " + tablename + " (" + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, Integer> entry : insertVals.entrySet()) {
        preparedStatement.setInt(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates a decimal entry in the database
   * @param tablename name of the table to be manipulated
   * @param insertVals
   */
  public static void insertDouble(String tablename, Map<String, Double> insertVals) {
    String columnList = "";
    String valueList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Double> entry : insertVals.entrySet()) {
      columnList += entry.getKey()+", ";
      valueList  += "?,";
    }
    columnList = columnList.substring(0,columnList.length()-1);
    valueList = valueList.substring(0,valueList.length()-1);

    try {
      // INSERT into tablename (col1, col2) VALUES (?, ?);
      preparedStatement = connection.prepareStatement("INSERT INTO " + tablename + " (" + columnList + ") VALUES (" + valueList + ");");
      int i = 1;
      for(Map.Entry<String, Double> entry : insertVals.entrySet()) {
        preparedStatement.setDouble(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Update method for the database
   * @param tablename table to update
   * @param updateVals
   * @param colCheck
   * @param valCheck
   */
  public static void updateStr(String tablename, Map<String, String> updateVals, String colCheck, String valCheck) {
    String updateList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, String> entry : updateVals.entrySet()){
      updateList+=entry.getKey()+" = ?,";
    }
    updateList = updateList.substring(0,updateList.length()-1);
    try {
      // UPDATE tablename SET col1 = ?, col2 = ? WHERE col3 = ?
      preparedStatement = connection.prepareStatement("UPDATE " + tablename + " SET " + updateList + " WHERE " + colCheck +" = ?;");
      int i = 1;
      for(Map.Entry<String, String> entry : updateVals.entrySet()){
        preparedStatement.setString(i, entry.getValue());
        i++;
      }
      preparedStatement.execute();
      preparedStatement.setString(i, valCheck);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void updateInt(String tablename, Map<String, Integer> updateVals, String colCheck, String valCheck) {
    String updateList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Integer> entry : updateVals.entrySet()){
      updateList+=entry.getKey()+" = ?,";
    }
    updateList = updateList.substring(0,updateList.length()-1);

    try {
      // UPDATE tablename SET col1 = ?, col2 = ? WHERE col3 = ?
      preparedStatement = connection.prepareStatement("UPDATE " + tablename + " SET " + updateList + " WHERE " + colCheck +" = ?;");
      int i = 1;
      for(Map.Entry<String, Integer> entry : updateVals.entrySet()){
        preparedStatement.setInt(i, entry.getValue());
        i++;
      }
      preparedStatement.setString(i, valCheck);
      preparedStatement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void updateDouble(String tablename, Map<String, Double> updateVals, String colCheck, String valCheck) {
    String updateList = "";
    PreparedStatement preparedStatement;
    for(Map.Entry<String, Double> entry : updateVals.entrySet()){
      updateList+=entry.getKey()+" = ?,";
    }
    updateList = updateList.substring(0,updateList.length()-1);
    try {
      // UPDATE tablename SET col1 = ?, col2 = ? WHERE col3 = ?
      preparedStatement = connection.prepareStatement("UPDATE " + tablename + " SET " + updateList + " WHERE " + colCheck +" = ?;");
      int i = 1;
      for(Map.Entry<String, Double> entry : updateVals.entrySet()){
        preparedStatement.setDouble(i, entry.getValue());
        i++;
      }
      preparedStatement.setString(i, valCheck);
      preparedStatement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Get information from the database
   */
  public static ArrayList<String> selectStr(String tablename, ArrayList<String> colSelect, String whereCol, String whereVal) {
    ArrayList<String> collection = new ArrayList<>();
    PreparedStatement preparedStatement;
    String columnList = "";

    for(String col : colSelect) {
      columnList+=col.toString() + ",";
    }
    columnList = columnList.substring(0,columnList.length()-1);
    try {
      // SELECT col1, col2 FROM tablename WHERE col3 = val;
      preparedStatement = connection.prepareStatement("SELECT " + columnList + " FROM " + tablename + " WHERE " + whereCol + " = ?;");
      preparedStatement.setString(1, whereVal);
      ResultSet resultSet = preparedStatement.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return collection;
  }

  public static ArrayList<Integer> selectInt(String tablename, ArrayList<Integer> colSelect, String whereCol, String whereVal) {
    ArrayList<Integer> collection = new ArrayList<>();
    PreparedStatement preparedStatement;
    String columnList = "";

    for(int col : colSelect) {
      columnList+=col +",";
    }
    columnList = columnList.substring(0,columnList.length()-1);
    try {
      // SELECT col1, col2 FROM tablename WHERE col3 = val;
      preparedStatement = connection.prepareStatement("SELECT " + columnList + " FROM " + tablename + " WHERE " + whereCol + " = ?;");
      preparedStatement.setString(1, whereVal);
      ResultSet resultSet = preparedStatement.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return collection;
  }
  public static ArrayList<String> selectDouble(String tablename, ArrayList<Double> colSelect, String whereCol, String whereVal) {
    ArrayList<String> collection = new ArrayList<>();
    PreparedStatement preparedStatement;
    String columnList = "";

    for(Double col : colSelect) {
      columnList+=col.toString() + ",";
    }
    columnList = columnList.substring(0,columnList.length()-1);
    try {
      // SELECT col1, col2 FROM tablename WHERE col3 = val;
      preparedStatement = connection.prepareStatement("SELECT " + columnList + " FROM " + tablename + " WHERE " + whereCol + " = ?;");
      preparedStatement.setString(1, whereVal);
      ResultSet resultSet = preparedStatement.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return collection;
  }
}
