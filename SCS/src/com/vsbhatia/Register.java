package com.vsbhatia;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			res.setContentType("text/html");
			String fname = req.getParameter("fname");
			String lname= req.getParameter("lname");
			String email= req.getParameter("mail");
			String username= req.getParameter("uname");
			String password = req.getParameter("pwd");
			
			String q1 = "select * from user";
			String query = "INSERT into `user` values (?,?,?,?,?)";		//registration is a name of the Table.
			
			String url = "jdbc:mysql://localhost:3306/couriersystem";	//couriersystem is a DataBase Name.
			String uname = "vsbhatia";									//username of User of the DataBase.
			String pass = "root";									//password of User of the DataBase.
			Connection con = DriverManager.getConnection(url, uname, pass);

//			PreparedStatement s =con.prepareStatement(q1);
//			ResultSet rs = ((PreparedStatement) s).executeQuery();

			java.sql.Statement s = con.createStatement();
		
			ResultSet rs = s.executeQuery(q1);
			rs.next();
			String dbname = null;
			String dbmail = null;
			while(rs.next()) {
				dbname = rs.getString(4);
				dbmail = rs.getString(3);
			}
			PrintWriter out = res.getWriter();
			if(dbmail.equals(email)) {
				out.println("this email is already registered!");
			}
			if(username.equals(dbname)) {
				out.println("this username is already registered!");
				
			}
			else {
			
			HttpSession ssn = req.getSession();
			ssn.setAttribute("user", username);
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, username);
			ps.setString(5, password);
			int rc = ps.executeUpdate();
			

			out.println("you have successfully registered!");
			out.println("<html><body><form action='addItem.jsp'>");
			out.println("<input type='submit' value='Add Item'></form></body></html>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
		

}
