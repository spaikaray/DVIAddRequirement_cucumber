//package Pages;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class ConnectDB {
//
//	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		
//		
//		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
//		String connectionUrl= "jdbc:sqlserver://dvi-sql-internal.database.windows.net;;user=Dvi-sql-admin;password=Mt62d6Y2jgCXMd9;databaseName=dvi-sql-internal-qa";
//		
//		Connection con = DriverManager.getConnection(connectionUrl);  
//		
//		Statement stmnt= con.createStatement();
//		
//		String s= "SELECT top 1 *  FROM REQUIREMENT order by 1 DESC";
//		String s1= "SELECT MAX(id) FROM REQUIREMENT";
//		
//		ResultSet rs= stmnt.executeQuery(s);
//		
//		
//		while (rs.next()) {
//			
//			String title= rs.getString("Title");
//			String contract= rs.getString("Contract_Duration");
//			String id= rs.getString("Id");
//			
//			System.out.println("title is:"+title);
//			System.out.println("contract is:"+contract);
//			System.out.println("Id is:"+id);
//			
//		}
//		ResultSet rs1= stmnt.executeQuery(s1);
//		while (rs.next()) {
//			String maxrow= rs1.getString(0);
//			System.out.println("Id is:"+maxrow);
//			
//		}
//		System.out.println("query executed");
//		
//		con.close();
//
//	}
//
//}
