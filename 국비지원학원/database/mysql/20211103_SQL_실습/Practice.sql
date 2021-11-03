use sqldb;
desc userTbl;
SELECT * FROM userTbl;
-- 1. userTbl 에서 1973년에 태어난 사람의 이름 검색
SELECT name FROM userTbl
WHERE birthYear = 1973;
-- 2. 011 전화번호를 사용하고 서울에 사는 사람의 이름과 주소 키 검색
SELECT name, addr, height 
FROM userTbl
WHERE mobile1 = 011 
AND addr ='서울';
-- 3. 경기에 사는 사람 중에 키가 170 이하인 사람 의 정보 검색
SELECT *
FROM userTbl
WHERE addr = '경기' 
AND height <= 170;

-- 4. 2013년도에 가입한 사람의 이름과 전화번호 검색
SELECT name, mobile1, mobile2
FROM userTbl
WHERE mdate 
LIKE '2013%';

-- 5. buyTbl에 해당 속성에 맞게 data 삽입
/*
	num : null, 
	userID : JKW
	prodName : '면바지'
	groupName : '의류'
	price : 40
	amount : 2
*/
INSERT INTO buyTbl (num,userID,prodName,groupName,price,amount)
VALUE (
	null,
	'JKW',
    '면바지',
    '의류',
    40,
    2
);
SELECT * FROM buyTbl;

-- 6. 김범수보다 먼저 가입한 사람의 아이디와 가입일 검색
SELECT userID, mdate 
FROM userTbl
WHERE mdate < (
	SELECT mdate 
    FROM userTbl
    WHERE name = '김범수'
);

-- 7. 윤종신보다 나이가 많은 사람의 이름과 출생년도 검색
SELECT name, birthYear
FROM userTbl
WHERE birthYear < (
	SELECT birthYear
    FROM userTbl
    WHERE name = '윤종신'
);

-- 8. 의류를 주문한 사람의 키보다 큰 사람의 이름과 키 검색
SELECT name, height
FROM userTbl
WHERE height > ANY(
	SELECT height
    FROM userTbl
    WHERE userID = ANY(
		SELECT userID
        FROM buyTbl
        WHERE groupName = '의류'
    )
);

-- 9. userTbl의 회원정보를 키가 큰 순으로 정렬하고, 키가 같으면 나이 많은 순으로 정렬하여 검색
SELECT *
FROM userTbl
ORDER by height DESC, birthYear ASC;

-- 10. buytbl 에서 groupName을 중복을 제거하고 검색
SELECT DISTINCT groupName
FROM buyTbl;


-- 11. buytbl에서 각 회원당 주문횟수 검색 - 회원별로 몇번 주문을 했는지 검색

SELECT userID, sum(amount)
FROM buyTbl
GROUP by userID;

# 회원별로 몃번 주문을 했는지 검색 구매횟수가 3번 이상인 정보만 검색
SELECT userID, count(*) AS '구매횟수' FROM buyTbl 
GROUP BY userID HAVING count(*) >= 3;


#  총 구매금액이 1000 이상인 사람만 userID로 그룹화 하여 아이디와 총구매금액 검색
SELECT sum(price * amount) FROM buyTbl;
SELECT sum(price * amount) FROM buyTbl WHERE userID = 'BBK';
 SELECT sum(price * amount) AS '구매금액 ' FROM buyTbl 
 GROUP BY userID
 HAVING '구매금액' >= 1000
 ORDER by '구매금액' DESC;



