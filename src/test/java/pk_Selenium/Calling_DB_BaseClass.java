package pk_Selenium;

import java.sql.SQLException;

import org.testng.annotations.Test;

public class Calling_DB_BaseClass extends BaseClass {
	
		@Test
		public void readDB() throws ClassNotFoundException, SQLException {
//			ConnectSQLDB("jdbc:mysql://localhost:3306/weborder","root","root","select * from login","com.mysql.jdbc.Driver");
			ConnectSQLDB("jdbc:mysql://localhost:3306/weborder","root","root","select * from create_order","com.mysql.jdbc.Driver","unam","upass");
			
			
		}

		private void ConnectSQLDB(String string, String string2, String string3, String string4, String string5,
				String string6, String string7) {
			// TODO Auto-generated method stub
			
		}
	

}
