-- test table 생성 - spring
CREATE TABLE IF NOT EXISTS tbl_member(
	userid VARCHAR(50),
    userpw VARCHAR(45),
    username VARCHAR(45),
    regdate TIMESTAMP,
    updatedate TIMESTAMP
);
DESC tbl_member;
SELECT * FROM tbl_member;



