CREATE DATABASE IF NOT EXISTS smart_web_test;
use smart_web_test;
CREATE TABLE student(
	stu_no INT(11) PRIMARY KEY,
    stu_name VARCHAR(12),
    stu_dept VARCHAR(20),
    stu_grade INT(1),
    stu_class CHAR(1),
    stu_gender CHAR(1),
    stu_height FLOAT(5,2),
    stu_weight FLOAT(5,2)
);

CREATE TABLE enrol(
	sub_no CHAR(3),
    stu_no INT(9),
    enr_grade INT(3)
);

CREATE TABLE subject(
	sub_no CHAR(3) PRIMARY KEY,
    sub_name VARCHAR(30),
    sub_prof VARCHAR(12),
    sub_grade INT(1),
    sub_dept VARCHAR(20)
);

ALTER TABLE enrol ADD CONSTRAINT FOREIGN KEY(stu_no)
REFERENCES student(stu_no);
ALTER TABLE enrol ADD CONSTRAINT FOREIGN KEY(sub_no)
REFERENCES subject(sub_no);
-- student table data
INSERT INTO student VALUES(20143054, '유가인', '기계', 2, 'C', 'F', 154.00, 47.00);
INSERT INTO student VALUES(20153075, '옥한빛', '기계', 1, 'C', 'M', 177.00, 80.00);
INSERT INTO student VALUES(20153088, '이태연', '기계', 1, 'C', 'F', 162.00, 50.00);
INSERT INTO student VALUES(20132003, '박희철', '전기전자', 3, 'B', 'M', null, 63.00);
INSERT INTO student VALUES(20142021, '심수정', '전기전자', 2, 'A', 'F', 168.00, 45.00);
INSERT INTO student VALUES(20152088, '조민우', '전기전자', 1, 'C', 'M', 188.00, 90.00);
INSERT INTO student VALUES(20131001, '김종헌', '컴퓨터정보', 3, 'C', 'M', null, 72.00);
INSERT INTO student VALUES(20131025, '옥성우', '컴퓨터정보', 3, 'A', 'F', 172.00, 63.00);
INSERT INTO student VALUES(20141007, '진현무', '컴퓨터정보', 2, 'A', 'M', 174.00, 64.00);
INSERT INTO student VALUES(20151062, '김인중', '컴퓨터정보', 1, 'B', 'M', 166.00, 67.00);

-- subject table sample data
INSERT INTO subject VALUES('111', '데이터베이스','이재영',2,'컴퓨터정보');
INSERT INTO subject VALUES('110', '자동제어','정순정',2,'전기전자');
INSERT INTO subject VALUES('109', '자동화설계','박민영',3,'기계');
INSERT INTO subject VALUES('101', '컴퓨터개론','강종영',3,'컴퓨터정보');
INSERT INTO subject VALUES('102', '기계공작법','김태영',1,'기계');
INSERT INTO subject VALUES('103', '기초전자실험','김유석',1,'전기전자');
INSERT INTO subject VALUES('104', '시스템분석설계','강석현',3,'컴퓨터정보');
INSERT INTO subject VALUES('105', '기계요소설계','김명성',1,'기계');
INSERT INTO subject VALUES('106', '전자회로실험','최영민',3,'전기전자');
INSERT INTO subject VALUES('107', 'CAD응용실습','구봉규',2,'기계');
INSERT INTO subject VALUES('108', '소프트웨어공학','권민성',1,'컴퓨터정보');

-- enrol sample data
insert into enrol values('101',20131001,80);
insert into enrol values('104',20131001,56);
insert into enrol values('106',20132003,72);
insert into enrol values('103',20152088,45);
insert into enrol values('101',20131025,65);
insert into enrol values('104',20131025,65);
insert into enrol values('108',20151062,81);
insert into enrol values('107',20143054,41);
insert into enrol values('102',20153075,66);
insert into enrol values('105',20153075,56);
insert into enrol values('102',20153088,61);
insert into enrol values('105',20153088,78);

UPDATE student
SET stu_height = 180
WHERE stu_name = '박희철';

UPDATE student
SET stu_height = 173
WHERE stu_name = '김종헌';

DELETE 
FROM student 
WHERE stu_no=20142021;

commit;

SET foreign_key_checks = 0;
DELETE FROM student;

SELECT *
FROM student;

ROLLBACK;

SELECT *
FROM student;

USE smart_web_test;
SHOW TABLES;

USE smart_web_test;
DESC student;
DESC subject;
DESC enrol;

CREATE INDEX index_stu_name ON student(stu_name);
SHOW INDEXES FROM student;

CREATE TABLE t_student(
	SELECT * FROM student
    WHERE stu_dept = '기계'
);

SELECT * FROM t_student;

SELECT * FROM enrol;

SELECT student.stu_no, student.stu_name, enrol.enr_grade
FROM student INNER JOIN enrol
ON student.stu_no=enrol.stu_no;


/*************************************************************************************************/


DROP TABLE IF EXISTS dept;

CREATE TABLE IF NOT EXISTS dept(
deptno int(2) primary key,		-- 부서 코드
dname varchar(20) not null,		-- 부서 이름
loc varchar(20)					-- 부서 지역
);				

DROP TABLE IF EXISTS emp;

CREATE TABLE IF NOT EXISTS emp(
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


DELIMITER // 
CREATE PROCEDURE test1_1()
	BEGIN 
		SELECT EMP.empno, EMP.ename ,DEPT.dname 
        FROM EMP NATURAL JOIN DEPT
        WHERE EMP.sal >= 2000
        ORDER BY dname;
	END //
DELIMITER ; 

call test1_1();

DELIMITER // 
CREATE PROCEDURE test1_2(IN _empno INT, IN _deptno INT)
	BEGIN 
		UPDATE emp
		SET deptno = _deptno
		WHERE empno = _empno;
	END //
DELIMITER ; 

SELECT * FROM emp WHERE empno=7369;

call test1_2(7369,10);
SELECT * FROM emp WHERE empno=7369;

CREATE TABLE back_up_emp like emp;
SELECT* FROM back_up_emp;

delimiter //
	CREATE TRIGGER backup_trg
		AFTER DELETE 
        ON emp
        FOR EACH ROW 
	BEGIN 
		INSERT INTO back_up_emp(empno, ename, job, mgr, hiredate, sal ,comm ,deptno) 
        VALUES(Old.empno, Old.ename, Old.job, Old.mgr, Old.hiredate, Old.sal, Old.comm, Old.deptno);
    END //
delimiter ;

DELETE FROM emp WHERE empno = 7369;
SELECT* FROM back_up_emp;
SELECT * FROM emp;

use smart_web_test;

SELECT deptno, count(*) AS '부서별 인원'
FROM emp
GROUP BY deptno WITH ROLLUP ;


use mysql;

CREATE USER 'testUser'@'localhost' IDENTIFIED BY '12345';

SELECT * FROM mysql.user
WHERE user='testUser';


GRANT SELECT, INSERT, UPDATE,DELETE ON smart_web_test.* to testUser@localhost;

SHOW GRANTS FOR testUser@'localhost';


