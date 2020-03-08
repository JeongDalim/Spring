package net.websnet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import net.websnet.domain.GuestVO;

public interface GuestMapper {
	//@Select("select * from guest_tbl")
	public List<GuestVO> guestList();
	
	// DB 등록
	public void guestWrite(GuestVO vo);
	
	//View
	public GuestVO guestView(int idx);
	
	// 조회수 증가
	public void guestReadCnt(int idx);
}
