package com.Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public interface SetupDAO {

  public boolean insertStr(String tablename, Map<String, String> insertVals);
  public boolean insertInt(String tablename, Map<String, Integer> insertVals);
  public boolean insertDouble(String tablename, Map<String, Double> insertVals);
  public boolean updateStr(String tablename, Map<String, String> updateVals, String colCheck, String valCheck);
  public boolean updateInt(String tablename, Map<String, Integer> updateVals, String colCheck, String valCheck);
  public boolean updateDouble(String tablename, Map<String, Double> updateVals, String colCheck, String valCheck);
  public ResultSet select(String tablename, ArrayList<String> colSelect, String whereCol, String whereVal);
  public boolean delete(String tablename, String whereCol, String whereVal);
  public boolean clearTable(String tablename);
}
