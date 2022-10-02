package com.mcq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DbOperation {
	
	ConnectionPool connectionpool=new ConnectionPool();
	PreparedStatement ps;
	Connection con;
	
	//Method for Insert the questions
	public void insertQuestions(Map<Question,Character> hmap) throws SQLException {
		try {
			
			//call the connectionpool method by connection pool object
			con=connectionpool.getConnection();
			
			//foreach loop to iterate for inserting the question
			for(Map.Entry<Question, Character> it:hmap.entrySet())
					{
				//prepare statement
				ps=con.prepareStatement("insert into questions(Question,Characters)values(?,?)");
				
		
				//add query by using prepared statement object
				ps.setObject(1, it.getKey().getQuestion());
				ps.setLong(2, it.getValue());
				
				//executeupdate
				int i=ps.executeUpdate();
				
				//get insertion successful message for question insertion operation
				//System.out.println("Insertion is successfully..."+i);
				
		}
		}catch(Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}finally {
		con.close();
		ps.close();
	}
	}


	//To get all data from table
	public void retrieveStudentdata() throws SQLException {
		try {
		con=connectionpool.getConnection();
		
		//prepared statement object storing the query to retrieve data
		ps=con.prepareStatement("select * from student order by studentname asc");
		
		  System.out.println("Student ID: " + "\t" + "Student name" +"\t"+"Student score");
		
		//executeQuery for retrieve data
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			int sc=+rs.getInt(3);
			  System.out.println(id + "\t\t" + name+"\t\t"+sc); //Print the data in new tab
		}
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}finally {
		con.close();
		ps.close();
	}
	}
	
	//to retrieve the particular student record by id
	public void retriveByID(int studentid) throws SQLException {
		try {
			con=connectionpool.getConnection();
			ps=con.prepareStatement("select * from student where studentid=? order by studentname asc");
			
			System.out.println("Student ID: " + "\t" + "Student name" +"\t"+"Student score");
			
			ps.setInt(1, studentid);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int sc=rs.getInt(3);
				
				 System.out.println(id + "\t\t" + name+"\t\t"+sc);
			}
		
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			con.close();
			ps.close();
		}
	}
	
	//method for Insert the student name , id & score
	public void insertStudentdata(int studentid,String studentname,int score) throws SQLException {
		try {
			con=connectionpool.getConnection();
			
			//Insert query by prepared statement & stored into prepared statement object
			ps=con.prepareStatement("insert into student(studentid,studentname,score)values(?,?,?)");
			
			ps.setInt(1, studentid);
			ps.setString(2, studentname);
			ps.setInt(3, score);
			
			
			int i=ps.executeUpdate();
			
			//insertion successful msg after student record insert operation
			//System.out.println("Student details inserted successfully: "+i);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			con.close();
			ps.close();
		}
		
	}


	
}
	

