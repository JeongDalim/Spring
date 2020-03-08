package net.websnet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import net.websnet.domain.GuestVO;

public interface GuestMapper {
//	@Select("select * from guest")
	public List<GuestVO> guestList();
	
	
	
	
	
	
	
	
	
	
}
