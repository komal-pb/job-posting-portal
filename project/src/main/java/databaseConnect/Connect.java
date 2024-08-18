package databaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	private static Connection Conn;

	public static Connection getConn() {
		
		try {
			if(Conn==null) {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				Conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal", "root", "root@123");
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		return Conn;
	}
}
