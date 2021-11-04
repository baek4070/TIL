DROP DATABASE  IF EXISTS smartweb;
CREATE DATABASE IF NOT EXISTS smartWeb;


use smartWeb;
create table dept(
deptno int(2) primary key,		-- 부서 코드
dname varchar(20) not null,		-- 부서 이름
loc varchar(20)					-- 부서 지역
);				

create table emp(
empno int(4) primary key,		-- 사원번호
ename varchar(10) not null,		-- 사원명
job varchar(20) not null,		-- 직무
mgr int(4),						-- 자신의 매니저
hiredate date,					-- 입사일
sal int(8),						-- 급여
comm int(8),					-- 커미션(추가수당)
deptno int(2),					-- 근무 부서번호
FOREIGN KEY fk_dept(deptno) REFERENCES dept(deptno));



insert into dept values(10, 'ACCOUNTING', 'NEW YORK');
insert into dept values(20, 'RESEARCH', 'DALLAS');
insert into dept values(30, 'SALES', 'CHICAGO');
insert into dept values(40, 'OPERATING', 'BOSTON');


insert into emp values(7369, 'SMITH', 'CLERK', 7902, '1980/12/17', 800, null, 20);
insert into emp values(7499, 'ALLEN', 'SALESMAN', 7698, '1981/02/20', 1600, 300, 30);
insert into emp values(7521, 'WARD', 'SALESMAN', 7698, '1981/02/22', 1250, 500, 30);
insert into emp values(7566, 'JONES', 'MANAGER', 7839, '1981/04/02', 2975, null, 20);
insert into emp values(7654, 'MARTIN', 'SALESMAN', 7698, '1981/09/28', 1250, 1400, 30);
insert into emp values(7698, 'BLAKE', 'MANAGER', 7839, '1981/05/01', 2850, null, 30);
insert into emp values(7788, 'SCOTT', 'ANALYST', 7566, '1987/04/19', 3000, null, 20);
insert into emp values(7839, 'KING', 'PRESIDENT', null, '1981/11/17', 5000, null, 10);
insert into emp values(7844, 'TURNER', 'SALESMAN', 7698, '1981/09/08', 1500, 0, 30);
insert into emp values(7876, 'ADAMS', 'CLERK', 7788, '1987/05/23', 1100, null, 20);
insert into emp values(7900, 'JAMES', 'CLERK', 7698, '1981/12/03', 950, null, 30);
insert into emp values(7902, 'FORD', 'ANALYST', 7566, '1981/12/03', 3000, null, 20);
insert into emp values(7934, 'MILLER', 'CLERK', 7782, '1982/01/23', 1300, null, 10);
insert into emp values(7782, 'CLARK', 'MANAGER', 7839, '1981/06/09', 2450, null, 10);

commit;

-- smartWeb 계정 생성 비밀번호 '12345'
-- smartWeb을 사용 할 수 있는 모든 권한 부여
use smartWeb;
show tables;
desc dept;
desc emp;


-- 1. 급여가 1500 이하인 사원의 사원번호, 사원명, 급여 출력
SELECT empno AS '사원번호', ename '사원명', sal '급여'
FROM emp
WHERE sal <= 1500;


-- 2. SCOTT 사원의 사원번호, 사원명, 급여 출력
SELECT empno AS '사원번호', ename '사원명', sal '급여'
FROM emp
WHERE ename = 'SCOTT';


-- 3. 10번 부서 소속의 사원들 중 직급이 MANAGER인 사람을
-- 검색해서 사원명, 부서번호, 직급을 출력
-- = 10번 부서이면서 직급이 MANAGER
SELECT ename '사원명', deptno '부서번호', job '직급'
FROM emp
WHERE deptno=10 AND job = 'MANAGER';


-- 4. 10번 부서가 아닌 사원의 사원명, 부서번호, 직급 출력
SELECT ename '사원명', deptno '부서번호', job '직급'
FROM emp
WHERE NOT deptno=10;


-- 5. 급여가 2000에서 3000 사이 사원의 사원명, 부서번호, 급여 출력
SELECT ename '사원명', deptno '부서번호', sal '급여'
FROM emp
WHERE sal BETWEEN 2000 AND 3000;


-- 6. 커미션이 300이거나 500이거나 1400인 사원의
-- 사원번호, 사원명, 급여, 커미션 출력
SELECT empno AS '사원번호', ename '사원명', sal '급여',comm '커미션'
FROM emp
WHERE comm IN(300, 500, 1400);


-- 7. 입사일이 1987년 1월 1일에서 1987년 12월 31일 사이인
-- 사원의 사원번호, 사원명, 급여, 입사일 출력
SELECT empno AS '사원번호', ename '사원명', sal '급여',hiredate '입사일'
FROM emp
WHERE hiredate BETWEEN '1987-01-01' AND '1987-12-31';


-- 8. 이름이 F로 시작하는 사원의 사원번호, 사원명 출력
SELECT empno AS '사원번호', ename '사원명'
FROM emp
WHERE ename LIKE 'F%';


-- 9. 이름에 A가 들어가는 사원의 사원번호, 사원명 출력
SELECT empno AS '사원번호', ename '사원명'
FROM emp
WHERE ename LIKE '%A%';


-- 10. 이름에 3번째 자리가 R인 사원의 사원번호, 사원명 출력
SELECT empno AS '사원번호', ename '사원명'
FROM emp
WHERE ename LIKE '__R%';


-- 11. 커미션이 null 인 사원의 사원번호, 사원명, 커미션 출력
SELECT empno AS '사원번호', ename '사원명', comm '커미션'
FROM emp
WHERE comm is null;


-- 12. 급여를 많이 받는 순서대로 출력하고, 급여가 같은 사람의 경우
-- 이름이 빠른 순서대로 나오도록 사원번호, 사원명, 급여 출력
SELECT empno AS '사원번호', ename '사원명', sal '급여'
FROM emp
ORDER BY sal DESC, ename DESC;


-- 13. SCOTT과 같은 부서에서 근무하는 사원의 이름과 부서번호 출력
SELECT ename '사원명', deptno '부서번호'
FROM emp
WHERE deptno = (
	SELECT deptno 
    FROM emp
    WHERE ename = 'SCOTT'
);


-- 14. SCOTT과 동일한 직급을 가진 사원의 정보 출력
SELECT*
FROM emp
WHERE job = (
	SELECT job 
    FROM emp
    WHERE ename = 'SCOTT'
);


-- 15. SCOTT이 소속된 부서의 부서명 출력
SELECT dname
FROM dept
WHERE deptno = (
	SELECT deptno 
    FROM emp
    WHERE ename = 'SCOTT'
);


-- 16. DALLAS에서 근무하는 사원의 이름, 부서번호 출력
SELECT ename '이름', deptno '부서번호'
FROM emp
WHERE deptno = (
	SELECT deptno
    FROM dept
    WHERE loc = 'DALLAS'
);


-- 17. 자신의 매니저가 KING인 사원의 이름과 급여 출력
SELECT ename '사원명', sal '급여'
FROM emp
WHERE mgr = (
	SELECT empno
    FROM emp
    WHERE ename = 'KING'
);


-- 18. 급여를 3000 이상 받는 사원이 소속된 부서 사원의 
-- 부서번호, 사원명, 급여 출력
SELECT deptno '부서번호', ename '사원명', sal '급여'
FROM emp
WHERE deptno = ANY(
	SELECT deptno
    FROM emp
    WHERE sal >= 3000 
);


-- 19. 30번 부서 사원들 중 급여를 가장 많이 받는 사원보다
-- 더 많은 급여를 받는 사원의 이름과 급여를 출력
SELECT ename '사원명', sal '급여'
FROM emp
WHERE sal > (
	SELECT MAX(sal)
    FROM emp
    WHERE deptno = 30
);


-- 20. 영업사원(SALESMAN)들의 최소 급여보다 많이 받는 사원들의
-- 이름과 급여, 직급을 출력하되, 영업사원은 제외
SELECT ename '사원명', sal '급여', job '직급'
FROM emp
WHERE NOT job= 'SALESMAN' AND sal > (
	SELECT MIN(sal)
    FROM emp
    WHERE job = 'SALESMAN'
);


-- 21. 가장 최근에 입사한 사원의 입사일과 가장 오래된 사원의 입사일
SELECT hiredate
FROM emp
WHERE hiredate IN(
	(SELECT MAX(hiredate) FROM emp),
    (SELECT MIN(hiredate) FROM emp)
);


-- 22. 부서별 평균급여를 부서번호, 평균급여 형태로 출력
SELECT deptno '부서번호',AVG(sal) '평균급여'
FROM emp
GROUP BY deptno;


-- 23. 부서의 최소 급여와 최대 급여를 구하고, 최대 급여가 2000 이상인
-- 부서만 출력
SELECT *
FROM dept
WHERE deptno = any(
	SELECT deptno
	FROM emp 
	GROUP BY deptno
    HAVING MAX(sal) >= 2000
);

SELECT MAX(sal)
FROM emp 
GROUP BY deptno;


-- 24. 사원들 평균 급여보다 더 많은 급여를 받는 사원의
-- 이름과 급여 출력
SELECT ename '이름', sal '급여'
FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp);


-- 25. 부서별 가장 급여가 많은 사원의 사원번호, 사원명, 급여, 부서번호
SELECT empno '사원번호',ename '사원명', sal '급여', deptno '부서번호'
FROM emp
WHERE sal IN(
	SELECT MAX(sal)
	FROM emp
    group by deptno
)
ORDER BY sal DESC;


