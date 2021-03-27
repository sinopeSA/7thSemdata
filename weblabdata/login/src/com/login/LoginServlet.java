package com.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String username, password;
		
		RegisterModel rm=new RegisterModel();
		
		username=request.getParameter("uname");
		password=request.getParameter("pword");
		
		
		
		String pw=rm.login(username);
		
		RequestDispatcher rd=null;
		if(pw.equals(password)){
			
			rd=request.getRequestDispatcher("/loginSuccess.html");
		}
		else{
			
			rd=request.getRequestDispatcher("/login_fail.html");
			
		}
		rd.forward(request, response);
		
	}
}