package com.example.kiosk.Lv4;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    Scanner sc = new Scanner(System.in);
    private final List<Menu> menus;
    boolean flag = true;

    // 키오스크 생성자 -> 각 카테고리별 메뉴가 담긴 리스트 불러오기
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    // 카테고리 선택 화면 출력
    private void printCategories() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.get(i);
            System.out.println((i+1) + ". " + menu.getCategory());
        }
        System.out.println("0. 종료");
    }

    // 선택된 카테고리의 메뉴 아이템들 출력
    private void printMenuItems(Menu menu) {
        List<MenuItem> menuItems = menu.getMenuItems();
        String category = menu.getCategory();

        System.out.println("[ " +  category + " MENU ]");

        for (int i = 1; i <= menuItems.size(); i++) {
            MenuItem menuItem = menuItems.get(i - 1);
            System.out.print(i + ". " + menuItem.getName() + "\t");
            System.out.print("| W " + menuItem.getPrice() + "\t");
            System.out.print("| " + menuItem.getDescription() + "\n");
        }
        System.out.println("0. 뒤로가기");
    }

    // 키오스크 시작 함수
    public void start() {
        while (flag) {
            printCategories();                  // 카테고리 출력
            int num = sc.nextInt();             /* [임시 값 입력] */

            printMenuItems(menus.get(num-1));   // 메뉴 출력
            flag = false;                       /* [임시 테스트 종료시 반복문 탈출] */
        }
    }
}
