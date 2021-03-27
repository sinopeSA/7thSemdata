package com.search;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SearchServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String pname;
		String hname;
		
		RegisterModel rm=new RegisterModel();
		
		pname=request.getParameter("search");
		hname=request.getParameter("hoteltype");
		
		RequestDispatcher rd=null;
		
		ArrayList<String> al=rm.search(pname,hname);
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
