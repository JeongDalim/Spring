package net.websnet.mapper;

import java.util.List;

import net.websnet.domain.GuestVO;
import net.websnet.domain.PageVO;

public interface GuestMapper {
	//게시물 전체 카운트
	public int guestCount();
	
	public List<GuestVO> guestList(PageVO vo);
	
	// DB 등록
	public void guestWrite(GuestVO vo);
	
	//View
	public GuestVO guestView(int idx);
	
	// 조회수 증가
	public void guestReadCnt(int idx);
}
