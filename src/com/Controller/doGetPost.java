package com.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface doGetPost {
  void doGet(HttpServletRequest request, HttpServletResponse response);
  void doPost(HttpServletRequest request, HttpServletResponse response);
}
