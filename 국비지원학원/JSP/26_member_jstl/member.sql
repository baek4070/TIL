DROP TABLE IF EXISTS smart_member;
CREATE TABLE IF NOT EXISTS smart_member(
	u_num INT primary key auto_increment,
	u_id VARCHAR(30) unique,
	u_pass VARCHAR(30) NOT NULL,
	u_age INT,
	u_gender VARCHAR(10),
	u_join char(1) default 'Y',
	u_regdate TIMESTAMP default now()
);

INSERT INTO smart_member(u_id,u_pass,u_age,u_gender)
VALUES('admin', 'admin' ,20, 'male');

SELECT * FROM smart_member;

SELECT * FROM smart_member
WHERE u_id != 'admin' AND u_join = 'Y'
ORDER BY u_num DESC