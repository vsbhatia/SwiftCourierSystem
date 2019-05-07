package com.vsbhatia;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
@WebServlet("/AddItem")
public class AddItem extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/couriersystem","vsbhatia","27618349");
			int type = Integer.parseInt(req.getParameter("type"));
			int weight = Integer.parseInt(req.getParameter("wgt"));
			
			String query= "INSERT into `item` (type,weight) values (?,?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			ps.setInt(1, type);
			ps.setInt(2, weight);
			ps.executeUpdate();
			System.out.println("item added:");
		
		  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
