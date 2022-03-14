package org.designmode.structure.facade;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
//import org.apache.commons.dbcp.BasicDataSource;

/**
 * Apache DBCP
 * DBCP使用
 *  A：导入包 包含DataSource实现类；
	   B：创建dataSource 的实现类对象，new BasicDataSource（）
		BasicDataSource实现了DataSource接口，提供了 getConnection（）方法，封装了数据库连接池的策略管理算法。
	   C：设置数据库的连接参数（driver,url,user,pwd）.

	   D：设置管理测略参数（可以不设，有默认值）
			设置方法set XXX 
			在管理策略中可以设置超时时间
		

	   E:调用 getConnection()方法，获得被连接池管理的数据库连接
		1）：是从连接池中获得的连接！
		  A）：---可以是空闲连接（连接池空闲）
		  B）：---是新创建连接（连接池比较慢）
		  C）：---同步等待（卡住了）！（连接池满了！）
			--------两种情况----------
			--------有连接归还的时候，返回连接
			--------超时了，得到SQL异常 
		2）：当关闭（.close（））这个连接时候，连接不会立即断开，是连接对象设置为空闲归还到了连接池。
注意：数据库连接池的策略参数是专用方法，不同的连接池不一样！方法名不一样，功能类似
 * 这是封装JDBC线程池的类
 * @author soft01
 *
 */
public class DBCP {
	private static DataSource ds;
	private static Properties pro;
	
	static{
		try {
			pro = new Properties();
			pro.load(new FileInputStream("db.properties"));
//			BasicDataSource ds = new BasicDataSource();
//			//加载资源
//			ds.setDriverClassName(pro.getProperty("jdbc.driver"));
//			ds.setUrl(pro.getProperty("jdbc.url"));
//			ds.setUsername(pro.getProperty("jdbc.user"));
//			ds.setPassword(pro.getProperty("jdbc.pwd"));
//
//			//创建管理参数
//			//最大的活动数
//			ds.setMaxActive(Integer.parseInt(pro.getProperty("jdbc.active")));
//			//最大的等待时间
//			ds.setMaxWait(Integer.parseInt(pro.getProperty("jdbc.wait")));
//			/*
//			 * static静态块不能用this
//			 */
//			DBCP.ds = ds;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("静态块加载失败");
		}
	}
	/**
	 * 这是获取Connection的方法
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	/**
	 * 这是关闭Connection的方法
	 * @param conn
	 */
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 此方法执行Update，delete insert方法
	 */
	public static void mainText(){
		String sql = "Update dept_mqf set loc = ? where depton = ?";
		Connection conn = null;
		try {
			conn = DBCP.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			// 获取先要搜索的值
			ps.setString(1, "bj");
			ps.setString(2, "10");
			int n = ps.executeUpdate();
			System.out.println(n);
			ps.close();
		} catch (Exception e) {
			
		}finally{
			DBCP.close(conn);
		}
	}
	/**
	 * 这个方法是测试Satement方法单线程的
	 * 次方法不安全
	 * @param name
	 * @param pwd
	 * @return
	 */
	public static boolean login1(String name,String deptno){
		Connection conn = null;
		String sql  = "select ename from emp_mqf where ename = '"+name+"'and deptno = '"+deptno+"'";
		System.out.println(sql);
		try {
			conn = DBCP.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int  n =-1;
			while(rs.next()){
				System.out.println("3333");
				String str = rs.getString("ename");
				System.out.println(str);
//				n = rs.getInt(2);
//				System.out.println(n);
			}
			rs.close();
			st.close();
			return n > 0;
		} catch (Exception e) {
			return false;
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 在工作中大多数使用 ps 对象执行sql ；对于没有参数的固定的sql使用Statement执行
	 * @param name
	 * @param deptno
	 * @return
	 */
	public static boolean login2(String name,String deptno){
		Connection conn = null;
		String sql  = "select Count(*),avg(sal) from emp_mqf where ename = ? and deptno = ?";
		try {
			conn = DBCP.getConnection();
			PreparedStatement st =conn.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, deptno);
			st.executeUpdate();
			ResultSet rs = st.executeQuery();
			int  n =-1;
			while(rs.next()){
				n = rs.getInt(1);
				System.out.println(n);
				n = rs.getInt(2);
				System.out.println(n);
			}
			rs.close();
			st.close();
			return n > 0;
		} catch (Exception e) {
			return false;
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
