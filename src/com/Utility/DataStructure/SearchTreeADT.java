package com.Utility.DataStructure;

import com.Exception.DuplicateKeyException;

public interface SearchTreeADT<K,V> {

  void insert(K key, V value) throws DuplicateKeyException;

}
