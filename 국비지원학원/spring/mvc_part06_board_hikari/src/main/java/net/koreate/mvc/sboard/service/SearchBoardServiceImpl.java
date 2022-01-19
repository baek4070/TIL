package net.koreate.mvc.sboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.koreate.mvc.common.service.BoardService;
import net.koreate.mvc.common.util.SearchCriteria;
import net.koreate.mvc.common.util.SearchPageMaker;
import net.koreate.mvc.sboard.vo.SearchBoardVO;

@Service
public class SearchBoardServiceImpl 
implements BoardService<SearchBoardVO, SearchPageMaker, SearchCriteria> {

	
	@Override
	public String register(SearchBoardVO model) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modify(SearchBoardVO model) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String remove(int bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchBoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateViewCnt(int bno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SearchBoardVO> list(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchPageMaker getPageMaker(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getListModel(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}







