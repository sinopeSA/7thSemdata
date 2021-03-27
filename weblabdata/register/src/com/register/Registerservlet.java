package com.register;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Registerservlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException 
	{	
		RegisterModel rm = new RegisterModel();
		int x =0;
		String fname,emailid,contact,City,State,Zipcode,quali,gender,pword;
		fname= request.getParameter("fname");
		contact= request.getParameter("number");
		City= request.getParameter("city");
		State= request.getParameter("state");
		Zipcode= request.getParameter("zipcode");
		gender= request.getParameter("gender");
		quali= request.getParameter("quali");
		emailid= request.getParameter("email");
		pword= request.getParameter("pword");
		
		RequestDispatcher rd=null;
		x= rm.register(fname,contact,City,State,Zipcode,gender,quali,emailid,pword);
		if(x==1){
			rd=request.getRequestDispatcher("/registrationsuccess.html");
		}
		else{
			rd=request.getRequestDispatcher("/registration_fail.html");		
		}
		rd.forward(request, response);
	}
}
