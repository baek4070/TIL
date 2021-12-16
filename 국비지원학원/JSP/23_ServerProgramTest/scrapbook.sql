
show tables;
DROP TABLE IF EXISTS test_guestbook;

CREATE TABLE test_guestbook(
	id INT PRIMARY KEY auto_increment,
	guestName VARCHAR(20) NOT NULL,
	password VARCHAR(30) NOT NULL,
	message TEXT
);

DESC test_guestbook;

SELECT @ROWNUM := @ROWNUM+1 AS rnum, A.* FROM 
(SELECT * FROM test_guestbook WHERE (@ROWNUM:=0)=0 
ORDER BY id ASC) AS A ORDER BY rnum DESC;

SELECT *FROM TEST_GUESTBOOK;
