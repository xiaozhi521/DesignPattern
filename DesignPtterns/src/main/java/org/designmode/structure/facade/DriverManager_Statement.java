package org.designmode.structure.facade;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 本类是单线程的
 * @author soft01
 *
 */
public class DriverManager_Statement {
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	/**
	 * 静态方法块
	 */
	static{
		try {
			Properties pro = new Properties(); 
			pro.load(new FileInputStream("db.properties"));
			driver = pro.getProperty("jdbc.driver");
			url = pro.getProperty("jdbc.url");
			user = pro.getProperty("jdbc.user");
			pwd = pro.getProperty("jdbc.pwd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取Connection的方法 用Drivermanager.getConnection();
	 * @return
	 */
	public static Connection getConnection(){
		//这个地方可以抛出异常而不是处理掉????
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pwd);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("没有找到驱动");
		}
	}
	/**
	 * 关闭Connection的方法
	 * @param conn
	 */
	public static void close(Connection conn){
		if(conn!= null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 这是主方法
	 */
	public static void mianText(){
		String sql = "select 'hello' as a from dual";
		Connection conn = null;
		try {
			conn = DriverManager_Statement.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				String str = rs.getString("a");
				System.out.println(str);
			}
			if(rs != null){
				rs.close();
			}
			if(st != null){
				st.close();
			}
		} catch (Exception e) {
			
		}finally{
			DriverManager_Statement.close(conn);
		}
	}
}
