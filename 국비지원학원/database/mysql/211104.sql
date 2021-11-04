-- 변수 초기화
-- 일반적인 언어에서는 대입 연산자 (=) 사용
-- SQL 에서는 = 가 비교 연산자로도 사용됨.

-- 변수 사용
-- @를 통해서 변수를 표시
-- @ 하나는 사용자 변수
-- @@ 두개는 시스템 변수
-- 대입연산자로만 사용되는 := 도 존재함.

use sqlDb;
-- 선언과 초기화
SET @myVal1 = 10;
-- 변수가 선언이 될때 타입으로 공간을차지해야 하므로 
-- 선언과 동시에 값이 대입되어야함.
SET @myVal2 = 3;
SET @myVal3 = 3.141592;
SET @myVal4 = '이름->';

SELECT @myVal1;
SELECT @myVal2 + @myVal3;
SELECT @myVal4, name 
FROM userTbl
WHERE height > 180;

SET @myVal4 = '가수 이름 =>';

-- 행 번호 얻기 rownum
SELECT * FROM buyTbl ORDER BY num DESC LIMIT 5;
DELETE FROM buyTbl WHERE num = 13;
-- SELECT 문에서 검색된 결과에 따른 행번호를 부여
-- := 대입연산자
SELECT @rn := 0; #여기 from dual이 생략된것임 !! 
-- , buyTbl.* //buyTbl 안의 모든걸 검색하겠다란 의미
SELECT @rn:=@rn+1 AS rownum, buyTbl.* FROM buyTbl;

SELECT * 
FROM -- 테이블 자리에 질의문 으로 만든 테이블이 들어감 ! 
	(SELECT @rn:=@rn+1 AS rnum, buyTbl.* 
	FROM buyTbl, (SELECT @rn:=0) a ) b
WHERE rnum BETWEEN 5 AND 10;

-- VIEW
-- 가상의 테이블 논리적으로 존재 하지 않지만 
-- SELECT문을 통해 생성된 구조와 정보를 가지고 있음
-- VIEW 사용
-- 질의안에 직접 SELECT 문을 통해 생성된 VIEW - 인라인 뷰
-- CREATE를 통해 생성된 개체 - VIEW 개체

-- CREATE VIEW 뷰이름 AS SELECT문;
USE smartWeb;

CREATE VIEW v_emp AS 
SELECT empno, ename 
FROM emp;

SELECT * FROM v_emp;
-- 인라인뷰
SELECT a.empno, a.ename -- 가상의 뷰 이기때문에 별칭을 달아주어야 함
FROM (SELECT empno,ename FROM emp) AS a;

SELECT emp.empno, ename FROM emp;

-- SELECT 문의 결과를 이름을 가지는 뷰라는 개체로 생성
-- 실제 데이터를 비추는 창문에 비유
-- 보안적인 목적으로 사용
-- 사용자는 사용되고 있는 데이터가 실제 table인지
-- 가상 테이블(view)인지 구별할 수 없음
-- 실제 테이블의 구조를 파악하기 힘듬.



use sqlDB;

CREATE VIEW v_usertbl AS 
SELECT userID, name FROM userTbl;

# 가상이기 때문에 따로 독립적인 공간을 마련하는것이 아니기 때문에 데이터 추가가안됨, 마치 참조변수 같은것
INSERT INTO v_userTbl 
VALUES('ABC','가나다');

SELECT * FROM v_userTbl;

UPDATE v_userTbl SET name = '홍길동'
WHERE userID = 'BBK';
# 이게 변경되었다는건 실제 테이블의 데이터가 변경되었다는것, 마치 참조변수와 같다
SELECT * FROM userTbl;

DELETE FROM v_userTbl WHERE userID = 'LSG';
# 가상 테이블에 정의된 속성을 통해서만 읽기와 쓰기가 가능하다 ! 
UPDATE v_userTbl SET birthYear = 1900
WHERE userID = 'BBK';

rollback;

/************************************************************************/
-- MySQL 내장 함수
-- dual 테이블
-- 데이터가 없고, 함수 계산을 위해 사용하는 가상의 테이블
-- 모든 RDBMS에 존재하는 테스트용 테이블

SELECT 1+1 FROM dual;

-- MySQL에서는 생략해도 가능.
SELECT 1+1;

-- 현재 날짜/시간 함수
SELECT sysdate(), now() FROM dual;

-- 현재 사용자 조회 함수
SELECT user() FROM dual;

-- 나머지를 구하는함수
SELECT MOD(27,2), MOD(27,5), MOD(27,7); # FROM dual 을 생략해도 되지만 호환성을 위해서 써주는게 좋다 !! 

use smartWeb;
-- 사원번호가 홀수인 사원의 사원번호, 사원명 출력
SELECT empno, ename FROM emp
WHERE mod(empno, 2) = 1;

-- 문자열 처리 함수's
-- 문자열을 대소문자로 처리
SELECT 'Welcome to MySQL',
upper('Welcome to MySQL'),
lower('Welcome to MySQL');

-- 문자열의 길이 구하는 함수
# MySQL 은 문자당 넘겨 받은 바이트 수를 나타냄  
# 한글은 utf-8로 글자당 3바이트 임으로 18바이트 로 표현이됨
# 영어는 ASCII 코드에서 글자당 1바이트로 표현이 됨으로 5바이트
SELECT length('MySQL'), length('마이에스큐엘');

-- 문자열 추출 함수 substr
SET @temp = 'Welcome to Mysql';
-- (문자열,시작위치,개수)
SELECT substr(@temp,4,3);
SELECT substr(@temp,-4,3);

-- 사원의 입사일을 사원번호, 사원명, 입사년, 월로 출력
SELECT hiredate FROM emp;
SELECT empno, ename,
substr(hiredate,1,4),
substr(hiredate,6,2) FROM emp;

