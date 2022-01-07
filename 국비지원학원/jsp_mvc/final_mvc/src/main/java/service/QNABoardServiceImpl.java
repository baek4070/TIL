package service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.QNABoardDAO;
import dao.QNABoardDAOImpl;
import vo.BoardVO;

public class QNABoardServiceImpl implements QNABoardService {
	
	String saveDir = "/resources/upload";
	
	QNABoardDAO dao = new QNABoardDAOImpl();

	@Override
	public ArrayList<BoardVO> getBoardList(HttpServletRequest request) {
		return null;
	}

	@Override
	public void boardWrite(HttpServletRequest request) {

	}

	@Override
	public void boardWriteFile(HttpServletRequest request) {
		//파일 정보와 함께 게시글 정보 등록
		String realPath = request.getServletContext().getRealPath(saveDir);
		System.out.println("realPath : "+realPath);
		File f = new File(realPath);
		if(!f.exists()) {
			f.mkdirs();
			System.out.println("폴더 생성 완료 : /resources/upload");
		}
		//cos.jar 파일 필요함 라이브러리 추가해주자 !! 
		// 아래 API 참조 ! 
		//http://www.servlets.com/cos/javadoc/com/oreilly/servlet/MultipartRequest.html
		//MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		//DefaultFileRenamePolicy()메서드는 파일이름이 중복될경우 test1과 같이 파일 이름을 rename해주는 역할
		try {
			MultipartRequest multi = new MultipartRequest(
					request,
					realPath,
					1024*1024*50,
					"utf-8",
					new DefaultFileRenamePolicy()
			);
			String qna_name = multi.getParameter("qna_name");
			int qna_writer_num = Integer.parseInt(multi.getParameter("qna_writer_num"));
			String qna_title = multi.getParameter("qna_title");
			String qna_content = multi.getParameter("qna_content");
			
			String file = (String)multi.getFileNames().nextElement();
			System.out.println(" file name : "+file);
			// 업로드 된 파일 이름
			String qna_file = multi.getFilesystemName(file);
			String qna_file_origin = multi.getOriginalFileName(file);
			
			BoardVO vo = new BoardVO();
			vo.setQna_name(qna_name);
			vo.setQna_title(qna_title);
			vo.setQna_content(qna_content);
			vo.setQna_writer_num(qna_writer_num);
			vo.setQna_file(qna_file);
			vo.setQna_file_origin(qna_file_origin);
			System.out.println("저장될 BoardVO객체"+vo);
			
			dao.boardWrite(vo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public BoardVO getBoardVO(HttpServletRequest request) {
		return null;
	}

	@Override
	public void updateReadCount(HttpServletRequest request) {

	}

	@Override
	public void fileDown(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public BoardVO boardReply(HttpServletRequest request) {
		return null;
	}

	@Override
	public BoardVO boardReplySubmit(HttpServletRequest request) {
		return null;
	}

	@Override
	public BoardVO getBoardVOByUpdate(HttpServletRequest request) {
		return null;
	}

	@Override
	public void boardUpdate(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void boardDelete(HttpServletRequest request, HttpServletResponse response) {

	}

}
