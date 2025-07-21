package com.example.kiosk.Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<MenuItem> menuItems = new ArrayList<>();
        List<MenuItem> selectedMenuItems = new ArrayList<>();
        boolean flag = true;

        menuItems.add(new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"));

        while (flag) {
            System.out.println("[ SHAKESHACK MENU ]");
            int num = 0;

            for (MenuItem item : menuItems) {
                System.out.print(++num + ". " + item.getName() + "\t");
                System.out.print("| W " + item.getPrice() + "\t");
                System.out.print("| " + item.getDescription() + "\n");
            }

            System.out.println("0. 종료");

            if (!selectedMenuItems.isEmpty()) {
                System.out.print("선택한 메뉴 : ");
                int menuCnt = selectedMenuItems.size();
                float sumPrice = 0;

                for (int i = 0; i < menuCnt; i++) {
                    MenuItem menuItem = selectedMenuItems.get(i);
                    System.out.print(menuItem.getName() + " ");
                    sumPrice += menuItem.getPrice();
                }

                System.out.println();
                System.out.println("가격 총합 : " + sumPrice);
            }

            System.out.print("입력 : ");
            int selectNum = sc.nextInt();

            System.out.println();

            if (selectNum > 0) {
                selectedMenuItems.add(menuItems.get(selectNum - 1));
            } else if (selectNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                flag = false;
            }
        }
    }
}