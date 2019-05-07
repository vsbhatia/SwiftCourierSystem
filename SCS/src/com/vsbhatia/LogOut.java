package com.vsbhatia;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession ssn = req.getSession();
		ssn.removeAttribute("user");
		ssn.invalidate();
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, res);
		
	}
}
