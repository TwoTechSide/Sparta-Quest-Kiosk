package com.example.kiosk.Lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        // 기본적인 메뉴를 배열에 초기화
        MenuItem[] menu = new MenuItem[4];
        menu[0] = new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menu[1] = new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menu[2] = new MenuItem("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menu[3] = new MenuItem("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거");

        // 키오스크 반복 진행
        while (flag) {
            // 메뉴 목록 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menu.length; i++) {
                System.out.print((i+1) + ". " + menu[i].getName() + "\t");
                System.out.print("| W " + menu[i].getPrice() + "\t");
                System.out.print("| " + menu[i].getDescription() + "\n");
            }
            System.out.println("0. 종료");

            // 만약 메뉴에 있는 번호 입력시 주문한 햄버거의 정보를 출력하거나 키오스크 종료
            System.out.print("입력 : ");
            int selectNum = sc.nextInt();

            System.out.println();

            if (selectNum > 0) {
                MenuItem selectedMenu = menu[selectNum - 1];
                System.out.println("주문한 햄버거 이름 : " + selectedMenu.getName() + " / " + selectedMenu.getDescription());
                System.out.println("가격 : " + selectedMenu.getPrice());
            } else if (selectNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                flag = false;
            }
        }
    }
}