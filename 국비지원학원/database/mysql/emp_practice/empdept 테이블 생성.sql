-- smartWeb database 생성
-- smartWeb database 에 table 생성 및 샘플데이터 추가

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