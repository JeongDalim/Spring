package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	//몸체가 없는 것 추상매소드임 extract 가 생략된 것임 
	public List<BoardVO> getList();
	
	public void register(BoardVO vo);
	
	
	 public BoardVO get(int bno);
	

	 public boolean modify(BoardVO vo);
	 

	 public boolean remove(int bno);
	
}
