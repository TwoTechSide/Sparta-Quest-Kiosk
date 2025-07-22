package com.example.kiosk.Lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    Scanner sc = new Scanner(System.in);
    private final List<MenuItem> menuItems = new ArrayList<>();
    private final List<MenuItem> selectedMenuItems = new ArrayList<>();
    boolean flag = true;

    // 키오스크 생성시 기본 메뉴 리스트 생성
    public Kiosk() {
        menuItems.add(new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    // menuItems 리스트를 반복문으로 돌아가며 출력
    private void printMenuItems() {
        for (int i = 1; i <= menuItems.size(); i++) {
            MenuItem menuItem = menuItems.get(i - 1);
            System.out.print(i + ". " + menuItem.getName() + "\t");
            System.out.print("| W " + menuItem.getPrice() + "\t");
            System.out.print("| " + menuItem.getDescription() + "\n");
        }

    }

    // 선택한 메뉴 목록과 총 합계 출력
    private void printSelectedMenuItems() {
        int menuCnt = selectedMenuItems.size();
        float sumPrice = 0;

        System.out.print("선택한 메뉴 : ");

        for (int i = 0; i < menuCnt; i++) {
            MenuItem menuItem = selectedMenuItems.get(i);
            System.out.print(menuItem.getName() + " ");
            sumPrice += menuItem.getPrice();
        }

        System.out.println();
        System.out.println("가격 총합 : " + sumPrice);
    }

    // 키오스크 시작 함수
    public void start() {
        while (flag) {
            // 1. 메뉴 출력
            printMenuItems();
            System.out.println("0. 종료");

            // 2. 입력을 받으며 메뉴 선택 및 종료
            System.out.print("입력 : ");
            int selectNum = sc.nextInt();

            if (selectNum > 0) {
                // 선택 목록에 메뉴 추가, 선택한 메뉴 목록 출력
                selectedMenuItems.add(menuItems.get(selectNum - 1));
                printSelectedMenuItems();
            } else if (selectNum == 0) {
                // 함수 종료
                break;
            }
        }
    }
}
