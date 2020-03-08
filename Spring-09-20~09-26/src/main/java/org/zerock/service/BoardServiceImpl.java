package org.zerock.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.controller.HomeController;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;


@Service //Service ��ü ����� ���ֶ�� ���� 
@AllArgsConstructor //Service �� �ڵ������� ��ü�� ����� �� �ֵ��� ���� 
public class BoardServiceImpl implements BoardService {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList() {
				//�̰� ȣ���ϸ� Mapper �� �ִ°� ȣ������ 
					//�� getList�� ��Ʈ�ѷ��� ȣ���Ҳ��� 
		logger.info("getList()..........");
		return mapper.getList();
	}
	
	@Override
	public void register(BoardVO vo) {
		logger.info("register()..........");
		mapper.insertSelectKey(vo);
	}
	
	  @Override public BoardVO get(int bno) {
		  logger.info("get()........." + bno);
		 
		  return mapper.read(bno);
		  
	 }
	 

	  @Override public boolean modify(BoardVO vo) {
		  logger.info("modify....." + vo);
		  return mapper.upadate(vo) == 1;
		  
	  
	  }
	

	  @Override public boolean remove(int bno) {
		  logger.info("remove......." + bno);
		  return mapper.delete(bno) == 1;
	  }
	
	
	
	
	
	

}
