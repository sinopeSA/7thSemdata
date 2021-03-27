package com.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.login.DBUtil;
public class RegisterModel {
	
public String login(String uname){
	
	Connection con=null;
	PreparedStatement ps=null;
	String pword=null;
	try{
		con=DBUtil.getMySqlConnection();
		ps=con.prepareStatement("select password from user where emailid=?");
		ps.setString(1,uname);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			 pword=rs.getString(1);			
		}
		rs.close();
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	return pword;
}

}
