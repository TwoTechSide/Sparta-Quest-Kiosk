package com.example.kiosk.Lv5;

public class MenuItem {
    private final String name;
    private final float price;
    private final String description;

    MenuItem(String name, float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 메뉴 출력시 toString() 오버라이딩
    @Override
    public String toString() {
        return String.format("%-15s | W %.1f | %s", name, price, description);
    }
}
