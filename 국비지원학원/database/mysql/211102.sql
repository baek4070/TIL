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

# LIKE whidcard[%,_] 를 활용 한 검색
# 와일드 카드 를 이용하여 1970 년대생 찾기 1970~1979
SELECT * FROM userTbl
WHERE birthYear Like '197_';

# userTbl에서 성이 '김'씨인 모든 사용자 정보 검색
SELECT * FROM userTbl
WHERE name LIKE '김__';

SELECT * FROM userTbl
WHERE name LIKE '김%';

# userTbl의 사용자 중에 이름 중간에 '시'가 들어가는 사용자 검색
SELECT * FROM userTbl
WHERE name LIKE '%시%';

SELECT * FROM userTbl
WHERE name LIKE '_수_';

SELECT * FROM userTbl
WHERE name LIKE '%수%';

#Date type 의 비교 mDate date
SELECT mDate FROM userTbl
WHERE userID = 'HGD';

-- 2013년 이전에 가입한 사용자
SELECT * FROM userTbl WHERE mDate < '2013-01-01';

-- 키가 182이면서 2009년 이전에 가입한 사용자 검색
-- 2009년 이전에 가입한 사용자 중에 키가 182인 사람
SELECT * FROM userTbl 
WHERE mDate < 20090101 AND height = 182;

-- Null 값 비교
-- mobile1 핸드폰 번호가 없는 사용자 정보 검색
SELECT * FROM userTbl 
WHERE mobile1 is null;

-- 전화번호가 존재하는 사용자
SELECT * FROM userTbl 
WHERE mobile1 is NOT null;
-- 거주지(주소)가 서울이 아닌 사람 검색
SELECT * FROM userTbl 
WHERE addr != '서울';

SELECT * FROM userTbl 
WHERE NOT addr = '서울';

SELECT * FROM userTbl 
WHERE addr <> '서울';

#전화번호 시작(mobile1) 016,018,019 인사람 검색
SELECT * FROM userTbl
WHERE mobile1 in('016','018','019');
#전화번호 시작(mobile1) 016,018,019 이 아닌사람 검색
SELECT * FROM userTbl
WHERE NOT mobile1 in('016','018','019');

#userTbl에서 '김경호' 보다 키가 크거나 같은 사람을검색하세요
#1. 김경호의 키를 알아내야한다
SELECT height FROM userTbl
where name = '김경호';
# 김경호의 키가 177인걸 알아냈다면 이제 보다 크거나 같은사람으로 검색
SELECT * FROM userTbl
where height >= 177;
#서브 쿼리(subQuery)를 이용해 두개의 질의를 하나로 합칠수가 있다
# 김경호 보다 크거나 같은키를 가진 사용자 검색
SELECT name, height FROM userTbl
WHERE height >= (
	SELECT height FROM userTbl
	WHERE name = '김경호'
);

SELECT name,height,addr FROM userTbl
WHERE height in(
	SELECT height FROM userTbl
	WHERE addr = '경남'
);

SELECT name,height,addr FROM userTbl
WHERE height >= ANY(
	SELECT height 
    FROM userTbl
	WHERE addr = '경남'
);

# 검색 된 행의 정보를 정렬해주는 ORDER BY 절(ASC/DESC)
SELECT * FROM userTbl ORDER BY addr;

# 가장 최근에 가입한 순서대로 정렬
SELECT * FROM userTbl ORDER BY mDate DESC;

# 거주지역 순으로 정렬하고 동일 지역이면나이순으로 정렬
SELECT * FROM userTbl
ORDER BY addr ASC, birthYear DESC;
# 검색 결과 열의 중복되는 값을 제거 - distict
SELECT DISTINCT addr FROM userTbl
ORDER BY addr;

SELECT DISTINCT addr FROM userTbl
WHERE height >= 175;
#userTbl에서 회원들의 거주 지역이 몃군데 인지 세어보세요

# 검색된 결과 내에서 제공되는 개수를 제한하는 LIMIT
SELECT * FROM userTbl ORDER BY mDate DESC;
# 개수
SELECT * FROM userTbl ORDER BY mDate DESC LIMIT 5;
# limit 시작 인덱스, 개수;
SELECT * FROM userTbl ORDER BY mDate DESC LIMIT 3, 5;
# limit 개수, offset 위치
SELECT * FROM userTbl 
ORDER BY mDate DESC LIMIT 6 OFFSET 5;

SELECT * FROM buyTbl;
# buyTbl 총 팔린 상품의 개수
# buyTbl 의 amount 속성의 총 합계
SELECT sum(amount) FROM buyTbl;
SELECT sum(amount) FROM buyTbl where userID='BBK';

# buyTbl 에서 사용자가 구매한 개수를 userID로 그룹화 하여
# 합산한 내역을 검색
SELECT userID, sum(amount) AS '구매개수' FROM buyTbl
GROUP BY userID;

# buyTbl 에서 사용자가 구매한금액을 userID별로 그룹화 하여 검색
SELECT userID, sum(amount * price) AS '구매금액' FROM buyTbl
GROUP BY userID;

#상품 이름 prodName, 판매개수 amount
#buyTbl 에서 상품별로 몃개나 판매 되었는지 상품을 그룹화하여 검색

SELECT prodName, sum(amount) 
FROM buyTbl
GROUP BY prodName
ORDER BY '판매개수' DESC;

# count() table 에 존재하는 행의 개수를 검색
# count(열이름) 해당 속성에 유효한 값을 가진 행의 개수를 검색
SELECT * FROM userTbl;
SELECT count(*) FROM userTbl;
SELECT count(mobile1) FROM userTbl;

SELECT count(*) FROM userTbl
WHERE mobile1 is not null;

SELECT count(*) FROM userTbl
WHERE mobile1 is null;

SELECT count(DISTINCT addr) FROM userTbl;
SELECT DISTINCT addr FROM userTbl;

# min() , max() 속성에 저장된 최소값과 최고값을 검색
# userTbl 에서 키가 가장 작은 사람의 이름과 키를 검색
SELECT min(height) FROM userTbl;
SELECT max(height) FROM userTbl;

SELECT name , height FROM userTbl
WHERE height IN(
	(SELECT min(height) FROM userTbl),
	(SELECT max(height) FROM userTbl)
);

# buyTbl에 등록된 상품 들 중에 가장 가격이 낮은 상품과
# 가장 가격이 높은 상품의 이름과 가격을 검색

SELECT  prodName, price FROM buyTbl
WHERE price IN(
	(SELECT max(price) FROM buyTbl),
    (SELECT min(price) FROM buyTbl)
) GROUP BY prodName;