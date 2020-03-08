package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
    @Setter(onMethod_ = @Autowired)
      private BoardService service;
  
    /*
    @Test
    public void testExist() {
       log.info(service);
    }
    @Test
    public void testRegister() {
    	BoardVO vo = new BoardVO();
    	vo.setTitle("AAAAAA");
    	vo.setContent("BBBBAAAAAA");
    	vo.setWriter("user01");
    	
    	service.register(vo);
    	log.info("생성된 게시물 번호:" + vo.getBno());
    	
    	
    }
    
    @Test
    public void testGet() {
    	log.info(service.get(45));
    	
    }
    
    @Test
    public void testUpdate() {
    
    	BoardVO board = service.get(45);
    	
    	if(board == null) {
    		return;
    	}
    	
    	board.setTitle("제목을 수정합니다욜크크");
    	 log.info("MODIFY RESULT:" + service.modify(board));
    	
    }
    	*/
    
    @Test
    public void testDelete() {
    	
    	log.info("REMOVE result:" + service.remove(45));
    }
    
    
}