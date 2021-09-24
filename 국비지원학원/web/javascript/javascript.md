# javascript

## 자바스크립트 기본용어

- 표현식과 문장
    - 표현식
    - 문장 : 마지막에 세미콜론(;)을 찍어 종결함
- 키워드
    - 키워드
        - break
        - else
        - instanceof
        - true
        - case
        - false
        - new
        - try
        - catch
        - finally
        - null
        - typeof
        - continue
        - for
        - return
        - var
        - default
        - function
        - switch
        - void
        - delete
        - if
        - this
        - while
        - do
        - in
        - throw
        - with
    - 예약 키워드
        - abstract
        - enum
        - int
        - short
        - boolean
        - export
        - interface
        - static
        - byte
        - extends
        - long
        - super
        - char
        - final
        - native
        - synchronized
        - class
        - float
        - package
        - throws
        - const
        - goto
        - private
        - transient
        - debugger
        - implements
        - protected
        - volatile
        - double
        - import
        - public
- 식별자
    - 식별자 생성 규칙 // 안지키면 오류발생
        - 키워드는 사용하지 않음
        - 특수 문자는 _과 $만 허용
        - 숫자로 시작하면 안 됨
        - 공백은 입력하면 안 됨
    - 식별자 사용 규칙 // 안지켜도 오류발생X  약속임
        - 생성자 함수의 이름은 항상 대문자로 시작
        - 변수, 인스턴스, 함수, 메소드의 이름은 항상 소문자로 시작
        - 여러 단어로 된 식별자는 각 단어의 첫 글자를 대문자로 함
    - 식별자 종류
        - 식별자 뒤의 괄호 O, 단독 : 함수
        - 식별자 뒤의 괄호 X, 단독 : 변수
        - 식별자 뒤의 괄호 O, 다른식별자와 함께 : 메소드
        - 식별자 뒤의 괄호 X, 다른식별자와 함께 : 속성
- 주석
    - 한행 주석처리 //
    - 여러 행 주석 처리 /\*내용*/

## 자바스크립트 출력

- alert() 함수 : 웹 브라우저의 경고창

## 자료형

- 수치형(number) 정수 or 실수
    - 나머지 연산자  %
- 문자열(string)
    - 이스케이프 문자
        - \t : 수평탭
        - \n : 행 바꿈
        - \\\ : 역슬래시
        - \' : 작은따움표
        - \" : 큰따옴표
    - + : 문자열 연결 연산자
- 부울형(boolean) 참 또는 거짓(true or false)
    - 비교 연산자 // 참인지 거짓인지 나타냄
        - ≥ : 좌변이 우변보다 크거나 같음
        - ≤ : 우변이 좌변보다 크거나 같음
        - > : 좌변이 우변보다 큼
        - < : 우변이 좌변보다 큼
        - == : 좌변과 우변이 같음
        - !- : 좌변과 우변이 다름
    - 논리 연산자
        - ! : 논리 부정 연산자
        - || : 논리곱 연산자
        - && : 논리합 연산자
- 객체(object) -함수도 포함(function) // javascript 에서는 객체와 함수를 구분 짓지 않는다
    - 호출이 가능한 객체를 함수형 객체 - alert('안녕');
    - 호출이 불가능한 객체를 object / object(); 실행이 불가능한 녀석
- ubdefined - 값이 정해지지 않은 상태
- null - 값이 없다는 걸 표현하는 데이터 타입
- infinity - 무한 연산 ex) 10/0

## 변수

- 값을 저장할 때 사용하는 식별자

## 조건문

- if 조건문 // 불 표현식이 true 면 문장을 실행하고 아니면 무시
- if else 조건문 //  조건에 따라 분기
- 중첩 조건문과 if else if 조건문

## 반복문

- 배열
    - 변수 여러개를 한꺼번에 다룰 수 있는 자료형 ( 객체의 일종)
- while 반복문
    - 표현식이 참이면 중괄호 안의 문장을 계속 실행
    - 조건이 변하지 않으면 무한 반복하므로 조건을 거짓으로 만들 수 있는 문장을 포함해야함
- for 반복문

## 함수

- 선언과 호출, 실행 우선순위
    - 익명 함수
    - 선언적 함수
- 실행 우선순위
- 매개 변수와 반환 값
    - 매개변수 : 함수의 괄호 안에 집어 넣는것
    - 리턴 값
- 콜백 함수
    - 문자열 '함수 호출'을 출력할 수 있는 함수
    - 익명 콜백 함수

## 객체

- 객체 개요
    - 배열
    - 객체의 속성에 접근하는법
- 속성과 메소드
    - 속성(Property) : 객체 내부에 있는 값 하나하나
    - 메소드(Method) : 객체의 속성 중 자료형이 함수인 속성
    - this 키워드 : 자기 자신이 가진 속성이라는 것을 표시