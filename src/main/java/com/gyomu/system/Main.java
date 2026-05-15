package com.gyomu.system;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        Window window = new Window(db);
        window.setVisible(true);
    }
}