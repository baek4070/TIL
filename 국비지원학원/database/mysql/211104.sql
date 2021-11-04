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

-- 9월에 입사한 사원의 사원번호, 사원명, 입사일 출력
SELECT empno, ename, hiredate 
FROM emp
WHERE substr(hiredate,6,2)= '09';

-- 문자의 위치를 구하는 함수
SELECT instr('WELCOME TO MYSQL','O') FROM dual; -- 5
SELECT instr('Welcome to Mysql','O') FROM dual; -- 대소문자 상관없음 ~ 
SELECT instr('이것이 MySQL이다','다')FROM dual; 	-- 11 

-- 공백을 제거 하는 함수
SELECT ltrim('               MySQL'); -- 왼쪽 공백 제거
SELECT rtrim('MySQL               '); -- 오른쪽 공백 제거 

-- 양쪽에서특정 문자 제거
SELECT trim('a' FROM'aaaaaaMySQLabaa');
SELECT trim(' ' FROM'     MySQL ab   ');

-- 문자열로 매개변수들을 묶어주는 concat()
SELECT concat('MySQL',80,' 을',' 배웁니다.') FROM dual;

-- 사원의 정보를 'SCOTT은 월급을 받습니다.' 형태로 출력
SELECT concat(ename,'은 ', sal,'을 받습니다.') AS 'RESULT' 
FROM emp ORDER BY sal DESC;

-- 날짜 관련 함수's
-- 현재 시간을 반환하는 sysdate(), now()
SELECT sysdate() FROM dual;
SELECT sysdate() - INTERVAL 1 day AS 어제,
	   sysdate() AS 오늘,
	   sysdate() + INTERVAL 1 day AS 내일;

-- 한달전
SELECT sysdate() - INTERVAL 1 month;
-- 1년전
SELECT sysdate() - INTERVAL 1 year;
-- 10년 후
SELECT sysdate() + INTERVAL 10 year;
-- 현재 시간에서 1분을 더함
-- date_add(기준시간,계산시간)
SELECT now() , date_add(now(), INTERVAL 1 MINUTE);
-- 시간을 뺌
SELECT now() , date_add(now(), INTERVAL -1 MINUTE);
SELECT now() , date_sub(now(), INTERVAL 1 HOUR);
-- 3시간 이후
SELECT now() , date_sub(now(), INTERVAL -3 HOUR);

-- 두 시간 사이의 간격(차이)를 계산a
-- timestamdiff(년월일,비교할 기준 시간,비교할 기준시간);
SELECT empno, ename, hiredate, noW(),
timestampdiff(year, hiredate, now())
FROM emp;

-- 사원들의 근무 개월 수
SELECT empno, ename, hiredate, noW(),
timestampdiff(month, hiredate, now())
FROM emp;

-- 날짜를 형식에 맞는 문자열로 반환하는 함수
-- date_format
/*
	%Y 4자리 년도		%y 2자리 년도		%m 숫자 월(2자리)
    %c 숫자 월(1자리) %M 긴 월(영문)		%b (짧은 월) 영문
    %d 일자(두자리)	%e 일자(한자리)	%W (요일이름 영문)
    %a (짧은 요일 영문)%I 시간(12시)		%H 시간(24시)
    %i 분			%S 초	
    %r hh:mm:ss AM,PM
    %T hh:mm:ss
*/
SELECT noW(), date_format(now(), '%y/%n/%d') FROM dual;
SELECT noW(), date_format(now(), '%y/%n/%d %T');

-- 년 월 주 별로 전달한 date가 언제인지 표현하는 함수
SELECT dayname(now()); -- 요일 이름(영문)
-- 일요일 1 ~~ 토요일 7
SELECT dayOfWeek(now()); -- 5(목요일)
SELECT dayOfMonth(now()); -- 월중 날짜
SELECT dayOfYear(now()); -- 308

-- case 문
-- 특정 속성의 값을 비교하여 다른 형태의 값으로 제공
-- 사원 정보를 검색하여 부서번호에 따라 사원이름, 부서번호, 부서명을 출력
SELECT ename, deptno, 
	#데이터를 조회하다가 deptno 가 10인 데이터를 만나면 dname 이란 별칭으로 '내용'을출력하여라 ~ 
	CASE WHEN deptno = 10 THEN 'ACCOUNTING'
		 WHEN deptno = 20 THEN 'RESEARCH'
         WHEN deptno = 30 THEN 'SALES'
         WHEN deptno = 20 THEN 'OPERATINGS'
    END AS dname
FROM emp;

-- Query문을 미리 등록 시켜놓고 필요한 것을 후에 전달하는
-- PREPARE EXCUTE 문
-- PREPARE 이름 FROM 'Query문';
PREPARE mQuery FROM
'SELECT ename, sal FROM emp ORDER BY sal LIMIT ?';
SET @tempVal = 3;

EXECUTE mQuery USING @tempVal;
SET @tempVal = 10;
EXECUTE mQuery USING @tempVal;
/****************************************************************************/
-- 사원의 부서 번호와 이름을 합쳐서 출력되게 검색
SELECT concat(deptno,'=',ename)
FROM emp;
-- 사원의 이름, 입사일자를 '80/12/17에 입사한 SWITH입니다.' 형식으로 검색
SELECT concat(date_format(hiredate,'%y/%m/%d'),'에 입사한 ',ename,'입니다.')
FROM emp;
-- 사원 번호가 79로 시작하는 사원들의 이름과 급여, 커미션을 검색 substr 사용
SELECT empno,ename, sal ,comm
FROM emp
WHERE substr(empno,1,2)=79;
-- 1981년 2월에 입사한 사원의 사원번호, 이름, 부서번호를 검색
-- substr 사용
SELECT empno,ename,deptno
FROM emp
WHERE substr(hiredate,1,7)='1981-02';
-- 사원정보에서 사원들의 이름을 소문자로 직무를 대문자로 검색
SELECT lower(ename),upper(job)
FROM emp;
-- 사원들의 이름을 검색하되 첫자만 대문자로 변경하여 검색
SELECT ename, substr(ename, 1, 1) FROM emp;
SELECT concat(substr(ename, 1, 1),
		lower(substr(ename, 2, length(ename)-1))) AS '이름'
FROM emp;

/*********************************************/
-- JOIN

-- 크로스 조인 합쳐지는 테이블의 행 * 행 개수
SELECT * FROM emp, dept;

-- inner join  emp.deptno = dept.deptno 일치하는 것만 조인시키겠다
SELECT emp.*, dept.*
FROM emp, dept WHERE emp.deptno = dept.deptno;

-- natural join 중복되는 속성을 기준으로 join
SELECT * FROM emp NATURAL JOIN dept
ORDER BY emp.empno;

-- 조인을 사용해서 뉴욕에서 근무하는 사원의 이름과 급여 출력
SELECT ename, sal 
FROM emp, dept
WHERE emp.deptno = dept.deptno # 어디있는 녀석인지 정확히 알려줘야함 table.record
AND dept.loc = 'NEW YORK';

-- join을 이용하여 SCOTT이 근무하는 부서이름 출력
SELECT ename,dname
FROM emp, dept
WHERE emp.deptno = dept.deptno
AND emp.ename = 'SCOTT';

SELECT dname FROM emp JOIN dept
ON dept.deptno = emp.deptno
WHERE emp.ename = 'SCOTT';  
-- sub query  # 결과는 동일하지만 join은 모든속성값을 사용가능하다는 차이점이 있다 
SELECT dname FROM dept
WHERE deptno = (
	SELECT deptno FROM emp
	WHERE ename = 'SCOTT'
);

-- NATURAL JOIN
SELECT dname FROM
emp NATURAL JOIN dept
WHERE emp.ename = 'SCOTT';

-- SELF JOIN
-- 사원의 이름과 그사원의 매니저 이름을 출력하기
-- ename -mgr & mgr = 사원번호 : ename
SELECT a.ename AS 사원, b.ename AS 매니저
FROM emp AS a, emp AS b #어떤 emp가 어떤 emp인지 모르니 별칭을 달아주자 ! 
WHERE a.mgr = b.empno;

-- SCOTT 이랑 동일한 근무지에 근무하는 사람의 사원명 출력
-- SCOTT 제외
SELECT a.ename , b.ename 
FROM emp AS a, emp AS b
WHERE a.deptno = b.deptno 
	AND b.ename != 'SCOTT'
    AND a.ename = 'SCOTT';
    
-- outer join //조인 범위에서 벗어난것도 출력해주는데 왼쪽이냐 오른쪽이냐 
-- LEFT JOIN / RIGHT JOIN
-- 일치하지 않는 값이라도 남아있는 테이블의 값이 존재하면 검색
SELECT a.ename , b.ename FROM emp a RIGHT JOIN emp b
ON a.mgr = b.empno ORDER BY a.ename DESC;

SELECT a.ename , b.ename FROM emp a LEFT JOIN emp b
ON a.mgr = b.empno ORDER BY a.ename DESC;