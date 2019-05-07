package com.vsbhatia;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginValidate")
public class LoginValidate extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			res.setContentType("text/html");
			String name = req.getParameter("uname");
			String pass = req.getParameter("pwd");
			
			String dbName = null;
			String dbPass = null;
			
			String query = "select * from user where username=? and password=?";
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/couriersystem","vsbhatia","root");
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery(); 		//executeQuery used for the SELECT query syntax of SQL.
			
			while(rs.next()) {
				dbName = rs.getString(4);
				dbPass = rs.getString(5);
			}
			
			PrintWriter out = res.getWriter();
			if(name.equals(dbName) && pass.equals(dbPass)) {

				
				HttpSession ssn = req.getSession();
				ssn.setAttribute("user", name);
				RequestDispatcher rd = req.getRequestDispatcher("loggedin.jsp");
				rd.forward(req, res);
				
//				out.println("<html><body><form action='addItem.jsp'>");
//				out.println("<input type='submit' value='Add Item'></form></body></html>");
//				
//				out.println("<html><body><form action='logout' method='post'>");
//				out.println("<input type='submit' name='submit' value='logout'></form></body></html>");
			}
			else {
				out.println("The data you have entered is incorrect !");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
