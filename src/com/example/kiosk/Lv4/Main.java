package com.example.kiosk.Lv4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 햄버거 메뉴
        List<MenuItem> burgerItems = Arrays.asList(
                new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"),
                new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거")
        );

        // 음료 메뉴
        List<MenuItem> drinkItems = Arrays.asList(
                new MenuItem("Cola", 1.5f, "콜라"),
                new MenuItem("Cider", 1.5f, "사이다"),
                new MenuItem("Americano", 1.2f, "아메리카노"),
                new MenuItem("MountainDew", 1.4f, "마운틴 듀")
        );

        // 디저트 메뉴
        List<MenuItem> dessertItems = Arrays.asList(
                new MenuItem("SoftIceCream", 1.2f, "부드러운 식감의 소프트 아이스크림"),
                new MenuItem("FrenchFries", 1.8f, "갓 구운 감자로 튀긴 감자튀김"),
                new MenuItem("LongCheeseStick", 2.0f, "모짜렐라 치즈가 들어있는 롱 치즈스틱")
        );

        // <햄버거, 음료, 디저트> 통합 메뉴 리스트
        List<Menu> menus = Arrays.asList(
                new Menu("Burger", burgerItems),
                new Menu("Drink", drinkItems),
                new Menu("Dessert", dessertItems)
        );

        // 각 카테고리별 메뉴가 담긴 메뉴 리스트를 키오스크 생성자에 전달
        Kiosk kiosk = new Kiosk(menus);

        // 만약 키오스크가 종료되는 경우
        System.out.println("키오스크를 종료합니다.");
    }
}