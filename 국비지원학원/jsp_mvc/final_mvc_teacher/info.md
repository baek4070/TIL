## info.md
/common/*  		전체 페이지 공통 페이지
/member/*  	 	회원 관련 요청 처리 페이지
/error/*   	 	공통 에러 처리 페이지
/board/*    	게시물 관련 페이지
/board/qna/*	답변형 게시물 페이지
/board/notice/*	공지형 게시물 페이지
/board/comment/*댓글 페이지
/resources/*	정적 자원(css/img/js *) 

# 요청 URL
*.mc 				회원 관련 요청 처리 URL
*.do				공지형 게시판 요청 처리 URL
*.bo				답변형 게시판 - 댓글 요청 처리 URL

*.co				비동기 댓글 요청 처리 URL
commentWrite.co		댓글 작성 요청
list.co				댓글 리스트
commentDelete.co 	댓글 삭제

	qna_num INT PRIMARY KEY auto_increment,			-- 글번호
	qna_name VARCHAR(30) NOT NULL,					-- 작성자
	qna_title VARCHAR(100) NOT NULL,				-- 글제목
	qna_content LONGTEXT NOT NULL,					-- 글내용
	qna_file VARCHAR(100),							-- 저장된 파일이름
	qna_file_origin VARCHAR(100),					-- 원본파일 이름
	qna_re_ref INT NOT NULL,						-- 원본 글 번호
	qna_re_lev INT NOT NULL,						-- 답변글 view 번호
	qna_re_seq INT NOT NULL,						-- 답변글 정렬 번호
	qna_writer_num INT,								-- 글 작성자 번호
	qna_readcount INT DEFAULT 0,					-- 조회수
	qna_delete char(1) DEFAULT 'N',					-- 삭제 여부
	qna_date TIMESTAMP DEFAULT now(),				-- 작성 시간
	FOREIGN KEY(qna_writer_num) REFERENCES mvc_member(num)













