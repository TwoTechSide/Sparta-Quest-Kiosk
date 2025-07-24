package com.example.kiosk.Lv7;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private final Map<MenuItem, Integer> menuItems = new HashMap<>();

    // 메뉴 추가
    public void addMenuItem(MenuItem menuItem) {
        // 이미 장바구니에 있는 경우 수량을 1씩 추가
        if (menuItems.containsKey(menuItem)) {
            menuItems.put(menuItem, menuItems.get(menuItem) + 1);
        } else {
            menuItems.put(menuItem, 1);
        }
    }

    // 장바구니에 있는 메뉴 아이템 가격의 합계 출력
    public float getTotalPrice() {
        float totalPrice = 0;
        for (MenuItem item : menuItems.keySet())
            totalPrice += item.getPrice() * menuItems.get(item);

        return totalPrice;
    }

    // 장바구니의 메뉴 아이템 리스트 반환
    public List<MenuItem> getMenuItemList() {
        return new ArrayList<>(menuItems.keySet());
    }

    public boolean isPresent() {
        return !menuItems.isEmpty();
    }

    public void clear() {
        menuItems.clear();
    }

    // 장바구니의 메뉴 목록 출력
    public void printCartMenuItems() {
        menuItems.forEach((menuItem, count) -> {
            System.out.printf("%-2d * %-15s | W %.1f | %s%n", count, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        });
    }
}