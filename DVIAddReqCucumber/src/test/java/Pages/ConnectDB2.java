package Pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

public class ConnectDB2 {
	WebDriver driver;

	public ConnectDB2(WebDriver driver) {
		this.driver= driver;
	}
		
		public void verifyDB() {
			try {
				DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
				String connectionUrl= "jdbc:sqlserver://dvi-sql-internal.database.windows.net;;user=Dvi-sql-admin;password=Mt62d6Y2jgCXMd9;databaseName=dvi-sql-internal-qa";
				
				Connection con = DriverManager.getConnection(connectionUrl);  
				
				Statement stmnt= con.createStatement();
				
				String s= "SELECT top 1 *  FROM REQUIREMENT order by 1 DESC";
				ResultSet rs= stmnt.executeQuery(s);
				
				while (rs.next()) {
					
					String title= rs.getString("Title");
					String contract= rs.getString("Contract_Duration");
					String id= rs.getString("Id");
					
					System.out.println("title is:"+title);
					System.out.println("contract is:"+contract);
					System.out.println("Id is:"+id);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
						
			
		}
		
		
		

	

}
