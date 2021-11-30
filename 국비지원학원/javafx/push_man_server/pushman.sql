DROP TABLE IF EXISTS push_man_member;

CREATE TABLE IF NOT EXISTS push_man_member(
	memberNum int(11) PRIMARY KEY AUTO_INCREMENT,
	memberName VARCHAR(50) DEFAULT null,
	memberId VARCHAR(100) UNIQUE NOT NULL,
	memberPw VARCHAR(100) NOT NULL,
	regdate BIGINT DEFAULT 0
);

DESC push_man_member;
commit;
SELECT * FROM push_man_member;