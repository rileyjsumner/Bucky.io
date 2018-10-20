package com.Model;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class DAOTest {

  // INSERT INTO table (col) VALUES (val);
  // UPDATE table SET col = val WHERE colcheck = valcheck;
  // DELETE col FROM table WHERE colcheck = valcheck;
  // SELECT col FROM table WHERE colcheck = valcheck;

  private final String TABLE_NAME = "test";
  /**
   *
   */
  @Test
  public void testInsertStrWithColumnNotExisting() {
    DAO testDao = new DAO();
    HashMap<String, String> insertTest = new HashMap<>();
    insertTest.put("failStr", "fail");
    Assert.assertEquals(false, testDao.insertStr(TABLE_NAME, insertTest));
  }

  /**
   * 
   */
  @Test
  public void testInsertStrWithValidString() {
    DAO testDao = new DAO();
    HashMap<String, String> insertTest = new HashMap<>();
    insertTest.put("stringTest", "valid");
    Assert.assertEquals(true, testDao.insertStr(TABLE_NAME, insertTest));
  }

  @Test
  public void testInsertIntWithColumnNotExisting() {
    DAO testDAO = new DAO();
    HashMap<String, Integer> insertTest = new HashMap<>();
    insertTest.put("failInt", 12);
    Assert.assertEquals(false, testDAO.insertInt(TABLE_NAME, insertTest));
  }

  @Test
  public void testInsertIntWithValidInteger(){
    DAO testDAO = new DAO();
    HashMap<String, Integer> insertTest = new HashMap<>();
    insertTest.put("integerTest", 7);
    Assert.assertEquals(true, testDAO.insertInt(TABLE_NAME, insertTest));
  }

  @Test
  public void testInsertDoubleWithColumnNotExisting(){
    DAO testDAO = new DAO();
    HashMap<String, Double> insertTest = new HashMap<>();
    insertTest.put("failDouble", 0.9);
    Assert.assertEquals(false, testDAO.insertDouble(TABLE_NAME, insertTest));
  }

  @Test
  public void testInsertDoubleWithValidDouble(){
    DAO testDAO = new DAO();
    HashMap<String, Double> insertTest = new HashMap<>();
    insertTest.put("doubleTest", 0.5);
    Assert.assertEquals(true, testDAO.insertDouble(TABLE_NAME, insertTest));
  }

  @Test
  public void testUpdateStrWithUpdateColumnNotExist() {
    DAO testDAO = new DAO();
    HashMap<String, String> insertTest = new HashMap<>();
    insertTest.put("failStr", "updateString");
    String colCheck = "integerTest";
    String valCheck = "7";
    Assert.assertEquals(false, testDAO.updateStr(TABLE_NAME, insertTest, colCheck, valCheck));
  }

  @Test
  public void testUpdateStrWithCheckColumnNotExist() {
    DAO testDAO = new DAO();
    HashMap<String, String> insertTest = new HashMap<>();
    insertTest.put("stringTest", "updateString");
    String colCheck = "failInt";
    String valCheck = "7";
    Assert.assertEquals(false, testDAO.updateStr(TABLE_NAME, insertTest, colCheck, valCheck));
  }

  @Test
  public void testUpdateStrWithValidString() {
    DAO testDAO = new DAO();
    HashMap<String, String> insertTest = new HashMap<>();
    insertTest.put("stringTest", "updateString");
    String colCheck = "integerTest";
    String valCheck = "7";
    Assert.assertEquals(true, testDAO.updateStr(TABLE_NAME, insertTest, colCheck, valCheck));
  }


}
