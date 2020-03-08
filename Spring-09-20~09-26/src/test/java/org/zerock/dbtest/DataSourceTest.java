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

@RunWith(SpringJUnit4ClassRunner.class) //현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는것
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") 
//지정된 클래스나 문자열을 이용해서 필요한 객체를 스프링 내에 객체로 등록(흔히 스프링의 빈으로 등록된다고 표현)
//여기에서 사용하는 문자열은 'classpath:"나 'file:'을 이용할 수 있으므로, 이클립스에서 자동으로 생성된
//root-context-context.xml의 경로를 지정할 수 있음 
//@ContextConfiguration(classes = {RootConfig.class})

@Log4j
//lombok을 이용해서 로그를 기록하는 logger을 변수로 생성
// 별도의 logger의 객체 선언 없이도 log4j라이브러리와 설정이 존재한다면 바로 사용할 수 있다. 

public class DataSourceTest {

	//Setter 설정메소드 
   @Setter(onMethod_ = {@Autowired})
   //Autowired는 해당 인스턴스 변수가 스프링으로부터 자동으로 주입해달라는 표시이고, 스프링은 정상적으로 주입 가능하면

   
   private DataSource dataSource;
   // DataSource타입의 객체를 주입하게 된다.
   
  //실행결과를 보면 DataSource
   
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