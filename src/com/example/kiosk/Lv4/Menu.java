package com.example.kiosk.Lv4;

import java.util.List;

public class Menu {

    private String category;
    private List<MenuItem> menuItems;

    Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }
}
