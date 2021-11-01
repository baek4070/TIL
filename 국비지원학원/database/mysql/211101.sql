-- ctrl + enter
show databases;#스키마나 데이터베이스나 같은이름
show tables;
use world;
use sqldb;
CREATE TABLE `sqldb`.`member_tbl` (
  `member_id` varchar(50) NOT NULL,
  `member_name` varchar(45) DEFAULT NULL,
  `member_addr` varchar(45) DEFAULT NULL
);

CREATE TABLE product_tbl(
	product_name VARCHAR(50),
    cost INT,
    make_date VARCHAR(20),
    amount INT NULL
);

show tables;
-- merber_tbl의 모든 정보 검색
SELECT*FROM member_tbl;
-- product_tbl의 모든 정보 검색
SELECT*FROM product_tbl;

DROP database sqlDB;

use employees;
# 테이블의 구조 확인
DESCRIBE titles;


# database 생성
CREATE DATABASE testDB;
# 동일
# CREATE SCHEMA testDB;

# database 삭제
DROP DATABASE testDB;

# teatDB가 존재 하면 삭제
DROP DATABASE IF EXISTS testDB;
# 이러면 오류를 발생안시키고 삭제가능 ~ 

# testDB database 가 존재하지 않으면 생성
CREATE DATABASE IF NOT EXISTS testDB;

USE testDB;

show tables;

show table status; ## 테이블이 언제만들어진건지 등등

#table 생성
CREATE TABLE IF NOT EXISTS userTbl(
	userID char(8) NOT NULL PRIMARY KEY,# 무조건 값이 존재해야하고 중복이 되선 안된다 구분자가 된다
    name VARCHAR(10) NOT NULL,#char은 무조건8자 VARCHAR은 최대10자 제한두는것
    birthyear INT NOT NULL,
    addr char(2) NOT NULL,
    mobile1 char(3),
    mobile2 char(8),
    height smallint,#작은 실수
    mDate date # 년월일
);
# DESC
DESCRIBE usertbl; # 어떤 데이터가 들어갈수있는지에대한 정보를 확인

# prodTbl table 생성
CREATE TABLE IF NOT EXISTS prodTbl(
	num INT(8) NOT NULL PRIMARY KEY, # 갯수의 제한이 있으면 나중에 문제가 있을수있다는 경고가 발생
    userID char(8) NOT NULL,
    prodName char(6) NOT NULL,
    groupName char(4) NOT NULL,
    price char(5),
    count smallint NOT NULL
);

show tables;

USE testDB;



insert into usertbl values('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
insert into usertbl values('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
insert into usertbl values('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');
insert into usertbl values('JYP', '조용필', 1950, '경기', '011', '4444444', 166, '2009-4-4');
insert into usertbl values('SSK', '성시경', 1979, '서울', NULL, null, 186, '2013-12-12');
insert into usertbl values('LJB', '임재범', 1963, '서울','016', '6666666', 182, '2009-9-9');
insert into usertbl values('YJS', '윤종신', 1969, '경남', null, null, 170, '2005-5-5');
insert into usertbl values('EJW', '은지원', 1972, '경북', '011', '8888888', 174, '2014-3-3');
insert into usertbl values('JKW', '조관우', 1965, '경기', '018', '9999999', 172, '2010-10-10');
insert into usertbl values('BBK', '바비킴', 1973, '서울', '010', '0000000', 176, '2013-5-5');


# testDB의 테이블 중에 prodTbl 정보를 수정
# 정의된 정보를 수정하는 keyword -ALTER
# porodTbl의 이름을 byyTbl로 변경
ALTER TABLE prodTbl rename buyTbl;

show tables;
# buyTbl 있는 price 속성에 dataType을 INT로 변경
ALTER TABLE buyTbl MODIFY price int;

#변경 확인 
DESC buyTbl;
# buyTbl의 num 속성을 INT AUTO_INCREMENT 기능 추가
# 1부터 시작해서 자동으로 1씩증가해주는 속성 
ALTER TABLE buyTbl modify num INT AUTO_INCREMENT; # 이건 MySQL 에만 있는 기능입니다

# buyTbl count열 이름을 amount로 변경
ALTER TABLE buyTbl CHANGE count amount smallint NOT NUll;
# 또는
ALTER TABLE buyTbl CHANGE count amount smallint;
ALTER TABLE buyTbl MODIFY amount smallint NOT NULL;

# buyTbl price 속성이 null 을 허용 안되게 변경alter
ALTER TABLE buyTbl MODIFY price INT NOT NULL;

DESC buyTbl;

# buyTbl의 userID에 외래키 지정
ALTER TABLE buyTbl ADD CONSTRAINT FOREIGN KEY(userID) # 테이블에서 참조 무결성을 제어해주는게 외부 키 이다 ! 
REFERENCES userTbl(userID); # 다른 테이블을 참조 할때는 해당 필드가 무조건 존재해야 한다 그걸 참조 무결성이라고 한다

DESC buyTbl;

insert into buytbl values(null, 'KBS', '운동화', '의류', 30, 2);
insert into buytbl values(null, 'KBS', '노트북', '전자', 1000, 1);
insert into buytbl values(null, 'JYP', '모니터', '전자', 200, 1);
insert into buytbl values(null, 'BBK', '모니터', '전자', 200, 5);
insert into buytbl values(null, 'KBS', '청바지', '의류', 50, 3);
insert into buytbl values(null, 'BBK', '메모리', '전자', 80, 10);
insert into buytbl values(null, 'SSK', '책', '서적', 15, 5);
insert into buytbl values(null, 'EJW', '책', '서적', 15, 2);
insert into buytbl values(null, 'EJW', '청바지', '의류', 50, 1);
insert into buytbl values(null, 'BBK', '운동화', '의류', 30, 2);
insert into buytbl values(null, 'EJW', '책', '서적', 15, 1);
insert into buytbl values(null, 'BBK', '운동화', '의류', 30, 2);
# insert into buytbl values(null, 'CGK', '운동화', '의류', 30, 2); # 안되는거 확인 이게 참조 무결성이다

#usertbl table 에서 사용자 이름과 가입일만 나오게 검색
SELECT name, mdate FROM usertbl;

# buyTbl 에서 userID를 사용자로 , prodName을 상품명으로 검색
# SQL 질의에서 문자열은 모두 ' ' 홑따옴표로 표기
SELECT userID AS '사용자', prodName '상품명' FROM buyTbl; 
#별칭으로 as로 사용자 별칭을 달아줌 , 상품명은 as가 없어도 '' 문자여를 자동인식해서 as 생략가능

# employees db안에 titles table 정보 검색 / 밖에서 검색할때
SELECT * FROM employees.titles;

use employees;
DESC employees;
DESC titles;
SELECT first_name FROM employees;
SELECT gender, first_name, emp_no FROM employees;
SELECT gender '성별' , first_name '이름', hire_date '입사일' FROM employees;

