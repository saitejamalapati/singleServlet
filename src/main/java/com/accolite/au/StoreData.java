package com.accolite.au;

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoreData extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  try {
			  String name = req.getParameter("name");
		      String email = req.getParameter("email");
		      System.out.println("Name: "+name+"Email: "+email);
		      MyConnection var = MyConnection.getConnection();
		      String query = new String("insert into servlet_streams_exercises values('" + name + "','" + email + "')");
	    	  Statement stmt = var.con.createStatement();
		      stmt.executeUpdate(query);
	    	  var.con.close();
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  try {
			  String name = req.getParameter("name");
		      String email = req.getParameter("email");
		      System.out.println("Name: "+name+"Email: "+email);
		      MyConnection var = MyConnection.getConnection();
		      String query = new String("insert into servlet_streams_exercises values('" + name + "','" + email + "')");
	    	  Statement stmt = var.con.createStatement();
		      stmt.executeUpdate(query);
	    	  var.con.close();
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	  }
}
