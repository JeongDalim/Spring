package net.websnet.mapper;

import java.util.List;

import net.websnet.domain.BoardVO;

public interface BoardMapper {
	
	public List<BoardVO> boardList();
	
	//MaxIDX
	public int boardMaxIdx();
	
	// 등록
	public void boardWrite(BoardVO vo);
	
	//특정게시물 조회수증가(View)
	public void boardCount(int idx);

	//특정게시물 검색(View)
	public BoardVO boardSelect(int idx);
	
	// 답변글일 경우 글 깊이, 들여쓰기 조정
	public void boardDepth(BoardVO vo);
	
	// 게시글 수정(수정 성고시 정수 리턴)
	public int boardModify(BoardVO vo);
	
	// 삭제글의 답변글이 존재하는지 검사
	public int boardRealparent(int idx);
	
	// 글삭제(성공시 정수 리턴)
	public int boardDelete(BoardVO vo);
	
}
