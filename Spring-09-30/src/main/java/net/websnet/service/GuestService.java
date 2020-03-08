package net.websnet.service;

import java.util.List;

import net.websnet.domain.GuestVO;

public interface GuestService {
	public List<GuestVO> guestList();
	
	public void guestWrite(GuestVO vo);
	
	public GuestVO guestView(int idx);
	
	public void guestReadCnt(int idx);
}
