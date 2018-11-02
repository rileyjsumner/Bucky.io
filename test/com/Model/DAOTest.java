package com.Model;

import org.junit.Assert;
import org.junit.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DAOTest {

  // INSERT INTO table (col) VALUES (val);
  // UPDATE table SET col = val WHERE colcheck = valcheck;
  // DELETE col FROM table WHERE colcheck = valcheck;
  // SELECT col FROM tabERE colcheck = valcheck;

  private final String TABLE_NAME = "test";
  private DAO testDAO = new DAO(TABLE_NAME);

  @Test
  public void testDeleteInvalidColumnFromTable() {
     String whereCol = "failTest";
     String whereVal = "updateString";
     Assert.assertEquals(false, testDAO.delete(whereCol, whereVal));
  }

  @Test
  public void testDeleteValidColumnFromTable() {
    String whereCol = "integerTest";
    String whereVal = "7";
    Assert.assertEquals(true, testDAO.delete(whereCol, whereVal));
  }

  @Test
  public void testDeleteAllFromTable() {
    String whereCol = "";
    String whereVal = "1";
    Assert.assertEquals(true, testDAO.delete(whereCol, whereVal));
  }

  @Test
  public void testClearTable() {
    Assert.assertEquals(true, testDAO.clearTable());
  }
  /**
   *
   */
  @Test
  public void testInsertStrWithColumnNotExisting() {
    HashMap<String, String> insertTest = new HashMap<>();
    insertTest.put("failStr", "fail");
    Assert.assertEquals(false, testDAO.insertStr(insertTest));
  }

  /**
   * 
   */
  @Test
  public void testInsertStrWithValidString() {
    HashMap<String, String> insertTest = new HashMap<>();
    insertTest.put("stringTest", "valid");
    Assert.assertEquals(true, testDAO.insertStr(insertTest));
  }

  @Test
  public void testInsertIntWithColumnNotExisting() {
    HashMap<String, Integer> insertTest = new HashMap<>();
    insertTest.put("failInt", 12);
    Assert.assertEquals(false, testDAO.insertInt(insertTest));
  }

  @Test
  public void testInsertIntWithValidInteger(){
    HashMap<String, Integer> insertTest = new HashMap<>();
    insertTest.put("integerTest", 7);
    Assert.assertEquals(true, testDAO.insertInt(insertTest));
  }

  @Test
  public void testInsertDoubleWithColumnNotExisting(){
    HashMap<String, Double> insertTest = new HashMap<>();
    insertTest.put("failDouble", 0.9);
    Assert.assertEquals(false, testDAO.insertDouble(insertTest));
  }

  @Test
  public void testInsertDoubleWithValidDouble(){
    HashMap<String, Double> insertTest = new HashMap<>();
    insertTest.put("doubleTest", 0.5);
    Assert.assertEquals(true, testDAO.insertDouble(insertTest));
  }

  @Test
  public void testUpdateStrWithUpdateColumnNotExist() {
    HashMap<String, String> updateTest = new HashMap<>();
    updateTest.put("failStr", "updateString");
    String colCheck = "integerTest";
    String valCheck = "7";
    Assert.assertEquals(false, testDAO.updateStr(updateTest, colCheck, valCheck));
  }

  @Test
  public void testUpdateStrWithCheckColumnNotExist() {
    HashMap<String, String> updateTest = new HashMap<>();
    updateTest.put("stringTest", "updateString");
    String colCheck = "failInt";
    String valCheck = "7";
    Assert.assertEquals(false, testDAO.updateStr(updateTest, colCheck, valCheck));
  }

  @Test
  public void testUpdateStrWithValidString() {
    HashMap<String, String> updateTest = new HashMap<>();
    updateTest.put("stringTest", "updateString");
    String colCheck = "integerTest";
    String valCheck = "7";
    Assert.assertEquals(true, testDAO.updateStr(updateTest, colCheck, valCheck));
  }

  @Test
  public void testUpdateIntWithCheckColumnNotExist() {
    HashMap<String, Integer> updateTest = new HashMap<>();
    updateTest.put("integerTest", 14);
    String colCheck = "failInt";
    String valCheck = "7";
    Assert.assertEquals(false, testDAO.updateInt(updateTest, colCheck, valCheck));
  }

  @Test
  public void testUpdateIntWithValidInt() {
    HashMap<String, Integer> updateTest = new HashMap<>();
    updateTest.put("integerTest", 17);
    String colCheck = "stringTest";
    String valCheck = "updateString";
    Assert.assertEquals(true, testDAO.updateInt(updateTest, colCheck, valCheck));
  }

  @Test
  public void testUpdateDoubleWithCheckColumnNotExist() {
    HashMap<String, Double> updateTest = new HashMap<>();
    updateTest.put("doubleTest", 4.02);
    String colCheck = "failDouble";
    String valCheck = "3.12";
    Assert.assertEquals(false, testDAO.updateDouble(updateTest, colCheck, valCheck));
  }

  @Test
  public void testUpdateDoubleWithValidDouble() {
    HashMap<String, Double> updateTest = new HashMap<>();
    updateTest.put("doubleTest", 3.14);
    String colCheck = "integerTest";
    String valCheck = "17";
    Assert.assertEquals(true, testDAO.updateDouble(updateTest, colCheck, valCheck));
  }

  @Test
  public void testSelectWithValidData() {
    ArrayList<String> colSelect = new ArrayList<>();
    colSelect.add("stringTest");
    String whereCol = "integerTest";
    String whereVal = "17";
    ResultSet testResult = testDAO.select(colSelect, whereCol, whereVal);
    String selectVal;
    try {
      if(testResult.first()) {
        selectVal = testResult.getString("stringTest");
      } else {
        selectVal = null;
      }
    } catch (SQLException e) {
      selectVal = null;
    }
    Assert.assertEquals("updateString", selectVal);
  }
}
