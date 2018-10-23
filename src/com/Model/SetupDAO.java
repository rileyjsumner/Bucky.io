package com.Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public interface SetupDAO {

  boolean insertStr(String tablename, Map<String, String> insertVals);
  boolean insertInt(String tablename, Map<String, Integer> insertVals);
  boolean insertDouble(String tablename, Map<String, Double> insertVals);
  boolean updateStr(String tablename, Map<String, String> updateVals, String colCheck, String valCheck);
  boolean updateInt(String tablename, Map<String, Integer> updateVals, String colCheck, String valCheck);
  boolean updateDouble(String tablename, Map<String, Double> updateVals, String colCheck, String valCheck);
  ResultSet select(String tablename, ArrayList<String> colSelect, String whereCol, String whereVal);
  boolean delete(String tablename, String whereCol, String whereVal);
  boolean clearTable(String tablename);
}
