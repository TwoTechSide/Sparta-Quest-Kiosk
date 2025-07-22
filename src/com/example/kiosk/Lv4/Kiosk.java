package com.example.kiosk.Lv4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    Scanner sc = new Scanner(System.in);
    private final List<MenuItem> menuItems = new ArrayList<>();
    private final List<MenuItem> selectedMenuItems = new ArrayList<>();
    private final List<Menu> menus;
    boolean flag = true;

    // 키오스크 생성자 -> 각 카테고리별 메뉴가 담긴 리스트 불러오기
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
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
        int selectedMenuCount = selectedMenuItems.size();

        // 선택한 메뉴가 1개 이상 있는 경우 실행
        if (selectedMenuCount > 0) {
            float sumPrice = 0;

            System.out.print("[선택한 메뉴 목록] : ");

            for (int i = 0; i < selectedMenuCount; i++) {
                MenuItem menuItem = selectedMenuItems.get(i);
                System.out.print(menuItem.getName() + " ");
                sumPrice += menuItem.getPrice();
            }

            System.out.println();
            System.out.println("가격 총합 : " + sumPrice);
        }
    }

    // 키오스크 시작 함수
    public void start() {
        while (flag) {
            // 메뉴 출력
            printMenuItems();
            System.out.println("0. 종료");

            // 입력을 받으며 메뉴 선택 및 종료
            try {
                System.out.print("입력 : ");
                int selectNum = sc.nextInt();

                // 선택 목록에 메뉴 추가,
                if (selectNum > 0 && selectNum <= menuItems.size())
                    selectedMenuItems.add(menuItems.get(selectNum - 1));

                // '0; 입력시 start() 함수를 종료하며 키오스크 종료
                else if (selectNum == 0) {
                    // 함수 종료
                    flag = false;
                    break;
                } else {
                    System.out.println("[주의] : 메뉴에 없는 숫자입니다.");
                }
            } catch (InputMismatchException e) {        // [catch] - Scanner로 받은 값이 숫자가 아닌 경우
                System.out.println("[오류] : 잘못된 입력입니다.");
                sc.next();
            } catch (IndexOutOfBoundsException e) {     // [catch] - 만약 입력받은 index 값으로 menuItem 리스트를 조회할 수 없는 경우
                System.out.println("[오류] : 메뉴를 조회하는데 실패하였습니다.");
            } finally {
                // 선택한 메뉴 목록 출력
                printSelectedMenuItems();
            }
        }
    }
}
