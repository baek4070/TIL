# sqlDB database 가 존재 하면 삭제 
DROP DATABASE IF EXISTS sqlDB;
ALTER TABLE userTbl 
MODIFY userID char(8);
DESC userTbl;
# 데이터 넣기/삽입 INSERT INTO ~ VALUES
INSERT INTO userTbl #여기를 생략하면 모든값을 다넣어주는것
VALUES(
'HGD',
'홍길동',
1000,
'서울',
'010',
'00000000',
176,
20130505);
SELECT * FROM userTbl;

INSERT INTO buyTbl(userID, prodName,price,amount) 
VALUES('HGD','책',30,5);

SELECT * FROM buyTbl;

# SELECT FROM WHERE절
# TABLE 내에서 조건에 만족하는 행만 검색 내용에 포함
# userTbl에서 이름이 '김경호'인 사람만 검색
SELECT * FROM userTbl # userTbl 정보 검색
#조건절 : 이름 속성의 값이 '김경호'와 일치하는 사용자
WHERE name = '김경호';

# 1970년 이후에 출생하고 키가 182 이상인 사람 검색
# birthYear > 1970
# height >= 182
SELECT * FROM userTbl
WHERE birthYear > 1970 AND height >= 182;

#userTbl 에서 userID 가 BBK인 사람을 검색
SELECT * FROM userTbl
WHERE userID = 'BBK';
#userTbl 에서 name이 '성시경'인 사람의 아이디와 키 검색
SELECT 
	userID AS 아이디,
	height AS 키
FROM userTbl
WHERE name = '성시경';
# userTbl에서 경기도에 사는 사람의 이름과 주소 검색
DESC userTbl;
SELECT name,addr FROM userTbl
WHERE addr = '경기'; 
# userTbl에서 1970년대생의 정보만 검색
SELECT * FROM userTbl
WHERE birthYear >= 1970 AND birthYear <= 1979; 
# 1970년 이후 출생 했거나 키가 175이상인 사람
SELECT * FROM userTbl
WHERE birthYear >= 1970 OR height >= 175;

# 키가 180이상 183이하인 사람의 정보 검색
SELECT * FROM userTbl
WHERE height >= 180 AND height <= 183;
# 두사이의 값을 비교 할떄 사용되는 between
SELECT * FROM userTbl
WHERE height BETWEEN 180 AND 183;


# 주소가 '경남' 이거나 '전남' 이거나 '경북'인 사람 검색
SELECT * FROM userTbl
WHERE addr = '경남' OR addr = '전남' OR addr = '경북';
# 여러 조건 중에 일치하는 모든 정보를 제공 IN
SELECT * FROM userTbl
WHERE addr IN('경남','전남','경북');

