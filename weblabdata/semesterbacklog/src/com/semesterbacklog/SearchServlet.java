package com.semesterbacklog;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SearchServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String Semester1;
		String Semester2;
		String Semester3;
		String Semester4;
		
		RegisterModel rm=new RegisterModel();
		
		Semester1=request.getParameter("sem1");
		Semester2=request.getParameter("sem2");
		Semester3=request.getParameter("sem3");
		Semester4=request.getParameter("sem4");
		
		
		RequestDispatcher rd=null;
		
		ArrayList<String> al=rm.search(Semester1,Semester2,Semester3,Semester4);
		//ArrayList<ArrayList<String>> al = rm.search(pname);
		request.setAttribute("PROD_DETAILS", al);
	if(al!=null){
			
			rd=request.getRequestDispatcher("/product_details2.jsp");
		}
		else{
			
			rd=request.getRequestDispatcher("/login_fail.html");
			
		}
		rd.forward(request, response);
		
	}
}
