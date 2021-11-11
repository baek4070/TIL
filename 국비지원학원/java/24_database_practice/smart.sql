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
CREATE PROCEDURE insert_member()
BEGIN
END $$
DELIMITER ;
