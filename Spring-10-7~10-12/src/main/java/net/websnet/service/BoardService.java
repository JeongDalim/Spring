package net.websnet.service;

import java.util.List;

import net.websnet.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> boardList();
	
	public int boardMaxIdx();
	
	public void boardWrite(BoardVO vo);
	
	// 조회수 증가
	public void boardCount(int idx);
	// 특정 게시물 검색(View)
	public BoardVO boardSelect(int idx);
	
	// 답변글 글 깊이
	public void boardDepth(BoardVO vo);
	
	// 게시글 수정
	public int boardModify(BoardVO vo);
	
	// 삭제글의 답변글이 존재하는지 검사
	public int boardRealparent(int idx);
	
	// 글삭제(성공시 정수 리턴)
	public int boardDelete(BoardVO vo);

}
