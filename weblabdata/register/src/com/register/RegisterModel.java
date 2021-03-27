package com.register;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.register.DBUtil;
public class RegisterModel {
	
public int register(String fname,String contact,String City, String State,String Zipcode,String gender,String quali,String emailid,String pword){
	PreparedStatement stmt=null;

		int x=0;
		Connection con=null;
		try{
			con=DBUtil.getMySqlConnection();	
			stmt=con.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?)");  
			stmt.setString(1, fname);
			stmt.setString(2, contact);
			stmt.setString(3, City);
			stmt.setString(4, State);
			stmt.setString(5, Zipcode);
			stmt.setString(6, gender);
			stmt.setString(7, quali);
			stmt.setString(8, emailid);
			stmt.setString(9, pword);
			
			x=stmt.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				DBUtil.cleanup(con,stmt);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return x;
	}

}
