show tables;

CREATE TABLE IF NOT EXISTS test_guestbook(
	id INT PRIMARY KEY auto_increment, -- 방명록 글번호
	guestName VARCHAR(20) NOT NULL,    -- 방명록 작성자
	password VARCHAR(30) NOT NULL,     -- 방명록 비밀번호
	message TEXT					   -- 방명록 작성
);

DESC test_guestbook;

SELECT * FROM test_guestbook;

PREPARE sql1 FROM
'DELETE FROM test_guestbook WHERE id = ? AND password = ?';
SET @id = 2;
SET @pass = ' ORD 1=1 --';
EXECUTE sql1 USING @id, @pass;