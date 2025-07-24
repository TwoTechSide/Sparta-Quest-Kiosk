package com.example.kiosk.Lv7;

public enum UserType {
    VETERAN("국가유공자", 0.10f),
    SOLDIER("군인", 0.05f),
    STUDENT("학생", 0.03f),
    GENERAL("일반인", 0.00f);

    private final String type;
    private final float discountRate;

    UserType(String type, float discountRate) {
        this.type = type;
        this.discountRate = discountRate;
    }

    // Getter
    public String getType() { return type; }
    public float getDiscountRate() { return discountRate; }

    // 할인이 적용된 값 출력
    public float getDiscountedPrice(float price) {
        return price * (1 - discountRate);
    }
}
