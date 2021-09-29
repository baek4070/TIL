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
- 변수를 선언하면 무조건 stack에 저장된다 하지만 변수내 데이터가 여러가지일 경우에는 heap에 저장을하고 stack에 해당 주소를 저장한다. 이를 참조변수라고 한다

## 조건문

- if 조건문 // 조건식이 true 면 실행문 블럭을 실행하고 아니면 무시
- if else 조건문 //  조건에 따라 분기
- 중첩 조건문과 if else if 조건문

## 반복문

- 배열
    - 변수 여러개를 한꺼번에 다룰 수 있는 자료형 ( 객체의 일종)
    - 자바스크립트 상에서는 데이터 타입구분없이 배열에 잡아넣을수 있지만 통상적인 올바른 배열 사용법이 아니기 때문에 지양해야한다
    - stack array 에 모든값을 저장할수 없기 떄문에 heap이라는 공간에 저장함
    - index 라는 번호를 사용 ( 0 부터 시작 )
- for 반복문 : 반복 횟수가 정해져 있을때 // for (초기화식(최초1회실행), 조건식, 증감식)
- while 반복문
    - 표현식이 참이면 중괄호 안의 문장을 계속 실행
    - 조건이 변하지 않으면 무한 반복하므로 조건을 거짓으로 만들 수 있는 문장을 포함해야함
- do-while 반복문
    - 조건문을 판단하기 전에 do 블록의 코드를 먼저 실행, 그리고 조건문을 판단하여 조건문의 결과가 true 이면 do 블록의 코드를 다시 실행,

## 함수

- 선언과 호출, 실행 우선순위
    - 익명 함수
    - 선언적 함수
- 실행 우선순위
- 매개 변수(Parameter)와 반환 값
    - 매개변수 : 함수의 괄호 안에 집어 넣는것
        - Parameter&Argument
        - Paremeter(매개변수), Argument(인자) // 입력과 관련
        - Return//출력
        - ex) function sum(left, right){} // left , right 가 parameter(매개변수)라고한다
        - ex)sum(2,3) // 2와 3을 인자(Argument) 라고한다
        - 정리하자면 인자의 값을 받아서 함수안으로 매개 해주는 변수를 매개변수라고한다
    - 리턴 값
        - Return 함수값을 돌려서 주는것  : sum(2.5) 를 쓰게되면 바로7로 출력이 되는것
- 콜백 함수 // 이벤트가 발생하는 시점에 익명함수를 받아 놓았다가 실행하는 함수
    - callback() : 문자열 '함수 호출'을 출력할 수 있는 함수
    - callTenTimes() : 매개 변수로 전달된 함수를 열번 호출하는 함수
    - 익명 콜백 함수

## 객체(Object)

- 객체 개요
    - 객체란 현실의 사물을 프로그래밍에 반영한 것
    - 배열
    - 객체의 속성에 접근하는법
- 속성과 메소드
    - 속성(Property) : 객체 내부에 있는 값 하나하나
    - 메소드(Method) : 객체의 속성 중 자료형이 함수인 속성
    - this 키워드 : 자기 자신이 가진 속성이라는 것을 표시

## 클래스(class)

- ES6에 추가된 class 키워드

## 변수 선언 방식

var 유연한 변수 선언으로 인해 변수를 한번더 선언했음에도 불구하고 에러가 나오지 않는다. 이는 간단한 테스트에는 편리할수 있겠으나, 코드량이 많아진다면 어디에서 어떻게 사용된지 파악하기 힘들뿐더러 값이 바뀔 우려가 있다 그래서 ES6 이후, 이를 보완하기 위해 추가 된 변수 선언 방식이 let 과 const 이다.

- var //변수 재선언, 변수 재할당 가능
- let // 변수 재할당 가능
- const // 변수 재선언, 변수 재할당 모두 불가
- 기본적으로 const 를 사용하고 재할당이 필요한 경우에 한정해 let을 사용하는걸 권장
    - 객체를 재할당하는 경우는 생각보다 흔하지 않다. const를 사용하면 의도치 않은 재할당을 방지해 주기 떄문에 보다 안전하다.

## 호이스팅 (Hoisting)

- JavaScript에서의 Hoisting : 변수의 정의가 그 범위에 따라 선언과 할당으로 분리되는 것을 의미한다. 즉, 변수가 함수 내에서 정의되었을 경우, 선언부분만 함수의 최상위로, 함수 바깥에서 정의되었을 경우, 전역 컨텍스트의 최상위로 변경이 된다
- 호이스팅이란
    - 자바스크립트 함수는 실행되기 전에 함수 안에 필요한 변수값들을 모두 모아서 유효 범위의 최상단에 선언한다.
    - 자바스크립트 Parser가 함수 실행 전 해당 함수를 한 번 훑는다.
    - 함수 안에 존재하는 변수/함수선언에 대한 정보를 기억하고 있다가 실행시킨다.
    - 유효 범위: 함수 블록 {} 안에서 유효
    즉, 함수 내에서 아래쪽에 존재하는 내용 중 필요한 값들을 끌어올리는 것이다.
    - 실제로 코드가 끌어올려지는 건 아니며, 자바스크립트 Parser 내부적으로 끌어올려서 처리하는 것이다.
    - 실제 메모리에서는 변화가 없다.

## 엄격 모드(strict mode)

- ES5 에서 처음으로 소개된 것으로 엄격한 오류 검사를 적용해줌, trict 모드의 문법에 따라 엄격하게 검사함
- strict 모드는 스크립트나 함수의 맨 처음에 "use strict" 지시어를 사용하여 선언
- strict 모드의 문법
    - 변수
        - 선언되지 않은 변수나 객체를 사용할 수 없음.
        - eval()함수 내에서 선언된 변수는 외부에서 사용할 수 없음
    - 프로퍼티
        - 읽기 전용 프로퍼티에는 대입할 수 없음
        - 한 프로퍼티를 여러 번 정의할 수 없음
    - 함수
        - 함수를 구문이나 블록 내에서 선언할 수 없음
    - 매개변수
        - 매개변수의 이름이 중복되어서는 안됨
        - arguments 객체의 요소 값을 변경할 수 없음
    - 문자열
        - 문자열"eval" 과 "arguments" 는 사용할 수 없음
    - 8진수
        - 숫자 리터럴에 8진수 값을 대입할 수 없음
    - this
        - this 포인터가 가르키는 값이 null이나 undefined인 경우 전역 객체로 변환되지 않음
    - delete
        - delete 키워드를 사용할 수 없음
    - with
        - with 문을 사용할 수 없음
    - 예약어
        - 다음 예약어들은 사용할 수 없음
        - implements, interface, let, package, private, protected, public, static, yield

## 문서 객체 모델(DOM)

- window : BOM(Browser Object Model)
    - navigator
    - screen
    - location : 이동정보
    - document : 문서 정보 // 문서에서 javascript로 태그요소를 제어한다는걸 dom을 제어한다고 한다
- 문서 객체 모델 관련 용어
    - 문서 객체 모델 : 웹 브라우저가 HTML 파일을 분석하고 표시하는 방식
    - 태그: h1 또는 p
    - 문서 객체 : HTML 태그를 자바스크립트에서 객체로 만든 것
    - 문서 객체 조작 = 태그 조작
    - 요소 노드 : h1 태그와 script 태그처럼 요소를 생성하는 노드
    - 텍스트 노드 : 화면에 출력되는 문자열
        - br, hr, img 등은(는) 텍스트 노드를 갖지않는 태그
- 웹페이지 생성 순서
    - 웹브라우저는 HTML 코드를 위쪽에서 아래쪽으로 실행
- 문서 객체 선택
    - 1개의 문서 객체 선택
        - document.getElementByld(아이디) : 아이디를 사용해 문서 객체 선택//동일한 ID값을 가진녀석들 중 최상단 한개만 가져옴 // 보통 CSS에서 class를 자주 사용하듯 자바에선 id를 자주 사용
        - document.querySelector(선택자) : 선택자를 사용해 문서 객체 선택//CSS에서 쓰던거 ~ //동일한 선택자를 가진녀석들 중 최상단 한개만 가져옴
        - querySelector() 메소드 사용
    - 여러 개의 문서 객체 선택
        - document.getElementsByName(이름) : name 속성으로 여러 개의 문서 객체 선택 // 배열을 전달해주는 녀석
        - document.getByClassName(클래스) : class 속성으로 여러 개의 문서 객체 선택
        - document,querySelectorAll(선택자) : 선택자로 여러 개의 문서 객체 선택
- 문서 객체 조작
    - 글자 조작
        - textContent : 일반 글자 형식의 문서 객체 내부 글자// 태그가 포함되있으면 그냥 문자열로 출력해버림
        - innerHTML : HTML형식의 문서 객체 내부 글자 // 태그로 출력해줌
    - 스타일 조작 // 스크립트로 CSS를 제어하면 Inline 요소로 삽입됨 그래서 최우선순위로 적용//카멜 표기법으로 하시죠
        - background-image = backgroundImage // 자바스크립트엔선 특수문자 $랑 _ 밖에 못쓰기때문에 - 이런건 못쓴다
        - background-color = backgroundColor
        - box-sizing = boxSizing
        - list-style = listStyle
    - 속성 조작
        - setAttribute(속성 이름, 속성 값) : 속성 지정
        - getAttribute(속성 이름) : 속성 추출
- 이벤트
    - 이벤트 : 키보드나 마우스처럼 어떤현상이 프로그램에 영향을 미치는 것
        - 이벤트 종류와 개요
            - 마우스 이벤트
            - 키보드 이벤트
            - HTML 프레임 이벤트
            - HTML 입력 양식 이벤트
            - 사용자 인터페이스 이벤트
            - 구조 변화 이벤트
            - 터치 이벤트
            - 이벤트 속성 : onload
            - 이벤트 이름(이벤트 타입) : on을 제외한 load
            - 이벤트 리스너 (이벤트 핸들러) : 이벤트 속성에 넣는 함수
    - 이벤트 모델 : 문서 객체에 이벤트를 연결하는 방법
        - DOM Level 0 : 인라인 이벤트 모델, 고전 이벤트 모델
        - DOM Level 2 :  마이크로소프트 인터넷 익스플로러 이벤트 모델, 표준 이벤트 모델
        - 이벤트 속성
            - onblur
            - onfocus
            - onfocusin
            - onfocusout
            - onload
            - onresize
            - onscroll
            - onunload
            - onclick
            - ondbclick
            - onmousedown
            - onmouseup
            - onmousemove
            - onmouseover
            - onmouseout
            - onmouseenter
            - onmouseleave
            - onchange
            - onselect
            - onsubmit
            - onkeydown
            - onkeypress
            - onkeyup
            - onerror
            
    - 이벤트 객체
        - 표준 이벤트 객체
        - 인터넷 익스플로러 이벤트 객체
        - 짧은 조건문을 사용한 이벤트 객체 사용
    - 기본 이벤트 제거
        - 기본 이벤트 제거를 사용한 유효성 검사