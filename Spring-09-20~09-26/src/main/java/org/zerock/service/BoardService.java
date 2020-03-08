package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	//��ü�� ���� �� �߻�żҵ��� extract �� ������ ���� 
	public List<BoardVO> getList();
	
	public void register(BoardVO vo);
	
	
	 public BoardVO get(int bno);
	

	 public boolean modify(BoardVO vo);
	 

	 public boolean remove(int bno);
	
}
