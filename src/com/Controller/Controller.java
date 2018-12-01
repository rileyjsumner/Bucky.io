package com.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Details
 */
public class Controller extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * Constructor for class Controller, instantiates an HttpServlet object
   */
  public Controller() {
    super();
  }

  /**
   * Forwards a request to render a jsp page
   * @param request servlet request
   * @param response servlet response
   * @param path to rendered file
   */
  public static void showPage(HttpServletRequest request, HttpServletResponse response, String path) {
    try {
      request.getRequestDispatcher(path).forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Sends a redirect to a given path
   * @param request servlet request
   * @param response servlet response
   * @param path to server redirect
   */
  public static void sendRedirect(HttpServletRequest request, HttpServletResponse response, String path) {
    try {
      response.sendRedirect(request.getContextPath()+path);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  // get parameter
  public static String getParam(HttpServletRequest request, String param) {
    return request.getParameter(param);
  }
  // set attribute
  public static void setAttr(HttpSession session, String attrName, Object attrValue) {
    session.setAttribute(attrName, attrValue);
  }

  public static Object getAttr(HttpSession session, String attrName) {
    return session.getAttribute(attrName);
  }

}
