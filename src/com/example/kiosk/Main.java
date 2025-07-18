package com.example.kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MenuItem[] menu = new MenuItem[4];
        menu[0] = new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menu[1] = new MenuItem("ShackBurger", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menu[2] = new MenuItem("ShackBurger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menu[3] = new MenuItem("ShackBurger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거");

        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menu.length; i++) {
            System.out.print((i+1) + ". " + menu[i].getName() + "\t");
            System.out.print("| W " + menu[i].getPrice() + "\t");
            System.out.print("| " + menu[i].getDescription() + "\n");
        }
        System.out.println("0. 종료");

        System.out.print("입력 : ");
        int selectNum = sc.nextInt();

        System.out.println();

        if (selectNum == 0) {
            System.out.println("프로그램을 종료합니다.");
            return;
        }
    }
}