package com.View;

import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;

public class View {

    private String title;
    private int width;
    private int height;

    private JFrame frame;

    public View() {
        this.title = null;
        this.width = -1;
        this.height = -1;

        this.frame = null;
    }

    public View(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        this.frame = createWindow(title, width, height);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JFrame createWindow(String title, int width, int height){
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
        return frame;
    }

    public JPanel addPanel(){
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        return panel;
    }

    public JButton addNewButton(String title){
        JButton button = new JButton(title);
        frame.getContentPane().add(button);
        return button;
    }

    public JButton addNewButton(Icon icon){
        JButton button = new JButton(icon);
        frame.getContentPane().add(button);
        return button;
    }

    public JButton addNewButton(String title, Icon icon){
        JButton button = new JButton(title, icon);
        frame.getContentPane().add(button);
        return button;
    }

    public JCheckBox addCheckBox (String title){
        JCheckBox checkBox = new JCheckBox(title);
        frame.getContentPane().add(checkBox);
        return checkBox;
    }

    public JCheckBox addCheckBox (Icon icon){
        JCheckBox checkBox = new JCheckBox(icon);
        frame.getContentPane().add(checkBox);
        return checkBox;
    }

    public JCheckBox addCheckBox (String title, Icon icon){
        JCheckBox checkBox = new JCheckBox(title, icon);
        frame.getContentPane().add(checkBox);
        return checkBox;
    }

    public JCheckBox addCheckBox (String title, boolean selected){
        JCheckBox checkBox = new JCheckBox(title, selected);
        frame.getContentPane().add(checkBox);
        return checkBox;
    }

    public JCheckBox addCheckBox (Icon icon, boolean selected){
        JCheckBox checkBox = new JCheckBox(icon, selected);
        frame.getContentPane().add(checkBox);
        return checkBox;
    }

    public JCheckBox addCheckBox (String title, Icon icon, boolean selected){
        JCheckBox checkBox = new JCheckBox(title, icon, selected);
        frame.getContentPane().add(checkBox);
        return checkBox;
    }

    public JCheckBoxMenuItem addCheckBoxMenuItem (String title){
        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem(title);
        frame.getContentPane().add(checkBoxMenuItem);
        return checkBoxMenuItem;
    }

    public JCheckBoxMenuItem addCheckBoxMenuItem (Icon icon){
        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem(icon);
        frame.getContentPane().add(checkBoxMenuItem);
        return checkBoxMenuItem;
    }

    public JCheckBoxMenuItem addCheckBoxMenuItem (String title, Icon icon){
        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem(title, icon);
        frame.getContentPane().add(checkBoxMenuItem);
        return checkBoxMenuItem;
    }

    public JCheckBoxMenuItem addCheckBoxMenuItem (String title, boolean selected){
        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem(title, selected);
        frame.getContentPane().add(checkBoxMenuItem);
        return checkBoxMenuItem;
    }

    public JCheckBoxMenuItem addCheckBoxMenuItem (String title, Icon icon, boolean selected){
        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem(title, icon, selected);
        frame.getContentPane().add(checkBoxMenuItem);
        return checkBoxMenuItem;
    }

    public JColorChooser addColorChooser (Color color){
        JColorChooser colorChooser = new JColorChooser(color);
        frame.getContentPane().add(colorChooser);
        return colorChooser;
    }

    public JColorChooser addColorChooser (ColorSelectionModel model){
        JColorChooser colorChooser = new JColorChooser(model);
        frame.getContentPane().add(colorChooser);
        return colorChooser;
    }

    public JFileChooser addFileChooser (File currentDirectory){
        JFileChooser fileChooser = new JFileChooser(currentDirectory);
        frame.getContentPane().add(fileChooser);
        return fileChooser;
    }

    public JFileChooser addFileChooser (FileSystemView fav){
        JFileChooser fileChooser = new JFileChooser(fav);
        frame.getContentPane().add(fileChooser);
        return fileChooser;
    }

    public JFileChooser addFileChooser (String currentDirectoryPath){
        JFileChooser fileChooser = new JFileChooser(currentDirectoryPath);
        frame.getContentPane().add(fileChooser);
        return fileChooser;
    }

    public JFileChooser addFileChooser (File currentDirectory, FileSystemView fav){
        JFileChooser fileChooser = new JFileChooser(currentDirectory, fav);
        frame.getContentPane().add(fileChooser);
        return fileChooser;
    }

    public JFileChooser addFileChooser (String currentDirectoryPath, FileSystemView fav){
        JFileChooser fileChooser = new JFileChooser(currentDirectoryPath, fav);
        frame.getContentPane().add(fileChooser);
        return fileChooser;
    }
    

}