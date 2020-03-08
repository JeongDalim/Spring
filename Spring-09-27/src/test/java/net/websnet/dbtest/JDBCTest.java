package net.websnet.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
   static {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      }catch (Exception e) {
         e.printStackTrace();
      }
   }
   @Test
   public void testConnection() {
      String url="jdbc:oracle:thin:@localhost:1521:xe";
      String user="system";
      String pass="1234";
      
      try {
         Connection conn= DriverManager.getConnection(url,user,pass);
      log.info(conn);
      }catch (Exception e) {
         e.printStackTrace();
      }
   }
}