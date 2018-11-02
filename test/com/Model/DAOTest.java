package com.Model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.*;
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
  public void testInsertLongWithColumnNotExisting() {
    HashMap<String, Long> insertTest = new HashMap<>();
    insertTest.put("failLong", 1L);
    Assert.assertEquals(false, testDAO.insertLong(insertTest));
  }

  @Test
  public void testInsertLongWithValidLong() {
    HashMap<String, Long> insertTest = new HashMap<>();
    insertTest.put("longTest", 2398423L);
    Assert.assertEquals(true, testDAO.insertLong(insertTest));
  }

  @Test
  public void testInsertBooleanWithColumnNotExisting() {
    HashMap<String, Boolean> insertTest = new HashMap<>();
    insertTest.put("failBoolean", true);
    Assert.assertEquals(false, testDAO.insertBoolean(insertTest));
  }

  @Test
  public void testInsertBooleanWithValidBoolean() {
    HashMap<String, Boolean> insertTest = new HashMap<>();
    insertTest.put("booleanTest", true);
    Assert.assertEquals(true, testDAO.insertBoolean(insertTest));
  }

  @Test
  public void testInsertFloatWithColumnNotExisting() {
    HashMap<String, Float> insertTest = new HashMap<>();
    insertTest.put("failFloat", 1.2F);
    Assert.assertEquals(false, testDAO.insertFloat(insertTest));
  }

  @Test
  public void testInsertFloatWithValidFloat() {
    HashMap<String, Float> insertTest = new HashMap<>();
    insertTest.put("floatTest", 2.4F);
    Assert.assertEquals(true, testDAO.insertFloat(insertTest));
  }

  @Test
  public void testInsertShortWithColumnNotExisting() {
    HashMap<String, Short> insertTest = new HashMap<>();
    insertTest.put("failShort", (short)10000);
    Assert.assertEquals(false, testDAO.insertShort(insertTest));
  }

  @Test
  public void testInsertShortWithValidShort() {
    HashMap<String, Short> insertTest = new HashMap<>();
    insertTest.put("shortTest", (short)3);
    Assert.assertEquals(true, testDAO.insertShort(insertTest));
  }

  @Test
  public void testInsertObjectWithColumnNotExisting() {
    HashMap<String, Object> insertTest = new HashMap<>();
    insertTest.put("failObject", new Object());
    Assert.assertEquals(false, testDAO.insertObject(insertTest));
  }

  @Test
  public void testInsertObjectWithValidObject() {
    HashMap<String, Double> insertTest = new HashMap<>();
    insertTest.put("doubleTest", 0.5);
    Assert.assertEquals(true, testDAO.insertDouble(insertTest));
  }

  @Test
  public void testInsertBigDecimalWithColumnNotExisting() {
    HashMap<String, BigDecimal> insertTest = new HashMap<>();
    insertTest.put("failBigDecimal", new BigDecimal(1.00002));
    Assert.assertEquals(false, testDAO.insertBigDecimal(insertTest));
  }

  @Test
  public void testInsertBigDecimalWithValidBigDecimal() {
    HashMap<String, BigDecimal> insertTest = new HashMap<>();
    insertTest.put("bigDecimalTest", new BigDecimal(30.523823));
    Assert.assertEquals(true, testDAO.insertBigDecimal(insertTest));
  }

  @Test
  public void testInsertDateWithColumnNotExisting() {
    HashMap<String, Date> insertTest = new HashMap<>();
    insertTest.put("failDate", new Date(1541193952L));
    Assert.assertEquals(false, testDAO.insertDate(insertTest));
  }

  @Test
  public void testInsertDateWithValidDate() {
    HashMap<String, Date> insertTest = new HashMap<>();
    insertTest.put("dateTest", new Date(2342323L));
    Assert.assertEquals(true, testDAO.insertDate(insertTest));
  }

  @Test
  public void testInsertTimeWithColumnNotExisting() {
    HashMap<String, Time> insertTest = new HashMap<>();
    insertTest.put("failTime", new Time(System.currentTimeMillis()));
    Assert.assertEquals(false, testDAO.insertTime(insertTest));
  }

  @Test
  public void testInsertTimeWithValidTime() {
    HashMap<String, Time> insertTest = new HashMap<>();
    insertTest.put("timeTest", new Time(System.currentTimeMillis()));
    Assert.assertEquals(true, testDAO.insertTime(insertTest));
  }

  @Test
  public void testInsertTimestampWithColumnNotExisting() {
    HashMap<String, Timestamp> insertTest = new HashMap<>();
    insertTest.put("failTimestamp", new Timestamp(1541193952L));
    Assert.assertEquals(false, testDAO.insertTimestamp(insertTest));
  }

  @Test
  public void testInsertTimestampWithValidTimestamp() {
    HashMap<String, Timestamp> insertTest = new HashMap<>();
    insertTest.put("timestampTest", new Timestamp(2981720720L));
    Assert.assertEquals(true, testDAO.insertTimestamp(insertTest));
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
