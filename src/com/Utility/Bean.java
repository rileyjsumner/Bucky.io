package com.Utility;

import java.util.HashMap;

public class Bean<K extends Comparable<K>,V> {
  private HashMap<K, V> fields;
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
  public Bean(HashMap<K, V> fields, String title) {
    this.fields = fields;
    this.title = title;
  }

  /**
   * Adds field to the Bean
   * @param fieldName name of field
   * @param fieldValue value of field
   */
  public void addField(K fieldName, V fieldValue) {
    this.fields.put(fieldName, fieldValue);
  }

  /**
   * Sets field of Bean to new value
   * @param fieldName name of field
   * @param fieldValue new value
   */
  public void setField(K fieldName, V fieldValue) {
    this.fields.replace(fieldName, fieldValue);
  }

  /**
   * Get the value of a field
   * @param fieldName name of field to get
   * @return value of field
   */
  public V getField(K fieldName) {
    return this.fields.get(fieldName);
  }

  /**
   * Remove a field from the bean
   * @param fieldName name of field to remove
   */
  public void deleteField(K fieldName) {
    this.fields.remove(fieldName);
  }

  /**
   * Detects if field exists in boolean
   * @param fieldName name of field to test
   * @return boolean if field exists in the Bean
   */
  public boolean hasField(K fieldName) {
    return this.fields.containsKey(fieldName);
  }

  /**
   * Detects if there is a field with value in Bean
   * @param fieldValue value to test
   * @return boolean if value exists in Bean
   */
  public boolean hasValue(V fieldValue) {
    return this.fields.containsValue(fieldValue);
  }
}
