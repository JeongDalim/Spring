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
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //ã�Ƽ� �������ش����� 
@Log4j
public class BoardMapperTests {
	
@Setter(onMethod_= @Autowired)
private BoardMapper mapper;
//mapper �� ã�Ƽ� ��ü�� �������� 


/*
@Test
public void testGetList() {	
	mapper.getList().forEach(board -> log.info(board));
}				//mapper �� ����ġ�� �ִ� getList �޼ҵ带 ȣ���ؿ���  (���ٽ� for�� �̶���� )for�� ������ �������� �� 
	
	
	

//ù��° ���
@Test
public void testInsert() {
	BoardVO board = new BoardVO();
	board.setTitle("AAAAA");
	board.setContent("BBBBBB");
	board.setWriter("new");
	
	mapper.insert(board);
	log.info(board); //0�� ��µɲ��� 
	

}

//�ι�° ���
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
 //�����ϴ� �Խù� ��ȣ�� �׽�Ʈ
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
	// ������ �����ϴ� ��ȣ���� Ȯ���� ��
	board.setBno(41);
	board.setTitle("������ ����");
	board.setContent("������ ����");
	board.setWriter("modifiedId");
	
	int count = mapper.upadate(board);
	log.info("update cont:" + count);
	
}
*/




}
