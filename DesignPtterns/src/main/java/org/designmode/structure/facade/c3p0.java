package org.designmode.structure.facade;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import javax.sql.DataSource;


/**
 *
 * @author 木清风
 * @since 2015年10月26日
 * @author soft01
 * 连接池总结：
 * 1）：在软件中如果需要并发访问数据库时需要使用连接池
 * 2）：控制连接总数，提高低并发情况下提高了性能，
 * 3）：使用 javax.sql.DataSource（数据源）
 *  数据源 == 连接池
 *  所有的数据源连接池都有getConnection()
 *  4）：使用数据源对象
 *  a：导入包
 *  b：创建连接池管理对象
 *  c:设置连接参数（必须）
 *  d:连接池管理策略参数（选项）
 *  e：获取连接  JDBC 操作
 *  f：关闭连接（归还连接）
 */
public class c3p0 {
	private static DataSource dataSource;
	private static Properties pro;

	static{
		try {
			pro = new Properties();
			pro.load(new FileInputStream("db.properties"));
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			//加载资源
			dataSource.setDriverClass(pro.getProperty("jdbc.driver"));
			dataSource.setJdbcUrl(pro.getProperty("jdbc.url"));
			dataSource.setUser(pro.getProperty("jdbc.user"));
			dataSource.setPassword(pro.getProperty("jdbc.pwd"));

			//创建管理参数
			//最大的活动数
			dataSource.setMaxPoolSize(Integer.parseInt(pro.getProperty("jdbc.active")));
			//最大的等待时间
			dataSource.setCheckoutTimeout(Integer.parseInt(pro.getProperty("jdbc.wait")));
			/*
			 * static静态块不能用this
			 */
			c3p0.dataSource = dataSource;


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
		return dataSource.getConnection();
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
	 *  封装回滚的方法rollback（）
	 */
	public static void rollback(Connection conn){
		if(conn != null){
			try {
				conn.rollback();
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
	 * 这个方法是测试Satement方法单线程的；
	 * 执行计划是固定，不会改变替换参数，也不能既定的执行计划，可以自然的避免注入攻击。
	 * 次方法不安全；
	 * @param name
	 * @param deptno
	 * @return
	 */
	public static boolean login1(String name,String deptno) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql  = "select ename from emp_mqf where ename = '"+name+"'and deptno = '"+deptno+"'";
		System.out.println(sql);
		try {
			conn = DBCP.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int  n =-1;
			while(rs.next()){
				n = rs.getInt(1);
				System.out.println("3333");
				System.out.println(n);
//				n = rs.getInt(2);
//				System.out.println(n);
			}
			rs.close();
			st.close();
			return n > 0;
		} catch (Exception e) {
			return false;
		}finally{
			if(st != null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
	 * 在工作中大多数使用 ps 对象执行sql ；对于没有参数的固定的sql使用Statement执行；
	 * 执行计划是固定，不会改变替换参数，也不能既定的执行计划，可以自然的避免注入攻击。
	 * @param name
	 * @param deptno
	 * @return
	 */
	public static boolean login2(String name,String deptno){
		Connection conn = null;
		String sql  = "select Count(*),avg(sal) from emp_mqf where ename = ? and deptno = ?";
		try {
			conn = DBCP.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
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
	/**
	 * 2015年10月27日
	 * 这个方法是封装要打印的SQL语句
	 *
	 * @param sql
	 */
	public static void print(String sql){
		Connection conn = null;
		try {
			conn = c3p0.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			for(int i =1;i<=count;i++){
				System.out.print(meta.getColumnName(i)+"\t");
			}
			System.out.println();
			while(rs.next()){
				for(int i = 1; i <= count;i++){
					Object obj = rs.getObject(i);
					System.out.print(obj+"\t");
				}
				System.out.println();
			}
			rs.close();
			st.close();
		} catch (Exception e) {

		}finally{
			c3p0.close(conn);
		}
	}
	/**
	 * 模拟事务控制语言TCL
	 * 执行的是Update方法
	 * 这是手动处理事物的经典结构
	 * @param sql
	 */
	public static void BalanceCount(String sql,String sql1){
		Connection conn = null;
		try {
			conn = c3p0.getConnection();
			//设置自动提交为fasle
			conn.setAutoCommit(false);
			Statement st = conn.createStatement();
			//取款操作或存款操作
			int n = st.executeUpdate(sql);
			// n的返回值不是 1 ，就抛出异常
			if(n != 1){
				throw new SQLException(" 更新失败");
			}
			// 接受结果
			ResultSet rs = st.executeQuery(sql1);
			//ResultSet rs = ps.executeQuery();
			double balance = -1;
			while(rs.next()){
				balance = rs.getDouble("balance");
			}
			// 钱少于0 抛出异常
			if(balance < 0){
				throw new SQLException("余额不足，取款失败");
			}
			System.out.println("余额："+balance);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn != null){
				try {
					//有任何异常，回滚事务TCL
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally{
			c3p0.close(conn);
		}
	}
	/**
	 * 这是获取数据结果集的元数据（ResultSetMetaData）
	 * @param sql
	 */
	public static void getMetaDataMessage(String sql){
		Connection conn = null;
		try {
			conn = c3p0.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			for(int i = 1;i<=count;i++){
				System.out.print(meta.getColumnName(i)+"\t");
			}
			System.out.println();
			while(rs.next()){
				for(int i = 1;i<=count;i++){
					System.out.print(rs.getObject(i));
				}
				System.out.println();
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			c3p0.close(conn);
		}
	}
	/**
	 * 	数据的批量更新与事务的使用；
	 *	 如果多个 更新（删除，添加）SQL 就必须使用事务；
	 * 	一个SQL 能处理的事情，一般不使用事务！
	 * 	@param name
	 * 	批量更新：
	 *	Statement
	 *	方法：
	 *     addBatch（sql） 将SQL添加到 Statemen t缓冲区;
	 *  	clearBatch（） 清除Statement 缓冲区的 SQL;
	 * 		executeBatch（） 将Statement  缓冲区的SQL 批量发送到 DB 执行;
	 *	PS  方法：
	 * 		1、addBatch（） 将当前绑定的参数添加到缓冲区；
	 *		2、创建 PS（编译 sql）
	 *		3、替换参数ps.setXXX(n,参数)
	 *			ps.addBatch()  将参数添加到缓冲区;
	 *		4、替换参数ps.setXXX(n,参数)
	 *			ps.addBatch()  将参数添加到缓冲区;
	 *			。。。。
	 *		5、ps.executeBatch() 将参数批量发送到 DB
	 *	事务特性介绍：ACID
	 *		原子性（Atomicity）：事务必须是原子工作单元；对于其数据修改，要么全都执行，要么全都不执行；
	 * 		一致性（Consistency）：事务在完成时，必须使所有的数据都保持一致状态；
   	 * 		隔离性（Isolation）：由并发事务所作的修改必须与任何其它并发事务所作的修改隔离；
	 *  	持久性（Durability）：事务完成之后，它对于系统的影响是永久性的；
	 */
	public static void TCLmessage(String[] name){
		Connection conn = null;
		String sql = "insert into mqf_d (id,name) values (mqf_d_seq.nextval,?)";
		try {
			conn = c3p0.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i = 0;i<name.length;i++){
				ps.setString(1, name[1]);
				ps.addBatch();
				if((i+1)%100 == 0){
					ps.executeBatch();
				}
			}
			int[] ary = ps.executeBatch();
			//打桩
			System.out.println(Arrays.toString(ary));
			ps.close();
			conn.commit();
		} catch (Exception e) {
			c3p0.rollback(conn);
		}finally{
			c3p0.close(conn);
		}
	}
	/**
	 * 获取自动生成的ID：是JDBC提供的功能，是固定的方法;
	 * 步骤：
	 * 	   （1）：在创建PS（st）对象的时候，提供自动生成列的列名;
	 * 			ps = conn.preparedataSourcetatement(sql,列名数组)；
	 * 			替换参数：ps.setXXX....;
	 * 			ps.executeUpdate();
	 * 		(2)：执行以后使用 ps.getGenerateKeys() 获取自动生成的 id;
	 *		(3)：ps.getGeneratedkeys() 返回值是ResultSet对象，是一行多列的结果，每个结果对应一个id;
	 *		(4)：使用while（rs.next()）处理结果，必须使用列号获取结果！
	 */
	public static void getGeneratedKeys(){
		String sql1 = "insert into mqf_dept (deptno,dname,loc) values (mqf_dept_seq.nextval,?,?)";
		String sql2 = "insert into mqf_emp (empno,ename,job,hiredate,salary,deptno) values (mqf_emp_seq.nextVal,?,?,?,?,?)";

		Connection conn = null;
		try {
			conn = c3p0.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql1, new String[]{"deptno"});
			ps.setString(1, "PHP");
			ps.setString(2, "bj");
			int n = ps.executeUpdate();
			if(n!=1){
				throw new SQLException();
			}
			ResultSet rs = ps.getGeneratedKeys();
			int deptno = -1;
			while(rs.next()){
				deptno = rs.getInt(1);//此处必须使用序列号
			}
			//打桩
			System.out.println("deptno:"+deptno);
			ps = conn.prepareStatement(sql2);
			ps.setString(1, "fan");
			ps.setString(2, "牙");
			ps.setDate(3, new Date(System.currentTimeMillis()));
			ps.setDouble(4, 200.5);
			ps.setInt(5, deptno);
			n = ps.executeUpdate();
			if(n!=1){
				throw new SQLException();
			}
			ps.close();
			rs.close();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			c3p0.rollback(conn);
		}finally{
			c3p0.close(conn);
		}
	}
}
