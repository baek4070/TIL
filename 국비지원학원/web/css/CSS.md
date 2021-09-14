# CSS

마크업 lang 의 디자인 요소를 결정

## css3의 종류와 기본 작성법

- 내부 스타일 시트 : style 태그를 사용해 HTML 페이지 내부에 직접 입력
- 외부 스타일 시트
    * 협업 업무나 프로젝트 규모가 클때 사용
    *  스타일 시트를 생성후 link 태그의 href속성을 사용해 불러옴

## css3 선택자

- 선택자 개요
    * css 선택자 : 특정한 HTML 태그를 선택할 때 사용
    * 여러개의 선택자를 사용시에 , 를 이용해서 나열

### 기본선택자

위 부터 아래순으로 우선순위를 가짐, 동일하다면 아래쪽이 우선순위를 가짐

- 인라인 선택자
- 아이디 선택자 : #아이디 // 특정 ID 속성이 있는 태그 하나를 선택
- 클래스 선택자 : .클래스 // 특정 클래스가 있는 태그 선택
- 태그 선택자 : 태그 // HTML 페이지 내부의 특정 태그를 모두 선택
- 전체 선택자 : * // HTML 문서 안에 있는 태그를 모두 선택

- 속성 선택자
    * 선택자\[속성] // 특정한 속성이 있는 태그 선택
    * 선택자\[속성=값] // 속성값이 ~~인 선택자를 지정할때 사용
    * 선택자\[속성~=값] // ~ 형제 인녀석 ,후위 선택자
    * 선택자\[속성\=값] // 1개만
    * 선택자\[속성^=값] // 해당 속성값으로 시작하는~
    * 선택자\[속성$=값] // 해당 속성값으로 끝나는~~
    * 선택자\[속성*=값] // 해당 속성값이 포함 또는 완성이 되어있는~~
- 후손 선택자 : 선택자 선택자// 후손 전체중에서
- 자손 선택자 : 선택자 > 선택자 // 바로 근접한 아래 자식만 선택
- 반응 선택자 // 사용자가 어떤 동작을 할때 반응하여 디자인을 적용시켜 주는것
    * 선택자:active // 클릭되었을때
    * 선택자:hover // 마우스 포인트가 올라왔을때
- 상태 선택자 // 해당 상태일때 디자인을 적용
    * :checked // 체크박스가 체크되었을때
    * :focus // 커서가 이동했을때 , 바로 상호작용 할수있는 상태
    * :enabled // 활성화 되었을때, 자바스크립트로 제어할때 
    * :disabled // 비활성화 되었을때, 자바스크립트로 제어할때 
- 구조 선택자
    * 선택자:first-child // 자식들 중에 첫순서
    * 선택자:last-child// 자식들 중에 마지막 순서
    * 선택자:nth-child(수열)// 자식들 중에 수열에 해당하는 순서
    * 선택자:nth-last-child(수열)//n=0 부터 시작한다
    * 선택자:first-of-type
    * 선택자:last-of-type
    * 선택자:nth-of-type(수열)
    * 선택자:nth-last-of-type(수열)
- 동위 선택자
    * 선택자 + 선택자 // 뒤에 적힌 형제에 해당하는 요소
    * 선택자 ~ 선택자 // 뒤에 나열해있는 형제들중 후위 요소
- 링크 선택자
    * :link // 방문 여부에 따라
    * :visited // 방문 여부에 따라
- 문자 선택자 // 많이 사용은 안되니 교재참고 해서 알아둘것
    * ::first-letter
    * ::first-line
    * ::after
    * before
    * selection
- 부정 선택자 : 선택자:not(선택자) // 뒤 선택자를 제외한 앞 선택자에 해당 요소

## CSS3 단위

- 키워드 단위 : W3C에서 미리 정의한 단어, 키워드를 입력하면 키워드에 해당하는 스타일이 자동으로 적용
- 크기 단위
    * % : 기본 크기 기준으로 상대적인 크기, 초기 100%
    * em : 배수를 나타내는 단위 1em=1배=100%
    * px : 크기를 절대적으로 지정
- 색상단위
    * rgb(red, green, blue) : RGB 색상단위 , 0부터 255 까지 입력
    * rgba(red, green, blue, alpha) : RGBA 색상 단위, RGB 색상값에 투명도 alpha 값을 추가 0은 완전투명 1은 완전불투명
    * #000000 : HEX 코드 단위, RGB 색상단위를 짧게 입력하는 방법 16진수
- URL 단위 : 이미지나 글꼴 파일을 불러올 때 사용

## 박스 속성

웹 페이지의 레이아웃을 구성할 때 가장 중요

- width, height : 글자를 감싸는 영역의 크기를 지정
- margin : 테두리와 다른 태그의 간격을 지정
- padding : 테두리와 글자 사이의 간격을 지정
- 테두리 속성
    * border-width : 테두리의 두께를 지정하는 속성
    * border-style : 테두리의 형태를 지정하는 속성
    * border-radius : CSS3에서 추가된 속성, 테두리가 둥근 사각형이나 원을 표현

## display 속성

- none : 태그를 화면에서 감추기
- block : 태그를 블록 형식으로 지정
- inline : 태그를 인라인 형식으로 지정
- inline-block : 태그를 인라인-블록 형식으로 지정

## 배경속성

- background-image : 배경 이미지 지정
- background-size : 배경 이미지의 크기 지정
- background-repeat : 배경 이미지의 반복 형태 지정
    * repeat : 이미지를 패턴처럼 표시
    * repeat-x 를 입력하면  x축 방향으로 이미지 반복
    * repeat-y 를 입력하면 y축 방향으로 이미지 반복
- background-attachment : 배경 이미지의 부착 형태 지정
- background-position : 배경 이미지의 위치 지정
    * background-position : 키워드;
    * background-position : x축 위치;
    * background-position : x축 위치 y축 위치;
- background : 한번에 모든 배경 속성 입력

## 글자 속성

- font-size 속성 : 글자 크기를 지정하는 속성
- font-family 속성 : 글꼴을 지정 속성
- generic-family 글꼴 : 다국적 사용자 대상용 글꼴
- font-style 과 font-weight 속성 : 글자의 두께와 기울기를 조정하는 속성
- text-align 속성 : 정렬
- text-decoration 속성

## 위치 속성

절대 위치 좌표 : 요소의 X 좌표와 Y 좌표를 설정해 절대 위치를 지정

상대 위치 좌표 : 요서를 입력한 순서에 따른 상대 위치를 지정

- position 속성
    * static : 상대 위치 좌표 설정
    * relative : 초기 위치에서 상하좌우로 이동
    * absolute : 정대 위치 좌표 설정
    * fixed : 화면을 기준으로 절대 위치 좌표 설정
- z-index 속성 : 숫자가 클수록 앞에 위치
- 위치 속성 공식
- overflow 속성 : 내부의 요소가 부모의 범위를 벗어날 때 요소를 처리하는 방법

## float 속성

- left : 태그를 왼쪽에 붙이기
- right : 태그를 오른쪽에 붙이기

## 그림자 속성

- text-shadow 속성 : 글자에 그림자를 부여
- box-shadow 속성 : 박스에 그림자를 부여
- CSS3 Generator 사용 : box-shadow와 text-shadow 속성을 쉽게 생성 가능

## 그레이디언트

- 그레이디언트 : 두 가지 이상의 색상을 혼합하는 채색 기능
- CSS3 이전의 웹은 그레이디언트를 지워하지 않아 background-image 을 사용함
- 선형 그레이디언트 : linear-gradient () 함수에 선형 그레이디언트가 진행될 각도와 색상 블록을 입력
- 원형 그레이디언트 : radial-gradient() 함수를 사용

## CSS3 단위

- 키워드 단위 : W3C에서 미리 정의한 단어, 키워드를 입력하면 키워드에 해당하는 스타일이 자동으로 적용
- 크기 단위
    * % : 기본 크기 기준으로 상대적인 크기, 초기 100%
    * em : 배수를 나타내는 단위 1em=1배=100%
    * px : 크기를 절대적으로 지정
- 색상단위
    * rgb(red, green, blue) : RGB 색상단위 , 0부터 255 까지 입력
    * rgba(red, green, blue, alpha) : RGBA 색상 단위, RGB 색상값에 투명도 alpha 값을 추가 0은 완전투명 1은 완전불투명
    * #000000 : HEX 코드 단위, RGB 색상단위를 짧게 입력하는 방법 16진수
- URL 단위 : 이미지나 글꼴 파일을 불러올 때 사용

## 박스 속성

웹 페이지의 레이아웃을 구성할 때 가장 중요

- width, height : 글자를 감싸는 영역의 크기를 지정
- margin : 테두리와 다른 태그의 간격을 지정. top, right, bottom ,left 순으로
- padding : 테두리와 글자 사이의 간격을 지정
- 테두리 속성
    * border-width : 테두리의 두께를 지정하는 속성
    * border-style : 테두리의 형태를 지정하는 속성
    * border-radius : CSS3에서 추가된 속성, 테두리가 둥근 사각형이나 원을 표현

## display 속성

- none : 태그를 화면에서 감추기
- block : 태그를 블록 형식으로 지정
- inline : 태그를 인라인 형식으로 지정
- inline-block : 태그를 인라인-블록 형식으로 지정

## 배경속성

- background-image : 배경 이미지 지정
- background-size : 배경 이미지의 크기 지정
- background-repeat : 배경 이미지의 반복 형태 지정
    * repeat : 이미지를 패턴처럼 표시
    * repeat-x 를 입력하면  x축 방향으로 이미지 반복
    * repeat-y 를 입력하면 y축 방향으로 이미지 반복
- background-attachment : 배경 이미지의 부착 형태 지정
- background-position : 배경 이미지의 위치 지정
    * background-position : 키워드;
    * background-position : x축 위치;
    * background-position : x축 위치 y축 위치;
- background : 한번에 모든 배경 속성 입력

## 글자 속성

- font-size 속성 : 글자 크기를 지정하는 속성
- font-family 속성 : 글꼴을 지정 속성
- generic-family 글꼴 : 다국적 사용자 대상용 글꼴
- font-style 과 font-weight 속성 : 글자의 두께와 기울기를 조정하는 속성
- text-align 속성 : 정렬
- text-decoration 속성

## 위치 속성

절대 위치 좌표 : 요소의 X 좌표와 Y 좌표를 설정해 절대 위치를 지정

상대 위치 좌표 : 요서를 입력한 순서에 따른 상대 위치를 지정

- position 속성
    * static : 상대 위치 좌표 설정
    * relative : 초기 위치에서 상하좌우로 이동
    * absolute : 정대 위치 좌표 설정
    * fixed : 화면을 기준으로 절대 위치 좌표 설정
- z-index 속성 : 숫자가 클수록 앞에 위치
- 위치 속성 공식
- overflow 속성 : 내부의 요소가 부모의 범위를 벗어날 때 요소를 처리하는 방법

## float 속성

- left : 태그를 왼쪽에 붙이기
- right : 태그를 오른쪽에 붙이기

## 그림자 속성

- text-shadow 속성 : 글자에 그림자를 부여
- box-shadow 속성 : 박스에 그림자를 부여
- CSS3 Generator 사용 : box-shadow와 text-shadow 속성을 쉽게 생성 가능

## 그레이디언트

- 그레이디언트 : 두 가지 이상의 색상을 혼합하는 채색 기능
- CSS3 이전의 웹은 그레이디언트를 지워하지 않아 background-image 을 사용함
- 선형 그레이디언트 : linear-gradient () 함수에 선형 그레이디언트가 진행될 각도와 색상 블록을 입력
- 원형 그레이디언트 : radial-gradient() 함수를 사용

## CSS3 응용과 레이아웃

## CSS3 관계형 박스모델

## 그리드

- 그리드는 수평선과 수직선으로 이루어진 집합체로, 디자인 요소를 정렬할 수 있는 대상 패턴을 생성
- 디자인은 페이지에서 페이지로 이동할 때 요소가 널뛰거나 너비가 바뀌지 않는 디자인 생성에 도움을 주어 웹 사이트의 일관성을 높여줌
- columns, rows로 구성되며, 각 행과 열 사이에 공백이 있는데, 대게는 이를 일컬어 gutters라고함

## 미디어 쿼리

- 지정한 규칙에 브라우저 및 장치 환경이 일치하는 경우에만 css를 적용할수 있는 방법을 제공
- min-width, max-width 와같이 넓이 조건을주거나
- orientation: landscape 가로모드 조건을 넣을수 있음(넓은 쪽을 가로로인식)
- 논리곱
- 논리합
- 부정논리
- 분기점을 선정하는 방법
    * 미디어 쿼리가 도입되는 지점을 breakpoints 라고 한다
- mobile first 반응형 디자인 : 가장 작은 뷰로 시작해서 뷰포트의 크기 확대에 맞춰 조판을 추가하는것
