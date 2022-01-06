
DROP TABLE mvc_member;

CREATE TABLE mvc_member(
	num INT primary key auto_increment,	
	id VARCHAR(50) UNIQUE NOT NULL,		
	pass VARCHAR(100) NOT NULL,			
	name VARCHAR(50) ,						
	age INT(3) default 1,					
	gender VARCHAR(10) ,					
	joinYN char(1) default 'Y',				
	regdate TIMESTAMP default now(),	
	updatedate TIMESTAMP default now()		
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

-- 공지형 게시판 table
DROP TABLE notice_board;
CREATE TABLE notice_board(
	notice_num int primary key auto_increment, 
	notice_category VARCHAR(20) ,				
	notice_author VARCHAR(50),					
	notice_title VARCHAR(100),				
	notice_content LONGTEXT ,					
	notice_date TIMESTAMP default now() 		
);

SELECT * FROM notice_board ORDER BY notice_num DESC limit 1;

DELETE FROM notice_board WHERE notice_num = 2 OR notice_num = 3;
commit;

INSERT INTO notice_board(
notice_category,
notice_author,
notice_title,
notice_content)
SELECT notice_category,
notice_author,
notice_title,
notice_content FROM notice_board; 

SELECT * FROM notice_board 
WHERE notice_title LIKE '%게시글%' 
ORDER BY notice_num DESC limit 0, 10;

-- 질문과 답변 - 답변형 게시판
DROP TABLE qna_board;
CREATE TABLE qna_board(
	qna_num INT PRIMARY KEY auto_increment,
	qna_name VARCHAR(30) NOT NULL,
	qna_title VARCHAR(100) NOT NULL,
	qna_content LONGTEXT NOT NULL,
	qna_file VARCHAR(100),
	qna_file_origin VARCHAR(100),
	qna_re_ref INT NOT NULL,
	qna_re_lev INT NOT NULL,
	qna_re_seq INT NOT NULL,
	qna_writer_num INT,
	qna_readcount INT DEFAULT 0,
	qna_date TIMESTAMP DEFAULT now(),
	FOREIGN KEY(qna_writer_num) REFERENCES mvc_member(num)
);

ALTER TABLE qna_board 
ADD qna_delete char(1) DEFAULT 'N' AFTER qna_readcount;

DESC qna_board;
SELECT * FROM qna_board;

-- 게시글에 대한 댓글을 저장할 테이블
DROP TABLE qna_comment;
CREATE TABLE qna_comment(
	comment_num INT auto_increment,
	comment_id VARCHAR(50),
	comment_name VARCHAR(50),
	comment_content VARCHAR(300),
	comment_date TIMESTAMP DEFAULT now(),
	comment_delete char(1),
	comment_board_num INT,
	PRIMARY KEY (comment_num),
	FOREIGN KEY(comment_board_num)
	REFERENCES qna_board(qna_num)
);

SELECT * FROM qna_comment;

















