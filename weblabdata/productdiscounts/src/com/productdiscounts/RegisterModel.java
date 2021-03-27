package com.productdiscounts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

import com.productdiscounts.DBUtil;
public class RegisterModel {
public ArrayList<String> search(String pname){
	Connection con=null;
	PreparedStatement ps=null;
	ArrayList<String> al =new ArrayList();
	try{
		con=DBUtil.getMySqlConnection();
		ps=con.prepareStatement("select * from productdesc where discounts >= ? ");
		ps.setString(1,pname);
		ResultSet rs1=ps.executeQuery();
		while(rs1.next()){
			al.add(rs1.getString(1));
			al.add(rs1.getString(2));
			al.add(rs1.getString(3));
			al.add(rs1.getString(4));
		}
		rs1.close();
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
	return al;
}
}
