package com.example.kiosk.Lv7;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private final Map<MenuItem, Integer> menuItems = new HashMap<>();

    // 메뉴 추가
    public void addMenuItem(MenuItem menuItem) {
        // 메뉴에 아이템을 넣거나 수량을 1 추가
        menuItems.entrySet().stream()
                .filter(e -> e.getKey().equals(menuItem))
                .findFirst()
                .ifPresentOrElse(e -> menuItems.put(e.getKey(), e.getValue()+1), () -> {menuItems.put(menuItem, 1);});
    }

    // 장바구니에 있는 메뉴 아이템 가격의 합계 출력
    public float getTotalPrice() {
        return menuItems.entrySet().stream()
                .map(e -> e.getKey().getPrice() * e.getValue())
                .reduce(0.0f, Float::sum);
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