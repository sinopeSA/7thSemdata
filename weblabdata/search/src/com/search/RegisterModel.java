package com.search;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

import com.search.DBUtil;
public class RegisterModel {
public ArrayList<String> search(String pname ,String hname){
	Connection con=null;
	PreparedStatement ps=null;
	ArrayList<String> al =new ArrayList();
	//ArrayList<ArrayList<String> > al = new ArrayList<ArrayList<String> >(); 
	try{
		con=DBUtil.getMySqlConnection();
		ps=con.prepareStatement("select * from hotel where (hotelname = ? and hoteltype = ? )");
		ps.setString(1,pname);
		ps.setString(2,hname);
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
