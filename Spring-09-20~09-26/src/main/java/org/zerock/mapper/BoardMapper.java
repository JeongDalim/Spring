package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

//@Select("select * from tbl_board where bno > 0") //이걸 xml로도 해보자
public List<BoardVO> getList();
	
public void insert(BoardVO vo);

public void insertSelectKey(BoardVO vo);

public BoardVO read(int bno);

public int delete(int bno);

public int upadate(BoardVO board);


}
