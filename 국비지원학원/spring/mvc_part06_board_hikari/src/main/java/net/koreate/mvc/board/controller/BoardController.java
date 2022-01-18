package net.koreate.mvc.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.koreate.mvc.board.vo.BoardVO;
import net.koreate.mvc.common.service.BoardService;
import net.koreate.mvc.common.util.Criteria;
import net.koreate.mvc.common.util.PageMaker;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	BoardService<BoardVO,PageMaker,Criteria> service;
	
	// /board/register method = GET
	@GetMapping("/register")
	public void register() throws Exception{
		System.out.println("/board/register GET 요청");
	}
	
	// /board/register method = POST
	@PostMapping("/register")
	public String register(BoardVO boardVO, 
							Model model,
							RedirectAttributes rttr) throws Exception{
		System.out.println(boardVO);
		String result = service.register(boardVO);
		System.out.println(result);
		rttr.addFlashAttribute("result",result);
//		Criteria cri = new Criteria();
//		model.addAttribute("list",service.list(cri));
//		model.addAttribute("pm",service.getPageMaker(cri));
//		return "/board/listPage";// 여기선 넘어가는 데이터가 없다 위에거랑 번갈아가면서 테스트해봐라
		return "redirect:/board/listPage";
	}
	
	// GET /board/listPage
		@GetMapping("/listPage")
		public void listPage(Criteria cri, Model model)throws Exception{
			System.out.println(cri);
			model.addAttribute("list",service.list(cri));
			model.addAttribute("pm",service.getPageMaker(cri));
		}
	
}









