package com.Model;

import java.util.List;
import java.util.Map;

public interface SQL {
  // SELECT colSelect FROM tablename WHERE whereCol = whereVal;
  Object select(String tablename, List<String> colSelect, String whereCol, Object whereVal);
  // INSERT INTO tablename (insertVal<String>) VALUES (insertVal<Object>) WHERE whereCol = whereVal;
  Object insert(String tablename, Map<String, Object> insertVal, String whereCol, Object whereVal);
  // UPDATE tablename SET updateVal<String> = updateVal<Object> WHERE whereCol = whereVal;
  Object update(String tablename, Map<String, Object> updateVal, String whereCol, Object whereVal);
  // DELETE FROM tablename WHERE whereCol = whereVal
  Object delete(String tablename, String whereCol, Object whereVal);
}
