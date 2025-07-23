package com.example.kiosk.Lv6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private final List<Menu> menus;
    private final List<MenuItem> selectedMenuItems = new ArrayList<>();
    private int flag = 0;

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
        Menu selectedMenu = null;
        MenuItem selectedMenuItem = null;

        while (flag > -1) {
            try {
                // flag == 0 -> 카테고리 선택
                if (flag == 0) {
                    // 카테고리 선택 화면 출력
                    printCategories();

                    // 입력값에 따라 프로그램을 종료하거나 특정 카테고리의 메뉴 선택으로 이동
                    selectNum = sc.nextInt();

                    if (selectNum == 0) { flag = -1; break; }
                    else if (selectNum <= menus.size()) { selectedMenu = menus.get(selectNum); flag = 1; }
                    else throw new InputMismatchException();
                }

                // flag == 1 -> 메뉴 선택
                else if (flag == 1) {
                    // 메뉴 선택 화면 출력
                    // 만약 메뉴 선택이 이루어지지 않는 버그가 발생하는 경우 처음부터 다시 진행
                    if (selectedMenu != null) printMenuItems(selectedMenu);
                    else { flag = 0; continue; }

                    // 0        : 카테고리 선택으로 이동
                    // menuItem : 장바구니 추가 확인으로 이동
                    // other    : 잘못된 입력 예외 처리 -> 재확인
                    selectNum = sc.nextInt();

                    if (selectNum == 0) flag = 1;
                    else if (selectNum <= selectedMenu.getMenuItems().size()) { selectedMenuItem = selectedMenu.getMenuItem(selectNum-1); flag = 2; }
                    else throw new InputMismatchException();
                }

                // flag == 2 -> 장바구니 추가 확인
                else if (flag == 2) {
                    // 장바구니 추가 확인 화면 출력
                    // 만약 메뉴 아이템 선택이 이루어지지 않는 버그가 발생하는 경우 처음부터 다시 진행
                    if (selectedMenuItem != null) {
                        String selectedMenuItemInfo = String.format("%s | W %.1f | %s", selectedMenuItem.getName(), selectedMenuItem.getPrice(), selectedMenuItem.getDescription());
                        System.out.println("선택한 메뉴: " + selectedMenuItemInfo);
                    } else { flag = 0; continue; }

                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인\t\t2.취소");

                    // 1        : 장바구니에 추가
                    // 2        : 장바구니 취소, 메뉴판으로 이동
                    // other    : 잘못된 입력이므로 다시 확인
                    selectNum = sc.nextInt();

                    if (selectNum == 1) { selectedMenuItems.add(selectedMenuItem); flag = 0; }
                    else if (selectNum == 2) flag = 1;
                    else throw new InputMismatchException();
                }
            }
            // 메뉴에 있는 숫자를 벗어난 값을 받는 경우(=IndexOutOfBoundsException), 정수가 아닌 값을 받는 경우(=InputMismatchException)
            // 예외 처리하고, 예외가 발생한 flag로 재이동
            catch (IndexOutOfBoundsException e) {
                System.out.println("[오류] : 메뉴를 조회하는데 실패하였습니다. 다시 시도해주세요.");
            } catch (InputMismatchException e) {
                System.out.println("[오류] : 잘못된 입력입니다.");
                sc.nextLine();
            } finally {
                System.out.println();
            }
        }
    }
}
