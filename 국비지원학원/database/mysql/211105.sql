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
-- BATURL 변경
SELECT userTbl.name,
		userTbl.birthYear,
        userTbl.mobile1,
        buyTbl.Groupname
        , buyTbl.prodname
FROM userTbl NATURAL JOIN buyTbl
WHERE buyTbl.Groupname = '전자';

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



