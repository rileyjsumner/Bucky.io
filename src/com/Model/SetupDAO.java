package com.Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public interface SetupDAO {

  boolean insertStr(Map<String, String> insertVals);
  boolean insertInt(Map<String, Integer> insertVals);
  boolean insertDouble(Map<String, Double> insertVals);
  boolean updateStr(Map<String, String> updateVals, String colCheck, String valCheck);
  boolean updateInt(Map<String, Integer> updateVals, String colCheck, String valCheck);
  boolean updateDouble(Map<String, Double> updateVals, String colCheck, String valCheck);
  ResultSet select(ArrayList<String> colSelect, String whereCol, String whereVal);
  boolean delete(String whereCol, String whereVal);
  boolean clearTable();
}
