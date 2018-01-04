package com.accolite.au;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MyConnection {
	Connection con;
	private static volatile MyConnection conVar;
	
	private MyConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/au","root","root");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MyConnection getConnection() {
		if(conVar == null) {
			synchronized (MyConnection.class) {
				if(conVar == null) {
					conVar = new MyConnection();
				}
			}
		}
		try {
			if(conVar.con.isClosed()) {
				synchronized (MyConnection.class) {
					if(conVar.con.isClosed()) {
						conVar.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/au","root","root");
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conVar;
	}
}
