
DROP TABLE mvc_member;

CREATE TABLE mvc_member(
	num INT primary key auto_increment,		
	id VARCHAR(50) UNIQUE NOT NULL,		
	pass VARCHAR(100) NOT NULL,				
	name VARCHAR(50) ,						
	age INT(3) default 1,					
	gender VARCHAR(10) ,					
	joinYN char(1) default 'Y',				
	regdate TIMESTAMP default now(),		
	updatedate TIMESTAMP default now()		
);

INSERT INTO mvc_member(id,pass,name,gender) 
VALUES('admin','admin','MASTER','male');

SELECT * FROM mvc_member;

UPDATE mvc_member SET joinYN = 'Y';
commit;

-- 비밀번호 찾기 code 저장 테이블
DROP TABLE test_code;
CREATE TABLE test_code(
	id VARCHAR(50),
	code char(5)
);

DESC test_code;

SELECT * FROM test_code;








