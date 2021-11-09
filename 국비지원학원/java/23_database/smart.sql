CREATE DATABASE smart;

show tables;

CREATE TABLE student(
	stuNo INT PRIMARY KEY auto_increment,
	stuName VARCHAR(50),
	stuDept VARCHAR(50),
	stuGrade INT,
	stuClass char(1) default 'A',
	stuGender char(1) default 'F',
	stuDate TIMESTAMP default now()
);

show tables;
-- ctrl + alt + x
INSERT INTO student
VALUES(null, '최기근', '컴퓨터공학', 3, 'A', 'M',now());

SELECT * FROM student;

CREATE TABLE tbl_book(
	num INT PRIMARY KEY auto_increment,
	title VARCHAR(300),
	author VARCHAR(300),
	regdate TIMESTAMP default now()
);

INSERT INTO tbl_book(title,author)
VALUES('혼자공부하는자바','신용권');

SELECT * FROM tbl_book;

UPDATE tbl_book SET author = '최기근' WHERE num = 1;

SELECT * FROM tbl_book;
