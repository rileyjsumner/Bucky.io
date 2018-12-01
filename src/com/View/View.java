package com.View;

import javax.swing.*;

public class View {
    public  JFrame createWindow(String title, int width, int height){
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
        return frame;
    }
}