=============================================
-- project에 MySQL JDBC 등록하기 

mvnrepository.com 접속
검색창에 mysql-connector 검색

MySQL Connector/J 선택

내컴퓨터에 설치된 version 선택

Files 탭의 jar파일 다운로드

project 우클릭 -> build path ->
Add External Archives 선택

다운로드 받은 jar 파일 선택 후 열기
(mysql-connector-java-8.0.27.jar)

-> Referenced Libraries 에 등록된 jar 확인 후 완료

=============================================

-- eclipse 에 data source explorer 설치하기

Help -> install new Software... 선택

Work With 작성란에 해당 내용 기입
https://download.eclipse.org/releases/neon/
후 Enter

검색된 내용 중

Database Development Check 후 next
 
I accept 동의 후 finish

설치 완료 되면 eclipse restart

재시작 후 

Window -> Show View -> Other 선택

Data Management -> Data Source Explorer 선택

DataBase Connections 폴더 우클릭 New... 선택

다운로드 받은 mysql-connector jar 파일 등록

접근 하려는 dabase url, username, password 정보를 등록 하여

connection 정보 추가
