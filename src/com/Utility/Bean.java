package com.Utility;

import java.util.HashMap;

public class Bean {
  private HashMap<String, Object> fields;
  private final String title;

  /**
   * Constructor for Bean class
   * @param title of Bean
   */
  public Bean(String title) {
    this.fields = new HashMap<>();
    this.title = title;
  }

  /**
   * Constructor for Bean class
   * @param fields initial values of fields for Bean
   * @param title of bean
   */
  public Bean(HashMap<String, Object> fields, String title) {
    this.fields = fields;
    this.title = title;
  }

  /**
   * Adds field to the Bean
   * @param fieldName name of field
   * @param fieldValue value of field
   */
  public void addField(String fieldName, Object fieldValue) {
    this.fields.put(fieldName, fieldValue);
  }

  /**
   * Sets field of Bean to new value
   * @param fieldName name of field
   * @param fieldValue new value
   */
  public void setField(String fieldName, Object fieldValue) {
    this.fields.replace(fieldName, fieldValue);
  }

  /**
   * Get the value of a field
   * @param fieldName name of field to get
   * @return value of field
   */
  public Object getField(String fieldName) {
    return this.fields.get(fieldName);
  }

  /**
   * Remove a field from the bean
   * @param fieldName name of field to remove
   */
  public void deleteField(String fieldName) {
    this.fields.remove(fieldName);
  }

  /**
   * Detects if field exists in boolean
   * @param fieldName name of field to test
   * @return boolean if field exists in the Bean
   */
  public boolean hasField(String fieldName) {
    return this.fields.containsKey(fieldName);
  }

  /**
   * Detects if there is a field with value in Bean
   * @param fieldValue value to test
   * @return boolean if value exists in Bean
   */
  public boolean hasValue(Object fieldValue) {
    return this.fields.containsValue(fieldValue);
  }
}
