package com.mcq;

public class Student extends Main{
	private int studentid;
	private String studentname;

	public Student(int studentid, String studentname) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentname=" + studentname +  "]";
	}
	
}
