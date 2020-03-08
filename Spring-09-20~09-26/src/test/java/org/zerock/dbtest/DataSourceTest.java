package org.zerock.dbtest;


import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //���� �׽�Ʈ �ڵ尡 �������� �����ϴ� ������ �� ���̶�°�
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") 
//������ Ŭ������ ���ڿ��� �̿��ؼ� �ʿ��� ��ü�� ������ ���� ��ü�� ���(���� �������� ������ ��ϵȴٰ� ǥ��)
//���⿡�� ����ϴ� ���ڿ��� 'classpath:"�� 'file:'�� �̿��� �� �����Ƿ�, ��Ŭ�������� �ڵ����� ������
//root-context-context.xml�� ��θ� ������ �� ���� 
//@ContextConfiguration(classes = {RootConfig.class})

@Log4j
//lombok�� �̿��ؼ� �α׸� ����ϴ� logger�� ������ ����
// ������ logger�� ��ü ���� ���̵� log4j���̺귯���� ������ �����Ѵٸ� �ٷ� ����� �� �ִ�. 

public class DataSourceTest {

	//Setter �����޼ҵ� 
   @Setter(onMethod_ = {@Autowired})
   //Autowired�� �ش� �ν��Ͻ� ������ ���������κ��� �ڵ����� �����ش޶�� ǥ���̰�, �������� ���������� ���� �����ϸ�

   
   private DataSource dataSource;
   // DataSourceŸ���� ��ü�� �����ϰ� �ȴ�.
   
  //�������� ���� DataSource
   
   @Setter(onMethod_ = {@Autowired})
   private SqlSessionFactory sqlSessionFactory;
   
   @Test
   public void testConnection() {
      try (Connection con = dataSource.getConnection()){
         log.info(con);
      } catch (Exception e) {
         //fail(e.getMessage());
      }
   }
   
   @Test
   public void testMybatis() {
      try {
         SqlSession sqlSession = sqlSessionFactory.openSession();
         Connection conn = sqlSession.getConnection();
         log.info(sqlSession);
         log.info(conn);
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
}