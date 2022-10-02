package com.mcq;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) throws SQLException, InterruptedException {
		
		//Scanner for user input to continue test or find particular data by id
		Scanner sc=new Scanner(System.in);
		Exam exam = new Exam();  //object of exam class to call the method of exam class
		char ch;   //character variable to store the user input
		
		//for exam iteration
		do {

		Thread.sleep(5000);
		exam.takeTest();
		
		System.out.println("\nDo you want to start the test again?.......If yes press 'Y' or 'y'");
		System.out.println("If you want to exit the test.......press 'N' or 'n'");

		ch=sc.next().charAt(0);
		
		}while(ch=='Y'||ch=='y');
		System.out.println("\nThank you! your test is submitted\n");
		System.out.println("All students Records: ");
		
		DbOperation obj=new DbOperation();
		obj.retrieveStudentdata();
		
		
		//iteration for retrieving particular student data by id
		do {

			Thread.sleep(5000);
			//exam.takeTest();
			
			System.out.println("\nDo you want to find the student record.......If yes press 'Y' or 'y'");
			ch=sc.next().charAt(0);
			System.out.println("Enter the Student ID: ");
			int id=sc.nextInt();
			obj.retriveByID(id);
			
			System.out.println("If you want to continue press ....'Y' or 'y' else.......press 'N' or 'n'");
			ch=sc.next().charAt(0);
			
			}while(ch=='Y'||ch=='y');
			System.out.println("\nThank you!\n");
		
	}
	}
	


