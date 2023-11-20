package com.superman.ex;

import java.io.Serializable;

public class StudentBean implements Serializable{
	private String name;
	private int age;
	private int grade;
	private String studentNum;
	public StudentBean(String name, int age, int grade, String studentNum) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.studentNum = studentNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	
}
