package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.QNABoardService;
import service.QNABoardServiceImpl;
import vo.BoardVO;

@WebServlet("*.bo")
public class QNABoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	QNABoardService service = new QNABoardServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//자동 로그인 체크
		MemberService.loginCheck(request);
		//요청 경로 가공과정 이해하기 ! 
		String command = request.getRequestURI().substring(request.getContextPath().length()+1);
		System.out.println("request.getRequesURI() : "+request.getRequestURI());
		System.out.println("request.getContextPath() : "+ request.getContextPath());
		System.out.println("request.getContextPath().length+1 : "+ request.getContextPath().length()+1);
		System.out.println("command : "+command);
		
		String nextPage = null;
		
		// header 에서 질문과답변 항목을 클릭했을때 오는 요청경로가 boardList.bo 일떄
		if(command.equals("boardList.bo")) {
			//목록 페이지 요청
			ArrayList<BoardVO> list = service.getBoardList(request);
			request.setAttribute("list", list);
			// "list" 에 ArrayList<BoardVO> list 를 담아서 nextPage로 getRequestDispatcher().forward() 방식으로 이동
			nextPage = "/board/qna/qna_list.jsp";
			// / 절대경로 ? 프로젝트 기준으로 찾아들어간다
		}else if(command.equals("boardWrite.bo")) {
			// 목록 작성 페이지 요청
			nextPage = "/board/qna/qna_write.jsp";
		}else if(command.equals("boardWriteSubmit.bo")) {
			System.out.println("게시글 등록 요청");
			// 일반 for data 게시글 등록
			//service.boardWrite(request);
			// 첨부파일과 함께 게시글 등록
			service.boardWriteFile(request);
			response.sendRedirect("boardList.bo");
		}
		
		
		if(nextPage != null) {
			request.getRequestDispatcher(nextPage).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
