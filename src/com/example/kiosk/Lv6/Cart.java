package com.example.kiosk.Lv6;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private final Map<MenuItem, Integer> menuItems = new HashMap<>();

    public void addMenuItem(MenuItem menuItem) {
        menuItems.put(menuItem, 1);
    }

    public float getTotalPrice() {

        float totalPrice = 0;
        for (MenuItem item : menuItems.keySet())
            totalPrice += item.getPrice() * menuItems.get(item);

        return totalPrice;
    }

    public List<MenuItem> getMenuItemList() {
        return new ArrayList<>(menuItems.keySet());
    }

    public boolean isPresent() {
        return !menuItems.isEmpty();
    }

    public void clear() {
        menuItems.clear();
    }
}