DROP TABLE IF EXISTS board_test;

CREATE TABLE IF NOT EXISTS board_test(
	board_num int PRIMARY KEY auto_increment,
	board_title VARCHAR(50),				
	board_auth VARCHAR(50),					 
	board_content TEXT,						  
	board_date TIMESTAMP DEFAULT now()		 
);

INSERT INTO board_test VALUES(null,'제목1','최기근','냉무',now());
INSERT INTO board_test VALUES(null,'제곧내','최기근','냉무',now());
commit;

SELECT * FROM board_test;

UPDATE board_test SET board_title ='제목2' WHERE board_num=2;
-- mysql 5.x 버전에서 rownum(행번호 구하기)
SELECT @ROWNUM := @ROWNUM+1 AS rnum, A.* FROM 
(SELECT * FROM board_test WHERE (@ROWNUM:=0)=0 
ORDER BY board_num ASC) AS A ORDER BY rnum DESC;

-- mysql 8.x 버전에서 추가 ROW_NUMBER()
SELECT ROW_NUMBER() OVER(ORDER BY board_num ASC) AS rnum,
board_test.* FROM board_test ORDER BY rnum DESC;

-- test 게시글 개수 증가
INSERT INTO board_test(board_title,board_auth,board_content) 
SELECT board_title,board_auth,board_content FROM board_test;

SELECT * FROM board_test ORDER BY board_num DESC;

SELECT * FROM board_test ORDER BY board_num DESC
limit 0, 10;
-- 0 ~ 9 
SELECT * FROM board_test ORDER BY board_num DESC
limit 10, 10;
-- 10 ~ 19
-- 전체 행의 개수
SELECT count(*) FROM board_test;


















