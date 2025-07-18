package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<MenuItem> menuItems = new ArrayList<>();

        while (true) {
            menuItems.add(new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
            menuItems.add(new MenuItem("ShackBurger", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
            menuItems.add(new MenuItem("ShackBurger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
            menuItems.add(new MenuItem("ShackBurger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"));

            System.out.println("[ SHAKESHACK MENU ]");
            int num = 1;

            for (MenuItem item : menuItems) {
                System.out.print(num++ + ". " + item.getName() + "\t");
                System.out.print("| W " + item.getPrice() + "\t");
                System.out.print("| " + item.getDescription() + "\n");
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
}