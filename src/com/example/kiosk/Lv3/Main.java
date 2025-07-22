package com.example.kiosk.Lv3;

public class Main {
    public static void main(String[] args) {

        // 키오스크 객체 생성
        Kiosk kiosk = new Kiosk();

        // 키오스크 실행
        kiosk.start();

        // 만약 키오스크가 종료되는 경우
        System.out.println("키오스크를 종료합니다.");
    }
}