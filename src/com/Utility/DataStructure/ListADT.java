package com.Utility.DataStructure;

import com.Exception.KeyNotFoundException;

public interface ListADT<T> {

  void add(T data);
  void remove(T data) throws KeyNotFoundException;
  boolean contains(T data) throws KeyNotFoundException;
  void clear();
  int size();
  boolean isEmpty();

}
