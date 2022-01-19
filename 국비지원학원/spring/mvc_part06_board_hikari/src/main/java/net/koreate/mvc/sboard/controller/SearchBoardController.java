package net.koreate.mvc.sboard.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.koreate.mvc.common.service.BoardService;
import net.koreate.mvc.common.util.SearchCriteria;
import net.koreate.mvc.common.util.SearchPageMaker;
import net.koreate.mvc.sboard.vo.SearchBoardVO;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

	@Inject
	BoardService<SearchBoardVO, SearchPageMaker, SearchCriteria> 
	service;
}








