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

  /**
   * Gets a parameter from the servlet
   * @param request servlet request
   * @param param name to return
   * @return value of requested parameter
   */
  public static String getParam(HttpServletRequest request, String param) {
    return request.getParameter(param);
  }

  /**
   * Sets an attribute to the session
   * @param session current user session
   * @param attrName name of attribute
   * @param attrValue value of attribute
   */
  public static void setAttr(HttpSession session, String attrName, Object attrValue) {
    session.setAttribute(attrName, attrValue);
  }

  /**
   * Gets an attribute from the session
   * @param session current user session
   * @param attrName name of attribute to get
   * @return value of attribute
   */
  public static Object getAttr(HttpSession session, String attrName) {
    return session.getAttribute(attrName);
  }

}
