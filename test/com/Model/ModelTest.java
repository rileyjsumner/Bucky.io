package com.Model;

import java.util.HashMap;

public class ModelTest {
  public static void main(String args[]) {
    DAO db = new DAO();
    HashMap<String, String> insertVals = new HashMap<>();
    insertVals.put("username", "myuser");
    insertVals.put("password", "mypass");
    db.insertStr("test", insertVals);
  }
}
