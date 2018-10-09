package com.Model;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class DAOTest {
  @Test
  public void testInsertStr() {
    DAO testDao = new DAO();
    String TABLE_NAME = "test";
    HashMap<String, String> insertTest = new HashMap<>();
    insertTest.put("username", "user");
    insertTest.put("password", "password");
    Assert.assertEquals(true, testDao.insertStr(TABLE_NAME, insertTest));
  }
}
