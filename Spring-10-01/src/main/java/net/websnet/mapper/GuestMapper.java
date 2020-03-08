package net.websnet.mapper;

import java.util.List;

import net.websnet.domain.GuestVO;
import net.websnet.domain.PageVO;

public interface GuestMapper {
	//�Խù� ��ü ī��Ʈ
	public int guestCount();
	
	public List<GuestVO> guestList(PageVO vo);
	
	// DB ���
	public void guestWrite(GuestVO vo);
	
	//View
	public GuestVO guestView(int idx);
	
	// ��ȸ�� ����
	public void guestReadCnt(int idx);
}
