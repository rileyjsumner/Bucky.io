package com.Utility;

import java.util.HashMap;

public class Bean {
  private HashMap<String, Object> fields;
  public Bean() {
    fields = new HashMap<>();
  }
  public Bean(HashMap<String, Object> fields) {
    this.fields = fields;
  }
  public void addField(String fieldName, Object fieldValue) {
    this.fields.put(fieldName, fieldValue);
  }
  public void setField(String fieldName, Object fieldValue) {
    this.fields.replace(fieldName, fieldValue);
  }
  public Object getField(String fieldName) {
    return this.fields.get(fieldName);
  }
  public void deleteField(String fieldName) {
    this.fields.remove(fieldName);
  }
}
