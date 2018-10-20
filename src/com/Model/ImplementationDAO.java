package com.Model;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.HashMap;

public class ImplementationDAO extends DAO {
  public ImplementationDAO() {
    super();
  }
  public static void main(String args[]) {
    ImplementationDAO myImpl = new ImplementationDAO();
    myImpl.insertStr("table", new HashMap<>());

    DAO myDAO = new DAO();
    myDAO.updateStr("table", new HashMap<>(), "col", "val");
      System.out.print("ffffffffffffffffffff");
  }
}
