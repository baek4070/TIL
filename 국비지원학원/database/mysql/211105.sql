-- 조인 - 여러 테이블의 정보를 합치는 것
use sqlDB;

-- CROSS JOIN 
SELECT count(*) FROM userTbl; -- 11개
SELECT count(*) FROM buyTbl;  -- 13개
SELECT count(*) FROM userTbl, buyTbl; -- 11*13 = 143개 
-- INNER JOIN - 일반적으로 가장 많이 사용되는 형태
-- 기준 테이블과 조인 테이블 모두 데이터가 존재해야 조회됨
SELECT count(*) FROM userTbl INNER JOIN buyTbl; -- 특별한 조건이 없으면 크로스조인과 같음
SELECT count(*) FROM userTbl JOIN buyTbl; -- 143 개

SELECT * FROM userTbl AS U , buyTbl AS B
WHERE U.userID = B.userID;

-- outer join
-- left/right join
-- 기준 테이블에만 데이터가 존재하면 조회됨
-- 일치하지 않는 값이라도 남아있는 기준 테이블의 값을 검색
SELECT * FROM userTbl AS U LEFT JOIN buyTbl as B
on U.userID = B.userID ORDER BY B.num;

use smartWeb;
SELECT e1.ename AS 사원명 , e2.ename AS 매니저
FROM emp AS e1 INNER JOIN emp AS e2
ON e1.mgr = e2.empno;

SELECT count(*) FROM emp;
SELECT ename, mgr FROM emp;
# 매니저가 없는 사람도 포함해서 출력
SELECT e1.ename , e2.ename FROM
emp e1 LEFT join emp e2
ON e1.mgr = e2.empno;
-- 매니저가 아닌 사람도 출력
SELECT e1.ename , e2.ename FROM
emp e1 RIGHT join emp e2
ON e1.mgr = e2.empno;

use sqlDB;
-- '전자' 그룹 물품을 구매한 사용자의
-- 이름, 출생년도, 전화번호, 상품 그룹이름, 상품 이름 검색
SELECT userTbl.name,
		userTbl.birthYear,
        userTbl.mobile1,
        buyTbl.Groupname
        , buyTbl.prodname
FROM userTbl INNER JOIN buyTbl
ON userTbl.userID=buyTbl.userID
WHERE buyTbl.Groupname = '전자';

-- NATURL 변경
SELECT userTbl.name,
		userTbl.birthYear,
        userTbl.mobile1,
        buyTbl.Groupname
        , buyTbl.prodname
FROM userTbl NATURAL JOIN buyTbl
WHERE buyTbl.Groupname = '전자';

-- '전자' 그룹 물품을 구매한 사용자의 
-- 이름, 출생년도, 전화번호, 상품그룹이름, 상품이름 검색

SELECT 
	u.name, 
    u.birthYear, 
    concat(u.mobile1,u.mobile2) AS 전화번호,
    b.groupName,
    b.prodName
FROM userTbl AS u JOIN buyTbl AS b 
ON u.userID = b.userID 
AND b.groupName = '전자';

-- 위의 내용을 NATURAL JOIN 으로 변경
SELECT 
	u.name, 
    u.birthYear, 
    concat(u.mobile1,u.mobile2) AS 전화번호,
    b.groupName,
    b.prodName
FROM userTbl AS u NATURAL JOIN buyTbl AS b
WHERE b.groupName = '전자';

/*****************************************************/
-- VIEW 활용하여 검색 결과에 대한 
-- 데이터를 결합하는 
-- UNION
-- 연결된 SELECT문의 결과 값을 합집합으로 묶어줌
-- 결과값의 중복은 제거
use smartWeb;

(SELECT empno, ename, sal, deptno FROM emp 
WHERE deptno = 20
UNION
SELECT empno, ename, sal, deptno FROM emp 
WHERE deptno = 10) ORDER BY deptno;

CREATE VIEW temp_view 
AS SELECT empno, ename, sal, deptno FROM emp;
-- WHERE deptno = 10 OR deptno = 20;

SELECT * FROM temp_view WHERE deptno = 20 
OR deptno = 10
UNION ALL
SELECT * FROM temp_view WHERE deptno = 10;

-- emp table과 salgrade table 을 join하여
-- 각 사원의 급여 등급을 사원명, 급여, 급여등급 으로출력
SELECT e.ename, e.sal, s.grade
FROM emp e, salgrade s
WHERE  e.sal BETWEEN s.losal AND s.hisal;
-- 인라인 뷰를 이용하여
-- 부서별 평균 급여가 2500 이상인 부서의
-- 부서 번호, 평균 급여를 출력
SELECT * FROM
    (SELECT deptno, avg(sal) AS '급여평균' 
	FROM emp
	GROUP BY deptno) tmp
WHERE 급여평균 >= 2500;

-- 부서별 평균 급여와 급여 등급을 출력 - 인라인 뷰 이용
SELECT deptno, avgSal, grade
FROM
    (SELECT avg(sal) AS avgSal,deptno
	FROM emp
	GROUP BY deptno) tmp, salgrade s
WHERE avgSal BETWEEN s.losal AND s.hisal;

-- 부서별 평균 급여와 급여 등급을 출력 - 인라인 뷰 이용
-- 부서이름, 평균급여, 급여등급 형식으로 출력
SELECT d.dname, avgSal, grade
FROM
    (SELECT avg(sal) AS avgSal,deptno
	FROM emp
	GROUP BY deptno) e, salgrade s, dept d
WHERE avgSal BETWEEN s.losal AND s.hisal 
AND d.deptno = e.deptno;


-- 급여등급별 인원수와, 평균 급여 출력 # 검색된 행의갯수= 인원수
-- 급여등급, 인원수, 평균급여
SELECT s.grade, count(*), avg(sal)
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal
GROUP BY s.grade;


/***********************************************************************************************/
-- INDEX - 색인 , 목록
-- Data 를 찾긱 위한 데이터
-- 책의 목차에 비유
-- 특정 테이블의 특정 컬럼(열)을 지정하여 인덱스를 생성
-- 지정한 인덱스를 이용하여 데이터를 검색
-- 목적은 빠른 데이터 검색
-- 기본키(PRIMARY KEY)를 지정한 컬럼에 대해서는
-- 자동으로 INDEX가 생성:생성된 기본키를 기준으로 순서대로 정렬
-- 나머지 컬럼(열)이 검색 조건이 된다면
-- 직접 인데스를 생셩해서 사용


-- CREATE INDEX 인덱스 이름 ON 테이블이름(컬럼이름);
-- ALTER TABLE 테이블 이름 ADD INDEX 인덱스 이름(컬럼이름)
-- emp 테이블의 sal열에 isx_emp_sal 이름의 인덱스 부여
ALTER TABLE emp ADD INDEX idx_emp_sal(sal);
CREATE INDEX inx_emp_sal ON emp(sal);

-- emp 테이블에 적용된 인덱스 정보 확인
SHOW INDEXES FROM emp;
-- 인덱스 삭제
-- DROP INDEX 인덱스 이름 ON table이름.column이름;
-- ALTER TABLE 테이블 이름 DROP INDEX 인덱스 이름;
ALTER TABLE emp DROP INDEX idx_emp_sal;
DROP INDEX inx_emp_sal ON smartWeb.emp;

use employees;
SHOW tables;
SELECT count(*) FROM employees;
DESC employees;

SELECT * FROM employees 
WHERE gender = 'M';
CREATE INDEX idx_emp_gender ON employees(gender);
DROP INDEX idx_emp_gender ON employees.employees;
SHOW INDEXES FROM employees;

-- 인덱스는 몯든 컬럼에 생성하는것이 좋지 않음.
-- 저장 공간 차지
-- 인덱스가 생성된 컬럼에 데이터의 삽입/삭제/수정이 일어나면
-- 인덱스 페이지를 새로 생성해야 할 수 있어서 성능에 악영향
-- 검색에 자주 사용되는 컬럼에만 생성
-- 데이터 변경이 자주 일어나지 않는 테이블에 생성
-- 검색쿼리에 인덱스는 영향을 받는다.

/************************************************************************/
-- 스토어 프로시져(Stored procedure)
-- 여러 개의 쿼리 혹은 동작을 프로시저라는 개체로 묶어서 저장
-- 프로시저 이름을 통해서 작동시키므로 내부의 쿼리를 숨길 수 있음
-- 작성된 프로시저는 CALL 이라는 예약어를 활용해서 사용(호출)
/*
	CREATE PROCEDURE 프로시저 이름(매개변수....)
		BEGIN
			내용
		END
*/

# DELIMITER : 구문 문자
-- 일반 프로그램의 ';' 역할을 한다.
-- 범위를 지정하는 함수
use smartWeb;


DELIMITER // 
CREATE PROCEDURE readEmp()
	BEGIN 
		SELECT * FROM EMP;
	END //
DELIMITER ; 

CALL readEmp();

-- 매개변수를 전달하는 프로시저
-- 특정 사원번호를 매개변수로 받아서 해당 사원의 정보를 검색
-- 매개변수 선언 형식 : 'IN 매개변수명 데이터 형식'
DELIMITER $$ 
CREATE PROCEDURE info_emp(IN _empno INT)
	BEGIN 
		SELECT * FROM emp WHERE empno = _empno;
    END $$
DELIMITER ;

-- 입력값 이상의 급여를 받는 사원의 사원번호, 이름, 입사일 ,급여
-- 를 검색하는 프로시저
DELIMITER $$ 
CREATE PROCEDURE `info_sal_over` (IN _sal INT)
BEGIN
	SELECT empno, ename, hiredate, sal 
    FROM emp 
    WHERE sal >= _sal;
    END $$
DELIMITER ;

CALL info_sal_over(1500);

-- 여러개의 매개변수를 전달받는 프로시저
-- 두개의 급여를 전달받아 두 급여사이의 급여를 받는 사원 정보
-- 검색
delimiter //
CREATE PROCEDURE info_sal_between(
	IN a_sal INT ,
    IN b_sal INT
)
BEGIN 
	SELECT * FROM emp 
    WHERE sal BETWEEN a_sal AND b_sal;
END //
delimiter ;

CALL info_sal_between(2000,3000);

use sqlDB;
-- 회원 이름을 입력받아서 
-- 회원의 나이에 따라 1980년 이전이다 나이가 많으시네요.
-- 1980년 이후 출색 아직 젊으시네요
DELIMITER //
CREATE PROCEDURE checkYear(
	IN uname VARCHAR(10)
)
BEGIN 
	DECLARE yearBirth INT; -- yearBirth 변수 선언
    SELECT birthYear INTO yearBirth FROM userTbl 
    WHERE name = uname;
    IF (yearBirth >= 1980) THEN
		SELECT '아직 젊으시네요.. ' AS ANSWER;
    ELSE 
		SELECT '나이가 지긋하시네요' AS ANSWER;
    END IF;  
END //
DELIMITER ;

CALL checkYear('이승기');
















CALL info_emp(7369);


