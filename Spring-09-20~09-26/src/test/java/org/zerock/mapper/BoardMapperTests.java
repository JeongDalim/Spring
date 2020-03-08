package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //찾아서 생성해준다음에 
@Log4j
public class BoardMapperTests {
	
@Setter(onMethod_= @Autowired)
private BoardMapper mapper;
//mapper 를 찾아서 객체로 만을어줌 


/*
@Test
public void testGetList() {	
	mapper.getList().forEach(board -> log.info(board));
}				//mapper 가 가르치고 있는 getList 메소드를 호출해오라  (남다식 for문 이라고함 )for문 돌려서 가져오는 것 
	
	
	

//첫번째 방법
@Test
public void testInsert() {
	BoardVO board = new BoardVO();
	board.setTitle("AAAAA");
	board.setContent("BBBBBB");
	board.setWriter("new");
	
	mapper.insert(board);
	log.info(board); //0이 출력될꺼야 
	

}

//두번째 방법
@Test
public void testInsertSelectKey() {
	BoardVO board = new BoardVO();
	board.setTitle("222222-SelectKey");
	board.setContent("33333 SelectKey");
	board.setWriter("new");
	
	mapper.insertSelectKey(board);
	log.info(board);
	
}

@Test
public void testRead() {
 //존재하는 게시물 번호로 테스트
	BoardVO board =mapper.read(21);
	log.info(board);
}



@Test
public void testDelete() {
	log.info("Delete count" + mapper.delete(21));
}


@Test
public void testUpadate() {
	BoardVO board = new BoardVO();
	// 실행전 존재하는 번호인지 확인할 것
	board.setBno(41);
	board.setTitle("수정된 제목");
	board.setContent("수정된 내용");
	board.setWriter("modifiedId");
	
	int count = mapper.upadate(board);
	log.info("update cont:" + count);
	
}
*/




}
