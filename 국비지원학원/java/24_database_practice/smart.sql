use smart;

DROP TABLE IF EXISTS tbl_account;

CREATE TABLE IF NOT EXISTS tbl_account(
	ano VARCHAR(30) NOT NULL UNIQUE,
    owner VARCHAR(20) NOT NULL,
    balance INT default 0,
    password VARCHAR(50) NOT NULL 
);

INSERT INTO tbl_account
VALUES('111-111','최기근',20000000,'12345');

SELECT * FROM tbl_account;
commit;

-- ano , password 를 넘겨받아서 일치하는 
-- 계정 정보를 반환하는 procedure

DELIMITER $$
CREATE PROCEDURE find_account(
	IN _ano VARCHAR(30),
    IN _pass VARCHAR(50)
)
BEGIN
	SELECT * FROM tbl_account 
    WHERE ano = _ano AND password = _pass;
END $$
DELIMITER ;

CALL find_account('222-222','12345');

-- PROCEDURE 추가
DELIMITER $$
CREATE PROCEDURE insert_member(
	IN _name VARCHAR(30),
    IN _id VARCHAR(100),
    IN _pw VARCHAR(100),
    IN _reg BIGINT
)
BEGIN
	INSERT INTO tbl_member VALUES(null, _name, _id, _pw, _reg);
    SELECT * FROM tbl_member WHERE mNum = LAST_INSERT_ID();
END $$
DELIMITER ;
commit;
CALL insert_member('김재관','idkjg','pwkjg',0);

SELECT * FROM tbl_member;

-- 탈퇴한 회원의 정보를 임시 저장할 back_up table 생성
CREATE TABLE back_up_member LIKE tbl_member;
SELECT * FROM back_up_member;
DESC back_up_member;
-- back_up_member table에 column 추가
-- 회원 탈퇴 일 정보 column
ALTER TABLE back_up_member 
ADD COLUMN deleteDate TIMESTAMP default now();

commit;
SELECT * FROM back_up_member;
SELECT * FROM tbl_member;

-- tbl_member table의 행정보가 delete 된 후
-- back_up_member table에 삭제된 회원의 정보 저장.
commit;

DELIMITER $$
CREATE TRIGGER delete_member
	AFTER DELETE ON tbl_member FOR EACH ROW 
BEGIN
	INSERT INTO back_up_member 
    VALUES(OLD.mNum,OLD.mName,OLD.mId,OLD.mPw,OLD.reg,now());
END $$
DELIMITER ;
drop trigger delete_member;

DELETE FROM tbl_member WHERE mNum = 5;
DELETE FROM back_up_member WHERE mNum = 5;
SELECT * FROM tbl_member;
SELECT * FROM back_up_member; 
rollback;
