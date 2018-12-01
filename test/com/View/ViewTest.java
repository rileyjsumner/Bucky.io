package com.View;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

public class ViewTest {

  /*
  Create JFrame
  Make Shapes
  Set colors
   */

  @Test
  public void testCreateWindow() {
    View view = new View();
    JFrame frame = view.createWindow("Frame Title", 150, 200);
    Assert.assertEquals(true, frame.getHeight() == 200 && frame.getWidth() == 150 && frame.getTitle().equals("Frame Title"));
  }

}
