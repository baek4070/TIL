CREATE TABLE test_member(
	num INT PRIMARY KEY auto_increment,
	id VARCHAR(30) UNIQUE NOT NULL,
	pass VARCHAR(100) NOT NULL,
	name VARCHAR(50),
	addr TEXT,
	phone VARCHAR(20),
	gender VARCHAR(10),
	age INT(3),
	regdate TIMESTAMP DEFAULT NOW()
);

INSERT INTO test_member
VALUES (
	null,'admin','admin',
	'MASTER' ,'부산광역시',
	'01094867166','남성', 26,now()
);

SELECT * FROM test_member;






