package com.semesterbacklog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

import com.semesterbacklog.DBUtil;
public class RegisterModel {
public ArrayList<String> search(String Semester1, String Semester2,String Semester3,String Semester4 ){
	Connection con=null;
	PreparedStatement ps=null;
	ArrayList<String> al =new ArrayList();
	//ArrayList<ArrayList<String> > al = new ArrayList<ArrayList<String> >(); 
	try{
		con=DBUtil.getMySqlConnection();
		ps=con.prepareStatement("select * from student where ((sem1 = ?) OR (sem2 =?) OR (sem3 =?) OR (sem4 =?))");
		ps.setString(1,Semester1);
		ps.setString(2,Semester2);
		ps.setString(3,Semester3);
		ps.setString(4,Semester4);
		ResultSet rs1=ps.executeQuery();
		while(rs1.next()){
			al.add(rs1.getString(1));
			al.add(rs1.getString(2));
			al.add(rs1.getString(3));
			al.add(rs1.getString(4));
			al.add(rs1.getString(5));
			al.add(rs1.getString(6));
			
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
