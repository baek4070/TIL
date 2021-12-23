show tables;

CREATE TABLE test_board(
	board_num INT PRIMARY KEY auto_increment,
	board_name VARCHAR(20) NOT NULL,
	board_pass VARCHAR(50) NOT NULL,
	board_title VARCHAR(50) NOT NULL,
	board_content TEXT NOT NULL,
	board_readcount INT default 0,
	board_date TIMESTAMP default now()
);

DESC test_board;

SELECT * FROM test_board;