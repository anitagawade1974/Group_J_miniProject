package com.mcq;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPool {

	Connection connection;
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root","root");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return connection;
		

	}

}
