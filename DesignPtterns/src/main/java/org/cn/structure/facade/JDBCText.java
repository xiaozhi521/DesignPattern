package org.cn.structure.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCText {
	public static void main(String[] args) {	
		
		if(DBCP.login1("KING", " 1' or '1' = '1")){
			System.out.println("1111111");
		}else{
			System.out.println("22222");
		}
		if(c3p0.login1("KING", "1' or '1' = '1")){
			System.out.println("1111111");
		}else{
			System.out.println("22222");
		}
		if(c3p0.login2("KING", "10")){
			System.out.println("1111111");
		}else{
			System.out.println("22222");
		}
		
		String sql = "Update mqf_account set balance = balance -10  where id = 10";
		String sql1 = "select balance from mqf_account where id = 10";
		c3p0.BalanceCount(sql,sql1);
		
		c3p0.getGeneratedKeys();
		
	}
	
}
