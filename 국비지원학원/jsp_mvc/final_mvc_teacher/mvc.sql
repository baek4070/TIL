
DROP TABLE mvc_member;

CREATE TABLE mvc_member(
	num INT primary key auto_increment,		--회원번호
	id VARCHAR(50) UNIQUE NOT NULL,			--아이디(email)
	pass VARCHAR(100) NOT NULL,				--비밀번호
	name VARCHAR(50) ,						--이름
	age INT(3) default 1,					--나이
	gender VARCHAR(10) ,					--성별
	joinYN char(1) default 'Y',				--탈퇴여부
	regdate TIMESTAMP default now(),		--회원가입일
	updatedate TIMESTAMP default now()		--회원정보수정일
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








