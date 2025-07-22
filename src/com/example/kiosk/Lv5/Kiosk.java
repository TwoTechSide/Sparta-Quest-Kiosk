package com.example.kiosk.Lv5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private final List<Menu> menus;
    private final List<MenuItem> selectedMenuItems = new ArrayList<>();
    private boolean flag = true;

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

        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem menuItem = menuItems.get(i);
            System.out.println((i+1) + ". " + menuItem.toString());
        }
        System.out.println("0. 뒤로가기");
    }

    // 키오스크 시작 함수
    public void start() {
        Scanner sc = new Scanner(System.in);
        int selectNum;

        while (flag) {
            try {
                // 카테고리 선택
                printCategories();
                selectNum = sc.nextInt();
                Menu selectedMenu;

                // 0 : 키오스크 종료
                // 1 ~ n : menus : List<Menu>에서 선택
                // 나머지 : InputMismatchException 으로 예외 처리
                if (selectNum == 0) {
                    flag = false;
                    break;
                } else if (selectNum < menus.size()) {
                    selectedMenu = menus.get(selectNum-1);
                } else {
                    throw new InputMismatchException();
                }

                // 메뉴 선택
                printMenuItems(selectedMenu);
                selectNum = sc.nextInt();

                // 0 : 카테고리 선택 화면으로 돌아가기
                // 1 ~ n : selectedMenu : List<Menu>에서 선택
                // 나머지 : InputMismatchException 으로 예외 처리
                if (selectNum == 0) {
                    continue;
                } else if (selectNum < selectedMenu.getMenuItems().size()) {
                    MenuItem selectedMenuItem = selectedMenu.getMenuItem(selectNum-1);
                    selectedMenuItems.add(selectedMenuItem);
                } else {
                    throw new InputMismatchException();
                }

                // 선택한 메뉴들 출력
                System.out.println("------- 선택한 메뉴 -------");
                for (MenuItem menuItem : selectedMenuItems) { System.out.println(menuItem.toString()); }
                System.out.println("-------------------------");
            }
            // 메뉴에 있는 숫자를 벗어난 값을 받는 경우(=IndexOutOfBoundsException), 정수가 아닌 값을 받는 경우(=InputMismatchException) 예외 처리
            catch (IndexOutOfBoundsException e) {
                System.out.println("[오류] : 메뉴를 조회하는데 실패하였습니다. 다시 시도해주세요.");
            } catch (InputMismatchException e) {
                System.out.println("[오류] : 잘못된 입력입니다.");
                sc.next();
            }
        }
    }
}
