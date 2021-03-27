package com.autoorder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

import com.autoorder.DBUtil;
public class RegisterModel {
public ArrayList<String> search(String Date){
	Connection con=null;
	PreparedStatement ps=null;
	ArrayList<String> al =new ArrayList();
	//ArrayList<ArrayList<String> > al = new ArrayList<ArrayList<String> >(); 
	try{
		con=DBUtil.getMySqlConnection();
		ps=con.prepareStatement("select orderDate from autoorder order by orderId desc limit 1");
		ResultSet rs2=ps.executeQuery();
		while(rs2.next()){
			Date = rs2.getString(1);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(Date));
		c.add(Calendar.DATE, 30);  // number of days to add
		Date = sdf.format(c.getTime());
		Date.toString();
		ps=con.prepareStatement("insert into autoorder(orderDate) values(?)");
		ps.setString(1,Date);
		int rs0=ps.executeUpdate();
		ps=con.prepareStatement("select orderDate from autoorder order by orderId desc limit 1");
		ResultSet rs1=ps.executeQuery();
		while(rs1.next()){
			al.add(rs1.getString(1));
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
