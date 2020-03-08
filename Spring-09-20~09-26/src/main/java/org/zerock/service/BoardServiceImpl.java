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


@Service //Service 객체 등록을 해주라는 거임 
@AllArgsConstructor //Service 가 자동적으로 객체를 등록할 수 있도록 해줌 
public class BoardServiceImpl implements BoardService {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList() {
				//이거 호출하면 Mapper 에 있는게 호출해줌 
					//이 getList는 컨트롤러가 호출할꺼임 
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
