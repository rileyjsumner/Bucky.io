package com.Utility;

import java.util.HashMap;

public class Bean {
  private HashMap<String, Object> fields;
  private final String title;

  public Bean(String title) {
    this.fields = new HashMap<>();
    this.title = title;
  }
  public Bean(HashMap<String, Object> fields, String title) {
    this.fields = fields;
    this.title = title;
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
  public boolean hasField(String fieldName) {
    return this.fields.containsKey(fieldName);
  }
  public boolean hasField(Object fieldValue) {
    return this.fields.containsValue(fieldValue);
  }
}
