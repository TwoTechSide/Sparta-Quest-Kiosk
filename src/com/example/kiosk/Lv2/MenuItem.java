package com.example.kiosk.Lv2;

public class MenuItem {
    private String name;
    private float price;
    private String description;

    MenuItem(String name, float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() { return name; }
    public float getPrice() { return price; }
    public String getDescription() { return description; }
}
