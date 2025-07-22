package com.example.kiosk.Lv4;

import java.util.List;

public class Menu {

    private String category;
    private final List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    // Getter
    public String getCategory() { return category; }
    public List<MenuItem> getMenuItems() { return menuItems; }
    public MenuItem getMenuItem(int num) { return getMenuItems().get(num); }
}
