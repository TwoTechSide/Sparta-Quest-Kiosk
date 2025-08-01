## 📌 내일배움캠프 - [Java] 키오스크 프로젝트
Java로 키오스크를 7단계까지 각 단계별로 패키지를 나누어, 요구하는 기능을 적용하며 완성해가는 프로젝트입니다.

일반적인 키오스크의 특징을 생각하여 '**프로그램을 구성하는 객체들의 역할과 책임**'을
어떻게 나누어 설정할지 고민하며 구현하는 것에 초점을 맞추면서 프로젝트를 진행하였습니다.

- - -

## 📋 각 단계별 학습 목표

### [Lv 1.] 기본적인 키오스크를 프로그래밍 해보자
<details>
<summary>접기/펼치기</summary>

- 요구사항이 가지는 의도
    - Scanner, 조건문, 반복문을 재확인하며 입력 데이터를 처리하는 방법 강화
- 햄버거 메뉴 출력 및 선택
    - Scanner를 사용하여 여러 햄버거 메뉴를 출력
    - 제시된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행하는 코드 작성
    - 반복문을 이용해서 특정 번호가 입력되면 프로그램 종료
</details>

### [Lv 2.] 객체 지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기
<details>
<summary>접기/펼치기</summary>

- 요구사항이 가지는 의도
    - 객체 지향 개념을 학습하고, 데이터를 구조적으로 관리하며 프로그램을 설계하는 방법을 익히기
    - 햄버거 메뉴를 `MenuItem` 클래스와 `List` 를 통해 관리
- `MenuItem` 클래스 생성
    - MenuItem 객체 생성을 통해 이름, 가격, 설명을 세팅
- `List`를 선언하여 여러 `MenuItem`을 추가
    - `List menuItems = new ArrayList<>();
- 반복문을 활용해 menuItems를 탐색하면서 하나씩 접근
</details>

### [Lv 3.] 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기
<details>
<summary>접기/펼치기</summary>

- 요구사항이 가지는 의도
    - 객체 지향 개념 학습, 데이터 구조 관리를 통해 프로그램 설계
    - `main` 함수에서 관리하던 전체 순서 제어를 `Kiosk` 클래스를 통해 관리

- `Kiosk` 클래스 생성하기
    - `MenuItem`을 관리하는 리스트가 필드로 존재
    - `main` 함수에서 관리하던 입력과 반복문 로직은 `start`함수를 만들어 관리
    - `List<MenuItem> menuItems`는 `Kiosk` 클래스 생성자를 통해 값을 할당
        - `Kiosk` 객체를 생성하고 사용하는 `main` 함수에서 객체를 생성할 때 값을 전달

- 요구사항에 부합하는지 검토
    - 키오스크 프로그램을 시작하는 메서드 구현
        - 콘솔에 햄버거 메뉴 출력
        - 사용자의 입력을 받아 메뉴를 선택하거나 프로그램 종료
        - 유효하지 않은 입력에 대해 오류 메시지를 출력
        - `0`을 입력하면 프로그램이 `뒤로가기`되거나 `종료`
</details>

### [Lv 4.] 객체 지향 설계를 적용해 음식 메뉴와 주문 내역을 클래스 기반으로 관리하기
<details>
<summary>접기/펼치기</summary>

- `Menu` 클래스 생성하기
    -  `MenuItem` 클래스를 관리하는 `Menu` 클래스 생성
        - 버거 메뉴, 음료 메뉴 등 각 카테고리에서 여러 `MenuItem`을 포함
    -  `List<MenuItem>`을 `Menu` 클래스가 관리하도록 변경
    - 여러 버거들을 포함하는 상위 개념 ‘버거’ 같은 `카테고리 이름` 필드 추가
    - 메뉴 카테고리 이름을 반환하는 메서드가 구현
</details>

### [Lv 5.] 캡슐화 적용하기
<details>
<summary>접기/펼치기</summary>

- `MenuItem`, `Menu` 그리고 `Kiosk` 클래스의 필드에 직접 접근하지 못하도록 설정
</details>

- - -

## 📚 도전 기능 가이드

### [Lv 6.] 장바구니 및 구매하기 기능을 추가하기
<details>
<summary>접기/펼치기</summary>

- 장바구니 생성 및 관리 기능
    - 사용자가 선택한 메뉴를 장바구니에 추가할 수 있는 기능을 제공
    - 장바구니는 메뉴명, 수량, 가격 정보를 저장하며, 항목을 동적으로 추가 및 조회
    - 사용자가 잘못된 선택을 했을 경우 예외를 처리 (예: 유효하지 않은 메뉴 번호 입력)
- 장바구니 출력 및 금액 계산
    - 사용자가 결제를 시도하기 전에, 장바구니에 담긴 모든 메뉴와 총 금액을 출력
    - 출력 예시
        - 각 메뉴의 이름, 가격, 수량
        - 총 금액 합계
- 장바구니 담기 기능
    - 메뉴를 클릭하면 장바구니에 추가할 지 물어보고, 입력값에 따라 “추가”, “취소” 처리
    - 장바구니에 담은 목록을 출력

- 주문 기능
    - 장바구니에 담긴 모든 항목을 출력
    - 합산하여 총 금액을 계산하고, “주문하기”를 누르면 장바구니 초기화
</details>

### [Lv7.] Enum, 람다 & 스트림을 활용한 주문 및 장바구니 관리
<details>
<summary>접기/펼치기</summary>

- 요구사항이 가지는 의도
    - 목적
        - Enum을 통해 프로그램 구조를 간결하게, 상수를 안전하게 관리
        - 제네릭을 활용하여 데이터 유연성을 높이고, 재사용 가능한 코드를 설계
        - 스트림 API를 사용하여 데이터를 필터링하고, 간결한 코드로 동작을 구현

- Enum을 활용한 사용자 유형별 할인율 관리하기
    - 사용자 유형의 Enum 정의 및 각 사용자 유형에 따른 할인율 적용
        - 예시 : 군인, 학생, 일반인
    - 주문 시, 사용자 유형에 맞는 할인율 적용해 총 금액 계산
- 람다 & 스트림을 활용한 장바구니 조회 기능
    - 기존에 생성한 Menu의 MenuItem을 조회 할 때 스트림을 사용하여 출력하도록 수정
    - 기존 장바구니에서 특정 메뉴 빼기 기능을 통한 스트림 활용
        - 예시 : 장바구니에 SmokeShack 가 들어 있다면, stream.filter를 활용하여 특정 메뉴 이름을 가진 메뉴 장바구니에서 제거

</details>

- - -

## 🛠 사용 기술 및 도구

- **IDE** : Intellij IDEA
- **Language** : Java 17
- **Version Control** : Git

- - -

## 📅 개발 기간
- 2025.07.16 ~ 2025.07.24 (총 9일)

- - -

## 📒 프로젝트 후기 (TIL)

- "[TIL] 개인 프로젝트 - '키오스크 프로젝트' 후기"
  [https://twotechside.github.io/posts/TIL_003/](https://twotechside.github.io/posts/TIL_003/)