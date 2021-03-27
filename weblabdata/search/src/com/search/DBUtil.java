package com.search;
import java.sql.*;
public class DBUtil {
	public static Connection getMySqlConnection()throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/labexam", "root", "sinopesa");
		return con;
	}
	public static void cleanup(Connection con,PreparedStatement pst){
		try{
			if(pst!=null){
				pst.close();
			}
			if(con!=null){
				con.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
