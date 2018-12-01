package com.Utility;

import com.Model.DAO;

public class Admin extends DAO {
  /*
  Create
  Read
  Update
  Delete

  Reports
  count
  count at condition
   */

  /**
   * Creates an admin Object to handle CRUD functions
   * @param table_name name of admin table data
   */
  public Admin(String table_name) {
    super(table_name);
  }



}
