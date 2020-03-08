package DBtest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class DBtestConn {
	static { 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String username="system";
		String password="1234";
		
		
		try {
			Connection conn = DriverManager.getConnection(url,username,password);
			log.info(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
