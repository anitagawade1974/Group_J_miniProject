package com.mcq;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam{

	//Scanner class to take user input for student data
	Scanner sc=new Scanner(System.in);
	
	//object of DbOperation class to call the methods of different queries
	DbOperation obj2=new DbOperation();
	
	//Online Test method 
	public void takeTest() throws SQLException{
		
	int score=0;
	int wronganswer=0;

	//All questions are inserted by Question class Constuctor
	Question q1=new Question("Select the valid statement.","A. char ch[] = new char(5)","B. char ch[] = new char[5]","C. char ch[] = new char()","D. char ch[] = new char[]");
	Question q2=new Question("Which of the following class is the superclass of String and StringBuffer class?","A. ArrayList","B. java.util","C. java.lang","D. java.string");
	Question q3=new Question("String in Java is a _________?","A. object","B. class","C. reference","D. array of character");
	Question q4=new Question("Which of the following method is used to get the length of a String object?","A. getSize() ","B. Sizeof()","C. len()","D. length()");
	Question q5=new Question("What does the expression float a = 35 / 0 return?","A. 0","B. Not a Number","C. Infinity","D. Run time exception");
	Question q6=new Question("Which of the following is not a Java features?","A. Dynamic","B. Architecture Neutral","C. Use of pointers","D. Object-oriented");
	Question q7=new Question("In which process, a local variable has the same name as one of the instance variables?","A. Serialization","B. Variable Shadowing","C. Abstraction","D. Multi-threading");
	Question q8=new Question("_____ is used to find and fix bugs in the Java programs.","A. JVM","B. JRE","C. JDK","D. JDB");
	Question q9=new Question("Which package contains the Random class?","A. java.util package","B. java.lang package","C. java.awt package","D. java.io package");
	Question q10=new Question("An interface with no fields or methods is known as a ______.","A. Runnable Interface","B. Marker Interface","C. Abstract Interface","D. CharSequence Interface");
	
	
	//Storing the quetions & correct answers into map
			Map<Question,Character> hmap=new HashMap<>();
			hmap.put(q1,'B');
			hmap.put(q2,'D');
			hmap.put(q3,'B');
			hmap.put(q4,'D');
			hmap.put(q5,'C');
			hmap.put(q6,'C');
			hmap.put(q7,'B');
			hmap.put(q8,'A');
			hmap.put(q9,'A');
			hmap.put(q10,'B');
			
			//passing the map values to insert method...where database connect & queries added
			obj2.insertQuestions(hmap);
			
			//Enter student data..............
			int studentid=0;
			System.out.println("Enter the Student ID: ");
			try {
			studentid=sc.nextInt();
			}catch(Exception e)
			{
				//e.printStackTrace();
				System.out.println("Incorrect Student ID");
				System.out.println("Please start again...");
				System.exit(studentid);
			}
			
			System.out.println("Enter the Student full name: ");
			String studentname=sc.next();
			
		//Printing statements for Warm welcome & note		
		System.out.println("\n");
		System.out.println("!!!Welcome to Java Online Test!!!\n");
		System.out.println("NOTE: Ansewer will be accepted in Capital letters only like (A,B,C,D)-------");
		System.out.println("Your Test is Started....All the Best!!!\n");
		
		//foreach loop to iterate the questions stored in map
		for(Map.Entry<Question, Character> map: hmap.entrySet()){
			System.out.println(map.getKey().getQuestion());
			System.out.println(map.getKey().getOption1());
			System.out.println(map.getKey().getOption2());
			System.out.println(map.getKey().getOption3());
			System.out.println(map.getKey().getOption4());
	
			System.out.println("\nEnter the Answer: ");
			char answer=sc.next().charAt(0);
			System.out.println("\n");
	//checking the correct answer & counting the score
	int correctanswer=Character.compare(answer, map.getValue());		
	if(correctanswer==0) {
		//System.out.println("Correct Answer");
		score++;
	}else {
		//System.out.println("Wrong Answer");
		wronganswer++;
		}

		}
		
	//Display the Result
	System.out.println("Result: ");
	System.out.println("Correct Answers: "+score);
	System.out.println("Wrong Answers: "+wronganswer);
	System.out.println("Score is "+score+"/"+hmap.size());
	
	//Print the Grade
	if(score>8 || score < 10) {
		System.out.println("Grade is: A");
	}else if(score>6 || score < 8) {
		System.out.println("Grade is B");
	}else if(score==5) {
		System.out.println("Grade is C");
	}else {
	System.out.println("Grade is D");
		}
	
	//Insert the student data into table
	obj2.insertStudentdata(studentid,studentname,score);
	
	}
	
}

