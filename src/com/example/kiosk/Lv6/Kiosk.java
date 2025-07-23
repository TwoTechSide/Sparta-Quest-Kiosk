package com.example.kiosk.Lv6;

import java.util.*;

public class Kiosk {

    private final List<Menu> menus;
    private final Cart cart = new Cart();
    private int flag = 0;

    // 키오스크 생성자 -> 각 카테고리별 메뉴가 담긴 리스트 불러오기
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    // 카테고리 선택 화면 출력
    private void printCategories() {
        int index = 1;

        System.out.println("[ MAIN MENU ]");
        while (index <= menus.size()) {
            Menu menu = menus.get(index-1);
            System.out.println(index + ". " + menu.getCategory());
            index++;
        }
        System.out.println("0. 종료");

        // 만약 장바구니에 메뉴가 있을 경우 -> 주문 또는 장바구니 취소
        if (cart.isPresent()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println(index + ". Orders\t| 장바구니를 확인 후 주문합니다.");
            index++;
            System.out.println(index + ". Cancel\t| 진행중인 주문을 취소합니다.");
        }
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
        Optional<Menu> selectedMenu = Optional.empty();

        while (flag > -1) {
            try {
                // flag == 0 -> 카테고리 선택
                if (flag == 0) {
                    // 카테고리 선택 화면 출력
                    printCategories();

                    // 입력값에 따라 프로그램을 종료하거나 특정 카테고리의 메뉴 선택으로 이동
                    selectNum = sc.nextInt();

                    if (selectNum == 0) { flag = -1; break; }
                    else if (selectNum <= menus.size()) { selectedMenu = Optional.ofNullable(menus.get(selectNum - 1)); flag = 1; }
                    else {
                        // 만약 장바구니에 메뉴 아이템이 있을 경우, [ ORDER MENU ]의 Orders, Cancel 확인
                        if (cart.isPresent()) {
                            if (selectNum == menus.size()+1) flag = 2;
                            else if (selectNum == menus.size()+2) { cart.clear(); flag = 0; }
                        }
                        // 만약 장바구니가 없는 경우 예외 처리
                        else throw new InputMismatchException();
                    }
                }

                // flag == 1 -> 메뉴 선택 화면 및 장바구니 추가 확인
                else if (flag == 1) {
                    Menu menu;
                    // Menu 객체를 Optional 에서 Get, 오류 발생시 예외 처리
                    if (selectedMenu.isPresent()) {
                        menu = selectedMenu.get();
                    } else {
                        throw new NullPointerException();
                    }

                    printMenuItems(menu);

                    // 0        : 카테고리 선택으로 이동
                    // menuItem : 장바구니 추가 여부 확인
                    // other    : 잘못된 입력 예외 처리
                    selectNum = sc.nextInt();

                    if (selectNum == 0)
                        flag = 0;
                    else if (selectNum <= selectedMenu.get().getMenuItems().size()) {
                        MenuItem selectedMenuItem = menu.getMenuItem(selectNum - 1);

                        // 장바구니 추가 여부
                        String selectedMenuItemInfo = String.format("%s | W %.1f | %s", selectedMenuItem.getName(), selectedMenuItem.getPrice(), selectedMenuItem.getDescription());
                        System.out.println("\n선택한 메뉴: " + selectedMenuItemInfo);
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인\t\t2.취소");

                        // 1        : 장바구니에 추가
                        // 2        : 장바구니 취소, 메뉴판으로 이동
                        // other    : 잘못된 입력이므로 다시 확인
                        selectNum = sc.nextInt();

                        if (selectNum == 1) { cart.addMenuItem(selectedMenuItem); flag = 0; }
                        else if (selectNum == 2) flag = 1;
                        else throw new InputMismatchException();
                    }
                    else throw new InputMismatchException();
                }

                // flag == 2 -> 장바구니 확인 후 주문
                else if (flag == 2) {
                    List<MenuItem> cartMenuItems = cart.getMenuItemList();
                    float totalPrice = cart.getTotalPrice();

                    System.out.println("아래와 같이 주문하시겠습니까?");

                    // 주문한 메뉴 및 합계 출력
                    System.out.println("\n[ Orders ]");
                    for (MenuItem menuItem : cartMenuItems)
                        System.out.println(menuItem.toString());

                    System.out.println("\n[ Total ]");
                    System.out.printf("W %.1f\n", totalPrice);

                    // 1 : 주문 선택시 합계를 출력하며 키오스크 종료
                    // 2 : 메뉴판 선택시 다시 카테고리 선택으로 이동
                    // other    : 잘못된 입력이므로 다시 확인
                    System.out.println("\n1.주문\t\t2.메뉴판");
                    selectNum = sc.nextInt();

                    if (selectNum == 1) {
                        System.out.printf("\n주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", totalPrice);
                        cart.clear();
                        flag = 0;
                    }
                    else if (selectNum == 2) flag = 0;
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
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                System.out.println("[오류] : 예기치 못한 오류가 발생하였습니다. 다시 시도해주세요.");
            } finally {
                System.out.println();
            }
        }
    }
}
