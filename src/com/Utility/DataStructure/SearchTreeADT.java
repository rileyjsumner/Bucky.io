package com.Utility.DataStructure;

import com.Exception.DuplicateKeyException;
import com.Exception.KeyNotFoundException;

public interface SearchTreeADT<K,V> {

  void insert(K key, V value) throws DuplicateKeyException;
  void remove(K key) throws KeyNotFoundException;
  boolean contains(K key) throws KeyNotFoundException;
  int height();
  boolean isEmpty();


}
