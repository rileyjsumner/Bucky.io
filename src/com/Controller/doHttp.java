package com.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface doHttp {
  void doGet(HttpServletRequest request, HttpServletResponse response);
  void doPost(HttpServletRequest request, HttpServletResponse response);
  void doPut(HttpServletRequest request, HttpServletResponse response);
  void doDelete(HttpServletRequest request, HttpServletResponse response);
}
