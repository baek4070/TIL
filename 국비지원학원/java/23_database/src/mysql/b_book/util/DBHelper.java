package mysql.b_book.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBHelper {
//	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
//	private static String URL = "jdbc:mysql://localhost:3306/smart";
//	private static String USER = "smart";
//	private static String PASS = "12345";
	
	private DBHelper() {}
	
	private static Connection conn = null;
	public static Connection getConnection() {
		if (conn == null) {
			try {
				//요렇게 하면 mysql 정보를 가지고있는 .properties 파일만 수정하면 된다 ! 
				Properties prop = new Properties();
				File file = new File("src/prop/mysql.properties");
				String path = file.getPath();
				System.out.println(path);
				prop.load(new FileReader(path));
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
//				Class.forName(DRIVER);
//				conn = DriverManager.getConnection(URL, USER, PASS);
				Class.forName(driver);
//				conn = DriverManager.getConnection(url, user, password);
				conn = DriverManager.getConnection(url, prop);
				
			}catch (IOException e) {
			}catch (ClassNotFoundException e) {
				System.out.println("Driver 정보를 찾을 수 없음.");
			} catch (SQLException e) {
				System.out.println("DB 정보 오류 : "+e.getMessage());
			}
		}
		return conn;
	}
	public static void close(AutoCloseable... closers) { // ... 하면 몃개일지 모른다는 뜻
		for(AutoCloseable closer : closers) {
				
			try {
				if (closer != null) {
					closer.close();
				}
			} catch (Exception e) {}
		}
	}
//	public static void close(Statement stmt) {
//		try {
//			if(stmt != null) stmt.close();
//		} catch (SQLException e) {}
//	}
//	
//	public static void close(Connection conn) {
//		try {
//			if(conn != null) conn.close();
//		} catch (SQLException e) {}
//	}
}